package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalAsked;

public class SicmedMedicalAskedBean extends BaseBean {

    private static final long serialVersionUID = 1L;
    private String medicalCode;        // 药品编号(对应药品表的编号)
    private String askedCode;        // 医嘱编号(对应医嘱表数据)

    public void setSicmedMedicalAsked(SicmedMedicalAsked medicalAsked) {

        if (medicalAsked != null) {
            this.medicalCode = medicalAsked.getMedicalCode();
            this.askedCode = medicalAsked.getAskedCode();
        }

    }

    public String getMedicalCode() {
        return medicalCode;
    }

    public void setMedicalCode(String medicalCode) {
        this.medicalCode = medicalCode;
    }

    public String getAskedCode() {
        return askedCode;
    }

    public void setAskedCode(String askedCode) {
        this.askedCode = askedCode;
    }

}
