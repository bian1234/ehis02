package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedAskedClass;
import com.sicmed.ehis.mapper.master.SicmedAskedClassWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedAskedBranchReadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/3 18:16
 * @Todo:
 */
public interface SicmedAskedClassService   extends BaseService<SicmedAskedClass>{


    @Override
    int insertSelective(SicmedAskedClass sicmedAskedClass);

    @Override
    int insert(SicmedAskedClass entity);

    @Override
    int updateSelective(SicmedAskedClass entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedAskedClass selectById(String id);

    @Override
    SicmedAskedClass selectOneByParams(SicmedAskedClass entity);

    @Override
    List<SicmedAskedClass> findAllList(Query query);

    @Override
    List<SicmedAskedClass> selectALLByParams(SicmedAskedClass sicmedAskedClass, Query query);

    @Override
    Page<SicmedAskedClass> findPage(Page<SicmedAskedClass> page, SicmedAskedClass entity);
}
