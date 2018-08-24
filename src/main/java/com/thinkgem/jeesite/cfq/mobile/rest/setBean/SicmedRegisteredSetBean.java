package com.thinkgem.jeesite.cfq.mobile.rest.setBean;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedRegisteredBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegistered;

public class SicmedRegisteredSetBean {

    public static SicmedRegistered setSRB(SicmedRegisteredBean sicmedRegisteredBean,
                                          SicmedRegistered sicmedRegistered) {

        if (sicmedRegistered == null) {

            sicmedRegistered = new SicmedRegistered();
        }


        return sicmedRegistered;

    }

}