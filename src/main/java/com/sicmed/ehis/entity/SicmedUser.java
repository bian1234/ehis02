package com.sicmed.ehis.entity;

import java.util.Date;

public class SicmedUser {
    private String id;

    private String userNumber;

    private String userName;

    private String password;

    private Date userFodate;

    private Date userTodate;

    private String userJobGroup;

    private String userJobGrade;

    private String userBranch;

    private String doctorCode;

    private String doctorGrade;

    private Integer printranking;

    private Integer doctorRegisteredAm;

    private Integer doctorRegisteredPm;

    private String doctorRegistered;

    private String registeredDifference;

    private Date loginDate;

    private String license;

    private String licenseSpc;

    private String userTel;

    private String userEmail;

    private String userStatus;

    private Date changeFdate;

    private Date changeOdate;

    private String doctorBranch1;

    private String doctorBranch2;

    private String doctorBranch3;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    private byte[] userDept;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber == null ? null : userNumber.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getUserFodate() {
        return userFodate;
    }

    public void setUserFodate(Date userFodate) {
        this.userFodate = userFodate;
    }

    public Date getUserTodate() {
        return userTodate;
    }

    public void setUserTodate(Date userTodate) {
        this.userTodate = userTodate;
    }

    public String getUserJobGroup() {
        return userJobGroup;
    }

    public void setUserJobGroup(String userJobGroup) {
        this.userJobGroup = userJobGroup == null ? null : userJobGroup.trim();
    }

    public String getUserJobGrade() {
        return userJobGrade;
    }

    public void setUserJobGrade(String userJobGrade) {
        this.userJobGrade = userJobGrade == null ? null : userJobGrade.trim();
    }

    public String getUserBranch() {
        return userBranch;
    }

    public void setUserBranch(String userBranch) {
        this.userBranch = userBranch == null ? null : userBranch.trim();
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode == null ? null : doctorCode.trim();
    }

    public String getDoctorGrade() {
        return doctorGrade;
    }

    public void setDoctorGrade(String doctorGrade) {
        this.doctorGrade = doctorGrade == null ? null : doctorGrade.trim();
    }

    public Integer getPrintranking() {
        return printranking;
    }

    public void setPrintranking(Integer printranking) {
        this.printranking = printranking;
    }

    public Integer getDoctorRegisteredAm() {
        return doctorRegisteredAm;
    }

    public void setDoctorRegisteredAm(Integer doctorRegisteredAm) {
        this.doctorRegisteredAm = doctorRegisteredAm;
    }

    public Integer getDoctorRegisteredPm() {
        return doctorRegisteredPm;
    }

    public void setDoctorRegisteredPm(Integer doctorRegisteredPm) {
        this.doctorRegisteredPm = doctorRegisteredPm;
    }

    public String getDoctorRegistered() {
        return doctorRegistered;
    }

    public void setDoctorRegistered(String doctorRegistered) {
        this.doctorRegistered = doctorRegistered == null ? null : doctorRegistered.trim();
    }

    public String getRegisteredDifference() {
        return registeredDifference;
    }

    public void setRegisteredDifference(String registeredDifference) {
        this.registeredDifference = registeredDifference == null ? null : registeredDifference.trim();
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license == null ? null : license.trim();
    }

    public String getLicenseSpc() {
        return licenseSpc;
    }

    public void setLicenseSpc(String licenseSpc) {
        this.licenseSpc = licenseSpc == null ? null : licenseSpc.trim();
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    public Date getChangeFdate() {
        return changeFdate;
    }

    public void setChangeFdate(Date changeFdate) {
        this.changeFdate = changeFdate;
    }

    public Date getChangeOdate() {
        return changeOdate;
    }

    public void setChangeOdate(Date changeOdate) {
        this.changeOdate = changeOdate;
    }

    public String getDoctorBranch1() {
        return doctorBranch1;
    }

    public void setDoctorBranch1(String doctorBranch1) {
        this.doctorBranch1 = doctorBranch1 == null ? null : doctorBranch1.trim();
    }

    public String getDoctorBranch2() {
        return doctorBranch2;
    }

    public void setDoctorBranch2(String doctorBranch2) {
        this.doctorBranch2 = doctorBranch2 == null ? null : doctorBranch2.trim();
    }

    public String getDoctorBranch3() {
        return doctorBranch3;
    }

    public void setDoctorBranch3(String doctorBranch3) {
        this.doctorBranch3 = doctorBranch3 == null ? null : doctorBranch3.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public byte[] getUserDept() {
        return userDept;
    }

    public void setUserDept(byte[] userDept) {
        this.userDept = userDept;
    }
}