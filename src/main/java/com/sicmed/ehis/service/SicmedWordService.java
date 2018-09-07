package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedWord;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/7 13:14
 * @Todo:   word 服务
 */

public interface SicmedWordService extends BaseService<SicmedWord> {

    @Override
    int insertSelective(SicmedWord sicmedWord);

    @Override
    int insert(SicmedWord entity);

    @Override
    int updateSelective(SicmedWord entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedWord selectById(String id);

    @Override
    SicmedWord selectOneByParams(SicmedWord entity);

    @Override
    List<SicmedWord> findAllList(Query query);

    @Override
    List<SicmedWord> selectALLByParams(SicmedWord sicmedWord, Query query);

    @Override
    Page<SicmedWord> findPage(Page<SicmedWord> page, SicmedWord entity);
}
