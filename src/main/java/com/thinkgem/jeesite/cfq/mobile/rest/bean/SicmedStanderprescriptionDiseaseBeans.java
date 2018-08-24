/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;


/**
 * 医生常用疾病表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedStanderprescriptionDiseaseBeans extends BaseBean {

    private static final long serialVersionUID = 1L;
    private List<SicmedStanderprescriptionDiseaseBean> sicmedStanderprescriptionDiseaseBeans = new ArrayList<SicmedStanderprescriptionDiseaseBean>();

    public List<SicmedStanderprescriptionDiseaseBean> getSicmedStanderprescriptionDiseaseBeans() {
        return sicmedStanderprescriptionDiseaseBeans;
    }

    public void setSicmedStanderprescriptionDiseaseBeans(
            List<SicmedStanderprescriptionDiseaseBean> sicmedStanderprescriptionDiseaseBeans) {
        this.sicmedStanderprescriptionDiseaseBeans = sicmedStanderprescriptionDiseaseBeans;
    }

}