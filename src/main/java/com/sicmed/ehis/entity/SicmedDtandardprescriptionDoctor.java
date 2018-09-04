package com.sicmed.ehis.entity;

import java.util.Date;

public class SicmedDtandardprescriptionDoctor {
    private String id;

    private String doctorCode;

    private String prescriptionName;

    private String prescriptionNameEx;

    private String askedCode;

    private String standerprescriptionAskedCode;

    private String standerprescriptionDiseaseCode;

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

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode == null ? null : doctorCode.trim();
    }

    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName == null ? null : prescriptionName.trim();
    }

    public String getPrescriptionNameEx() {
        return prescriptionNameEx;
    }

    public void setPrescriptionNameEx(String prescriptionNameEx) {
        this.prescriptionNameEx = prescriptionNameEx == null ? null : prescriptionNameEx.trim();
    }

    public String getAskedCode() {
        return askedCode;
    }

    public void setAskedCode(String askedCode) {
        this.askedCode = askedCode == null ? null : askedCode.trim();
    }

    public String getStanderprescriptionAskedCode() {
        return standerprescriptionAskedCode;
    }

    public void setStanderprescriptionAskedCode(String standerprescriptionAskedCode) {
        this.standerprescriptionAskedCode = standerprescriptionAskedCode == null ? null : standerprescriptionAskedCode.trim();
    }

    public String getStanderprescriptionDiseaseCode() {
        return standerprescriptionDiseaseCode;
    }

    public void setStanderprescriptionDiseaseCode(String standerprescriptionDiseaseCode) {
        this.standerprescriptionDiseaseCode = standerprescriptionDiseaseCode == null ? null : standerprescriptionDiseaseCode.trim();
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