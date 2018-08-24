package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStanderprescriptionDisease;

/**
 * 医生常用疾病表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedStanderprescriptionDiseaseBean extends BaseBean {

    private static final long serialVersionUID = 1L;
    public String id;
    private String prescriptionName; // 处方名
    private SicmedDiseaseBean sicmedDiseaseBean = new SicmedDiseaseBean(); // 疾病编码(对应疾病编码表)

    public void setssdb(SicmedStanderprescriptionDisease ssdb) {
        this.id = ssdb.getId();
        this.prescriptionName = ssdb.getPrescriptionName();
        if (ssdb.getSicmedDisease() != null) {
            this.sicmedDiseaseBean.setSD(ssdb.getSicmedDisease());
        }
    }

    public SicmedStanderprescriptionDiseaseBean() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SicmedDiseaseBean getSicmedDiseaseBean() {
        return sicmedDiseaseBean;
    }

    public void setSicmedDiseaseBean(SicmedDiseaseBean sicmedDiseaseBean) {
        this.sicmedDiseaseBean = sicmedDiseaseBean;
    }

    @Length(min = 0, max = 40, message = "处方名长度必须介于 0 和 40 之间")
    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
    }

}