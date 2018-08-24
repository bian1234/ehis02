package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.List;

import com.google.common.collect.Lists;

public class SicmedRegisteredTypeBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    private List<SicmedRegisteredTypeBean> sicmedRegisteredTypeBeans = Lists.newArrayList();

    public List<SicmedRegisteredTypeBean> getSicmedRegisteredTypeBeans() {
        return sicmedRegisteredTypeBeans;
    }

    public void setSicmedRegisteredTypeBeans(List<SicmedRegisteredTypeBean> sicmedRegisteredTypeBeans) {
        this.sicmedRegisteredTypeBeans = sicmedRegisteredTypeBeans;
    }


}