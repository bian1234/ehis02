package com.thinkgem.jeesite.cfq.mobile.rest.bean.print;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedRegisteredBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedBranch;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatient;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegistered;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedUser;

/**
 * @author Max
 */
public class RegisteredPrintBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private SicmedPatientBean sicmedPatientBean;

    private SicmedRegisteredBean sicmedRegisteredBean;

    private String patientName;

    private String patientNumber;

    private String branchName;

    private String branchLocation;

    private String doctorName;

    private String number;

    private String date;

    private String price;

    private String money;

    private String registeredName;

    private String registeredTime;

    public void setRPB(SicmedPatient sicmedPatient) {
        this.patientName = sicmedPatient.getPatientName();
        this.patientNumber = sicmedPatient.getPatientNumber();
    }

    public void setRPB(SicmedBranch sicmedBranch) {
        this.branchName = sicmedBranch.getBranchName();
        this.branchLocation = sicmedBranch.getBranchLocation();
    }

    public void setRPB(SicmedRegistered sicmedRegistered) {
        this.number = sicmedRegistered.getId();
        this.date = sicmedRegistered.getRegisteredBeginDate().toString();
        this.price = sicmedRegistered.getRegisteredPric();
        this.money = sicmedRegistered.getRegisteredPric();
        this.registeredName = sicmedRegistered.getCreateUser().getUserName();
        this.registeredTime = sicmedRegistered.getCreateDate().toString();
    }

    public void setRPB(SicmedUser sicmedUser) {
        this.doctorName = sicmedUser.getUserName();
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

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getRegisteredName() {
        return registeredName;
    }

    public void setRegisteredName(String registeredName) {
        this.registeredName = registeredName;
    }

    public String getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(String registeredTime) {
        this.registeredTime = registeredTime;
    }

}