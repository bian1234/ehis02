package com.thinkgem.jeesite.cfq.mobile.rest.bean.print;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedAskedBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalPriceBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalUseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientPriceBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedical;

public class MedicalPrintBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String medicalCode;

    private String medicalName;

    private String medicalStand;

    private String medicalTraits;

    private String medicalTotalPrice;  //此类药品总价

    private SicmedMedicalUseBean sicmedMedicalUseBean;
    private SicmedMedicalPriceBean sicmedMedicalPriceBean;
    private SicmedAskedBean sicmedAskedBean;
    private SicmedPatientPriceBean sicmedPatientPriceBean;

    public void setMPB(SicmedMedical sicmedMedical) {
        this.medicalCode = sicmedMedical.getMedicalCode();
        this.medicalName = sicmedMedical.getMedicalNameChina();
        this.medicalStand = sicmedMedical.getMedicalStand();
        this.medicalTraits = sicmedMedical.getMedicalTraits();
    }

    public String getMedicalCode() {
        return medicalCode;
    }

    public void setMedicalCode(String medicalCode) {
        this.medicalCode = medicalCode;
    }

    public String getMedicalName() {
        return medicalName;
    }

    public void setMedicalName(String medicalName) {
        this.medicalName = medicalName;
    }

    public SicmedMedicalUseBean getSicmedMedicalUseBean() {
        return sicmedMedicalUseBean;
    }

    public void setSicmedMedicalUseBean(SicmedMedicalUseBean sicmedMedicalUseBean) {
        this.sicmedMedicalUseBean = sicmedMedicalUseBean;
    }

    public SicmedMedicalPriceBean getSicmedMedicalPriceBean() {
        return sicmedMedicalPriceBean;
    }

    public void setSicmedMedicalPriceBean(SicmedMedicalPriceBean sicmedMedicalPriceBean) {
        this.sicmedMedicalPriceBean = sicmedMedicalPriceBean;
    }

    public SicmedAskedBean getSicmedAskedBean() {
        return sicmedAskedBean;
    }

    public void setSicmedAskedBean(SicmedAskedBean sicmedAskedBean) {
        this.sicmedAskedBean = sicmedAskedBean;
    }

    public SicmedPatientPriceBean getSicmedPatientPriceBean() {
        return sicmedPatientPriceBean;
    }

    public void setSicmedPatientPriceBean(SicmedPatientPriceBean sicmedPatientPriceBean) {
        this.sicmedPatientPriceBean = sicmedPatientPriceBean;
    }

    public String getMedicalStand() {
        return medicalStand;
    }

    public void setMedicalStand(String medicalStand) {
        this.medicalStand = medicalStand;
    }

    public String getMedicalTraits() {
        return medicalTraits;
    }

    public void setMedicalTraits(String medicalTraits) {
        this.medicalTraits = medicalTraits;
    }

    public String getMedicalTotalPrice() {
        return medicalTotalPrice;
    }

    public void setMedicalTotalPrice(String medicalTotalPrice) {
        this.medicalTotalPrice = medicalTotalPrice;
    }


}