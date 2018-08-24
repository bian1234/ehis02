/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 患者医嘱表Entity
 *
 * @author XUE
 * @version 2016-07-12
 */
public class SicmedPatientAskedBeans extends BaseBean {

    private static final long serialVersionUID = 1L;
    private SicmedPatientBean sicmedPatientBean;
    private SicmedBranchBean sicmedBranchBean;
    private SicmedUserBean sicmedUserBean;
    private SicmedAskedBean sicmedAskedBean;
    private SicmedAskedBranchBean sicmedAskedBranchBean;
    private SicmedMedicalBean sicmedMedicalBean;
    private SicmedAskedClassBean sicmedAskedClassBean;
    private List<SicmedPatientAskedBean> sicmedPatientAskedBeans = new ArrayList<SicmedPatientAskedBean>();

    public SicmedPatientBean getSicmedPatientBean() {
        return sicmedPatientBean;
    }

    public SicmedAskedClassBean getSicmedAskedClassBean() {
        return sicmedAskedClassBean;
    }

    public void setSicmedAskedClassBean(SicmedAskedClassBean sicmedAskedClassBean) {
        this.sicmedAskedClassBean = sicmedAskedClassBean;
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

    public List<SicmedPatientAskedBean> getSicmedPatientAskedBeans() {
        return sicmedPatientAskedBeans;
    }

    public void setSicmedPatientAskedBeans(List<SicmedPatientAskedBean> sicmedPatientAskedBeans) {
        this.sicmedPatientAskedBeans = sicmedPatientAskedBeans;
    }

}