package com.thinkgem.jeesite.cfq.mobile.rest.setBean;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatient;

/**
 * @author Max
 * @version 2016-07-12
 */
public class SicmedPatientSetBean {

    public static SicmedPatient setSPB(SicmedPatientBean sicmedPatientBean, SicmedPatient sicmedPatient) {

        // 判断 患者对象是否为空
        if (sicmedPatient == null) {
            sicmedPatient = new SicmedPatient();
        }
        // 给患者对象赋值
        sicmedPatient.setPatientName(sicmedPatientBean.getPatientName());
        sicmedPatient.setPatientSex(sicmedPatientBean.getPatientSex());
        sicmedPatient.setPatientAge(sicmedPatientBean.getPatientAge());
        sicmedPatient.setPatientCard(sicmedPatientBean.getPatientCard());
        sicmedPatient.setPatientTel(sicmedPatientBean.getPatientTel());
        // 返回患者对象
        return sicmedPatient;

    }

}