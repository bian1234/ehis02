/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import com.thinkgem.jeesite.cfq.common.utils.excel.annotation.ExcelField;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;

/**
 * 挂号信息表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedRegistered extends DataEntity<SicmedRegistered> {

    private static final long serialVersionUID = 1L;
    private Date registeredBeginDate;                                // 就诊开始时间
    private Date registeredEndDate;                                    // 就诊结束时间
    private String registeredStatus;                                // 挂号类型
    private String registeredPric;                                    // 挂号费用
    private String registeredStatusName;                            // 挂号类型名称(0,可改号,可退号,1可改号 数据库中没有)
    private String pricStatus;                                        // 缴费状态
    private SicmedBaseCode sicmedBaseCode;                            // 医保类型(对应基础编码标准中的BUN(BI)_code)
    private SicmedPatient sicmedPatient;                            // 患者编号(对应患者基本信息表)
    private SicmedBranch sicmedBranch;                                // 科室编号(对应科室表)
    private SicmedUser sicmedDoctor;                                // 医生(对应医生表)
    private SicmedUser createUser;                                    // 创建人(对应医生表)
    private SicmedUser updateUser;                                    // 修改人(对应医生表)
    private SicmedUser deleteUser;                                    // 删除人(对应用户表)
    private SicmedRegisteredType sicmedRegistrationType;            // 挂号类型
    private String statusType;                                    // 是否缴费(0.未缴费  1.已缴费)
    private String remarks;                                        // 备注
    private String copyTableName;                                    // 清空新实例 记录备份表名

    public SicmedUser getDeleteUser() {
        return deleteUser;
    }

    public void setDeleteUser(SicmedUser deleteUser) {
        this.deleteUser = deleteUser;
    }

    public SicmedRegistered() {
        super();
    }

    public SicmedRegistered(String id) {
        super(id);
    }

    public SicmedUser getCreateUser() {
        return createUser;
    }

    public void setCreateUser(SicmedUser createUser) {
        this.createUser = createUser;
    }

    public String getStatusType() {
        if (statusType != null || pricStatus == null) {
            return statusType;
        }
        switch (Integer.valueOf(this.getPricStatus())) {
            case 1:
                this.setStatusType("未缴费");
                break;
            case 0:
                this.setStatusType("已缴费");
            default:
                break;
        }
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public SicmedUser getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(SicmedUser updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    @ExcelField(title = "备注", align = 2, sort = 60)
    public String getRemarks() {
        return remarks;
    }

    @Override
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public SicmedRegisteredType getSicmedRegistrationType() {
        return sicmedRegistrationType;
    }

    public void setSicmedRegistrationType(SicmedRegisteredType sicmedRegistrationType) {
        this.sicmedRegistrationType = sicmedRegistrationType;
    }

    @Length(min = 0, max = 1, message = "缴费状态长度必须介于 0 和 2 之间")
//	@ExcelField(title="缴费状态", align=2, sort=30)
    public String getPricStatus() {
        return pricStatus;
    }

    public void setPricStatus(String pricStatus) {
        this.pricStatus = pricStatus;
    }

    @Length(min = 0, max = 20, message = "挂号类型长度必须介于 0 和 20 之间")
    @ExcelField(title = "挂号类型", align = 2, sort = 15)
    public String getRegisteredStatus() {
        return registeredStatus;
    }

    public void setRegisteredStatus(String registeredStatus) {
        this.registeredStatus = registeredStatus;
    }

    @Length(min = 0, max = 30, message = "价格长度必须介于 0 和 30 之间")
    public String getRegisteredPric() {
        return registeredPric;
    }

    public void setRegisteredPric(String registeredPric) {
        this.registeredPric = registeredPric;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "就诊开始时间不能为空")
    @ExcelField(title = "挂号时间", align = 2, sort = 50)
    public Date getRegisteredBeginDate() {
        return registeredBeginDate;
    }

    public void setRegisteredBeginDate(Date registeredBeginDate) {
        this.registeredBeginDate = registeredBeginDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "就诊结束时间不能为空")
    public Date getRegisteredEndDate() {
        return registeredEndDate;
    }

    public void setRegisteredEndDate(Date registeredEndDate) {
        this.registeredEndDate = registeredEndDate;
    }

    public SicmedBaseCode getSicmedBaseCode() {
        return sicmedBaseCode;
    }

    public void setSicmedBaseCode(SicmedBaseCode sicmedBaseCode) {
        this.sicmedBaseCode = sicmedBaseCode;
    }

    public SicmedPatient getSicmedPatient() {
        return sicmedPatient;
    }

    public void setSicmedPatient(SicmedPatient sicmedPatient) {
        this.sicmedPatient = sicmedPatient;
    }

    @ExcelField(title = "患者姓名", align = 2, sort = 2)
    public String getPatientName() {
        return sicmedPatient.getPatientName();
    }

    public SicmedBranch getSicmedBranch() {
        return sicmedBranch;
    }

    @ExcelField(title = "科室名称", align = 2, sort = 10)
    public String getSicmedBranchstr() {
        return sicmedBranch.getBranchName();
    }


    public void setSicmedBranch(SicmedBranch sicmedBranch) {
        this.sicmedBranch = sicmedBranch;
    }

    @ExcelField(title = "医生", align = 2, sort = 20)
    public String getSicmedUserstr() {
        return sicmedDoctor.getUserName();
    }

    public SicmedUser getSicmedDoctor() {
        return sicmedDoctor;
    }

    public void setSicmedDoctor(SicmedUser sicmedDoctor) {
        this.sicmedDoctor = sicmedDoctor;
    }

    public String getCopyTableName() {
        return copyTableName;
    }

    public void setCopyTableName(String copyTableName) {
        this.copyTableName = copyTableName;
    }

    public String getRegisteredStatusName() {
        if (registeredStatusName != null || registeredStatus == null) {
            return registeredStatusName;
        }
        switch (Integer.valueOf(this.getRegisteredStatus())) {
            case 0:
                this.setRegisteredStatusName("已挂号");
                break;
            case 1:
                this.setRegisteredStatusName("已挂号");
                break;
            case 2:
                this.setRegisteredStatusName("已挂号");
        }
        return registeredStatusName;
    }

    public void setRegisteredStatusName(String registeredStatusName) {
        this.registeredStatusName = registeredStatusName;
    }


}