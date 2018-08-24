/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedUser;
import org.hibernate.validator.constraints.Length;


/**
 * 账号激活码Entity
 *
 * @author Max
 * @version 2016-07-19
 */
public class SicmedInviteNumber extends DataEntity<SicmedInviteNumber> {

    private static final long serialVersionUID = 1L;
    private String inviteNumber; // 激活码
    private String inviteStatus; // 激活状态
    private SicmedUser sicmedUser; //激活码所属用户

    private String statusType;  //是否激活(0.否 1.是)

    public SicmedInviteNumber() {
        super();
    }

    public SicmedInviteNumber(String id) {
        super(id);
    }


    public SicmedUser getSicmedUser() {
        return sicmedUser;
    }

    public String getStatusType() {
        if (statusType != null || inviteStatus == null) {
            return statusType;
        }
        switch (Integer.valueOf(this.getInviteStatus())) {
            case 0:
                this.setStatusType("否");
                break;
            case 1:
                this.setStatusType("是");
                break;
            default:
                break;
        }
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public void setSicmedUser(SicmedUser sicmedUser) {
        this.sicmedUser = sicmedUser;
    }

    @Length(min = 1, max = 32, message = "激活码长度必须介于 1 和 32 之间")
    public String getInviteNumber() {
        return inviteNumber;
    }

    public void setInviteNumber(String inviteNumber) {
        this.inviteNumber = inviteNumber;
    }

    @Length(min = 1, max = 1, message = "激活状态长度必须介于 1 和 1 之间")
    public String getInviteStatus() {
        return inviteStatus;
    }

    public void setInviteStatus(String inviteStatus) {
        this.inviteStatus = inviteStatus;
    }

}