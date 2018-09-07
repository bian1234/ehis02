package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedDiseaseBranch;
import com.sicmed.ehis.mapper.master.SicmedDiseaseBranchWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedDiseaseBranchReadMapper;
import com.sicmed.ehis.service.SicmedDiseaseBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 16:22
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SicmedDiseaseBranchServiceImpl  implements SicmedDiseaseBranchService {

    @Autowired
    private SicmedDiseaseBranchReadMapper sicmedDiseaseBranchReadMapper;

    @Autowired
    private SicmedDiseaseBranchWriteMapper sicmedDiseaseBranchWriteMapper;
    @Override
    @Transactional(readOnly = false)
    public int insertSelective(SicmedDiseaseBranch sicmedDiseaseBranch) {
        return sicmedDiseaseBranchWriteMapper.insertSelective(sicmedDiseaseBranch);
    }

    @Override
    public int insert(SicmedDiseaseBranch entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedDiseaseBranch entity) {
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
    public SicmedDiseaseBranch selectById(String id) {
        return sicmedDiseaseBranchReadMapper.selectByPrimaryKey(id);
    }

    @Override
    public SicmedDiseaseBranch selectOneByParams(SicmedDiseaseBranch entity) {
        return null;
    }

    @Override
    public List<SicmedDiseaseBranch> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedDiseaseBranch> selectALLByParams(SicmedDiseaseBranch sicmedDiseaseBranch, Query query) {
        return null;
    }

    @Override
    public Page<SicmedDiseaseBranch> findPage(Page<SicmedDiseaseBranch> page, SicmedDiseaseBranch entity) {
        return null;
    }

    @Override
    public List<SicmedDiseaseBranch> selectByBranch(Map map) {
        return sicmedDiseaseBranchReadMapper.selectByBranch(map);
    }
}
