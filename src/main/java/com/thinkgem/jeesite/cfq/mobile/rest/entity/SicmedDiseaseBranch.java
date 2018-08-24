/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;


import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;

/**
 * 科室常用疾病表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedDiseaseBranch extends DataEntity<SicmedDiseaseBranch> {

    private static final long serialVersionUID = 1L;


    private SicmedBranch sicmedBranch;        // 科室编号(对应科室表)
    private SicmedDiseaseClass sicmedDiseaseClass;        // 疾病类别编号(对应疾病类别表)
    private SicmedDisease sicmedDisease;        // 疾病编码(对应疾病编码)


    public SicmedDiseaseBranch() {
        super();
    }

    public SicmedDiseaseBranch(String id) {
        super(id);
    }

    public SicmedBranch getSicmedBranch() {
        return sicmedBranch;
    }

    public void setSicmedBranch(SicmedBranch sicmedBranch) {
        this.sicmedBranch = sicmedBranch;
    }

    public SicmedDiseaseClass getSicmedDiseaseClass() {
        return sicmedDiseaseClass;
    }

    public void setSicmedDiseaseClass(SicmedDiseaseClass sicmedDiseaseClass) {
        this.sicmedDiseaseClass = sicmedDiseaseClass;
    }

    public SicmedDisease getSicmedDisease() {
        return sicmedDisease;
    }

    public void setSicmedDisease(SicmedDisease sicmedDisease) {
        this.sicmedDisease = sicmedDisease;
    }


}