package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.entity.SicmedInspectPrice;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 14:07
 * @Todo:  检验价格服务
 */

public interface SicmedInspectPriceService  extends BaseService<SicmedInspectPrice> {

    @Override
    SicmedInspectPrice selectById(String id);
}
