package com.thinkgem.jeesite.cfq.mobile.rest.bean.print;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCureCheck;

public class CurePrintBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String cureCode;

    private String cureName;

    private String cureNumber;

    public void setCPB(SicmedCureCheck sicmedCureCheck) {

        this.cureCode = sicmedCureCheck.getCureCode();
        this.cureName = sicmedCureCheck.getCureName();
        this.cureNumber = "1";

    }

    public String getCureCode() {
        return cureCode;
    }

    public void setCureCode(String cureCode) {
        this.cureCode = cureCode;
    }

    public String getCureName() {
        return cureName;
    }

    public void setCureName(String cureName) {
        this.cureName = cureName;
    }

    public String getCureNumber() {
        return cureNumber;
    }

    public void setCureNumber(String cureNumber) {
        this.cureNumber = cureNumber;
    }

}