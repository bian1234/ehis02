/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.dao;


import java.util.List;

import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalPrice;
import org.springframework.stereotype.Repository;

/**
 * 药品价格信息DAO接口
 *
 * @author 丁学志
 * @version 2016-07-12
 */
@Repository
public interface SicmedMedicalPriceDao extends CrudDao<SicmedMedicalPrice> {

    public SicmedMedicalPrice getMedicalPrice(SicmedMedicalPrice medicalPrice);

    public List<SicmedMedicalPrice> fingMedicalPrice(SicmedMedicalPrice medicalPrice);

    public List<SicmedMedicalPrice> findAllPriceList(SicmedMedicalPrice medicalPrice);

    public List<SicmedMedicalPrice> findByVersion(SicmedMedicalPrice sicmedMedicalPrice);
}