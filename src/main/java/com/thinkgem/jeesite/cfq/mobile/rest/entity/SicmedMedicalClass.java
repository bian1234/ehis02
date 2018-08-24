/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * 药品分类Entity
 *
 * @author XUE
 * @version 2016-09-02
 */
public class SicmedMedicalClass extends DataEntity<SicmedMedicalClass> {

    private static final long serialVersionUID = 1L;
    private String code;        // 类别编号
    private String name;        // 药品类名
    private String sort;        // 缩写
    private String pace;        // 学名
    private SicmedMedicalClass parent;        // 父级编号
    private String parentIds;        // 所有父级编号

    public SicmedMedicalClass() {
        super();
    }

    public SicmedMedicalClass(String id) {
        super(id);
    }

    @Length(min = 1, max = 20, message = "类别编号长度必须介于 1 和 8 之间")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Length(min = 0, max = 200, message = "药品类名长度必须介于 0 和 200 之间")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min = 0, max = 2, message = "缩写长度必须介于 0 和 2 之间")
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Length(min = 0, max = 3, message = "学名长度必须介于 0 和 3 之间")
    public String getPace() {
        return pace;
    }

    public void setPace(String pace) {
        this.pace = pace;
    }

    @JsonBackReference
    public SicmedMedicalClass getParent() {
        return parent;
    }

    public void setParent(SicmedMedicalClass parent) {
        this.parent = parent;
    }

    @Length(min = 0, max = 2000, message = "所有父级编号长度必须介于 0 和 2000 之间")
    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

}