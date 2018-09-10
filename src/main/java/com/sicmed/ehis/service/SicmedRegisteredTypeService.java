package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.entity.SicmedRegisteredType;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 16:04
 * @Todo:
 */

public interface SicmedRegisteredTypeService  extends BaseService<SicmedRegisteredType> {

    @Override
     SicmedRegisteredType selectById(String id);

    List<SicmedRegisteredType> selectByGrades(String codeGrades);
}
