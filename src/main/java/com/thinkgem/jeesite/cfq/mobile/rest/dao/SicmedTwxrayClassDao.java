package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;


import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedTwxrayClass;
import org.springframework.stereotype.Repository;

/**
 * RESTful接口示例DAO接口
 *
 * @author DING
 * @version 2016-07-22
 */
@Repository
public interface SicmedTwxrayClassDao extends CrudDao<SicmedTwxrayClass> {

    List<SicmedTwxrayClass> findByVersion(SicmedTwxrayClass sicmedTwxrayClass);


}