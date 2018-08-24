package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCheckPriceBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCheckPriceBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCureCheckBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCureCheckBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCureClassBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCureClassBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCurePriceBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCurePriceBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedDiseaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedDiseaseBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedDiseaseClassBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedDiseaseClassBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedInspectBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedInspectBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedInspectClassBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedInspectClassBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedInspectPriceBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedInspectPriceBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalClassBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalClassBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalPriceBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalPriceBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedRegisteredPriceBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedRegisteredPriceBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedRegisteredTypeBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedRegisteredTypeBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedStanderprescriptionAskedBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedStanderprescriptionAskedBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedStanderprescriptionDiseaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedStanderprescriptionDiseaseBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedTwxrayCheckBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedTwxrayCheckBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedTwxrayClassBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedTwxrayClassBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedUserBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedUserBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCheckPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCureCheck;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCureClass;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCurePrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDisease;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDiseaseClass;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspect;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspectClass;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspectPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedical;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalClass;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegisteredPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegisteredType;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStanderprescriptionAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStanderprescriptionDisease;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedTwxrayCheck;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedTwxrayClass;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedUser;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.Sno;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCheckPriceService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCureCheckService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCureClassService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCurePriceService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedDiseaseClassService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedDiseaseService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedInspectClassService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedInspectPriceService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedInspectService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedMedicalClassService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedMedicalPriceService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedMedicalService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedRegisteredPriceService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedRegisteredTypeService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedStanderprescriptionAskedService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedStanderprescriptionDiseaseService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedTwxrayCheckService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedTwxrayClassService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedUserService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SnoService;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;

