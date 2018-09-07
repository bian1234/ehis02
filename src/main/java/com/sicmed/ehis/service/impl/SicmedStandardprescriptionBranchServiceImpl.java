package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedStandardprescriptionBranch;
import com.sicmed.ehis.mapper.master.SicmedStandardprescriptionBranchWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedStandardprescriptionBranchReadMapper;
import com.sicmed.ehis.service.SicmedStandardprescriptionBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/7 16:22
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SicmedStandardprescriptionBranchServiceImpl  implements SicmedStandardprescriptionBranchService{



    @Autowired
    private SicmedStandardprescriptionBranchReadMapper sicmedStandardprescriptionBranchReadMapper;

    @Autowired
    private SicmedStandardprescriptionBranchWriteMapper sicmedStandardprescriptionBranchWriteMapper;


    @Override
    public List<SicmedStandardprescriptionBranch> findStandardPrescriptionBranch(String branchCode, String askedCode) {
        return sicmedStandardprescriptionBranchReadMapper.findStandardPrescriptionBranch(branchCode,askedCode);
    }
    @Override
    public int insertSelective(SicmedStandardprescriptionBranch sicmedStandardprescriptionBranch) {
        return 0;
    }

    @Override
    public int insert(SicmedStandardprescriptionBranch entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedStandardprescriptionBranch entity) {
        return 0;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }

    @Override
    public int logicDelete(String id) {
        return 0;
    }

    @Override
    public SicmedStandardprescriptionBranch selectById(String id) {
        return sicmedStandardprescriptionBranchReadMapper.selectByPrimaryKey(id);
    }

    @Override
    public SicmedStandardprescriptionBranch selectOneByParams(SicmedStandardprescriptionBranch entity) {
        return null;
    }

    @Override
    public List<SicmedStandardprescriptionBranch> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedStandardprescriptionBranch> selectALLByParams(SicmedStandardprescriptionBranch sicmedStandardprescriptionBranch, Query query) {
        return null;
    }

    @Override
    public Page<SicmedStandardprescriptionBranch> findPage(Page<SicmedStandardprescriptionBranch> page, SicmedStandardprescriptionBranch entity) {
        return null;
    }
}
