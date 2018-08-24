/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.sys.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import com.thinkgem.jeesite.cfq.common.utils.DateUtils;
import com.thinkgem.jeesite.cfq.sys.dao.PrescriptionLogDao;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionLog;

/**
 * 日志Service
 *
 * @author ThinkGem
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class PrescriptionLogService extends CrudService<PrescriptionLogDao, PrescriptionLog> {

    @Override
    public Page<PrescriptionLog> findPage(Page<PrescriptionLog> page, PrescriptionLog prescriptionLog) {

        // 设置默认时间范围，默认当前月
        if (prescriptionLog.getBeginDate() == null) {
            prescriptionLog.setBeginDate(DateUtils.setDays(DateUtils.parseDate(DateUtils.getDate()), 1));
        }
        if (prescriptionLog.getEndDate() == null) {
            prescriptionLog.setEndDate(DateUtils.addMonths(prescriptionLog.getBeginDate(), 1));
        }

        return super.findPage(page, prescriptionLog);

    }

}
