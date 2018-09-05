package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedCureClass;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 17:37
 * @Todo:   治疗大分类
 */

public interface SicmedCureClassService extends BaseService<SicmedCureClass>{

    @Override
    int insertSelective(SicmedCureClass sicmedCureClass);

    @Override
    int insert(SicmedCureClass entity);

    @Override
    int updateSelective(SicmedCureClass entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedCureClass selectById(String id);

    @Override
    SicmedCureClass selectOneByParams(SicmedCureClass entity);

    @Override
    List<SicmedCureClass> findAllList(Query query);

    @Override
    List<SicmedCureClass> selectALLByParams(SicmedCureClass sicmedCureClass, Query query);

    @Override
    Page<SicmedCureClass> findPage(Page<SicmedCureClass> page, SicmedCureClass entity);
}
