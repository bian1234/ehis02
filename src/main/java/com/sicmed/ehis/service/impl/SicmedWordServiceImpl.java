package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedWord;
import com.sicmed.ehis.mapper.master.SicmedWordWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedWordReadMapper;
import com.sicmed.ehis.service.SicmedWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/7 13:15
 * @Todo:
 */
@Service
public class SicmedWordServiceImpl  implements SicmedWordService {

    @Autowired
    private SicmedWordReadMapper sicmedWordReadMapper;

    @Autowired
    private SicmedWordWriteMapper sicmedWordWriteMapper;

    @Override
    public int insertSelective(SicmedWord sicmedWord) {
        return 0;
    }

    @Override
    public int insert(SicmedWord entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedWord entity) {
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
    public SicmedWord selectById(String id) {
        return null;
    }

    @Override
    public SicmedWord selectOneByParams(SicmedWord entity) {
        return null;
    }

    @Override
    public List<SicmedWord> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedWord> selectALLByParams(SicmedWord sicmedWord, Query query) {
        return null;
    }

    @Override
    public Page<SicmedWord> findPage(Page<SicmedWord> page, SicmedWord entity) {
        return null;
    }
}
