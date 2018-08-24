/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;


/**
 * 药品价格信息Entity
 *
 * @author 丁学志
 * @version 2016-07-12
 */
public class SicmedMedicalPrice extends DataEntity<SicmedMedicalPrice> {

    private static final long serialVersionUID = 1L;
    private Date priceCutoffDate;        // 价格变更截止时间
    private Date priceInsertDate;        // 价格变更开始时间
    private String priceEnter;        // 药品进价
    private String priceSale;        // 药品售价
    private String insertUser;        // 插入id(对应用户表主键)
    private String insertDept;        // 插入部门(对应部门表ID)

    private SicmedMedical sicmedMedical;        // 药品编码(对应药品表中的主键)
    //创建父表对象
    private SicmedMedical medical;

    private Date startDate;//查询使用 起始时间
    private Date endDate;  //查询使用 截止时间
    private String isUsePrice;                //价格是否启用(根据对象的delFlag属性进行判断)

    public SicmedMedicalPrice() {
        super();
    }

    public SicmedMedicalPrice(String id) {
        super(id);
    }

    public SicmedMedical getSicmedMedical() {
        return sicmedMedical;
    }

    public void setSicmedMedical(SicmedMedical sicmedMedical) {
        this.sicmedMedical = sicmedMedical;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "价格变更截止时间不能为空")
    public Date getPriceCutoffDate() {
        return priceCutoffDate;
    }

    public void setPriceCutoffDate(Date priceCutoffDate) {
        this.priceCutoffDate = priceCutoffDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "价格变更开始时间不能为空")
    public Date getPriceInsertDate() {
        return priceInsertDate;
    }

    public void setPriceInsertDate(Date priceInsertDate) {
        this.priceInsertDate = priceInsertDate;
    }

    @Length(min = 0, max = 11, message = "药品进价长度必须介于 0 和 11 之间")
    public String getPriceEnter() {
        return priceEnter;
    }

    public void setPriceEnter(String priceEnter) {
        this.priceEnter = priceEnter;
    }

    @Length(min = 0, max = 11, message = "药品售价长度必须介于 0 和 11 之间")
    public String getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(String priceSale) {
        this.priceSale = priceSale;
    }

    @Length(min = 0, max = 32, message = "插入id(对应用户表主键)长度必须介于 0 和 32 之间")
    public String getInsertUser() {
        return insertUser;
    }

    public void setInsertUser(String insertUser) {
        this.insertUser = insertUser;
    }

    @Length(min = 0, max = 32, message = "插入部门(对应部门表ID)长度必须介于 0 和 32 之间")
    public String getInsertDept() {
        return insertDept;
    }

    public void setInsertDept(String insertDept) {
        this.insertDept = insertDept;
    }

    public SicmedMedical getMedical() {
        return medical;
    }

    public void setMedical(SicmedMedical medical) {
        this.medical = medical;
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

    public String getIsUsePrice() {

        switch (Integer.valueOf(this.getDelFlag())) {
            case 0:
                this.isUsePrice = "启用";
                break;
            case 1:
                this.isUsePrice = "未启用";
                break;
            default:
                this.isUsePrice = "未知";
                break;
        }

        return isUsePrice;
    }


}