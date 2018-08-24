/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.sys.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.sys.dao.PrescriptionDictDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.common.service.CrudService;
import com.thinkgem.jeesite.cfq.common.utils.CacheUtils;
import com.thinkgem.jeesite.cfq.sys.dao.PrescriptionDictDao;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionDict;
import com.thinkgem.jeesite.cfq.sys.utils.PrescriptionDictUtils;

/**
 * 字典Service
 *
 * @author ThinkGem
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class PrescriptionDictService extends CrudService<PrescriptionDictDao, PrescriptionDict> {

    /**
     * 查询字段类型列表
     *
     * @return
     */
    public List<String> findTypeList() {
        return dao.findTypeList(new PrescriptionDict());
    }

    @Override
    @Transactional(readOnly = false)
    public void save(PrescriptionDict prescriptionDict) {
        super.save(prescriptionDict);
        CacheUtils.remove(PrescriptionDictUtils.CACHE_DICT_MAP);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(PrescriptionDict prescriptionDict) {
        super.delete(prescriptionDict);
        CacheUtils.remove(PrescriptionDictUtils.CACHE_DICT_MAP);
    }

}
