/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;


import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatientDisease;
import org.springframework.stereotype.Repository;

/**
 * 患者疾病表DAO接口
 *
 * @author XUE
 * @version 2016-07-20
 */
@Repository
public interface SicmedPatientDiseaseDao extends CrudDao<SicmedPatientDisease> {
    public List<SicmedPatientDisease> getDoctorId(String id);

    public SicmedPatientDisease getOnly(SicmedPatientDisease sicmedPatientDisease);
}