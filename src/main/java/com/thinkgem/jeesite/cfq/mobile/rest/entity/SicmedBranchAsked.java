/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;

/**
 * 科室常用医嘱Entity
 *
 * @author XUE
 * @version 2016-07-12
 */
public class SicmedBranchAsked extends DataEntity<SicmedBranchAsked> {

    private static final long serialVersionUID = 1L;
    private SicmedBranch sicmedBranch;
    private SicmedAskedClass sicmedAskedClass;
    private SicmedAsked sicmedAsked;

    public SicmedBranchAsked(SicmedBranch sicmedBranch) {
        this.sicmedBranch = sicmedBranch;
    }

    public SicmedBranchAsked(SicmedAskedClass sicmedAskedClass) {
        this.sicmedAskedClass = sicmedAskedClass;
    }

    public SicmedBranchAsked(SicmedAsked sicmedAsked) {
        this.sicmedAsked = sicmedAsked;
    }

    public SicmedBranch getSicmedBranch() {
        return sicmedBranch;
    }

    public void setSicmedBranch(SicmedBranch sicmedBranch) {
        this.sicmedBranch = sicmedBranch;
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

    public SicmedBranchAsked() {
        super();
    }

    public SicmedBranchAsked(String id) {
        super(id);
    }

}