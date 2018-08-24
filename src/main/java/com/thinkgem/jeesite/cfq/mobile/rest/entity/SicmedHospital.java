/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCity;
import org.hibernate.validator.constraints.Length;


/**
 * 单表生成Entity
 *
 * @author Max
 * @version 2016-08-10
 */
public class SicmedHospital extends DataEntity<SicmedHospital> {

    private static final long serialVersionUID = 1L;
    private String hospitalId;        // hospital_id
    private String hospitalName;        // hospital_name
    private String hospitalGrade;        // hospital_grade
    private String hospitalAdd;        // hospital_add
    //	private String cityCode;		// city_code
    private SicmedCity sicmedCity;        // city_code

    public SicmedHospital() {
        super();
    }

    public SicmedHospital(String id) {
        super(id);
    }

    @Length(min = 1, max = 5, message = "hospital_id长度必须介于 1 和 5 之间")
    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Length(min = 1, max = 120, message = "hospital_name长度必须介于 1 和 120 之间")
    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    @Length(min = 1, max = 120, message = "hospital_grade长度必须介于 1 和 120 之间")
    public String getHospitalGrade() {
        return hospitalGrade;
    }

    public void setHospitalGrade(String hospitalGrade) {
        this.hospitalGrade = hospitalGrade;
    }

    @Length(min = 1, max = 120, message = "hospital_add长度必须介于 1 和 120 之间")
    public String getHospitalAdd() {
        return hospitalAdd;
    }

    public void setHospitalAdd(String hospitalAdd) {
        this.hospitalAdd = hospitalAdd;
    }

    public SicmedCity getSicmedCity() {
        return sicmedCity;
    }

    public void setSicmedCity(SicmedCity sicmedCity) {
        this.sicmedCity = sicmedCity;
    }

}