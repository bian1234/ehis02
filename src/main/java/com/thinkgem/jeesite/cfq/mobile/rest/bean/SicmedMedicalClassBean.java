package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalClass;

public class SicmedMedicalClassBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String id;
    private String className;

    public void setSMCB(SicmedMedicalClass sicmedMedicalClass) {
        this.id = sicmedMedicalClass.getId();
        this.className = sicmedMedicalClass.getName();
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
