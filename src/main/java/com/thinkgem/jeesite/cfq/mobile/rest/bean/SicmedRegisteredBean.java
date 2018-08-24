/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegistered;

/**
 * 挂号信息表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedRegisteredBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String id;
    private String registeredStatus; // 挂号类型
    private String registeredPric; // 挂号费用
    private String pricStatus; // 缴费状态

    private Date registeredBeginDate; // 就诊开始时间
    private Date registeredEndDate; // 就诊结束时间

    private Date createDate;

    private SicmedPatientBean sicmedPatientBean = new SicmedPatientBean(); // 患者编号(对应患者基本信息表)
    private SicmedBranchBean sicmedBranchBean = new SicmedBranchBean(); // 科室编号(对应科室表)
    private SicmedUserBean sicmedDoctorBean;
    private SicmedRegisteredTypeBean sicmedRegisteredTypeBean = new SicmedRegisteredTypeBean();
    private SicmedUserBean createUserBean = new SicmedUserBean();

    public void setSR(SicmedRegistered sicmedRegistered) {
        this.id = sicmedRegistered.getId();
        this.registeredStatus = sicmedRegistered.getRegisteredStatus();
        this.registeredPric = sicmedRegistered.getRegisteredPric();
        this.pricStatus = sicmedRegistered.getPricStatus();
        this.registeredBeginDate = sicmedRegistered.getRegisteredBeginDate();
        this.registeredEndDate = sicmedRegistered.getRegisteredEndDate();
        this.createDate = sicmedRegistered.getCreateDate();

        if (sicmedRegistered.getSicmedPatient() != null) {

            this.sicmedPatientBean.setSP(sicmedRegistered.getSicmedPatient());
        }
        if (sicmedRegistered.getSicmedBranch() != null) {
            this.sicmedBranchBean.setSB(sicmedRegistered.getSicmedBranch());
        }
        if (sicmedRegistered.getSicmedRegistrationType() != null) {
            this.sicmedRegisteredTypeBean.setSRTB(sicmedRegistered.getSicmedRegistrationType());
        }
        if (sicmedRegistered.getSicmedDoctor() != null) {
            sicmedDoctorBean = new SicmedUserBean();
            sicmedDoctorBean.setSUser(sicmedRegistered.getSicmedDoctor());
        }
    }

    /**
     * 查询诊疗记录
     * 2016/11/23
     */
    /*public void setSicmedRegisteredBean(SicmedRegistered sicmedRegistered) {
		if (sicmedRegistered == null) {
			this.setError("1");
			this.setSuccessMessage("未找到");
			return;
		}
		this.id = sicmedRegistered.getId();
		this.registeredStatus = sicmedRegistered.getRegisteredStatus();
		this.registeredPric = sicmedRegistered.getRegisteredPric();
		this.pricStatus = sicmedRegistered.getPricStatus();
		this.registeredBeginDate = sicmedRegistered.getRegisteredBeginDate();
		this.registeredEndDate = sicmedRegistered.getRegisteredEndDate();
		this.createDate = sicmedRegistered.getCreateDate();

		if (sicmedRegistered.getSicmedBranch() != null) {
			this.sicmedBranchBean.setSB(sicmedRegistered.getSicmedBranch());
		}
		if(sicmedRegistered.getSicmedRegistrationType()!=null){
			this.sicmedRegisteredTypeBean.setSRTB(sicmedRegistered.getSicmedRegistrationType());
		}
		this.setError("0");
		this.setSuccessMessage("未找到");
	}*/
    public SicmedUserBean getCreateUserBean() {
        return createUserBean;
    }


    public void setCreateUserBean(SicmedUserBean createUserBean) {
        this.createUserBean = createUserBean;
    }


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public SicmedUserBean getSicmedDoctorBean() {
        return sicmedDoctorBean;
    }

    public void setSicmedDoctorBean(SicmedUserBean sicmedDoctorBean) {
        this.sicmedDoctorBean = sicmedDoctorBean;
    }

    public SicmedRegisteredTypeBean getSicmedRegisteredTypeBean() {
        return sicmedRegisteredTypeBean;
    }

    public void setSicmedRegisteredTypeBean(SicmedRegisteredTypeBean sicmedRegisteredTypeBean) {
        this.sicmedRegisteredTypeBean = sicmedRegisteredTypeBean;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegisteredStatus() {
        return registeredStatus;
    }

    public void setRegisteredStatus(String registeredStatus) {
        this.registeredStatus = registeredStatus;
    }

    public String getRegisteredPric() {
        return registeredPric;
    }

    public void setRegisteredPric(String registeredPric) {
        this.registeredPric = registeredPric;
    }

    public String getPricStatus() {
        return pricStatus;
    }

    public void setPricStatus(String pricStatus) {
        this.pricStatus = pricStatus;
    }

    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // @NotNull(message="就诊开始时间不能为空")
    public Date getRegisteredBeginDate() {
        return registeredBeginDate;
    }

    public void setRegisteredBeginDate(Date registeredBeginDate) {
        this.registeredBeginDate = registeredBeginDate;
    }

    public Date getRegisteredEndDate() {
        return registeredEndDate;
    }

    public void setRegisteredEndDate(Date registeredEndDate) {
        this.registeredEndDate = registeredEndDate;
    }

    // public SicmedBaseCodeBean getSicmedBaseCodeBean() {
    // return sicmedBaseCodeBean;
    // }
    //
    // public void setSicmedBaseCodeBean(SicmedBaseCodeBean sicmedBaseCodeBean)
    // {
    // this.sicmedBaseCodeBean = sicmedBaseCodeBean;
    // }

    public SicmedPatientBean getSicmedPatientBean() {
        return sicmedPatientBean;
    }

    public void setSicmedPatientBean(SicmedPatientBean sicmedPatientBean) {
        this.sicmedPatientBean = sicmedPatientBean;
    }

    public SicmedBranchBean getSicmedBranchBean() {
        return sicmedBranchBean;
    }

    public void setSicmedBranchBean(SicmedBranchBean sicmedBranchBean) {
        this.sicmedBranchBean = sicmedBranchBean;
    }

    // public SicmedUserBean getSicmedDoctorBean() {
    // return sicmedDoctorBean;
    // }
    //
    // public void setSicmedDoctorBean(SicmedUserBean sicmedDoctorBean) {
    // this.sicmedDoctorBean = sicmedDoctorBean;
    // }

}