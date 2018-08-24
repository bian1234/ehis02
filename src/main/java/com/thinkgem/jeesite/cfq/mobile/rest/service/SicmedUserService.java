package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedUser;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedUserDao;

/**
 * 用户信息表Service
 *
 * @author Max
 * @version 2016-07-12
 */
@Service
@Transactional(readOnly = true)
public class SicmedUserService extends CrudService<SicmedUserDao, SicmedUser> {

    @Autowired
    private SicmedUserDao sicmedUserDao;

    @Override
    public SicmedUser get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedUser> findList(SicmedUser sicmedUser) {

        return super.findList(sicmedUser);
    }

    @Override
    public Page<SicmedUser> findPage(Page<SicmedUser> page, SicmedUser sicmedUser) {
        if (sicmedUser.getUserJobGroup() != null) {
            if (sicmedUser.getUserJobGroup().equals("挂号")) {
                sicmedUser.setUserJobGroup("0");
            } else if (sicmedUser.getUserJobGroup().equals("医生")) {
                sicmedUser.setUserJobGroup("1");
            } else if (sicmedUser.getUserJobGroup().equals("收费")) {
                sicmedUser.setUserJobGroup("2");
            }
        }
        return super.findPage(page, sicmedUser);
    }

    @Override
    //模糊查询带分页
    public Page<SicmedUser> findPageLike(Page<SicmedUser> page, SicmedUser sicmedUser) {
        if (sicmedUser.getUserJobGroup() != null) {
            if (sicmedUser.getUserJobGroup().equals("挂号")) {
                sicmedUser.setUserJobGroup("0");
            } else if (sicmedUser.getUserJobGroup().equals("医生")) {
                sicmedUser.setUserJobGroup("1");
            } else if (sicmedUser.getUserJobGroup().equals("收费")) {
                sicmedUser.setUserJobGroup("2");
            }
        }
        return super.findPageLike(page, sicmedUser);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedUser sicmedUser) {
        super.save(sicmedUser);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedUser sicmedUser) {
        super.delete(sicmedUser);
    }

    public SicmedUser getByTel(String userTel) {
        return sicmedUserDao.getByTel(userTel);
    }

    @Transactional(readOnly = false)
    public void update(SicmedUser sicmedUser) {
        sicmedUserDao.update(sicmedUser);
    }

    public List<SicmedUser> findByBranch(SicmedUser sicmedUser) {
        return sicmedUserDao.findByBranch(sicmedUser);
    }

    public List<SicmedUser> findByDept(SicmedUser sicmedUser) {
        return sicmedUserDao.findByDept(sicmedUser);
    }

    public SicmedUser getById(String str) {
        return sicmedUserDao.getById(str);
    }


    public List<SicmedUser> findList1(SicmedUser sicmedUser) {
        return sicmedUserDao.findList1(sicmedUser);
    }

    public SicmedUser login(SicmedUser sicmedUser) {
        // TODO Auto-generated method stub
        return sicmedUserDao.login(sicmedUser);
    }

    public List<SicmedUser> findDoctorByTypeAndBranch(SicmedUser sicmedUser) {
        // TODO Auto-generated method stub
        return sicmedUserDao.findDoctorByTypeAndBranch(sicmedUser);
    }

    public List<SicmedUser> findByVersion(SicmedUser sicmedUser) {
        // TODO Auto-generated method stub
        return sicmedUserDao.findByVersion(sicmedUser);
    }

}