package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedCureCheck;
import com.sicmed.ehis.mapper.master.SicmedCureCheckWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedCureCheckReadMapper;
import com.sicmed.ehis.service.SicmedCureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 9:26
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SicmedCureCheckServiceImpl  implements SicmedCureCheckService {

    @Autowired
    private SicmedCureCheckReadMapper sicmedCureCheckReadMapper;

    @Autowired
    private SicmedCureCheckWriteMapper sicmedCureCheckWriteMapper;

    @Override
    public int insertSelective(SicmedCureCheck sicmedCureCheck) {
        return 0;
    }

    @Override
    public int insert(SicmedCureCheck entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedCureCheck entity) {
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
    public SicmedCureCheck selectById(String id) {
        return null;
    }

    @Override
    public SicmedCureCheck selectOneByParams(SicmedCureCheck entity) {
        return null;
    }

    @Override
    public List<SicmedCureCheck> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedCureCheck> selectALLByParams(SicmedCureCheck sicmedCureCheck, Query query) {
        return null;
    }

    @Override
    public Page<SicmedCureCheck> findPage(Page<SicmedCureCheck> page, SicmedCureCheck entity) {
        return null;
    }

    @Override
    public List<SicmedCureCheck> searchCure(Map map) {
        return sicmedCureCheckReadMapper.searchCure(map);
    }
}
