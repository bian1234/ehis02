package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.List;

import com.google.common.collect.Lists;

public class SicmedTwxrayCheckBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    private List<SicmedTwxrayCheckBean> twxrayCheckBeanList = Lists.newArrayList();

    public List<SicmedTwxrayCheckBean> getTwxrayCheckBeanList() {
        return twxrayCheckBeanList;
    }

    public void setTwxrayCheckBeanList(List<SicmedTwxrayCheckBean> twxrayCheckBeanList) {
        this.twxrayCheckBeanList = twxrayCheckBeanList;
    }

}
