package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;


import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDiseaseClass;
import org.springframework.stereotype.Repository;

/**
 * 疾病类别表DAO接口
 *
 * @author Max
 * @version 2016-07-18
 */
@Repository
public interface SicmedDiseaseClassDao extends CrudDao<SicmedDiseaseClass> {

    List<SicmedDiseaseClass> findByVersion(SicmedDiseaseClass sicmedDiseaseClass);

}