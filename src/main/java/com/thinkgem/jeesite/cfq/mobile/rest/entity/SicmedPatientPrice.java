/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;
import java.util.Date;

import com.thinkgem.jeesite.cfq.common.utils.excel.annotation.ExcelField;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;


/**
 * 患者价格明细表Entity
 *
 * @author 丁学志
 * @version 2016-07-18
 */
public class SicmedPatientPrice extends DataEntity<SicmedPatientPrice> implements Serializable {

    private static final long serialVersionUID = 1L;
    private String priceClassType;                                // 患者收费类别
    private String doctorId;                                    // 医生编号
    private String isPay;                                        // 患者缴费情况
    private SicmedAsked sicmedAsked;                            // 患者医嘱id;
    private SicmedPatient sicmedPatient;                        // 患者编号(对应患者信息表)
    private SicmedUser createUser;                                // 创建人(对应用户表)
    private SicmedUser updateUser;                                // 修改人(对应用户表)
    private String priceCode;                                    // 收费项目编号

    private String price;                                        // 收费项目价格(不与数据库对应，用来记录Entity单价)
    private String priceName;                                    // 收费项目名称(不与数据库对应，用来记录Entity名称)
    private String priceClassTypeName;                            // priceClassType名称(不与数据库对应，用来记录Entity名称)
    private String payType;                                        // 支付狀態 (0.未繳費 1.缴费 2.退费)
    private Date startDate;                                        // 查询开始时间(过滤时间用)
    private Date endDate;                                        // 查询截止时间(过滤时间用)
    private String copyTableName;                                // 复制表 复制表的名称
    private Date createDate;
    private Boolean isWebUserList = false;                        // 丁学志创建 检录是否为web收费员操作
    private String remarks; //备注

    private String number;

    @Override
    @ExcelField(title = "创建时间", align = 2, sort = 50)
    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public SicmedPatientPrice() {
        super();
    }

    public SicmedPatientPrice(String id) {
        super(id);
    }

    @ExcelField(title = "收费人员", align = 2, sort = 40)
    public String getCreateUserStr() {
        return createUser.getUserName();
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

    @ExcelField(title = "备注", align = 2, sort = 60)
    @Override
    public String getRemarks() {
        return remarks;
    }

    @Override
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @ExcelField(title = "患者名称", align = 2, sort = 10)
    public String getSicmedPatientName() {
        return sicmedPatient.getPatientName();
    }

    @ExcelField(title = "患者身份证号", align = 2, sort = 11)
    public String getSicmedPatientCard() {
        return sicmedPatient.getPatientCard();
    }

    public SicmedPatient getSicmedPatient() {
        return sicmedPatient;
    }

    public void setSicmedPatient(SicmedPatient sicmedPatient) {
        this.sicmedPatient = sicmedPatient;
    }

    @Length(min = 0, max = 1, message = "患者收费类别长度必须介于 0 和 1 之间")
    public String getPriceClassType() {
        return priceClassType;
    }

    public void setPriceClassType(String priceClassType) {
        this.priceClassType = priceClassType;
    }

    //	@Length(min=0, max=32, message="收费项目编号长度必须介于 0 和 32 之间")
    public String getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(String priceCode) {
        this.priceCode = priceCode;
    }

    @Length(min = 0, max = 11, message = "收费项目价格长度必须介于 0 和 11 之间")
    @ExcelField(title = "收费项目价格", align = 2, sort = 30)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public SicmedAsked getSicmedAsked() {
        return sicmedAsked;
    }

    public void setSicmedAsked(SicmedAsked sicmedAsked) {
        this.sicmedAsked = sicmedAsked;
    }

    @Length(min = 0, max = 1, message = "收费状态长度必须介于 0 和 1 之间")
    public String getIsPay() {
        return isPay;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay;
    }

    @ExcelField(title = "收费名称详情", align = 2, sort = 25)
    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }

    @ExcelField(title = "患者分类", align = 2, sort = 20)
    public String getPriceClassTypeName() {
        if (priceClassTypeName != null || priceClassType == null) {
            return priceClassTypeName;
        }
        switch (Integer.valueOf(this.getPriceClassType())) {
            case 0:
                this.setPriceClassTypeName("检查");
                break;
            case 1:
                this.setPriceClassTypeName("检验");
                break;
            case 2:
                this.setPriceClassTypeName("治疗");
                break;
            case 3:
                this.setPriceClassTypeName("药品");
                break;
            case 5:
                this.setPriceClassTypeName("挂号");
                break;
            default:
                break;
        }
        return priceClassTypeName;
    }

    public void setPriceClassTypeName(String priceClassTypeName) {
        this.priceClassTypeName = priceClassTypeName;
    }

    @ExcelField(title = "收费状态", align = 2, sort = 35)
    public String getPayType() {
        if (payType != null || isPay == null) {
            return payType;
        }
        switch (Integer.valueOf(this.getIsPay())) {
            case 0:
                this.setPayType("未缴费");
                break;
            case 1:
                this.setPayType("缴费");
                break;
            case 2:
                this.setPayType("退费");
                break;
            default:
                break;
        }
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCopyTableName() {
        return copyTableName;
    }

    public void setCopyTableName(String copyTableName) {
        this.copyTableName = copyTableName;
    }

    public Boolean getIsWebUserList() {
        return isWebUserList;
    }

    public void setIsWebUserList(Boolean isWebUserList) {
        this.isWebUserList = isWebUserList;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}