package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCurePrice;

public class SicmedCurePriceBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String cureType;        // 治疗类型
    private String price;        // 价格
    private Date priceCutoffDate;        // 价格截止时间
    private Date priceInsertDate;        // 价格启用时间

    public void setSicmedCurePriceBean(SicmedCurePrice sicmedCurePrice) {

        if (sicmedCurePrice != null) {
            this.price = sicmedCurePrice.getPrice();
        }

    }

    public String getCureType() {
        return cureType;
    }

    public void setCureType(String cureType) {
        this.cureType = cureType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getPriceCutoffDate() {
        return priceCutoffDate;
    }

    public void setPriceCutoffDate(Date priceCutoffDate) {
        this.priceCutoffDate = priceCutoffDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getPriceInsertDate() {
        return priceInsertDate;
    }

    public void setPriceInsertDate(Date priceInsertDate) {
        this.priceInsertDate = priceInsertDate;
    }

}
