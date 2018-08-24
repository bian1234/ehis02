/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCheckPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedCheckPriceDao;

/**
 * RESTful接口示例Service
 *
 * @author DING
 * @version 2016-07-22
 */
@Service
@Transactional(readOnly = true)
public class SicmedCheckPriceService extends CrudService<SicmedCheckPriceDao, SicmedCheckPrice> {

    @Autowired
    private SicmedCheckPriceDao checkPriceDao;


    @Override
    public SicmedCheckPrice get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedCheckPrice> findList(SicmedCheckPrice sicmedCheckPrice) {
        return super.findList(sicmedCheckPrice);
    }

    public SicmedCheckPrice findCheckPriceList(SicmedCheckPrice sicmedCheckPrice) {
        List<SicmedCheckPrice> tempList = Lists.newArrayList();
        tempList = checkPriceDao.findCheckPrice(sicmedCheckPrice);
        //去价格表中第一个
        if (tempList.size() > 0) {
            //sicmedCheckPrice = tempList.get(0);
            for (int i = 0; i < tempList.size(); i++) {
                SicmedCheckPrice tempCheckPrice = new SicmedCheckPrice();
                tempCheckPrice = tempList.get(i);
                //将tempInspectPrice的启用时间转化为毫秒
                Date date = new Date();
                Long currentTime = date.getTime();
                Long insertTime = tempCheckPrice.getCheckPriceInsertDate().getTime();
                Long cutoTime = tempCheckPrice.getCheckPriceCutoffDate().getTime();
                //当前时间在启用时间和截止时间中间 就将这个
                if (currentTime > insertTime && cutoTime > currentTime) {
                    sicmedCheckPrice = tempCheckPrice;
                    return sicmedCheckPrice;
                }

            }
        }
        return sicmedCheckPrice;
    }


    @Override
    public Page<SicmedCheckPrice> findPage(Page<SicmedCheckPrice> page, SicmedCheckPrice sicmedCheckPrice) {
        return super.findPage(page, sicmedCheckPrice);
    }

    @Transactional(readOnly = false)
    public void save(SicmedCheckPrice sicmedCheckPrice) {
        super.save(sicmedCheckPrice);
    }

    @Transactional(readOnly = false)
    public void delete(SicmedCheckPrice sicmedCheckPrice) {
        super.delete(sicmedCheckPrice);
    }

    public SicmedCheckPrice getByEntity(SicmedCheckPrice sicmedCheckPrice) {
        return checkPriceDao.getByEntity(sicmedCheckPrice);
    }

    @Transactional(readOnly = false)
    public void update(SicmedCheckPrice sicmedCheckPrice) {
        checkPriceDao.update(sicmedCheckPrice);
    }

    //查询所有的价格信息 包括del=0的信息
    public Page<SicmedCheckPrice> findAllPricePage(Page<SicmedCheckPrice> page, SicmedCheckPrice sicmedCheckPrice) {
        Page<SicmedCheckPrice> tempPage = sicmedCheckPrice.setPage(page);
        tempPage.setList(checkPriceDao.findAllPriceList(sicmedCheckPrice));
        return tempPage;
    }

    public List<SicmedCheckPrice> findByVersion(SicmedCheckPrice sicmedCheckPrice) {
        // TODO Auto-generated method stub
        return checkPriceDao.findByVersion(sicmedCheckPrice);
    }

}