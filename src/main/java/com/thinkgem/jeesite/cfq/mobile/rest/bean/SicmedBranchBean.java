/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedBranch;

/**
 * 科室信息表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedBranchBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String id;
    private String branchCode;        // 科室编码
    private String branchNumber;        // 科室排序
    private String branchName;        // 科室名称
    private String branchNameEnglish;        // 科室英文名称
    private String branchLocation;        // 科室所在物理位置
    private String branchRegistered;        // 是否可挂号
    private String branchRegisteredAm;        // 上午挂号人数
    private String branchRegisteredPm;        // 下午挂号人数
    private String branchIpd;        // 是否为住院科室
//	private List<SicmedUser> userList = Lists.newArrayList(); // 拥有人员
//	private List<SicmedPatient> patientList = Lists.newArrayList(); // 就诊患者

    public void setSB(SicmedBranch sicmedBranch) {
        if (sicmedBranch != null) {
            this.id = sicmedBranch.getId();
            this.branchCode = sicmedBranch.getBranchCode();
            this.branchNumber = sicmedBranch.getBranchNumber();
            this.branchName = sicmedBranch.getBranchName();
            this.branchNameEnglish = sicmedBranch.getBranchNameEnglish();
            this.branchLocation = sicmedBranch.getBranchLocation();
            this.branchRegistered = sicmedBranch.getBranchRegistered();
            this.branchRegisteredAm = sicmedBranch.getBranchRegisteredAm();
            this.branchRegisteredPm = sicmedBranch.getBranchRegisteredPm();
            this.branchIpd = sicmedBranch.getBranchIpd();
        } else {
            super.setError("1");
            super.setErrorMessage("所查询的数据为空");
        }
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(String branchNumber) {
        this.branchNumber = branchNumber;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchNameEnglish() {
        return branchNameEnglish;
    }

    public void setBranchNameEnglish(String branchNameEnglish) {
        this.branchNameEnglish = branchNameEnglish;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    public String getBranchRegistered() {
        return branchRegistered;
    }

    public void setBranchRegistered(String branchRegistered) {
        this.branchRegistered = branchRegistered;
    }

    public String getBranchRegisteredAm() {
        return branchRegisteredAm;
    }

    public void setBranchRegisteredAm(String branchRegisteredAm) {
        this.branchRegisteredAm = branchRegisteredAm;
    }

    public String getBranchRegisteredPm() {
        return branchRegisteredPm;
    }

    public void setBranchRegisteredPm(String branchRegisteredPm) {
        this.branchRegisteredPm = branchRegisteredPm;
    }

    public String getBranchIpd() {
        return branchIpd;
    }

    public void setBranchIpd(String branchIpd) {
        this.branchIpd = branchIpd;
    }


}