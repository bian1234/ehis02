/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;

import javax.validation.constraints.NotNull;


/**
 * 基础编码表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedBaseCode extends DataEntity<SicmedBaseCode> {

    private static final long serialVersionUID = 1L;
    private String codeBusiness;        // 业务类型
    private String codeBuns;        // 子业务类型
    private String code;        // 业务编码
    private String codeName;        // 名称
    private String codeExtand;        // 扩展编码
    private Date codeDate;        // 适用日期
    private String codeUse;        // 是否使用

    private List<SicmedRegistered> registeredList = Lists.newArrayList(); // 挂某个患者类型的号数

    public SicmedBaseCode() {
        super();
    }

    public SicmedBaseCode(String id) {
        super(id);
    }

    @Length(min = 1, max = 20, message = "业务类型长度必须介于 1 和 20 之间")
    public String getCodeBusiness() {
        return codeBusiness;
    }

    public void setCodeBusiness(String codeBusiness) {
        this.codeBusiness = codeBusiness;
    }

    @Length(min = 1, max = 20, message = "子业务类型长度必须介于 1 和 20 之间")
    public String getCodeBuns() {
        return codeBuns;
    }

    public void setCodeBuns(String codeBuns) {
        this.codeBuns = codeBuns;
    }

    @Length(min = 1, max = 10, message = "业务编码长度必须介于 1 和 10 之间")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Length(min = 0, max = 60, message = "名称长度必须介于 0 和 60 之间")
    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    @Length(min = 0, max = 80, message = "扩展编码长度必须介于 0 和 80 之间")
    public String getCodeExtand() {
        return codeExtand;
    }

    public void setCodeExtand(String codeExtand) {
        this.codeExtand = codeExtand;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "适用日期不能为空")
    public Date getCodeDate() {
        return codeDate;
    }

    public void setCodeDate(Date codeDate) {
        this.codeDate = codeDate;
    }

    @Length(min = 0, max = 1, message = "是否使用长度必须介于 0 和 1 之间")
    public String getCodeUse() {
        return codeUse;
    }

    public void setCodeUse(String codeUse) {
        this.codeUse = codeUse;
    }

    public List<SicmedRegistered> getRegisteredList() {
        return registeredList;
    }

    public void setRegisteredList(List<SicmedRegistered> registeredList) {
        this.registeredList = registeredList;
    }

}