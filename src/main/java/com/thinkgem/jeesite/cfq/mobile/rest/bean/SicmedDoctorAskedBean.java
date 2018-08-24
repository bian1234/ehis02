/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDoctorAsked;

/**
 * 医生常用医嘱Entity
 *
 * @author XUE
 * @version 2016-07-12
 */
public class SicmedDoctorAskedBean extends BaseBean {

    private static final long serialVersionUID = 1L;
    private SicmedUserBean sicmedUserBean;
    private SicmedAskedClassBean sicmedAskedClassBean;
    private SicmedAskedBean sicmedAskedBean;

    public void Setsd(SicmedDoctorAsked sd) {
        if (sd != null) {
            this.sicmedUserBean.setSUser(sd.getSicmedUser());
            this.sicmedAskedClassBean.setSac(sd.getSicmedAskedClass());
            this.sicmedAskedBean.setSAB(sd.getSicmedAsked());
        }
    }

    public SicmedDoctorAskedBean() {
        super();
    }

}