package com.wisdom.beauty.api.dto;

import com.wisdom.common.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class ShopCustomerRechargeCardDTO extends BaseEntity implements Serializable {
    //
    private String id;

    //充值卡主键
    private String shopRechargeCardId;

    //充值卡名称
    private String shopRechargeCardName;

    //用户主键
    private String sysCustomerId;

    //用户名称
    private String sysCustomerName;

    //美容店id
    private String sysShopId;

    //老板表主键
    private String sysBossId;

    //剩余金额
    private Long surplusAmount;

    //初始金额
    private Long initAmount;

    //
    private String createBy;

    //
    private Date createDate;

    //
    private String updateUser;

    //
    private Date updateDate;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopRechargeCardId() {
        return shopRechargeCardId;
    }

    public void setShopRechargeCardId(String shopRechargeCardId) {
        this.shopRechargeCardId = shopRechargeCardId;
    }

    public String getShopRechargeCardName() {
        return shopRechargeCardName;
    }

    public void setShopRechargeCardName(String shopRechargeCardName) {
        this.shopRechargeCardName = shopRechargeCardName;
    }

    public String getSysCustomerId() {
        return sysCustomerId;
    }

    public void setSysCustomerId(String sysCustomerId) {
        this.sysCustomerId = sysCustomerId;
    }

    public String getSysCustomerName() {
        return sysCustomerName;
    }

    public void setSysCustomerName(String sysCustomerName) {
        this.sysCustomerName = sysCustomerName;
    }

    public String getSysShopId() {
        return sysShopId;
    }

    public void setSysShopId(String sysShopId) {
        this.sysShopId = sysShopId;
    }

    public String getSysBossId() {
        return sysBossId;
    }

    public void setSysBossId(String sysBossId) {
        this.sysBossId = sysBossId;
    }

    public Long getSurplusAmount() {
        return surplusAmount;
    }

    public void setSurplusAmount(Long surplusAmount) {
        this.surplusAmount = surplusAmount;
    }

    public Long getInitAmount() {
        return initAmount;
    }

    public void setInitAmount(Long initAmount) {
        this.initAmount = initAmount;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}