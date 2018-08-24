package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.Date;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalPrice;

public class SicmedMedicalPriceBean extends BaseBean {

    private static final long serialVersionUID = 1L;
    private Date priceCutoffDate;        // 价格变更截止时间
    private Date priceInsertDate;        // 价格变更开始时间
    //	private SicmedMedicalBean sicmedMedicalBean;		// 药品编码(对应药品表中的主键)
    private String priceEnter;        // 药品进价
    private String priceSale;        // 药品售价
    private String insertUser;        // 插入id(对应用户表主键)
    private String insertDept;        // 插入部门(对应部门表ID)

    public void setSicmedMedicaPrice(SicmedMedicalPrice medicalPrice) {

        if (medicalPrice != null) {

            this.priceCutoffDate = medicalPrice.getPriceCutoffDate();
            this.priceInsertDate = medicalPrice.getPriceInsertDate();
            this.priceEnter = medicalPrice.getPriceEnter();
            this.priceSale = medicalPrice.getPriceSale();
            this.insertUser = medicalPrice.getInsertUser();
            this.insertDept = medicalPrice.getInsertDept();

        }

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

    public String getPriceEnter() {
        return priceEnter;
    }

    public void setPriceEnter(String priceEnter) {
        this.priceEnter = priceEnter;
    }

    public String getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(String priceSale) {
        this.priceSale = priceSale;
    }

    public String getInsertUser() {
        return insertUser;
    }

    public void setInsertUser(String insertUser) {
        this.insertUser = insertUser;
    }

    public String getInsertDept() {
        return insertDept;
    }

    public void setInsertDept(String insertDept) {
        this.insertDept = insertDept;
    }


}
