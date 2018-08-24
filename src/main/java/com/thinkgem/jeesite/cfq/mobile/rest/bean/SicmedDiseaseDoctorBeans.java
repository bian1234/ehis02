package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 医生常用疾病表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedDiseaseDoctorBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    // private SicmedUserBean sicmedDoctorBean; // 医生编号(对应医生表)
    //
    // private SicmedDiseaseClassBean sicmedDiseaseClassBean; // 疾病类别编号(对应疾病类别表)
    //
    // private SicmedDiseaseBean sicmedDiseaseBean; // 疾病编码(对应疾病编码)

    private List<SicmedDiseaseDoctorBean> sicmedDiseaseDoctorBeans = new ArrayList<SicmedDiseaseDoctorBean>();

    public List<SicmedDiseaseDoctorBean> getSicmedDiseaseDoctorBeans() {
        return sicmedDiseaseDoctorBeans;
    }

    public void setSicmedDiseaseDoctorBeans(List<SicmedDiseaseDoctorBean> sicmedDiseaseDoctorBeans) {
        this.sicmedDiseaseDoctorBeans = sicmedDiseaseDoctorBeans;
    }

}