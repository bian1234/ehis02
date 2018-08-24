package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;

public class SicmedPatientUnitPriceBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    private List<SicmedPatientUnitPriceBean> sicmedPatientUnitPriceBeans = new ArrayList<SicmedPatientUnitPriceBean>();

    private String checkNo;
    private String inspectNo;
    private String cureNo;
    private String medicalNo;

    private String totalCheckPrice;
    private String totalInspectPrice;
    private String totalCurePrice;
    private String totalMedicalPrice;

    private SicmedPatientBean sicmedPatientBean;
    private SicmedRegisteredBean sicmedRegisteredBean;

    public List<SicmedPatientUnitPriceBean> getSicmedPatientUnitPriceBeans() {
        return sicmedPatientUnitPriceBeans;
    }

    public void setSicmedPatientUnitPriceBeans(List<SicmedPatientUnitPriceBean> sicmedPatientUnitPriceBeans) {
        this.sicmedPatientUnitPriceBeans = sicmedPatientUnitPriceBeans;
    }

    public String getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(String checkNo) {
        this.checkNo = checkNo;
    }

    public String getInspectNo() {
        return inspectNo;
    }

    public void setInspectNo(String inspectNo) {
        this.inspectNo = inspectNo;
    }

    public String getCureNo() {
        return cureNo;
    }

    public void setCureNo(String cureNo) {
        this.cureNo = cureNo;
    }

    public String getMedicalNo() {
        return medicalNo;
    }

    public void setMedicalNo(String medicalNo) {
        this.medicalNo = medicalNo;
    }

    public String getTotalCheckPrice() {
        return totalCheckPrice;
    }

    public void setTotalCheckPrice(String totalCheckPrice) {
        this.totalCheckPrice = totalCheckPrice;
    }

    public String getTotalInspectPrice() {
        return totalInspectPrice;
    }

    public void setTotalInspectPrice(String totalInspectPrice) {
        this.totalInspectPrice = totalInspectPrice;
    }

    public String getTotalCurePrice() {
        return totalCurePrice;
    }

    public void setTotalCurePrice(String totalCurePrice) {
        this.totalCurePrice = totalCurePrice;
    }

    public String getTotalMedicalPrice() {
        return totalMedicalPrice;
    }

    public void setTotalMedicalPrice(String totalMedicalPrice) {
        this.totalMedicalPrice = totalMedicalPrice;
    }

    public SicmedPatientBean getSicmedPatientBean() {
        return sicmedPatientBean;
    }

    public void setSicmedPatientBean(SicmedPatientBean sicmedPatientBean) {
        this.sicmedPatientBean = sicmedPatientBean;
    }

    public SicmedRegisteredBean getSicmedRegisteredBean() {
        return sicmedRegisteredBean;
    }

    public void setSicmedRegisteredBean(SicmedRegisteredBean sicmedRegisteredBean) {
        this.sicmedRegisteredBean = sicmedRegisteredBean;
    }


}
