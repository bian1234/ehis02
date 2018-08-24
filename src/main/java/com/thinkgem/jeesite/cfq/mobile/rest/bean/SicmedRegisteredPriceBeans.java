package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegisteredType;

public class SicmedRegisteredPriceBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String id;

    private String typeName;

    private List<SicmedRegisteredPriceBean> sicmedRegisteredPriceBeans = new ArrayList<SicmedRegisteredPriceBean>();

    public List<SicmedRegisteredPriceBean> getSicmedRegisteredPriceBeans() {
        return sicmedRegisteredPriceBeans;
    }

    public void setSicmedRegisteredPriceBeans(List<SicmedRegisteredPriceBean> sicmedRegisteredPriceBeans) {
        this.sicmedRegisteredPriceBeans = sicmedRegisteredPriceBeans;
    }

    public void setSRTB(SicmedRegisteredType sicmedRegisteredType) {
        this.id = sicmedRegisteredType.getId();
        this.typeName = sicmedRegisteredType.getNameChina();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


}