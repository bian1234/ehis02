package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStanderprescriptionAsked;

/**
 * 标准处方中的医嘱Entity
 *
 * @author Max
 * @version 2016-07-20
 */
public class SicmedStanderprescriptionAskedBean extends BaseBean {

    private static final long serialVersionUID = 1L;
    private String id;
    private String orderCode; // 医嘱项目ID
    private SicmedAskedClassBean sicmedAskedClassBean = new SicmedAskedClassBean();
    private String askedGroup; // 医嘱项目ID
    // 医嘱项目
    private SicmedTwxrayCheckBean sicmedTwxrayCheckBean;
    private SicmedCureCheckBean sicmedCureCheckBean;
    private SicmedInspectBean sicmedInspectBean;
    private SicmedMedicalBean sicmedMedicalBean;
    private SicmedMedicalUseBean sicmedMedicalUseBean;

    public void setSSAB(SicmedStanderprescriptionAsked ssa) {
        this.id = ssa.getId();
        this.orderCode = ssa.getOrderCode();
        if (ssa.getSicmedAskedClass() != null) {
            this.sicmedAskedClassBean.setSac(ssa.getSicmedAskedClass());
            String classNumber = ssa.getSicmedAskedClass().getClassNumber();
            switch (Integer.parseInt(classNumber)) {
                case 0:
                    this.sicmedTwxrayCheckBean = new SicmedTwxrayCheckBean();
                    break;
                case 1:
                    this.sicmedInspectBean = new SicmedInspectBean();
                    break;
                case 2:
                    this.sicmedCureCheckBean = new SicmedCureCheckBean();
                    break;
                case 3:
                    this.sicmedMedicalBean = new SicmedMedicalBean();
                    this.sicmedMedicalUseBean = new SicmedMedicalUseBean();
                    this.askedGroup = ssa.getAskedGroup();
                    break;
                default:
                    break;
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SicmedAskedClassBean getSicmedAskedClassBean() {
        return sicmedAskedClassBean;
    }

    public void setSicmedAskedClassBean(SicmedAskedClassBean sicmedAskedClassBean) {
        this.sicmedAskedClassBean = sicmedAskedClassBean;
    }

    public SicmedTwxrayCheckBean getSicmedTwxrayCheckBean() {
        return sicmedTwxrayCheckBean;
    }

    public void setSicmedTwxrayCheckBean(SicmedTwxrayCheckBean sicmedTwxrayCheckBean) {
        this.sicmedTwxrayCheckBean = sicmedTwxrayCheckBean;
    }

    public SicmedCureCheckBean getSicmedCureCheckBean() {
        return sicmedCureCheckBean;
    }

    public void setSicmedCureCheckBean(SicmedCureCheckBean sicmedCureCheckBean) {
        this.sicmedCureCheckBean = sicmedCureCheckBean;
    }

    public SicmedInspectBean getSicmedInspectBean() {
        return sicmedInspectBean;
    }

    public void setSicmedInspectBean(SicmedInspectBean sicmedInspectBean) {
        this.sicmedInspectBean = sicmedInspectBean;
    }

    public SicmedMedicalBean getSicmedMedicalBean() {
        return sicmedMedicalBean;
    }

    public void setSicmedMedicalBean(SicmedMedicalBean sicmedMedicalBean) {
        this.sicmedMedicalBean = sicmedMedicalBean;
    }

    public SicmedMedicalUseBean getSicmedMedicalUseBean() {
        return sicmedMedicalUseBean;
    }

    public void setSicmedMedicalUseBean(SicmedMedicalUseBean sicmedMedicalUseBean) {
        this.sicmedMedicalUseBean = sicmedMedicalUseBean;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getAskedGroup() {
        return askedGroup;
    }

    public void setAskedGroup(String askedGroup) {
        this.askedGroup = askedGroup;
    }

}