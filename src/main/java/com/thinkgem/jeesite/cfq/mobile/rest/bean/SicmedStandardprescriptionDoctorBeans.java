package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;


/**
 * 医生常用疾病表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedStandardprescriptionDoctorBeans extends BaseBean {

    private static final long serialVersionUID = 1L;
    private SicmedUserBean sicmedUserBean;        // 医生编号(对应用户表)
    private SicmedAskedClassBean sicmedAskedClassBean;  //医嘱类型编号(对应医嘱类别表)
    private SicmedStanderprescriptionAskedBean standerprescriptionAskedBean;        // 标准处方中医嘱编号(对应标准处方中医嘱表)
    private SicmedStanderprescriptionDiseaseBean standerdprescriptionDiseaseBean;        // 标准处方中的疾病编码(对应标准处方中的疾病表)
    private List<SicmedStandardprescriptionDoctorBean> sicmedStandardprescriptionDoctorBeans = new ArrayList<SicmedStandardprescriptionDoctorBean>();

    public SicmedUserBean getSicmedUserBean() {
        return sicmedUserBean;
    }

    public void setSicmedUserBean(SicmedUserBean sicmedUserBean) {
        this.sicmedUserBean = sicmedUserBean;
    }

    public SicmedAskedClassBean getSicmedAskedClassBean() {
        return sicmedAskedClassBean;
    }

    public void setSicmedAskedClassBean(SicmedAskedClassBean sicmedAskedClassBean) {
        this.sicmedAskedClassBean = sicmedAskedClassBean;
    }

    public SicmedStanderprescriptionAskedBean getStanderprescriptionAskedBean() {
        return standerprescriptionAskedBean;
    }

    public void setStanderprescriptionAskedBean(SicmedStanderprescriptionAskedBean standerprescriptionAskedBean) {
        this.standerprescriptionAskedBean = standerprescriptionAskedBean;
    }

    public SicmedStanderprescriptionDiseaseBean getStanderdprescriptionDiseaseBean() {
        return standerdprescriptionDiseaseBean;
    }

    public void setStanderdprescriptionDiseaseBean(SicmedStanderprescriptionDiseaseBean standerdprescriptionDiseaseBean) {
        this.standerdprescriptionDiseaseBean = standerdprescriptionDiseaseBean;
    }

    public List<SicmedStandardprescriptionDoctorBean> getSicmedStandardprescriptionDoctorBeans() {
        return sicmedStandardprescriptionDoctorBeans;
    }

    public void setSicmedStandardprescriptionDoctorBeans(
            List<SicmedStandardprescriptionDoctorBean> sicmedStandardprescriptionDoctorBeans) {
        this.sicmedStandardprescriptionDoctorBeans = sicmedStandardprescriptionDoctorBeans;
    }

}