package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.List;

import com.google.common.collect.Lists;

public class SicmedInspectClassBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    private List<SicmedInspectClassBean> sicmedInspectClassBeans = Lists.newArrayList();

    public List<SicmedInspectClassBean> getSicmedInspectClassBeans() {
        return sicmedInspectClassBeans;
    }

    public void setSicmedInspectClassBeans(List<SicmedInspectClassBean> sicmedInspectClassBeans) {
        this.sicmedInspectClassBeans = sicmedInspectClassBeans;
    }

}
