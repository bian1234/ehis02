/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAskedClass;

public class SicmedAskedClassBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String id;        //医嘱类别ID
    private String classNumber; // 医嘱编号
    private String askedCalss; // 药品类型

    public void setSac(SicmedAskedClass sac) {
        if (sac != null) {
            this.id = sac.getId();
            this.classNumber = sac.getClassNumber();
            this.askedCalss = sac.getAskedCalss();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getAskedCalss() {
        return askedCalss;
    }

    public void setAskedCalss(String askedCalss) {
        this.askedCalss = askedCalss;
    }

}