/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCurePrice;
import org.springframework.stereotype.Repository;

/**
 * RESTful接口示例DAO接口
 *
 * @author DING
 * @version 2016-07-22
 */
@Repository
public interface SicmedCurePriceDao extends CrudDao<SicmedCurePrice> {

    public List<SicmedCurePrice> fingCurePrice(SicmedCurePrice curePrice);

    public SicmedCurePrice getByEntity(SicmedCurePrice sicmedCurePrice);

    public List<SicmedCurePrice> findAllPriceList(SicmedCurePrice curePrice);

    public List<SicmedCurePrice> findByVersion(SicmedCurePrice sicmedCurePrice);
}