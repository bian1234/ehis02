package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedTwxrayClass;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 10:06
 * @Todo:  放射线大分类服务
 */

public interface SicmedTwxrayClassService   extends BaseService<SicmedTwxrayClass> {

    @Override
    int insertSelective(SicmedTwxrayClass sicmedTwxrayClass);

    @Override
    int insert(SicmedTwxrayClass entity);

    @Override
    int updateSelective(SicmedTwxrayClass entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedTwxrayClass selectById(String id);

    @Override
    SicmedTwxrayClass selectOneByParams(SicmedTwxrayClass entity);

    @Override
    List<SicmedTwxrayClass> findAllList(Query query);

    @Override
    List<SicmedTwxrayClass> selectALLByParams(SicmedTwxrayClass sicmedTwxrayClass, Query query);

    @Override
    Page<SicmedTwxrayClass> findPage(Page<SicmedTwxrayClass> page, SicmedTwxrayClass entity);
}
