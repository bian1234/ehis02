package com.thinkgem.jeesite.cfq.mobile.rest.bean.print;

import java.util.List;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatient;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatientPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AmountTransferredCapitalUtils;

public class RefundsPrintBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String patientName;

    private String patientSex;

    private int patientAge;

    private String priceUserName;

    private String priceTime;

    private String priceLower;

    private String pricUper;

    private List<RefundsPrintBean> refundsPrintBeans = Lists.newArrayList();

    public void setTPB(SicmedPatientPrice sicmedPatientPrice) {
        this.priceUserName = sicmedPatientPrice.getCreateUser().getUserName();
        this.priceTime = sicmedPatientPrice.getCreateDate().toString();
    }

    public void setTPB(SicmedPatient sicmedPatient) {
        this.patientName = sicmedPatient.getPatientName();
        this.patientSex = sicmedPatient.getPatientSex();
        this.patientAge = sicmedPatient.getPatientAge();
    }

    public String getPriceLower() {
        return priceLower;
    }

    public void setPriceLower(Double priceLower) {

        this.priceLower = priceLower.toString();
    }

    public String getPricUper() {
        return pricUper;
    }

    public void setPricUper(double pricUper) {
        this.pricUper = AmountTransferredCapitalUtils.change(pricUper);
    }

    public List<RefundsPrintBean> getRefundsPrintBeans() {
        return refundsPrintBeans;
    }

    public void setRefundsPrintBeans(List<RefundsPrintBean> refundsPrintBeans) {
        this.refundsPrintBeans = refundsPrintBeans;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getPriceUserName() {
        return priceUserName;
    }

    public void setPriceUserName(String priceUserName) {
        this.priceUserName = priceUserName;
    }

    public String getPriceTime() {
        return priceTime;
    }

    public void setPriceTime(String priceTime) {
        this.priceTime = priceTime;
    }

    public void setPricUper(String pricUper) {
        this.pricUper = pricUper;
    }
}