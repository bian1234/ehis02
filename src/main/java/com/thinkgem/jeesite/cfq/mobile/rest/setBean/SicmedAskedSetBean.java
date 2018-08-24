package com.thinkgem.jeesite.cfq.mobile.rest.setBean;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedAskedBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAsked;

/**
 * 医嘱信息Entity
 *
 * @author XUE
 * @version 2016-07-12
 */
public class SicmedAskedSetBean {

    public static SicmedAsked setAsked(SicmedAskedBean sicmedAskedBean, SicmedAsked sicmedAsked) {

        if (sicmedAsked == null) {
            sicmedAsked = new SicmedAsked();
        }

        if (sicmedAskedBean.getId() != null) {
            sicmedAsked.setId(sicmedAskedBean.getId());

        }
        if (sicmedAskedBean.getRemarks() != null) {
            sicmedAsked.setRemarks(sicmedAskedBean.getRemarks());

        }
        if (sicmedAskedBean.getAskedCode() != null) {
            sicmedAsked.setAskedCode(sicmedAskedBean.getAskedCode());

        }
        if (sicmedAskedBean.getAskedName() != null) {
            sicmedAsked.setAskedName(sicmedAskedBean.getAskedName());

        }
        if (sicmedAskedBean.getAskedGroup() != null) {
            sicmedAsked.setAskedGroup(sicmedAskedBean.getAskedGroup());

        }
        if (sicmedAskedBean.getOrderCode() != null) {
            sicmedAsked.setOrderCode(sicmedAskedBean.getOrderCode());

        }
        return sicmedAsked;
    }
}