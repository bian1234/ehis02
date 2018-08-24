/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAskedClass;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStanderprescriptionAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStanderprescriptionDisease;

/**
 * 医生常用疾病表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedStandardprescriptionBranchBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    private SicmedStanderprescriptionAsked standerprescriptionAsked;        // 标准处方中医嘱编号(对应标准处方中医嘱表)
    private SicmedStanderprescriptionDisease standerprescriptionDisease;        // 标准处方中的疾病编码(对应标准处方中的疾病表)
    private SicmedAskedClass sicmedAskedClass;  //医嘱类型编号(对应医嘱类别表)
    private List<SicmedStandardprescriptionBranchBean> sicmedStandardprescriptionBranchBeans = new ArrayList<SicmedStandardprescriptionBranchBean>();

    public SicmedStanderprescriptionAsked getStanderprescriptionAsked() {
        return standerprescriptionAsked;
    }

    public void setStanderprescriptionAsked(SicmedStanderprescriptionAsked standerprescriptionAsked) {
        this.standerprescriptionAsked = standerprescriptionAsked;
    }

    public SicmedAskedClass getSicmedAskedClass() {
        return sicmedAskedClass;
    }

    public void setSicmedAskedClass(SicmedAskedClass sicmedAskedClass) {
        this.sicmedAskedClass = sicmedAskedClass;
    }

    public SicmedStanderprescriptionDisease getStanderprescriptionDisease() {
        return standerprescriptionDisease;
    }

    public void setStanderprescriptionDisease(SicmedStanderprescriptionDisease standerprescriptionDisease) {
        this.standerprescriptionDisease = standerprescriptionDisease;
    }

    public List<SicmedStandardprescriptionBranchBean> getSicmedStandardprescriptionBranchBeans() {
        return sicmedStandardprescriptionBranchBeans;
    }

    public void setSicmedStandardprescriptionBranchBeans(
            List<SicmedStandardprescriptionBranchBean> sicmedStandardprescriptionBranchBeans) {
        this.sicmedStandardprescriptionBranchBeans = sicmedStandardprescriptionBranchBeans;
    }

}