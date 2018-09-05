package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedHospital;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 10:37
 * @Todo:   医院服务
 */

public interface SicmedHospitalService extends BaseService<SicmedHospital>{

    @Override
    int insertSelective(SicmedHospital sicmedHospital);

    @Override
    int insert(SicmedHospital entity);

    @Override
    int updateSelective(SicmedHospital entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedHospital selectById(String id);

    @Override
    SicmedHospital selectOneByParams(SicmedHospital entity);

    @Override
    List<SicmedHospital> findAllList(Query query);

    @Override
    List<SicmedHospital> selectALLByParams(SicmedHospital sicmedHospital, Query query);

    @Override
    Page<SicmedHospital> findPage(Page<SicmedHospital> page, SicmedHospital entity);

    List<SicmedHospital> selectALLByCityId(String CityId);
}
