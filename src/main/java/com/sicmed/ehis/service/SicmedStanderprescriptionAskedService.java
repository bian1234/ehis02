package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedStanderprescriptionAsked;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/7 17:59
 * @Todo:   标准处方中的医嘱
 */

public interface SicmedStanderprescriptionAskedService extends BaseService<SicmedStanderprescriptionAsked>{

    @Override
    int insertSelective(SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked);

    @Override
    int insert(SicmedStanderprescriptionAsked entity);

    @Override
    int updateSelective(SicmedStanderprescriptionAsked entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedStanderprescriptionAsked selectById(String id);

    @Override
    SicmedStanderprescriptionAsked selectOneByParams(SicmedStanderprescriptionAsked entity);

    @Override
    List<SicmedStanderprescriptionAsked> findAllList(Query query);

    @Override
    List<SicmedStanderprescriptionAsked> selectALLByParams(SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked, Query query);

    @Override
    Page<SicmedStanderprescriptionAsked> findPage(Page<SicmedStanderprescriptionAsked> page, SicmedStanderprescriptionAsked entity);
}
