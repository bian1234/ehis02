package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedDoctorAsked;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/7 9:17
 * @Todo:  医生常用医嘱服务
 */

public interface SicmedDoctorAskedService  extends BaseService<SicmedDoctorAsked> {

    @Override
    int insertSelective(SicmedDoctorAsked sicmedDoctorAsked);

    @Override
    int insert(SicmedDoctorAsked entity);

    @Override
    int updateSelective(SicmedDoctorAsked entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedDoctorAsked selectById(String id);

    @Override
    SicmedDoctorAsked selectOneByParams(SicmedDoctorAsked entity);

    @Override
    List<SicmedDoctorAsked> findAllList(Query query);

    @Override
    List<SicmedDoctorAsked> selectALLByParams(SicmedDoctorAsked sicmedDoctorAsked, Query query);

    @Override
    Page<SicmedDoctorAsked> findPage(Page<SicmedDoctorAsked> page, SicmedDoctorAsked entity);
}
