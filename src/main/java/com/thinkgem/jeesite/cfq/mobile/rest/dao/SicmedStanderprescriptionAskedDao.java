package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;


import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStanderprescriptionAsked;
import org.springframework.stereotype.Repository;

/**
 * 标准处方中的医嘱DAO接口
 *
 * @author Max
 * @version 2016-07-20
 */
@Repository
public interface SicmedStanderprescriptionAskedDao extends CrudDao<SicmedStanderprescriptionAsked> {

    List<SicmedStanderprescriptionAsked> findList1(SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked);

    List<SicmedStanderprescriptionAsked> findByVersion(SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked);

}