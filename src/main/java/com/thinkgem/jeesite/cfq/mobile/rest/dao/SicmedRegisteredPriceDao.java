package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;


import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegisteredPrice;
import org.springframework.stereotype.Repository;

/**
 * 挂号价格DAO接口
 *
 * @author XUE
 * @version 2016-09-06
 */
//@MyBatisDao
@Repository
public interface SicmedRegisteredPriceDao extends CrudDao<SicmedRegisteredPrice> {

    List<SicmedRegisteredPrice> findByVersion(SicmedRegisteredPrice sicmedRegisteredPrice);

}