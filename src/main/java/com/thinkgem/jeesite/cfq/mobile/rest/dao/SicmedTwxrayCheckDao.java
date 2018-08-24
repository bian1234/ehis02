package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedTwxrayCheck;
import org.springframework.stereotype.Repository;

/**
 * RESTful接口示例DAO接口
 *
 * @author DING
 * @version 2016-07-22
 */
@Repository
public interface SicmedTwxrayCheckDao extends CrudDao<SicmedTwxrayCheck> {

    public SicmedTwxrayCheck getTwxrayCheck(SicmedTwxrayCheck sicmedTwxrayCheck);

    /**
     * 模糊查询检查项目接口
     *
     * @param sicmedTwxrayCheck
     * @return List<SicmedTwxrayCheck>
     */
    public List<SicmedTwxrayCheck> findListLike(SicmedTwxrayCheck sicmedTwxrayCheck);

    public List<SicmedTwxrayCheck> findByVersion(SicmedTwxrayCheck sicmedTwxrayCheck);

}