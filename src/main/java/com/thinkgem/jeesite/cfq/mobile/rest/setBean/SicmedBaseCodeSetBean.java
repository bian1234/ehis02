/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.setBean;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedBaseCodeBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedBaseCode;

/**
 * 基础编码表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedBaseCodeSetBean {

    // private List<SicmedRegistered> registeredList = Lists.newArrayList(); //
    // 挂某个患者类型的号数
    public static SicmedBaseCode setSBCB(SicmedBaseCodeBean sicmedBaseCodeBean, SicmedBaseCode sicmedBaseCode) {

        if (sicmedBaseCode != null) {
            sicmedBaseCode = new SicmedBaseCode();

        }
        if (sicmedBaseCodeBean.getId() != null) {

            sicmedBaseCode.setId(sicmedBaseCodeBean.getId());
        }
        if (sicmedBaseCodeBean.getCodeBusiness() != null) {
            sicmedBaseCode.setCodeBusiness(sicmedBaseCodeBean.getCodeBusiness());

        }
        if (sicmedBaseCodeBean.getCodeBuns() != null) {
            sicmedBaseCode.setCodeBuns(sicmedBaseCodeBean.getCodeBuns());

        }
        if (sicmedBaseCodeBean.getCode() != null) {
            sicmedBaseCode.setCode(sicmedBaseCodeBean.getCode());

        }
        if (sicmedBaseCodeBean.getCodeName() != null) {
            sicmedBaseCode.setCodeName(sicmedBaseCodeBean.getCodeName());

        }
        if (sicmedBaseCodeBean.getCodeExtand() != null) {

            sicmedBaseCode.setCodeExtand(sicmedBaseCodeBean.getCodeExtand());
        }
        if (sicmedBaseCodeBean.getCodeDate() != null) {

            sicmedBaseCode.setCodeDate(sicmedBaseCodeBean.getCodeDate());
        }
        if (sicmedBaseCodeBean.getCodeUse() != null) {
            sicmedBaseCode.setCodeUse(sicmedBaseCodeBean.getCodeUse());

        }

        // sicmedBaseCode.setCreateBy(createBy);
        // sicmedBaseCode.setCreateDate(createDate);
        // sicmedBaseCode.setCurrentUser(currentUser);
        // sicmedBaseCode.setDelFlag(delFlag);
        // sicmedBaseCode.setIsNewRecord(isNewRecord);
        // sicmedBaseCode.setPage(page)
        // sicmedBaseCode.setRegisteredList(registeredList);
        // sicmedBaseCode.setRemarks(remarks);
        // sicmedBaseCode.setSqlMap(sqlMap);
        // sicmedBaseCode.setUpdateBy(updateBy);
        // sicmedBaseCode.setUpdateDate(updateDate);

        return sicmedBaseCode;

    }

}