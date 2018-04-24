package com.wisdom.beauty.api.responseDto;

import com.wisdom.beauty.api.dto.ShopUserConsumeRecordDTO;
import com.wisdom.common.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * ClassName: ${CLASS_NAME}
 *
 * @Author： huan
 * @Description:
 * @Date:Created in 2018/4/9 19:26
 * @since JDK 1.8
 */
public class UserConsumeRecordResponseDTO extends BaseEntity {
    //流水号
    private  String flowNo;
    //总金额
    private BigDecimal sumAmount;
    //划卡和消费页面展示的名称
    private String title;
    //创建时间
    private Date createDate;
    //顾客
    private String shopUserName;
    //前台
    private String sysShopClerkName;
    //操作门店
    private String sysShopName;
    //类型
    private String type;
    private List<ShopUserConsumeRecordDTO> userConsumeRecordList;


    public Date getCreateDate() {
        return createDate;
    }

    public String getSysShopClerkName() {
        return sysShopClerkName;
    }

    public void setSysShopClerkName(String sysShopClerkName) {
        this.sysShopClerkName = sysShopClerkName;
    }

    public String getSysShopName() {
        return sysShopName;
    }

    public void setSysShopName(String sysShopName) {
        this.sysShopName = sysShopName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShopUserName() {
        return shopUserName;
    }

    public void setShopUserName(String shopUserName) {
        this.shopUserName = shopUserName;
    }

    public BigDecimal getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(BigDecimal sumAmount) {
        this.sumAmount = sumAmount;
    }

    public List<ShopUserConsumeRecordDTO> getUserConsumeRecordList() {
        return userConsumeRecordList;
    }

    public void setUserConsumeRecordList(List<ShopUserConsumeRecordDTO> userConsumeRecordList) {
        this.userConsumeRecordList = userConsumeRecordList;
    }

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo;
    }
}