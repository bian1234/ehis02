package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedBranchAsked;
import com.sicmed.ehis.mapper.master.SicmedBranchAskedWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedBranchAskedReadMapper;
import com.sicmed.ehis.service.SicmedBranchAskedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 15:31
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SicmedBranchAskedServiceImpl implements SicmedBranchAskedService{

    @Autowired
    private SicmedBranchAskedReadMapper sicmedBranchAskedReadMapper;
    @Autowired
    private SicmedBranchAskedWriteMapper sicmedBranchAskedWriteMapper;

    @Override
    public int insertSelective(SicmedBranchAsked sicmedBranchAsked) {
        return 0;
    }

    @Override
    public int insert(SicmedBranchAsked entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedBranchAsked entity) {
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
    public SicmedBranchAsked selectById(String id) {
        return sicmedBranchAskedReadMapper.selectById(id);
    }

    @Override
    public SicmedBranchAsked selectOneByParams(SicmedBranchAsked entity) {
        return null;
    }

    @Override
    public List<SicmedBranchAsked> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedBranchAsked> selectALLByParams(SicmedBranchAsked sicmedBranchAsked, Query query) {
        return null;
    }

    @Override
    public Page<SicmedBranchAsked> findPage(Page<SicmedBranchAsked> page, SicmedBranchAsked entity) {
        return null;
    }
}
