package com.sicmed.ehis.entity;

import java.util.Date;

public class SicmedRegisteredType {
    private String id;

    private String nameChina;

    private String nameEnglish;

    private String codeGrades;

    private String priceId;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;


    private SicmedRegisteredPrice sicmedRegisteredPrice;

    public SicmedRegisteredPrice getSicmedRegisteredPrice() {
        return sicmedRegisteredPrice;
    }

    public void setSicmedRegisteredPrice(SicmedRegisteredPrice sicmedRegisteredPrice) {
        this.sicmedRegisteredPrice = sicmedRegisteredPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNameChina() {
        return nameChina;
    }

    public void setNameChina(String nameChina) {
        this.nameChina = nameChina == null ? null : nameChina.trim();
    }

    public String getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish == null ? null : nameEnglish.trim();
    }

    public String getCodeGrades() {
        return codeGrades;
    }

    public void setCodeGrades(String codeGrades) {
        this.codeGrades = codeGrades;
    }

    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId == null ? null : priceId.trim();
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
        return "SicmedRegisteredType{" +
                "id='" + id + '\'' +
                ", nameChina='" + nameChina + '\'' +
                ", nameEnglish='" + nameEnglish + '\'' +
                ", codeGrades='" + codeGrades + '\'' +
                ", priceId='" + priceId + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate=" + createDate +
                ", updateBy='" + updateBy + '\'' +
                ", updateDate=" + updateDate +
                ", remarks='" + remarks + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", sicmedRegisteredPrice=" + sicmedRegisteredPrice +
                '}';
    }
}