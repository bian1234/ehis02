package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedDept;
import com.sicmed.ehis.mapper.master.SicmedDeptWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedDeptReadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/4 18:57
 * @Todo:
 */
@Service
public class SicmedDeptServiceImpl  implements SicmedDeptService {

    @Autowired
    private SicmedDeptReadMapper sicmedDeptReadMapper;

    @Autowired
    private SicmedDeptWriteMapper sicmedDeptWriteMapper;


    @Override
    public int insertSelective(SicmedDept sicmedDept) {
        return sicmedDeptWriteMapper.insertSelective(sicmedDept);
    }

    @Override
    public int insert(SicmedDept entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedDept entity) {
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
    public SicmedDept selectById(String id) {
        return sicmedDeptReadMapper.selectById(id);
    }

    @Override
    public SicmedDept selectOneByParams(SicmedDept entity) {
        return null;
    }

    @Override
    public List<SicmedDept> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedDept> selectALLByParams(SicmedDept sicmedDept, Query query) {
        return null;
    }

    @Override
    public Page<SicmedDept> findPage(Page<SicmedDept> page, SicmedDept entity) {
        return null;
    }
}
