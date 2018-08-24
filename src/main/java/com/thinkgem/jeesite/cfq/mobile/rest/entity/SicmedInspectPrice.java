/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;


import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;


/**
 * RESTful接口示例Entity
 *
 * @author DING
 * @version 2016-07-22
 */
public class SicmedInspectPrice extends DataEntity<SicmedInspectPrice> {

    private static final long serialVersionUID = 1L;
    //	private String priceCode;		// 价格编号
    private String price;        // 价格
    private Date priceCutoffDate;        // 价格截止时间
    private Date priceInsertDate;        // 价格启用时间

    private SicmedInspect sicmedInspect;        // 检验编号(检验表编号)
    private Date startDate;                //查询开始时间
    private Date endDate;                //查询截止时间

    private String isUsePrice;                //价格是否启用(根据对象的delFlag属性进行判断)

    public SicmedInspectPrice() {
        super();
    }

    public SicmedInspectPrice(String id) {
        super(id);
    }

    public SicmedInspect getSicmedInspect() {
        return sicmedInspect;
    }

    public void setSicmedInspect(SicmedInspect sicmedInspect) {
        this.sicmedInspect = sicmedInspect;
    }

    @Length(min = 0, max = 11, message = "价格长度必须介于 0 和 11 之间")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "价格截止时间不能为空")
    public Date getPriceCutoffDate() {
        return priceCutoffDate;
    }

    public void setPriceCutoffDate(Date priceCutoffDate) {
        this.priceCutoffDate = priceCutoffDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "价格启用时间不能为空")
    public Date getPriceInsertDate() {
        return priceInsertDate;
    }

    public void setPriceInsertDate(Date priceInsertDate) {
        this.priceInsertDate = priceInsertDate;
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