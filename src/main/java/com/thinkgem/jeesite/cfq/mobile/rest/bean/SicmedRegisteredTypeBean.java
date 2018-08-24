package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegisteredType;

public class SicmedRegisteredTypeBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String id;

    private String typeName;

    private SicmedRegisteredPriceBean sicmedRegisteredPriceBean = new SicmedRegisteredPriceBean();

    public void setSRTB(SicmedRegisteredType sicmedRegisteredType) {
        this.id = sicmedRegisteredType.getId();
        this.typeName = sicmedRegisteredType.getNameChina();
        this.sicmedRegisteredPriceBean.setSRPB(sicmedRegisteredType.getSicmedRegisteredPrice());
    }

    public SicmedRegisteredPriceBean getSicmedRegisteredPriceBean() {
        return sicmedRegisteredPriceBean;
    }

    public void setSicmedRegisteredPriceBean(SicmedRegisteredPriceBean sicmedRegisteredPriceBean) {
        this.sicmedRegisteredPriceBean = sicmedRegisteredPriceBean;
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