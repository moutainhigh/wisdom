package com.wisdom.beauty.core.mapper;

import com.wisdom.beauty.api.dto.ShopRechargeCardCriteria;
import com.wisdom.beauty.api.dto.ShopRechargeCardDTO;
import com.wisdom.common.entity.BaseDao;
import com.wisdom.common.persistence.annotation.MyBatisDao;
import org.springframework.stereotype.Repository;

@MyBatisDao
@Repository
public interface ShopRechargeCardMapper extends BaseDao<ShopRechargeCardDTO, ShopRechargeCardCriteria, String> {
}