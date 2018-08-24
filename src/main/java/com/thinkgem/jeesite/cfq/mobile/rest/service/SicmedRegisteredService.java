package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegistered;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedRegisteredDao;

/**
 * 挂号信息表Service
 *
 * @author Max
 * @version 2016-07-12
 */
@Service
@Transactional(readOnly = true)
public class SicmedRegisteredService extends CrudService<SicmedRegisteredDao, SicmedRegistered> {

    @Autowired
    private SicmedRegisteredDao sicmedRegisteredDao;

    @Override
    public SicmedRegistered get(String id) {
        return super.get(id);
    }

    public SicmedRegistered getByP(SicmedRegistered sicmedRegistered) {
        return sicmedRegisteredDao.getByP(sicmedRegistered);
    }


    public Page<SicmedRegistered> findRegistered(Page<SicmedRegistered> page, SicmedRegistered registered) {
        //生成数据权限过滤条件
        registered.getSqlMap().put("dsf", dataScopeFilter(registered.getCurrentUser(), "o", "a"));
        //设置分页参数
        registered.setPage(page);
        //执行分页查询
        page.setList(sicmedRegisteredDao.findList(registered));
        return page;

    }

    @Override
    public List<SicmedRegistered> findList(SicmedRegistered sicmedRegistered) {
        return super.findList(sicmedRegistered);
    }

    @Override
    public Page<SicmedRegistered> findPage(Page<SicmedRegistered> page, SicmedRegistered sicmedRegistered) {
        return super.findPage(page, sicmedRegistered);
    }

    @Override
    //模糊查询带分页web
    public Page<SicmedRegistered> findPageLike(Page<SicmedRegistered> page, SicmedRegistered sicmedRegistered) {
        return super.findPageLike(page, sicmedRegistered);
    }

    public Page<SicmedRegistered> findPage1(Page<SicmedRegistered> page, SicmedRegistered sicmedRegistered) {
        return super.findPage(page, sicmedRegistered);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedRegistered sicmedRegistered) {
        super.save(sicmedRegistered);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedRegistered sicmedRegistered) {
        super.delete(sicmedRegistered);
    }

    @Transactional(readOnly = false)
    public void update(SicmedRegistered sicmedRegistered) {
        sicmedRegisteredDao.update(sicmedRegistered);
    }

    //复制数据表 表结构和表中数据 复制 清空原表
    @Transactional(readOnly = false)
    public void clearTable(String copyName) {
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        sicmedRegistered.setCopyTableName(copyName);
        sicmedRegisteredDao.copyTable(sicmedRegistered);
        sicmedRegisteredDao.insertTable(sicmedRegistered);
        sicmedRegisteredDao.clearTable();
    }

    public SicmedRegistered getByEntity(SicmedRegistered sicmedRegistered) {
        // TODO Auto-generated method stub
        return sicmedRegisteredDao.getByEntity(sicmedRegistered);
    }

    public List<SicmedRegistered> findByDAndB(SicmedRegistered sicmedRegistered) {
        // TODO Auto-generated method stub
        return sicmedRegisteredDao.findByDAndB(sicmedRegistered);
    }

    public List<SicmedRegistered> findRefuntOrChange(SicmedRegistered sicmedRegistered) {
        // TODO Auto-generated method stub
        return sicmedRegisteredDao.findRefuntOrChange(sicmedRegistered);
    }

    public List<SicmedRegistered> findHistoryListByUpdateUser(SicmedRegistered sicmedRegistered) {
        // TODO Auto-generated method stub
        return sicmedRegisteredDao.findHistoryListByUpdateUser(sicmedRegistered);
    }

    public List<SicmedRegistered> findHistoryListByCreateUser(SicmedRegistered sicmedRegistered) {
        // TODO Auto-generated method stub
        return sicmedRegisteredDao.findHistoryListByCreateUser(sicmedRegistered);
    }

    public List<SicmedRegistered> findByParamAndD(SicmedRegistered sicmedRegistered) {
        // TODO Auto-generated method stub
        return sicmedRegisteredDao.findByParamAndD(sicmedRegistered);
    }

    public List<SicmedRegistered> findHistoryListByDeleteUser(SicmedRegistered sicmedRegistered) {
        // TODO Auto-generated method stub
        return sicmedRegisteredDao.findHistoryListByDeleteUser(sicmedRegistered);
    }

	/*//查询当天挂号
	public Page<SicmedRegistered> findToday(Page<SicmedRegistered> page, SicmedRegistered sicmedRegistered) {
		return super.findToday(page, sicmedRegistered);
	}
	*/

}