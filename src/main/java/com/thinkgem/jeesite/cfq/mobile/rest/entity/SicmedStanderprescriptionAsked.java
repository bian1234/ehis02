package com.thinkgem.jeesite.cfq.mobile.rest.entity;


import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;


/**
 * 标准处方中的医嘱Entity
 *
 * @author Max
 * @version 2016-07-20
 */
public class SicmedStanderprescriptionAsked extends DataEntity<SicmedStanderprescriptionAsked> {

    private static final long serialVersionUID = 1L;
    private SicmedStanderprescriptionDisease sicmedStanderprescription;  //标准处方
    private SicmedAskedClass sicmedAskedClass; //医嘱类别
    private String orderCode;   //医嘱项目ID

    //	private SicmedAsked sicmedAsked;		// 医嘱编码(对应医嘱表)
    private SicmedMedicalUse sicmedMedicalUse; // 药品用法
    private SicmedUser createUser;
    private SicmedUser updateUser;

    private String detailStr;  //统计使用

    private String askedGroup;  //统计使用
//	public SicmedAsked getSicmedAsked() {
//		return sicmedAsked;
//	}
//
//	public void setSicmedAsked(SicmedAsked sicmedAsked) {
//		this.sicmedAsked = sicmedAsked;
//	}

    public SicmedStanderprescriptionAsked() {
        super();
    }


    public SicmedStanderprescriptionAsked(String id) {
        super(id);
    }


    public String getDetailStr() {
        return detailStr;
    }

    public void setDetailStr(String detailStr) {
        this.detailStr = detailStr;
    }

    public SicmedMedicalUse getSicmedMedicalUse() {
        return sicmedMedicalUse;
    }

    public void setSicmedMedicalUse(SicmedMedicalUse sicmedMedicalUse) {
        this.sicmedMedicalUse = sicmedMedicalUse;
    }

    public SicmedStanderprescriptionDisease getSicmedStanderprescription() {
        return sicmedStanderprescription;
    }

    public void setSicmedStanderprescription(SicmedStanderprescriptionDisease sicmedStanderprescription) {
        this.sicmedStanderprescription = sicmedStanderprescription;
    }

    public SicmedAskedClass getSicmedAskedClass() {
        return sicmedAskedClass;
    }

    public void setSicmedAskedClass(SicmedAskedClass sicmedAskedClass) {
        this.sicmedAskedClass = sicmedAskedClass;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public SicmedUser getCreateUser() {
        return createUser;
    }

    public void setCreateUser(SicmedUser createUser) {
        this.createUser = createUser;
    }

    public SicmedUser getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(SicmedUser updateUser) {
        this.updateUser = updateUser;
    }

    public String getAskedGroup() {
        return askedGroup;
    }

    public void setAskedGroup(String askedGroup) {
        this.askedGroup = askedGroup;
    }

}