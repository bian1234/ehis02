package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatient;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatientPrice;

public class SicmedPatientPriceBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    //UUID 用来删除
    private String patientPriceID;

    private String patientCode;        // 患者编号(对应患者信息表)
    private String priceClassType;        // 患者收费类别
    private String priceCode;        // 收费项目编号
    private String price;        // 收费项目价格
    private String isPay;
    private String priceName;    //收费项目对应的具体名称

    private Integer inspectSum;        //检验
    private Integer checkSum;        //检查
    private Integer curetSum;        //治疗
    private Integer medicalSum;        //药品
    private Integer inspectPay;        //检查诊金
    private Integer checkPay;        //检验诊金
    private Integer curetPay;        //治疗诊金
    private Integer medicalPay;        //药品诊金
    private Integer allSum;            //总价


    //	private SicmedUserBean createUserBean;
//	private SicmedUserBean updateUserBean;
    private SicmedPatientBean patientBean;

    private List<SicmedPatientPriceBean> patientPriceList = Lists.newArrayList();
    private List<SicmedPatientPriceBean> inspectList = Lists.newArrayList();
    private List<SicmedPatientPriceBean> checkList = Lists.newArrayList();
    private List<SicmedPatientPriceBean> curetList = Lists.newArrayList();
    private List<SicmedPatientPriceBean> medicalList = Lists.newArrayList();

    public void setSicmedPatientPrice(SicmedPatientPrice patientPrice) {

        if (patientPrice != null) {
            this.priceClassType = patientPrice.getPriceClassType();
            this.priceCode = patientPrice.getPriceCode();
            this.price = patientPrice.getPrice();
            this.priceName = patientPrice.getPriceName();
            this.setIsPay(patientPrice.getIsPay());
        }

    }

    public void setSicmedPatientPrice(SicmedPatient sicmedPatient) {

        if (sicmedPatient != null) {
            SicmedPatientBean patientBean = new SicmedPatientBean();
            patientBean.setSP(sicmedPatient);
            this.setPatientBean(patientBean);
        }

    }

    public void setSicmedPatientPriceSum(Map<String, Integer> tempMap) {
        this.inspectSum = tempMap.get("inspectSum");
        this.inspectPay = tempMap.get("inspectPay");

        this.checkSum = tempMap.get("checkSum");
        this.checkPay = tempMap.get("checkPay");

        this.curetSum = tempMap.get("curetSum");
        this.curetPay = tempMap.get("curetPay");

        this.medicalSum = tempMap.get("medicalSum");
        this.medicalPay = tempMap.get("medicalPay");

        this.allSum = tempMap.get("allSum");
    }

    public void setSicmedPatientPrice(List<SicmedPatientPrice> patientPriceList) {

        //创建一个迭代器
        Iterator<SicmedPatientPrice> iter = patientPriceList.iterator();
        //创建SicmedPatientPrice对象
        SicmedPatientPrice patientPrice = new SicmedPatientPrice();

        while (iter.hasNext()) {

            patientPrice = iter.next();
            SicmedPatientPriceBean patientPriceBean = new SicmedPatientPriceBean();
            patientPriceBean.setSicmedPatientPrice(patientPrice);

            switch (Integer.valueOf(patientPrice.getPriceClassType())) {

                case 0:
                    this.checkList.add(patientPriceBean);
                    this.checkSum = ((this.getCheckSum() == null) ? 0 : this.getCheckSum()) + Integer.valueOf(patientPrice.getPrice());
                    break;
                case 1:
                    this.inspectList.add(patientPriceBean);
                    this.inspectSum = ((this.getInspectSum() == null) ? 0 : this.getInspectSum()) + Integer.valueOf(patientPrice.getPrice());
                    break;
                case 2:
                    this.curetList.add(patientPriceBean);
                    this.curetSum = ((this.getCuretSum() == null) ? 0 : this.getCuretSum()) + Integer.valueOf(patientPrice.getPrice());
                    break;
                case 3:
                    this.medicalList.add(patientPriceBean);
                    this.medicalSum = ((this.getMedicalSum() == null) ? 0 : this.getMedicalSum()) + Integer.valueOf(patientPrice.getPrice());
                    break;
            }

        }

        if (this.getInspectSum() == null) {
            this.setInspectSum(0);
        }

        if (this.getCheckSum() == null) {
            this.setCheckSum(0);
        }

        if (this.getCuretSum() == null) {
            this.setCuretSum(0);
        }

        if (this.getMedicalSum() == null) {
            this.setMedicalSum(0);
        }

        if (this.getInspectList().size() == 0) {
            List<SicmedPatientPriceBean> tempList = Lists.newArrayList();
            SicmedPatientPriceBean tempBean = new SicmedPatientPriceBean();
            tempBean.successNotFoundData();
            tempList.add(tempBean);
            this.setInspectList(tempList);
        }

        if (this.getCheckList().size() == 0) {
            List<SicmedPatientPriceBean> tempList = Lists.newArrayList();
            SicmedPatientPriceBean tempBean = new SicmedPatientPriceBean();
            tempBean.successNotFoundData();
            tempList.add(tempBean);
            this.setCheckList(tempList);
        }

        if (this.getCuretList().size() == 0) {
            List<SicmedPatientPriceBean> tempList = Lists.newArrayList();
            SicmedPatientPriceBean tempBean = new SicmedPatientPriceBean();
            tempBean.successNotFoundData();
            tempList.add(tempBean);
            this.setCuretList(tempList);
        }

        if (this.getMedicalList().size() == 0) {
            List<SicmedPatientPriceBean> tempList = Lists.newArrayList();
            SicmedPatientPriceBean tempBean = new SicmedPatientPriceBean();
            tempBean.successNotFoundData();
            tempList.add(tempBean);
            this.setMedicalList(tempList);
        }

        this.allSum = this.getInspectSum() + this.getCheckSum() + this.getCuretSum() + this.getMedicalSum();

    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public String getPriceClassType() {
        return priceClassType;
    }

    public void setPriceClassType(String priceClassType) {
        this.priceClassType = priceClassType;
    }

    public String getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(String priceCode) {
        this.priceCode = priceCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getInspectSum() {
        return inspectSum;
    }

    public void setInspectSum(Integer inspectSum) {
        this.inspectSum = inspectSum;
    }

    public Integer getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(Integer checkSum) {
        this.checkSum = checkSum;
    }

    public Integer getCuretSum() {
        return curetSum;
    }

    public void setCuretSum(Integer curetSum) {
        this.curetSum = curetSum;
    }

    public Integer getMedicalSum() {
        return medicalSum;
    }

    public void setMedicalSum(Integer medicalSum) {
        this.medicalSum = medicalSum;
    }

    public Integer getAllSum() {
        return allSum;
    }

    public void setAllSum(Integer allSum) {
        this.allSum = allSum;
    }

    public List<SicmedPatientPriceBean> getPatientPriceList() {
        return patientPriceList;
    }

    public void setPatientPriceList(List<SicmedPatientPriceBean> patientPriceList) {
        this.patientPriceList = patientPriceList;
    }

    public List<SicmedPatientPriceBean> getInspectList() {
        return inspectList;
    }

    public void setInspectList(List<SicmedPatientPriceBean> inspectList) {
        this.inspectList = inspectList;
    }

    public List<SicmedPatientPriceBean> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<SicmedPatientPriceBean> checkList) {
        this.checkList = checkList;
    }

    public List<SicmedPatientPriceBean> getCuretList() {
        return curetList;
    }

    public void setCuretList(List<SicmedPatientPriceBean> curetList) {
        this.curetList = curetList;
    }

    public List<SicmedPatientPriceBean> getMedicalList() {
        return medicalList;
    }

    public void setMedicalList(List<SicmedPatientPriceBean> medicalList) {
        this.medicalList = medicalList;
    }

    public String getPatientPriceID() {
        return patientPriceID;
    }

    public void setPatientPriceID(String patientPriceID) {
        this.patientPriceID = patientPriceID;
    }

    public String getIsPay() {
        return isPay;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay;
    }

    public SicmedPatientBean getPatientBean() {
        return patientBean;
    }

    public void setPatientBean(SicmedPatientBean patientBean) {
        this.patientBean = patientBean;
    }

    public Integer getInspectPay() {
        return inspectPay;
    }

    public void setInspectPay(Integer inspectPay) {
        this.inspectPay = inspectPay;
    }

    public Integer getCheckPay() {
        return checkPay;
    }

    public void setCheckPay(Integer checkPay) {
        this.checkPay = checkPay;
    }

    public Integer getCuretPay() {
        return curetPay;
    }

    public void setCuretPay(Integer curetPay) {
        this.curetPay = curetPay;
    }

    public Integer getMedicalPay() {
        return medicalPay;
    }

    public void setMedicalPay(Integer medicalPay) {
        this.medicalPay = medicalPay;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }


}
