package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAsked;

/**
 * 医嘱信息Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedAskedBean extends BaseBean {

    private static final long serialVersionUID = 1L;
    private String id;
    private String askedCode; // 医嘱编码
    private String askedName; // 医嘱名称
    private String askedGroup; // 医嘱扩展名
    private String orderCode; // 字表编号
    private String remarks;
    private SicmedAskedClassBean sicmedAskedClassBean = new SicmedAskedClassBean();

    // 医嘱项目
    private SicmedTwxrayCheckBean sicmedTwxrayCheckBean;
    private SicmedCureCheckBean sicmedCureCheckBean;
    private SicmedInspectBean sicmedInspectBean;
    private SicmedMedicalBean sicmedMedicalBean;
    private SicmedMedicalUseBean sicmedMedicalUseBean;

    public void setSAB(SicmedAsked sa) {
        this.id = sa.getId();
        this.askedCode = sa.getAskedCode();
        this.askedName = sa.getAskedName();
        this.orderCode = sa.getOrderCode();
        this.askedGroup = sa.getAskedGroup();
    }

    public SicmedMedicalUseBean getSicmedMedicalUseBean() {

        return sicmedMedicalUseBean;
    }

    public void setSicmedMedicalUseBean(SicmedMedicalUseBean sicmedMedicalUseBean) {

        this.sicmedMedicalUseBean = sicmedMedicalUseBean;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //
    // public SicmedCaseBean getSicmedCaseBean() {
    // return sicmedCaseBean;
    // }
    //
    // public void setSicmedCaseBean(SicmedCaseBean sicmedCaseBean) {
    // this.sicmedCaseBean = sicmedCaseBean;
    // }
    //
    public void setSicmedAskedClassBean(SicmedAskedClassBean sicmedAskedClassBean) {
        this.sicmedAskedClassBean = sicmedAskedClassBean;
    }

    public SicmedAskedClassBean getSicmedAskedClassBean() {
        return sicmedAskedClassBean;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getAskedCode() {
        return askedCode;
    }

    public void setAskedCode(String askedCode) {
        this.askedCode = askedCode;
    }

    public String getAskedName() {
        return askedName;
    }

    public void setAskedName(String askedName) {
        this.askedName = askedName;
    }

    public String getAskedGroup() {
        return askedGroup;
    }

    public void setAskedGroup(String askedGroup) {
        this.askedGroup = askedGroup;
    }


}