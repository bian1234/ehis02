package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;

public class SicmedCurePriceBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    private List<SicmedCurePriceBean> sicmedCurePriceBeans = new ArrayList<SicmedCurePriceBean>();

    public List<SicmedCurePriceBean> getSicmedCurePriceBeans() {
        return sicmedCurePriceBeans;
    }

    public void setSicmedCurePriceBeans(List<SicmedCurePriceBean> sicmedCurePriceBeans) {
        this.sicmedCurePriceBeans = sicmedCurePriceBeans;
    }


}
