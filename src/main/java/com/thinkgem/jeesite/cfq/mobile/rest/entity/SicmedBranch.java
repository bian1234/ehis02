package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import java.util.List;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;

import com.google.common.collect.Lists;

/**
 * 科室信息表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedBranch extends DataEntity<SicmedBranch> {

    private static final long serialVersionUID = 1L;
    private String branchCode;        // 科室编码
    private String branchNumber;        // 科室等级
    private String branchName;        // 科室名称
    private String branchNameEnglish;        // 科室英文名称
    private String branchLocation;        // 科室所在物理位置
    private String branchRegistered;        // 是否可挂号
    private String branchRegisteredAm;        // 上午挂号人数
    private String branchRegisteredPm;        // 下午挂号人数
    private String branchIpd;        // 是否为住院科室

    private String registeredType; //是否挂号(0.未挂号 1.挂号 )
    private String ipdType; //是否住院(0.否 1.是)

    private List<SicmedUser> userList = Lists.newArrayList(); // 拥有人员
    private List<SicmedPatient> patientList = Lists.newArrayList(); // 就诊患者
    private List<SicmedPatientDisease> patientDiseaseList = Lists.newArrayList(); // 患者疾病

    public SicmedBranch() {
        super();
    }

    public SicmedBranch(String id) {
        super(id);
    }

    @Length(min = 0, max = 20, message = "科室编码长度必须介于 0 和 4 之间")
    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getRegisteredType() {
        if (registeredType != null || branchRegistered == null) {
            return registeredType;
        }
        switch (Integer.valueOf(this.getBranchRegistered())) {
            case 0:
                this.setRegisteredType("不可挂号");
                break;
            case 1:
                this.setRegisteredType("可挂号");
                break;
            default:
                break;
        }
        return registeredType;
    }

    public String getIpdType() {
        if (ipdType != null || branchIpd == null) {
            return ipdType;
        }
        switch (Integer.valueOf(this.getBranchIpd())) {
            case 0:
                this.setIpdType("否");
                break;
            case 1:
                this.setIpdType("是");
            default:
                break;
        }
        return ipdType;
    }

    public void setIpdType(String ipdType) {
        this.ipdType = ipdType;
    }

    public void setRegisteredType(String registeredType) {
        this.registeredType = registeredType;
    }

    @Length(min = 0, max = 3, message = "科室排序长度必须介于 0 和 3 之间")
    public String getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(String branchNumber) {
        this.branchNumber = branchNumber;
    }

    @Length(min = 0, max = 30, message = "科室名称长度必须介于 0 和 30 之间")
    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Length(min = 0, max = 50, message = "科室英文名称长度必须介于 0 和 50 之间")
    public String getBranchNameEnglish() {
        return branchNameEnglish;
    }

    public void setBranchNameEnglish(String branchNameEnglish) {
        this.branchNameEnglish = branchNameEnglish;
    }

    @Length(min = 0, max = 60, message = "科室所在物理位置长度必须介于 0 和 60 之间")
    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    @Length(min = 0, max = 1, message = "是否可挂号长度必须介于 0 和 1 之间")
    public String getBranchRegistered() {
        return branchRegistered;
    }

    public void setBranchRegistered(String branchRegistered) {
        this.branchRegistered = branchRegistered;
    }

    @Length(min = 0, max = 20, message = "上午挂号人数长度必须介于 0 和 3 之间")
    public String getBranchRegisteredAm() {
        return branchRegisteredAm;
    }

    public void setBranchRegisteredAm(String branchRegisteredAm) {
        this.branchRegisteredAm = branchRegisteredAm;
    }

    @Length(min = 0, max = 20, message = "下午挂号人数长度必须介于 0 和 3 之间")
    public String getBranchRegisteredPm() {
        return branchRegisteredPm;
    }

    public void setBranchRegisteredPm(String branchRegisteredPm) {
        this.branchRegisteredPm = branchRegisteredPm;
    }

    @Length(min = 0, max = 1, message = "是否为住院科室长度必须介于 0 和 1 之间")
    public String getBranchIpd() {
        return branchIpd;
    }

    public void setBranchIpd(String branchIpd) {
        this.branchIpd = branchIpd;
    }

    public List<SicmedUser> getUserList() {
        return userList;
    }

    public void setUserList(List<SicmedUser> userList) {
        this.userList = userList;
    }

    public List<SicmedPatient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<SicmedPatient> patientList) {
        this.patientList = patientList;
    }

    public List<SicmedPatientDisease> getPatientDiseaseList() {
        return patientDiseaseList;
    }

    public void setPatientDiseaseList(List<SicmedPatientDisease> patientDiseaseList) {
        this.patientDiseaseList = patientDiseaseList;
    }

}