/**
 * @author Max
 * @version 2016-09-20
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/dateUpdate")
public class SicmedDateUpdateController extends BaseController {

    private static int PAGE_SIZE = 1000;

    @Autowired
    private SnoService snoService;

    @Autowired
    private SicmedUserService sicmedUserService;

    @Autowired
    private SicmedMedicalService sicmedMedicalService;

    @Autowired
    private SicmedMedicalClassService sicmedMedicalClassService;

    @Autowired
    private SicmedMedicalPriceService sicmedMedicalPriceService;

    @Autowired
    private SicmedTwxrayCheckService sicmedTwxrayCheckService;

    @Autowired
    private SicmedTwxrayClassService sicmedTwxrayCheckClassService;

    @Autowired
    private SicmedCheckPriceService sicmedTwxrayCheckPriceService;

    @Autowired
    private SicmedCureCheckService sicmedCureCheckService;

    @Autowired
    private SicmedCureClassService sicmedCureCheckClassService;

    @Autowired
    private SicmedCurePriceService sicmedCureCheckPriceService;

    @Autowired
    private SicmedInspectService sicmedInspectService;

    @Autowired
    private SicmedInspectClassService sicmedInspectClassService;

    @Autowired
    private SicmedInspectPriceService sicmedInspectPriceService;

    @Autowired
    private SicmedDiseaseService sicmedDiseaseService;

    @Autowired
    private SicmedDiseaseClassService sicmedDiseaseClassService;

    @Autowired
    private SicmedStanderprescriptionAskedService sicmedStanderprescriptionAskedService;

    @Autowired
    private SicmedStanderprescriptionDiseaseService sicmedStanderprescriptionDiseaseService;

    @Autowired
    private SicmedRegisteredTypeService sicmedRegisteredTypeService;

    @Autowired
    private SicmedRegisteredPriceService sicmedRegisteredPriceService;

    /**
     * 版本更新
     */
    @ResponseBody
    @RequestMapping(value = "updateVersion")
    public void updateVersion(String version, String pageNo) {

        int key = 0;
        switch (key) {
            case 0:
                break;
            default:
                break;
        }

    }

    /**
     * 更新药品信息
     *
     * @return
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "findMedcital")
    public BaseBean findMedcital(String version, String pageNo) {
        // 创建返回对象
        SicmedMedicalBeans sicmedMedicalBeans = new SicmedMedicalBeans();
        // 获取客户端传递的版本号 对应的更新日期
        Sno sno = new Sno();
        sno.setNumber(version);
        sno = snoService.get(sno);
        // 创建分页条件
        Page<SicmedMedical> page = new Page<SicmedMedical>();
        page.setPageSize(PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 创建查询条件
        SicmedMedical sicmedMedical = new SicmedMedical();
        // 查询条件赋值
        sicmedMedical.setUpdateDate(sno.getUpdateDate());
        sicmedMedical.setPage(page);
        // 调用service查询数据
        List<SicmedMedical> sicmedMedicales = sicmedMedicalService.findByVersion(sicmedMedical);
        // 查询结果分享分析
        if (sicmedMedicales.size() > 0) {
            // 遍历查询结果
            for (SicmedMedical sicmedMedical2 : sicmedMedicales) {
                SicmedMedicalBean sicmedMedicalBean = new SicmedMedicalBean();
                sicmedMedicalBean.setSMB(sicmedMedical2);
                // 返回对象赋值
                sicmedMedicalBeans.getSicmedMedicalBeans().add(sicmedMedicalBean);
            }
            sicmedMedicalBeans.setError("0");
            return sicmedMedicalBeans;
        } else {
            sicmedMedicalBeans.setError("1");
            return sicmedMedicalBeans;
        }
    }

    /*
     * 药品价格
     */
    @ResponseBody
    @RequestMapping(value = "findMedcitalClass")
    public BaseBean findMedcitalClass(String version, String pageNo) {
        // 创建返回对象
        SicmedMedicalClassBeans sicmedMedicalClassBeans = new SicmedMedicalClassBeans();
        // 获取客户端传递的版本号 对应的更新日期
        Sno sno = new Sno();
        sno.setNumber(version);
        sno = snoService.get(sno);
        // 创建分页条件
        Page<SicmedMedicalClass> page = new Page<SicmedMedicalClass>();
        page.setPageSize(PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 创建查询条件
        SicmedMedicalClass sicmedMedicalClass = new SicmedMedicalClass();
        // 查询条件赋值
        sicmedMedicalClass.setUpdateDate(sno.getUpdateDate());
        sicmedMedicalClass.setPage(page);
        // 调用service查询数据
        List<SicmedMedicalClass> sicmedMedicalClasses = sicmedMedicalClassService.findByVersion(sicmedMedicalClass);
        // 查询结果分享分析
        if (sicmedMedicalClasses.size() > 0) {
            // 遍历查询结果
            for (SicmedMedicalClass sicmedMedicalClass2 : sicmedMedicalClasses) {
                SicmedMedicalClassBean sicmedMedicalClassBean = new SicmedMedicalClassBean();
                sicmedMedicalClassBean.setSMCB(sicmedMedicalClass2);
                // 返回对象赋值
                sicmedMedicalClassBeans.getSicmedMedicalClassBeans().add(sicmedMedicalClassBean);
            }
            sicmedMedicalClassBeans.setError("0");
            return sicmedMedicalClassBeans;
        } else {
            sicmedMedicalClassBeans.setError("1");
            return sicmedMedicalClassBeans;
        }
    }

    /*
     * 药品价格
     */
    @ResponseBody
    @RequestMapping(value = "findMedcitalPrice")
    public BaseBean findMedcitalPrice(String version, String pageNo) {
        // 创建返回对象
        SicmedMedicalPriceBeans sicmedMedicalPriceBeans = new SicmedMedicalPriceBeans();
        // 获取客户端传递的版本号 对应的更新日期
        Sno sno = new Sno();
        sno.setNumber(version);
        sno = snoService.get(sno);
        // 创建分页条件
        Page<SicmedMedicalPrice> page = new Page<SicmedMedicalPrice>();
        page.setPageSize(PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 创建查询条件
        SicmedMedicalPrice sicmedMedicalPrice = new SicmedMedicalPrice();
        // 查询条件赋值
        sicmedMedicalPrice.setUpdateDate(sno.getUpdateDate());
        sicmedMedicalPrice.setPage(page);
        // 调用service查询数据
        List<SicmedMedicalPrice> sicmedMedicalPrices = sicmedMedicalPriceService.findByVersion(sicmedMedicalPrice);
        // 查询结果分享分析
        if (sicmedMedicalPrices.size() > 0) {
            // 遍历查询结果
            for (SicmedMedicalPrice sicmedMedicalPrice2 : sicmedMedicalPrices) {
                SicmedMedicalPriceBean sicmedMedicalPriceBean = new SicmedMedicalPriceBean();
                sicmedMedicalPriceBean.setSicmedMedicaPrice(sicmedMedicalPrice2);
                // 返回对象赋值
                sicmedMedicalPriceBeans.getSicmedMedicalPriceBeans().add(sicmedMedicalPriceBean);
            }
            sicmedMedicalPriceBeans.setError("0");
            return sicmedMedicalPriceBeans;
        } else {
            sicmedMedicalPriceBeans.setError("1");
            return sicmedMedicalPriceBeans;
        }
    }

    /*
     * 检查
     */
    @ResponseBody
    @RequestMapping(value = "findCheck")
    public BaseBean findCheck(String version, String pageNo) {
        // 创建返回对象
        SicmedTwxrayCheckBeans sicmedTwxrayCheckBeans = new SicmedTwxrayCheckBeans();
        // 获取客户端传递的版本号 对应的更新日期
        Sno sno = new Sno();
        sno.setNumber(version);
        sno = snoService.get(sno);
        // 创建分页条件
        Page<SicmedTwxrayCheck> page = new Page<SicmedTwxrayCheck>();
        page.setPageSize(PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 创建查询条件
        SicmedTwxrayCheck sicmedTwxrayCheck = new SicmedTwxrayCheck();
        // 查询条件赋值
        sicmedTwxrayCheck.setUpdateDate(sno.getUpdateDate());
        sicmedTwxrayCheck.setPage(page);
        // 调用service查询数据
        List<SicmedTwxrayCheck> sicmedTwxrayChecks = sicmedTwxrayCheckService.findByVersion(sicmedTwxrayCheck);
        // 查询结果分享分析
        if (sicmedTwxrayChecks.size() > 0) {
            // 遍历查询结果
            for (SicmedTwxrayCheck sicmedTwxrayCheck2 : sicmedTwxrayChecks) {
                SicmedTwxrayCheckBean sicmedTwxrayCheckBean = new SicmedTwxrayCheckBean();
                sicmedTwxrayCheckBean.setSTCB(sicmedTwxrayCheck2);
                // 返回对象赋值
                sicmedTwxrayCheckBeans.getTwxrayCheckBeanList().add(sicmedTwxrayCheckBean);
            }
            sicmedTwxrayCheckBeans.setError("0");
            return sicmedTwxrayCheckBeans;
        } else {
            sicmedTwxrayCheckBeans.setError("1");
            return sicmedTwxrayCheckBeans;
        }
    }

    /*
     * 检查类别
     */
    @ResponseBody
    @RequestMapping(value = "findCheckClass")
    public BaseBean findCheckClass(String version, String pageNo) {
        // 创建返回对象
        SicmedTwxrayClassBeans sicmedTwxrayClassBeans = new SicmedTwxrayClassBeans();
        // 获取客户端传递的版本号 对应的更新日期
        Sno sno = new Sno();
        sno.setNumber(version);
        sno = snoService.get(sno);
        // 创建分页条件
        Page<SicmedTwxrayClass> page = new Page<SicmedTwxrayClass>();
        page.setPageSize(PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 创建查询条件
        SicmedTwxrayClass sicmedTwxrayClass = new SicmedTwxrayClass();
        // 查询条件赋值
        sicmedTwxrayClass.setUpdateDate(sno.getUpdateDate());
        sicmedTwxrayClass.setPage(page);
        // 调用service查询数据
        List<SicmedTwxrayClass> sicmedTwxrayClasss = sicmedTwxrayCheckClassService.findByVersion(sicmedTwxrayClass);
        // 查询结果分享分析
        if (sicmedTwxrayClasss.size() > 0) {
            // 遍历查询结果
            for (SicmedTwxrayClass sicmedTwxrayClass2 : sicmedTwxrayClasss) {
                SicmedTwxrayClassBean sicmedTwxrayClassBean = new SicmedTwxrayClassBean();
                sicmedTwxrayClassBean.setSicmedTwxrayClass(sicmedTwxrayClass2);
                // 返回对象赋值
                sicmedTwxrayClassBeans.getSicmedTwxrayClassBeans().add(sicmedTwxrayClassBean);
            }
            sicmedTwxrayClassBeans.setError("0");
            return sicmedTwxrayClassBeans;
        } else {
            sicmedTwxrayClassBeans.setError("1");
            return sicmedTwxrayClassBeans;
        }
    }

    /*
     * 检查价格
     */
    @ResponseBody
    @RequestMapping(value = "findCheckPrice")
    public BaseBean findCheckPrice(String version, String pageNo) {
        // 创建返回对象
        SicmedCheckPriceBeans sicmedCheckPriceBeans = new SicmedCheckPriceBeans();
        // 获取客户端传递的版本号 对应的更新日期
        Sno sno = new Sno();
        sno.setNumber(version);
        sno = snoService.get(sno);
        // 创建分页条件
        Page<SicmedCheckPrice> page = new Page<SicmedCheckPrice>();
        page.setPageSize(PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 创建查询条件
        SicmedCheckPrice sicmedCheckPrice = new SicmedCheckPrice();
        // 查询条件赋值
        sicmedCheckPrice.setUpdateDate(sno.getUpdateDate());
        sicmedCheckPrice.setPage(page);
        // 调用service查询数据
        List<SicmedCheckPrice> sicmedCheckPrices = sicmedTwxrayCheckPriceService.findByVersion(sicmedCheckPrice);
        // 查询结果分享分析
        if (sicmedCheckPrices.size() > 0) {
            // 遍历查询结果
            for (SicmedCheckPrice sicmedCheckPrice2 : sicmedCheckPrices) {
                SicmedCheckPriceBean sicmedCheckPriceBean = new SicmedCheckPriceBean();
                sicmedCheckPriceBean.setSicmedCheckPrice(sicmedCheckPrice2);
                // 返回对象赋值
                sicmedCheckPriceBeans.getSicmedCheckPriceBeans().add(sicmedCheckPriceBean);
            }
            sicmedCheckPriceBeans.setError("0");
            return sicmedCheckPriceBeans;
        } else {
            sicmedCheckPriceBeans.setError("1");
            return sicmedCheckPriceBeans;
        }
    }

    /*
     * 检验
     */
    @ResponseBody
    @RequestMapping(value = "findInspect")
    public BaseBean findInspect(String version, String pageNo) {
        // 创建返回对象
        SicmedInspectBeans sicmedInspectBeans = new SicmedInspectBeans();
        // 获取客户端传递的版本号 对应的更新日期
        Sno sno = new Sno();
        sno.setNumber(version);
        sno = snoService.get(sno);
        // 创建分页条件
        Page<SicmedInspect> page = new Page<SicmedInspect>();
        page.setPageSize(PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 创建查询条件
        SicmedInspect sicmedInspect = new SicmedInspect();
        // 查询条件赋值
        sicmedInspect.setUpdateDate(sno.getUpdateDate());
        sicmedInspect.setPage(page);
        // 调用service查询数据
        List<SicmedInspect> sicmedInspects = sicmedInspectService.findByVersion(sicmedInspect);
        // 查询结果分享分析
        if (sicmedInspects.size() > 0) {
            // 遍历查询结果
            for (SicmedInspect sicmedInspect2 : sicmedInspects) {
                SicmedInspectBean sicmedInspectBean = new SicmedInspectBean();
                sicmedInspectBean.setSIB(sicmedInspect2);
                // 返回对象赋值
                sicmedInspectBeans.getSicmedInspectBeans().add(sicmedInspectBean);
            }
            sicmedInspectBeans.setError("0");
            return sicmedInspectBeans;
        } else {
            sicmedInspectBeans.setError("1");
            return sicmedInspectBeans;
        }
    }

    /*
     * 检验类别
     */
    @ResponseBody
    @RequestMapping(value = "findInspectClass")
    public BaseBean findInspectClass(String version, String pageNo) {
        // 创建返回对象
        SicmedInspectClassBeans sicmedInspectClassBeans = new SicmedInspectClassBeans();
        // 获取客户端传递的版本号 对应的更新日期
        Sno sno = new Sno();
        sno.setNumber(version);
        sno = snoService.get(sno);
        // 创建分页条件
        Page<SicmedInspectClass> page = new Page<SicmedInspectClass>();
        page.setPageSize(PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 创建查询条件
        SicmedInspectClass sicmedInspectClass = new SicmedInspectClass();
        // 查询条件赋值
        sicmedInspectClass.setUpdateDate(sno.getUpdateDate());
        sicmedInspectClass.setPage(page);
        // 调用service查询数据
        List<SicmedInspectClass> sicmedInspectClasss = sicmedInspectClassService.findByVersion(sicmedInspectClass);
        // 查询结果分享分析
        if (sicmedInspectClasss.size() > 0) {
            // 遍历查询结果
            for (SicmedInspectClass sicmedInspectClass2 : sicmedInspectClasss) {
                SicmedInspectClassBean sicmedInspectClassBean = new SicmedInspectClassBean();
                sicmedInspectClassBean.setSICB(sicmedInspectClass2);
                // 返回对象赋值
                sicmedInspectClassBeans.getSicmedInspectClassBeans().add(sicmedInspectClassBean);
            }
            sicmedInspectClassBeans.setError("0");
            return sicmedInspectClassBeans;
        } else {
            sicmedInspectClassBeans.setError("1");
            return sicmedInspectClassBeans;
        }
    }

    /*
     * 检验价格
     */
    @ResponseBody
    @RequestMapping(value = "findInspectPrice")
    public BaseBean findInspectPrice(String version, String pageNo) {
        // 创建返回对象
        SicmedInspectPriceBeans sicmedInspectPriceBeans = new SicmedInspectPriceBeans();
        // 获取客户端传递的版本号 对应的更新日期
        Sno sno = new Sno();
        sno.setNumber(version);
        sno = snoService.get(sno);
        // 创建分页条件
        Page<SicmedInspectPrice> page = new Page<SicmedInspectPrice>();
        page.setPageSize(PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 创建查询条件
        SicmedInspectPrice sicmedInspectPrice = new SicmedInspectPrice();
        // 查询条件赋值
        sicmedInspectPrice.setUpdateDate(sno.getUpdateDate());
        sicmedInspectPrice.setPage(page);
        // 调用service查询数据
        List<SicmedInspectPrice> sicmedInspectPrices = sicmedInspectPriceService.findByVersion(sicmedInspectPrice);
        // 查询结果分享分析
        if (sicmedInspectPrices.size() > 0) {
            // 遍历查询结果
            for (SicmedInspectPrice sicmedInspectPrice2 : sicmedInspectPrices) {
                SicmedInspectPriceBean sicmedInspectPriceBean = new SicmedInspectPriceBean();
                sicmedInspectPriceBean.setSicmedInspectPriceBean(sicmedInspectPrice2);
                // 返回对象赋值
                sicmedInspectPriceBeans.getSicmedInspectPriceBeans().add(sicmedInspectPriceBean);
            }
            sicmedInspectPriceBeans.setError("0");
            return sicmedInspectPriceBeans;
        } else {
            sicmedInspectPriceBeans.setError("1");
            return sicmedInspectPriceBeans;
        }
    }

    /*
     * 治疗
     */
    @ResponseBody
    @RequestMapping(value = "findCure")
    public BaseBean findCure(String version, String pageNo) {
        // 创建返回对象
        SicmedCureCheckBeans sicmedCureCheckBeans = new SicmedCureCheckBeans();
        // 获取客户端传递的版本号 对应的更新日期
        Sno sno = new Sno();
        sno.setNumber(version);
        sno = snoService.get(sno);
        // 创建分页条件
        Page<SicmedCureCheck> page = new Page<SicmedCureCheck>();
        page.setPageSize(PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 创建查询条件
        SicmedCureCheck sicmedCureCheck = new SicmedCureCheck();
        // 查询条件赋值
        sicmedCureCheck.setUpdateDate(sno.getUpdateDate());
        sicmedCureCheck.setPage(page);
        // 调用service查询数据
        List<SicmedCureCheck> sicmedCureChecks = sicmedCureCheckService.findByVersion(sicmedCureCheck);
        // 查询结果分享分析
        if (sicmedCureChecks.size() > 0) {
            // 遍历查询结果
            for (SicmedCureCheck sicmedCureCheck2 : sicmedCureChecks) {
                SicmedCureCheckBean sicmedCureCheckBean = new SicmedCureCheckBean();
                sicmedCureCheckBean.setSCCB(sicmedCureCheck2);
                // 返回对象赋值
                sicmedCureCheckBeans.getCureCheckBeanList().add(sicmedCureCheckBean);
            }
            sicmedCureCheckBeans.setError("0");
            return sicmedCureCheckBeans;
        } else {
            sicmedCureCheckBeans.setError("1");
            return sicmedCureCheckBeans;
        }
    }

    /*
     * 治疗类别
     */
    @ResponseBody
    @RequestMapping(value = "findCureClass")
    public BaseBean findCureClass(String version, String pageNo) {
        // 创建返回对象
        SicmedCureClassBeans sicmedCureClassBeans = new SicmedCureClassBeans();
        // 获取客户端传递的版本号 对应的更新日期
        Sno sno = new Sno();
        sno.setNumber(version);
        sno = snoService.get(sno);
        // 创建分页条件
        Page<SicmedCureClass> page = new Page<SicmedCureClass>();
        page.setPageSize(PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 创建查询条件
        SicmedCureClass sicmedCureClass = new SicmedCureClass();
        // 查询条件赋值
        sicmedCureClass.setUpdateDate(sno.getUpdateDate());
        sicmedCureClass.setPage(page);
        // 调用service查询数据
        List<SicmedCureClass> sicmedCureClasss = sicmedCureCheckClassService.findByVersion(sicmedCureClass);
        // 查询结果分享分析
        if (sicmedCureClasss.size() > 0) {
            // 遍历查询结果
            for (SicmedCureClass sicmedCureClass2 : sicmedCureClasss) {
                SicmedCureClassBean sicmedCureClassBean = new SicmedCureClassBean();
                sicmedCureClassBean.setSCCB(sicmedCureClass2);
                // 返回对象赋值
                sicmedCureClassBeans.getSicmedCureClassBeans().add(sicmedCureClassBean);
            }
            sicmedCureClassBeans.setError("0");
            return sicmedCureClassBeans;
        } else {
            sicmedCureClassBeans.setError("1");
            return sicmedCureClassBeans;
        }
    }

    /*
     * 治疗价格
     */
    @ResponseBody
    @RequestMapping(value = "findCurePrice")
    public BaseBean findCurePrice(String version, String pageNo) {
        // 创建返回对象
        SicmedCurePriceBeans sicmedCurePriceBeans = new SicmedCurePriceBeans();
        // 获取客户端传递的版本号 对应的更新日期
        Sno sno = new Sno();
        sno.setNumber(version);
        sno = snoService.get(sno);
        // 创建分页条件
        Page<SicmedCurePrice> page = new Page<SicmedCurePrice>();
        page.setPageSize(PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 创建查询条件
        SicmedCurePrice sicmedCurePrice = new SicmedCurePrice();
        // 查询条件赋值
        sicmedCurePrice.setUpdateDate(sno.getUpdateDate());
        sicmedCurePrice.setPage(page);
        // 调用service查询数据
        List<SicmedCurePrice> sicmedCurePrices = sicmedCureCheckPriceService.findByVersion(sicmedCurePrice);
        // 查询结果分享分析
        if (sicmedCurePrices.size() > 0) {
            // 遍历查询结果
            for (SicmedCurePrice sicmedCurePrice2 : sicmedCurePrices) {
                SicmedCurePriceBean sicmedCurePriceBean = new SicmedCurePriceBean();
                sicmedCurePriceBean.setSicmedCurePriceBean(sicmedCurePrice2);
                // 返回对象赋值
                sicmedCurePriceBeans.getSicmedCurePriceBeans().add(sicmedCurePriceBean);
            }
            sicmedCurePriceBeans.setError("0");
            return sicmedCurePriceBeans;
        } else {
            sicmedCurePriceBeans.setError("1");
            return sicmedCurePriceBeans;
        }
    }

    /*
     * 疾病
     */
    @ResponseBody
    @RequestMapping(value = "findDisease")
    public BaseBean findDisease(String version, String pageNo) {
        // 创建返回对象
        SicmedDiseaseBeans sicmedDiseaseBeans = new SicmedDiseaseBeans();
        // 获取客户端传递的版本号 对应的更新日期
        Sno sno = new Sno();
        sno.setNumber(version);
        sno = snoService.get(sno);
        // 创建分页条件
        Page<SicmedDisease> page = new Page<SicmedDisease>();
        page.setPageSize(PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 创建查询条件
        SicmedDisease sicmedDisease = new SicmedDisease();
        // 查询条件赋值
        sicmedDisease.setUpdateDate(sno.getUpdateDate());
        sicmedDisease.setPage(page);
        // 调用service查询数据
        List<SicmedDisease> sicmedDiseases = sicmedDiseaseService.findByVersion(sicmedDisease);
        // 查询结果分享分析
        if (sicmedDiseases.size() > 0) {
            // 遍历查询结果
            for (SicmedDisease sicmedDisease2 : sicmedDiseases) {
                SicmedDiseaseBean sicmedDiseaseBean = new SicmedDiseaseBean();
                sicmedDiseaseBean.setSD(sicmedDisease2);
                // 返回对象赋值
                sicmedDiseaseBeans.getSicmedDiseaseBeans().add(sicmedDiseaseBean);
            }
            sicmedDiseaseBeans.setError("0");
            return sicmedDiseaseBeans;
        } else {
            sicmedDiseaseBeans.setError("1");
            return sicmedDiseaseBeans;
        }
    }

    /*
     * 疾病类别
     */
    @ResponseBody
    @RequestMapping(value = "findDiseaseClass")
    public BaseBean findDiseaseClass(String version, String pageNo) {
        // 创建返回对象
        SicmedDiseaseClassBeans sicmedDiseaseClassBeans = new SicmedDiseaseClassBeans();
        // 获取客户端传递的版本号 对应的更新日期
        Sno sno = new Sno();
        sno.setNumber(version);
        sno = snoService.get(sno);
        // 创建分页条件
        Page<SicmedDiseaseClass> page = new Page<SicmedDiseaseClass>();
        page.setPageSize(PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 创建查询条件
        SicmedDiseaseClass sicmedDiseaseClass = new SicmedDiseaseClass();
        // 查询条件赋值
        sicmedDiseaseClass.setUpdateDate(sno.getUpdateDate());
        sicmedDiseaseClass.setPage(page);
        // 调用service查询数据
        List<SicmedDiseaseClass> sicmedDiseaseClasss = sicmedDiseaseClassService.findByVersion(sicmedDiseaseClass);
        // 查询结果分享分析
        if (sicmedDiseaseClasss.size() > 0) {
            // 遍历查询结果
            for (SicmedDiseaseClass sicmedDiseaseClass2 : sicmedDiseaseClasss) {
                SicmedDiseaseClassBean sicmedDiseaseClassBean = new SicmedDiseaseClassBean();
                sicmedDiseaseClassBean.setDC(sicmedDiseaseClass2);
                // 返回对象赋值
                sicmedDiseaseClassBeans.getSicmedDiseaseClassBeans().add(sicmedDiseaseClassBean);
            }
            sicmedDiseaseClassBeans.setError("0");
            return sicmedDiseaseClassBeans;
        } else {
            sicmedDiseaseClassBeans.setError("1");
            return sicmedDiseaseClassBeans;
        }
    }

    /*
     * 标准处方
     */
    @ResponseBody
    @RequestMapping(value = "findStand")
    public BaseBean findStand(String version, String pageNo) {
        // 创建返回对象
        SicmedStanderprescriptionDiseaseBeans sicmedStanderprescriptionDiseaseBeans = new SicmedStanderprescriptionDiseaseBeans();
        // 获取客户端传递的版本号 对应的更新日期
        Sno sno = new Sno();
        sno.setNumber(version);
        sno = snoService.get(sno);
        // 创建分页条件
        Page<SicmedStanderprescriptionDisease> page = new Page<SicmedStanderprescriptionDisease>();
        page.setPageSize(PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 创建查询条件
        SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease = new SicmedStanderprescriptionDisease();
        // 查询条件赋值
        sicmedStanderprescriptionDisease.setUpdateDate(sno.getUpdateDate());
        sicmedStanderprescriptionDisease.setPage(page);
        // 调用service查询数据
        List<SicmedStanderprescriptionDisease> sicmedStanderprescriptionDiseases = sicmedStanderprescriptionDiseaseService
                .findByVersion(sicmedStanderprescriptionDisease);
        // 查询结果分享分析
        if (sicmedStanderprescriptionDiseases.size() > 0) {
            // 遍历查询结果
            for (SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease2 : sicmedStanderprescriptionDiseases) {
                SicmedStanderprescriptionDiseaseBean sicmedStanderprescriptionDiseaseBean = new SicmedStanderprescriptionDiseaseBean();
                sicmedStanderprescriptionDiseaseBean.setssdb(sicmedStanderprescriptionDisease2);
                // 返回对象赋值
                sicmedStanderprescriptionDiseaseBeans.getSicmedStanderprescriptionDiseaseBeans()
                        .add(sicmedStanderprescriptionDiseaseBean);
            }
            sicmedStanderprescriptionDiseaseBeans.setError("0");
            return sicmedStanderprescriptionDiseaseBeans;
        } else {
            sicmedStanderprescriptionDiseaseBeans.setError("1");
            return sicmedStanderprescriptionDiseaseBeans;
        }
    }

    /*
     * 标准处方中的医嘱
     */
    @ResponseBody
    @RequestMapping(value = "findStandAsked")
    public BaseBean findStandAsked(String version, String pageNo) {
        // 创建返回对象
        SicmedStanderprescriptionAskedBeans sicmedStanderprescriptionAskedBeans = new SicmedStanderprescriptionAskedBeans();
        // 获取客户端传递的版本号 对应的更新日期
        Sno sno = new Sno();
        sno.setNumber(version);
        sno = snoService.get(sno);
        // 创建分页条件
        Page<SicmedStanderprescriptionAsked> page = new Page<SicmedStanderprescriptionAsked>();
        page.setPageSize(PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 创建查询条件
        SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked = new SicmedStanderprescriptionAsked();
        // 查询条件赋值
        sicmedStanderprescriptionAsked.setUpdateDate(sno.getUpdateDate());
        sicmedStanderprescriptionAsked.setPage(page);
        // 调用service查询数据
        List<SicmedStanderprescriptionAsked> sicmedStanderprescriptionAskeds = sicmedStanderprescriptionAskedService
                .findByVersion(sicmedStanderprescriptionAsked);
        // 查询结果分享分析
        if (sicmedStanderprescriptionAskeds.size() > 0) {
            // 遍历查询结果
            for (SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked2 : sicmedStanderprescriptionAskeds) {
                SicmedStanderprescriptionAskedBean sicmedStanderprescriptionAskedBean = new SicmedStanderprescriptionAskedBean();
                sicmedStanderprescriptionAskedBean.setSSAB(sicmedStanderprescriptionAsked2);
                // 返回对象赋值
                sicmedStanderprescriptionAskedBeans.getSicmedStanderprescriptionAskedBeans()
                        .add(sicmedStanderprescriptionAskedBean);
            }
            sicmedStanderprescriptionAskedBeans.setError("0");
            return sicmedStanderprescriptionAskedBeans;
        } else {
            sicmedStanderprescriptionAskedBeans.setError("1");
            return sicmedStanderprescriptionAskedBeans;
        }
    }

    /*
     * 用户
     */
    @ResponseBody
    @RequestMapping(value = "findUser")
    public BaseBean findUser(String version, String pageNo) {
        // 创建返回对象
        SicmedUserBeans sicmedUserBeans = new SicmedUserBeans();
        // 获取客户端传递的版本号 对应的更新日期
        Sno sno = new Sno();
        sno.setNumber(version);
        sno = snoService.get(sno);
        // 创建分页条件
        Page<SicmedUser> page = new Page<SicmedUser>();
        page.setPageSize(PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 创建查询条件
        SicmedUser sicmedUser = new SicmedUser();
        // 查询条件赋值
        sicmedUser.setUpdateDate(sno.getUpdateDate());
        sicmedUser.setPage(page);
        // 调用service查询数据
        List<SicmedUser> sicmedUsers = sicmedUserService.findByVersion(sicmedUser);
        // 查询结果分享分析
        if (sicmedUsers.size() > 0) {
            // 遍历查询结果
            for (SicmedUser sicmedUser2 : sicmedUsers) {
                SicmedUserBean sicmedUserBean = new SicmedUserBean();
                sicmedUserBean.setSUser(sicmedUser2);
                // 返回对象赋值
                sicmedUserBeans.getSicmedUserBeans().add(sicmedUserBean);
            }
            sicmedUserBeans.setError("0");
            return sicmedUserBeans;
        } else {
            sicmedUserBeans.setError("1");
            return sicmedUserBeans;
        }
    }

    /*
     * 挂号类型
     */
    @ResponseBody
    @RequestMapping(value = "findRegisteredType")
    public BaseBean findRegisteredType(String version, String pageNo) {
        // 创建返回对象
        SicmedRegisteredTypeBeans sicmedRegisteredTypeBeans = new SicmedRegisteredTypeBeans();
        // 获取客户端传递的版本号 对应的更新日期
        Sno sno = new Sno();
        sno.setNumber(version);
        sno = snoService.get(sno);
        // 创建分页条件
        Page<SicmedRegisteredType> page = new Page<SicmedRegisteredType>();
        page.setPageSize(PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 创建查询条件
        SicmedRegisteredType sicmedRegisteredType = new SicmedRegisteredType();
        // 查询条件赋值
        sicmedRegisteredType.setUpdateDate(sno.getUpdateDate());
        sicmedRegisteredType.setPage(page);
        // 调用service查询数据
        List<SicmedRegisteredType> sicmedRegisteredTypes = sicmedRegisteredTypeService
                .findByVersion(sicmedRegisteredType);
        // 查询结果分享分析
        if (sicmedRegisteredTypes.size() > 0) {
            // 遍历查询结果
            for (SicmedRegisteredType sicmedRegisteredType2 : sicmedRegisteredTypes) {
                SicmedRegisteredTypeBean sicmedRegisteredTypeBean = new SicmedRegisteredTypeBean();
                sicmedRegisteredTypeBean.setSRTB(sicmedRegisteredType2);
                // 返回对象赋值
                sicmedRegisteredTypeBeans.getSicmedRegisteredTypeBeans().add(sicmedRegisteredTypeBean);
            }
            sicmedRegisteredTypeBeans.setError("0");
            return sicmedRegisteredTypeBeans;
        } else {
            sicmedRegisteredTypeBeans.setError("1");
            return sicmedRegisteredTypeBeans;
        }
    }

    /*
     * 挂号价格
     */
    @ResponseBody
    @RequestMapping(value = "findRegisteredPrice")
    public BaseBean findRegisteredPrice(String version, String pageNo) {
        // 创建返回对象
        SicmedRegisteredPriceBeans sicmedRegisteredPriceBeans = new SicmedRegisteredPriceBeans();
        // 获取客户端传递的版本号 对应的更新日期
        Sno sno = new Sno();
        sno.setNumber(version);
        sno = snoService.get(sno);
        // 创建分页条件
        Page<SicmedRegisteredPrice> page = new Page<SicmedRegisteredPrice>();
        page.setPageSize(PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 创建查询条件
        SicmedRegisteredPrice sicmedRegisteredPrice = new SicmedRegisteredPrice();
        // 查询条件赋值
        sicmedRegisteredPrice.setUpdateDate(sno.getUpdateDate());
        sicmedRegisteredPrice.setPage(page);
        // 调用service查询数据
        List<SicmedRegisteredPrice> sicmedRegisteredPrices = sicmedRegisteredPriceService
                .findByVersion(sicmedRegisteredPrice);
        // 查询结果分享分析
        if (sicmedRegisteredPrices.size() > 0) {
            // 遍历查询结果
            for (SicmedRegisteredPrice sicmedRegisteredPrice2 : sicmedRegisteredPrices) {
                SicmedRegisteredPriceBean sicmedRegisteredPriceBean = new SicmedRegisteredPriceBean();
                sicmedRegisteredPriceBean.setSRPB(sicmedRegisteredPrice2);
                // 返回对象赋值
                sicmedRegisteredPriceBeans.getSicmedRegisteredPriceBeans().add(sicmedRegisteredPriceBean);
            }
            sicmedRegisteredPriceBeans.setError("0");
            return sicmedRegisteredPriceBeans;
        } else {
            sicmedRegisteredPriceBeans.setError("1");
            return sicmedRegisteredPriceBeans;
        }
    }
}