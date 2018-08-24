/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCurePrice;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedCurePriceDao;

/**
 * RESTful接口示例Service
 *
 * @author DING
 * @version 2016-07-22
 */
@Service
@Transactional(readOnly = true)
public class SicmedCurePriceService extends CrudService<SicmedCurePriceDao, SicmedCurePrice> {

    @Autowired
    private SicmedCurePriceDao sicmedCurePriceDao;

    @Override
    public SicmedCurePrice get(String id) {
        return super.get(id);
    }

    public SicmedCurePrice findCurePriceList(SicmedCurePrice sicmedCurePrice) {

        List<SicmedCurePrice> tempList = Lists.newArrayList();
        tempList = sicmedCurePriceDao.fingCurePrice(sicmedCurePrice);
        //去价格表中第一个
        if (tempList.size() > 0) {
            sicmedCurePrice = tempList.get(0);
//			return sicmedCheckPrice;
        }
        return sicmedCurePrice;
    }

    @Override
    public List<SicmedCurePrice> findList(SicmedCurePrice sicmedCurePrice) {
        return super.findList(sicmedCurePrice);
    }

    @Override
    public Page<SicmedCurePrice> findPage(Page<SicmedCurePrice> page, SicmedCurePrice sicmedCurePrice) {
        return super.findPage(page, sicmedCurePrice);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedCurePrice sicmedCurePrice) {
        super.save(sicmedCurePrice);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedCurePrice sicmedCurePrice) {
        super.delete(sicmedCurePrice);
    }

    public SicmedCurePrice getByEntity(SicmedCurePrice sicmedCurePrice) {
        return sicmedCurePriceDao.getByEntity(sicmedCurePrice);
    }

    @Transactional(readOnly = false)
    public void update(SicmedCurePrice sicmedCurePrice) {
        sicmedCurePriceDao.update(sicmedCurePrice);
    }

    public Page<SicmedCurePrice> findAllPricePage(Page<SicmedCurePrice> page, SicmedCurePrice sicmedCurePrice) {
    /*	Page<SicmedCurePrice> tempPage = sicmedCurePrice.setPage(page);
		page.setList(sicmedCurePriceDao.findAllPriceList(sicmedCurePrice));
		return tempPage;*/
        return super.findPageLike(page, sicmedCurePrice);
    }

    public List<SicmedCurePrice> findByVersion(SicmedCurePrice sicmedCurePrice) {
        // TODO Auto-generated method stub
        return sicmedCurePriceDao.findByVersion(sicmedCurePrice);
    }

}