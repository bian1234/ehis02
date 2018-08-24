/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 科室信息表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedBranchBeans extends BaseBean {

    private static final long serialVersionUID = 1L;
    // private List<SicmedUser> userList = Lists.newArrayList(); // 拥有人员
    // private List<SicmedPatient> patientList = Lists.newArrayList(); // 就诊患者

    private List<SicmedBranchBean> sicmedBranchBeans = new ArrayList<SicmedBranchBean>();

    public List<SicmedBranchBean> getSicmedBranchBeans() {
        return sicmedBranchBeans;
    }

    public void setSicmedBranchBeans(List<SicmedBranchBean> sicmedBranchBeans) {
        this.sicmedBranchBeans = sicmedBranchBeans;
    }

}