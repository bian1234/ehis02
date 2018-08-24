/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCheckPrice;

/**
 * 放射性检查价格表Entity
 *
 * @author 丁学志
 * @version 2016-07-12
 */
public class SicmedCheckPriceBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private Date checkPriceCutoffDate;        // 价格变更截止时间
    private Date checkPriceInsertDate;        // 价格变更开始时间
    private String checkCode;        // 放射线检查编码(对应放射性检查表)
    private String checkPrice;        // 检查价格
    private Date beginCheckPriceCutoffDate;        // 开始 价格变更截止时间
    private Date endCheckPriceCutoffDate;        // 结束 价格变更截止时间
    private Date beginCheckPriceInsertDate;        // 开始 价格变更开始时间
    private Date endCheckPriceInsertDate;        // 结束 价格变更开始时间

    public void setSicmedCheckPrice(SicmedCheckPrice sicmedCheckPrice) {
        if (sicmedCheckPrice != null) {

//			this.checkPriceCutoffDate = sicmedCheckPrice.getCheckPriceCutoffDate();
//			this.checkPriceInsertDate = sicmedCheckPrice.getCheckPriceInsertDate();
//			this.checkCode = sicmedCheckPrice.getCheckCode();
            this.checkPrice = sicmedCheckPrice.getCheckPrice();
//			this.beginCheckPriceCutoffDate = sicmedCheckPrice.getBeginCheckPriceCutoffDate();
//			this.endCheckPriceCutoffDate = sicmedCheckPrice.getEndCheckPriceCutoffDate();
//			this.beginCheckPriceInsertDate = sicmedCheckPrice.getBeginCheckPriceInsertDate();
//			this.endCheckPriceInsertDate = sicmedCheckPrice.getEndCheckPriceInsertDate();

        } else {
            super.setError("1");
            super.setErrorMessage("所查的信息不存在");
        }
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	@NotNull(message="价格变更截止时间不能为空")
    public Date getCheckPriceCutoffDate() {
        return checkPriceCutoffDate;
    }

    public void setCheckPriceCutoffDate(Date checkPriceCutoffDate) {
        this.checkPriceCutoffDate = checkPriceCutoffDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCheckPriceInsertDate() {
        return checkPriceInsertDate;
    }

    public void setCheckPriceInsertDate(Date checkPriceInsertDate) {
        this.checkPriceInsertDate = checkPriceInsertDate;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getCheckPrice() {
        return checkPrice;
    }

    public void setCheckPrice(String checkPrice) {
        this.checkPrice = checkPrice;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getBeginCheckPriceCutoffDate() {
        return beginCheckPriceCutoffDate;
    }

    public void setBeginCheckPriceCutoffDate(Date beginCheckPriceCutoffDate) {
        this.beginCheckPriceCutoffDate = beginCheckPriceCutoffDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getEndCheckPriceCutoffDate() {
        return endCheckPriceCutoffDate;
    }

    public void setEndCheckPriceCutoffDate(Date endCheckPriceCutoffDate) {
        this.endCheckPriceCutoffDate = endCheckPriceCutoffDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getBeginCheckPriceInsertDate() {
        return beginCheckPriceInsertDate;
    }

    public void setBeginCheckPriceInsertDate(Date beginCheckPriceInsertDate) {
        this.beginCheckPriceInsertDate = beginCheckPriceInsertDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getEndCheckPriceInsertDate() {
        return endCheckPriceInsertDate;
    }

    public void setEndCheckPriceInsertDate(Date endCheckPriceInsertDate) {
        this.endCheckPriceInsertDate = endCheckPriceInsertDate;
    }

}