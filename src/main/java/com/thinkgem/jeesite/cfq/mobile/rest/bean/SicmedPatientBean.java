/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatient;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegistered;

/**
 * 患者信息表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedPatientBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String id;
    private String patientNumber; // 患者编号
    private String patientName; // 患者名字
    private String patientSex; // 患者性别
    private int patientAge;
    private String medicareNo;
    private String medicareType;
    private Date patientBirthday; // 患者生日
    private String patientCard; // 患者身份证
    private Date patientFirstdate; // 患者第一次就诊时间
    private Date patientLastdate; // 患者最后一次就诊时间
    private String patientAddress; // 患者住址
    private String patientTel; // 患者电话

    //private SicmedRegisteredBean patientRegisteredBean;		// 挂号对象（2016/11/23 丁学志）

//	private SicmedBranchBean sicmedBranchBean; // 就诊科室(对应科室表)
//	private SicmedUserBean sicmedDoctorBean; // 诊疗医生(对应用户表)
//	private SicmedUserBean createUserBean; // 创建医生(对应用户表)
//	private SicmedUserBean updateUserBean; //修改医生(对应医生表)
    // private List<SicmedRegistered> registeredList = Lists.newArrayList(); //
    // 患者挂号数

    public void setSP(SicmedPatient sicmedPatient) {
        if (sicmedPatient != null) {
            this.id = sicmedPatient.getId();
            this.patientNumber = sicmedPatient.getPatientNumber();
            this.patientName = sicmedPatient.getPatientName();
            this.patientSex = sicmedPatient.getPatientSex();
            this.patientAge = sicmedPatient.getPatientAge();
            this.medicareNo = sicmedPatient.getMedicareNo();
            this.medicareType = sicmedPatient.getMedicareType();
            this.patientBirthday = sicmedPatient.getPatientBirthday();
            this.patientCard = sicmedPatient.getPatientCard();
            this.patientFirstdate = sicmedPatient.getPatientFirstdate();
            this.patientLastdate = sicmedPatient.getPatientLastdate();
            this.patientAddress = sicmedPatient.getPatientAddress();
            this.patientTel = sicmedPatient.getPatientTel();
            if (sicmedPatient.getSicmedBranch() != null) {

//				this.sicmedBranchBean.setSB(sicmedPatient.getSicmedBranch());
            }
            if (sicmedPatient.getSicmedDoctor() != null) {

//				this.sicmedDoctorBean.setSUser(sicmedPatient.getSicmedDoctor());
            }
            if (sicmedPatient.getCreateUser() != null) {
//				this.createUserBean.setSUser(sicmedPatient.getCreateUser());
            }
            if (sicmedPatient.getUpdateUser() != null) {
//				this.updateUserBean.setSUser(sicmedPatient.getUpdateUser());
            }
        } else {

            super.setError("1");
            super.setErrorMessage("所查询的数据为空");
        }
    }

    /**
     * 患者列表查询使用
     * 2016/11/23
     * 丁学志
     */
    public void setSicmedPatientBean(SicmedPatient sicmedPatient) {
        if (sicmedPatient == null) {
            super.setError("1");
            super.setErrorMessage("所查询的数据为空");
            return;
        }
        this.setId(sicmedPatient.getId() != null ? sicmedPatient.getId() : "");
        this.setPatientNumber(sicmedPatient.getPatientNumber() != null ? sicmedPatient.getPatientNumber() : "");
        this.setPatientName(sicmedPatient.getPatientName() != null ? sicmedPatient.getPatientName() : "");
        this.setPatientAge(sicmedPatient.getPatientAge());
        this.setPatientFirstdate(sicmedPatient.getPatientFirstdate());
        this.setPatientLastdate(sicmedPatient.getPatientLastdate());

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getMedicareNo() {
        return medicareNo;
    }

    public void setMedicareNo(String medicareNo) {
        this.medicareNo = medicareNo;
    }

    public String getMedicareType() {
        return medicareType;
    }

    public void setMedicareType(String medicareType) {
        this.medicareType = medicareType;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // @NotNull(message="患者生日不能为空")
    public Date getPatientBirthday() {
        return patientBirthday;
    }

    public void setPatientBirthday(Date patientBirthday) {
        this.patientBirthday = patientBirthday;
    }

    // @Length(min=0, max=18, message="患者身份证长度必须介于 0 和 18 之间")
    public String getPatientCard() {
        return patientCard;
    }

    public void setPatientCard(String patientCard) {
        this.patientCard = patientCard;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // @NotNull(message="患者第一次就诊时间不能为空")
    public Date getPatientFirstdate() {
        return patientFirstdate;
    }

    public void setPatientFirstdate(Date patientFirstdate) {
        this.patientFirstdate = patientFirstdate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // @NotNull(message="患者最后一次就诊时间不能为空")
    public Date getPatientLastdate() {
        return patientLastdate;
    }

    public void setPatientLastdate(Date patientLastdate) {
        this.patientLastdate = patientLastdate;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientTel() {
        return patientTel;
    }

    public void setPatientTel(String patientTel) {
        this.patientTel = patientTel;
    }

//	public SicmedBranchBean getSicmedBranchBean() {
//		return sicmedBranchBean;
//	}
//
//	public void setSicmedBranchBean(SicmedBranchBean sicmedBranchBean) {
//		this.sicmedBranchBean = sicmedBranchBean;
//	}
//
//	public SicmedUserBean getSicmedDoctorBean() {
//		return sicmedDoctorBean;
//	}
//
//	public void setSicmedDoctorBean(SicmedUserBean sicmedDoctorBean) {
//		this.sicmedDoctorBean = sicmedDoctorBean;
//	}

}