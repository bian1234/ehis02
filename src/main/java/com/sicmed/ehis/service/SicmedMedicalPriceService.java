package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.entity.SicmedMedicalPrice;

/**
 * @Author: ykbian
 * @Date: 2018/9/7 10:00
 * @Todo:  药品价格服务
 */

public interface SicmedMedicalPriceService extends BaseService<SicmedMedicalPrice>{

    @Override
    SicmedMedicalPrice selectById(String id);
}
