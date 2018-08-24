package com.thinkgem.jeesite.cfq.mobile.rest.bean.print;

import java.util.List;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedRegisteredBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedUserBean;

public class CurePrintBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String wordId;

    private SicmedUserBean sicmedDoctorBean;
    private SicmedPatientBean sicmedPatientBean;
    private SicmedCaseBean sicmedCaseBean;
    private SicmedRegisteredBean sicmedRegisteredBean;
    private List<CurePrintBean> curePrintBean = Lists.newArrayList();

    public String getWordId() {
        return wordId;
    }

    public void setWordId(String wordId) {
        this.wordId = wordId;
    }

    public SicmedUserBean getSicmedDoctorBean() {
        return sicmedDoctorBean;
    }

    public void setSicmedDoctorBean(SicmedUserBean sicmedDoctorBean) {
        this.sicmedDoctorBean = sicmedDoctorBean;
    }

    public SicmedPatientBean getSicmedPatientBean() {
        return sicmedPatientBean;
    }

    public void setSicmedPatientBean(SicmedPatientBean sicmedPatientBean) {
        this.sicmedPatientBean = sicmedPatientBean;
    }

    public SicmedCaseBean getSicmedCaseBean() {
        return sicmedCaseBean;
    }

    public void setSicmedCaseBean(SicmedCaseBean sicmedCaseBean) {
        this.sicmedCaseBean = sicmedCaseBean;
    }

    public SicmedRegisteredBean getSicmedRegisteredBean() {
        return sicmedRegisteredBean;
    }

    public void setSicmedRegisteredBean(SicmedRegisteredBean sicmedRegisteredBean) {
        this.sicmedRegisteredBean = sicmedRegisteredBean;
    }

    public List<CurePrintBean> getCurePrintBean() {
        return curePrintBean;
    }

    public void setCurePrintBean(List<CurePrintBean> curePrintBean) {
        this.curePrintBean = curePrintBean;
    }


}