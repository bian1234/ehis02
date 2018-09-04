package com.sicmed.ehis.entity;

import java.util.Date;

public class SicmedStanderprescriptionAsked {
    private String id;

    private String standerprescriptionCode;

    private String askedClassCode;

    private String orderCode;

    private String medicalUseCode;

    private String createUser;

    private String updateUser;

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

    public String getStanderprescriptionCode() {
        return standerprescriptionCode;
    }

    public void setStanderprescriptionCode(String standerprescriptionCode) {
        this.standerprescriptionCode = standerprescriptionCode == null ? null : standerprescriptionCode.trim();
    }

    public String getAskedClassCode() {
        return askedClassCode;
    }

    public void setAskedClassCode(String askedClassCode) {
        this.askedClassCode = askedClassCode == null ? null : askedClassCode.trim();
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public String getMedicalUseCode() {
        return medicalUseCode;
    }

    public void setMedicalUseCode(String medicalUseCode) {
        this.medicalUseCode = medicalUseCode == null ? null : medicalUseCode.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
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