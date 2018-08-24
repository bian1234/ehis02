/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspect;
import org.springframework.stereotype.Repository;

/**
 * RESTful接口示例DAO接口
 *
 * @author DING
 * @version 2016-07-22
 */
@Repository
public interface SicmedInspectDao extends CrudDao<SicmedInspect> {

    public SicmedInspect getInspect(SicmedInspect inspect);

    //	public int update(SicmedInspect inspect);
    public List<SicmedInspect> findAllPriceList(SicmedInspect inspect);

    /**
     * 模糊查询检验项目 接口
     *
     * @param sicmedInspect
     * @return List<SicmedInspect>
     * @author Max
     */
    public List<SicmedInspect> findListLike(SicmedInspect sicmedInspect);

    public List<SicmedInspect> findByVersion(SicmedInspect sicmedInspect);
}