package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;

import javax.validation.constraints.NotNull;


/**
 * 患者信息表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedPatient extends DataEntity<SicmedPatient> {

    private static final long serialVersionUID = 1L;
    private String patientNumber; // 患者编号
    private String patientName; // 患者名字
    private String patientSex; // 患者性别
    private Date patientBirthday; // 患者生日
    private String patientCard; // 患者身份证
    private Date patientFirstdate; // 患者第一次就诊时间
    private Date patientLastdate; // 患者最后一次就诊时间
    private String patientAddress; // 患者住址
    private String patientTel; // 患者电话
    private int patientAge; // 患者年龄
    private String medicareType; // 医保类型
    private String medicareNo; // 医保卡号
    private SicmedBranch sicmedBranch; // 就诊科室(对应科室表)
    private SicmedUser sicmedDoctor; // 诊疗医生(对应用户表)
    private List<SicmedRegistered> registeredList = Lists.newArrayList(); // 患者挂号数
    private List<SicmedPatientDisease> patientDiseaseList = Lists.newArrayList(); // 患者疾病
    private SicmedUser createUser;   //创建人(对应用户表)
    private SicmedUser updateUser;    //修改人(对应用户表)
    private SicmedUser deleteUser;    //删除人(对应用户表)

    private SicmedRegistered sicmedRegistered; //挂号对象

    private String copyTableName;    //对应新表名称

    private String ptSex; // 患者性别

    private String searchContent;

    public SicmedUser getDeleteUser() {
        return deleteUser;
    }

    public void setDeleteUser(SicmedUser deleteUser) {
        this.deleteUser = deleteUser;
    }

    public SicmedPatient() {
        super();
    }

    public SicmedPatient(String id) {
        super(id);
    }

    public SicmedUser getCreateUser() {
        return createUser;
    }

    public void setCreateUser(SicmedUser createUser) {
        this.createUser = createUser;
    }

    public SicmedUser getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(SicmedUser updateUser) {
        this.updateUser = updateUser;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    @Length(min = 0, max = 20, message = "患者编号长度必须介于 0 和 10 之间")
    public String getMedicareType() {
        return medicareType;
    }

    public void setMedicareType(String medicareType) {
        this.medicareType = medicareType;
    }

    @Length(min = 0, max = 100, message = "患者编号长度必须介于 0 和 10 之间")
    public String getMedicareNo() {
        return medicareNo;
    }

    public void setMedicareNo(String medicareNo) {
        this.medicareNo = medicareNo;
    }

    public SicmedRegistered getSicmedRegistered() {
        return sicmedRegistered;
    }

    public void setSicmedRegistered(SicmedRegistered sicmedRegistered) {
        this.sicmedRegistered = sicmedRegistered;
    }

    //	@Length(min = 0, max = 15, message = "患者编号长度必须介于 0 和 15 之间")
    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    @Length(min = 0, max = 20, message = "患者名字长度必须介于 0 和 20 之间")
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    @Length(min = 0, max = 1, message = "患者性别长度必须介于 0 和 1 之间")
    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	@NotNull(message = "患者生日不能为空")
    public Date getPatientBirthday() {
        return patientBirthday;
    }

    public void setPatientBirthday(Date patientBirthday) {
        this.patientBirthday = patientBirthday;
    }

    @Length(min = 0, max = 18, message = "患者身份证长度必须介于 0 和 18 之间")
    public String getPatientCard() {
        return patientCard;
    }

    public void setPatientCard(String patientCard) {
        this.patientCard = patientCard;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "患者第一次就诊时间不能为空")
    public Date getPatientFirstdate() {
        return patientFirstdate;
    }

    public void setPatientFirstdate(Date patientFirstdate) {
        this.patientFirstdate = patientFirstdate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "患者最后一次就诊时间不能为空")
    public Date getPatientLastdate() {
        return patientLastdate;
    }

    public void setPatientLastdate(Date patientLastdate) {
        this.patientLastdate = patientLastdate;
    }

    @Length(min = 0, max = 60, message = "患者住址长度必须介于 0 和 60 之间")
    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    @Length(min = 0, max = 14, message = "患者电话长度必须介于 0 和 14 之间")
    public String getPatientTel() {
        return patientTel;
    }

    public void setPatientTel(String patientTel) {
        this.patientTel = patientTel;
    }

    public SicmedBranch getSicmedBranch() {
        return sicmedBranch;
    }

    public void setSicmedBranch(SicmedBranch sicmedBranch) {
        this.sicmedBranch = sicmedBranch;
    }

    public SicmedUser getSicmedDoctor() {
        return sicmedDoctor;
    }

    public void setSicmedDoctor(SicmedUser sicmedDoctor) {
        this.sicmedDoctor = sicmedDoctor;
    }

    public List<SicmedRegistered> getRegisteredList() {
        return registeredList;
    }

    public void setRegisteredList(List<SicmedRegistered> registeredList) {
        this.registeredList = registeredList;
    }

    public List<SicmedPatientDisease> getPatientDiseaseList() {
        return patientDiseaseList;
    }

    public void setPatientDiseaseList(List<SicmedPatientDisease> patientDiseaseList) {
        this.patientDiseaseList = patientDiseaseList;
    }

    public String getCopyTableName() {
        return copyTableName;
    }

    public void setCopyTableName(String copyTableName) {
        this.copyTableName = copyTableName;
    }

    public String getPtSex() {
        return ptSex;
    }

    public void setPtSex(String ptSex) {
        this.ptSex = ptSex;
    }

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

}