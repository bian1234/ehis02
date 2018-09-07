package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedTwxrayCheck;
import com.sicmed.ehis.mapper.master.SicmedTwxrayCheckWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedTwxrayCheckReadMapper;
import com.sicmed.ehis.service.SicmedTwxrayCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 16:52
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SicmedTwxrayCheckServiceImpl  implements SicmedTwxrayCheckService {


    @Autowired
    private SicmedTwxrayCheckReadMapper sicmedTwxrayCheckReadMapper;

    @Autowired
    private SicmedTwxrayCheckWriteMapper sicmedTwxrayCheckWriteMapper;


    @Override
    public int insertSelective(SicmedTwxrayCheck sicmedTwxrayCheck) {
        return 0;
    }

    @Override
    public int insert(SicmedTwxrayCheck entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedTwxrayCheck entity) {
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
    public SicmedTwxrayCheck selectById(String id) {
        return null;
    }

    @Override
    public SicmedTwxrayCheck selectOneByParams(SicmedTwxrayCheck entity) {
        return null;
    }

    @Override
    public List<SicmedTwxrayCheck> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedTwxrayCheck> selectALLByParams(SicmedTwxrayCheck sicmedTwxrayCheck, Query query) {
        return null;
    }

    @Override
    public Page<SicmedTwxrayCheck> findPage(Page<SicmedTwxrayCheck> page, SicmedTwxrayCheck entity) {
        return null;
    }
}
