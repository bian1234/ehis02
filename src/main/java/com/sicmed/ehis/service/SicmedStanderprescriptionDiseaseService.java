package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedStanderprescriptionDisease;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/7 18:02
 * @Todo:   标准处方中的疾病
 */

public interface SicmedStanderprescriptionDiseaseService  extends BaseService<SicmedStanderprescriptionDisease> {

   /**
    * 根据名字查找
    */

    List<SicmedStanderprescriptionDisease> selectByName(String prescriptionName);


    @Override
    int insertSelective(SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease);

    @Override
    int insert(SicmedStanderprescriptionDisease entity);

    @Override
    int updateSelective(SicmedStanderprescriptionDisease entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedStanderprescriptionDisease selectById(String id);

    List<SicmedStanderprescriptionDisease> selectByCreate(String createUser);

    @Override
    List<SicmedStanderprescriptionDisease> findAllList(Query query);

    @Override
    List<SicmedStanderprescriptionDisease> selectALLByParams(SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease, Query query);

    @Override
    Page<SicmedStanderprescriptionDisease> findPage(Page<SicmedStanderprescriptionDisease> page, SicmedStanderprescriptionDisease entity);
}
