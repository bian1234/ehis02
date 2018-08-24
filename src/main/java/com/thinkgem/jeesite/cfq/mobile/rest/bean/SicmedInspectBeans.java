package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.List;

import com.google.common.collect.Lists;

public class SicmedInspectBeans extends BaseBean {

    private static final long serialVersionUID = 1L;
    private List<SicmedInspectBean> sicmedInspectBeans = Lists.newArrayList();

    public List<SicmedInspectBean> getSicmedInspectBeans() {
        return sicmedInspectBeans;
    }

    public void setSicmedInspectBeans(List<SicmedInspectBean> sicmedInspectBeans) {
        this.sicmedInspectBeans = sicmedInspectBeans;
    }

}
