package com.wisdom.beauty.api.dto;

import com.wisdom.common.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class ShopStockRecordDTO extends BaseEntity implements Serializable {
    //
    private String id;

    //库存表主键
    private String shopStockId;

    //仓库名称
    private String name;

    //0、手动入库  1、扫码入库 2、手动出库 3、扫码出库
    private String stockStyle;

    //0、采购入库 1、内部员工出库 2、顾客出库 3、赠送 4、报废 5、院用  6、退回供货商  7、下发到店
    private String stockType;

    //操作时间
    private Date operDate;

    //单据号
    private String flowNo;

    //操作人(库管id)
    private String managerId;

    //备注
    private String detail;

    //
    private Integer operNumber;

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

    public String getShopStockId() {
        return shopStockId;
    }

    public void setShopStockId(String shopStockId) {
        this.shopStockId = shopStockId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStockStyle() {
        return stockStyle;
    }

    public void setStockStyle(String stockStyle) {
        this.stockStyle = stockStyle;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public Date getOperDate() {
        return operDate;
    }

    public void setOperDate(Date operDate) {
        this.operDate = operDate;
    }

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

 public String getDetail() {        return detail;    }    public void setDetail(String detail) {        this.detail = detail;    }

    public Integer getOperNumber() {
        return operNumber;
    }

    public void setOperNumber(Integer operNumber) {
        this.operNumber = operNumber;
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