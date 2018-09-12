package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedPatient;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/11 15:19
 * @Todo:   患者服务
 */

public interface SicmedPatientService extends BaseService<SicmedPatient>{

    @Override
    int insertSelective(SicmedPatient sicmedPatient);

    @Override
    int insert(SicmedPatient entity);

    @Override
    int updateSelective(SicmedPatient entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedPatient selectById(String id);

    @Override
    List<SicmedPatient> selectOneByParams(SicmedPatient entity);

    @Override
    List<SicmedPatient> findAllList(Query query);

    @Override
    List<SicmedPatient> selectALLByParams(SicmedPatient sicmedPatient, Query query);
    @Override
    Page<SicmedPatient> findPage(Page<SicmedPatient> page, SicmedPatient entity);
}
