package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedBaseCode;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/4 13:53
 * @Todo:   基础编码表服务接口
 */

public interface SicmedBaseCodeService  extends BaseService<SicmedBaseCode> {

    @Override
    int insertSelective(SicmedBaseCode sicmedBaseCode);

    @Override
    int insert(SicmedBaseCode entity);

    @Override
    int updateSelective(SicmedBaseCode entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedBaseCode selectById(String id);

    @Override
    SicmedBaseCode selectOneByParams(SicmedBaseCode entity);

    @Override
    List<SicmedBaseCode> findAllList(Query query);

    @Override
    List<SicmedBaseCode> selectALLByParams(SicmedBaseCode sicmedBaseCode, Query query);

    //    public SicmedBaseCode get(String id);
//    public List<SicmedBaseCode> findList(SicmedBaseCode sicmedBaseCode);
//
//    public Page<SicmedBaseCode> findPage(Page<SicmedBaseCode> page, SicmedBaseCode sicmedBaseCode);
//
//    @Transactional(readOnly = false)
//    public int  save(SicmedBaseCode sicmedBaseCode);
//
//    @Transactional(readOnly = false)
//    public void delete(SicmedBaseCode sicmedBaseCode);
}
