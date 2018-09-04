package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedAskedClass;
import com.sicmed.ehis.mapper.master.SicmedAskedClassWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedAskedBranchReadMapper;
import com.sicmed.ehis.mapper.slaver.SicmedAskedClassReadMapper;
import com.sicmed.ehis.service.SicmedAskedClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/3 18:16
 * @Todo:
 */
@Service
public class SicmedAskedClassServiceImpl  implements SicmedAskedClassService{

    @Autowired
    private SicmedAskedClassWriteMapper sicmedAskedClassWriteMapper;

    @Autowired
    private SicmedAskedClassReadMapper sicmedAskedClassReadMapper;


    @Override
    public int insertSelective(SicmedAskedClass sicmedAskedClass) {
        return sicmedAskedClassWriteMapper.insertSelective(sicmedAskedClass);
    }

    @Override
    public int insert(SicmedAskedClass entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedAskedClass entity) {
        return sicmedAskedClassWriteMapper.updateSelective(entity);
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }

    @Override
    public int logicDelete(String id) {
        return sicmedAskedClassWriteMapper.logicDelete(id);
    }

    @Override
    public SicmedAskedClass selectById(String id) {
        return sicmedAskedClassReadMapper.selectById(id);
    }

    @Override
    public SicmedAskedClass selectOneByParams(SicmedAskedClass entity) {
        return null;
    }



    @Override
    public List<SicmedAskedClass> findAllList(Query query) {
        return sicmedAskedClassReadMapper.findAllList(query);
    }

    @Override
    public List<SicmedAskedClass> selectALLByParams(SicmedAskedClass sicmedAskedClass, Query query) {
        return null;
    }


    @Override
    public Page<SicmedAskedClass> findPage(Page<SicmedAskedClass> page, SicmedAskedClass entity) {
        return null;
    }
}
