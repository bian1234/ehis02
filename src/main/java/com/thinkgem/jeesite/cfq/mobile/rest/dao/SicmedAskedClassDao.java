/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAskedClass;
import org.springframework.stereotype.Repository;

/**
 * 医嘱分类编码DAO接口
 *
 * @author XUE
 * @version 2016-07-12
 */
@Repository
public interface SicmedAskedClassDao extends CrudDao<SicmedAskedClass> {

    public SicmedAskedClass getAskedByAskedClass(String askedClass);

    public int update(SicmedAskedClass sicmedAskedClass);

}