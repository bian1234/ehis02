package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.entity.SicmedRegisteredType;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 16:04
 * @Todo:
 */

public interface SicmedRegisteredTypeService  extends BaseService<SicmedRegisteredType> {

    @Override
    public SicmedRegisteredType selectById(String id);
}
