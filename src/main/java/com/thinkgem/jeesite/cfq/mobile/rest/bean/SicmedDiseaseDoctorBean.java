package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDiseaseDoctor;

/**
 * 医生常用疾病表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedDiseaseDoctorBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private SicmedUserBean sicmedDoctorBean = new SicmedUserBean();        // 医生编号(对应医生表)

    private SicmedDiseaseClassBean sicmedDiseaseClassBean = new SicmedDiseaseClassBean();        // 疾病类别编号(对应疾病类别表)

    private SicmedDiseaseBean sicmedDiseaseBean = new SicmedDiseaseBean();        // 疾病编码(对应疾病编码)


    public void setSDD(SicmedDiseaseDoctor sicmedDiseaseDoctor) {
        if (sicmedDiseaseDoctor != null) {
            this.sicmedDoctorBean.setSUser(sicmedDiseaseDoctor.getSicmedDoctor());

            this.sicmedDiseaseBean.setSD(sicmedDiseaseDoctor.getSicmedDisease());

            this.sicmedDiseaseClassBean.setDC(sicmedDiseaseDoctor.getSicmedDiseaseClass());
        } else {
            super.setError("1");
            super.setErrorMessage("所查询的数据为空");
        }
    }


    public SicmedUserBean getSicmedDoctorBean() {
        return sicmedDoctorBean;
    }


    public void setSicmedDoctorBean(SicmedUserBean sicmedDoctorBean) {
        this.sicmedDoctorBean = sicmedDoctorBean;
    }


    public SicmedDiseaseClassBean getSicmedDiseaseClassBean() {
        return sicmedDiseaseClassBean;
    }


    public void setSicmedDiseaseClassBean(SicmedDiseaseClassBean sicmedDiseaseClassBean) {
        this.sicmedDiseaseClassBean = sicmedDiseaseClassBean;
    }


    public SicmedDiseaseBean getSicmedDiseaseBean() {
        return sicmedDiseaseBean;
    }


    public void setSicmedDiseaseBean(SicmedDiseaseBean sicmedDiseaseBean) {
        this.sicmedDiseaseBean = sicmedDiseaseBean;
    }

}