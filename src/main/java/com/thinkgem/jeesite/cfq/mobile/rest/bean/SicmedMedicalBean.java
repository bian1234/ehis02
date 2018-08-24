package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.Date;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedical;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalPrice;

/* 
 * 创建:丁学志
 * 创建时间:2016.7.15
 * 
 * */
public class SicmedMedicalBean extends BaseBean {

    private static final long serialVersionUID = 1L;


    private String id;
    private String medicalCode;
    private String medicalGroup;
    private String medicalNameChina;
    private String medicalNameEnglish;
    private String medicalStand;

    private String medicalUseNumber;    //用药频次（每日多少次）
    private String medicalMeasure;        //单词剂量（每次多少）
    private String medicalUse;            //给药途径（外服、口服）
    private String unit1;   //药品单位1
    private String unit2;   //药品单位2
    private String detail;   //药品详情
    private String medicalCompany;


    private Date medicalTodate;
    //药品价格对象
    private SicmedMedicalPrice medicalPriceModel;
    //药品价格bean对象
    private SicmedMedicalPriceBean medicalPriceBean;

    /* 药品价格列表。一个药品对应多个价格。
     * 价格表中存放该药品的历史价格
     * */
    private List<SicmedMedicalPrice> medicalPriceList = Lists.newArrayList();

    /**
     * @param medical
     */
    public void setSMB(SicmedMedical medical) {

        this.id = medical.getId();
        this.setMedicalTodate(medical.getMedicalTodate());
        this.medicalNameChina = medical.getMedicalNameChina();
        this.medicalNameEnglish = medical.getMedicalNameEnglish();
        this.medicalGroup = medical.getMedicalGroup();
        this.medicalCode = medical.getMedicalCode();
        this.medicalStand = medical.getMedicalStand();
        this.medicalTodate = medical.getMedicalTodate();
        this.medicalUseNumber = medical.getMedicalUseNumber();
        this.medicalMeasure = medical.getMedicalMeasure();
        this.medicalUse = medical.getMedicalUse();
        this.unit1 = medical.getUnit1();
        this.unit2 = medical.getUnit2();
        this.detail = medical.getDetail();
        this.medicalCompany = medical.getMedicalCompany();

    }

    public void setSicmedMedical(SicmedMedicalPrice medicalPrice) {

		/*
		 * MedicalPriceBean的赋值方法
		 * 
		 * 暂时不采用
		 * 次方法产生的对象，包含medicalPriceBean所有属性的数据。
		 * */
        SicmedMedicalPriceBean sicmedMedicalPrice = new SicmedMedicalPriceBean();
        sicmedMedicalPrice.setPriceSale(medicalPrice.getPriceSale());
        this.medicalPriceBean = sicmedMedicalPrice;
    }


    public String getMedicalUseNumber() {
        return medicalUseNumber;
    }

    public void setMedicalUseNumber(String medicalUseNumber) {
        this.medicalUseNumber = medicalUseNumber;
    }

    public String getMedicalMeasure() {
        return medicalMeasure;
    }

    public void setMedicalMeasure(String medicalMeasure) {
        this.medicalMeasure = medicalMeasure;
    }

    public String getMedicalUse() {
        return medicalUse;
    }

    public void setMedicalUse(String medicalUse) {
        this.medicalUse = medicalUse;
    }

    public String getUnit1() {
        return unit1;
    }

    public void setUnit1(String unit1) {
        this.unit1 = unit1;
    }

    public String getUnit2() {
        return unit2;
    }

    public void setUnit2(String unit2) {
        this.unit2 = unit2;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getMedicalCompany() {
        return medicalCompany;
    }

    public void setMedicalCompany(String medicalCompany) {
        this.medicalCompany = medicalCompany;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SicmedMedicalPrice> getMedicalPriceList() {
        return medicalPriceList;
    }

    public void setMedicalPriceList(List<SicmedMedicalPrice> medicalPriceList) {
        this.medicalPriceList = medicalPriceList;
    }

    public String getMedicalCode() {
        return medicalCode;
    }

    public void setMedicalCode(String medicalCode) {
        this.medicalCode = medicalCode;
    }

    public String getMedicalGroup() {
        return medicalGroup;
    }

    public void setMedicalGroup(String medicalGroup) {
        this.medicalGroup = medicalGroup;
    }

    public String getMedicalNameChina() {
        return medicalNameChina;
    }

    public void setMedicalNameChina(String medicalNameChina) {
        this.medicalNameChina = medicalNameChina;
    }

    public String getMedicalStand() {
        return medicalStand;
    }

    public void setMedicalStand(String medicalStand) {
        this.medicalStand = medicalStand;
    }

    public String getMedicalNameEnglish() {
        return medicalNameEnglish;
    }

    public void setMedicalNameEnglish(String medicalNameEnglish) {
        this.medicalNameEnglish = medicalNameEnglish;
    }

    public SicmedMedicalPriceBean getMedicalPriceBean() {
        return medicalPriceBean;
    }

    public void setMedicalPriceBean(SicmedMedicalPriceBean medicalPriceBean) {

        this.medicalPriceBean = medicalPriceBean;
    }

    public SicmedMedicalPrice getMedicalPriceModel() {
        return medicalPriceModel;
    }

    public void setMedicalPriceModel(SicmedMedicalPrice medicalPrice) {
        this.medicalPriceModel = medicalPrice;
    }

    //@JsonSerialize(using = JsonDateSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getMedicalTodate() {
        return medicalTodate;
    }

    public void setMedicalTodate(Date medicalTodate) {
        this.medicalTodate = medicalTodate;
    }

}
