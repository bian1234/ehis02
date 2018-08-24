/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import java.util.List;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;

import com.google.common.collect.Lists;

/**
 * 医嘱分类编码Entity
 *
 * @author XUE
 * @version 2016-07-12
 */
public class SicmedAskedClass extends DataEntity<SicmedAskedClass> {

    private static final long serialVersionUID = 1L;

    private String classNumber; // 医嘱编号
    private String askedCalss; // 医嘱类型

    private List<SicmedAsked> sicmedAskedList = Lists.newArrayList();
    private List<SicmedBranchAsked> sicmedBranchAsked = Lists.newArrayList();
    private List<SicmedDoctorAsked> sicmedDoctorAsked = Lists.newArrayList();


    public List<SicmedAsked> getSicmedAskedList() {
        return sicmedAskedList;
    }

    public void setSicmedAskedList(List<SicmedAsked> sicmedAskedList) {
        this.sicmedAskedList = sicmedAskedList;
    }

    public List<SicmedBranchAsked> getSicmedBranchAsked() {
        return sicmedBranchAsked;
    }

    public void setSicmedBranchAsked(List<SicmedBranchAsked> sicmedBranchAsked) {
        this.sicmedBranchAsked = sicmedBranchAsked;
    }

    public List<SicmedDoctorAsked> getSicmedDoctorAsked() {
        return sicmedDoctorAsked;
    }

    public void setSicmedDoctorAsked(List<SicmedDoctorAsked> sicmedDoctorAsked) {
        this.sicmedDoctorAsked = sicmedDoctorAsked;
    }

    public SicmedAskedClass() {
        super();
    }

    public SicmedAskedClass(String id) {
        super(id);
    }

    @Length(min = 0, max = 4, message = "医嘱编号长度必须介于 0 和 4 之间")
    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    @Length(min = 0, max = 40, message = "药品类型长度必须介于 0 和 40 之间")
    public String getAskedCalss() {
        return askedCalss;
    }

    public void setAskedCalss(String askedCalss) {
        this.askedCalss = askedCalss;
    }

}