package com.thinkgem.jeesite.cfq.mobile.rest.setBean;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedDeptBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDept;

/**
 * 基础编码表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedDeptSetBean {

    // private List<SicmedRegistered> registeredList = Lists.newArrayList(); //
    // 挂某个患者类型的号数
    public static SicmedDept setSDB(SicmedDeptBean sicmedDeptBean, SicmedDept sicmedDept) {

        if (sicmedDept == null) {
            sicmedDept = new SicmedDept();
        }
        if (sicmedDeptBean.getId() != null) {
            sicmedDept.setId(sicmedDeptBean.getId());
        }
        if (sicmedDeptBean.getDeptCode() != null) {
            sicmedDept.setDeptCode(sicmedDeptBean.getDeptCode());
        }
        if (sicmedDeptBean.getDeptName() != null) {
            sicmedDept.setDeptName(sicmedDeptBean.getDeptName());
        }
        if (sicmedDeptBean.getDeptNumber() != null) {
            sicmedDept.setDeptNumber(sicmedDeptBean.getDeptNumber());
        }
        if (sicmedDeptBean.getDeptPmpa() != null) {
            sicmedDept.setDeptPmpa(sicmedDeptBean.getDeptPmpa());
        }

        // sicmedDept.setCreateBy(sicmedDeptBean.get);
        // sicmedDept.setCreateDate(sicmedDeptBean.get);
        // sicmedDept.setCurrentUser(sicmedDeptBean.get);
        // sicmedDept.setDelFlag(sicmedDeptBean.get);
        // sicmedDept.setId(sicmedDeptBean.get);
        // sicmedDept.setIsNewRecord(sicmedDeptBean.get);
        // sicmedDept.setPage(page);
        // sicmedDept.setRemarks(remarks);
        // sicmedDept.setSqlMap(sqlMap);
        // sicmedDept.setUpdateBy(updateBy);
        // sicmedDept.setUpdateDate(updateDate);
        // sicmedDept.setUserList(userList)

        return sicmedDept;

    }

}