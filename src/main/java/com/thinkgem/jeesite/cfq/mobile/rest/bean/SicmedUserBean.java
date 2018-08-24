package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedUser;

public class SicmedUserBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String id;
    private String userNumber;                // 用户编码
    private String userName;                // 用户名称
    private String userTel;                // 用户名
    private String userJobGroup;            // 工作组
    private String userJobGrade;            // 工作等级
    private String doctorGrade;            // 医生等级
    private String doctorRegistered;        // 是否可挂号
    private String userStatus;

    private String ssid;

    public void setSUser(SicmedUser sicmedUser) {
        this.id = sicmedUser.getId();
        this.userNumber = sicmedUser.getUserNumber();
        this.userTel = sicmedUser.getUserTel();
        this.userJobGrade = sicmedUser.getUserJobGrade();
        this.userJobGroup = sicmedUser.getUserJobGroup();
        this.doctorGrade = sicmedUser.getDoctorGrade();
        this.doctorRegistered = sicmedUser.getDoctorRegistered();
        this.userStatus = sicmedUser.getUserStatus();
        this.userName = sicmedUser.getUserName();

    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public String getUserJobGroup() {
        return userJobGroup;
    }

    public void setUserJobGroup(String userJobGroup) {
        this.userJobGroup = userJobGroup;
    }

    public String getUserJobGrade() {
        return userJobGrade;
    }

    public void setUserJobGrade(String userJobGrade) {
        this.userJobGrade = userJobGrade;
    }

    public String getDoctorGrade() {
        return doctorGrade;
    }

    public void setDoctorGrade(String doctorGrade) {
        this.doctorGrade = doctorGrade;
    }

    public String getDoctorRegistered() {
        return doctorRegistered;
    }

    public void setDoctorRegistered(String doctorRegistered) {
        this.doctorRegistered = doctorRegistered;
    }

}
