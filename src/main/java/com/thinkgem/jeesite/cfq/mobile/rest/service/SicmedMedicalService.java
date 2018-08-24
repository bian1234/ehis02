/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedical;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.MedicalParameter;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedMedicalDao;
/**
 * 药品详细信息Service
 *
 * @author 丁学志
 * @version 2016-07-12
 */
@Service
@Transactional(readOnly = true)
public class SicmedMedicalService extends CrudService<SicmedMedicalDao, SicmedMedical> {

    @Autowired
    private SicmedMedicalDao sicmedMedicalDao;
    @Autowired
    private SicmedMedicalPriceService sicmedMedicalPriceService;

    @Override
    public SicmedMedical get(String id) {
        return super.get(id);
    }


    /*
     * 通过SicmedMedical.name进行查询 entity必须包含chinese.name 或 englist.name
     *
     * */
    public List<SicmedMedical> getMedicalListWithName(SicmedMedical sicmedMedical) {

        //创建List用来接收SicmedMedicalList
        List<SicmedMedical> tempList = new ArrayList<SicmedMedical>();
        //在数据库中去除SicmedMedicalList列表
        tempList = sicmedMedicalDao.getMeicalListWithMedical(sicmedMedical);

        return tempList;
    }

	/*
	 * 搜索接口
	 * */

    public List<SicmedMedical> searchMedical(String customParameter) {

        // 创建List 接收返回的SicmedMedical列表 列表中并不包含price entity数据
        List<SicmedMedical> tempList = new ArrayList<SicmedMedical>();

        if (MedicalParameter.DetectionParameter(customParameter)) {
            // 通过药品ID获取药品信息对象
            SicmedMedical sicmedMedical = new SicmedMedical();
            sicmedMedical = this.sicmedMedicalDetai(customParameter);
            if (sicmedMedical == null) {
                return null;
            }

            tempList = this.getMedicalListWithName(sicmedMedical);

            // 判断 tempList长度 如果长度为1
            if (tempList.size() == 0 || tempList == null) {
                // 创建MedicalBean对象
                return null;

            } else {
                return tempList;
            }
        } else {
            return null;
        }
    }

    /*
     * 根据参数 给Entity的不同属性赋值
     * */
    public SicmedMedical sicmedMedicalDetai(String customParameter) {
        SicmedMedical sicmedMedical = new SicmedMedical();
        Integer medicalType = 3;

        if (AppParameterSimulation.askNamePY(customParameter)) {
            medicalType = 2;
        } else if (AppParameterSimulation.askName(customParameter)) {
            medicalType = 1;
        } else if (AppParameterSimulation.askCode(customParameter)) {
            medicalType = 0;
        } else {
            return null;
        }

        switch (medicalType) {

            case 0:
                sicmedMedical.setMedicalCode(customParameter);
                break;

            case 1:
                sicmedMedical.setMedicalNameChina(customParameter);
                break;

            case 2:
                sicmedMedical.setMedicalNameEnglish(customParameter);
                break;
            default:
                sicmedMedical = null;
        }
        return sicmedMedical;
    }

    @Override
    public List<SicmedMedical> findList(SicmedMedical sicmedMedical) {
        return super.findList(sicmedMedical);
    }

    /**
     * 模糊查询药品 接口
     *
     * @param sicmedMedical
     * @return List<SicmedMedical>
     * @author Max
     */
    public List<SicmedMedical> findListLike(SicmedMedical sicmedMedical) {
        return sicmedMedicalDao.findListLike(sicmedMedical);
    }

    @Override
    @Transactional(readOnly = false)
    public Page<SicmedMedical> findPage(Page<SicmedMedical> page, SicmedMedical sicmedMedical) {
        Page<SicmedMedical> tempPage = new Page<SicmedMedical>();
        tempPage = super.findPage(page, sicmedMedical);
        return tempPage;
    }

    /**
     * 模糊查询带分页
     *
     * @param sicmedMedical
     * @author XUE
     */

    @Override
    public Page<SicmedMedical> findPageLike(Page<SicmedMedical> page, SicmedMedical sicmedMedical) {
        return super.findPageLike(page, sicmedMedical);

    }

    @Transactional(readOnly = false)
    public void customSave(SicmedMedical sicmedMedical) {

        //先判断这个药品对象是否存在
        SicmedMedical tempMedical = this.get(sicmedMedical);
        //如果这个对象为空
        if (tempMedical == null) {
            //创建药品价格对象
            SicmedMedicalPrice medicalPrice = new SicmedMedicalPrice();
            medicalPrice.setPriceSale(sicmedMedical.getMedicalPrice().getPriceSale());
            medicalPrice.setPriceEnter(sicmedMedical.getMedicalPrice().getPriceEnter());
            medicalPrice.setSicmedMedical(sicmedMedical);
            sicmedMedical.setMedicalPrice(medicalPrice);
            sicmedMedicalPriceService.save(medicalPrice);
            super.save(sicmedMedical);
            //通过sicmedMeidcal 的ID找到这个价格对象
            medicalPrice = sicmedMedicalPriceService.get(sicmedMedical.getMedicalPrice());
            medicalPrice.setSicmedMedical(sicmedMedical);
            sicmedMedicalPriceService.save(medicalPrice);

        } else {

            SicmedMedicalPrice tempMedicalPrice = new SicmedMedicalPrice();
            tempMedicalPrice = sicmedMedicalPriceService.get(sicmedMedical.getMedicalPrice().getId());
            tempMedicalPrice.setDelFlag("1");
            tempMedicalPrice.setPriceCutoffDate(new Date());
            sicmedMedicalPriceService.update(tempMedicalPrice);
            // 创建药品价格对象
            SicmedMedicalPrice medicalPrice = new SicmedMedicalPrice();
            medicalPrice.setPriceSale(sicmedMedical.getMedicalPrice().getPriceSale());
            medicalPrice.setPriceEnter(sicmedMedical.getMedicalPrice().getPriceEnter());
            medicalPrice.setSicmedMedical(sicmedMedical);
            sicmedMedicalPriceService.save(medicalPrice);
            sicmedMedical.setMedicalPrice(medicalPrice);
            super.save(sicmedMedical);
        }
    }

    //
//	@Transactional(readOnly = false)
//	public void delete(SicmedMedical sicmedMedical) {
//		super.delete(sicmedMedical);
//	}
    public List<SicmedMedical> getAll() {
        return sicmedMedicalDao.getAll();
    }

    @Transactional(readOnly = false)
    public void update(SicmedMedical sicmedMedical) {
        sicmedMedicalDao.update(sicmedMedical);
    }


    public List<SicmedMedical> findByVersion(SicmedMedical sicmedMedical) {

        return sicmedMedicalDao.findByVersion(sicmedMedical);
    }

}