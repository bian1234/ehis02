package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;


import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalClass;
import org.springframework.stereotype.Repository;

/**
 * 药品分类DAO接口
 *
 * @author XUE
 * @version 2016-09-02
 */
@Repository
public interface SicmedMedicalClassDao extends CrudDao<SicmedMedicalClass> {

    List<SicmedMedicalClass> findByVersion(SicmedMedicalClass sicmedMedicalClass);

}