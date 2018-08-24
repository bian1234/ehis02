package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.List;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCase;


/**
 * @author Max
 */

public class SicmedCaseBeans extends BaseBean {

    private static final long serialVersionUID = 1L;
    private List<SicmedCaseBean> sicmedCaseBeans = Lists.newArrayList();

    public void setSicmedCaseBeanList(List<SicmedCase> sicmedCaseList) {
        if (sicmedCaseList == null || sicmedCaseList.size() == 0) {
            this.setError("1");
            this.setErrorMessage("没有找到任何数据");
            return;
        }
        for (SicmedCase sicmedCase : sicmedCaseList) {
            SicmedCaseBean sicmedCaseBean = new SicmedCaseBean();
            sicmedCaseBean.setSicmedCase(sicmedCase);
            sicmedCaseBeans.add(sicmedCaseBean);
        }
        this.setSuccessMessage("访问成功");
    }

    public List<SicmedCaseBean> getSicmedCaseBeans() {
        return sicmedCaseBeans;
    }

    public void setSicmedCaseBeans(List<SicmedCaseBean> sicmedCaseBeans) {
        this.sicmedCaseBeans = sicmedCaseBeans;
    }


}