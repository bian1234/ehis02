package com.sicmed.ehis.entity;

import java.util.Date;


/**
 *@Author:      ykbian
 *@date_time:   2018/9/3 17:11
 *@Description:  医嘱信息
 *@param:
*/
public class SicmedAsked {
    private String id;

    private String askedClassCode;

    private String askedCode;

    private String askedName;

    private String patientPrice;

    private String orderCode;

    private String medicalUseCode;

    private String askedNameExtand;

    private String askedCaseCode;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String printType;

    private String delFlag;

    /**
     *@Author:      ykbian
     *@date_time:   2018/9/3 17:15
     *@Description:  需要复制的表名   =======出自源码，目前还不知道其作用
     *@param:
    */
    private String copyTableName; //启动新实例 赋值表明

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAskedClassCode() {
        return askedClassCode;
    }

    public void setAskedClassCode(String askedClassCode) {
        this.askedClassCode = askedClassCode == null ? null : askedClassCode.trim();
    }

    public String getAskedCode() {
        return askedCode;
    }

    public void setAskedCode(String askedCode) {
        this.askedCode = askedCode == null ? null : askedCode.trim();
    }

    public String getAskedName() {
        return askedName;
    }

    public void setAskedName(String askedName) {
        this.askedName = askedName == null ? null : askedName.trim();
    }

    public String getPatientPrice() {
        return patientPrice;
    }

    public void setPatientPrice(String patientPrice) {
        this.patientPrice = patientPrice == null ? null : patientPrice.trim();
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

    public String getAskedNameExtand() {
        return askedNameExtand;
    }

    public void setAskedNameExtand(String askedNameExtand) {
        this.askedNameExtand = askedNameExtand == null ? null : askedNameExtand.trim();
    }

    public String getAskedCaseCode() {
        return askedCaseCode;
    }

    public void setAskedCaseCode(String askedCaseCode) {
        this.askedCaseCode = askedCaseCode == null ? null : askedCaseCode.trim();
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

    public String getPrintType() {
        return printType;
    }

    public void setPrintType(String printType) {
        this.printType = printType == null ? null : printType.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getCopyTableName() {
        return copyTableName;
    }

    public void setCopyTableName(String copyTableName) {
        this.copyTableName = copyTableName;
    }
}