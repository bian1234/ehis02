package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedRegisteredTypeDao;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegisteredPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegisteredType;

/**
 * 挂号类别Service
 *
 * @author XUE
 * @version 2016-09-06
 */
@Service
@Transactional(readOnly = true)
public class SicmedRegisteredTypeService extends CrudService<SicmedRegisteredTypeDao, SicmedRegisteredType> {

    //@Autowired
    //private SicmedRegisteredTypeService sicmedRegisteredTypeService;
//	
    @Autowired
    private SicmedRegisteredPriceService sicmedRegisteredPriceService;
    @Autowired
    private SicmedRegisteredTypeDao sicmedRegisteredTypeDao;

    @Override
    public SicmedRegisteredType get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedRegisteredType> findList(SicmedRegisteredType sicmedRegisteredType) {
        return super.findList(sicmedRegisteredType);
    }

    @Override
    public Page<SicmedRegisteredType> findPage(Page<SicmedRegisteredType> page, SicmedRegisteredType sicmedRegisteredType) {
        return super.findPage(page, sicmedRegisteredType);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedRegisteredType sicmedRegisteredType) {
        super.save(sicmedRegisteredType);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedRegisteredType sicmedRegisteredType) {
        super.delete(sicmedRegisteredType);
    }

    @Transactional(readOnly = false)
    public void customSave(SicmedRegisteredType sicmedRegisteredType) {

        if (sicmedRegisteredType.getSicmedRegisteredPrice().getId() == null) { //增加新的类别信息
            sicmedRegisteredType.preInsert();    //给类别对象生成uuid
            sicmedRegisteredType.setIsNewRecord(true);
            sicmedRegisteredType.getSicmedRegisteredPrice().preInsert();//生成uuid
            sicmedRegisteredType.getSicmedRegisteredPrice().setIsNewRecord(true);//标识为新增数据
            this.save(sicmedRegisteredType);
            sicmedRegisteredType.getSicmedRegisteredPrice().setSicmedRegisteredType(sicmedRegisteredType);
            sicmedRegisteredPriceService.save(sicmedRegisteredType.getSicmedRegisteredPrice());
        } else {    //修改价格操作
            SicmedRegisteredPrice tempPrice = new SicmedRegisteredPrice();    //创建新的价格对象
            tempPrice.setMaterialFee(sicmedRegisteredType.getSicmedRegisteredPrice().getMaterialFee()); //给价格对象赋价格
            tempPrice.preInsert();//给价格对象生成uuid对象
            tempPrice.setIsNewRecord(true);
            tempPrice.setSicmedRegisteredType(sicmedRegisteredType);
            sicmedRegisteredPriceService.save(tempPrice); //保存价格对象
            sicmedRegisteredType.setSicmedRegisteredPrice(tempPrice); //类别对象重新关联价格对象
            this.save(sicmedRegisteredType); //保存类别对象
        }

    }

    //通过挂号科室查找挂号类型
    public List<SicmedRegisteredType> findList1(SicmedRegisteredType sicmedRegisteredType) {
        return sicmedRegisteredTypeDao.findList1(sicmedRegisteredType);
    }

    public List<SicmedRegisteredType> findList2(SicmedRegisteredType sicmedRegisteredType) {
        return sicmedRegisteredTypeDao.findList2(sicmedRegisteredType);
    }

    public List<SicmedRegisteredType> findByVersion(SicmedRegisteredType sicmedRegisteredType) {
        // TODO Auto-generated method stub
        return sicmedRegisteredTypeDao.findByVersion(sicmedRegisteredType);
    }

}