/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;


/**
 * 单表生成Entity
 *
 * @author Max
 * @version 2016-08-10
 */
public class SicmedCity extends DataEntity<SicmedCity> {

    private static final long serialVersionUID = 1L;
    private String cityId;        // city_id
    private String cityParentId;        // city_parent_id
    //	private SicmedCity sicmedCityParent;		// city_parent_id
    private String cityName;        // city_name
    private String cityType;        // city_type

    public SicmedCity() {
        super();
    }

    public SicmedCity(String id) {
        super(id);
    }

    @Length(min = 1, max = 5, message = "city_id长度必须介于 1 和 5 之间")
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityParentId() {
        return cityParentId;
    }

    public void setCityParentId(String cityParentId) {
        this.cityParentId = cityParentId;
    }

    @Length(min = 1, max = 120, message = "city_name长度必须介于 1 和 120 之间")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Length(min = 1, max = 1, message = "city_type长度必须介于 1 和 1 之间")
    public String getCityType() {
        return cityType;
    }

    public void setCityType(String cityType) {
        this.cityType = cityType;
    }

}