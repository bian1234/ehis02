package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedCity;
import com.sicmed.ehis.mapper.master.SicmedCityWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedCityReadMapper;
import com.sicmed.ehis.service.SicmedCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 10:40
 * @Todo:
 */
@Service
public class SicmedCityServiceImpl  implements SicmedCityService {

    @Autowired
    private SicmedCityReadMapper sicmedCityReadMapper;
    @Autowired
    private SicmedCityWriteMapper sicmedCityWriteMapper;

    @Override
    public int insertSelective(SicmedCity sicmedCity) {
        return 0;
    }

    @Override
    public int insert(SicmedCity entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedCity entity) {
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
    public SicmedCity selectById(String id) {
        return sicmedCityReadMapper.selectById(id);
    }

    @Override
    public SicmedCity selectOneByParams(SicmedCity entity) {
        return null;
    }

    @Override
    public List<SicmedCity> findAllList(Query query) {
        return sicmedCityReadMapper.findAllList(query);
    }

    @Override
    public List<SicmedCity> selectALLByParams(SicmedCity sicmedCity, Query query) {
        return null;
    }

    @Override
    public Page<SicmedCity> findPage(Page<SicmedCity> page, SicmedCity entity) {
        return null;
    }

    @Override
    public List<SicmedCity> getChild(String cityParentId) {
        return sicmedCityReadMapper.getChild(cityParentId);
    }
}
