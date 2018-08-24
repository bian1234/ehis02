package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDiseaseBranch;

/**
 * 科室常用疾病表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedDiseaseBranchBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private SicmedBranchBean sicmedBranchBean;
    private SicmedDiseaseClassBean sicmedDiseaseClassBean;
    private SicmedDiseaseBean sicmedDiseaseBean;

    public void setDB(SicmedDiseaseBranch sicmedDiseaseBranch) {
        if (sicmedDiseaseBranch != null) {
            sicmedDiseaseBranch.getSicmedBranch();
            sicmedDiseaseBranch.getSicmedDiseaseClass();
            sicmedDiseaseBranch.getSicmedDisease();
        } else {
            super.setError("1");
            super.setErrorMessage("所查询的数据为空");
        }
    }

    public SicmedBranchBean getSicmedBranchBean() {
        return sicmedBranchBean;
    }

    public void setSicmedBranchBean(SicmedBranchBean sicmedBranchBean) {
        this.sicmedBranchBean = sicmedBranchBean;
    }

    public SicmedDiseaseClassBean getSicmedDiseaseClassBean() {
        return sicmedDiseaseClassBean;
    }

    public void setSicmedDiseaseClassBean(SicmedDiseaseClassBean sicmedDiseaseClassBean) {
        this.sicmedDiseaseClassBean = sicmedDiseaseClassBean;
    }

    public SicmedDiseaseBean getSicmedDiseaseBean() {
        return sicmedDiseaseBean;
    }

    public void setSicmedDiseaseBean(SicmedDiseaseBean sicmedDiseaseBean) {
        this.sicmedDiseaseBean = sicmedDiseaseBean;
    }


}