package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedAskedBranch;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 14:44
 * @Todo:  医嘱传送服务
 */

public interface SicmedAskedBranchService extends BaseService<SicmedAskedBranch> {

    @Override
    int insertSelective(SicmedAskedBranch sicmedAskedBranch);

    @Override
    int insert(SicmedAskedBranch entity);

    @Override
    int updateSelective(SicmedAskedBranch entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedAskedBranch selectById(String id);

    @Override
    SicmedAskedBranch selectOneByParams(SicmedAskedBranch entity);

    @Override
    List<SicmedAskedBranch> findAllList(Query query);

    @Override
    List<SicmedAskedBranch> selectALLByParams(SicmedAskedBranch sicmedAskedBranch, Query query);

    @Override
    Page<SicmedAskedBranch> findPage(Page<SicmedAskedBranch> page, SicmedAskedBranch entity);
}
