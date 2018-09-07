package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedInviteNumber;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/7 9:36
 * @Todo:  账号激活码服务
 */

public interface SicmedInviteNumberService  extends BaseService<SicmedInviteNumber> {
    @Override
    int insertSelective(SicmedInviteNumber sicmedInviteNumber);

    @Override
    int insert(SicmedInviteNumber entity);

    @Override
    int updateSelective(SicmedInviteNumber entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedInviteNumber selectById(String id);

    @Override
    SicmedInviteNumber selectOneByParams(SicmedInviteNumber entity);

    @Override
    List<SicmedInviteNumber> findAllList(Query query);

    @Override
    List<SicmedInviteNumber> selectALLByParams(SicmedInviteNumber sicmedInviteNumber, Query query);

    @Override
    Page<SicmedInviteNumber> findPage(Page<SicmedInviteNumber> page, SicmedInviteNumber entity);
}
