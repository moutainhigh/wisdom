package com.wisdom.beauty.core.mapper;

import com.wisdom.beauty.api.dto.ShopCashFlowCriteria;
import com.wisdom.beauty.api.dto.ShopCashFlowDTO;
import com.wisdom.common.entity.BaseDao;
import com.wisdom.common.persistence.annotation.MyBatisDao;
import org.springframework.stereotype.Repository;

@MyBatisDao
@Repository
public interface ShopCashFlowMapper extends BaseDao<ShopCashFlowDTO, ShopCashFlowCriteria, String> {
}