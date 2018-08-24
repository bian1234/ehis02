package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedMedicalPriceDao;

/**
 * 药品价格信息Service
 *
 * @author 丁学志
 * @version 2016-07-12
 */
@Service
@Transactional(readOnly = true)
public class SicmedMedicalPriceService extends CrudService<SicmedMedicalPriceDao, SicmedMedicalPrice> {

    @Autowired
    private SicmedMedicalPriceDao sicmedMedicalPriceDao;


    @Override
    public SicmedMedicalPrice get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedMedicalPrice> findList(SicmedMedicalPrice sicmedMedicalPrice) {
        return super.findList(sicmedMedicalPrice);
    }

    @Override
    public Page<SicmedMedicalPrice> findPage(Page<SicmedMedicalPrice> page, SicmedMedicalPrice sicmedMedicalPrice) {
        return super.findPage(page, sicmedMedicalPrice);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedMedicalPrice sicmedMedicalPrice) {
        super.save(sicmedMedicalPrice);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedMedicalPrice sicmedMedicalPrice) {
        super.delete(sicmedMedicalPrice);
    }

    public SicmedMedicalPrice getMedicalPrice(SicmedMedicalPrice sicmedMedicalPrice) {
        return sicmedMedicalPriceDao.getMedicalPrice(sicmedMedicalPrice);
    }

/*	public SicmedMedicalPrice findAllPriceList(SicmedMedicalPrice medicalPrice){
		List<SicmedMedicalPrice> tempList = Lists.newArrayList();
		tempList = sicmedMedicalPriceDao.fingMedicalPrice(medicalPrice);
		//去价格表中第一个
		if(tempList.size()>0){
			
			for (int i = 0; i < tempList.size(); i++) {
				SicmedMedicalPrice tempMedicalPrice = new SicmedMedicalPrice();
				tempMedicalPrice = tempList.get(i);
				//将tempInspectPrice的启用时间转化为毫秒
				Date date=new Date();
				Long currentTime = date.getTime();
				Long insertTime = tempMedicalPrice.getPriceInsertDate().getTime();
				Long cutoTime = tempMedicalPrice.getPriceCutoffDate().getTime();
				//当前时间在启用时间和截止时间中间 就将这个
				if(currentTime>insertTime&&cutoTime>currentTime){
					medicalPrice = tempMedicalPrice;					
					return medicalPrice;
				}
				
			}
			
		}
		
		return medicalPrice;
	}*/

    public Page<SicmedMedicalPrice> findAllPricePage(Page<SicmedMedicalPrice> page, SicmedMedicalPrice sicmedMedicalPrice) {
		/*Page<SicmedMedicalPrice> tempPage = sicmedMedicalPrice.setPage(page);
		page.setList(sicmedMedicalPriceDao.findAllPriceList(sicmedMedicalPrice));
		return tempPage;*/
        return super.findPageLike(page, sicmedMedicalPrice);
    }

    @Transactional(readOnly = false)
    public void update(SicmedMedicalPrice sicmedMedicalPrice) {
        sicmedMedicalPriceDao.update(sicmedMedicalPrice);
    }

    public List<SicmedMedicalPrice> findByVersion(SicmedMedicalPrice sicmedMedicalPrice) {
        // TODO Auto-generated method stub
        return sicmedMedicalPriceDao.findByVersion(sicmedMedicalPrice);
    }

}