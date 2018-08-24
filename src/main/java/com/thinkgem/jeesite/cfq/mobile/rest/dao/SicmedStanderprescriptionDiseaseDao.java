package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStanderprescriptionDisease;
import org.springframework.stereotype.Repository;

/**
 * 医生常用疾病表DAO接口
 *
 * @author Max
 * @version 2016-07-18
 */
@Repository
public interface SicmedStanderprescriptionDiseaseDao extends CrudDao<SicmedStanderprescriptionDisease> {

    public List<SicmedStanderprescriptionDisease> findListLike(
            SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease);

    public List<SicmedStanderprescriptionDisease> findByVersion(
            SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease);

}