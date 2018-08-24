package com.thinkgem.jeesite.cfq.mobile.rest.setBean;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedAskedClassBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAskedClass;

/**
 * 医嘱信息Entity
 *
 * @author XUE
 * @version 2016-07-12
 */
public class SicmedAskedClassSetBean {

    /*
     * private static final long serialVersionUID = 1L; private String
     * askedCode; // 医嘱编码 private String askedName; // 医嘱名称 private String
     * askedNameExtand; // 医嘱扩展名 private String orderCode; //字表编号 private
     * SicmedCaseBean sicmedCaseBean = new SicmedCaseBean(); // 医嘱所属病例 private
     * SicmedAskedClassBean sicmedAskedClassBean = new SicmedAskedClassBean();
     */
    public static SicmedAskedClass setSAC(SicmedAskedClassBean sicmedAskedClassBean, SicmedAskedClass sicmedAskedClass) {

        if (sicmedAskedClass == null) {
            sicmedAskedClass = new SicmedAskedClass();
        }

        if (sicmedAskedClassBean.getId() != null) {
            sicmedAskedClass.setId(sicmedAskedClassBean.getId());
        }
        if (sicmedAskedClassBean.getClassNumber() != null) {
            sicmedAskedClass.setClassNumber(sicmedAskedClassBean.getClassNumber());
        }
        if (sicmedAskedClassBean.getAskedCalss() != null) {
            sicmedAskedClass.setAskedCalss(sicmedAskedClassBean.getAskedCalss());
        }

        return sicmedAskedClass;
    }
}