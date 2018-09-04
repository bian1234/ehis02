package com.sicmed.ehis.entity;

import java.util.Date;

public class SicmedCheckPrice {
    private String id;

    private Date checkPriceCutoffDate;

    private Date checkPriceInsertDate;

    private String checkCode;

    private String checkPrice;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCheckPriceCutoffDate() {
        return checkPriceCutoffDate;
    }

    public void setCheckPriceCutoffDate(Date checkPriceCutoffDate) {
        this.checkPriceCutoffDate = checkPriceCutoffDate;
    }

    public Date getCheckPriceInsertDate() {
        return checkPriceInsertDate;
    }

    public void setCheckPriceInsertDate(Date checkPriceInsertDate) {
        this.checkPriceInsertDate = checkPriceInsertDate;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode == null ? null : checkCode.trim();
    }

    public String getCheckPrice() {
        return checkPrice;
    }

    public void setCheckPrice(String checkPrice) {
        this.checkPrice = checkPrice == null ? null : checkPrice.trim();
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
}