package com.thinkgem.jeesite.cfq.mobile.rest.entity;


import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;

/**
 * 挂号价格Entity
 *
 * @author XUE
 * @version 2016-09-06
 */
public class SicmedRegisteredPrice extends DataEntity<SicmedRegisteredPrice> {

    private static final long serialVersionUID = 1L;
    private SicmedRegisteredType sicmedRegisteredType; // 编号

    private String registeredFee; // 挂号费
    private String clinicsFee; // 诊疗费
    private String materialFee;// 工本费

    public SicmedRegisteredPrice() {
        super();
    }

    public SicmedRegisteredPrice(String id) {
        super(id);
    }

    public String getRegisteredFee() {
        return registeredFee;
    }

    public void setRegisteredFee(String registeredFee) {
        this.registeredFee = registeredFee;
    }

    public String getClinicsFee() {
        return clinicsFee;
    }

    public void setClinicsFee(String clinicsFee) {
        this.clinicsFee = clinicsFee;
    }

    public String getMaterialFee() {
        return materialFee;
    }

    public void setMaterialFee(String materialFee) {
        this.materialFee = materialFee;
    }

    public SicmedRegisteredType getSicmedRegisteredType() {
        return sicmedRegisteredType;
    }

    public void setSicmedRegisteredType(SicmedRegisteredType sicmedRegisteredType) {
        this.sicmedRegisteredType = sicmedRegisteredType;
    }

}