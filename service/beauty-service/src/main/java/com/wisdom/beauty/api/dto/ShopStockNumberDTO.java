package com.wisdom.beauty.api.dto;

import com.wisdom.common.entity.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ShopStockNumberDTO extends BaseEntity implements Serializable {
    //
    private String id;

    //产品id
    private String shopProcId;

    //仓库id
    private String shopStoreId;

    //
    private String shopBossId;

    //产品二级类别id
    private String productTypeTwoId;

    //库存数量
    private Integer stockNumber;

    //实际库存数量
    private Integer actualStockNumber;

    //实际价格
    private Integer actualStockPrice;

    //价格
    private BigDecimal stockPrice;

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

    public String getShopProcId() {
        return shopProcId;
    }

    public void setShopProcId(String shopProcId) {
        this.shopProcId = shopProcId;
    }

    public String getShopStoreId() {
        return shopStoreId;
    }

    public void setShopStoreId(String shopStoreId) {
        this.shopStoreId = shopStoreId;
    }

    public String getShopBossId() {
        return shopBossId;
    }

    public void setShopBossId(String shopBossId) {
        this.shopBossId = shopBossId;
    }

    public String getProductTypeTwoId() {
        return productTypeTwoId;
    }

    public void setProductTypeTwoId(String productTypeTwoId) {
        this.productTypeTwoId = productTypeTwoId;
    }

    public Integer getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
    }

    public Integer getActualStockNumber() {
        return actualStockNumber;
    }

    public void setActualStockNumber(Integer actualStockNumber) {
        this.actualStockNumber = actualStockNumber;
    }

    public Integer getActualStockPrice() {
        return actualStockPrice;
    }

    public void setActualStockPrice(Integer actualStockPrice) {
        this.actualStockPrice = actualStockPrice;
    }

    public BigDecimal getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(BigDecimal stockPrice) {
        this.stockPrice = stockPrice;
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