/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 患者信息表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedPatientBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    private List<SicmedPatientBean> sicmedPatientBeans = new ArrayList<SicmedPatientBean>();

    public List<SicmedPatientBean> getSicmedPatientBeans() {
        return sicmedPatientBeans;
    }

    public void setSicmedPatientBeans(List<SicmedPatientBean> sicmedPatientBeans) {
        this.sicmedPatientBeans = sicmedPatientBeans;
    }

}