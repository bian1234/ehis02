package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedDisease;
import com.sicmed.ehis.mapper.slaver.SicmedDiseaseReadMapper;
import com.sicmed.ehis.service.SicmedDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 15:25
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SicmedDiseaseServiceImpl  implements SicmedDiseaseService {


    @Autowired
    private SicmedDiseaseReadMapper sicmedDiseaseReadMapper;


    @Override
    public List<SicmedDisease> getByClass(Map map) {
        return sicmedDiseaseReadMapper.getByClass(map);
    }


    @Override
    public List<SicmedDisease> searchDisease(Map map) {
        return sicmedDiseaseReadMapper.searchDisease(map);
    }

    @Override
    public int insertSelective(SicmedDisease sicmedDisease) {
        return 0;
    }

    @Override
    public int insert(SicmedDisease entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedDisease entity) {
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
    public SicmedDisease selectById(String id) {
        return sicmedDiseaseReadMapper.selectByPrimaryKey(id);
    }

    @Override
    public SicmedDisease selectOneByParams(SicmedDisease entity) {
        return null;
    }

    @Override
    public List<SicmedDisease> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedDisease> selectALLByParams(SicmedDisease sicmedDisease, Query query) {
        return null;
    }

    @Override
    public Page<SicmedDisease> findPage(Page<SicmedDisease> page, SicmedDisease entity) {
        return null;
    }
}
