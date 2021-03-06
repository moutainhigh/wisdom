package com.wisdom.beauty.core.mapper;

import com.wisdom.beauty.api.dto.SysShopRoomCriteria;
import com.wisdom.beauty.api.dto.SysShopRoomDTO;
import com.wisdom.common.entity.BaseDao;
import com.wisdom.common.persistence.annotation.MyBatisDao;
import org.springframework.stereotype.Repository;

@MyBatisDao
@Repository
public interface SysShopRoomMapper extends BaseDao<SysShopRoomDTO, SysShopRoomCriteria, String> {
}