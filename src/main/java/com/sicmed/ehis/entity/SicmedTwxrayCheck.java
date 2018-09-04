package com.sicmed.ehis.entity;

import java.util.Date;

public class SicmedTwxrayCheck {
    private String id;

    private String checkCode;

    private String checkName;

    private String checkPriceCode;

    private String checkNamePy;

    private String checkClassCode;

    private String checkDetail;

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

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode == null ? null : checkCode.trim();
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName == null ? null : checkName.trim();
    }

    public String getCheckPriceCode() {
        return checkPriceCode;
    }

    public void setCheckPriceCode(String checkPriceCode) {
        this.checkPriceCode = checkPriceCode == null ? null : checkPriceCode.trim();
    }

    public String getCheckNamePy() {
        return checkNamePy;
    }

    public void setCheckNamePy(String checkNamePy) {
        this.checkNamePy = checkNamePy == null ? null : checkNamePy.trim();
    }

    public String getCheckClassCode() {
        return checkClassCode;
    }

    public void setCheckClassCode(String checkClassCode) {
        this.checkClassCode = checkClassCode == null ? null : checkClassCode.trim();
    }

    public String getCheckDetail() {
        return checkDetail;
    }

    public void setCheckDetail(String checkDetail) {
        this.checkDetail = checkDetail == null ? null : checkDetail.trim();
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