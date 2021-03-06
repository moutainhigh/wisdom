package com.wisdom.beauty.core.mapper;

import com.wisdom.beauty.api.dto.ShopProjectProductCardRelationCriteria;
import com.wisdom.beauty.api.dto.ShopProjectProductCardRelationDTO;
import com.wisdom.common.entity.BaseDao;
import com.wisdom.common.persistence.annotation.MyBatisDao;
import org.springframework.stereotype.Repository;

@MyBatisDao
@Repository
public interface ShopProjectProductCardRelationMapper extends BaseDao<ShopProjectProductCardRelationDTO, ShopProjectProductCardRelationCriteria, String> {
}