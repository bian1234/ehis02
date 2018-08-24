/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDept;

/**
 * 部门信息表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedDeptBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String id;
    private String deptNumber; // 部门编号
    private String deptName; // 部门名称
    private String deptPmpa; // 部门拼音简写
    private String deptCode; // 部门编码

    // private List<SicmedUser> userList = Lists.newArrayList(); // 拥有人员

    public void setSD(SicmedDept sicmedDept) {

        if (sicmedDept != null) {
            this.id = sicmedDept.getId();
            this.deptNumber = sicmedDept.getDeptNumber();
            this.deptName = sicmedDept.getDeptName();
            this.deptPmpa = sicmedDept.getDeptPmpa();
            this.deptCode = sicmedDept.getDeptCode();

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

    public String getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(String deptNumber) {
        this.deptNumber = deptNumber;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptPmpa() {
        return deptPmpa;
    }

    public void setDeptPmpa(String deptPmpa) {
        this.deptPmpa = deptPmpa;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

}