package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Max
 * @version 2016-07-12
 */
public class SicmedHospitalBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    List<SicmedHospitalBean> sicmedHospitalBeans = new ArrayList<SicmedHospitalBean>();

    public List<SicmedHospitalBean> getSicmedHospitalBeans() {
        return sicmedHospitalBeans;
    }

    public void setSicmedHospitalBeans(List<SicmedHospitalBean> sicmedHospitalBeans) {
        this.sicmedHospitalBeans = sicmedHospitalBeans;
    }


}