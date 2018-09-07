package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedMedicalUse;
import com.sicmed.ehis.mapper.slaver.SicmedMedicalUseReadMapper;
import com.sicmed.ehis.service.SicmedMedicalUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/7 10:33
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SicmedMedicalUseServiceImpl  implements SicmedMedicalUseService {


    @Autowired
    private SicmedMedicalUseReadMapper sicmedMedicalUseReadMapper;


    @Override
    public int insertSelective(SicmedMedicalUse sicmedMedicalUse) {
        return 0;
    }

    @Override
    public int insert(SicmedMedicalUse entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedMedicalUse entity) {
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
    public SicmedMedicalUse selectById(String id) {
        return sicmedMedicalUseReadMapper.selectById(id);
    }

    @Override
    public SicmedMedicalUse selectOneByParams(SicmedMedicalUse entity) {
        return null;
    }

    @Override
    public List<SicmedMedicalUse> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedMedicalUse> selectALLByParams(SicmedMedicalUse sicmedMedicalUse, Query query) {
        return null;
    }

    @Override
    public Page<SicmedMedicalUse> findPage(Page<SicmedMedicalUse> page, SicmedMedicalUse entity) {
        return null;
    }
}
