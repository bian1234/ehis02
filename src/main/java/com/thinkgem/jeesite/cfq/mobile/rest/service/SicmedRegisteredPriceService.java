package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedRegisteredPriceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegisteredPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedRegisteredPriceDao;

/**
 * 挂号价格Service
 *
 * @author XUE
 * @version 2016-09-06
 */
@Service
@Transactional(readOnly = true)
public class SicmedRegisteredPriceService extends CrudService<SicmedRegisteredPriceDao, SicmedRegisteredPrice> {

    @Autowired
    private SicmedRegisteredPriceDao sicmedRegisteredPriceDao;

    @Override
    public SicmedRegisteredPrice get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedRegisteredPrice> findList(SicmedRegisteredPrice sicmedRegisteredPrice) {
        return super.findList(sicmedRegisteredPrice);
    }

    @Override
    public Page<SicmedRegisteredPrice> findPage(Page<SicmedRegisteredPrice> page, SicmedRegisteredPrice sicmedRegisteredPrice) {
        return super.findPage(page, sicmedRegisteredPrice);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedRegisteredPrice sicmedRegisteredPrice) {
        super.save(sicmedRegisteredPrice);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedRegisteredPrice sicmedRegisteredPrice) {
        super.delete(sicmedRegisteredPrice);
    }

    public List<SicmedRegisteredPrice> findByVersion(SicmedRegisteredPrice sicmedRegisteredPrice) {
        // TODO Auto-generated method stub
        return sicmedRegisteredPriceDao.findByVersion(sicmedRegisteredPrice);
    }

}