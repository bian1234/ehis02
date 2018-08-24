package com.thinkgem.jeesite.cfq.mobile.rest.setBean;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedBranchBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedBranch;

/**
 * 基础编码表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedBranchSetBean {

    // private List<SicmedRegistered> registeredList = Lists.newArrayList(); //
    // 挂某个患者类型的号数
    public static SicmedBranch setSBB(SicmedBranchBean sicmedBranchBean, SicmedBranch sicmedBranch) {

        if (sicmedBranch == null) {

            sicmedBranch = new SicmedBranch();
        }
        if (sicmedBranchBean.getBranchLocation() != null) {
            sicmedBranch.setBranchLocation(sicmedBranchBean.getBranchLocation());
        }
        if (sicmedBranchBean.getId() != null) {
            sicmedBranch.setId(sicmedBranchBean.getId());
        }
        if (sicmedBranchBean.getBranchCode() != null) {
            sicmedBranch.setBranchCode(sicmedBranchBean.getBranchCode());

        }
        if (sicmedBranchBean.getBranchIpd() != null) {
            sicmedBranch.setBranchIpd(sicmedBranchBean.getBranchIpd());

        }
        if (sicmedBranchBean.getBranchIpd() != null) {
            sicmedBranch.setBranchLocation(sicmedBranchBean.getBranchLocation());

        }
        if (sicmedBranchBean.getBranchName() != null) {
            sicmedBranch.setBranchName(sicmedBranchBean.getBranchName());

        }
        if (sicmedBranchBean.getBranchNameEnglish() != null) {
            sicmedBranch.setBranchNameEnglish(sicmedBranchBean.getBranchNameEnglish());

        }
        if (sicmedBranchBean.getBranchNumber() != null) {
            sicmedBranch.setBranchNumber(sicmedBranchBean.getBranchNumber());

        }
        if (sicmedBranchBean.getBranchRegistered() != null) {
            sicmedBranch.setBranchRegistered(sicmedBranchBean.getBranchRegistered());

        }
        if (sicmedBranchBean.getBranchRegisteredAm() != null) {
            sicmedBranch.setBranchRegisteredAm(sicmedBranchBean.getBranchRegisteredAm());

        }
        if (sicmedBranchBean.getBranchRegisteredPm() != null) {

            sicmedBranch.setBranchRegisteredPm(sicmedBranchBean.getBranchRegisteredPm());
        }
        // sicmedBranch.setCreateBy(sicmedBranchBean.get);
        // sicmedBranch.setCreateDate(createDate);
        // sicmedBranch.setCurrentUser(currentUser);
        // sicmedBranch.setDelFlag(delFlag);
        // sicmedBranch.setId(id);
        // sicmedBranch.setIsNewRecord(isNewRecord);
        // sicmedBranch.setPage(page)
        // sicmedBranch.setPatientList(patientList);
        // sicmedBranch.setRemarks(remarks);
        // sicmedBranch.setSqlMap(sqlMap);
        // sicmedBranch.setUpdateBy(updateBy);
        // sicmedBranch.setUpdateDate(updateDate);
        // sicmedBranch.setUserList(userList);

        return sicmedBranch;

    }

}