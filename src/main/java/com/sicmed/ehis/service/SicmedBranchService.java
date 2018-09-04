package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedBranch;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/4 14:51
 * @Todo:
 */

public interface SicmedBranchService  extends BaseService<SicmedBranch> {


    @Override
    int insertSelective(SicmedBranch sicmedBranch);

    @Override
    SicmedBranch selectById(String id);

    @Override
    List<SicmedBranch> findAllList(Query query);

    @Override
    List<SicmedBranch> selectALLByParams(SicmedBranch sicmedBranch,Query query);

    List<SicmedBranch> selectRegistered(Query query);
}
