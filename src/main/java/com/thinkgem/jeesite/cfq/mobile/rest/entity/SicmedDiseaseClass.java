package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import java.util.List;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;

import com.google.common.collect.Lists;

/**
 * 疾病类别表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedDiseaseClass extends DataEntity<SicmedDiseaseClass> {

    private static final long serialVersionUID = 1L;

    private String diseaseClassName;        // 疾病类别名称
    private String diseaseClassCode;        // 疾病类别编号
    private String diseaseClassPmpa;        // 疾病类别拼音简称

    private SicmedDiseaseClass parentDiseaseClass; //父类别

    private List<SicmedDisease> diseaseList = Lists.newArrayList(); // 拥有疾病

    public SicmedDiseaseClass() {
        super();
    }

    public SicmedDiseaseClass(String id) {
        super(id);
    }

    @Length(min = 0, max = 50, message = "疾病类别名称长度必须介于 0 和 50 之间")
    public String getDiseaseClassName() {
        return diseaseClassName;
    }

    public void setDiseaseClassName(String diseaseClassName) {
        this.diseaseClassName = diseaseClassName;
    }

    @Length(min = 0, max = 50, message = "疾病类别编号长度必须介于 0 和 50 之间")
    public String getDiseaseClassCode() {
        return diseaseClassCode;
    }

    public void setDiseaseClassCode(String diseaseClassCode) {
        this.diseaseClassCode = diseaseClassCode;
    }

    public List<SicmedDisease> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(List<SicmedDisease> diseaseList) {
        this.diseaseList = diseaseList;
    }

    public String getDiseaseClassPmpa() {
        return diseaseClassPmpa;
    }

    public void setDiseaseClassPmpa(String diseaseClassPmpa) {
        this.diseaseClassPmpa = diseaseClassPmpa;
    }

    public SicmedDiseaseClass getParentDiseaseClass() {
        return parentDiseaseClass;
    }

    public void setParentDiseaseClass(SicmedDiseaseClass parentDiseaseClass) {
        this.parentDiseaseClass = parentDiseaseClass;
    }

}