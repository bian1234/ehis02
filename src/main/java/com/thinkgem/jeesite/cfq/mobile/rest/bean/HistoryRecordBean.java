package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatient;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegistered;

/**
 * @author Max
 * @version 2016-08-11
 */
public class HistoryRecordBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String sicmedPatientName;
    private int sicmedPatientAge;
    private String sicmedPatientSex;
    private String sicmedPatientId;
    private Date updateDate;

    private String unitPrice;
    private String clinicsFee;
    private String materialFee;
    private String registeredFee;

    public void setHRB(SicmedPatient sicmedPatient) {
        this.sicmedPatientId = sicmedPatient.getId();
        this.sicmedPatientAge = sicmedPatient.getPatientAge();
        this.sicmedPatientName = sicmedPatient.getPatientName();
        this.updateDate = sicmedPatient.getUpdateDate();

        if (sicmedPatient.getPatientSex() != null) {
            if (sicmedPatient.getPatientSex().equals("1")) {
                this.sicmedPatientSex = "男";
            } else if (sicmedPatient.getPatientSex().equals("0")) {
                this.sicmedPatientSex = "女";
            } else {
                this.sicmedPatientSex = sicmedPatient.getPatientSex();
            }
        }
    }

    public void setHRBByRegistered(SicmedRegistered sicmedRegistered) {

        this.sicmedPatientId = sicmedRegistered.getSicmedPatient().getId();
        this.sicmedPatientAge = sicmedRegistered.getSicmedPatient().getPatientAge();
        this.sicmedPatientName = sicmedRegistered.getSicmedPatient().getPatientName();
        this.updateDate = sicmedRegistered.getUpdateDate();
        this.sicmedPatientSex = sicmedRegistered.getSicmedPatient().getPatientSex();

        this.clinicsFee = sicmedRegistered.getSicmedRegistrationType().getSicmedRegisteredPrice().getClinicsFee();
        this.materialFee = sicmedRegistered.getSicmedRegistrationType().getSicmedRegisteredPrice().getMaterialFee();
        this.registeredFee = sicmedRegistered.getSicmedRegistrationType().getSicmedRegisteredPrice().getRegisteredFee();
        Double a = Double.parseDouble(clinicsFee);
        Double b = Double.parseDouble(materialFee);
        Double c = Double.parseDouble(registeredFee);
        Double d = a + b + c;
        this.unitPrice = d.toString();
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

    public String getRegisteredFee() {
        return registeredFee;
    }

    public void setRegisteredFee(String registeredFee) {
        this.registeredFee = registeredFee;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getUpdateDate() {
        return updateDate;
    }


    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


    public String getUnitPrice() {
        return unitPrice;
    }


    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }


    public String getSicmedPatientName() {
        return sicmedPatientName;
    }

    public void setSicmedPatientName(String sicmedPatientName) {
        this.sicmedPatientName = sicmedPatientName;
    }

    public int getSicmedPatientAge() {
        return sicmedPatientAge;
    }

    public void setSicmedPatientAge(int sicmedPatientAge) {
        this.sicmedPatientAge = sicmedPatientAge;
    }

    public String getSicmedPatientSex() {
        return sicmedPatientSex;
    }

    public void setSicmedPatientSex(String sicmedPatientSex) {
        this.sicmedPatientSex = sicmedPatientSex;
    }

    public String getSicmedPatientId() {
        return sicmedPatientId;
    }

    public void setSicmedPatientId(String sicmedPatientId) {
        this.sicmedPatientId = sicmedPatientId;
    }

}