package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;


public class SicmedCheckPriceBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    private List<SicmedCheckPriceBean> sicmedCheckPriceBeans = new ArrayList<SicmedCheckPriceBean>();

    public List<SicmedCheckPriceBean> getSicmedCheckPriceBeans() {
        return sicmedCheckPriceBeans;
    }

    public void setSicmedCheckPriceBeans(List<SicmedCheckPriceBean> sicmedCheckPriceBeans) {
        this.sicmedCheckPriceBeans = sicmedCheckPriceBeans;
    }

}