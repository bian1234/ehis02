/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;

/**
 * RESTful接口示例Entity
 *
 * @author DING
 * @version 2016-07-22
 */
public class SicmedCheckPrice extends DataEntity<SicmedCheckPrice> {

    private static final long serialVersionUID = 1L;
    private Date checkPriceCutoffDate;        // 价格变更截止时间
    private Date checkPriceInsertDate;        // 价格变更开始时间
    private String checkPrice;        // 检查价格
    private Date beginCheckPriceCutoffDate;        // 开始 价格变更截止时间
    private Date endCheckPriceCutoffDate;        // 结束 价格变更截止时间
    private Date beginCheckPriceInsertDate;        // 开始 价格变更开始时间
    private Date endCheckPriceInsertDate;        // 结束 价格变更开始时间
    private SicmedTwxrayCheck sicmedTwxrayCheck;        // 放射线检查编码(对应放射性检查表)

    private Date startDate;                //查询 起始时间
    private Date endDate;                //查询 截止时间
    private String isUsePrice;                //价格是否启用(根据对象的delFlag属性进行判断)

    public SicmedCheckPrice() {
        super();
    }

    public SicmedCheckPrice(String id) {
        super(id);
    }

    public SicmedTwxrayCheck getSicmedTwxrayCheck() {
        return sicmedTwxrayCheck;
    }

    public void setSicmedTwxrayCheck(SicmedTwxrayCheck sicmedTwxrayCheck) {
        this.sicmedTwxrayCheck = sicmedTwxrayCheck;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "价格变更截止时间不能为空")
    public Date getCheckPriceCutoffDate() {
        return checkPriceCutoffDate;
    }

    public void setCheckPriceCutoffDate(Date checkPriceCutoffDate) {
        this.checkPriceCutoffDate = checkPriceCutoffDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "价格变更开始时间不能为空")
    public Date getCheckPriceInsertDate() {
        return checkPriceInsertDate;
    }

    public void setCheckPriceInsertDate(Date checkPriceInsertDate) {
        this.checkPriceInsertDate = checkPriceInsertDate;
    }


    //	@Length(min=0, max=11, message="检查价格长度必须介于 0 和 11 之间")
    public String getCheckPrice() {
        return checkPrice;
    }

    public void setCheckPrice(String checkPrice) {
        this.checkPrice = checkPrice;
    }

    public Date getBeginCheckPriceCutoffDate() {
        return beginCheckPriceCutoffDate;
    }

    public void setBeginCheckPriceCutoffDate(Date beginCheckPriceCutoffDate) {
        this.beginCheckPriceCutoffDate = beginCheckPriceCutoffDate;
    }

    public Date getEndCheckPriceCutoffDate() {
        return endCheckPriceCutoffDate;
    }

    public void setEndCheckPriceCutoffDate(Date endCheckPriceCutoffDate) {
        this.endCheckPriceCutoffDate = endCheckPriceCutoffDate;
    }

    public Date getBeginCheckPriceInsertDate() {
        return beginCheckPriceInsertDate;
    }

    public void setBeginCheckPriceInsertDate(Date beginCheckPriceInsertDate) {
        this.beginCheckPriceInsertDate = beginCheckPriceInsertDate;
    }

    public Date getEndCheckPriceInsertDate() {
        return endCheckPriceInsertDate;
    }

    public void setEndCheckPriceInsertDate(Date endCheckPriceInsertDate) {
        this.endCheckPriceInsertDate = endCheckPriceInsertDate;
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

/*	public void setIsUsePrice(String isUsePrice) {
        this.isUsePrice = isUsePrice;
	}*/

}