/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 科室信息表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedCityBeans extends BaseBean {

    private static final long serialVersionUID = 1L;
    List<SicmedCityBean> SicmedCityBeans = new ArrayList<SicmedCityBean>();

    public List<SicmedCityBean> getSicmedCityBeans() {
        return SicmedCityBeans;
    }

    public void setSicmedCityBeans(List<SicmedCityBean> sicmedCityBeans) {
        SicmedCityBeans = sicmedCityBeans;
    }

}