package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 医嘱信息Entity
 *
 * @author XUE
 * @version 2016-07-12
 */
public class SicmedAskedBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    private List<SicmedAskedBean> sicmedAskedBeans = new ArrayList<SicmedAskedBean>();

    public List<SicmedAskedBean> getSicmedAskedBeans() {
        return sicmedAskedBeans;
    }

    public void setSicmedAskedBeans(List<SicmedAskedBean> sicmedAskedBeans) {
        this.sicmedAskedBeans = sicmedAskedBeans;
    }

}