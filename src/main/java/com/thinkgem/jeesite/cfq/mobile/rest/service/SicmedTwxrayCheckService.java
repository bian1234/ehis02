package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.Date;
import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCheckPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedTwxrayCheck;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedTwxrayCheckDao;

/**
 * RESTful接口示例Service
 *
 * @author DING
 * @version 2016-07-22
 */
@Service
@Transactional(readOnly = true)
public class SicmedTwxrayCheckService extends CrudService<SicmedTwxrayCheckDao, SicmedTwxrayCheck> {

    @Autowired
    private SicmedTwxrayCheckDao sicmedTwxrayCheckDao;

    @Autowired
    private SicmedCheckPriceService sicmedCheckPriceService;

    @Override
    public SicmedTwxrayCheck get(String id) {
        return super.get(id);
    }

    /*
     * 通过检查编号找到检查信息
     * */
    public SicmedTwxrayCheck getTwxrayCheck(SicmedTwxrayCheck sicmedTwxrayCheck) {
        SicmedTwxrayCheck sicmedTwxrayCheck1 = new SicmedTwxrayCheck();
        sicmedTwxrayCheck1 = sicmedTwxrayCheckDao.getTwxrayCheck(sicmedTwxrayCheck);
        return sicmedTwxrayCheck1;
    }

    @Override
    public List<SicmedTwxrayCheck> findList(SicmedTwxrayCheck sicmedTwxrayCheck) {
        return super.findList(sicmedTwxrayCheck);
    }

    /**
     * 模糊查询检查项目
     *
     * @param sicmedTwxrayCheck
     * @return List<SicmedTwxrayCheck>
     */
    public List<SicmedTwxrayCheck> findListLike(SicmedTwxrayCheck sicmedTwxrayCheck) {
        return sicmedTwxrayCheckDao.findListLike(sicmedTwxrayCheck);
    }

    @Override
    public Page<SicmedTwxrayCheck> findPage(Page<SicmedTwxrayCheck> page, SicmedTwxrayCheck sicmedTwxrayCheck) {
        return super.findPage(page, sicmedTwxrayCheck);
    }

    @Transactional(readOnly = false)
    public void customSave(SicmedTwxrayCheck sicmedTwxrayCheck) {
        //判断药品对象是否存在
        SicmedCheckPrice tempCheckPrice = sicmedCheckPriceService.get(sicmedTwxrayCheck.getSicmedCheckPrice());
        if (tempCheckPrice == null) {
            //先创建价格表信息 并且保存
            SicmedCheckPrice checkPrice = new SicmedCheckPrice();
            checkPrice.setCheckPrice(sicmedTwxrayCheck.getSicmedCheckPrice().getCheckPrice());
            //sicmedTwxrayCheck 对象是没有id的
            checkPrice.setSicmedTwxrayCheck(sicmedTwxrayCheck);
            sicmedCheckPriceService.save(checkPrice);
            sicmedTwxrayCheck.setSicmedCheckPrice(checkPrice);
            super.save(sicmedTwxrayCheck);
            //sicmedTwxrayCheck 有ID
            checkPrice.setSicmedTwxrayCheck(sicmedTwxrayCheck);
            sicmedCheckPriceService.save(checkPrice);
        } else {

            // 记录旧的价格对象
            SicmedCheckPrice oldCheckPrice = new SicmedCheckPrice();
            oldCheckPrice = sicmedCheckPriceService.get(sicmedTwxrayCheck.getSicmedCheckPrice().getId());
            oldCheckPrice.setCheckPriceCutoffDate(new Date());
            oldCheckPrice.setDelFlag("1");
            sicmedCheckPriceService.update(oldCheckPrice);
            // 先创建价格表信息 并且保存
            SicmedCheckPrice checkPrice = new SicmedCheckPrice();
            checkPrice.setCheckPrice(sicmedTwxrayCheck.getSicmedCheckPrice().getCheckPrice());
            checkPrice.setSicmedTwxrayCheck(sicmedTwxrayCheck);
            sicmedCheckPriceService.save(checkPrice);
            sicmedTwxrayCheck.setSicmedCheckPrice(checkPrice);
            super.save(sicmedTwxrayCheck);
        }

    }

    @Transactional(readOnly = false)
    public void update(SicmedTwxrayCheck sicmedTwxrayCheck) {
        sicmedTwxrayCheckDao.update(sicmedTwxrayCheck);
    }

    @Transactional(readOnly = false)
    public void delete(SicmedTwxrayCheck sicmedTwxrayCheck) {
        super.delete(sicmedTwxrayCheck);
    }

    /*
     * 通过参数 给模型的不同属性赋值
     * */
    public SicmedTwxrayCheck sicmedTwxrayCheckDetail(String parameter) {

        SicmedTwxrayCheck twxrayCheck = new SicmedTwxrayCheck();

        // 如果是汉字 按照检查名称进行搜索
        if (AppParameterSimulation.askNamePY(parameter)) {
            // 如果是拼音
            twxrayCheck.setCheckNamePY(parameter);
            // 在SicmedTwxrayCheck对应的数据库中进行查询
        } else if (AppParameterSimulation.askCode(parameter)) {
            // 如果是编号
            twxrayCheck.setCheckCode(parameter);
        } else if (AppParameterSimulation.askName(parameter)) {
            // 假设该参数为检查名字 进行查询
            twxrayCheck.setCheckName(parameter);
        }

        return twxrayCheck;
    }

    public List<SicmedTwxrayCheck> findByVersion(SicmedTwxrayCheck sicmedTwxrayCheck) {
        // TODO Auto-generated method stub
        return sicmedTwxrayCheckDao.findByVersion(sicmedTwxrayCheck);
    }

}