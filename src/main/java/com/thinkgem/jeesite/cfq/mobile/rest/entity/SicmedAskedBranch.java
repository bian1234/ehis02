/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;


import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;

/**
 * 医嘱传送部门Entity
 *
 * @author XUE
 * @version 2016-07-12
 */
public class SicmedAskedBranch extends DataEntity<SicmedAskedBranch> {

    private static final long serialVersionUID = 1L;
    private SicmedAsked sicmedAsked;  //医嘱编号
    private SicmedBranch sicmedbranch;  //部门编号

    public SicmedAskedBranch(SicmedAsked sicmedAsked) {
        this.sicmedAsked = sicmedAsked;
    }

    public SicmedAskedBranch(SicmedBranch sicmedbranch) {
        this.sicmedbranch = sicmedbranch;
    }

    public SicmedAsked getSicmedAsked() {
        return sicmedAsked;
    }

    public void setSicmedAsked(SicmedAsked sicmedAsked) {
        this.sicmedAsked = sicmedAsked;
    }

    public SicmedBranch getSicmedbranch() {
        return sicmedbranch;
    }

    public void setSicmedbranch(SicmedBranch sicmedbranch) {
        this.sicmedbranch = sicmedbranch;
    }

    public SicmedAskedBranch() {
        super();
    }

    public SicmedAskedBranch(String id) {
        super(id);
    }

}