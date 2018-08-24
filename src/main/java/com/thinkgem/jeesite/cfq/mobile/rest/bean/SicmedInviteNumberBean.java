/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInviteNumber;

/**
 * 账号激活码Entity
 *
 * @author Max
 * @version 2016-07-19
 */
public class SicmedInviteNumberBean extends DataEntity<SicmedInviteNumberBean> {

    private static final long serialVersionUID = 1L;
    private String inviteNumber;        // 激活码
    private String inviteStatus;        // 激活状态

    public void setSIN(SicmedInviteNumber sicmedInviteNumber) {
        if (sicmedInviteNumber != null) {

            this.inviteNumber = sicmedInviteNumber.getInviteNumber();
            this.inviteStatus = sicmedInviteNumber.getInviteStatus();

        } else {

        }
    }

    public String getInviteNumber() {
        return inviteNumber;
    }

    public void setInviteNumber(String inviteNumber) {
        this.inviteNumber = inviteNumber;
    }

    public String getInviteStatus() {
        return inviteStatus;
    }

    public void setInviteStatus(String inviteStatus) {
        this.inviteStatus = inviteStatus;
    }

}