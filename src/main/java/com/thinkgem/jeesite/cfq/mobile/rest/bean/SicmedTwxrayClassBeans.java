package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.List;

import com.google.common.collect.Lists;

public class SicmedTwxrayClassBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    private List<SicmedTwxrayClassBean> sicmedTwxrayClassBeans = Lists.newArrayList();

    public List<SicmedTwxrayClassBean> getSicmedTwxrayClassBeans() {
        return sicmedTwxrayClassBeans;
    }

    public void setSicmedTwxrayClassBeans(List<SicmedTwxrayClassBean> sicmedTwxrayClassBeans) {
        this.sicmedTwxrayClassBeans = sicmedTwxrayClassBeans;
    }


}
