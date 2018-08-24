/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCase;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCureCheck;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspect;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedical;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalUse;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedTwxrayCheck;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedCaseDao;

import java.util.List;

/**
 * 病历表Service
 *
 * @author Max
 * @version 2016-07-18
 */
@Service
@Transactional(readOnly = true)
public class SicmedCaseService extends CrudService<SicmedCaseDao, SicmedCase> {

    @Autowired
    private SicmedCaseDao sicmedCaseDao;
    @Autowired
    private SicmedAskedService sicmedAskedService;
    @Autowired
    private SicmedTwxrayCheckService sicmedTwxrayCheckService;
    @Autowired
    private SicmedInspectService sicmedInspectService;
    @Autowired
    private SicmedCureCheckService sicmedCureCheckService;
    @Autowired
    private SicmedMedicalService sicmedMedicalService;
    @Autowired
    private SicmedMedicalUseService sicmedMedicalUseService;


    @Override
    public SicmedCase get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedCase> findList(SicmedCase sicmedCase) {
        return super.findList(sicmedCase);
    }

    @Override
    public Page<SicmedCase> findPage(Page<SicmedCase> page, SicmedCase sicmedCase) {
        Page<SicmedCase> tempPage = new Page<SicmedCase>();
        tempPage = sicmedCase.setPage(page);
        page.setList(sicmedCaseDao.findList1(sicmedCase));
        for (SicmedCase tempSicmedCase : tempPage.getList()) {
            if (tempSicmedCase.getSicmedAsked() == null) {
                continue;
            }
            this.searchSicmedCase(tempSicmedCase);

        }
        /*
		 * List<SicmedCase> tempList = Lists.newArrayList(); tempList =
		 * tempPage.getList(); for (SicmedCase tempSicmedCase :
		 * tempPage.getList()) { //当是按照条件查询的时候sicmedCase不为空 if
		 * (sicmedCase.getNameStr() != null&&sicmedCase.getNameStr() !="") {
		 * if(sicmedCase.getNameStr().equals("未设置")){ //判断askcode是否存在 存在的话
		 * 就从list中剔除掉 if (tempSicmedCase.getSicmedAsked()!=null) {
		 * tempPage.getList().remove(tempSicmedCase); } } } else { if
		 * (tempSicmedCase.getSicmedAsked() == null) { continue; }
		 * this.searchSicmedCase(tempSicmedCase); } }
		 */
        return tempPage;
    }

    @Transactional(readOnly = false)
    public SicmedCase searchSicmedCase(SicmedCase sicmedCase) {
        // 医嘱详情
        String detailStr = new String();
        SicmedAsked sicmedAsked = sicmedCase.getSicmedAsked();
        switch (Integer.valueOf(sicmedAsked.getSicmedAskedClass().getClassNumber())) {
            case 0:// check
                SicmedTwxrayCheck twxrayCheck = sicmedTwxrayCheckService.get(sicmedAsked.getOrderCode());
                if (twxrayCheck == null) {
                    break;
                }
                sicmedCase.setDataEntity(twxrayCheck);
                detailStr = twxrayCheck.getCheckName();
                break;
            case 1:// inspect
                SicmedInspect inspect = sicmedInspectService.get(sicmedAsked.getOrderCode());
                if (inspect == null) {
                    break;
                }
                sicmedCase.setDataEntity(inspect);
                detailStr = inspect.getInspectName();
                break;
            case 2:// cure
                SicmedCureCheck cureCheck = sicmedCureCheckService.get(sicmedAsked.getOrderCode());
                if (cureCheck == null) {
                    break;
                }
                sicmedCase.setDataEntity(cureCheck);
                detailStr = cureCheck.getCureName();
                break;
            case 3:// medical 对应有用法 asked表中的medical_user_code
                SicmedMedical medical =
                        sicmedMedicalService.get(sicmedAsked.getOrderCode());
                if (medical == null) {
                    break;
                }
                // detailStr = medical.getMedicalNameChina();
                SicmedMedicalUse medicalUse = sicmedMedicalUseService.get(sicmedAsked.getSicmedMedicalUse());
                if (medicalUse == null) {
                    break;
                }
                detailStr = "药品名称:" + medical.getMedicalNameChina() + "，药品类型：" + medicalUse.getUseBun() + "。用法：" + medicalUse.getUseGroup() + "使用" + "，每次" + medicalUse.getUseAmount()
                        + medicalUse.getUseUnit() + "，每天" + medicalUse.getUseBout() + "次" + "，共" + medicalUse.getUseDay() + "天";
                sicmedCase.setDataEntity(medical);
                sicmedCase.setDataEntityUse(medicalUse);
                break;

            default:
                break;
        }
        sicmedCase.setDetailStr(detailStr);
        return sicmedCase;
    }

    @Transactional(readOnly = false)
    public void save(SicmedCase sicmedCase) {
        super.save(sicmedCase);
    }

    @Transactional(readOnly = false)
    public void delete(SicmedCase sicmedCase) {
        super.delete(sicmedCase);
    }

    @Transactional(readOnly = false)
    public void update(SicmedCase sicmedCase) {
        sicmedCaseDao.update(sicmedCase);
    }

    public SicmedCase getByEntity(SicmedCase sicmedCase) {
        return sicmedCaseDao.getByEntity(sicmedCase);
    }

    //复制数据表 表结构和表中数据 复制 清空原表
    @Transactional(readOnly = false)
    public void clearTable(String copyName) {
        SicmedCase sicmedCase = new SicmedCase();
        sicmedCase.setCopyTableName(copyName);
        sicmedCaseDao.copyTable(sicmedCase);
        sicmedCaseDao.insertTable(sicmedCase);
        sicmedCaseDao.clearTable();
    }


    public List<SicmedCase> getSicmedCaseDetail(SicmedCase sicmedCase) {
        List<SicmedCase> tempList = Lists.newArrayList();
        tempList = sicmedCaseDao.findList1(sicmedCase);
        for (SicmedCase tempSicmedCase : tempList) {
            if (tempSicmedCase.getSicmedAsked() == null) {
                continue;
            }
            this.searchSicmedCase(tempSicmedCase);
        }
        return tempList;
    }

    public List<SicmedCase> findPageWithDate(SicmedCase sicmedCase) {
        return sicmedCaseDao.findListWithDate(sicmedCase);
    }

}