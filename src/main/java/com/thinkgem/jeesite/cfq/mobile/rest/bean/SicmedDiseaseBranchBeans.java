package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 科室常用疾病表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedDiseaseBranchBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

//	private SicmedBranchBean sicmedBranchBean;		
//	private SicmedDiseaseClassBean sicmedDiseaseClassBean;		
//	private SicmedDiseaseBean sicmedDiseaseBean;		

    private List<SicmedDiseaseBranchBean> sicmedDiseaseBranchBeans = new ArrayList<SicmedDiseaseBranchBean>();

    public List<SicmedDiseaseBranchBean> getSicmedDiseaseBranchBeans() {
        return sicmedDiseaseBranchBeans;
    }

    public void setSicmedDiseaseBranchBeans(List<SicmedDiseaseBranchBean> sicmedDiseaseBranchBeans) {
        this.sicmedDiseaseBranchBeans = sicmedDiseaseBranchBeans;
    }


}