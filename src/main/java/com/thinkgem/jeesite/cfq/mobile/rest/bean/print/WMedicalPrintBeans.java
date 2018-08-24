package com.thinkgem.jeesite.cfq.mobile.rest.bean.print;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedical;

public class WMedicalPrintBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String medicalCode;

    private String medicalName;

    private String medicalNumber;

    public void setMPB(SicmedMedical sicmedMedical) {
        this.medicalCode = sicmedMedical.getMedicalCode();
        this.medicalName = sicmedMedical.getMedicalNameChina();
        this.medicalNumber = "1";
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

    public String getMedicalNumber() {
        return medicalNumber;
    }

    public void setMedicalNumber(String medicalNumber) {
        this.medicalNumber = medicalNumber;
    }


}