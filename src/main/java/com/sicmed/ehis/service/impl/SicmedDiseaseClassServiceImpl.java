package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedDiseaseClass;
import com.sicmed.ehis.mapper.master.SicmedDiseaseClassWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedDiseaseClassReadMapper;
import com.sicmed.ehis.service.SicmedDiseaseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 9:01
 * @Todo:
 */
@Service
public class SicmedDiseaseClassServiceImpl  implements SicmedDiseaseClassService {

    @Autowired
    private SicmedDiseaseClassReadMapper sicmedDiseaseClassReadMapper;

    @Autowired
    private SicmedDiseaseClassWriteMapper sicmedDiseaseClassWriteMapper;

    @Override
    public int insertSelective(SicmedDiseaseClass sicmedDiseaseClass) {
        return sicmedDiseaseClassWriteMapper.insertSelective(sicmedDiseaseClass);
    }

    @Override
    public int insert(SicmedDiseaseClass entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedDiseaseClass entity) {
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
    public SicmedDiseaseClass selectById(String id) {
        return sicmedDiseaseClassReadMapper.selectById(id);
    }

    @Override
    public SicmedDiseaseClass selectOneByParams(SicmedDiseaseClass entity) {
        return null;
    }

    @Override
    public List<SicmedDiseaseClass> findAllList(Query query) {
        return sicmedDiseaseClassReadMapper.findAllList(query);
    }

    @Override
    public List<SicmedDiseaseClass> selectALLByParams(SicmedDiseaseClass sicmedDiseaseClass, Query query) {
        return null;
    }

    @Override
    public Page<SicmedDiseaseClass> findPage(Page<SicmedDiseaseClass> page, SicmedDiseaseClass entity) {
        return null;
    }
}
