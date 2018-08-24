package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.List;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedTwxrayClass;

public class SicmedTwxrayClassBean extends BaseBean {

    private static final long serialVersionUID = 1L;
    private String id;
    private String classCode; // 类别编号
    private String className; // 类别名称
    private String pacsClass; // 学名
    private String sort; // 缩写

    // 存放checkBean的列表
    private List<SicmedTwxrayCheckBean> checkBeanList = Lists.newArrayList();

    public void setSicmedTwxrayClass(SicmedTwxrayClass sicmedTwxrayClass) {

        if (sicmedTwxrayClass != null) {
            this.id = sicmedTwxrayClass.getId();
            this.pacsClass = sicmedTwxrayClass.getPacsClass();
            this.classCode = sicmedTwxrayClass.getClassCode();
            this.className = sicmedTwxrayClass.getClassName();
            this.sort = sicmedTwxrayClass.getSort();

        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPacsClass() {
        return pacsClass;
    }

    public void setPacsClass(String pacsClass) {
        this.pacsClass = pacsClass;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public List<SicmedTwxrayCheckBean> getCheckBeanList() {
        return checkBeanList;
    }

    public void setCheckBeanList(List<SicmedTwxrayCheckBean> checkBeanList) {
        this.checkBeanList = checkBeanList;
    }

}
