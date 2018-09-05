package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedBranchAsked;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 15:29
 * @Todo:   科室常用的医嘱服务
 */

public interface SicmedBranchAskedService extends BaseService<SicmedBranchAsked>{

    @Override
    int insertSelective(SicmedBranchAsked sicmedBranchAsked);

    @Override
    int insert(SicmedBranchAsked entity);

    @Override
    int updateSelective(SicmedBranchAsked entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedBranchAsked selectById(String id);

    @Override
    SicmedBranchAsked selectOneByParams(SicmedBranchAsked entity);

    @Override
    List<SicmedBranchAsked> findAllList(Query query);

    @Override
    List<SicmedBranchAsked> selectALLByParams(SicmedBranchAsked sicmedBranchAsked, Query query);

    @Override
    Page<SicmedBranchAsked> findPage(Page<SicmedBranchAsked> page, SicmedBranchAsked entity);
}
