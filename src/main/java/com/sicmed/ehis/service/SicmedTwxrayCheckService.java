package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedTwxrayCheck;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 16:52
 * @Todo:   放射线检查服务
 */

public interface SicmedTwxrayCheckService  extends BaseService<SicmedTwxrayCheck> {

    @Override
    int insertSelective(SicmedTwxrayCheck sicmedTwxrayCheck);

    @Override
    int insert(SicmedTwxrayCheck entity);

    @Override
    int updateSelective(SicmedTwxrayCheck entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedTwxrayCheck selectById(String id);


    @Override
    List<SicmedTwxrayCheck> findAllList(Query query);

    @Override
    List<SicmedTwxrayCheck> selectALLByParams(SicmedTwxrayCheck sicmedTwxrayCheck, Query query);

    @Override
    Page<SicmedTwxrayCheck> findPage(Page<SicmedTwxrayCheck> page, SicmedTwxrayCheck entity);
}
