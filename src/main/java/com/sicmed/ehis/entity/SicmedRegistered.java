package com.sicmed.ehis.entity;

import java.util.Date;

public class SicmedRegistered {
    private String id;

    private String patientCode;

    private String branchCode;

    private String sicmedRegistrationType;

    private String registeredStatus;

    private String registeredPric;

    private String pricStatus;

    private String doctorCode;

    private String updateUser;

    private String createUser;

    private String deleteUser;

    private Date registeredBeginDate;

    private Date registeredEndDate;

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

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode == null ? null : patientCode.trim();
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode == null ? null : branchCode.trim();
    }

    public String getSicmedRegistrationType() {
        return sicmedRegistrationType;
    }

    public void setSicmedRegistrationType(String sicmedRegistrationType) {
        this.sicmedRegistrationType = sicmedRegistrationType == null ? null : sicmedRegistrationType.trim();
    }

    public String getRegisteredStatus() {
        return registeredStatus;
    }

    public void setRegisteredStatus(String registeredStatus) {
        this.registeredStatus = registeredStatus == null ? null : registeredStatus.trim();
    }

    public String getRegisteredPric() {
        return registeredPric;
    }

    public void setRegisteredPric(String registeredPric) {
        this.registeredPric = registeredPric == null ? null : registeredPric.trim();
    }

    public String getPricStatus() {
        return pricStatus;
    }

    public void setPricStatus(String pricStatus) {
        this.pricStatus = pricStatus == null ? null : pricStatus.trim();
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode == null ? null : doctorCode.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getDeleteUser() {
        return deleteUser;
    }

    public void setDeleteUser(String deleteUser) {
        this.deleteUser = deleteUser == null ? null : deleteUser.trim();
    }

    public Date getRegisteredBeginDate() {
        return registeredBeginDate;
    }

    public void setRegisteredBeginDate(Date registeredBeginDate) {
        this.registeredBeginDate = registeredBeginDate;
    }

    public Date getRegisteredEndDate() {
        return registeredEndDate;
    }

    public void setRegisteredEndDate(Date registeredEndDate) {
        this.registeredEndDate = registeredEndDate;
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