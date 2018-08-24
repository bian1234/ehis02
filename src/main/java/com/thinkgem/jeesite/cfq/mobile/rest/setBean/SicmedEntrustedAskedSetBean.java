/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.setBean;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedEntrustedAskedBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedEntrustedAsked;

/**
 * 单表生成Entity
 *
 * @author yjx
 * @version 2016-07-28
 */
public class SicmedEntrustedAskedSetBean {

    public static SicmedEntrustedAsked setSEA(SicmedEntrustedAskedBean sicmedEntrustedAskedBean, SicmedEntrustedAsked sicmedEntrustedAsked) {

        sicmedEntrustedAsked = new SicmedEntrustedAsked();
        if (sicmedEntrustedAskedBean.getId() != null) {
            sicmedEntrustedAsked.setId(sicmedEntrustedAskedBean.getId());
        }
        if (sicmedEntrustedAskedBean.getEntrustedAsked() != null) {
            sicmedEntrustedAsked.setEntrustedAsked(sicmedEntrustedAskedBean.getEntrustedAsked());
        }
        if (sicmedEntrustedAskedBean.getOrderCode() != null) {
            sicmedEntrustedAsked.setOrderCode(sicmedEntrustedAskedBean.getOrderCode());
        }
        return sicmedEntrustedAsked;
    }

}