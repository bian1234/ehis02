package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;

public class SicmedMedicalBeans extends BaseBean {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private List<SicmedMedicalBean> sicmedMedicalBeans = new ArrayList<SicmedMedicalBean>();

    public List<SicmedMedicalBean> getSicmedMedicalBeans() {
        return sicmedMedicalBeans;
    }

    public void setSicmedMedicalBeans(List<SicmedMedicalBean> sicmedMedicalBeans) {
        this.sicmedMedicalBeans = sicmedMedicalBeans;
    }

}
