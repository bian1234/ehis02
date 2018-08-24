/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;


import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;


/**
 * 医嘱患者中间表Entity
 *
 * @author 丁学志
 * @version 2016-07-18
 */
public class SicmedMedicalAsked extends DataEntity<SicmedMedicalAsked> {

    private static final long serialVersionUID = 1L;
    private String medicalCode;        // 药品编号(对应药品表的编号)
    private String askedCode;        // 医嘱编号(对应医嘱表数据)

    public SicmedMedicalAsked() {
        super();
    }

    public SicmedMedicalAsked(String id) {
        super(id);
    }

    @Length(min = 0, max = 32, message = "药品编号(对应药品表的编号)长度必须介于 0 和 32 之间")
    public String getMedicalCode() {
        return medicalCode;
    }

    public void setMedicalCode(String medicalCode) {
        this.medicalCode = medicalCode;
    }

    @Length(min = 0, max = 32, message = "医嘱编号(对应医嘱表数据)长度必须介于 0 和 32 之间")
    public String getAskedCode() {
        return askedCode;
    }

    public void setAskedCode(String askedCode) {
        this.askedCode = askedCode;
    }

}