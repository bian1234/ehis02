package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedInspect;
import com.sicmed.ehis.mapper.master.SicmedInspectWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedInspectReadMapper;
import com.sicmed.ehis.service.SicmedInspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 14:07
 * @Todo:   检验服务
 */
@Service
public class SicmedInspectServiceImpl  implements SicmedInspectService {


    @Autowired
    private SicmedInspectReadMapper sicmedInspectReadMapper;

    @Autowired
    private SicmedInspectWriteMapper sicmedInspectWriteMapper;
    @Override
    public int insertSelective(SicmedInspect sicmedInspect) {
        return 0;
    }

    @Override
    public int insert(SicmedInspect entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedInspect entity) {
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
    public SicmedInspect selectById(String id) {
        return null;
    }

    @Override
    public List<SicmedInspect> selectOneByParams(SicmedInspect entity) {
        return null;
    }

    @Override
    public List<SicmedInspect> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedInspect> selectALLByParams(SicmedInspect sicmedInspect, Query query) {
        return null;
    }

    @Override
    public Page<SicmedInspect> findPage(Page<SicmedInspect> page, SicmedInspect entity) {
        return null;
    }

    @Override
    public List<SicmedInspect> findListLike(Map map) {
        return sicmedInspectReadMapper.findListLike(map);
    }
}
