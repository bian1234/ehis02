package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedUser;
import com.sicmed.ehis.mapper.master.SicmedUserWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedUserReadMapper;
import com.sicmed.ehis.service.SicmedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 17:19
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SicmedUserServiceImpl implements SicmedUserService {

    @Autowired
    private SicmedUserReadMapper sicmedUserReadMapper;

    @Autowired
    private SicmedUserWriteMapper sicmedUserWriteMapper;

    @Override
    public int insertSelective(SicmedUser sicmedUser) {
        return 0;
    }

    @Override
    public int insert(SicmedUser entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedUser entity) {
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
    public SicmedUser selectById(String id) {
        return null;
    }

    @Override
    public SicmedUser selectOneByParams(SicmedUser entity) {
        return null;
    }

    @Override
    public List<SicmedUser> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedUser> selectALLByParams(SicmedUser sicmedUser, Query query) {
        return null;
    }

    @Override
    public Page<SicmedUser> findPage(Page<SicmedUser> page, SicmedUser entity) {
        return null;
    }
}
