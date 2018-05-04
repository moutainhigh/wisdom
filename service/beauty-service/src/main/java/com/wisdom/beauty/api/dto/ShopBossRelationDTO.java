package com.wisdom.beauty.api.dto;

import com.wisdom.common.entity.BaseEntity;

import java.io.Serializable;

public class ShopBossRelationDTO extends BaseEntity implements Serializable {
    //
    private String id;

    //店id
    private String sysShopId;

    //店名称
    private String sysShopName;

    //
    private String sysBossId;

    //
    private String sysBossName;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSysShopId() {
        return sysShopId;
    }

    public void setSysShopId(String sysShopId) {
        this.sysShopId = sysShopId;
    }

    public String getSysShopName() {
        return sysShopName;
    }

    public void setSysShopName(String sysShopName) {
        this.sysShopName = sysShopName;
    }

    public String getSysBossId() {
        return sysBossId;
    }

    public void setSysBossId(String sysBossId) {
        this.sysBossId = sysBossId;
    }

    public String getSysBossName() {
        return sysBossName;
    }

    public void setSysBossName(String sysBossName) {
        this.sysBossName = sysBossName;
    }
}