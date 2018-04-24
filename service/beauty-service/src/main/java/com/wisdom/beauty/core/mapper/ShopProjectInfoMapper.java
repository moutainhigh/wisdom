package com.wisdom.beauty.core.mapper;

import com.wisdom.beauty.api.dto.ShopProjectInfoCriteria;
import com.wisdom.beauty.api.dto.ShopProjectInfoDTO;
import com.wisdom.common.entity.BaseDao;
import com.wisdom.common.persistence.annotation.MyBatisDao;
import org.springframework.stereotype.Repository;

@MyBatisDao
@Repository
public interface ShopProjectInfoMapper extends BaseDao<ShopProjectInfoDTO, ShopProjectInfoCriteria, String> {
}