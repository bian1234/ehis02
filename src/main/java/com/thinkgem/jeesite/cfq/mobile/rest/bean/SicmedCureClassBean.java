package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCureClass;

public class SicmedCureClassBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String id;

    private String className;

    public void setSCCB(SicmedCureClass sicmedCureClass) {
        this.id = sicmedCureClass.getId();
        this.className = sicmedCureClass.getClassName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}
