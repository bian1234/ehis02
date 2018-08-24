package com.thinkgem.jeesite.cfq.mobile.rest.setBean;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalUseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalUse;

/**
 * 基础编码表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedMedicalUseSetBean {

    public static SicmedMedicalUse setSMUB(SicmedMedicalUseBean sicmedMedicalUseBean,
                                           SicmedMedicalUse sicmedMedicalUse) {

        if (sicmedMedicalUse == null) {

            sicmedMedicalUse = new SicmedMedicalUse();
        }

        if (sicmedMedicalUseBean.getUseAmount() != null) {
            sicmedMedicalUse.setUseAmount(sicmedMedicalUseBean.getUseAmount());
        }
        if (sicmedMedicalUseBean.getUseBout() != null) {
            sicmedMedicalUse.setUseBout(sicmedMedicalUseBean.getUseBout());
        }
        if (sicmedMedicalUseBean.getUseBun() != null) {
            sicmedMedicalUse.setUseBun(sicmedMedicalUseBean.getUseBun());
        }
        if (sicmedMedicalUseBean.getUseDay() != null) {
            sicmedMedicalUse.setUseDay(sicmedMedicalUseBean.getUseDay());
        }
        if (sicmedMedicalUseBean.getUseGroup() != null) {
            sicmedMedicalUse.setUseGroup(sicmedMedicalUseBean.getUseGroup());
        }
        if (sicmedMedicalUseBean.getUseUnit() != null) {
            sicmedMedicalUse.setUseUnit(sicmedMedicalUseBean.getUseUnit());
        }

        return sicmedMedicalUse;

    }

}