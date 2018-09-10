package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedPatientDisease;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/10 15:02
 * @Todo:
 */

public interface SicmedPatientDiseaseService  extends BaseService<SicmedPatientDisease> {


    @Override
    int insertSelective(SicmedPatientDisease sicmedPatientDisease);

    @Override
    int insert(SicmedPatientDisease entity);

    @Override
    int updateSelective(SicmedPatientDisease entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedPatientDisease selectById(String id);


    @Override
    List<SicmedPatientDisease> selectOneByParams(SicmedPatientDisease entity);

    @Override
    List<SicmedPatientDisease> findAllList(Query query);

    @Override
    List<SicmedPatientDisease> selectALLByParams(SicmedPatientDisease sicmedPatientDisease, Query query);

    @Override
    Page<SicmedPatientDisease> findPage(Page<SicmedPatientDisease> page, SicmedPatientDisease entity);

    /**
     *  根据病历id查询数据
     */

    List<SicmedPatientDisease>  getByCase(String caseCode);
}
