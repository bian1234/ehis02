package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.entity.SicmedDisease;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 15:24
 * @Todo:   疾病服务
 */

public interface SicmedDiseaseService  extends BaseService<SicmedDisease> {


    List<SicmedDisease> getByClass(Map map);

    List<SicmedDisease> searchDisease(Map map);
}
