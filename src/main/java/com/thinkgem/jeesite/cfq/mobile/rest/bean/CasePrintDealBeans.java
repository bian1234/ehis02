package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 病历打印信息 -处理集合
 *
 * @author Max
 */
public class CasePrintDealBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    List<CasePrintDealBean> casePrintDealBeans = new ArrayList<CasePrintDealBean>();

    public List<CasePrintDealBean> getCasePrintDealBeans() {
        return casePrintDealBeans;
    }

    public void setCasePrintDealBeans(List<CasePrintDealBean> casePrintDealBeans) {
        this.casePrintDealBeans = casePrintDealBeans;
    }
}