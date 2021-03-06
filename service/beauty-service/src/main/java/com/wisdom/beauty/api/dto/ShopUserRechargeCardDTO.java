package com.wisdom.beauty.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.wisdom.common.entity.BaseEntity;

public class ShopUserRechargeCardDTO extends BaseEntity implements Serializable {
    //
    private String id;

    //充值卡主键
    private String shopRechargeCardId;

    //充值卡名称
    private String shopRechargeCardName;

    //用户主键
    private String sysUserId;

    //用户名称
    private String sysUserName;

    //
    private String sysClerkId;

    //
    private String sysClerkName;

    //美容店id
    private String sysShopId;

    //boss编码
    private String sysBossCode;

    //次卡折扣
    private Float timeDiscount;

    //疗程卡折扣
    private Float periodDiscount;

    //产品折扣
    private Float productDiscount;

    //0 特殊账户
    private String rechargeCardType;

    //
    private String imageUrl;

    //备注
    private String detail;

    //折扣描述
    private String discountDesc;

    //剩余金额
    private BigDecimal surplusAmount;

    //初始金额
    private BigDecimal initAmount;

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

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getSysUserName() {
        return sysUserName;
    }

    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName;
    }

    public String getSysClerkId() {
        return sysClerkId;
    }

    public void setSysClerkId(String sysClerkId) {
        this.sysClerkId = sysClerkId;
    }

    public String getSysClerkName() {
        return sysClerkName;
    }

    public void setSysClerkName(String sysClerkName) {
        this.sysClerkName = sysClerkName;
    }

    public String getSysShopId() {
        return sysShopId;
    }

    public void setSysShopId(String sysShopId) {
        this.sysShopId = sysShopId;
    }

    public String getSysBossCode() {
        return sysBossCode;
    }

    public void setSysBossCode(String sysBossCode) {
        this.sysBossCode = sysBossCode;
    }

    public Float getTimeDiscount() {
        return timeDiscount;
    }

    public void setTimeDiscount(Float timeDiscount) {
        this.timeDiscount = timeDiscount;
    }

    public Float getPeriodDiscount() {
        return periodDiscount;
    }

    public void setPeriodDiscount(Float periodDiscount) {
        this.periodDiscount = periodDiscount;
    }

    public Float getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(Float productDiscount) {
        this.productDiscount = productDiscount;
    }

    public String getRechargeCardType() {
        return rechargeCardType;
    }

    public void setRechargeCardType(String rechargeCardType) {
        this.rechargeCardType = rechargeCardType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDiscountDesc() {
        return discountDesc;
    }

    public void setDiscountDesc(String discountDesc) {
        this.discountDesc = discountDesc;
    }

    public BigDecimal getSurplusAmount() {
        return surplusAmount;
    }

    public void setSurplusAmount(BigDecimal surplusAmount) {
        this.surplusAmount = surplusAmount;
    }

    public BigDecimal getInitAmount() {
        return initAmount;
    }

    public void setInitAmount(BigDecimal initAmount) {
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