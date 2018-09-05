package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedDept;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/4 18:56
 * @Todo:
 */

public interface SicmedDeptService  extends BaseService<SicmedDept> {

    @Override
    int insertSelective(SicmedDept sicmedDept);

    @Override
    int insert(SicmedDept entity);

    @Override
    int updateSelective(SicmedDept entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedDept selectById(String id);

    @Override
    SicmedDept selectOneByParams(SicmedDept entity);

    @Override
    List<SicmedDept> findAllList(Query query);

    @Override
    List<SicmedDept> selectALLByParams(SicmedDept sicmedDept, Query query);

    @Override
    Page<SicmedDept> findPage(Page<SicmedDept> page, SicmedDept entity);
}
