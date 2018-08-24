package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.List;

import com.google.common.collect.Lists;

public class SicmedMedicalClassBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    List<SicmedMedicalClassBean> sicmedMedicalClassBeans = Lists.newArrayList();

    public List<SicmedMedicalClassBean> getSicmedMedicalClassBeans() {
        return sicmedMedicalClassBeans;
    }

    public void setSicmedMedicalClassBeans(List<SicmedMedicalClassBean> sicmedMedicalClassBeans) {
        this.sicmedMedicalClassBeans = sicmedMedicalClassBeans;
    }

}
