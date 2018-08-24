package com.thinkgem.jeesite.cfq.mobile.rest.bean;


import com.google.common.collect.Lists;

import java.util.List;

public class SicmedCureCheckBeans extends BaseBean {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private List<SicmedCureCheckBean> cureCheckBeanList = Lists.newArrayList();

    public List<SicmedCureCheckBean> getCureCheckBeanList() {
        return cureCheckBeanList;
    }

    public void setCureCheckBeanList(List<SicmedCureCheckBean> cureCheckBeanList) {
        this.cureCheckBeanList = cureCheckBeanList;
    }


}
