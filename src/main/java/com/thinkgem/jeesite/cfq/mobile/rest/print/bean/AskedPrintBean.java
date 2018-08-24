package com.thinkgem.jeesite.cfq.mobile.rest.print.bean;

import java.util.List;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientBean;

/**
 */
public class AskedPrintBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private SicmedPatientBean sicmedPatientBean = new SicmedPatientBean();

    private List<CheckPrintBean> checkPrintBean = Lists.newArrayList();
    private List<InspectPrintBean> inspectPrintBean = Lists.newArrayList();
    private List<CurePrintBean> curePrintBean = Lists.newArrayList();
    private List<MedicalPrintBean> cMedicalPrintBean = Lists.newArrayList();

    private List<MedicalPrintBean> wMedicalPrintBean = Lists.newArrayList();

    public SicmedPatientBean getSicmedPatientBean() {
        return sicmedPatientBean;
    }

    public void setSicmedPatientBean(SicmedPatientBean sicmedPatientBean) {
        this.sicmedPatientBean = sicmedPatientBean;
    }

    public List<CheckPrintBean> getCheckPrintBean() {
        return checkPrintBean;
    }

    public void setCheckPrintBean(List<CheckPrintBean> checkPrintBean) {
        this.checkPrintBean = checkPrintBean;
    }

    public List<InspectPrintBean> getInspectPrintBean() {
        return inspectPrintBean;
    }

    public void setInspectPrintBean(List<InspectPrintBean> inspectPrintBean) {
        this.inspectPrintBean = inspectPrintBean;
    }

    public List<CurePrintBean> getCurePrintBean() {
        return curePrintBean;
    }

    public void setCurePrintBean(List<CurePrintBean> curePrintBean) {
        this.curePrintBean = curePrintBean;
    }

    public List<MedicalPrintBean> getcMedicalPrintBean() {
        return cMedicalPrintBean;
    }

    public void setcMedicalPrintBean(List<MedicalPrintBean> cMedicalPrintBean) {
        this.cMedicalPrintBean = cMedicalPrintBean;
    }

    public List<MedicalPrintBean> getwMedicalPrintBean() {
        return wMedicalPrintBean;
    }

    public void setwMedicalPrintBean(List<MedicalPrintBean> wMedicalPrintBean) {
        this.wMedicalPrintBean = wMedicalPrintBean;
    }


}