package com.thinkgem.jeesite.cfq.mobile.rest.entity;


import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 医嘱信息Entity
 *
 * @author XUE
 * @version 2016-07-12
 */
public class SicmedAsked extends DataEntity<SicmedAsked> {

    private static final long serialVersionUID = 1L;
    private String askedCode; // 医嘱编码
    private String orderCode; // 字表编号
    private String askedName; // 医嘱名称
    private String askedGroup; // 医嘱扩展名

    private String printType;//是否打印     0未打印  1已打印
    private SicmedPatientPrice sicmedPatientPrice; // 患者价格表id

    private List<SicmedAskedBranch> sicmedAskedBranch = Lists.newArrayList();
    private List<SicmedBranchAsked> sicmedBranchAsked = Lists.newArrayList();
    private List<SicmedDoctorAsked> sicmedDoctorAsked = Lists.newArrayList();
    private List<SicmedPatientAsked> sicmedPatientAsked = Lists.newArrayList();
    private List<SicmedStandardprescriptionBranch> sicmedStandardprescriptionBranch = Lists.newArrayList();
    private List<SicmedStandardprescriptionDoctor> sicmedStandardprescriptionDoctor = Lists.newArrayList();
    private SicmedAskedClass sicmedAskedClass;
    private SicmedCase sicmedCase; // 医嘱所属病例

    private SicmedMedicalUse sicmedMedicalUse; // 药品用法

    private String copyTableName; //启动新实例 赋值表明

    public SicmedCase getSicmedCase() {
        return sicmedCase;
    }


    public SicmedMedicalUse getSicmedMedicalUse() {
        return sicmedMedicalUse;
    }


    public void setSicmedMedicalUse(SicmedMedicalUse sicmedMedicalUse) {
        this.sicmedMedicalUse = sicmedMedicalUse;
    }


    public void setSicmedCase(SicmedCase sicmedCase) {
        this.sicmedCase = sicmedCase;
    }

    public SicmedPatientPrice getSicmedPatientPrice() {
        return sicmedPatientPrice;
    }

    public void setSicmedPatientPrice(SicmedPatientPrice sicmedPatientPrice) {
        this.sicmedPatientPrice = sicmedPatientPrice;
    }

    public SicmedAsked(SicmedAskedClass sicmedAskedClass) {
        this.sicmedAskedClass = sicmedAskedClass;
    }

    public SicmedAskedClass getSicmedAskedClass() {
        return sicmedAskedClass;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public void setSicmedAskedClass(SicmedAskedClass sicmedAskedClass) {
        this.sicmedAskedClass = sicmedAskedClass;
    }

    public List<SicmedBranchAsked> getSicmedBranchAsked() {
        return sicmedBranchAsked;
    }

    public List<SicmedPatientAsked> getSicmedPatientAsked() {
        return sicmedPatientAsked;
    }

    public void setSicmedPatientAsked(List<SicmedPatientAsked> sicmedPatientAsked) {
        this.sicmedPatientAsked = sicmedPatientAsked;
    }

    public void setSicmedBranchAsked(List<SicmedBranchAsked> sicmedBranchAsked) {
        this.sicmedBranchAsked = sicmedBranchAsked;
    }

    public List<SicmedDoctorAsked> getSicmedDoctorAsked() {
        return sicmedDoctorAsked;
    }

    public void setSicmedDoctorAsked(List<SicmedDoctorAsked> sicmedDoctorAsked) {
        this.sicmedDoctorAsked = sicmedDoctorAsked;
    }

    public List<SicmedStandardprescriptionBranch> getSicmedStandardprescriptionBranch() {
        return sicmedStandardprescriptionBranch;
    }

    public void setSicmedStandardprescriptionBranch(
            List<SicmedStandardprescriptionBranch> sicmedStandardprescriptionBranch) {
        this.sicmedStandardprescriptionBranch = sicmedStandardprescriptionBranch;
    }

    public List<SicmedStandardprescriptionDoctor> getSicmedStandardprescriptionDoctor() {
        return sicmedStandardprescriptionDoctor;
    }

    public void setSicmedStandardprescriptionDoctor(
            List<SicmedStandardprescriptionDoctor> sicmedStandardprescriptionDoctor) {
        this.sicmedStandardprescriptionDoctor = sicmedStandardprescriptionDoctor;
    }

    public SicmedAsked() {
        super();
    }

    public List<SicmedAskedBranch> getSicmedAskedBranch() {
        return sicmedAskedBranch;
    }

    public void setSicmedAskedBranch(List<SicmedAskedBranch> sicmedAskedBranch) {
        this.sicmedAskedBranch = sicmedAskedBranch;
    }

    public SicmedAsked(String id) {
        super(id);
    }

    @Length(min = 0, max = 30, message = "医嘱编码长度必须介于 0 和 30 之间")
    public String getAskedCode() {
        return askedCode;
    }

    public void setAskedCode(String askedCode) {
        this.askedCode = askedCode;
    }

    @Length(min = 0, max = 200, message = "医嘱名称长度必须介于 0 和 200 之间")
    public String getAskedName() {
        return askedName;
    }

    public void setAskedName(String askedName) {
        this.askedName = askedName;
    }

    @Length(min = 0, max = 200, message = "医嘱扩展名长度必须介于 0 和 200 之间")
    public void setAskedGroup(String askedGroup) {
        this.askedGroup = askedGroup;
    }


    public void setCopyTableName(String copyTableName) {
        this.copyTableName = copyTableName;
    }


    public String getCopyTableName() {
        return copyTableName;
    }


    public String getAskedGroup() {
        return askedGroup;
    }


    public String getPrintType() {
        return printType;
    }


    public void setPrintType(String printType) {
        this.printType = printType;
    }


}