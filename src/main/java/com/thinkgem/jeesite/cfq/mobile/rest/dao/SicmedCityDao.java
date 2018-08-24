/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.dao;


import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCity;
import org.springframework.stereotype.Repository;

/**
 * 单表生成DAO接口
 *
 * @author Max
 * @version 2016-08-10
 */
@Repository
public interface SicmedCityDao extends CrudDao<SicmedCity> {

    public SicmedCity getById(int id);

}