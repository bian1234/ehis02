package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;

public class SicmedInspectPriceBeans extends BaseBean {

    private static final long serialVersionUID = 1L;
    private List<SicmedInspectPriceBean> sicmedInspectPriceBeans = new ArrayList<SicmedInspectPriceBean>();

    public List<SicmedInspectPriceBean> getSicmedInspectPriceBeans() {
        return sicmedInspectPriceBeans;
    }

    public void setSicmedInspectPriceBeans(List<SicmedInspectPriceBean> sicmedInspectPriceBeans) {
        this.sicmedInspectPriceBeans = sicmedInspectPriceBeans;
    }


}
