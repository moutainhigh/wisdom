package com.wisdom.weixin.service.user;


import com.wisdom.common.constant.ConfigConstant;
import com.wisdom.common.dto.wexin.WeixinTokenDTO;
import com.wisdom.common.entity.Article;
import com.wisdom.common.entity.ReceiveXmlEntity;
import com.wisdom.common.util.StringUtils;
import com.wisdom.common.util.WeixinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chenjiake on 2017/9/11.
 */
@Service
@Transactional(readOnly = false)
public class ProcessUserScanEventService {

    @Autowired
    private MongoTemplate mongoTemplate;

    private static ExecutorService threadExecutorCached = Executors.newCachedThreadPool();

    public void processUserScanEvent(ReceiveXmlEntity xmlEntity)
    {
        Query query = new Query(Criteria.where("weixinFlag").is(ConfigConstant.weixinUserFlag));
        WeixinTokenDTO weixinTokenDTO = this.mongoTemplate.findOne(query,WeixinTokenDTO.class,"weixinParameter");
        String token = weixinTokenDTO.getToken();

        //开启线程，给关注的用户推送微信消息
        Runnable sendSubscribeMessageThread = new SendScanMessageThread(token, xmlEntity);
        threadExecutorCached.execute(sendSubscribeMessageThread);
    }

    private class SendScanMessageThread extends Thread {
        private String token;
        private ReceiveXmlEntity xmlEntity;

        public SendScanMessageThread(String token, ReceiveXmlEntity xmlEntity) {
            this.token = token;
            this.xmlEntity = xmlEntity;
        }

        @Override
        public void run() {

            if(StringUtils.isNotNull(xmlEntity.getEventKey())&&xmlEntity.getEventKey().indexOf("mxForeignPurchase")!=-1)
            {
                //处理境外购的流程
                String weishiyiShop = xmlEntity.getEventKey().replace("mxForeignPurchase_", "");
                String codeArray[] = weishiyiShop.split("_");
                String weishiyiShopId = codeArray[1];

                //通过shopId查询出店铺名称

                //处理境外购的流程
                List<Article> articleList = new ArrayList<>();
                Article article = new Article();
                article.setTitle("嗨!您终于来啦! ~\n");
                article.setDescription(
                        "请点击我进入唯十一店吧");
                article.setPicUrl("");
                article.setUrl("www.sina.com.cn");
                articleList.add(article);
                WeixinUtil.senImgMsgToWeixin(token,xmlEntity.getFromUserName(),articleList);
            }
            else
            {
                //判断用户所扫描的二维码是否是A店或者B店的二维码
                String businessParentPhone = "";
                if(StringUtils.isNotNull(xmlEntity.getEventKey())){
                    //todo 此处要考虑，未来完善，不仅仅只有mxbusinessshare_一种类型的扩展二维码
                    businessParentPhone = xmlEntity.getEventKey().replace("mxbusinessshare_", "");
                    String codeArray[] = businessParentPhone.split("_");
                    businessParentPhone = codeArray[0];
                }

                List<Article> articleList = new ArrayList<>();
                Article article = new Article();
                article.setTitle("欢迎再次光临! \n");
                article.setDescription("我们是美享商城，在这里，将会为您实时传递最好的美享服务。");
                article.setPicUrl("");
                article.setUrl("");
                articleList.add(article);
                WeixinUtil.senImgMsgToWeixin(token,xmlEntity.getFromUserName(),articleList);
            }
        }
    }

}
