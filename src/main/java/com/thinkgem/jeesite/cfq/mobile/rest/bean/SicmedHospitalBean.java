/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedHospital;

/**
 * 科室信息表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedHospitalBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String hospitalId; // hospital_id
    private String hospitalName; // hospital_name
    private String hospitalGrade; // hospital_grade
    private String hospitalAdd; // hospital_add
    // private String cityCode; // city_code
    private SicmedCityBean sicmedCityBean = new SicmedCityBean(); // city_code

    public void setSHB(SicmedHospital sicmedHospital) {
        if (sicmedHospital != null) {
            this.hospitalId = sicmedHospital.getHospitalId();
            this.hospitalName = sicmedHospital.getHospitalName();
            this.hospitalGrade = sicmedHospital.getHospitalGrade();
            this.hospitalAdd = sicmedHospital.getHospitalAdd();
            if (sicmedHospital.getSicmedCity() != null) {
                this.sicmedCityBean.setSCB(sicmedHospital.getSicmedCity());
            }
        }
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalGrade() {
        return hospitalGrade;
    }

    public void setHospitalGrade(String hospitalGrade) {
        this.hospitalGrade = hospitalGrade;
    }

    public String getHospitalAdd() {
        return hospitalAdd;
    }

    public void setHospitalAdd(String hospitalAdd) {
        this.hospitalAdd = hospitalAdd;
    }

    public SicmedCityBean getSicmedCityBean() {
        return sicmedCityBean;
    }

    public void setSicmedCityBean(SicmedCityBean sicmedCityBean) {
        this.sicmedCityBean = sicmedCityBean;
    }

}