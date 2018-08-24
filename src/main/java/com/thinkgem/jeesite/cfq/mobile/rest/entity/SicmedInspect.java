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
 * @version 2016-07-22
 */
public class SicmedInspect extends DataEntity<SicmedInspect> {

    private static final long serialVersionUID = 1L;
    private String inspectCode;    //检验编号
    private String inspectName;        // 检验名称
    /*	private String inspectPriceCode;		// 检验价格表编号
        private String inspectClassCode;		// 检验类别编号(对应类别表)
    */    private String inspectDetail;        // 检验名称详情
    private String inspectNamePY;        //拼音名称

    private SicmedInspectPrice inspectPrice;//无用-丁学志
    private SicmedInspectClass sicmedInspectClass;
    private SicmedInspectPrice sicmedInspectPrice;

    public SicmedInspect() {
        super();
    }

    public SicmedInspect(String id) {
        super(id);
    }

    @Length(min = 0, max = 30, message = "检验名称长度必须介于 0 和 30 之间")
    public String getInspectName() {
        return inspectName;
    }

    public void setInspectName(String inspectName) {
        this.inspectName = inspectName;
    }

/*	@Length(min=0, max=32, message="检验价格表编号长度必须介于 0 和 32 之间")
	public String getInspectPriceCode() {
		return inspectPriceCode;
	}

	public void setInspectPriceCode(String inspectPriceCode) {
		this.inspectPriceCode = inspectPriceCode;
	}
	
	@Length(min=0, max=32, message="检验类别编号(对应类别表)长度必须介于 0 和 32 之间")
	public String getInspectClassCode() {
		return inspectClassCode;
	}

	public void setInspectClassCode(String inspectClassCode) {
		this.inspectClassCode = inspectClassCode;
	}*/

    @Length(min = 0, max = 200, message = "检验名称详情长度必须介于 0 和 200 之间")
    public String getInspectDetail() {
        return inspectDetail;
    }

    public void setInspectDetail(String inspectDetail) {
        this.inspectDetail = inspectDetail;
    }

    @Length(min = 0, max = 80, message = "检验名称长度必须介于 0 和 80 之间")
    public String getInspectNamePY() {
        return inspectNamePY;
    }

    public void setInspectNamePY(String inspectNamePY) {
        this.inspectNamePY = inspectNamePY;
    }

    public SicmedInspectPrice getInspectPrice() {
        return inspectPrice;
    }

    public void setInspectPrice(SicmedInspectPrice inspectPrice) {
        this.inspectPrice = inspectPrice;
    }

    public String getInspectCode() {
        return inspectCode;
    }

    public void setInspectCode(String inspectCode) {
        this.inspectCode = inspectCode;
    }

    public SicmedInspectClass getSicmedInspectClass() {
        return sicmedInspectClass;
    }

    public void setSicmedInspectClass(SicmedInspectClass sicmedInspectClass) {
        this.sicmedInspectClass = sicmedInspectClass;
    }

    public SicmedInspectPrice getSicmedInspectPrice() {
        return sicmedInspectPrice;
    }

    public void setSicmedInspectPrice(SicmedInspectPrice sicmedInspectPrice) {
        this.sicmedInspectPrice = sicmedInspectPrice;
    }

}