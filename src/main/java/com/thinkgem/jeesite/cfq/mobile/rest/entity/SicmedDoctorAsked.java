/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;


import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;

/**
 * 医生常用医嘱Entity
 *
 * @author XUE
 * @version 2016-07-12
 */
public class SicmedDoctorAsked extends DataEntity<SicmedDoctorAsked> {

    private static final long serialVersionUID = 1L;
    private SicmedUser sicmedUser;
    private SicmedAskedClass sicmedAskedClass;
    private SicmedAsked sicmedAsked;

    public SicmedDoctorAsked(SicmedUser sicmedUser) {
        this.sicmedUser = sicmedUser;
    }

    public SicmedDoctorAsked(SicmedAskedClass sicmedAskedClass) {
        this.sicmedAskedClass = sicmedAskedClass;
    }

    public SicmedDoctorAsked(SicmedAsked sicmedAsked) {
        this.sicmedAsked = sicmedAsked;
    }

    public SicmedUser getSicmedUser() {
        return sicmedUser;
    }

    public void setSicmedUser(SicmedUser sicmedUser) {
        this.sicmedUser = sicmedUser;
    }

    public SicmedAskedClass getSicmedAskedClass() {
        return sicmedAskedClass;
    }

    public void setSicmedAskedClass(SicmedAskedClass sicmedAskedClass) {
        this.sicmedAskedClass = sicmedAskedClass;
    }

    public SicmedAsked getSicmedAsked() {
        return sicmedAsked;
    }

    public void setSicmedAsked(SicmedAsked sicmedAsked) {
        this.sicmedAsked = sicmedAsked;
    }

    public SicmedDoctorAsked() {
        super();
    }

    public SicmedDoctorAsked(String id) {
        super(id);
    }

}