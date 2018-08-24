/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedEntrustedAsked;

/**
 * 单表生成Entity
 *
 * @author yjx
 * @version 2016-07-28
 */
public class SicmedEntrustedAskedBean extends BaseBean {

    private static final long serialVersionUID = 1L;
    private String id;          //嘱托医嘱id
    private String entrustedAsked;        // 嘱托医嘱信息
    private String orderCode;        // 对应id

    public void setSeab(SicmedEntrustedAsked seab) {
        this.id = seab.getId();
        this.entrustedAsked = seab.getEntrustedAsked();
        this.orderCode = seab.getOrderCode();
    }

    public String getEntrustedAsked() {
        return entrustedAsked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEntrustedAsked(String entrustedAsked) {
        this.entrustedAsked = entrustedAsked;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }


}