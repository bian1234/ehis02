package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedDiseaseDoctor;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 17:13
 * @Todo:  医生常用疾病服务
 */

public interface SicmedDiseaseDoctorService  extends BaseService<SicmedDiseaseDoctor> {

    @Override
    int insertSelective(SicmedDiseaseDoctor sicmedDiseaseDoctor);

    @Override
    int insert(SicmedDiseaseDoctor entity);

    @Override
    int updateSelective(SicmedDiseaseDoctor entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedDiseaseDoctor selectById(String id);

    /**
     *  根据医生id查询
     */

    List<SicmedDiseaseDoctor> selectByDoctorCode(String doctorCode);

    @Override
    SicmedDiseaseDoctor selectOneByParams(SicmedDiseaseDoctor entity);

    @Override
    List<SicmedDiseaseDoctor> findAllList(Query query);

    @Override
    List<SicmedDiseaseDoctor> selectALLByParams(SicmedDiseaseDoctor sicmedDiseaseDoctor, Query query);

    @Override
    Page<SicmedDiseaseDoctor> findPage(Page<SicmedDiseaseDoctor> page, SicmedDiseaseDoctor entity);
}
