package com.thinkgem.jeesite.cfq.mobile.rest.bean;


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStandardprescriptionDoctor;

/**
 * 医生常用疾病表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedStandardprescriptionDoctorBean extends BaseBean {

    private static final long serialVersionUID = 1L;
    private SicmedUserBean sicmedUserBean = new SicmedUserBean();        // 医生编号(对应用户表)
    private String prescriptionName;        // 处方名
    private String prescriptionNameEx;        // 处方名(扩展)
    private SicmedAskedClassBean sicmedAskedClassBean = new SicmedAskedClassBean();                // 医嘱类型编号(对应医嘱类别表)
//	private SicmedStanderprescriptionAskedBean standerprescriptionAskedBean = new SicmedStanderprescriptionAskedBean();		// 标准处方中医嘱编号(对应标准处方中医嘱表)
//	private SicmedStanderprescriptionDiseaseBean standerdprescriptionDiseaseBean = new SicmedStanderprescriptionDiseaseBean();		// 标准处方中的疾病编码(对应标准处方中的疾病表)

    public void setssd(SicmedStandardprescriptionDoctor ssd) {
        this.prescriptionName = ssd.getPrescriptionName();
        this.prescriptionNameEx = ssd.getPrescriptionNameEx();
        this.sicmedUserBean.setSUser(ssd.getSicmedUser());
        this.sicmedAskedClassBean.setSac(ssd.getAskedClass());
        //this.standerdprescriptionDiseaseBean.setssdb(ssd.getStanderprescriptionDisease());
        //this.standerprescriptionAskedBean.setssa(ssd.getStanderprescriptionAsked());
    }


    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
    }

    public String getPrescriptionNameEx() {
        return prescriptionNameEx;
    }

    public void setPrescriptionNameEx(String prescriptionNameEx) {
        this.prescriptionNameEx = prescriptionNameEx;
    }


}