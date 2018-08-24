package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;


import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import org.springframework.stereotype.Repository;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegisteredType;

/**
 * 挂号类别DAO接口
 *
 * @author XUE
 * @version 2016-09-06
 */
@Repository
public interface SicmedRegisteredTypeDao extends CrudDao<SicmedRegisteredType> {

    public List<SicmedRegisteredType> findList1(SicmedRegisteredType sicmedRegisteredType);

    public List<SicmedRegisteredType> findList2(SicmedRegisteredType sicmedRegisteredType);

    public List<SicmedRegisteredType> findByVersion(SicmedRegisteredType sicmedRegisteredType);
}