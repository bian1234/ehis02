/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspectPrice;
import org.springframework.stereotype.Repository;

/**
 * RESTful接口示例DAO接口
 *
 * @author DING
 * @version 2016-07-22
 */
@Repository
public interface SicmedInspectPriceDao extends CrudDao<SicmedInspectPrice> {

    public List<SicmedInspectPrice> fingInspectPrice(SicmedInspectPrice inspectPrice);

    public SicmedInspectPrice getByEntity(SicmedInspectPrice sicmedInspectPrice);

    /**
     * 更新数据
     *
     * @param entity
     * @return
     */
    public int update(SicmedInspectPrice inspectPrice);

    public List<SicmedInspectPrice> findAllPricePage(SicmedInspectPrice inspectPrice);

    public List<SicmedInspectPrice> findByVersion(SicmedInspectPrice sicmedInspectPrice);
}