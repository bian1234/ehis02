package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedEntrustedAsked;
import com.sicmed.ehis.mapper.master.SicmedEntrustedAskedWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedEntrustedAskedReadMapper;
import com.sicmed.ehis.service.SicmedEntrustedAskedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/10 13:36
 * @Todo:
 */
@Service
public class SicmedEntrustedAskedServcieImpl  implements SicmedEntrustedAskedService {


    @Autowired
    private SicmedEntrustedAskedReadMapper sicmedEntrustedAskedReadMapper;

    @Autowired
    private SicmedEntrustedAskedWriteMapper sicmedEntrustedAskedWriteMapper;


    @Override
    public int insertSelective(SicmedEntrustedAsked sicmedEntrustedAsked) {
        return sicmedEntrustedAskedWriteMapper.insertSelective(sicmedEntrustedAsked);
    }

    @Override
    public int insert(SicmedEntrustedAsked entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedEntrustedAsked entity) {
        return sicmedEntrustedAskedWriteMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int deleteById(String id) {
        return sicmedEntrustedAskedWriteMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int logicDelete(String id) {
        return sicmedEntrustedAskedWriteMapper.logicDelete(id);
    }

    @Override
    public SicmedEntrustedAsked selectById(String id) {
        return sicmedEntrustedAskedReadMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SicmedEntrustedAsked> selectOneByParams(SicmedEntrustedAsked entity) {
        return null;
    }

    @Override
    public List<SicmedEntrustedAsked> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedEntrustedAsked> selectALLByParams(SicmedEntrustedAsked sicmedEntrustedAsked, Query query) {
        return null;
    }

    @Override
    public Page<SicmedEntrustedAsked> findPage(Page<SicmedEntrustedAsked> page, SicmedEntrustedAsked entity) {
        return null;
    }
}
