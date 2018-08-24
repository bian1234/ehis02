package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;

public class SicmedMedicalPriceBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    private List<SicmedMedicalPriceBean> sicmedMedicalPriceBeans = new ArrayList<SicmedMedicalPriceBean>();

    public List<SicmedMedicalPriceBean> getSicmedMedicalPriceBeans() {
        return sicmedMedicalPriceBeans;
    }

    public void setSicmedMedicalPriceBeans(List<SicmedMedicalPriceBean> sicmedMedicalPriceBeans) {
        this.sicmedMedicalPriceBeans = sicmedMedicalPriceBeans;
    }


}
