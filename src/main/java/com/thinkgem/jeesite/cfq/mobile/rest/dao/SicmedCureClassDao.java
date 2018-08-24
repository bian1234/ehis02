package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCureClass;
import org.springframework.stereotype.Repository;

/**
 * RESTful接口示例DAO接口
 *
 * @author DING
 * @version 2016-07-23
 */
@Repository
public interface SicmedCureClassDao extends CrudDao<SicmedCureClass> {

    List<SicmedCureClass> findByVersion(SicmedCureClass sicmedCureClass);

}