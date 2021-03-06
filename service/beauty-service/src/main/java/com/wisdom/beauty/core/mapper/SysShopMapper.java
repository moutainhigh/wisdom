package com.wisdom.beauty.core.mapper;

import com.wisdom.beauty.api.dto.SysShopDTO;
import com.wisdom.beauty.api.dto.SysShopCriteria;
import com.wisdom.common.entity.BaseDao;
import com.wisdom.common.persistence.annotation.MyBatisDao;
import org.springframework.stereotype.Repository;

@MyBatisDao
@Repository
public interface SysShopMapper extends BaseDao<SysShopDTO, SysShopCriteria, String> {
}