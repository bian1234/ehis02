/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import java.util.List;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;

import com.google.common.collect.Lists;

/**
 * 疾病表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedDisease extends DataEntity<SicmedDisease> {

    private static final long serialVersionUID = 1L;
    private String diseaseName;                                                        // 疾病名称
    private String diseaseNameEnglish;                                                // 疾病英文名
    private String diseaseNamePmpa;                                                    // 疾病拼音缩写名
    private String diseaseCode;                                                        // 疾病编码
    private SicmedDiseaseClass diseaseClass;                                        // 疾病类别编码(对应疾病编码表)
    private List<SicmedPatientDisease> patientDiseaseList = Lists.newArrayList();    // 患者疾病

    public SicmedDisease() {
        super();
    }

    public SicmedDisease(String id) {
        super(id);
    }

    public SicmedDiseaseClass getDiseaseClass() {
        return diseaseClass;
    }

    public void setDiseaseClass(SicmedDiseaseClass diseaseClass) {
        this.diseaseClass = diseaseClass;
    }

    @Length(min = 0, max = 50, message = "疾病名称长度必须介于 0 和 50 之间")
    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    @Length(min = 0, max = 20, message = "疾病英文名长度必须介于 0 和 20 之间")
    public String getDiseaseNameEnglish() {
        return diseaseNameEnglish;
    }

    public void setDiseaseNameEnglish(String diseaseNameEnglish) {
        this.diseaseNameEnglish = diseaseNameEnglish;
    }

    @Length(min = 0, max = 10, message = "疾病拼音缩写名长度必须介于 0 和 10 之间")
    public String getDiseaseNamePmpa() {
        return diseaseNamePmpa;
    }

    public void setDiseaseNamePmpa(String diseaseNamePmpa) {
        this.diseaseNamePmpa = diseaseNamePmpa;
    }

    @Length(min = 0, max = 20, message = "疾病编码长度必须介于 0 和 20 之间")
    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    public List<SicmedPatientDisease> getPatientDiseaseList() {
        return patientDiseaseList;
    }

    public void setPatientDiseaseList(List<SicmedPatientDisease> patientDiseaseList) {
        this.patientDiseaseList = patientDiseaseList;
    }

}