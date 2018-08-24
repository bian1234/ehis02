/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;


/**
 * 患者医嘱表Entity
 *
 * @author XUE
 * @version 2016-07-12
 */
public class SicmedPatientAsked extends DataEntity<SicmedPatientAsked> {

    private static final long serialVersionUID = 1L;
    private String plusName;        // 附加医嘱信息
    private String askedType;        //医嘱类型
    private SicmedAskedClass askedClass; //医嘱类型
    private SicmedPatient sicmedPatient;
    private SicmedBranch sicmedBranch;
    private SicmedUser sicmedUser;
    private SicmedAsked sicmedAsked;


    //private SicmedBaseCode sicmedBaseCode; //药品类别,对应基础编码表
    private SicmedAskedBranch sicmedAskedBranch;
    private SicmedMedical sicmedMedical;

    public SicmedPatientAsked(SicmedPatient sicmedPatient) {
        this.sicmedPatient = sicmedPatient;
    }

    public SicmedPatientAsked(SicmedBranch sicmedBranch) {
        this.sicmedBranch = sicmedBranch;
    }

    public SicmedAskedClass getAskedClass() {
        return askedClass;
    }

    public void setAskedClass(SicmedAskedClass askedClass) {
        this.askedClass = askedClass;
    }

    public String getAskedType() {
        return askedType;
    }

    public void setAskedType(String askedType) {
        this.askedType = askedType;
    }

    public SicmedPatientAsked(SicmedUser sicmedUser) {
        this.sicmedUser = sicmedUser;
    }

    public SicmedPatientAsked(SicmedAsked sicmedAsked) {
        this.sicmedAsked = sicmedAsked;
    }


    public SicmedPatientAsked(SicmedAskedBranch sicmedAskedBranch) {
        this.sicmedAskedBranch = sicmedAskedBranch;
    }

    public SicmedPatientAsked(SicmedMedical sicmedMedical) {
        this.sicmedMedical = sicmedMedical;
    }


    public SicmedPatient getSicmedPatient() {
        return sicmedPatient;
    }

    public void setSicmedPatient(SicmedPatient sicmedPatient) {
        this.sicmedPatient = sicmedPatient;
    }

    public SicmedBranch getSicmedBranch() {
        return sicmedBranch;
    }

    public void setSicmedBranch(SicmedBranch sicmedBranch) {
        this.sicmedBranch = sicmedBranch;
    }


    public SicmedUser getSicmedUser() {
        return sicmedUser;
    }

    public void setSicmedUser(SicmedUser sicmedUser) {
        this.sicmedUser = sicmedUser;
    }

    public SicmedAsked getSicmedAsked() {
        return sicmedAsked;
    }

    public void setSicmedAsked(SicmedAsked sicmedAsked) {
        this.sicmedAsked = sicmedAsked;
    }

    public SicmedAskedBranch getSicmedAskedBranch() {
        return sicmedAskedBranch;
    }

    public void setSicmedAskedBranch(SicmedAskedBranch sicmedAskedBranch) {
        this.sicmedAskedBranch = sicmedAskedBranch;
    }

    public SicmedMedical getSicmedMedical() {
        return sicmedMedical;
    }

    public void setSicmedMedical(SicmedMedical sicmedMedical) {
        this.sicmedMedical = sicmedMedical;
    }

    public SicmedPatientAsked() {
        super();
    }

    public SicmedPatientAsked(String id) {
        super(id);
    }


    @Length(min = 0, max = 40, message = "附加医嘱信息长度必须介于 0 和 40 之间")
    public String getPlusName() {
        return plusName;
    }

    public void setPlusName(String plusName) {
        this.plusName = plusName;
    }

}