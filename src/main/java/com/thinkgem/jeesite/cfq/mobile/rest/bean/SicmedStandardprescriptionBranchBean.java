/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedBranch;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStandardprescriptionBranch;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStanderprescriptionAsked;

/**
 * 医生常用疾病表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedStandardprescriptionBranchBean extends BaseBean {

    private static final long serialVersionUID = 1L;
    private SicmedBranch sicmedBranch;        // 科室编号(对应科室表)
    private String prescriptionName;        // 处方名称
    private String prescriptionNameEx;        // 处方名称(扩展)
//	private SicmedStanderprescriptionAskedBean standerprescriptionAskedBean = new SicmedStanderprescriptionAskedBean();		// 标准处方中医嘱编号(对应标准处方中医嘱表)
//	private SicmedStanderprescriptionDiseaseBean standerdprescriptionDiseaseBean = new SicmedStanderprescriptionDiseaseBean();		// 标准处方中的疾病编码(对应标准处方中的疾病表)

    public void setssb(SicmedStandardprescriptionBranch ssb) {
        this.prescriptionName = ssb.getPrescriptionName();
        this.prescriptionNameEx = ssb.getPrescriptionNameEx();
//		this.standerprescriptionAskedBean.setssa(ssb.getStanderprescriptionAsked());
//		this.standerdprescriptionDiseaseBean.setssdb(ssb.getStanderprescriptionDisease());
    }

    public SicmedStandardprescriptionBranchBean() {
        super();
    }

    public SicmedBranch getSicmedBranch() {
        return sicmedBranch;
    }

    public void setSicmedBranch(SicmedBranch sicmedBranch) {
        this.sicmedBranch = sicmedBranch;
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