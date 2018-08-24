package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.Date;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspectPrice;

public class SicmedInspectPriceBean extends BaseBean {

    private static final long serialVersionUID = 1L;
    private String inspectCode;        // 检验编号(检验表编号)
    //	private String priceCode;		// 价格编号
    private String price;        // 价格
    private Date priceCutoffDate;        // 价格截止时间
    private Date priceInsertDate;        // 价格启用时间

    public void setSicmedInspectPriceBean(SicmedInspectPrice inspectPrice) {

        if (inspectPrice != null) {
//			this.inspectCode = inspectPrice.getInspectCode();
            this.price = inspectPrice.getPrice();
        }

    }

    public String getInspectCode() {
        return inspectCode;
    }

    public void setInspectCode(String inspectCode) {
        this.inspectCode = inspectCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getPriceCutoffDate() {
        return priceCutoffDate;
    }

    public void setPriceCutoffDate(Date priceCutoffDate) {
        this.priceCutoffDate = priceCutoffDate;
    }

    public Date getPriceInsertDate() {
        return priceInsertDate;
    }

    public void setPriceInsertDate(Date priceInsertDate) {
        this.priceInsertDate = priceInsertDate;
    }

}
