package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import java.util.Date;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;

/**
 * 药品详细信息Entity
 *
 * @author 丁学志
 * @version 2016-07-12
 */
public class SicmedMedical extends DataEntity<SicmedMedical> {

    private static final long serialVersionUID = 1L;
    private Date medicalFrdate;        // 药品开始日期
    private Date medicalTodate;        // 药品截止日期
    private String medicalCode;        // 药品编号
    private String medicalGroup;        // 药品所属类别编号(对应基础编码表中的BUN字段)
    private String medicalCompany;
    private String medicalNameChina;        // 药品名称
    private String medicalNameEnglish;        // 药品英文名
    private String medicalStand;        // 药品规格
    private SicmedMedical medical;
    private String medicalUseNumber;    //用药频次（每日多少次）
    private String medicalMeasure;        //单词剂量（每次多少）
    private String medicalUse;            //给药途径（外服、口服）
    private String unit1;   //药品单位1
    private String unit2;   //药品单位2
    private String detail;   //药品详情

    private String medicalNamePinyin;
    private String medicalIngredient;
    private String medicalTraits;
    private String medicalIndications;
    private String medicalSpecification;
    private String medicalDosageUsage;
    private String medicalAdverseReactions;
    private String medicalTaboo;
    private String medicalPrecautions;
    private String medicalPregnantWomenLactatingWomen;
    private String medicalPediatricUse;
    private String medicalElderlyMedication;
    private String medicalMedicineInteractions;
    private String medicalDrugOverdose;
    private String medicalClinicalTrials;
    private String medicalPharmacologyToxicology;
    private String medicalPharmacokinetics;
    private String medicalPackage;
    private String medicalPeriodValidity;
    private String medicalImplementationStandards;
    private String medicalApprovalNumber;
    private String medicalManufacturer;
    private String medicalStorage;

    //药品价格的实体
    private SicmedMedicalPrice medicalPrice;

//	private SicmedMedicalClass medicalClass;


    private SicmedMedicalClass medicalClassOne;
    private SicmedMedicalClass medicalClassTwo;
    private SicmedMedicalClass medicalClassThree;

    //创建药品价格的list列表
    private List<SicmedMedicalPrice> medicalPriceList = Lists.newArrayList();

    //基础编码表的实体
    private SicmedBaseCode baseCode;

    public SicmedMedical() {
        super();
    }

    public SicmedMedical(String id) {
        super(id);
    }

    public SicmedMedicalPrice getMedicalPrice() {
        return medicalPrice;
    }

    public String getUnit1() {
        return unit1;
    }

    public void setUnit1(String unit1) {
        this.unit1 = unit1;
    }

    public SicmedMedicalClass getMedicalClassTwo() {
        return medicalClassTwo;
    }

