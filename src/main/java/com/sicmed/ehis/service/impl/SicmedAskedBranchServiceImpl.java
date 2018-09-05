package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedAskedBranch;
import com.sicmed.ehis.mapper.slaver.SicmedAskedBranchReadMapper;
import com.sicmed.ehis.service.SicmedAskedBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 14:47
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SicmedAskedBranchServiceImpl  implements SicmedAskedBranchService {

    @Autowired
    private SicmedAskedBranchReadMapper sicmedAskedBranchReadMapper;
    @Override
    public int insertSelective(SicmedAskedBranch sicmedAskedBranch) {
        return 0;
    }

    @Override
    public int insert(SicmedAskedBranch entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedAskedBranch entity) {
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
    public SicmedAskedBranch selectById(String id) {
        return sicmedAskedBranchReadMapper.selectById(id);
    }

    @Override
    public SicmedAskedBranch selectOneByParams(SicmedAskedBranch entity) {
        return null;
    }

    @Override
    public List<SicmedAskedBranch> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedAskedBranch> selectALLByParams(SicmedAskedBranch sicmedAskedBranch, Query query) {
        return null;
    }

    @Override
    public Page<SicmedAskedBranch> findPage(Page<SicmedAskedBranch> page, SicmedAskedBranch entity) {
        return null;
    }
}
