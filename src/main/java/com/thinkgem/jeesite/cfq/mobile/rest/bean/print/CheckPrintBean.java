package com.thinkgem.jeesite.cfq.mobile.rest.bean.print;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedTwxrayCheck;

/**
 * 病历表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class CheckPrintBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String checkCode;

    private String checkName;

    private String number;

    public void setCPB(SicmedTwxrayCheck sicmedTwxrayCheck) {
        this.checkCode = sicmedTwxrayCheck.getCheckCode();
        this.checkName = sicmedTwxrayCheck.getCheckName();
        this.number = "1";
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}