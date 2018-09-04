package com.sicmed.ehis.entity;

import java.util.Date;

public class SicmedPatientAsked {
    private String id;

    private String patientCode;

    private String branchCode;

    private String doctorCode;

    private String askedClass;

    private String askedCode;

    private String medicalGroup;

    private String plusName;

    private String sendBranch;

    private String medicalCode;

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

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode == null ? null : doctorCode.trim();
    }

    public String getAskedClass() {
        return askedClass;
    }

    public void setAskedClass(String askedClass) {
        this.askedClass = askedClass == null ? null : askedClass.trim();
    }

    public String getAskedCode() {
        return askedCode;
    }

    public void setAskedCode(String askedCode) {
        this.askedCode = askedCode == null ? null : askedCode.trim();
    }

    public String getMedicalGroup() {
        return medicalGroup;
    }

    public void setMedicalGroup(String medicalGroup) {
        this.medicalGroup = medicalGroup == null ? null : medicalGroup.trim();
    }

    public String getPlusName() {
        return plusName;
    }

    public void setPlusName(String plusName) {
        this.plusName = plusName == null ? null : plusName.trim();
    }

    public String getSendBranch() {
        return sendBranch;
    }

    public void setSendBranch(String sendBranch) {
        this.sendBranch = sendBranch == null ? null : sendBranch.trim();
    }

    public String getMedicalCode() {
        return medicalCode;
    }

    public void setMedicalCode(String medicalCode) {
        this.medicalCode = medicalCode == null ? null : medicalCode.trim();
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