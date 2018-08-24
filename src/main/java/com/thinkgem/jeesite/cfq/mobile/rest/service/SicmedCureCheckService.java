/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCureCheck;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCurePrice;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedCureCheckDao;

/**
 * RESTful接口示例Service
 *
 * @author DING
 * @version 2016-07-23
 */
@Service
@Transactional(readOnly = true)
public class SicmedCureCheckService extends CrudService<SicmedCureCheckDao, SicmedCureCheck> {

    @Autowired
    private SicmedCureCheckDao sicmedCureCheckDao;

    @Autowired
    private SicmedCurePriceService sicmedCurePriceService;

    public SicmedCureCheck get(String id) {
        return super.get(id);
    }

    /*根据编号 找到对应的治疗对象
     * */
    public SicmedCureCheck getCureCheck(SicmedCureCheck sicmedCureCheck) {
        SicmedCureCheck sicmedCureCheck1 = new SicmedCureCheck();
        sicmedCureCheck1 = sicmedCureCheckDao.getCureCheck(sicmedCureCheck);
        return sicmedCureCheck1;
    }

    public List<SicmedCureCheck> findList(SicmedCureCheck sicmedCureCheck) {
        return super.findList(sicmedCureCheck);
    }

    /**
     * 模糊查询检验项目 接口实现
     *
     * @param sicmedCureCheck
     * @return List<SicmedCureCheck>
     * @author Max
     */
    public List<SicmedCureCheck> findListLike(SicmedCureCheck sicmedCureCheck) {
        return sicmedCureCheckDao.findListLike(sicmedCureCheck);
    }

    @Transactional(readOnly = false)
    public Page<SicmedCureCheck> findPage(Page<SicmedCureCheck> page, SicmedCureCheck sicmedCureCheck) {
        Page<SicmedCureCheck> tempPage = new Page<SicmedCureCheck>();
        tempPage = super.findPage(page, sicmedCureCheck);
        return tempPage;
    }

    //模糊查询带分页
    public Page<SicmedCureCheck> findPageLike(Page<SicmedCureCheck> page, SicmedCureCheck sicmedCureCheck) {
        return super.findPageLike(page, sicmedCureCheck);
    }

    @Transactional(readOnly = false)
    public void update(SicmedCureCheck sicmedCureCheck) {
        //先创建价格表信息 并且保存
        sicmedCureCheckDao.update(sicmedCureCheck);
    }

    @Transactional(readOnly = false)
    public void customSave(SicmedCureCheck sicmedCureCheck) {
        SicmedCurePrice tempPrice = sicmedCurePriceService.get(sicmedCureCheck.getSicmedCurePrice());

        if (tempPrice == null) {
            // 先创建价格表信息 并且保存
            SicmedCurePrice curePrice = new SicmedCurePrice();
            curePrice.setPrice(sicmedCureCheck.getSicmedCurePrice().getPrice());
            curePrice.setSicmedCureCheck(sicmedCureCheck);
            sicmedCurePriceService.save(curePrice);
            sicmedCureCheck.setSicmedCurePrice(curePrice);
            super.save(sicmedCureCheck);

            curePrice.setSicmedCureCheck(sicmedCureCheck);
            sicmedCurePriceService.save(curePrice);
        } else {
            // 获得旧收费对象
            SicmedCurePrice tempCurePrice = new SicmedCurePrice();
            tempCurePrice = sicmedCurePriceService.get(sicmedCureCheck.getSicmedCurePrice().getId());
            tempCurePrice.setPriceCutoffDate(new Date());
            tempCurePrice.setDelFlag("1");
            sicmedCurePriceService.update(tempCurePrice);
            // 先创建价格表信息 并且保存
            SicmedCurePrice curePrice = new SicmedCurePrice();
            curePrice.setPrice(sicmedCureCheck.getSicmedCurePrice().getPrice());
            curePrice.setSicmedCureCheck(sicmedCureCheck);
            sicmedCurePriceService.save(curePrice);
            sicmedCureCheck.setSicmedCurePrice(curePrice);
            super.save(sicmedCureCheck);
        }
    }

    @Transactional(readOnly = false)
    public void delete(SicmedCureCheck sicmedCureCheck) {
        super.delete(sicmedCureCheck);
    }

    /*
     * 通过参数 给模型的不同属性赋值
     * */
    public SicmedCureCheck sicmedCureCheckDetail(String parameter) {

        SicmedCureCheck cureCheck = new SicmedCureCheck();

        // 如果是汉字 按照检查名称进行搜索
        if (AppParameterSimulation.askNamePY(parameter)) {
            // 如果是拼音
            cureCheck.setCureNamePY(parameter);
            // 在SicmedTwxrayCheck对应的数据库中进行查询
        } else if (AppParameterSimulation.askCode(parameter)) {
            // 如果是编号
            cureCheck.setCureCode(parameter);
        } else if (AppParameterSimulation.askName(parameter)) {
            // 假设该参数为检查名字 进行查询
            cureCheck.setCureName(parameter);
        }

        return cureCheck;
    }

    public List<SicmedCureCheck> findByVersion(SicmedCureCheck sicmedCureCheck) {
        // TODO Auto-generated method stub
        return sicmedCureCheckDao.findByVersion(sicmedCureCheck);
    }

}