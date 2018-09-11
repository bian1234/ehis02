package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedInspect;
import org.apache.ibatis.ognl.ASTSequence;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 13:49
 * @Todo:   检验服务
 */

public interface SicmedInspectService  extends BaseService<SicmedInspect> {


    @Override
    int insertSelective(SicmedInspect sicmedInspect);

    @Override
    int insert(SicmedInspect entity);

    @Override
    int updateSelective(SicmedInspect entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedInspect selectById(String id);



    @Override
    List<SicmedInspect> findAllList(Query query);

    @Override
    List<SicmedInspect> selectALLByParams(SicmedInspect sicmedInspect, Query query);

    @Override
    Page<SicmedInspect> findPage(Page<SicmedInspect> page, SicmedInspect entity);


    /**
     * 模糊查询
     */
    List<SicmedInspect>  findListLike(Map map);
}
