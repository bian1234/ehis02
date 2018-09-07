package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedDiseaseBranch;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 16:21
 * @Todo: 科室疾病服务
 */

public interface SicmedDiseaseBranchService extends BaseService<SicmedDiseaseBranch> {

    @Override
    int insertSelective(SicmedDiseaseBranch sicmedDiseaseBranch);

    @Override
    int insert(SicmedDiseaseBranch entity);

    @Override
    int updateSelective(SicmedDiseaseBranch entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedDiseaseBranch selectById(String id);

    @Override
    SicmedDiseaseBranch selectOneByParams(SicmedDiseaseBranch entity);

    @Override
    List<SicmedDiseaseBranch> findAllList(Query query);

    @Override
    List<SicmedDiseaseBranch> selectALLByParams(SicmedDiseaseBranch sicmedDiseaseBranch, Query query);


    List<SicmedDiseaseBranch> selectByBranch(Map map);

    @Override
    Page<SicmedDiseaseBranch> findPage(Page<SicmedDiseaseBranch> page, SicmedDiseaseBranch entity);
}
