/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDisease;

/**
 * 疾病表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedDiseaseBean extends BaseBean {

    private static final long serialVersionUID = 1L;
    private String id;
    private String diseaseName;        // 疾病名称
    private String diseaseNameEnglish;        // 疾病英文名
    private String diseaseNamePmpa;        // 疾病拼音缩写名
    private String diseaseCode;        // 疾病编码

//	private SicmedDiseaseClass diseaseClass;		// 疾病类别编码(对应疾病编码表)

    public void setSD(SicmedDisease sicmedDisease) {
        if (sicmedDisease != null) {
            this.id = sicmedDisease.getId();
            this.diseaseName = sicmedDisease.getDiseaseName();
            this.diseaseNameEnglish = sicmedDisease.getDiseaseNameEnglish();
            this.diseaseNamePmpa = sicmedDisease.getDiseaseNamePmpa();
            this.diseaseCode = sicmedDisease.getDiseaseCode();
        } else {
            super.setError("1");
            super.setErrorMessage("所查找的信息不存在");
        }
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

    public String getDiseaseNameEnglish() {
        return diseaseNameEnglish;
    }

    public void setDiseaseNameEnglish(String diseaseNameEnglish) {
        this.diseaseNameEnglish = diseaseNameEnglish;
    }

    public String getDiseaseNamePmpa() {
        return diseaseNamePmpa;
    }

    public void setDiseaseNamePmpa(String diseaseNamePmpa) {
        this.diseaseNamePmpa = diseaseNamePmpa;
    }

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

}