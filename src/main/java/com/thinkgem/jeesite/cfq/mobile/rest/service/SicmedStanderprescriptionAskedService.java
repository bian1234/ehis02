package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCureCheck;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspect;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalUse;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStanderprescriptionAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedTwxrayCheck;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedStanderprescriptionAskedDao;

/**
 * 标准处方中的医嘱Service
 *
 * @author Max
 * @version 2016-07-20
 */
@Service
@Transactional(readOnly = true)
public class SicmedStanderprescriptionAskedService extends CrudService<SicmedStanderprescriptionAskedDao, SicmedStanderprescriptionAsked> {

    @Autowired
    private SicmedStanderprescriptionAskedDao sicmedStanderprescriptionAskedDao;
    @Autowired
    private SicmedTwxrayCheckService sicmedTwxrayCheckService;
    @Autowired
    private SicmedInspectService sicmedInspectService;
    @Autowired
    private SicmedCureCheckService sicmedCureCheckService;
    @Autowired
    private SicmedMedicalUseService sicmedMedicalUseService;

    @Override
    public SicmedStanderprescriptionAsked get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedStanderprescriptionAsked> findList(SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked) {
        return super.findList(sicmedStanderprescriptionAsked);
    }

    @Override
    //模糊查询带分页web
    public Page<SicmedStanderprescriptionAsked> findPageLike(Page<SicmedStanderprescriptionAsked> page, SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked) {
        return super.findPageLike(page, sicmedStanderprescriptionAsked);
    }

    @Override
    public Page<SicmedStanderprescriptionAsked> findPage(Page<SicmedStanderprescriptionAsked> page, SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked) {
        Page<SicmedStanderprescriptionAsked> tempPage = new Page<SicmedStanderprescriptionAsked>();
        tempPage = sicmedStanderprescriptionAsked.setPage(page);
        page.setList(sicmedStanderprescriptionAskedDao.findList1(sicmedStanderprescriptionAsked));
        for (SicmedStanderprescriptionAsked tempAsked : tempPage.getList()) {
            if (tempAsked.getSicmedAskedClass() == null) {
                continue;
            }
            this.searchAsked(tempAsked);
        }

        return tempPage;
    }

    @Transactional(readOnly = false)
    public SicmedStanderprescriptionAsked searchAsked(SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked) {
        String detailStr = new String();
        //医嘱详情
        switch (Integer.valueOf(sicmedStanderprescriptionAsked.getSicmedAskedClass().getClassNumber())) {
            case 0:
                SicmedTwxrayCheck twxrayCheck = sicmedTwxrayCheckService.get(sicmedStanderprescriptionAsked.getOrderCode());
                if (twxrayCheck == null) {
                    break;
                }
                detailStr = twxrayCheck.getCheckName();
                break;
            case 1:// inspect
                SicmedInspect inspect = sicmedInspectService.get(sicmedStanderprescriptionAsked.getOrderCode());
                if (inspect == null) {
                    break;
                }
                detailStr = inspect.getInspectName();
                break;
            case 2:// cure
                SicmedCureCheck cureCheck = sicmedCureCheckService.get(sicmedStanderprescriptionAsked.getOrderCode());
                if (cureCheck == null) {
                    break;
                }
                detailStr = cureCheck.getCureName();
                break;
            case 3:
                SicmedMedicalUse medicalUse = sicmedMedicalUseService.get(sicmedStanderprescriptionAsked.getSicmedMedicalUse());
                if (medicalUse == null) {
                    break;
                }
                detailStr = "药品类型：" + medicalUse.getUseBun() + "。用法：" + medicalUse.getUseGroup() + "，每次" + medicalUse.getUseAmount()
                        + medicalUse.getUseUnit() + "，每天" + medicalUse.getUseBout() + "次" + "，共" + medicalUse.getUseDay() + "天";
                break;
            default:
                break;
        }
        sicmedStanderprescriptionAsked.setDetailStr(detailStr);
        return sicmedStanderprescriptionAsked;

    }


    @Override
    @Transactional(readOnly = false)
    public void save(SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked) {
        super.save(sicmedStanderprescriptionAsked);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked) {
        super.delete(sicmedStanderprescriptionAsked);
    }

    public List<SicmedStanderprescriptionAsked> findByVersion(
            SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked) {
        // TODO Auto-generated method stub
        return sicmedStanderprescriptionAskedDao.findByVersion(sicmedStanderprescriptionAsked);
    }
}