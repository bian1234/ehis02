package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedDiseaseClass;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 9:00
 * @Todo:   疾病类别服务
 */

public interface SicmedDiseaseClassService  extends BaseService<SicmedDiseaseClass> {

    @Override
    int insertSelective(SicmedDiseaseClass sicmedDiseaseClass);

    @Override
    int insert(SicmedDiseaseClass entity);

    @Override
    int updateSelective(SicmedDiseaseClass entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedDiseaseClass selectById(String id);

    @Override
    SicmedDiseaseClass selectOneByParams(SicmedDiseaseClass entity);

    @Override
    List<SicmedDiseaseClass> findAllList(Query query);

    @Override
    List<SicmedDiseaseClass> selectALLByParams(SicmedDiseaseClass sicmedDiseaseClass, Query query);

    @Override
    Page<SicmedDiseaseClass> findPage(Page<SicmedDiseaseClass> page, SicmedDiseaseClass entity);
}
