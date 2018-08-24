package com.thinkgem.jeesite.cfq.mobile.rest.bean.print;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspect;

public class InspectPrintBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String inspectCode;
    private String inspectName;
    private String number;

    public void setIPB(SicmedInspect sicmedInspect) {
        this.inspectCode = sicmedInspect.getInspectCode();
        this.inspectName = sicmedInspect.getInspectName();
        this.number = "1";
    }

    public String getInspectCode() {
        return inspectCode;
    }

    public void setInspectCode(String inspectCode) {
        this.inspectCode = inspectCode;
    }

    public String getInspectName() {
        return inspectName;
    }

    public void setInspectName(String inspectName) {
        this.inspectName = inspectName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}