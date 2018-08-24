/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;


/**
 * 单表生成Entity
 *
 * @author yjx
 * @version 2016-07-28
 */
public class SicmedEntrustedAsked extends DataEntity<SicmedEntrustedAsked> {

    private static final long serialVersionUID = 1L;
    private String id;              //嘱托医嘱id
    private String entrustedAsked;        // 嘱托医嘱信息
    private String orderCode;        // 对应id

    public SicmedEntrustedAsked() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Length(min = 0, max = 200, message = "嘱托医嘱信息长度必须介于 0 和 200 之间")
    public String getEntrustedAsked() {
        return entrustedAsked;
    }

    public void setEntrustedAsked(String entrustedAsked) {
        this.entrustedAsked = entrustedAsked;
    }

    @Length(min = 0, max = 32, message = "对应id长度必须介于 0 和 32 之间")
    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

}