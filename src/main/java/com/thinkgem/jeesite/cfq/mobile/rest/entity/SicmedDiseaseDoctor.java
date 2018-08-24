/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;


import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;

/**
 * 医生常用疾病表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedDiseaseDoctor extends DataEntity<SicmedDiseaseDoctor> {

    private static final long serialVersionUID = 1L;
    private SicmedUser sicmedDoctor;        // 医生编号(对应医生表)

    private SicmedDiseaseClass sicmedDiseaseClass;        // 疾病类别编号(对应疾病类别表)
    private SicmedDisease sicmedDisease;        // 疾病编码(对应疾病编码)


    public SicmedDiseaseDoctor() {
        super();
    }

    public SicmedDiseaseDoctor(String id) {
        super(id);
    }

    public SicmedUser getSicmedDoctor() {
        return sicmedDoctor;
    }

    public void setSicmedDoctor(SicmedUser sicmedDoctor) {
        this.sicmedDoctor = sicmedDoctor;
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