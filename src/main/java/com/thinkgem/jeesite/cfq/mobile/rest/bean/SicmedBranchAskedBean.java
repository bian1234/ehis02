/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedBranchAsked;

/**
 * 科室常用医嘱Entity
 *
 * @author XUE
 * @version 2016-07-12
 */
public class SicmedBranchAskedBean extends BaseBean {

    private static final long serialVersionUID = 1L;
    //private SicmedBranchBean sicmedBranchBean;
    private SicmedAskedClassBean sicmedAskedClassBean;
    private SicmedAskedBean sicmedAskedBean;

    public void Setsb(SicmedBranchAsked sb) {
        if (sb != null) {
            //TODO
            //this.sicmedBranchBean.Set
            this.sicmedAskedClassBean.setSac(sb.getSicmedAskedClass());
            this.sicmedAskedBean.setSAB(sb.getSicmedAsked());
        }
    }

    public SicmedBranchAskedBean() {
        super();
    }

}