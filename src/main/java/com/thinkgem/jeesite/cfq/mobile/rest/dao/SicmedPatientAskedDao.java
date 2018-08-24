/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;


import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatientAsked;
import org.springframework.stereotype.Repository;

/**
 * 患者医嘱表DAO接口
 *
 * @author XUE
 * @version 2016-07-12
 */
@Repository
public interface SicmedPatientAskedDao extends CrudDao<SicmedPatientAsked> {
    //添加患者医嘱信息
    public SicmedPatientAsked addPatientAsked(String patientId, String askedCode, String medicalId);

    //通过患者医嘱对象查询患者医嘱集合
    public List<SicmedPatientAsked> findPatientAsked(SicmedPatientAsked sicmedPatientAsked);
}