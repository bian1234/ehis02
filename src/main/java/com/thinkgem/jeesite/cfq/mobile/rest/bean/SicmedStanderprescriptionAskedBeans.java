package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 标准处方中的医嘱Entity
 *
 * @author Max
 * @version 2016-07-20
 */
public class SicmedStanderprescriptionAskedBeans extends BaseBean {

    private static final long serialVersionUID = 1L;
    private List<SicmedStanderprescriptionAskedBean> sicmedStanderprescriptionAskedBeans = new ArrayList<SicmedStanderprescriptionAskedBean>();

    public List<SicmedStanderprescriptionAskedBean> getSicmedStanderprescriptionAskedBeans() {
        return sicmedStanderprescriptionAskedBeans;
    }

    public void setSicmedStanderprescriptionAskedBeans(
            List<SicmedStanderprescriptionAskedBean> sicmedStanderprescriptionAskedBeans) {
        this.sicmedStanderprescriptionAskedBeans = sicmedStanderprescriptionAskedBeans;
    }

}