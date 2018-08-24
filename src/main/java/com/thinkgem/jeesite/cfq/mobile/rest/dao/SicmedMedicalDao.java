/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;


import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedical;
import org.springframework.stereotype.Repository;

/**
 * 药品详细信息DAO接口
 *
 * @author 丁学志
 * @version 2016-07-12
 */
@Repository
public interface SicmedMedicalDao extends CrudDao<SicmedMedical> {

    //通过medical 在数据库中查到对应的对象
    public SicmedMedical getMedicalWithMedical(SicmedMedical medical);

    //通过medical 在数据库中查到对应的对象
//	public List<SicmedMedicalPrice> getMeicalDetailWithMedical(SicmedMedical medical);

    //通过medical 在数据库中查到对应的对象
    public List<SicmedMedical> getMeicalListWithMedical(SicmedMedical medical);

    /**
     * 模糊查询药品 接口
     *
     * @param sicmedMedical
     * @return List<SicmedMedical>
     * @author Max
     */
    public List<SicmedMedical> findListLike(SicmedMedical sicmedMedical);

    public List<SicmedMedical> getAll();

    public List<SicmedMedical> findByVersion(SicmedMedical sicmedMedical);

}