package com.wisdom.beauty.core.service.impl;

import com.aliyun.oss.ServiceException;
import com.wisdom.beauty.api.dto.ShopUserConsumeRecordCriteria;
import com.wisdom.beauty.api.dto.ShopUserConsumeRecordDTO;
import com.wisdom.beauty.api.enums.ConsumeTypeEnum;
import com.wisdom.beauty.api.responseDto.UserConsumeRecordResponseDTO;
import com.wisdom.beauty.core.mapper.ShopUserConsumeRecordMapper;
import com.wisdom.beauty.core.service.ShopUerConsumeRecordService;
import com.wisdom.common.dto.account.PageParamVoDTO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * ClassName: ShopUerConsumeRecordServiceImpl
 *
 * @Author： huan
 * @Description:
 * @Date:Created in 2018/4/8 18:23
 * @since JDK 1.8
 */
@Service("shopUerConsumeRecordService")
public class ShopUerConsumeRecordServiceImpl implements ShopUerConsumeRecordService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ShopUserConsumeRecordMapper shopUserConsumeRecordMapper;

    @Override
    public List<UserConsumeRecordResponseDTO> getShopCustomerConsumeRecordList(PageParamVoDTO<ShopUserConsumeRecordDTO> pageParamVoDTO) {
        ShopUserConsumeRecordDTO shopUserConsumeRecordDTO = pageParamVoDTO.getRequestData();
        logger.info("getShopCustomerConsumeRecordList方法传入的参数,SysShopId={},ShopUserId={},Status={}", shopUserConsumeRecordDTO.getSysShopId(), shopUserConsumeRecordDTO.getShopUserId(), shopUserConsumeRecordDTO.getStatus());
        if (StringUtils.isBlank(shopUserConsumeRecordDTO.getSysShopId()) ||
                StringUtils.isBlank(shopUserConsumeRecordDTO.getShopUserId()) ||
                StringUtils.isBlank(shopUserConsumeRecordDTO.getConsumeType())) {
            throw new ServiceException("getShopCustomerConsumeRecordList方法传入的参数为空");
        }
        ShopUserConsumeRecordCriteria criteria = new ShopUserConsumeRecordCriteria();
        ShopUserConsumeRecordCriteria.Criteria c = criteria.createCriteria();
        //去重
        // criteria.setGroupBy("consume_flow_no");
        // 排序
        criteria.setOrderByClause("create_date");
        // 分页
        criteria.setLimitStart(pageParamVoDTO.getPageNo());
        criteria.setPageSize(pageParamVoDTO.getPageSize());

        c.andSysShopIdEqualTo(shopUserConsumeRecordDTO.getSysShopId());
        c.andShopUserIdEqualTo(shopUserConsumeRecordDTO.getShopUserId());

        if (ConsumeTypeEnum.CONSUME.getCode().equals(shopUserConsumeRecordDTO.getStatus())) {
            c.andConsumeTypeEqualTo(shopUserConsumeRecordDTO.getStatus());
        } else {
            List<String> values = new ArrayList<>();
            values.add(ConsumeTypeEnum.CONSUME.getCode());
            c.andConsumeTypeNotIn(values);
        }
        List<ShopUserConsumeRecordDTO> list = shopUserConsumeRecordMapper.selectByCriteria(criteria);
        Map<String, UserConsumeRecordResponseDTO> map = new HashMap<>(16);
        UserConsumeRecordResponseDTO userConsumeRecordResponseDTO = new UserConsumeRecordResponseDTO();
        for (ShopUserConsumeRecordDTO shopUserConsumeRecord : list) {
            if (map.get(shopUserConsumeRecord.getFlowNo()) == null) {
                userConsumeRecordResponseDTO.setSumAmount(shopUserConsumeRecord.getPrice());
                userConsumeRecordResponseDTO.setCreateDate(shopUserConsumeRecord.getCreateDate());
                if (ConsumeTypeEnum.CONSUME.getCode().equals(shopUserConsumeRecord.getStatus())) {
                    userConsumeRecordResponseDTO.setTitle(shopUserConsumeRecord.getFlowName());
                } else {
                    userConsumeRecordResponseDTO.setTitle(shopUserConsumeRecord.getConsumeType());
                }
                map.put(shopUserConsumeRecord.getFlowNo(), userConsumeRecordResponseDTO);
            } else {
                UserConsumeRecordResponseDTO userConsumeRecordResponseMap = map.get(shopUserConsumeRecord.getFlowNo());
                Long prices = shopUserConsumeRecord.getPrice() + userConsumeRecordResponseMap.getSumAmount();
                userConsumeRecordResponseMap.setSumAmount(prices);
                map.put(shopUserConsumeRecord.getFlowNo(), userConsumeRecordResponseMap);
            }
        }
        List values = Arrays.asList(map.values().toArray());
        return values;
    }

    @Override
    public UserConsumeRecordResponseDTO getShopCustomerConsumeRecord(String consumeFlowNo) {
        logger.info("getShopCustomerConsumeRecordList方法传入的参数,consumeFlowNo={}}", consumeFlowNo);
        if (StringUtils.isBlank(consumeFlowNo)) {
            throw new ServiceException("getShopCustomerConsumeRecordList方法传入的参数为空");
        }
        ShopUserConsumeRecordCriteria criteria = new ShopUserConsumeRecordCriteria();
        ShopUserConsumeRecordCriteria.Criteria c = criteria.createCriteria();
        c.andFlowNoEqualTo(consumeFlowNo);

        List<ShopUserConsumeRecordDTO> list = shopUserConsumeRecordMapper.selectByCriteria(criteria);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        UserConsumeRecordResponseDTO userConsumeRecordResponseDTO = new UserConsumeRecordResponseDTO();
        for (ShopUserConsumeRecordDTO userConsumeRecord : list) {
            userConsumeRecordResponseDTO.setCreateDate(userConsumeRecord.getCreateDate());
            userConsumeRecordResponseDTO.setShopUserName(userConsumeRecord.getShopUserName());
            userConsumeRecordResponseDTO.setSysShopClerkName(userConsumeRecord.getSysShopClerkName());
            userConsumeRecordResponseDTO.setSysShopName(userConsumeRecord.getSysShopName());
            userConsumeRecordResponseDTO.setType(userConsumeRecord.getConsumeType());
        }
        userConsumeRecordResponseDTO.setList(list);
        return userConsumeRecordResponseDTO;
    }

    /**
     * 保存用户消费或充值记录
     *
     * @param shopUserConsumeRecordDTO
     * @return
     */
    @Override
    public int saveCustomerConsumeRecord(ShopUserConsumeRecordDTO shopUserConsumeRecordDTO) {

        logger.info("保存用户消费或充值记录传入参数={}", "shopUserConsumeRecordDTO = [" + shopUserConsumeRecordDTO + "]");

        int insert = shopUserConsumeRecordMapper.insert(shopUserConsumeRecordDTO);

        return insert;
    }



}
