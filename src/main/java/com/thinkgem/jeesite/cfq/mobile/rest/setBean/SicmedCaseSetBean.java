package com.thinkgem.jeesite.cfq.mobile.rest.setBean;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCase;

/**
 * 基础编码表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedCaseSetBean {

    public static SicmedCase setSCB(SicmedCaseBean sicmedCaseBean, SicmedCase sicmedCase) {

        if (sicmedCase == null) {
            sicmedCase = new SicmedCase();

        }
        if (sicmedCaseBean.getId() != null) {
            sicmedCase.setId(sicmedCaseBean.getId());
        }

        if (sicmedCaseBean.getCaseTell() != null) {
            sicmedCase.setCaseTell(sicmedCaseBean.getCaseTell());
        }

        if (sicmedCaseBean.getCaseHistory() != null) {
            sicmedCase.setCaseHistory(sicmedCaseBean.getCaseHistory());
        }
        if (sicmedCaseBean.getPastHistory() != null) {
            sicmedCase.setPastHistory(sicmedCaseBean.getPastHistory());

        }
        if (sicmedCaseBean.getCaseAllergy() != null) {
            sicmedCase.setCaseAllergy(sicmedCaseBean.getCaseAllergy());

        }
        if (sicmedCaseBean.getFamilyAllergy() != null) {
            sicmedCase.setFamilyAllergy(sicmedCaseBean.getFamilyAllergy());

        }
        if (sicmedCaseBean.getCheckCodeBody() != null) {
            sicmedCase.setCheckCodeBody(sicmedCaseBean.getCheckCodeBody());

        }
        if (sicmedCaseBean.getCheckCodeAid() != null) {
            sicmedCase.setCheckCodeAid(sicmedCaseBean.getCheckCodeAid());

        }
        return sicmedCase;
    }
}