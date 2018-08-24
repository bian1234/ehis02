package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegisteredPrice;

public class SicmedRegisteredPriceBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String registeredFee;
    private String clinicsFee;
    private String materialFee;

    public void setSRPB(SicmedRegisteredPrice sicmedRegisteredPrice) {
        this.registeredFee = sicmedRegisteredPrice.getRegisteredFee();
        this.clinicsFee = sicmedRegisteredPrice.getClinicsFee();
        this.materialFee = sicmedRegisteredPrice.getMaterialFee();
    }

    public String getRegisteredFee() {
        return registeredFee;
    }

    public void setRegisteredFee(String registeredFee) {
        this.registeredFee = registeredFee;
    }

    public String getClinicsFee() {
        return clinicsFee;
    }

    public void setClinicsFee(String clinicsFee) {
        this.clinicsFee = clinicsFee;
    }

    public String getMaterialFee() {
        return materialFee;
    }

    public void setMaterialFee(String materialFee) {
        this.materialFee = materialFee;
    }


}