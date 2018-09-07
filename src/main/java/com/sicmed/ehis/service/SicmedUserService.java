package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedUser;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 17:17
 * @Todo:  用户服务
 */

public interface SicmedUserService  extends BaseService<SicmedUser> {


    @Override
    int insertSelective(SicmedUser sicmedUser);

    @Override
    int insert(SicmedUser entity);

    @Override
    int updateSelective(SicmedUser entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedUser selectById(String id);

    @Override
    SicmedUser selectOneByParams(SicmedUser entity);

    @Override
    List<SicmedUser> findAllList(Query query);

    @Override
    List<SicmedUser> selectALLByParams(SicmedUser sicmedUser, Query query);

    @Override
    Page<SicmedUser> findPage(Page<SicmedUser> page, SicmedUser entity);
}
