package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;


import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDisease;
import org.springframework.stereotype.Repository;

/**
 * 疾病表DAO接口
 *
 * @author Max
 * @version 2016-07-18
 */
@Repository
public interface SicmedDiseaseDao extends CrudDao<SicmedDisease> {

    /**
     * 模糊查询疾病 Dao接口
     *
     * @param sicmedDisease
     * @return List<SicmedDisease>
     * @author Max
     */
    public List<SicmedDisease> findListLike(SicmedDisease sicmedDisease);

    public List<SicmedDisease> findByVersion(SicmedDisease sicmedDisease);


}