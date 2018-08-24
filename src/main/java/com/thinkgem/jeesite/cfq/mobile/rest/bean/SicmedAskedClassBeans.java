/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;

public class SicmedAskedClassBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    private List<SicmedAskedClassBean> sicmedAskedClassBeans = new ArrayList<SicmedAskedClassBean>();

    public List<SicmedAskedClassBean> getSicmedAskedClassBeans() {
        return sicmedAskedClassBeans;
    }

    public void setSicmedAskedClassBeans(List<SicmedAskedClassBean> sicmedAskedClassBeans) {
        this.sicmedAskedClassBeans = sicmedAskedClassBeans;
    }

}