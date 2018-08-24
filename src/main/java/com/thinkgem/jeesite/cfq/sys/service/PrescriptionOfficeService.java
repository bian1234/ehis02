/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.common.service.TreeService;
import com.thinkgem.jeesite.cfq.sys.dao.PrescriptionOfficeDao;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionOffice;
import com.thinkgem.jeesite.cfq.sys.utils.PrescriptionUserUtils;

/**
 * 机构Service
 *
 * @author ThinkGem
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class PrescriptionOfficeService extends TreeService<PrescriptionOfficeDao, PrescriptionOffice> {

    public List<PrescriptionOffice> findAll() {
        return PrescriptionUserUtils.getPrescriptionOfficeList();
    }

    public List<PrescriptionOffice> findList(Boolean isAll) {
        if (isAll != null && isAll) {
            return PrescriptionUserUtils.getPrescriptionOfficeAllList();
        } else {
            return PrescriptionUserUtils.getPrescriptionOfficeList();
        }
    }


    @Override
    @Transactional(readOnly = true)
    public List<PrescriptionOffice> findList(PrescriptionOffice prescriptionOffice) {
        if (prescriptionOffice != null) {
            prescriptionOffice.setParentIds(prescriptionOffice.getParentIds() + "%");
            return dao.findByParentIdsLike(prescriptionOffice);
        }
        return new ArrayList<PrescriptionOffice>();
    }

    @Override
    @Transactional(readOnly = false)
    public void save(PrescriptionOffice prescriptionOffice) {
        super.save(prescriptionOffice);
        PrescriptionUserUtils.removeCache(PrescriptionUserUtils.CACHE_OFFICE_LIST);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(PrescriptionOffice prescriptionOffice) {
        super.delete(prescriptionOffice);
        PrescriptionUserUtils.removeCache(PrescriptionUserUtils.CACHE_OFFICE_LIST);
    }

}
