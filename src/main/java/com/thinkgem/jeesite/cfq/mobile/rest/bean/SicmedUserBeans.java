package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;


public class SicmedUserBeans extends BaseBean {

    private static final long serialVersionUID = 1L;


    private SicmedDeptBean sicmedDeptBean;        // 部门(外键)
    private SicmedBranchBean sicmedBranchBean;    // 科室编码(外键)

    private List<SicmedUserBean> sicmedUserBeans = new ArrayList<SicmedUserBean>();

    public List<SicmedUserBean> getSicmedUserBeans() {
        return sicmedUserBeans;
    }

    public void setSicmedUserBeans(List<SicmedUserBean> sicmedUserBeans) {
        this.sicmedUserBeans = sicmedUserBeans;
    }

    public SicmedDeptBean getSicmedDeptBean() {
        return sicmedDeptBean;
    }

    public void setSicmedDeptBean(SicmedDeptBean sicmedDeptBean) {
        this.sicmedDeptBean = sicmedDeptBean;
    }

    public SicmedBranchBean getSicmedBranchBean() {
        return sicmedBranchBean;
    }

    public void setSicmedBranchBean(SicmedBranchBean sicmedBranchBean) {
        this.sicmedBranchBean = sicmedBranchBean;
    }


}
