/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import java.util.List;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;

import com.google.common.collect.Lists;

/**
 * 部门信息表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedDept extends DataEntity<SicmedDept> {

    private static final long serialVersionUID = 1L;
    private String deptNumber;        // 部门编号
    private String deptName;        // 部门名称
    private String deptPmpa;        // 部门拼音简写
    private String deptCode;        // 部门编码
    private List<SicmedUser> userList = Lists.newArrayList(); // 拥有人员

    public SicmedDept() {
        super();
    }

    public SicmedDept(String id) {
        super(id);
    }

    @Length(min = 1, max = 10, message = "部门编号长度必须介于 1 和 10 之间")
    public String getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(String deptNumber) {
        this.deptNumber = deptNumber;
    }

    @Length(min = 1, max = 30, message = "部门名称长度必须介于 1 和 30 之间")
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Length(min = 0, max = 4, message = "部门拼音简写长度必须介于 0 和 4 之间")
    public String getDeptPmpa() {
        return deptPmpa;
    }

    public void setDeptPmpa(String deptPmpa) {
        this.deptPmpa = deptPmpa;
    }

    @Length(min = 0, max = 30, message = "部门编码长度必须介于 0 和 30 之间")
    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public List<SicmedUser> getUserList() {
        return userList;
    }

    public void setUserList(List<SicmedUser> userList) {
        this.userList = userList;
    }

}