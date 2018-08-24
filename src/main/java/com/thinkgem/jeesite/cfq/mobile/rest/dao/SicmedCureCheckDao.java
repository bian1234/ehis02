/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCureCheck;
import org.springframework.stereotype.Repository;

/**
 * RESTful接口示例DAO接口
 *
 * @author DING
 * @version 2016-07-23
 */
@Repository
public interface SicmedCureCheckDao extends CrudDao<SicmedCureCheck> {

    public SicmedCureCheck getCureCheck(SicmedCureCheck sicmedCureCheck);

    /**
     * 模糊查询检验项目 接口
     *
     * @param sicmedCureCheck
     * @return List<SicmedCureCheck>
     * @author Max
     */
    public List<SicmedCureCheck> findListLike(SicmedCureCheck sicmedCureCheck);

    public List<SicmedCureCheck> findByVersion(SicmedCureCheck sicmedCureCheck);

}