package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedMedicalUse;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/7 10:32
 * @Todo:   药品用法服务
 */

public interface SicmedMedicalUseService extends BaseService<SicmedMedicalUse>{

    @Override
    int insertSelective(SicmedMedicalUse sicmedMedicalUse);

    @Override
    int insert(SicmedMedicalUse entity);

    @Override
    int updateSelective(SicmedMedicalUse entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedMedicalUse selectById(String id);

    @Override
    SicmedMedicalUse selectOneByParams(SicmedMedicalUse entity);

    @Override
    List<SicmedMedicalUse> findAllList(Query query);

    @Override
    List<SicmedMedicalUse> selectALLByParams(SicmedMedicalUse sicmedMedicalUse, Query query);

    @Override
    Page<SicmedMedicalUse> findPage(Page<SicmedMedicalUse> page, SicmedMedicalUse entity);
}
