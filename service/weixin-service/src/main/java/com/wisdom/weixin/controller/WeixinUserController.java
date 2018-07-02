package com.wisdom.weixin.controller;

import com.wisdom.common.constant.ConfigConstant;
import com.wisdom.common.constant.StatusConstant;
import com.wisdom.common.dto.account.AccountDTO;
import com.wisdom.common.dto.system.ResponseDTO;
import com.wisdom.common.dto.user.UserInfoDTO;
import com.wisdom.common.dto.wexin.WeixinConfigDTO;
import com.wisdom.common.dto.wexin.WeixinShareDTO;
import com.wisdom.common.dto.wexin.WeixinTokenDTO;
import com.wisdom.common.entity.WeixinUserBean;
import com.wisdom.common.util.*;
import com.wisdom.weixin.client.BusinessServiceClient;
import com.wisdom.weixin.client.UserServiceClient;
import com.wisdom.weixin.interceptor.LoginRequired;
import com.wisdom.weixin.service.user.WeixinUserCoreService;
import com.wisdom.weixin.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.krb5.Config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by chenjiake on 17/11/4.
 * 负责响应微商平台用户端微信公众平台的请求
 *
 */

@Controller
@RequestMapping(value = "customer")
public class WeixinUserController {

    @Autowired
    private WeixinUserCoreService weixinCustomerCoreService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private BusinessServiceClient businessServiceClient;

    @Autowired
    private UserServiceClient userServiceClient;


    /**
     * *用户校验是否是微信服务器发送的请求
     * */
    @RequestMapping(value = "requestFromServer", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String requestFromServer(HttpServletRequest request, HttpServletResponse response) {
          String method = request.getMethod().toUpperCase();
          if ("GET".equals(method)) {
              // 微信加密签名
              String signature = request.getParameter("signature");
              // 时间戳
              String timestamp = request.getParameter("timestamp");
              // 随机数
              String nonce = request.getParameter("nonce");
              // 随机字符串
              String echostr = request.getParameter("echostr");

              // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
              if (SignUtil.checkCustomerSignature(signature, timestamp, nonce)) {
                return echostr;
              }
              return "";
          } else {
              // 调用核心业务类接收消息、处理消息
              String respMessage = null;
              try {
                  respMessage = weixinCustomerCoreService.processCustomerWeixinRequest(request,response);
              } catch (IOException e) {
                  e.printStackTrace();
              }
              return respMessage;
          }
      }

    /**
     * 公众号菜单引导页 081dazSU0Zf1iU1fGISU0q5ASU0dazSd 0815XmM70lSlvH1UnyN70OwBM705XmM9
     */
    @RequestMapping(value = "getUserWeixinMenuId", method = {RequestMethod.POST, RequestMethod.GET})
    public String getUserWeixinMenuId(HttpServletRequest request,
                                          HttpServletResponse response,
                                          HttpSession session) throws Exception
    {
        String url = java.net.URLDecoder.decode(request.getParameter("url"), "utf-8");

        if ("shopHome".equals(url)) {
            url = ConfigConstant.USER_WEB_URL + "shopHome";
        }
        if (url.contains("specialProductList")) {
            String urls[] = url.split("88888888");
            String specialShopId = urls[1];
            url = ConfigConstant.USER_WEB_URL + "specialProductList/" + specialShopId;
        }
        else if ("shareHome".equals(url)) {
            url = ConfigConstant.USER_WEB_URL + "shareHome";
        }
        else if ("trainingHome".equals(url)) {
            url = ConfigConstant.USER_WEB_URL + "trainingHome";
        }
        else if ("myselfCenter".equals(url)) {
            url = ConfigConstant.USER_WEB_URL + "myselfCenter";
        }

        String code = request.getParameter("code");
        String get_access_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                "appid="+ ConfigConstant.USER_CORPID +
                "&secret=" + ConfigConstant.USER_SECRET +
                "&code="+ code +
                "&grant_type=authorization_code";
        WeixinUserBean weixinUserBean;
        int countNum = 0;
        do {
            String json = HttpRequestUtil.getConnectionResult(get_access_token_url, "GET", "");
            weixinUserBean = JsonUtil.getObjFromJsonStr(json, WeixinUserBean.class);
            if (countNum++ > 3) {
                break;
            }
        } while (weixinUserBean.getOpenid() == null);

        String openId = weixinUserBean.getOpenid();
        session.setAttribute(ConfigConstant.USER_OPEN_ID, openId);
        CookieUtils.setCookie(response, ConfigConstant.USER_OPEN_ID, openId==null?"":openId,60*60*24*30,ConfigConstant.DOMAIN_VALUE);

        return "redirect:" + url;
    }


    /**
     * 用户端微信JS-SDK获得初始化参数
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getConfig", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseDTO<WeixinConfigDTO> getConfig(HttpServletRequest request) throws Exception
    {
        ResponseDTO<WeixinConfigDTO> responseDTO = new ResponseDTO<>();
        String u = request.getParameter("url");
        Query query = new Query(Criteria.where("weixinFlag").is(ConfigConstant.weixinUserFlag));
        WeixinTokenDTO weixinTokenDTO = mongoTemplate.findOne(query,WeixinTokenDTO.class,"weixinParameter");
        String ticket = weixinTokenDTO.getTicket();
        WeixinConfigDTO WeixinConfigDTO = JsApiTicketUtil.customerSign(ticket, u);
        responseDTO.setResponseData(WeixinConfigDTO);
        return responseDTO;
    }

    /**
     * 验证主入口
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/fieldwork/author", method = RequestMethod.GET)
    public String Oauth2API(HttpServletRequest request) {
        String backUrl = request.getParameter("url");
        String oauth2Url = WeixinUtil.getUserOauth2Url(backUrl);
        return "redirect:" + oauth2Url;
    }

    /**
     * 用户获取推广二维码
     */
    @RequestMapping(value = "getUserQRCode", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<WeixinShareDTO> getUserQRCode() throws FileNotFoundException {
        ResponseDTO<WeixinShareDTO> responseDTO = new ResponseDTO();

        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();
        WeixinShareDTO weixinShareDTO = weixinCustomerCoreService.getWeixinShareInfo(userInfoDTO);
        if(weixinShareDTO==null)
        {
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        else
        {
            AccountDTO accountDTO = businessServiceClient.getUserAccountInfo(weixinShareDTO.getSysUserId());
            String instanceMoney = businessServiceClient.selectIncomeInstanceByUserId(userInfoDTO.getId());
            List<UserInfoDTO> userInfoDTOList = userServiceClient.queryNextUserByUserId(userInfoDTO.getId());
            float balance = accountDTO.getBalance();
            weixinShareDTO.setIstanceMoney(instanceMoney);
            weixinShareDTO.setPeoperCount(userInfoDTOList.size());
            weixinShareDTO.setBalance(String.valueOf(balance));
            weixinShareDTO.setUserType(userInfoDTO.getUserType());
            responseDTO.setResult(StatusConstant.SUCCESS);
            responseDTO.setResponseData(weixinShareDTO);
        }
        return responseDTO;
    }

    @RequestMapping(value = "getSpecialShopQRCode", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<String> getSpecialShopQRCode(@RequestParam String specialShopId) throws FileNotFoundException {
        ResponseDTO<String> responseDTO = new ResponseDTO();
        String specialShopQRURL = weixinCustomerCoreService.getSpecialShopQRCode(specialShopId);
        responseDTO.setResult(StatusConstant.SUCCESS);
        responseDTO.setResponseData(specialShopQRURL);
        return responseDTO;
    }




}
