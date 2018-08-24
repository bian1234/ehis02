/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatientAsked;

/**
 * 患者医嘱表Entity
 *
 * @author XUE
 * @version 2016-07-12
 */
public class SicmedPatientAskedBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private SicmedPatientBean sicmedPatientBean = new SicmedPatientBean();
    private SicmedBranchBean sicmedBranchBean = new SicmedBranchBean();
    private SicmedUserBean sicmedUserBean = new SicmedUserBean();
    private SicmedAskedBean sicmedAskedBean = new SicmedAskedBean();
    private SicmedAskedBranchBean sicmedAskedBranchBean = new SicmedAskedBranchBean();
    private SicmedMedicalBean sicmedMedicalBean = new SicmedMedicalBean();
    private SicmedAskedClassBean sicmedAskedClassBean = new SicmedAskedClassBean();
    private String plusName; // 附加医嘱信息

    public void setpm(SicmedPatientAsked spab) {
        this.plusName = spab.getPlusName();
        if (spab.getSicmedPatient() != null) {
            if (spab.getSicmedPatient() != null) {
                this.sicmedPatientBean.setSP(spab.getSicmedPatient());

            }
            if (spab.getSicmedBranch() != null) {
                this.sicmedBranchBean.setSB(spab.getSicmedBranch());
            }
            if (spab.getSicmedUser() != null) {
                this.sicmedUserBean.setSUser(spab.getSicmedUser());
            }
            if (spab.getSicmedAsked() != null) {
                this.sicmedAskedBean.setSAB(spab.getSicmedAsked());
            }
            if (spab.getSicmedAskedBranch() != null) {
                this.sicmedAskedBranchBean.SetS(spab.getSicmedAskedBranch());
            }
            if (spab.getSicmedMedical() != null) {
                this.sicmedMedicalBean.setSMB(spab.getSicmedMedical());
            }
            if (spab.getAskedClass() != null) {
                this.sicmedAskedClassBean.setSac(spab.getAskedClass());
            }
        }
    }

    public String getPlusName() {
        return plusName;
    }

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

    public SicmedUserBean getSicmedUserBean() {
        return sicmedUserBean;
    }

    public void setSicmedUserBean(SicmedUserBean sicmedUserBean) {
        this.sicmedUserBean = sicmedUserBean;
    }

    public SicmedAskedBean getSicmedAskedBean() {
        return sicmedAskedBean;
    }

    public void setSicmedAskedBean(SicmedAskedBean sicmedAskedBean) {
        this.sicmedAskedBean = sicmedAskedBean;
    }

    public SicmedAskedBranchBean getSicmedAskedBranchBean() {
        return sicmedAskedBranchBean;
    }

    public void setSicmedAskedBranchBean(SicmedAskedBranchBean sicmedAskedBranchBean) {
        this.sicmedAskedBranchBean = sicmedAskedBranchBean;
    }

    public SicmedMedicalBean getSicmedMedicalBean() {
        return sicmedMedicalBean;
    }

    public void setSicmedMedicalBean(SicmedMedicalBean sicmedMedicalBean) {
        this.sicmedMedicalBean = sicmedMedicalBean;
    }

    public SicmedAskedClassBean getSicmedAskedClassBean() {
        return sicmedAskedClassBean;
    }

    public void setSicmedAskedClassBean(SicmedAskedClassBean sicmedAskedClassBean) {
        this.sicmedAskedClassBean = sicmedAskedClassBean;
    }

    public void setPlusName(String plusName) {
        this.plusName = plusName;
    }

}