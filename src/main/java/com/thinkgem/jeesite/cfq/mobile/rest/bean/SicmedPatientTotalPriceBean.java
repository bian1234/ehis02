package com.thinkgem.jeesite.cfq.mobile.rest.bean;

public class SicmedPatientTotalPriceBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String checkTotalPrice;
    private String inspectTotalPrice;
    private String cureTotalPrice;
    private String medicalTotalPrice;

    private String registerPrice;

    private String totalPrice;

    public String getCheckTotalPrice() {
        return checkTotalPrice;
    }

    public void setCheckTotalPrice(String checkTotalPrice) {
        this.checkTotalPrice = checkTotalPrice;
    }

    public String getInspectTotalPrice() {
        return inspectTotalPrice;
    }

    public void setInspectTotalPrice(String inspectTotalPrice) {
        this.inspectTotalPrice = inspectTotalPrice;
    }

    public String getCureTotalPrice() {
        return cureTotalPrice;
    }

    public void setCureTotalPrice(String cureTotalPrice) {
        this.cureTotalPrice = cureTotalPrice;
    }

    public String getMedicalTotalPrice() {
        return medicalTotalPrice;
    }

    public void setMedicalTotalPrice(String medicalTotalPrice) {
        this.medicalTotalPrice = medicalTotalPrice;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getRegisterPrice() {
        return registerPrice;
    }

    public void setRegisterPrice(String registerPrice) {
        this.registerPrice = registerPrice;
    }


}
