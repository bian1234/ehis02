/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;


/**
 * 挂号类别Entity
 *
 * @author XUE
 * @version 2016-09-06
 */
public class SicmedRegisteredType extends DataEntity<SicmedRegisteredType> {

    private static final long serialVersionUID = 1L;
    private String nameChina;        // 挂号类型
    private String nameEnglish;        // 挂号类型拼音
    private String codeGrades;        // 挂号等级

    private SicmedRegisteredPrice sicmedRegisteredPrice; //挂号价格对象

    public SicmedRegisteredType() {
        super();
    }

    public SicmedRegisteredType(String id) {
        super(id);
    }

    public SicmedRegisteredPrice getSicmedRegisteredPrice() {
        return sicmedRegisteredPrice;
    }

    public void setSicmedRegisteredPrice(SicmedRegisteredPrice sicmedRegisteredPrice) {
        this.sicmedRegisteredPrice = sicmedRegisteredPrice;
    }

    @Length(min = 1, max = 20, message = "挂号类型长度必须介于 1 和 20 之间")
    public String getNameChina() {
        return nameChina;
    }

    public void setNameChina(String nameChina) {
        this.nameChina = nameChina;
    }

    @Length(min = 0, max = 50, message = "挂号类型拼音长度必须介于 0 和 50 之间")
    public String getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    @Length(min = 0, max = 3, message = "挂号等级长度必须介于 0 和 3 之间")
    public String getCodeGrades() {
        return codeGrades;
    }

    public void setCodeGrades(String codeGrades) {
        this.codeGrades = codeGrades;
    }

}