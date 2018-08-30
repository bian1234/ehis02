/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.sys.service;

import com.thinkgem.jeesite.cfq.common.service.TreeService;
import com.thinkgem.jeesite.cfq.sys.dao.PrescriptionAreaDao;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionArea;
import com.thinkgem.jeesite.cfq.sys.utils.PrescriptionUserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



/**
 * 区域Service
 *
 * @author ThinkGem
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class PrescriptionAreaService extends TreeService<PrescriptionAreaDao, PrescriptionArea> {

    public List<PrescriptionArea> findAll() {
        return PrescriptionUserUtils.getPrescriptionAreaList();
    }

    @Override
    @Transactional(readOnly = false)
    public void save(PrescriptionArea prescriptionArea) {
        super.save(prescriptionArea);
        PrescriptionUserUtils.removeCache(PrescriptionUserUtils.CACHE_AREA_LIST);
    }


    @Override
    @Transactional(readOnly = false)
    public void delete(PrescriptionArea prescriptionArea) {
        super.delete(prescriptionArea);
        PrescriptionUserUtils.removeCache(PrescriptionUserUtils.CACHE_AREA_LIST);
    }

}
