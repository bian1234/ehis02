/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import java.util.Date;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 单表生成Entity
 *
 * @author Max
 * @version 2016-08-12
 */
public class Sno extends DataEntity<Sno> {

    private static final long serialVersionUID = 1L;
    private String number;        // number
    private Date updateDate;


    public Sno() {
        super();
    }

    public Sno(String id) {
        super(id);
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Length(min = 1, max = 10, message = "number长度必须介于 1 和 10 之间")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}