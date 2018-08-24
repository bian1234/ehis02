/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.Date;
import java.util.List;


import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspect;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspectPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedInspectDao;

/**
 * RESTful接口示例Service
 *
 * @author DING
 * @version 2016-07-22
 */
@Service
@Transactional(readOnly = true)
public class SicmedInspectService extends CrudService<SicmedInspectDao, SicmedInspect> {

    @Autowired
    private SicmedInspectDao sicmedInspectDao;

    @Autowired
    private SicmedInspectPriceService sicmedInspectPriceService;

    @Override
    public SicmedInspect get(String id) {
        return super.get(id);
    }

    public SicmedInspect getInspect(SicmedInspect sicmedInspect) {
        SicmedInspect sicmedInspect1 = new SicmedInspect();
        sicmedInspect1 = sicmedInspectDao.getInspect(sicmedInspect);
        return sicmedInspect1;
    }

    @Override
    public List<SicmedInspect> findList(SicmedInspect sicmedInspect) {
        return super.findList(sicmedInspect);
    }

    /**
     * 模糊查询检验项目 接口实现
     *
     * @param sicmedInspect
     * @return List<SicmedInspect>
     * @author Max
     */

    public List<SicmedInspect> findListLike(SicmedInspect sicmedInspect) {
        return sicmedInspectDao.findListLike(sicmedInspect);
    }

    @Override
    @Transactional(readOnly = false)
    public Page<SicmedInspect> findPage(Page<SicmedInspect> page, SicmedInspect sicmedInspect) {
        return super.findPage(page, sicmedInspect);
    }

    @Override
    //模糊查询带分页
    public Page<SicmedInspect> findPageLike(Page<SicmedInspect> page, SicmedInspect sicmedInspect) {
        return super.findPageLike(page, sicmedInspect);
    }

    @Transactional(readOnly = false)
    public void customSave(SicmedInspect sicmedInspect) {
        SicmedInspectPrice tempInspectPrice = sicmedInspectPriceService.get(sicmedInspect.getSicmedInspectPrice());
        if (tempInspectPrice == null) {
            // 先创建价格表信息 并且保存
            SicmedInspectPrice inspectPrice = new SicmedInspectPrice();
            inspectPrice.setPrice(sicmedInspect.getSicmedInspectPrice().getPrice());
            inspectPrice.setSicmedInspect(sicmedInspect);
            sicmedInspect.setSicmedInspectPrice(inspectPrice);
            sicmedInspectPriceService.save(inspectPrice);
            super.save(sicmedInspect);
            inspectPrice.setSicmedInspect(sicmedInspect);
            sicmedInspectPriceService.save(inspectPrice);
        } else {
            // 先得到先前的价格对象
            SicmedInspectPrice oldInspectPrice = new SicmedInspectPrice();
            oldInspectPrice = sicmedInspectPriceService.get(sicmedInspect.getSicmedInspectPrice().getId());
            oldInspectPrice.setPriceCutoffDate(new Date());
            oldInspectPrice.setDelFlag("1");
            sicmedInspectPriceService.update(oldInspectPrice);
            // 先创建价格表信息 并且保存
            SicmedInspectPrice inspectPrice = new SicmedInspectPrice();
            inspectPrice.setPrice(sicmedInspect.getSicmedInspectPrice().getPrice());
            inspectPrice.setSicmedInspect(sicmedInspect);
            // sicmedInspect.getSicmedInspectPrice().setId(inspectPrice.getId());
            sicmedInspect.setSicmedInspectPrice(inspectPrice);
            sicmedInspectPriceService.save(inspectPrice);
            super.save(sicmedInspect);
        }
    }

    @Transactional(readOnly = false)
    public void update(SicmedInspect sicmedInspect) {
        sicmedInspectDao.update(sicmedInspect);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedInspect sicmedInspect) {
        super.delete(sicmedInspect);
    }

    /*
     * 通过参数 给模型的不同属性赋值
     * */
    public SicmedInspect sicmedInspectDetail(String parameter) {

        SicmedInspect inspect = new SicmedInspect();

        if (AppParameterSimulation.askNamePY(parameter)) {
            //如果是拼音
            inspect.setInspectNamePY(parameter);
            //在SicmedTwxrayCheck对应的数据库中进行查询
        } else if (AppParameterSimulation.askCode(parameter)) {
            //如果是编号
            //inspect.setInspectCode(parameter);
        } else if (AppParameterSimulation.askName(parameter)) {
            //假设该参数为检查名字 进行查询
            inspect.setInspectName(parameter);
        }

        return inspect;
    }

    public List<SicmedInspect> findByVersion(SicmedInspect sicmedInspect) {
        // TODO Auto-generated method stub
        return sicmedInspectDao.findByVersion(sicmedInspect);
    }

}