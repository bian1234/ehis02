package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedInviteNumber;
import com.sicmed.ehis.mapper.slaver.SicmedInviteNumberReadMapper;
import com.sicmed.ehis.service.SicmedInviteNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/7 9:37
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SicmedInviteNumberServiceImpl  implements SicmedInviteNumberService {

    @Autowired
    private SicmedInviteNumberReadMapper sicmedInviteNumberReadMapper;
    @Override
    public int insertSelective(SicmedInviteNumber sicmedInviteNumber) {
        return 0;
    }

    @Override
    public int insert(SicmedInviteNumber entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedInviteNumber entity) {
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
    public SicmedInviteNumber selectById(String id) {
        return sicmedInviteNumberReadMapper.selectByPrimaryKey(id);
    }

    @Override
    public SicmedInviteNumber selectOneByParams(SicmedInviteNumber entity) {
        return null;
    }

    @Override
    public List<SicmedInviteNumber> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedInviteNumber> selectALLByParams(SicmedInviteNumber sicmedInviteNumber, Query query) {
        return null;
    }

    @Override
    public Page<SicmedInviteNumber> findPage(Page<SicmedInviteNumber> page, SicmedInviteNumber entity) {
        return null;
    }
}
