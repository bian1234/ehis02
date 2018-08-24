/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDiseaseClass;

/**
 * 疾病类别表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedDiseaseClassBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String id;
    private String diseaseClassName;        // 疾病类别名称
    private String diseaseClassCode;        // 疾病类别编号

//	private List<SicmedDisease> diseaseList = Lists.newArrayList(); // 拥有疾病

    public void setDC(SicmedDiseaseClass sicmedDiseaseClass) {
        if (sicmedDiseaseClass != null) {
            this.id = sicmedDiseaseClass.getId();
            this.diseaseClassName = sicmedDiseaseClass.getDiseaseClassName();
            this.diseaseClassCode = sicmedDiseaseClass.getDiseaseClassName();

        } else {

            super.setError("1");
            super.setErrorMessage("所查询的数据为空");

        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiseaseClassName() {
        return diseaseClassName;
    }

    public void setDiseaseClassName(String diseaseClassName) {
        this.diseaseClassName = diseaseClassName;
    }

    public String getDiseaseClassCode() {
        return diseaseClassCode;
    }

    public void setDiseaseClassCode(String diseaseClassCode) {
        this.diseaseClassCode = diseaseClassCode;
    }


}