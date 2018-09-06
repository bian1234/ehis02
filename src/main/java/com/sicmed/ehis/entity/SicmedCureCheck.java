package com.sicmed.ehis.entity;

import java.util.Date;

public class SicmedCureCheck {
    private String id;

    private String cureCode;

    private String cureName;

    private String cureNamePy;

    private String checkPriceCode;

    private String cureClassCode;

    private String cureDetail;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;


    /**
     *  增加治疗价格和治疗分类属性
     */
    private SicmedCurePrice sicmedCurePrice;
    private SicmedCureClass sicmedCureClass;

    public SicmedCurePrice getSicmedCurePrice() {
        return sicmedCurePrice;
    }

    public void setSicmedCurePrice(SicmedCurePrice sicmedCurePrice) {
        this.sicmedCurePrice = sicmedCurePrice;
    }

    public SicmedCureClass getSicmedCureClass() {
        return sicmedCureClass;
    }

    public void setSicmedCureClass(SicmedCureClass sicmedCureClass) {
        this.sicmedCureClass = sicmedCureClass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCureCode() {
        return cureCode;
    }

    public void setCureCode(String cureCode) {
        this.cureCode = cureCode == null ? null : cureCode.trim();
    }

    public String getCureName() {
        return cureName;
    }

    public void setCureName(String cureName) {
        this.cureName = cureName == null ? null : cureName.trim();
    }

    public String getCureNamePy() {
        return cureNamePy;
    }

    public void setCureNamePy(String cureNamePy) {
        this.cureNamePy = cureNamePy == null ? null : cureNamePy.trim();
    }

    public String getCheckPriceCode() {
        return checkPriceCode;
    }

    public void setCheckPriceCode(String checkPriceCode) {
        this.checkPriceCode = checkPriceCode == null ? null : checkPriceCode.trim();
    }

    public String getCureClassCode() {
        return cureClassCode;
    }

    public void setCureClassCode(String cureClassCode) {
        this.cureClassCode = cureClassCode == null ? null : cureClassCode.trim();
    }

    public String getCureDetail() {
        return cureDetail;
    }

    public void setCureDetail(String cureDetail) {
        this.cureDetail = cureDetail == null ? null : cureDetail.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    @Override
    public String toString() {
        return "SicmedCureCheck{" +
                "id='" + id + '\'' +
                ", cureCode='" + cureCode + '\'' +
                ", cureName='" + cureName + '\'' +
                ", cureNamePy='" + cureNamePy + '\'' +
                ", checkPriceCode='" + checkPriceCode + '\'' +
                ", cureClassCode='" + cureClassCode + '\'' +
                ", cureDetail='" + cureDetail + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate=" + createDate +
                ", updateBy='" + updateBy + '\'' +
                ", updateDate=" + updateDate +
                ", remarks='" + remarks + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", sicmedCurePrice=" + sicmedCurePrice +
                ", sicmedCureClass=" + sicmedCureClass +
                '}';
    }
}