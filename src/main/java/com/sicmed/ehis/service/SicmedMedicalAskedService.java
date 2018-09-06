package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.entity.SicmedMedicalAsked;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 14:21
 * @Todo:
 */

public interface SicmedMedicalAskedService  extends BaseService<SicmedMedicalAsked> {

    @Override
    SicmedMedicalAsked selectById(String id);
}
