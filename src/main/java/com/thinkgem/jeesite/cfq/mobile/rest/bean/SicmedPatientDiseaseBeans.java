package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 患者疾病表Entity
 *
 * @author Max
 */
public class SicmedPatientDiseaseBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    private List<SicmedPatientDiseaseBean> sicmedPatientDiseaseBeans = new ArrayList<SicmedPatientDiseaseBean>();

    public List<SicmedPatientDiseaseBean> getSicmedPatientDiseaseBeans() {
        return sicmedPatientDiseaseBeans;
    }

    public void setSicmedPatientDiseaseBeans(List<SicmedPatientDiseaseBean> sicmedPatientDiseaseBeans) {
        this.sicmedPatientDiseaseBeans = sicmedPatientDiseaseBeans;
    }


}