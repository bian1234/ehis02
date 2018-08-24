/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;


import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;

/**
 * 医生常用疾病表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedStandardprescriptionDoctor extends DataEntity<SicmedStandardprescriptionDoctor> {

    private static final long serialVersionUID = 1L;
    private SicmedUser sicmedUser;        // 医生编号(对应用户表)
    private String prescriptionName;        // 处方名
    private String prescriptionNameEx;        // 处方名(扩展)
    private SicmedAskedClass askedClass;                //医嘱类型编号(对应医嘱类别表)
    private SicmedStanderprescriptionAsked standerprescriptionAsked;        // 标准处方中医嘱编号(对应标准处方中医嘱表)
    private SicmedStanderprescriptionDisease standerprescriptionDisease;        // 标准处方中的疾病编码(对应标准处方中的疾病表)

    public SicmedStanderprescriptionAsked getStanderprescriptionAsked() {
        return standerprescriptionAsked;
    }

    public void setStanderprescriptionAsked(SicmedStanderprescriptionAsked standerprescriptionAsked) {
        this.standerprescriptionAsked = standerprescriptionAsked;
    }

    public SicmedStanderprescriptionDisease getStanderprescriptionDisease() {
        return standerprescriptionDisease;
    }

    public void setStanderprescriptionDisease(SicmedStanderprescriptionDisease standerprescriptionDisease) {
        this.standerprescriptionDisease = standerprescriptionDisease;
    }


    public SicmedStandardprescriptionDoctor() {
        super();
    }

    public SicmedStandardprescriptionDoctor(String id) {
        super(id);
    }


    public SicmedAskedClass getAskedClass() {
        return askedClass;
    }

    public void setAskedClass(SicmedAskedClass askedClass) {
        this.askedClass = askedClass;
    }

    public SicmedUser getSicmedUser() {
        return sicmedUser;
    }

    public void setSicmedUser(SicmedUser sicmedUser) {
        this.sicmedUser = sicmedUser;
    }

    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
    }

    public String getPrescriptionNameEx() {
        return prescriptionNameEx;
    }

    public void setPrescriptionNameEx(String prescriptionNameEx) {
        this.prescriptionNameEx = prescriptionNameEx;
    }


}