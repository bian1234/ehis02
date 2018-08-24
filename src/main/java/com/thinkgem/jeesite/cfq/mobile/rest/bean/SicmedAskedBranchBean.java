/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAskedBranch;

/**
 * 医嘱传送部门Entity
 *
 * @author XUE
 * @version 2016-07-12
 */
public class SicmedAskedBranchBean extends BaseBean {

    private static final long serialVersionUID = 1L;
    private SicmedAskedBean sicmedAskedBean = new SicmedAskedBean();  //医嘱编号
    private SicmedBranchBean sicmedbranchBean = new SicmedBranchBean();  //部门编号

    public void SetS(SicmedAskedBranch sa) {
        if (sa != null) {
            this.sicmedAskedBean.setSAB(sa.getSicmedAsked());
            this.sicmedbranchBean.setSB(sa.getSicmedbranch());
        }
    }


    public SicmedAskedBranchBean() {
        super();
    }

}