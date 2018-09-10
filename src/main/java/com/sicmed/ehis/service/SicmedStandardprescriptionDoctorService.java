package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedStandardprescriptionDoctor;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/10 17:28
 * @Todo:
 */

public interface SicmedStandardprescriptionDoctorService  extends BaseService<SicmedStandardprescriptionDoctor> {

    @Override
    SicmedStandardprescriptionDoctor selectById(String id);

    @Override
    int insertSelective(SicmedStandardprescriptionDoctor sicmedStandardprescriptionDoctor);

    @Override
    int insert(SicmedStandardprescriptionDoctor entity);

    @Override
    int updateSelective(SicmedStandardprescriptionDoctor entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    List<SicmedStandardprescriptionDoctor> selectOneByParams(SicmedStandardprescriptionDoctor entity);

    @Override
    List<SicmedStandardprescriptionDoctor> findAllList(Query query);

    @Override
    List<SicmedStandardprescriptionDoctor> selectALLByParams(SicmedStandardprescriptionDoctor sicmedStandardprescriptionDoctor, Query query);

    List<SicmedStandardprescriptionDoctor>  select(Map map);
    @Override
    Page<SicmedStandardprescriptionDoctor> findPage(Page<SicmedStandardprescriptionDoctor> page, SicmedStandardprescriptionDoctor entity);
}
