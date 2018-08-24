package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.List;

import com.google.common.collect.Lists;

public class SicmedPatientPriceBeans extends BaseBean {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private List<SicmedPatientPriceBean> patientPriceBeans = Lists.newArrayList();

    public List<SicmedPatientPriceBean> getPatientPriceBeans() {
        return patientPriceBeans;
    }

    public void setPatientPriceBeans(List<SicmedPatientPriceBean> patientPriceBeans) {
        this.patientPriceBeans = patientPriceBeans;
    }
}
