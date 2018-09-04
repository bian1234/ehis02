package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedBranch;
import com.sicmed.ehis.mapper.master.SicmedBranchWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedBranchReadMapper;
import com.sicmed.ehis.service.SicmedBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/4 14:54
 * @Todo:  科室信息服务
 */
@Service
public class SicmedBranchServiceImpl  implements SicmedBranchService {

    @Autowired
    private SicmedBranchReadMapper sicmedBranchReadMapper;

    @Autowired
    private SicmedBranchWriteMapper sicmedBranchWriteMapper;


    @Override
    public int insertSelective(SicmedBranch sicmedBranch) {
        return sicmedBranchWriteMapper.insertSelective(sicmedBranch);
    }

    @Override
    public int insert(SicmedBranch entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedBranch entity) {
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
    public SicmedBranch selectById(String id) {
        return sicmedBranchReadMapper.selectById(id);
    }

    @Override
    public SicmedBranch selectOneByParams(SicmedBranch entity) {
        return null;
    }

    @Override
    public List<SicmedBranch> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedBranch> selectRegistered(Query query) {
        return sicmedBranchReadMapper.selectRegistered(query);
    }

    @Override
    public List<SicmedBranch> selectALLByParams(SicmedBranch sicmedBranch, Query query) {
        return null;
    }

    @Override
    public Page<SicmedBranch> findPage(Page<SicmedBranch> page, SicmedBranch entity) {
        return null;
    }
}
