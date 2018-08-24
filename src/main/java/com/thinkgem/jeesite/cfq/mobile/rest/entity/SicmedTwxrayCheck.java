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
public class SicmedTwxrayCheck extends DataEntity<SicmedTwxrayCheck> {

    private static final long serialVersionUID = 1L;
    private String checkCode;        // 检查编码
    private String checkName;        // 检查名称
    //	private String checkPriceCode;		// 检查价格(对应检查价格表)
//	private String checkClassCode;		// 检查类别(对应放射性大分类表)
    private String checkNamePY;        // 拼音 方便搜索

    private String checkDetail;        //检查详情
    //创建价格对象
    private SicmedCheckPrice sicmedCheckPrice;
    //创建分类对象
    private SicmedTwxrayClass sicmedTwxrayClass;

    public SicmedTwxrayCheck() {
        super();
    }

    public SicmedTwxrayCheck(String id) {
        super(id);
    }

    @Length(min = 0, max = 50, message = "长度必须介于 0 和 50之间")
    public String getCheckDetail() {
        return checkDetail;
    }

    public void setCheckDetail(String checkDetail) {
        this.checkDetail = checkDetail;
    }

    @Length(min = 0, max = 8, message = "检查编码长度必须介于 0 和 8 之间")
    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    @Length(min = 0, max = 40, message = "检查名称长度必须介于 0 和 40 之间")
    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

//	@Length(min=0, max=32, message="检查价格(对应检查价格表)长度必须介于 0 和 32 之间")
//	public String getcheckPriceCode() {
//		return checkPriceCode;
//	}
//
//	public void setcheckPriceCode(String checkPriceCode) {
//		this.checkPriceCode = checkPriceCode;
//	}
//	
//	@Length(min=0, max=32, message="检查类别(对应放射性大分类表)长度必须介于 0 和 32 之间")
//	public String getCheckClassCode() {
//		return checkClassCode;
//	}
//
//	public void setCheckClassCode(String checkClassCode) {
//		this.checkClassCode = checkClassCode;
//	}

    public SicmedCheckPrice getSicmedCheckPrice() {
        return sicmedCheckPrice;
    }

    public void setSicmedCheckPrice(SicmedCheckPrice sicmedCheckPrice) {
        this.sicmedCheckPrice = sicmedCheckPrice;
    }

    public String getCheckNamePY() {
        return checkNamePY;
    }

    public void setCheckNamePY(String checkNamePY) {
        this.checkNamePY = checkNamePY;
    }

    //@Length(min=0, max=30, message="检查名称长度必须介于 0 和 30 之间")
    public SicmedTwxrayClass getSicmedTwxrayClass() {
        return sicmedTwxrayClass;
    }

    public void setSicmedTwxrayClass(SicmedTwxrayClass sicmedTwxrayClass) {
        this.sicmedTwxrayClass = sicmedTwxrayClass;
    }

}