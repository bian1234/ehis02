package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspectClass;

public class SicmedInspectClassBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String id;

    private String className;

    public void setSICB(SicmedInspectClass sicmedInspectClass) {

        this.id = sicmedInspectClass.getId();
        this.className = sicmedInspectClass.getInspectName();
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
