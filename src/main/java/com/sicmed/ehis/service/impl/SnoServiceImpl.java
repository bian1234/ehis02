package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.Sno;
import com.sicmed.ehis.mapper.slaver.SnoReadMapper;
import com.sicmed.ehis.service.SnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 14:40
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SnoServiceImpl  implements SnoService {


    @Autowired
    private SnoReadMapper snoReadMapper;
    @Override
    public int insertSelective(Sno sno) {
        return 0;
    }

    @Override
    public int insert(Sno entity) {
        return 0;
    }

    @Override
    public int updateSelective(Sno entity) {
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
    public Sno selectById(String id) {
        return snoReadMapper.selectByPrimaryKey(id);
    }

    @Override
    public Sno selectOneByParams(Sno entity) {
        return null;
    }

    @Override
    public List<Sno> findAllList(Query query) {
        return null;
    }

    @Override
    public List<Sno> selectALLByParams(Sno sno, Query query) {
        return null;
    }

    @Override
    public Page<Sno> findPage(Page<Sno> page, Sno entity) {
        return null;
    }
}
