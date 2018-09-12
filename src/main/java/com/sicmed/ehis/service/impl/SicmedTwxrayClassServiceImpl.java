package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedTwxrayClass;
import com.sicmed.ehis.mapper.master.SicmedTwxrayClassWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedTwxrayClassReadMapper;
import com.sicmed.ehis.service.SicmedTwxrayClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 10:08
 * @Todo:
 */

@Service
public class SicmedTwxrayClassServiceImpl  implements SicmedTwxrayClassService {

    @Autowired
    private SicmedTwxrayClassReadMapper sicmedTwxrayClassReadMapper;
    @Autowired
    private SicmedTwxrayClassWriteMapper sicmedTwxrayClassWriteMapper;

    @Override
    public int insertSelective(SicmedTwxrayClass sicmedTwxrayClass) {
        return 0;
    }

    @Override
    public int insert(SicmedTwxrayClass entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedTwxrayClass entity) {
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
    public SicmedTwxrayClass selectById(String id) {
        return null;
    }


    @Override
    public List<SicmedTwxrayClass> selectOneByParams(SicmedTwxrayClass entity) {
        return null;
    }

    @Override
    public List<SicmedTwxrayClass> findAllList(Query query) {
        return sicmedTwxrayClassReadMapper.findAllList(query);
    }

    @Override
    public List<SicmedTwxrayClass> selectALLByParams(SicmedTwxrayClass sicmedTwxrayClass, Query query) {
        return null;
    }

    @Override
    public Page<SicmedTwxrayClass> findPage(Page<SicmedTwxrayClass> page, SicmedTwxrayClass entity) {
        return null;
    }
}
