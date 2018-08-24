package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.List;

import com.google.common.collect.Lists;

public class SicmedCureClassBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    private List<SicmedCureClassBean> sicmedCureClassBeans = Lists.newArrayList();

    public List<SicmedCureClassBean> getSicmedCureClassBeans() {
        return sicmedCureClassBeans;
    }

    public void setSicmedCureClassBeans(List<SicmedCureClassBean> sicmedCureClassBeans) {
        this.sicmedCureClassBeans = sicmedCureClassBeans;
    }

}
