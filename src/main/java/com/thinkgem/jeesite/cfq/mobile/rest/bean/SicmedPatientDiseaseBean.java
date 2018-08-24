package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatientDisease;

/**
 * 患者疾病表Entity
 *
 * @author Max
 */
public class SicmedPatientDiseaseBean extends BaseBean {

    private static final long serialVersionUID = 1L;
    private String id;
    private String diseaseName;

    public void setspd(SicmedPatientDisease spd) {
        this.id = spd.getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }


}