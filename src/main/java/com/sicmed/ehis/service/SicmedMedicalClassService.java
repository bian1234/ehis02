package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedMedicalClass;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/10 18:54
 * @Todo:   药片分类服务
 */

public interface SicmedMedicalClassService  extends BaseService<SicmedMedicalClass> {



    @Override
    List<SicmedMedicalClass> findAllList(Query query);

    /**
     *   查找一级分类
     */
    List<SicmedMedicalClass> firstClassification(SicmedMedicalClass sicmedMedicalClass);

    /**
     *  根据父id查询
     */
    List<SicmedMedicalClass> findChild(Map map);

    SicmedMedicalClass selectById(String id);
}
