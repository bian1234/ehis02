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
public class SicmedCurePrice extends DataEntity<SicmedCurePrice> {

    private static final long serialVersionUID = 1L;
    /*	private String cureType;		// 治疗类型
        private String priceCode;		// 价格编号
    */    private String price;        // 价格
    private Date priceCutoffDate;        // 价格截止时间
    private Date priceInsertDate;        // 价格启用时间
/*	private SicmedCureClass cureCode;*/

    private SicmedCureCheck sicmedCureCheck;        // 治疗编号
    private Date startDate;                //查询开始时间
    private Date endDate;                //查询截止时间

    private String isUsePrice;                //价格是否启用(根据对象的delFlag属性进行判断)

    public SicmedCurePrice() {
        super();
    }

    public SicmedCurePrice(String id) {
        super(id);
    }

    public SicmedCureCheck getSicmedCureCheck() {
        return sicmedCureCheck;
    }

    public void setSicmedCureCheck(SicmedCureCheck sicmedCureCheck) {
        this.sicmedCureCheck = sicmedCureCheck;
    }

/*	@Length(min=0, max=2, message="治疗类型长度必须介于 0 和 2 之间")
    public String getCureType() {
		return cureType;
	}

	public void setCureType(String cureType) {
		this.cureType = cureType;
	}
	
	@Length(min=0, max=32, message="价格编号长度必须介于 0 和 32 之间")
	public String getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(String priceCode) {
		this.priceCode = priceCode;
	}*/

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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /*	public SicmedCureClass getCureCode() {
            return cureCode;
        }

        public void setCureCode(SicmedCureClass cureCode) {
            this.cureCode = cureCode;
        }*/
    public String getIsUsePrice() {
        if (isUsePrice != null || delFlag == null) {
            return isUsePrice;
        }
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