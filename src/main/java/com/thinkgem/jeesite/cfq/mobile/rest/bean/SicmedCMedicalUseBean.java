package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalUse;

public class SicmedCMedicalUseBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String useTemperature;        //服药温度

    private String useType;                //服药方法

    private String useTime;                //服药时间

    private String useDose;                //服药剂量

    private String useNote;                //注意事项


    public void setSCMUB(SicmedMedicalUse sicmedCmedicalUse) {
        this.useTemperature = sicmedCmedicalUse.getRemarks();
        this.useType = sicmedCmedicalUse.getUseGroup();
        this.useTime = sicmedCmedicalUse.getUseBun();
        this.useDose = sicmedCmedicalUse.getUseAmount();
        this.useNote = sicmedCmedicalUse.getUseName();
    }


    public String getUseTemperature() {
        return useTemperature;
    }


    public void setUseTemperature(String useTemperature) {
        this.useTemperature = useTemperature;
    }


    public String getUseType() {
        return useType;
    }


    public void setUseType(String useType) {
        this.useType = useType;
    }


    public String getUseTime() {
        return useTime;
    }


    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }


    public String getUseDose() {
        return useDose;
    }


    public void setUseDose(String useDose) {
        this.useDose = useDose;
    }


    public String getUseNote() {
        return useNote;
    }


    public void setUseNote(String useNote) {
        this.useNote = useNote;
    }


}