/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCity;

/**
 * 科室信息表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedCityBean extends BaseBean {

    private static final long serialVersionUID = 1L;
    private String cityId; // city_id
    private String cityName; // city_name
    private String cityType; // city_type
    private String cityParentId;        // city_parent_id

    public void setSCB(SicmedCity sicmedCity) {
        if (sicmedCity != null) {
            this.cityId = sicmedCity.getCityId();
            this.cityName = sicmedCity.getCityName();
            this.cityType = sicmedCity.getCityType();
            this.cityParentId = sicmedCity.getCityParentId();
        }
    }

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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityType() {
        return cityType;
    }

    public void setCityType(String cityType) {
        this.cityType = cityType;
    }

}