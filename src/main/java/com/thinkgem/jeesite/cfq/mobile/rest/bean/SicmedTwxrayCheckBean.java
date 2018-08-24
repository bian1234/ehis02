package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedTwxrayCheck;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedTwxrayClass;

public class SicmedTwxrayCheckBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String id; // 檢查项目id
    private String checkCode; // 检查编码
    private String checkName; // 检查名称
    private String checkNamePY; // 检查拼音
    private String checkDetail;        //检查详情

    private SicmedTwxrayClass sicmedCheckClass;

    public void setSTCB(SicmedTwxrayCheck twxrayCheck) {

        if (twxrayCheck != null) {

            this.id = twxrayCheck.getId();
            this.checkCode = twxrayCheck.getCheckCode();
            this.checkName = twxrayCheck.getCheckName();
            this.checkNamePY = twxrayCheck.getCheckNamePY();
            this.checkDetail = twxrayCheck.getCheckDetail();

        }

    }


    public String getCheckDetail() {
        return checkDetail;
    }

    public void setCheckDetail(String checkDetail) {
        this.checkDetail = checkDetail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public SicmedTwxrayClass getSicmedCheckClass() {
        return sicmedCheckClass;
    }

    public void setSicmedCheckClass(SicmedTwxrayClass sicmedCheckClass) {
        this.sicmedCheckClass = sicmedCheckClass;
    }

    public String getCheckNamePY() {
        return checkNamePY;
    }

    public void setCheckNamePY(String checkNamePY) {
        this.checkNamePY = checkNamePY;
    }

}
