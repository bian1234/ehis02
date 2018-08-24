/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.Date;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedBaseCode;

/**
 * 基础编码表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedBaseCodeBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String id;
    private String codeBusiness;        // 业务类型
    private String codeBuns;        // 子业务类型
    private String code;        // 业务编码
    private String codeName;        // 名称
    private String codeExtand;        // 扩展编码
    private Date codeDate;        // 适用日期
    private String codeUse;        // 是否使用

//	private List<SicmedRegistered> registeredList = Lists.newArrayList(); // 挂某个患者类型的号数

    public void setSBC(SicmedBaseCode sicmedBaseCode) {
        if (sicmedBaseCode != null) {
            this.id = sicmedBaseCode.getId();
            this.codeBusiness = sicmedBaseCode.getCodeBusiness();
            this.codeBuns = sicmedBaseCode.getCodeBuns();
            this.code = sicmedBaseCode.getCode();
            this.codeName = sicmedBaseCode.getCodeName();
            this.codeExtand = sicmedBaseCode.getCodeExtand();
            this.codeDate = sicmedBaseCode.getCodeDate();
            this.codeUse = sicmedBaseCode.getCodeUse();

        } else {

            super.setError("1");
            super.setErrorMessage("所查询的数据为空");

        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodeBusiness() {
        return codeBusiness;
    }

    public void setCodeBusiness(String codeBusiness) {
        this.codeBusiness = codeBusiness;
    }

    public String getCodeBuns() {
        return codeBuns;
    }

    public void setCodeBuns(String codeBuns) {
        this.codeBuns = codeBuns;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeExtand() {
        return codeExtand;
    }

    public void setCodeExtand(String codeExtand) {
        this.codeExtand = codeExtand;
    }

    //	@NotNull(message="适用日期不能为空")
    public Date getCodeDate() {
        return codeDate;
    }

    public void setCodeDate(Date codeDate) {
        this.codeDate = codeDate;
    }

    public String getCodeUse() {
        return codeUse;
    }

    public void setCodeUse(String codeUse) {
        this.codeUse = codeUse;
    }

}