    public void setMedicalClassTwo(SicmedMedicalClass medicalClassTwo) {
        this.medicalClassTwo = medicalClassTwo;
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

    public void setMedicalPrice(SicmedMedicalPrice medicalPrice) {
        this.medicalPrice = medicalPrice;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	@NotNull(message="药品开始日期不能为空")
    public Date getMedicalFrdate() {
        return medicalFrdate;
    }

    public void setMedicalFrdate(Date medicalFrdate) {
        this.medicalFrdate = medicalFrdate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getMedicalTodate() {
        return medicalTodate;
    }

    public void setMedicalTodate(Date medicalTodate) {
        this.medicalTodate = medicalTodate;
    }

    @Length(min = 0, max = 15, message = "药品编号长度必须介于 0 和 10 之间")
    public String getMedicalCode() {
        return medicalCode;
    }

    public void setMedicalCode(String medicalCode) {
        this.medicalCode = medicalCode;
    }

    @Length(min = 0, max = 2, message = "药品所属类别编号(对应基础编码表中的BUN字段)长度必须介于 0 和 2 之间")
    public String getMedicalGroup() {
        return medicalGroup;
    }

    public void setMedicalGroup(String medicalGroup) {
        this.medicalGroup = medicalGroup;
    }

    @Length(min = 0, max = 100, message = "药品名称长度必须介于 0 和 100 之间")
    public String getMedicalNameChina() {
        return medicalNameChina;
    }

    public void setMedicalNameChina(String medicalNameChina) {
        this.medicalNameChina = medicalNameChina;
    }

    @Length(min = 0, max = 100, message = "药品英文名长度必须介于 0 和 100 之间")
    public String getMedicalNameEnglish() {
        return medicalNameEnglish;
    }

    public void setMedicalNameEnglish(String medicalNameEnglish) {
        this.medicalNameEnglish = medicalNameEnglish;
    }

    @Length(min = 0, max = 50, message = "药品规格长度必须介于 0 和 50 之间")
    public String getMedicalStand() {
        return medicalStand;
    }

    public void setMedicalStand(String medicalStand) {
        this.medicalStand = medicalStand;
    }

    public SicmedBaseCode getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(SicmedBaseCode baseCode) {
        this.baseCode = baseCode;
    }

    public List<SicmedMedicalPrice> getMedicalPriceList() {
        return medicalPriceList;
    }

    public void setMedicalPriceList(List<SicmedMedicalPrice> medicalPriceList) {
        this.medicalPriceList = medicalPriceList;
    }


    public SicmedMedical getMedical() {
        return medical;
    }

    //
    @JsonBackReference
    public void setMedical(SicmedMedical medical) {
        this.medical = medical;
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

    public String getMedicalCompany() {
        return medicalCompany;
    }

    public void setMedicalCompany(String medicalCompany) {
        this.medicalCompany = medicalCompany;
    }

    public String getMedicalNamePinyin() {
        return medicalNamePinyin;
    }

    public void setMedicalNamePinyin(String medicalNamePinyin) {
        this.medicalNamePinyin = medicalNamePinyin;
    }

    public String getMedicalIngredient() {
        return medicalIngredient;
    }

    public void setMedicalIngredient(String medicalIngredient) {
        this.medicalIngredient = medicalIngredient;
    }

    public String getMedicalTraits() {
        return medicalTraits;
    }

    public void setMedicalTraits(String medicalTraits) {
        this.medicalTraits = medicalTraits;
    }

    public String getMedicalIndications() {
        return medicalIndications;
    }

    public void setMedicalIndications(String medicalIndications) {
        this.medicalIndications = medicalIndications;
    }

    public String getMedicalSpecification() {
        return medicalSpecification;
    }

    public void setMedicalSpecification(String medicalSpecification) {
        this.medicalSpecification = medicalSpecification;
    }

    public String getMedicalDosageUsage() {
        return medicalDosageUsage;
    }

    public void setMedicalDosageUsage(String medicalDosageUsage) {
        this.medicalDosageUsage = medicalDosageUsage;
    }

    public String getMedicalAdverseReactions() {
        return medicalAdverseReactions;
    }

    public void setMedicalAdverseReactions(String medicalAdverseReactions) {
        this.medicalAdverseReactions = medicalAdverseReactions;
    }

    public String getMedicalTaboo() {
        return medicalTaboo;
    }

    public void setMedicalTaboo(String medicalTaboo) {
        this.medicalTaboo = medicalTaboo;
    }

    public String getMedicalPrecautions() {
        return medicalPrecautions;
    }

    public void setMedicalPrecautions(String medicalPrecautions) {
        this.medicalPrecautions = medicalPrecautions;
    }

    public String getMedicalPregnantWomenLactatingWomen() {
        return medicalPregnantWomenLactatingWomen;
    }

    public void setMedicalPregnantWomenLactatingWomen(String medicalPregnantWomenLactatingWomen) {
        this.medicalPregnantWomenLactatingWomen = medicalPregnantWomenLactatingWomen;
    }

    public String getMedicalPediatricUse() {
        return medicalPediatricUse;
    }

    public void setMedicalPediatricUse(String medicalPediatricUse) {
        this.medicalPediatricUse = medicalPediatricUse;
    }

    public String getMedicalElderlyMedication() {
        return medicalElderlyMedication;
    }

    public void setMedicalElderlyMedication(String medicalElderlyMedication) {
        this.medicalElderlyMedication = medicalElderlyMedication;
    }

    public String getMedicalMedicineInteractions() {
        return medicalMedicineInteractions;
    }

    public void setMedicalMedicineInteractions(String medicalMedicineInteractions) {
        this.medicalMedicineInteractions = medicalMedicineInteractions;
    }

    public String getMedicalDrugOverdose() {
        return medicalDrugOverdose;
    }

    public void setMedicalDrugOverdose(String medicalDrugOverdose) {
        this.medicalDrugOverdose = medicalDrugOverdose;
    }

    public String getMedicalClinicalTrials() {
        return medicalClinicalTrials;
    }

    public void setMedicalClinicalTrials(String medicalClinicalTrials) {
        this.medicalClinicalTrials = medicalClinicalTrials;
    }

    public String getMedicalPharmacologyToxicology() {
        return medicalPharmacologyToxicology;
    }

    public void setMedicalPharmacologyToxicology(String medicalPharmacologyToxicology) {
        this.medicalPharmacologyToxicology = medicalPharmacologyToxicology;
    }

    public String getMedicalPharmacokinetics() {
        return medicalPharmacokinetics;
    }

    public void setMedicalPharmacokinetics(String medicalPharmacokinetics) {
        this.medicalPharmacokinetics = medicalPharmacokinetics;
    }

    public String getMedicalPackage() {
        return medicalPackage;
    }

    public void setMedicalPackage(String medicalPackage) {
        this.medicalPackage = medicalPackage;
    }

    public String getMedicalPeriodValidity() {
        return medicalPeriodValidity;
    }

    public void setMedicalPeriodValidity(String medicalPeriodValidity) {
        this.medicalPeriodValidity = medicalPeriodValidity;
    }

    public String getMedicalImplementationStandards() {
        return medicalImplementationStandards;
    }

    public void setMedicalImplementationStandards(String medicalImplementationStandards) {
        this.medicalImplementationStandards = medicalImplementationStandards;
    }

    public String getMedicalApprovalNumber() {
        return medicalApprovalNumber;
    }

    public void setMedicalApprovalNumber(String medicalApprovalNumber) {
        this.medicalApprovalNumber = medicalApprovalNumber;
    }

    public String getMedicalManufacturer() {
        return medicalManufacturer;
    }

    public void setMedicalManufacturer(String medicalManufacturer) {
        this.medicalManufacturer = medicalManufacturer;
    }

    public String getMedicalStorage() {
        return medicalStorage;
    }

    public void setMedicalStorage(String medicalStorage) {
        this.medicalStorage = medicalStorage;
    }

    public SicmedMedicalClass getMedicalClassOne() {
        return medicalClassOne;
    }

    public void setMedicalClassOne(SicmedMedicalClass medicalClassOne) {
        this.medicalClassOne = medicalClassOne;
    }

    public SicmedMedicalClass getMedicalClassThree() {
        return medicalClassThree;
    }

    public void setMedicalClassThree(SicmedMedicalClass medicalClassThree) {
        this.medicalClassThree = medicalClassThree;
    }

}