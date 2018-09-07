package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedRegisteredType;
import com.sicmed.ehis.mapper.slaver.SicmedRegisteredTypeReadMapper;
import com.sicmed.ehis.service.SicmedRegisteredTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 16:06
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SicmedRegisteredTypeServiceImpl  implements SicmedRegisteredTypeService {

    @Autowired
    private SicmedRegisteredTypeReadMapper sicmedRegisteredTypeReadMapper;
    @Override
    public SicmedRegisteredType selectById(String id) {
        return sicmedRegisteredTypeReadMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SicmedRegisteredType sicmedRegisteredType) {
        return 0;
    }

    @Override
    public int insert(SicmedRegisteredType entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedRegisteredType entity) {
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
    public SicmedRegisteredType selectOneByParams(SicmedRegisteredType entity) {
        return null;
    }

    @Override
    public List<SicmedRegisteredType> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedRegisteredType> selectALLByParams(SicmedRegisteredType sicmedRegisteredType, Query query) {
        return null;
    }

    @Override
    public Page<SicmedRegisteredType> findPage(Page<SicmedRegisteredType> page, SicmedRegisteredType entity) {
        return null;
    }
}
