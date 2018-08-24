package com.thinkgem.jeesite.cfq.mobile.rest.bean;


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalUse;

/**
 * 病历打印信息 -处理
 *
 * @author Max
 */
public class CasePrintDealBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String name;
    private String dose;
    private String use;
    private String day;

    public void setCPDB(SicmedAsked sicmedAsked) {
        String classNumber = sicmedAsked.getSicmedAskedClass().getClassNumber();
        if (classNumber.equals("0")) {
            this.name = sicmedAsked.getAskedName();
            this.dose = "1";
            this.use = "";
            this.day = "1";
        } else if (classNumber.equals("1")) {
            this.name = sicmedAsked.getAskedName();
            this.dose = "1";
            this.use = "";
            this.day = "1";
        } else if (classNumber.equals("2")) {
            this.name = sicmedAsked.getAskedName();
            this.dose = "1";
            this.use = "";
            this.day = "1";
        } else if (classNumber.equals("3")) {
            SicmedMedicalUse sicmedMedicalUse = sicmedAsked.getSicmedMedicalUse();
            this.name = sicmedAsked.getAskedName();
            this.dose = "1" + sicmedMedicalUse.getUseBun();
            this.use = sicmedMedicalUse.getUseGroup();
            this.day = sicmedMedicalUse.getUseDay();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}