/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;


/**
 * RESTful接口示例Entity
 *
 * @author DING
 * @version 2016-07-23
 */
public class SicmedCureCheck extends DataEntity<SicmedCureCheck> {

    private static final long serialVersionUID = 1L;
    private String cureCode;        // 治疗编码
    private String cureName;        // 治疗名称
    /*	private String checkPriceCode;		// 治疗价格(对应治疗价格表)
        private String cureClassCode;		// 治疗类别(对应治疗大分类表)
    */    private String cureDetail;        // 治疗部位及方法
    private String cureNamePY;        // 治疗拼音

    private SicmedCurePrice sicmedCurePrice;
    private SicmedCureClass sicmedCureClass;

    public SicmedCureCheck() {
        super();
    }

    public SicmedCureCheck(String id) {
        super(id);
    }

    @Length(max = 20, message = "治疗编码长度必须为20")
    public String getCureCode() {
        return cureCode;
    }

    public void setCureCode(String cureCode) {
        this.cureCode = cureCode;
    }

    @Length(min = 0, max = 60, message = "治疗名称长度必须介于 0 和 30 之间")
    public String getCureName() {
        return cureName;
    }

    public void setCureName(String cureName) {
        this.cureName = cureName;
    }

/*	@Length(min=0, max=32, message="治疗价格(对应治疗价格表)长度必须介于 0 和 32 之间")
	public String getCheckPriceCode() {
		return checkPriceCode;
	}

	public void setCheckPriceCode(String checkPriceCode) {
		this.checkPriceCode = checkPriceCode;
	}
	
	@Length(min=0, max=32, message="治疗类别(对应治疗大分类表)长度必须介于 0 和 32 之间")
	public String getCureClassCode() {
		return cureClassCode;
	}

	public void setCureClassCode(String cureClassCode) {
		this.cureClassCode = cureClassCode;
	}*/

    @Length(min = 0, max = 32, message = "治疗详情长度必须介于 0 和 200 之间")
    public String getCureDetail() {
        return cureDetail;
    }

    public void setCureDetail(String cureDetail) {
        this.cureDetail = cureDetail;
    }

    public SicmedCurePrice getSicmedCurePrice() {
        return sicmedCurePrice;
    }

    public void setSicmedCurePrice(SicmedCurePrice sicmedCurePrice) {
        this.sicmedCurePrice = sicmedCurePrice;
    }

    public String getCureNamePY() {
        return cureNamePY;
    }

    public void setCureNamePY(String cureNamePY) {
        this.cureNamePY = cureNamePY;
    }

    public SicmedCureClass getSicmedCureClass() {
        return sicmedCureClass;
    }

    public void setSicmedCureClass(SicmedCureClass sicmedCureClass) {
        this.sicmedCureClass = sicmedCureClass;
    }

}