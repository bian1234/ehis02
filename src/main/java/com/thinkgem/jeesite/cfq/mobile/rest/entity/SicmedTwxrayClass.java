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
public class SicmedTwxrayClass extends DataEntity<SicmedTwxrayClass> {

    private static final long serialVersionUID = 1L;
    private String classCode;        // 类别编号
    private String className;        // 类别名称
    private String pacsClass;        // 学名
    private String sort;        // 缩写

    public SicmedTwxrayClass() {
        super();
    }

    public SicmedTwxrayClass(String id) {
        super(id);
    }

    @Length(min = 1, max = 2, message = "类别编号长度必须介于 1 和 2 之间")
    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    @Length(min = 0, max = 30, message = "类别名称长度必须介于 0 和 30 之间")
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Length(min = 0, max = 3, message = "学名长度必须介于 0 和 3 之间")
    public String getPacsClass() {
        return pacsClass;
    }

    public void setPacsClass(String pacsClass) {
        this.pacsClass = pacsClass;
    }

    @Length(min = 0, max = 2, message = "缩写长度必须介于 0 和 2 之间")
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

}