/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;

import org.hibernate.validator.constraints.Length;


/**
 * 医生常用疾病表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedStanderprescriptionDisease extends DataEntity<SicmedStanderprescriptionDisease> {

    private static final long serialVersionUID = 1L;
    private String prescriptionName; // 处方名
    private String prescriptionNameEx; // 处方扩展名
    private SicmedDisease sicmedDisease; // 疾病编码(对应疾病编码表)
    private SicmedUser createUser; // 创建者
    private SicmedUser updateUser; // 更新者

    public SicmedStanderprescriptionDisease() {
        super();
    }

    public SicmedStanderprescriptionDisease(String id) {
        super(id);
    }


    public SicmedUser getCreateUser() {
        return createUser;
    }

    public void setCreateUser(SicmedUser createUser) {
        this.createUser = createUser;
    }

    public SicmedUser getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(SicmedUser updateUser) {
        this.updateUser = updateUser;
    }

    public SicmedDisease getSicmedDisease() {
        return sicmedDisease;
    }

    public void setSicmedDisease(SicmedDisease sicmedDisease) {
        this.sicmedDisease = sicmedDisease;
    }

    @Length(min = 0, max = 40, message = "处方名长度必须介于 0 和 40 之间")
    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
    }

    @Length(min = 0, max = 40, message = "医嘱扩展名长度必须介于 0 和 40 之间")
    public String getPrescriptionNameEx() {
        return prescriptionNameEx;
    }

    public void setPrescriptionNameEx(String prescriptionNameEx) {
        this.prescriptionNameEx = prescriptionNameEx;
    }

}