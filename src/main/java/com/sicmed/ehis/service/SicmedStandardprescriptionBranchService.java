package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedStandardprescriptionBranch;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/7 16:20
 * @Todo:  科室标准处方服务
 */

public interface SicmedStandardprescriptionBranchService extends BaseService<SicmedStandardprescriptionBranch>{

    @Override
    int insertSelective(SicmedStandardprescriptionBranch sicmedStandardprescriptionBranch);

    @Override
    int insert(SicmedStandardprescriptionBranch entity);

    @Override
    int updateSelective(SicmedStandardprescriptionBranch entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedStandardprescriptionBranch selectById(String id);

    @Override
    SicmedStandardprescriptionBranch selectOneByParams(SicmedStandardprescriptionBranch entity);

    @Override
    List<SicmedStandardprescriptionBranch> findAllList(Query query);

    @Override
    List<SicmedStandardprescriptionBranch> selectALLByParams(SicmedStandardprescriptionBranch sicmedStandardprescriptionBranch, Query query);

    List<SicmedStandardprescriptionBranch> findStandardPrescriptionBranch(String branchCode,String askedCode);
    @Override
    Page<SicmedStandardprescriptionBranch> findPage(Page<SicmedStandardprescriptionBranch> page, SicmedStandardprescriptionBranch entity);




}
