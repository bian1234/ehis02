/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;

import javax.validation.constraints.NotNull;


/**
 * 用户信息表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedUser extends DataEntity<SicmedUser> {

    private static final long serialVersionUID = 1L;
    private String id;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    private String userNumber;            // 用户编码
    private String userName;            // 用户名
    private String password;            // 密码
    private Date userFodate;            // 入职日期
    private Date userTodate;            // 离职时间
    private String userJobGroup;        // 工作组
    private String userJobGrade;        // 工作等级
    private String doctorCode;            // 医生编号
    private String doctorGrade;            // 医生等级
    private String printranking;        // 账号是否激活
    private String doctorRegisteredAm;    // 上午挂号人数
    private String doctorRegisteredPm;    // 下午挂号人数
    private String doctorRegistered;    // 是否可挂号
    private String registeredDifference;// 挂号区分
    private String license;                // 许可证编码
    private String licenseSpc;            // 特需许可证编号
    private String userTel;                // 电话
    private String userEmail;            // 邮箱
    private String userStatus;            // 在职状态
    private Date loginDate;                // 登录时间
    private Date changeFdate;            // 变更开始日期
    private Date changeOdate;            // 变更结束日期
    private SicmedDept sicmedDept;        // 部门(外键)
    private SicmedBranch sicmedBranch;    // 科室编码(外键)
    private String doctorBranch1;        // 所属科室编码1
    private String doctorBranch2;        // 所属科室编码2
    private String doctorBranch3;        // 医生所属科室3

    private String jobGroupType;        // 工作组(0.挂号  1.医生  2.收费)
    private String doctorGradeType;    // 医生等级分类 (1.普通门诊  3.副主任专家门诊  4.主任专家门诊 5.知名专家门诊  2.特需门诊 )
    private String registeredType;    // 是否可挂号 (0.不可挂号 1.可挂号)
    private String userStatusType;        // 是否在职 (0.离职  1.在职)

    public static final String PASS_WORD = "12345678";
    public static final String USER_JOB_GRADE = "0";
    public static final String PRINT_RANKING = "0";

//	private String inviteNumber;
//	private SicmedInviteNumber sicmedInviteNumber;

    private List<SicmedPatient> patientList = Lists.newArrayList(); // 医生诊疗的患者
    private List<SicmedRegistered> registeredList = Lists.newArrayList(); // 挂号数
    private List<SicmedPatientDisease> patientDiseaseList = Lists.newArrayList(); // 患者疾病

    public SicmedUser() {
        super();

		/*	this.userJobGrade = USER_JOB_GRADE;
		this.printranking = PRINT_RANKING;*/
    }

    public SicmedUser(String id) {
        super(id);
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getJobGroupType() {
        if (jobGroupType != null || userJobGroup == null) {
            return jobGroupType;
        }
        switch (Integer.valueOf(this.getUserJobGroup())) {
            case 0:
                this.setJobGroupType("挂号");
                break;
            case 1:
                this.setJobGroupType("医生");
                break;
            case 2:
                this.setJobGroupType("收费");
                break;
            default:
                break;
        }
        return jobGroupType;
    }

    public void setJobGroupType(String jobGroupType) {
        this.jobGroupType = jobGroupType;
    }

    public String getDoctorGradeType() {
        if (doctorGradeType != null || doctorGrade == null || doctorGradeType == "") {
            return doctorGradeType;
        }
        switch (Integer.valueOf(this.getDoctorGrade())) {
            case 0:
                this.setDoctorGradeType("没有医生等级权限");
                break;
            case 1:
                this.setDoctorGradeType("普通门诊");
                break;
            case 3:
                this.setDoctorGradeType("副主任专家门诊");
                break;
            case 4:
                this.setDoctorGradeType("主任专家门诊");
                break;
            case 5:
                this.setDoctorGradeType("知名专家门诊");
                break;
            case 2:
                this.setDoctorGradeType("特需门诊");
                break;

            default:
                break;
        }
        return doctorGradeType;
    }

    public void setDoctorGradeType(String doctorGradeType) {
        this.doctorGradeType = doctorGradeType;
    }

    public String getRegisteredType() {
        if (registeredType != null || doctorRegistered == null) {
            return registeredType;
        }
        switch (Integer.valueOf(this.getDoctorRegistered())) {
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

    public void setRegisteredType(String registeredType) {
        this.registeredType = registeredType;
    }

    public String getUserStatusType() {
        if (userStatusType != null || userStatus == null) {
            return userStatusType;
        }
        switch (Integer.valueOf(this.getUserStatus())) {
            case 0:
                this.setUserStatusType("离职");
                break;
            case 1:
                this.setUserStatusType("在职");
                break;
            default:
                break;
        }
        return userStatusType;
    }

    public void setUserStatusType(String userStatusType) {
        this.userStatusType = userStatusType;
    }

    @Length(min = 1, max = 6, message = "用户编码长度必须介于 1 和 6 之间")
    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    @Length(min = 1, max = 10, message = "用户名长度必须介于 1 和 10 之间")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Length(min = 8, max = 16, message = "密码长度必须介于 8和 16 之间")

    public String getPassword() {
        if (password == null || password == "") {
            this.password = PASS_WORD;
        }
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password == "") {
            this.password = PASS_WORD;
        }
        this.password = password;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "入职日期不能为空")
    public Date getUserFodate() {
        return userFodate;
    }

    public void setUserFodate(Date userFodate) {
        this.userFodate = userFodate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	@NotNull(message="离职时间不能为空")
    public Date getUserTodate() {
        return userTodate;
    }

    public void setUserTodate(Date userTodate) {
        this.userTodate = userTodate;
    }

    @Length(min = 0, max = 20, message = "工作组长度必须介于 0 和 20 之间")
    public String getUserJobGroup() {
        return userJobGroup;
    }

    public void setUserJobGroup(String userJobGroup) {
        this.userJobGroup = userJobGroup;
    }

    @Length(min = 0, max = 40, message = "工作等级长度必须介于 0 和 20 之间")
    public String getUserJobGrade() {
        if (userJobGrade == null || userJobGrade == "") {
            this.userJobGrade = USER_JOB_GRADE;
        }
        return userJobGrade;
    }

    public void setUserJobGrade(String userJobGrade) {
        if (userJobGrade == null || userJobGrade == "") {
            this.userJobGrade = USER_JOB_GRADE;
        }
        this.userJobGrade = userJobGrade;
    }

    public SicmedDept getSicmedDept() {
        return sicmedDept;
    }

    public void setSicmedDept(SicmedDept sicmedDept) {
        this.sicmedDept = sicmedDept;
    }

    public SicmedBranch getSicmedBranch() {
        return sicmedBranch;
    }

    public void setSicmedBranch(SicmedBranch sicmedBranch) {
        this.sicmedBranch = sicmedBranch;
    }

    @Length(min = 0, max = 20, message = "医生编号长度必须介于 0 和 6 之间")
    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    @Length(min = 0, max = 1, message = "医生等级长度必须介于 0 和 1 之间")
    public String getDoctorGrade() {
        return doctorGrade;
    }

    public void setDoctorGrade(String doctorGrade) {
        this.doctorGrade = doctorGrade;
    }

    @Length(min = 0, max = 2, message = "优先级长度必须介于 0 和 2 之间")
    public String getPrintranking() {
        return printranking;
    }

    public void setPrintranking(String printranking) {
        if (printranking == null || printranking == "") {
            this.printranking = PRINT_RANKING;
        }
        this.printranking = printranking;
    }

    @Length(min = 0, max = 3, message = "上午挂号人数长度必须介于 0 和 3 之间")
    public String getDoctorRegisteredAm() {
        return doctorRegisteredAm;
    }

    public void setDoctorRegisteredAm(String doctorRegisteredAm) {
        this.doctorRegisteredAm = doctorRegisteredAm;
    }

    @Length(min = 0, max = 3, message = "下午挂号人数长度必须介于 0 和 3 之间")
    public String getDoctorRegisteredPm() {
        return doctorRegisteredPm;
    }

    public void setDoctorRegisteredPm(String doctorRegisteredPm) {
        this.doctorRegisteredPm = doctorRegisteredPm;
    }

    @Length(min = 0, max = 1, message = "是否可挂号长度必须介于 0 和 1 之间")
    public String getDoctorRegistered() {
        return doctorRegistered;
    }

    public void setDoctorRegistered(String doctorRegistered) {
        this.doctorRegistered = doctorRegistered;
    }

    @Length(min = 0, max = 1, message = "挂号区分长度必须介于 0 和 1 之间")
    public String getRegisteredDifference() {
        return registeredDifference;
    }

    public void setRegisteredDifference(String registeredDifference) {
        this.registeredDifference = registeredDifference;
    }

    @Length(min = 0, max = 15, message = "许可证编码长度必须介于 0 和 15 之间")
    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Length(min = 0, max = 10, message = "特需许可证编号长度必须介于 0 和 10 之间")
    public String getLicenseSpc() {
        return licenseSpc;
    }

    public void setLicenseSpc(String licenseSpc) {
        this.licenseSpc = licenseSpc;
    }

    @Length(min = 0, max = 14, message = "电话长度必须介于 0 和 14 之间")
    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    @Length(min = 0, max = 50, message = "邮箱长度必须介于 0 和 50 之间")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Length(min = 0, max = 1, message = "在职状态长度必须介于 0 和 1 之间")
    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getChangeFdate() {
        return changeFdate;
    }

    public void setChangeFdate(Date changeFdate) {
        this.changeFdate = changeFdate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getChangeOdate() {
        return changeOdate;
    }

    public void setChangeOdate(Date changeOdate) {
        this.changeOdate = changeOdate;
    }

    @Length(min = 0, max = 4, message = "所属科室编码1长度必须介于 0 和 4 之间")
    public String getDoctorBranch1() {
        return doctorBranch1;
    }

    public void setDoctorBranch1(String doctorBranch1) {
        this.doctorBranch1 = doctorBranch1;
    }

    @Length(min = 0, max = 4, message = "所属科室编码2长度必须介于 0 和 4 之间")
    public String getDoctorBranch2() {
        return doctorBranch2;
    }

    public void setDoctorBranch2(String doctorBranch2) {
        this.doctorBranch2 = doctorBranch2;
    }

    @Length(min = 0, max = 4, message = "医生所属科室3长度必须介于 0 和 4 之间")
    public String getDoctorBranch3() {
        return doctorBranch3;
    }

    public void setDoctorBranch3(String doctorBranch3) {
        this.doctorBranch3 = doctorBranch3;
    }

    public List<SicmedPatient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<SicmedPatient> patientList) {
        this.patientList = patientList;
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

	/*public SicmedInviteNumber getSicmedInviteNumber() {
		return sicmedInviteNumber;
	}

	public void setSicmedInviteNumber(SicmedInviteNumber sicmedInviteNumber) {
		this.sicmedInviteNumber = sicmedInviteNumber;
	}
	*/
}