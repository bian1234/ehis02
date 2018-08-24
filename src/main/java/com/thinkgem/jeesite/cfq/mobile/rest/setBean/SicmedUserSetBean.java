package com.thinkgem.jeesite.cfq.mobile.rest.setBean;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedUserBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedUser;

/**
 * 基础编码表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedUserSetBean {

    // private List<SicmedRegistered> registeredList = Lists.newArrayList(); //
    // 挂某个患者类型的号数
    public static SicmedUser setSUB(SicmedUserBean sicmedUserBean) {
        SicmedUser sicmedUser = new SicmedUser();

        sicmedUser.setId(sicmedUserBean.getId());
        sicmedUser.setUserNumber(sicmedUserBean.getUserNumber());
        sicmedUser.setDoctorGrade(sicmedUserBean.getDoctorGrade());
        sicmedUser.setDoctorRegistered(sicmedUserBean.getDoctorRegistered());
        sicmedUser.setUserJobGrade(sicmedUserBean.getUserJobGrade());
        sicmedUser.setUserJobGroup(sicmedUserBean.getUserJobGroup());
        sicmedUser.setUserTel(sicmedUserBean.getUserTel());

        // sicmedUser.setCurrentUser(sicmedUserBean.getc);
        // sicmedUser.setCreateBy(sicmedUserBean);
        // sicmedUser.setCreateDate(createDate);
        // sicmedUser.setDelFlag(sicmedUserBean.get);
        // sicmedUser.setIsNewRecord(sicmedUserBean.get);
        // sicmedUser.setPage(page)
        // sicmedUser.setPatientList(sicmedUserBean.getp);
        // sicmedUser.setRemarks(sicmedUserBean.get);
        // sicmedUser.setRegisteredList(sicmedUserBean.getr);
        // sicmedUser.setSicmedBranch(sicmedUserBean.get);
        // sicmedUser.setSicmedDept(sicmedUserBean.gets);
        // sicmedUser.setSqlMap(sicmedUserBean.gets);
        // sicmedUser.setUpdateBy(updateBy);
        // sicmedUser.setUpdateDate(updateDate);

        return sicmedUser;

    }

}