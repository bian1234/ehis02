package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspectPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedInspectPriceDao;

/**
 * RESTful接口示例Service
 *
 * @author DING
 * @version 2016-07-22
 */
@Service
@Transactional(readOnly = true)
public class SicmedInspectPriceService extends CrudService<SicmedInspectPriceDao, SicmedInspectPrice> {

    @Autowired
    private SicmedInspectPriceDao sicmedInspectPriceDao;

    @Override
    public SicmedInspectPrice get(String id) {
        return super.get(id);
    }

    public SicmedInspectPrice findInspectPriceList(SicmedInspectPrice sicmedInspectPrice) {
        return sicmedInspectPrice;
    }

    @Override
    public List<SicmedInspectPrice> findList(SicmedInspectPrice sicmedInspectPrice) {
        return super.findList(sicmedInspectPrice);
    }

    @Override
    public Page<SicmedInspectPrice> findPage(Page<SicmedInspectPrice> page, SicmedInspectPrice sicmedInspectPrice) {
        return super.findPage(page, sicmedInspectPrice);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedInspectPrice sicmedInspectPrice) {
        super.save(sicmedInspectPrice);
    }

    @Transactional(readOnly = false)
    public int update(SicmedInspectPrice sicmedInspectPrice) {
        //sicmedInspectPriceDao.updata(sicmedInspectPrice);
        return sicmedInspectPriceDao.update(sicmedInspectPrice);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedInspectPrice sicmedInspectPrice) {
        super.delete(sicmedInspectPrice);
    }

    public SicmedInspectPrice getByEntity(SicmedInspectPrice sicmedInspectPrice) {
        return sicmedInspectPriceDao.getByEntity(sicmedInspectPrice);
    }

    public Page<SicmedInspectPrice> findAllPricePage(Page<SicmedInspectPrice> page, SicmedInspectPrice sicmedInspectPrice) {
        /*Page<SicmedInspectPrice> tempPage =  sicmedInspectPrice.setPage(page);
		page.setList(sicmedInspectPriceDao.findAllPricePage(sicmedInspectPrice));
		return tempPage;*/
        return super.findPageLike(page, sicmedInspectPrice);
    }

    public List<SicmedInspectPrice> findByVersion(SicmedInspectPrice sicmedInspectPrice) {
        // TODO Auto-generated method stub
        return sicmedInspectPriceDao.findByVersion(sicmedInspectPrice);
    }
}