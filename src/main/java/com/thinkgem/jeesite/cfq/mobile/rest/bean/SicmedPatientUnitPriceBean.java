package com.thinkgem.jeesite.cfq.mobile.rest.bean;

public class SicmedPatientUnitPriceBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private SicmedTwxrayCheckBean sicmedTwxrayCheckBean;
    private SicmedInspectBean sicmedInspectBean;
    private SicmedCureCheckBean sicmedCureCheckBean;
    private SicmedMedicalBean sicmedMedicalBean;
    private SicmedRegisteredBean sicmedRegisteredBean;

    private String checkPrice;
    private String inspectPrice;
    private String curePrice;
    private String medicalPrice;
    private String registerPrice;


    private String priceId;

    public SicmedTwxrayCheckBean getSicmedTwxrayCheckBean() {
        return sicmedTwxrayCheckBean;
    }

    public void setSicmedTwxrayCheckBean(SicmedTwxrayCheckBean sicmedTwxrayCheckBean) {
        this.sicmedTwxrayCheckBean = sicmedTwxrayCheckBean;
    }

    public SicmedInspectBean getSicmedInspectBean() {
        return sicmedInspectBean;
    }

    public void setSicmedInspectBean(SicmedInspectBean sicmedInspectBean) {
        this.sicmedInspectBean = sicmedInspectBean;
    }

    public SicmedCureCheckBean getSicmedCureCheckBean() {
        return sicmedCureCheckBean;
    }

    public void setSicmedCureCheckBean(SicmedCureCheckBean sicmedCureCheckBean) {
        this.sicmedCureCheckBean = sicmedCureCheckBean;
    }

    public SicmedMedicalBean getSicmedMedicalBean() {
        return sicmedMedicalBean;
    }

    public void setSicmedMedicalBean(SicmedMedicalBean sicmedMedicalBean) {
        this.sicmedMedicalBean = sicmedMedicalBean;
    }

    public SicmedRegisteredBean getSicmedRegisteredBean() {
        return sicmedRegisteredBean;
    }

    public void setSicmedRegisteredBean(SicmedRegisteredBean sicmedRegisteredBean) {
        this.sicmedRegisteredBean = sicmedRegisteredBean;
    }

    public String getCheckPrice() {
        return checkPrice;
    }

    public void setCheckPrice(String checkPrice) {
        this.checkPrice = checkPrice;
    }

    public String getInspectPrice() {
        return inspectPrice;
    }

    public void setInspectPrice(String inspectPrice) {
        this.inspectPrice = inspectPrice;
    }

    public String getCurePrice() {
        return curePrice;
    }

    public void setCurePrice(String curePrice) {
        this.curePrice = curePrice;
    }

    public String getMedicalPrice() {
        return medicalPrice;
    }

    public void setMedicalPrice(String medicalPrice) {
        this.medicalPrice = medicalPrice;
    }

    public String getRegisterPrice() {
        return registerPrice;
    }

    public void setRegisterPrice(String registerPrice) {
        this.registerPrice = registerPrice;
    }

    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }


}
