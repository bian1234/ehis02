package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCMedicalUseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalUseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedStanderprescriptionAskedBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedStanderprescriptionAskedBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAskedClass;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCase;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCheckPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCureCheck;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCurePrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspect;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspectPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedical;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalUse;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatient;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatientPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegistered;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStanderprescriptionAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStanderprescriptionDisease;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedTwxrayCheck;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedAskedClassService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedAskedService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCaseService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCheckPriceService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCureCheckService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCurePriceService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedInspectPriceService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedInspectService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedMedicalPriceService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedMedicalService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedMedicalUseService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedPatientPriceService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedPatientService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedRegisteredService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedStanderprescriptionAskedService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedStanderprescriptionDiseaseService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedTwxrayCheckService;
import com.thinkgem.jeesite.cfq.mobile.rest.setBean.SicmedMedicalUseSetBean;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.DateTimeUtils;

/**
 * 标准处方中的医嘱Controller
 *
 * @author Max
 * @version 2016-08-17
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedStanderprescriptionAsked")
public class SicmedStanderprescriptionAskedController extends BaseController {

    @Autowired
    private SicmedStanderprescriptionAskedService sicmedStanderprescriptionAskedService;

    @Autowired
    private SicmedAskedClassService sicmedAskedClassService;

    @Autowired
    private SicmedMedicalUseService sicmedMedicalUseService;

    @Autowired
    private SicmedStanderprescriptionDiseaseService sicmedStanderprescriptionDiseaseService;

    @Autowired
    private SicmedAskedService sicmedAskedService;

    @Autowired
    private SicmedCaseService sicmedCaseService;

    @Autowired
    private SicmedPatientService sicmedPatientService;

    @Autowired
    private SicmedTwxrayCheckService sicmedTwxrayCheckService;

    @Autowired
    private SicmedCheckPriceService sicmedCheckPriceService;

    @Autowired
    private SicmedInspectService sicmedInspectService;

    @Autowired
    private SicmedInspectPriceService sicmedInspectPriceService;

    @Autowired
    private SicmedCureCheckService sicmedCureCheckService;

    @Autowired
    private SicmedCurePriceService sicmedCurePriceService;

    @Autowired
    private SicmedMedicalService sicmedMedicalService;

    @Autowired
    private SicmedMedicalPriceService sicmedMedicalPriceService;

    @Autowired
    private SicmedPatientPriceService sicmedPatientPriceService;

    @Autowired
    private SicmedRegisteredService sicmedRegisteredService;

    /**
     * 添加标准处方中的医嘱
     *
     * @param sicmedStanderprescriptionAskedBean
     * @param askedClassId
     * @param sicmedStanderprescriptionId
     * @param sicmedMedicalUseBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addCMed")
    public BaseBean addCMed(HttpServletRequest request, SicmedCMedicalUseBean sicmedCMedicalUseBean,
                            String sicmedStanderprescriptionId) {
        //1.创建返回对象
        SicmedStanderprescriptionAskedBean sicmedStanderprescriptionAskedBean = new SicmedStanderprescriptionAskedBean();
        //2.传入参数校验
        if (!AppParameterSimulation.simulationId(sicmedStanderprescriptionId)) {
            sicmedStanderprescriptionAskedBean.setError("0");
            sicmedStanderprescriptionAskedBean.setErrorMessage("病历ID为空");
            return sicmedStanderprescriptionAskedBean;
        }
        //3.获取医嘱类别
        SicmedAskedClass sicmedAskedClass = new SicmedAskedClass();
        sicmedAskedClass.setClassNumber("3");
        sicmedAskedClass = sicmedAskedClassService.get(sicmedAskedClass);
        //4.获取标准处方信息
        SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease = sicmedStanderprescriptionDiseaseService.get(sicmedStanderprescriptionId);

        //5.创建中药用法对象
        SicmedMedicalUse sicmedMedicalUse = new SicmedMedicalUse();

        //7.中药用法对象赋值
        sicmedMedicalUse.setUseGroup(sicmedCMedicalUseBean.getUseType());
        sicmedMedicalUse.setUseBun(sicmedCMedicalUseBean.getUseTime());
//				sicmedMedicalUse.setUseBout(sicmedCMedicalUseBean.get);
//				sicmedMedicalUse.setUseName(useName);
//				sicmedMedicalUse.setRemarks(remarks);
        //8.调用service保存中药用法
        sicmedMedicalUseService.save(sicmedMedicalUse);
        // 获取保存的药品用法
        sicmedMedicalUse = sicmedMedicalUseService.get(sicmedMedicalUse);
        //9.获取中药信息
        String allStandZhMedical = request.getParameter("allStandZhMedical");
        JSONArray dailyList = new JSONArray(allStandZhMedical);
        //10.分别保存各中药信息
        for (int i = 0, j = dailyList.length(); i < j; i++) {
            SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked = new SicmedStanderprescriptionAsked();

            sicmedStanderprescriptionAsked.setSicmedStanderprescription(sicmedStanderprescriptionDisease);
            sicmedStanderprescriptionAsked.setAskedGroup(sicmedMedicalUse.getId());
            JSONObject object = (JSONObject) dailyList.get(i);
            String id = (String) object.get("id");
            String useInfor = (String) object.get("useInfor");
            String count = (String) object.get("count");
            // 添加医嘱所属类别
            sicmedStanderprescriptionAsked.setSicmedAskedClass(sicmedAskedClass);
            // 获取药品信息
            SicmedMedical sicmedMedical = sicmedMedicalService.get(id);
            // 设置医嘱名称
            //sicmedStanderprescriptionAsked.setAskedName(sicmedMedical.getMedicalNameChina());

            sicmedStanderprescriptionAsked.setOrderCode(id);

            sicmedStanderprescriptionAsked.setSicmedMedicalUse(sicmedMedicalUse);
            //sicmedStanderprescriptionAsked.setAskedGroup(sicmedMedicalUse.getId());
            sicmedStanderprescriptionAsked.setSicmedMedicalUse(sicmedMedicalUse);
            sicmedStanderprescriptionAskedService.save(sicmedStanderprescriptionAsked);
        }


        sicmedStanderprescriptionAskedBean.setError("0");
        sicmedStanderprescriptionAskedBean.setErrorMessage("添加医嘱成功");

        return sicmedStanderprescriptionAskedBean;
    }

    /**
     * 添加标准处方中的医嘱
     *
     * @param sicmedStanderprescriptionAskedBean
     * @param askedClassId
     * @param sicmedStanderprescriptionId
     * @param sicmedMedicalUseBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add")
    public BaseBean add(SicmedStanderprescriptionAskedBean sicmedStanderprescriptionAskedBean, String askedClassId,
                        String sicmedStanderprescriptionId, SicmedMedicalUseBean sicmedMedicalUseBean) {

        if (!AppParameterSimulation.simulationId(askedClassId)
                || !AppParameterSimulation.simulationId(sicmedStanderprescriptionAskedBean.getOrderCode())) {
            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;
        }

        SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked = new SicmedStanderprescriptionAsked();

        sicmedStanderprescriptionAsked.setOrderCode(sicmedStanderprescriptionAskedBean.getOrderCode());

        sicmedStanderprescriptionAsked
                .setSicmedStanderprescription(sicmedStanderprescriptionDiseaseService.get(sicmedStanderprescriptionId));
        // 判断是否是重复添加医嘱
        if (sicmedStanderprescriptionAskedService.findList(sicmedStanderprescriptionAsked).size() > 0) {
            sicmedStanderprescriptionAskedBean.setError("1");
            sicmedStanderprescriptionAskedBean.setErrorMessage("添加失败,医嘱在标准处方中已经存在");
            return sicmedStanderprescriptionAskedBean;
        }
        // 获取医嘱类别
        SicmedAskedClass sicmedAskedClass = new SicmedAskedClass();
        sicmedAskedClass.setId(askedClassId);
        sicmedAskedClass = sicmedAskedClassService.get(sicmedAskedClass);
        // 添加医嘱类别
        sicmedStanderprescriptionAsked.setSicmedAskedClass(sicmedAskedClass);

        // 获取医嘱类别编号
        String classNumber = sicmedAskedClass.getClassNumber();
        // 类别编码转Int
        int a = Integer.parseInt(classNumber);
        // 根据医嘱类别获取医嘱中项目信息
        switch (a) {
            case 3:
                // 校验药品用法
                if (AppParameterSimulation.isEmpty(sicmedMedicalUseBean.getUseAmount())
                        || AppParameterSimulation.isEmpty(sicmedMedicalUseBean.getUseBout())
                        || AppParameterSimulation.isEmpty(sicmedMedicalUseBean.getUseBun())
                        || AppParameterSimulation.isEmpty(sicmedMedicalUseBean.getUseDay())
                        || AppParameterSimulation.isEmpty(sicmedMedicalUseBean.getUseGroup())
                        || AppParameterSimulation.isEmpty(sicmedMedicalUseBean.getUseUnit())) {
                    BaseBean baseBean = new BaseBean();
                    baseBean.failureWithParameter();
                    return baseBean;
                } else {
                    // 创建药品用法
                    SicmedMedicalUse sicmedMedicalUse = SicmedMedicalUseSetBean.setSMUB(sicmedMedicalUseBean, null);
                    sicmedMedicalUseService.save(sicmedMedicalUse);
                    sicmedMedicalUse = sicmedMedicalUseService.get(sicmedMedicalUse);

                    sicmedStanderprescriptionAsked.setSicmedMedicalUse(sicmedMedicalUse);
                }
                break;
            default:
                break;
        }

        sicmedStanderprescriptionAskedService.save(sicmedStanderprescriptionAsked);
        sicmedStanderprescriptionAskedBean.setError("0");
        sicmedStanderprescriptionAskedBean.setErrorMessage("添加标准处方中的医嘱成功");

        return sicmedStanderprescriptionAskedBean;
    }

    /**
     * 根据标准处方添加患者医嘱
     */
    @ResponseBody
    @RequestMapping(value = "addAsked")
    public BaseBean addAsked(String id, String caseId, String patientId) {
        // 创建返回对象
        SicmedStanderprescriptionAskedBean sicmedStanderprescriptionAskedBean = new SicmedStanderprescriptionAskedBean();
        // 传入参数校验
        if (!AppParameterSimulation.simulationId(id)) {
            sicmedStanderprescriptionAskedBean.setError("1");
            sicmedStanderprescriptionAskedBean.setErrorMessage("id错误");
            return sicmedStanderprescriptionAskedBean;
        }
        // 获取病历对象
        SicmedCase sicmedCase = sicmedCaseService.get(caseId);
        // 获取患者对象
        SicmedPatient sicmedPatient = sicmedPatientService.get(patientId);
        // 创建查询条件
        SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked = new SicmedStanderprescriptionAsked();
        // 给查询条件赋值
        sicmedStanderprescriptionAsked.setSicmedStanderprescription(sicmedStanderprescriptionDiseaseService.get(id));

        // 根据查询条件去数据库中查询
        List<SicmedStanderprescriptionAsked> sicmedStanderprescriptionAskeds = sicmedStanderprescriptionAskedService
                .findList(sicmedStanderprescriptionAsked);

//		// 创建患者价格明细对象
//		SicmedPatientPrice sicmedPatientPrice = new SicmedPatientPrice();
//		// 向患者价格明细表对象中添加患者属性
//		sicmedPatientPrice.setSicmedPatient(sicmedPatient);
//		sicmedPatientPrice.setIsPay("0");

        // 获取 病历中原有的医嘱
        SicmedAsked sicmedAskedOld = new SicmedAsked();
        sicmedAskedOld.setSicmedCase(sicmedCase);
        List<SicmedAsked> sicmedAskedOlds = sicmedAskedService.findList(sicmedAskedOld);

        // 获取病历医嘱中所有的项目
        List<String> uuids = new ArrayList<String>();
        if (sicmedAskedOlds.size() > 0) {
            for (SicmedAsked sicmedAsked : sicmedAskedOlds) {
                uuids.add(sicmedAsked.getOrderCode());
            }
        }
        // 判断查询结果
        if (sicmedStanderprescriptionAskeds.size() > 0) {
            // 查询结果存在遍历查询结果
            for (SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked2 : sicmedStanderprescriptionAskeds) {
                // 创建患者价格明细对象
                SicmedPatientPrice sicmedPatientPrice = new SicmedPatientPrice();
                // 向患者价格明细表对象中添加患者属性
                sicmedPatientPrice.setSicmedPatient(sicmedPatient);
                sicmedPatientPrice.setIsPay("0");
                // 判断是否是重复添加
                if (uuids.size() > 0) {
                    int i = 0;
                    for (String string : uuids) {
                        if (string.equals(sicmedStanderprescriptionAsked2.getOrderCode())) {
                            i = i + 1;
                        }
                    }
                    if (i > 0) {
                        continue;
                    }
                }
                SicmedAsked sicmedAsked = new SicmedAsked();
                // 类别编码转Int
                int a = Integer.parseInt(sicmedStanderprescriptionAsked2.getSicmedAskedClass().getClassNumber());

                // 根据医嘱类别获取医嘱中项目信息
                switch (a) {
                    case 0:
                        // 获取检查项目信息
                        SicmedTwxrayCheck sicmedTwxrayCheck = sicmedTwxrayCheckService
                                .get(sicmedStanderprescriptionAsked2.getOrderCode());
                        // 创建检查价格查询条件
                        SicmedCheckPrice sicmedCheckPrice = new SicmedCheckPrice();
                        // 为检查价格查询条件赋值
                        sicmedCheckPrice.setSicmedTwxrayCheck(sicmedTwxrayCheck);
                        // 获取检查项目价格信息
                        sicmedCheckPrice = sicmedCheckPriceService.getByEntity(sicmedCheckPrice);
                        // 设置患者价格明细
                        sicmedPatientPrice.setPriceCode(sicmedCheckPrice.getId());
                        break;
                    case 1:
                        // 获取检验项目信息
                        SicmedInspect sicmedInspect = sicmedInspectService
                                .get(sicmedStanderprescriptionAsked2.getOrderCode());
                        // 创建检验价格查询条件
                        SicmedInspectPrice sicmedInspectPrice = new SicmedInspectPrice();
                        // 为检验价格查询条件赋值
                        sicmedInspectPrice.setSicmedInspect(sicmedInspect);
                        // 获取检验项目价格信息
                        sicmedInspectPrice = sicmedInspectPriceService.getByEntity(sicmedInspectPrice);
                        // 设置患者价格明细
                        sicmedPatientPrice.setPriceCode(sicmedInspectPrice.getId());
                        break;
                    case 2:
                        // 获取治疗项目信息
                        SicmedCureCheck sicmedCureCheck = sicmedCureCheckService
                                .get(sicmedStanderprescriptionAsked2.getOrderCode());
                        // 创建治疗价格查询条件
                        SicmedCurePrice sicmedCurePrice = new SicmedCurePrice();
                        // 为治疗价格查询条件赋值
                        sicmedCurePrice.setSicmedCureCheck(sicmedCureCheck);
                        // 获取治疗项目价格信息
                        sicmedCurePrice = sicmedCurePriceService.getByEntity(sicmedCurePrice);
                        // 设置患者价格明细
                        sicmedPatientPrice.setPriceCode(sicmedCurePrice.getId());
                        break;
                    case 3:
                        // 获取药品信息
                        SicmedMedical sicmedMedical = sicmedMedicalService
                                .get(sicmedStanderprescriptionAsked2.getOrderCode());
                        // 创建药品价格查询条件
                        SicmedMedicalPrice sicmedMedicalPrice = new SicmedMedicalPrice();
                        // 为药品价格查询条件赋值
                        sicmedMedicalPrice.setSicmedMedical(sicmedMedical);
                        // 获取药品价格信息
                        sicmedMedicalPrice = sicmedMedicalPriceService.getMedicalPrice(sicmedMedicalPrice);
                        // 设置患者价格明细
                        sicmedPatientPrice.setPriceCode(sicmedMedicalPrice.getId());
                        // 添加药品用法
                        SicmedMedicalUse sicmedMedicalUse = sicmedStanderprescriptionAsked2.getSicmedMedicalUse();
                        // 创建药品用法
                        sicmedMedicalUse.setId(null);
                        sicmedMedicalUse.setAskedCode(DateTimeUtils.getCurrentTime());
                        sicmedMedicalUseService.save(sicmedMedicalUse);
                        sicmedMedicalUse = sicmedMedicalUseService.get(sicmedMedicalUse);
                        sicmedAsked.setSicmedMedicalUse(sicmedMedicalUse);
                        break;
                    case 4:
                        // 获取嘱托信息
                        break;
                    default:
                        break;
                }
                sicmedPatientPrice.setPriceClassType(sicmedStanderprescriptionAsked2.getSicmedAskedClass().getClassNumber());
                sicmedPatientPriceService.save(sicmedPatientPrice);
                SicmedPatientPrice sicmedPatientPrice2 = sicmedPatientPriceService.get(sicmedPatientPrice);
                sicmedAsked.setSicmedPatientPrice(sicmedPatientPrice2);
                sicmedAsked.setOrderCode(sicmedStanderprescriptionAsked2.getOrderCode());
                sicmedAsked.setSicmedAskedClass(sicmedStanderprescriptionAsked2.getSicmedAskedClass());
                sicmedAsked.setSicmedCase(sicmedCase);
                sicmedAskedService.save(sicmedAsked);
            }
            sicmedStanderprescriptionAskedBean.setError("0");
            sicmedStanderprescriptionAskedBean.setSuccessMessage("标准处方调用成功");
            // --------------------更改挂号状态开始-------------------
            SicmedRegistered sicmedRegistered = new SicmedRegistered();
            sicmedRegistered.setSicmedPatient(sicmedPatient);
            sicmedRegistered = sicmedRegisteredService.getByP(sicmedRegistered);
            sicmedRegistered.setRegisteredStatus("2");
            sicmedRegisteredService.update(sicmedRegistered);
            // --------------------更改挂号状态结束-------------------
        } else {
            sicmedStanderprescriptionAskedBean.setError("1");
            sicmedStanderprescriptionAskedBean.setErrorMessage("标准处方中还没有医嘱");
        }
        return sicmedStanderprescriptionAskedBean;
    }

    /**
     * 根据标准处方ID查询标准处方中的医嘱
     *
     * @param pid
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "find")
    public BaseBean find(@RequestParam(required = false) String pid) {

        SicmedStanderprescriptionAskedBeans sicmedStanderprescriptionAskedBeans = new SicmedStanderprescriptionAskedBeans();
        // 判断传入参数
        if (!AppParameterSimulation.simulationId(pid)) {
            sicmedStanderprescriptionAskedBeans.setError("1");
            sicmedStanderprescriptionAskedBeans.setErrorMessage("输入的标准处方ID不正确");
            return sicmedStanderprescriptionAskedBeans;
        }
        // 创建查询条件
        SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked = new SicmedStanderprescriptionAsked();
        // 获取查询条件属性
        SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease = sicmedStanderprescriptionDiseaseService
                .get(pid);
        // 判断查询条件属性
        if (sicmedStanderprescriptionDisease == null) {
            sicmedStanderprescriptionAskedBeans.setError("1");
            sicmedStanderprescriptionAskedBeans.setErrorMessage("标准处方不存在!");
            return sicmedStanderprescriptionAskedBeans;
        }
        // 为查询条件赋值
        sicmedStanderprescriptionAsked.setSicmedStanderprescription(sicmedStanderprescriptionDisease);
        // 根据查询添加查询医嘱信息
        List<SicmedStanderprescriptionAsked> sicmedStanderprescriptionAskeds = sicmedStanderprescriptionAskedService
                .findList(sicmedStanderprescriptionAsked);

        // 创建空的返回结果

        SicmedStanderprescriptionAskedBean sicmedTwxrayCheckAskedBean = new SicmedStanderprescriptionAskedBean();
        SicmedStanderprescriptionAskedBean sicmedInspectAskedBean = new SicmedStanderprescriptionAskedBean();
        SicmedStanderprescriptionAskedBean sicmedCureCheckAskedBean = new SicmedStanderprescriptionAskedBean();
        SicmedStanderprescriptionAskedBean sicmedMedicalAskedBean = new SicmedStanderprescriptionAskedBean();

        SicmedAskedClass sicmedAskedClass = new SicmedAskedClass();
        List<SicmedAskedClass> sicmedAskedClasses = sicmedAskedClassService.findList(sicmedAskedClass);
        for (SicmedAskedClass sicmedAskedClass2 : sicmedAskedClasses) {
            switch (Integer.parseInt(sicmedAskedClass2.getClassNumber())) {
                case 0:
                    sicmedStanderprescriptionAsked.setSicmedAskedClass(sicmedAskedClass2);
                    sicmedTwxrayCheckAskedBean.setSSAB(sicmedStanderprescriptionAsked);
                    sicmedStanderprescriptionAskedBeans.getSicmedStanderprescriptionAskedBeans().add(sicmedTwxrayCheckAskedBean);
                    break;
                case 1:
                    sicmedStanderprescriptionAsked.setSicmedAskedClass(sicmedAskedClass2);
                    sicmedInspectAskedBean.setSSAB(sicmedStanderprescriptionAsked);
                    sicmedStanderprescriptionAskedBeans.getSicmedStanderprescriptionAskedBeans().add(sicmedInspectAskedBean);
                    break;
                case 2:
                    sicmedStanderprescriptionAsked.setSicmedAskedClass(sicmedAskedClass2);
                    sicmedCureCheckAskedBean.setSSAB(sicmedStanderprescriptionAsked);
                    sicmedStanderprescriptionAskedBeans.getSicmedStanderprescriptionAskedBeans().add(sicmedCureCheckAskedBean);
                    break;
                case 3:
                    sicmedStanderprescriptionAsked.setSicmedAskedClass(sicmedAskedClass2);
                    sicmedMedicalAskedBean.setSSAB(sicmedStanderprescriptionAsked);
                    sicmedStanderprescriptionAskedBeans.getSicmedStanderprescriptionAskedBeans().add(sicmedMedicalAskedBean);
                    break;
                default:
                    break;
            }
        }
        // 判断查询结果
        if (sicmedStanderprescriptionAskeds.size() != 0) {
            // 查询结果不为空 遍历查询结果
            for (SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked2 : sicmedStanderprescriptionAskeds) {
                // 获取医嘱项目
                String classNumber = sicmedStanderprescriptionAsked2.getSicmedAskedClass().getClassNumber();

                SicmedStanderprescriptionAskedBean sicmedStanderprescriptionAskedBean = new SicmedStanderprescriptionAskedBean();
                switch (Integer.parseInt(classNumber)) {
                    case 0:// 检查
                        sicmedStanderprescriptionAskedBeans.getSicmedStanderprescriptionAskedBeans()
                                .remove(sicmedTwxrayCheckAskedBean);
                        sicmedStanderprescriptionAskedBean.setSSAB(sicmedStanderprescriptionAsked2);
                        SicmedTwxrayCheck sicmedTwxrayCheck = sicmedTwxrayCheckService.get(sicmedStanderprescriptionAsked2.getOrderCode());
                        sicmedStanderprescriptionAskedBean.getSicmedTwxrayCheckBean().setSTCB(sicmedTwxrayCheck);
                        sicmedStanderprescriptionAskedBeans.getSicmedStanderprescriptionAskedBeans().add(sicmedStanderprescriptionAskedBean);
                        break;
                    case 1:// 检验
                        sicmedStanderprescriptionAskedBeans.getSicmedStanderprescriptionAskedBeans().remove(sicmedInspectAskedBean);
                        sicmedStanderprescriptionAskedBean.setSSAB(sicmedStanderprescriptionAsked2);
                        SicmedInspect sicmedInspect = sicmedInspectService.get(sicmedStanderprescriptionAsked2.getOrderCode());
                        sicmedStanderprescriptionAskedBean.getSicmedInspectBean().setSIB(sicmedInspect);
                        sicmedStanderprescriptionAskedBeans.getSicmedStanderprescriptionAskedBeans().add(sicmedStanderprescriptionAskedBean);
                        break;
                    case 2:// 治疗
                        sicmedStanderprescriptionAskedBeans.getSicmedStanderprescriptionAskedBeans().remove(sicmedCureCheckAskedBean);
                        sicmedStanderprescriptionAskedBean.setSSAB(sicmedStanderprescriptionAsked2);
                        SicmedCureCheck sicmedCureCheck = sicmedCureCheckService.get(sicmedStanderprescriptionAsked2.getOrderCode());
                        sicmedStanderprescriptionAskedBean.getSicmedCureCheckBean().setSCCB(sicmedCureCheck);
                        sicmedStanderprescriptionAskedBeans.getSicmedStanderprescriptionAskedBeans().add(sicmedStanderprescriptionAskedBean);
                        break;
                    case 3:// 药品
                        sicmedStanderprescriptionAskedBeans.getSicmedStanderprescriptionAskedBeans().remove(sicmedMedicalAskedBean);
                        sicmedStanderprescriptionAskedBean.setSSAB(sicmedStanderprescriptionAsked2);
                        SicmedMedical sicmedMedical = sicmedMedicalService.get(sicmedStanderprescriptionAsked2.getOrderCode());
                        sicmedStanderprescriptionAskedBean.getSicmedMedicalBean().setSMB(sicmedMedical);
                        sicmedStanderprescriptionAskedBeans.getSicmedStanderprescriptionAskedBeans().add(sicmedStanderprescriptionAskedBean);
                        sicmedStanderprescriptionAskedBean.getSicmedMedicalUseBean().setSMUB(sicmedStanderprescriptionAsked2.getSicmedMedicalUse());
                        System.err.println(sicmedStanderprescriptionAsked2.getSicmedMedicalUse().getUseName());
                        break;
                    case 4://
                        break;
                    default:
                        break;
                }
            }
            sicmedStanderprescriptionAskedBeans.setError("0");
            sicmedStanderprescriptionAskedBeans.setErrorMessage("请求成功");
        } else {
            // 查询结果为空
            sicmedStanderprescriptionAskedBeans.setError("0");
            sicmedStanderprescriptionAskedBeans.setErrorMessage("处方下还没有医嘱");
        }
        return sicmedStanderprescriptionAskedBeans;
    }

    /**
     * 删除标准处方中的医嘱
     */
    @ResponseBody
    @RequestMapping(value = "delete")
    public BaseBean delete(String id) {

        BaseBean baseBean = new BaseBean();
        if (AppParameterSimulation.simulationId(id)) {
            SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked = sicmedStanderprescriptionAskedService
                    .get(id);
            if (sicmedStanderprescriptionAsked != null) {
                sicmedStanderprescriptionAskedService.delete(sicmedStanderprescriptionAsked);
                baseBean.setError("0");
                baseBean.setErrorMessage("删除成功");
            } else {
                baseBean.setError("1");
                baseBean.setErrorMessage("删除失败");
            }
        } else {
            baseBean.setError("1");
            baseBean.setErrorMessage("输入的id有误");
        }
        return baseBean;
    }

    @ResponseBody
    @RequestMapping(value = "findUnit")
    public BaseBean findUnit(@RequestParam(required = false) String pid, String askedClassId) {

        SicmedStanderprescriptionAskedBeans sicmedStanderprescriptionAskedBeans = new SicmedStanderprescriptionAskedBeans();
        // 判断传入参数
        if (!AppParameterSimulation.simulationId(pid)) {
            sicmedStanderprescriptionAskedBeans.setError("1");
            sicmedStanderprescriptionAskedBeans.setErrorMessage("输入的标准处方ID不正确");
            return sicmedStanderprescriptionAskedBeans;
        }
        // 创建查询条件
        SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked = new SicmedStanderprescriptionAsked();
        // 获取查询条件属性
        SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease = sicmedStanderprescriptionDiseaseService
                .get(pid);
        SicmedAskedClass sicmedAskedClass = new SicmedAskedClass();
        sicmedAskedClass.setId(askedClassId);
        sicmedAskedClass = sicmedAskedClassService.get(sicmedAskedClass);
        String str = sicmedAskedClass.getClassNumber();
        // 判断查询条件属性
        if (sicmedStanderprescriptionDisease == null) {
            sicmedStanderprescriptionAskedBeans.setError("1");
            sicmedStanderprescriptionAskedBeans.setErrorMessage("标准处方不存在!");
            return sicmedStanderprescriptionAskedBeans;
        }
        // 为查询条件赋值
        sicmedStanderprescriptionAsked.setSicmedStanderprescription(sicmedStanderprescriptionDisease);
        sicmedStanderprescriptionAsked.setSicmedAskedClass(sicmedAskedClass);
        // 根据查询添加查询医嘱信息
        List<SicmedStanderprescriptionAsked> sicmedStanderprescriptionAskeds = sicmedStanderprescriptionAskedService
                .findList(sicmedStanderprescriptionAsked);
        // 判断查询结果
        if (sicmedStanderprescriptionAskeds.size() != 0) {
            // 查询结果不为空 遍历查询结果
            if (str.equals("0")) {
                for (SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked2 : sicmedStanderprescriptionAskeds) {
                    SicmedStanderprescriptionAskedBean sicmedTwxrayCheckAskedBean = new SicmedStanderprescriptionAskedBean();
                    sicmedTwxrayCheckAskedBean.setSSAB(sicmedStanderprescriptionAsked2);
                    sicmedStanderprescriptionAskedBeans.getSicmedStanderprescriptionAskedBeans()
                            .add(sicmedTwxrayCheckAskedBean);
                    sicmedTwxrayCheckAskedBean.getSicmedTwxrayCheckBean().setSTCB(
                            sicmedTwxrayCheckService.get(sicmedStanderprescriptionAsked2.getOrderCode()));
                }
            } else if (str.equals("1")) {
                for (SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked2 : sicmedStanderprescriptionAskeds) {
                    SicmedStanderprescriptionAskedBean sicmedInspectAskedBean = new SicmedStanderprescriptionAskedBean();
                    sicmedInspectAskedBean.setSSAB(sicmedStanderprescriptionAsked2);
                    sicmedStanderprescriptionAskedBeans.getSicmedStanderprescriptionAskedBeans()
                            .add(sicmedInspectAskedBean);
                    sicmedInspectAskedBean.getSicmedInspectBean().setSIB(
                            sicmedInspectService.get(sicmedStanderprescriptionAsked2.getOrderCode()));
                }
            } else if (str.equals("2")) {
                for (SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked2 : sicmedStanderprescriptionAskeds) {
                    SicmedStanderprescriptionAskedBean sicmedCureCheckAskedBean = new SicmedStanderprescriptionAskedBean();
                    sicmedCureCheckAskedBean.setSSAB(sicmedStanderprescriptionAsked2);
                    sicmedStanderprescriptionAskedBeans.getSicmedStanderprescriptionAskedBeans()
                            .add(sicmedCureCheckAskedBean);
                    sicmedCureCheckAskedBean.getSicmedCureCheckBean().setSCCB(
                            sicmedCureCheckService.get(sicmedStanderprescriptionAsked2.getOrderCode()));
                }
            } else if (str.equals("3")) {
                for (SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked2 : sicmedStanderprescriptionAskeds) {
                    SicmedStanderprescriptionAskedBean sicmedMedicalAskedBean = new SicmedStanderprescriptionAskedBean();
                    sicmedMedicalAskedBean.setSSAB(sicmedStanderprescriptionAsked2);
                    sicmedStanderprescriptionAskedBeans.getSicmedStanderprescriptionAskedBeans()
                            .add(sicmedMedicalAskedBean);
                    sicmedMedicalAskedBean.getSicmedMedicalBean()
                            .setSMB(sicmedMedicalService.get(sicmedStanderprescriptionAsked2.getOrderCode()));
                    sicmedMedicalAskedBean.getSicmedMedicalUseBean().setSMUB(
                            sicmedMedicalUseService.get(sicmedStanderprescriptionAsked2.getSicmedMedicalUse()));
                }
            }
            sicmedStanderprescriptionAskedBeans.setError("0");
            sicmedStanderprescriptionAskedBeans.setErrorMessage("请求成功");
        } else {
            // 查询结果为空
            sicmedStanderprescriptionAskedBeans.setError("0");
            sicmedStanderprescriptionAskedBeans.setErrorMessage("处方下还没有医嘱");
        }
        return sicmedStanderprescriptionAskedBeans;
    }

    // @ModelAttribute
    // public SicmedStanderprescriptionAsked get(@RequestParam(required = false)
    // String id) {
    // SicmedStanderprescriptionAsked entity = null;
    // if (StringUtils.isNotBlank(id)) {
    // entity = sicmedStanderprescriptionAskedService.get(id);
    // }
    // if (entity == null) {
    // entity = new SicmedStanderprescriptionAsked();
    // }
    // return entity;
    // }
    //
    // @RequiresPermissions("rest:sicmedStanderprescriptionAsked:view")
    // @RequestMapping(value = { "list", "" })
    // public String list(SicmedStanderprescriptionAsked
    // sicmedStanderprescriptionAsked, HttpServletRequest request,
    // HttpServletResponse response, Model model) {
    // Page<SicmedStanderprescriptionAsked> page =
    // sicmedStanderprescriptionAskedService
    // .findPage(new Page<SicmedStanderprescriptionAsked>(request, response),
    // sicmedStanderprescriptionAsked);
    // model.addAttribute("page", page);
    // return "mobile/rest/sicmedStanderprescriptionAskedList";
    // }
    //
    // @RequiresPermissions("rest:sicmedStanderprescriptionAsked:view")
    // @RequestMapping(value = "form")
    // public String form(SicmedStanderprescriptionAsked
    // sicmedStanderprescriptionAsked, Model model) {
    // model.addAttribute("sicmedStanderprescriptionAsked",
    // sicmedStanderprescriptionAsked);
    // return "mobile/rest/sicmedStanderprescriptionAskedForm";
    // }
    //
    // @RequiresPermissions("rest:sicmedStanderprescriptionAsked:edit")
    // @RequestMapping(value = "save")
    // public String save(SicmedStanderprescriptionAsked
    // sicmedStanderprescriptionAsked, Model model,
    // RedirectAttributes redirectAttributes) {
    // if (!beanValidator(model, sicmedStanderprescriptionAsked)) {
    // return form(sicmedStanderprescriptionAsked, model);
    // }
    // sicmedStanderprescriptionAskedService.save(sicmedStanderprescriptionAsked);
    // addMessage(redirectAttributes, "保存保存成功成功");
    // return "redirect:" + Global.getAdminPath() +
    // "/rest/sicmedStanderprescriptionAsked/?repage";
    // }
    //
    // @RequiresPermissions("rest:sicmedStanderprescriptionAsked:edit")
    // @RequestMapping(value = "delete")
    // public String delete(SicmedStanderprescriptionAsked
    // sicmedStanderprescriptionAsked,
    // RedirectAttributes redirectAttributes) {
    // sicmedStanderprescriptionAskedService.delete(sicmedStanderprescriptionAsked);
    // addMessage(redirectAttributes, "删除保存成功成功");
    // return "redirect:" + Global.getAdminPath() +
    // "/rest/sicmedStanderprescriptionAsked/?repage";
    // }

}