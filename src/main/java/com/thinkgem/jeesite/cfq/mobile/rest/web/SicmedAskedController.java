package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
import org.apache.velocity.VelocityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedAskedBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedAskedBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedAskedClassBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCMedicalUseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalUseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.AskedPrintBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.CheckPrintBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.CurePrintBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.InspectPrintBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.MedicalPrintBean;
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
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedTwxrayCheck;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedUser;
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
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedTwxrayCheckService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedUserService;
import com.thinkgem.jeesite.cfq.mobile.rest.setBean.SicmedAskedSetBean;
import com.thinkgem.jeesite.cfq.mobile.rest.setBean.SicmedMedicalUseSetBean;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.DateTimeUtils;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.SsidUtils;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.VelocityUtil;

/**
 * 医嘱信息Controller
 *
 * @author Max
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedAsked")
public class SicmedAskedController extends BaseController {

    @Autowired
    private SicmedAskedService sicmedAskedService;

    @Autowired
    private SicmedAskedClassService sicmedAskedClassService;

    @Autowired
    private SicmedCaseService sicmedCaseService;

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
    private SicmedPatientService sicmedPatientService;

    @Autowired
    private SicmedMedicalUseService sicmedMedicalUseService;

    @Autowired
    private SicmedRegisteredService sicmedRegisteredService;

    @Autowired
    private SicmedUserService sicmedUserService;

    /**
     * 添加医嘱
     *
     * @param sicmedAskedBean
     * @param sicmedMedicalUseBean
     * @param askedClassId
     * @param caseId
     * @param patientId
     * @return BaseBean
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "add")
    public BaseBean add(SicmedAskedBean sicmedAskedBean, String askedClassId, String caseId, String patientId,
                        SicmedMedicalUseBean sicmedMedicalUseBean) {

        // 传入参数校验
        if (!AppParameterSimulation.simulationId(askedClassId) || !AppParameterSimulation.simulationId(caseId)
                || !AppParameterSimulation.simulationId(patientId)
                || !AppParameterSimulation.simulationId(sicmedAskedBean.getOrderCode())) {
            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;
        }
        // 创建添加对象
        SicmedAsked sicmedAsked = SicmedAskedSetBean.setAsked(sicmedAskedBean, null);
        // 获取医嘱类别
        SicmedAskedClass sicmedAskedClass = new SicmedAskedClass();
        sicmedAskedClass.setId(askedClassId);
        sicmedAskedClass = sicmedAskedClassService.get(sicmedAskedClass);
        // 获取病历信息
        SicmedCase sicmedCase = new SicmedCase();
        sicmedCase.setId(caseId);
        sicmedCase = sicmedCaseService.get(sicmedCase);
        // 添加医嘱所属类别
        sicmedAsked.setSicmedAskedClass(sicmedAskedClass);
        // 添加医嘱所属病历
        sicmedAsked.setSicmedCase(sicmedCase);

        // 校验 是否是重复医嘱
        if (sicmedAskedService.getOnly(sicmedAsked) != null) {
            sicmedAskedBean.setError("1");
            sicmedAskedBean.setErrorMessage("医嘱中已经存在此类处理项目不能重复添加");
            return sicmedAskedBean;
        }
        // 获取患者信息
        SicmedPatient sicmedPatient = new SicmedPatient();
        sicmedPatient.setId(patientId);
        sicmedPatient = sicmedPatientService.get(sicmedPatient);

        // 创建患者价格明细对象
        SicmedPatientPrice sicmedPatientPrice = new SicmedPatientPrice();
        // 向患者价格明细表对象中添加患者属性
        sicmedPatientPrice.setSicmedPatient(sicmedPatient);
        sicmedPatientPrice.setIsPay("0");

        // 获取医嘱类别编号
        String classNumber = sicmedAskedClass.getClassNumber();
        // 向患者价格明细对象中添加价格类别编号
        sicmedPatientPrice.setPriceClassType(classNumber);
        // 类别编码转Int
        int a = Integer.parseInt(classNumber);
        // 根据医嘱类别获取医嘱中项目信息
        switch (a) {
            case 0:
                // 获取检查项目信息
                SicmedTwxrayCheck sicmedTwxrayCheck = sicmedTwxrayCheckService.get(sicmedAskedBean.getOrderCode());

                SicmedCheckPrice sicmedCheckPrice = new SicmedCheckPrice();
                sicmedCheckPrice.setSicmedTwxrayCheck(sicmedTwxrayCheck);
                // 获取检查项目价格信息
                sicmedCheckPrice = sicmedCheckPriceService.getByEntity(sicmedCheckPrice);
                sicmedPatientPrice.setPriceCode(sicmedCheckPrice.getId());

                // 设置医嘱名称
                sicmedAsked.setAskedName(sicmedTwxrayCheck.getCheckName());
                break;
            case 1:
                // 获取检验项目信息
                SicmedInspect sicmedInspect = sicmedInspectService.get(sicmedAskedBean.getOrderCode());
                SicmedInspectPrice sicmedInspectPrice = new SicmedInspectPrice();
                sicmedInspectPrice.setSicmedInspect(sicmedInspect);
                // 获取检验项目价格信息
                sicmedInspectPrice = sicmedInspectPriceService.getByEntity(sicmedInspectPrice);
                sicmedPatientPrice.setPriceCode(sicmedInspectPrice.getId());

                // 设置医嘱名称
                sicmedAsked.setAskedName(sicmedInspect.getInspectName());
                break;
            case 2:
                // 获取治疗项目信息
                SicmedCureCheck sicmedCureCheck = sicmedCureCheckService.get(sicmedAskedBean.getOrderCode());
                SicmedCurePrice sicmedCurePrice = new SicmedCurePrice();
                sicmedCurePrice.setSicmedCureCheck(sicmedCureCheck);
                // 获取治疗项目价格信息
                sicmedCurePrice = sicmedCurePriceService.getByEntity(sicmedCurePrice);
                sicmedPatientPrice.setPriceCode(sicmedCurePrice.getId());

                // 设置医嘱名称
                sicmedAsked.setAskedName(sicmedCureCheck.getCureName());
                break;
            case 3:
                // 获取药品信息
                SicmedMedical sicmedMedical = new SicmedMedical();
                sicmedMedical.setId(sicmedAskedBean.getOrderCode());
                sicmedMedical = sicmedMedicalService.get(sicmedMedical);
                SicmedMedicalPrice sicmedMedicalPrice = new SicmedMedicalPrice();
                sicmedMedicalPrice.setSicmedMedical(sicmedMedical);
                // 获取药品价格信息
                sicmedMedicalPrice = sicmedMedicalPriceService.getMedicalPrice(sicmedMedicalPrice);
                sicmedPatientPrice.setPriceCode(sicmedMedicalPrice.getId());
                // 设置医嘱名称
                sicmedAsked.setAskedName(sicmedMedical.getMedicalNameChina());
                // 校验药品用法
                if (AppParameterSimulation.isEmpty(sicmedMedicalUseBean.getUseUnit())) {
                    sicmedAskedBean.setError("1");
                    sicmedAskedBean.setErrorMessage("药品用法为必填项");
                    return sicmedAskedBean;
                } else {
                    // 创建药品用法
                    SicmedMedicalUse sicmedMedicalUse = SicmedMedicalUseSetBean.setSMUB(sicmedMedicalUseBean, null);
                    // 保存药品用法
                    sicmedMedicalUseService.save(sicmedMedicalUse);
                    // 获取保存的药品用法
                    sicmedMedicalUse = sicmedMedicalUseService.get(sicmedMedicalUse);
                    // 药品医嘱中添加药品用法
                    sicmedAsked.setSicmedMedicalUse(sicmedMedicalUse);
                }
                break;
            case 4:
                // 获取嘱托信息

                break;
            default:
                break;
        }
        // 添加患者价格明细表
        sicmedPatientPriceService.save(sicmedPatientPrice);
        if (a == 3) {
            sicmedAsked.setSicmedPatientPrice(sicmedPatientPrice);
            sicmedAsked.setAskedCode(DateTimeUtils.getCurrentTime());
            sicmedAskedService.save(sicmedAsked);

            sicmedAskedBean.setSAB(sicmedAskedService.get(sicmedAsked));
        } else {
            sicmedAsked.setSicmedPatientPrice(sicmedPatientPrice);
            sicmedAskedService.save(sicmedAsked);
        }

        sicmedAskedBean.setError("0");
        sicmedAskedBean.setErrorMessage("添加医嘱成功");
        // --------------------更改挂号状态开始-------------------
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        sicmedRegistered.setSicmedPatient(sicmedPatient);
        sicmedRegistered = sicmedRegisteredService.getByP(sicmedRegistered);
        if (!sicmedRegistered.getRegisteredStatus().equals("2")) {
            sicmedRegistered.setRegisteredStatus("2");
            sicmedRegisteredService.update(sicmedRegistered);
        }
        // --------------------更改挂号状态结束-------------------

        return sicmedAskedBean;
    }

    /**
     * 添加中药医嘱
     *
     * @param sicmedAskedBean
     * @param sicmedMedicalUseBean
     * @param askedClassId
     * @param caseId
     * @param patientId
     * @return BaseBean
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "addCMedAsked")
    public BaseBean addCMedAsked(HttpServletRequest request, String caseId, String patientId, SicmedCMedicalUseBean sicmedCMedicalUseBean) {
        //1.创建返回对象
        SicmedAskedBean sicmedAskedBean = new SicmedAskedBean();
        //2.传入参数校验
        if (!AppParameterSimulation.simulationId(caseId)) {
            sicmedAskedBean.setError("0");
            sicmedAskedBean.setErrorMessage("病历ID为空");
            return sicmedAskedBean;
        } else if (!AppParameterSimulation.simulationId(patientId)) {
            sicmedAskedBean.setError("0");
            sicmedAskedBean.setErrorMessage("患者ID为空");
            return sicmedAskedBean;
        }
        //3.获取医嘱类别
        SicmedAskedClass sicmedAskedClass = new SicmedAskedClass();
        sicmedAskedClass.setClassNumber("3");
        sicmedAskedClass = sicmedAskedClassService.get(sicmedAskedClass);
        //4.获取病历信息
        SicmedCase sicmedCase = sicmedCaseService.get(caseId);
        //5.获取患者信息
        SicmedPatient sicmedPatient = sicmedPatientService.get(patientId);

        //6.创建中药用法对象
        SicmedMedicalUse sicmedMedicalUse = new SicmedMedicalUse();

        //7.中药用法对象赋值
        sicmedMedicalUse.setUseGroup(sicmedCMedicalUseBean.getUseType());
        sicmedMedicalUse.setUseBun(sicmedCMedicalUseBean.getUseTime());
//		sicmedMedicalUse.setUseBout(sicmedCMedicalUseBean.get);
//		sicmedMedicalUse.setUseName(useName);
//		sicmedMedicalUse.setRemarks(remarks);
        // 保存药品用法
        sicmedMedicalUseService.save(sicmedMedicalUse);
        // 获取保存的药品用法
        sicmedMedicalUse = sicmedMedicalUseService.get(sicmedMedicalUse);
        //8.调用service保存中药用法
        sicmedMedicalUseService.save(sicmedMedicalUse);
        //9.获取中药信息
        String allZhMedical = request.getParameter("allZhMedical");
        logger.debug(allZhMedical);
        JSONArray dailyList = new JSONArray(allZhMedical);
        //10.分别保存各中药信息
        for (int i = 0, j = dailyList.length(); i < j; i++) {
            SicmedAsked sicmedAsked = new SicmedAsked();
            JSONObject object = (JSONObject) dailyList.get(i);
            String id = (String) object.get("id");
            String useInfor = (String) object.get("useInfor");
            String count = (String) object.get("count");
            logger.debug(id + "---" + useInfor + "---" + count);
            // 添加医嘱所属类别
            sicmedAsked.setSicmedAskedClass(sicmedAskedClass);
            // 添加医嘱所属病历
            sicmedAsked.setSicmedCase(sicmedCase);
            // 获取药品信息
            SicmedMedical sicmedMedical = sicmedMedicalService.get(id);
            // 设置医嘱名称
            sicmedAsked.setAskedName(sicmedMedical.getMedicalNameChina());
            SicmedMedicalPrice sicmedMedicalPrice = new SicmedMedicalPrice();
            sicmedMedicalPrice.setSicmedMedical(sicmedMedical);
            // 获取药品价格信息
            sicmedMedicalPrice = sicmedMedicalPriceService.getMedicalPrice(sicmedMedicalPrice);
            // 创建患者价格明细对象
            SicmedPatientPrice sicmedPatientPrice = new SicmedPatientPrice();
            // 向患者价格明细表对象中添加患者属性
            sicmedPatientPrice.setSicmedPatient(sicmedPatient);
            sicmedPatientPrice.setIsPay("0");
            // 向患者价格明细对象中添加价格类别编号
            sicmedPatientPrice.setPriceClassType("3");
            sicmedPatientPrice.setPriceCode(sicmedMedicalPrice.getId());
            // 添加患者价格明细表
            sicmedPatientPriceService.save(sicmedPatientPrice);

            sicmedAsked.setOrderCode(id);
            sicmedAsked.setSicmedPatientPrice(sicmedPatientPrice);
            sicmedAsked.setAskedCode(DateTimeUtils.getCurrentTime());

            sicmedAsked.setSicmedMedicalUse(sicmedMedicalUse);
            sicmedAsked.setAskedGroup(sicmedMedicalUse.getId());
            sicmedAskedService.save(sicmedAsked);
            sicmedAskedBean.setSAB(sicmedAskedService.get(sicmedAsked));
        }
        // --------------------更改挂号状态开始-------------------
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        sicmedRegistered.setSicmedPatient(sicmedPatient);
        sicmedRegistered = sicmedRegisteredService.getByP(sicmedRegistered);
        if (!sicmedRegistered.getRegisteredStatus().equals("2")) {
            sicmedRegistered.setRegisteredStatus("2");
            sicmedRegisteredService.update(sicmedRegistered);
        }
        // --------------------更改挂号状态结束-------------------

        sicmedAskedBean.setError("0");
        sicmedAskedBean.setErrorMessage("添加医嘱成功");

        return sicmedAskedBean;
    }

    /**
     * 根据患者查询医嘱
     *
     * @param caseId
     * @param patientId
     * @param askedClassId
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "findByPatient")
    public BaseBean findByPatient(@RequestParam(required = false) String caseId,
                                  @RequestParam(required = false) String patientId, @RequestParam(required = false) String askedClassId) {

        if (!AppParameterSimulation.simulationId(patientId) || !AppParameterSimulation.simulationId(askedClassId)) {

            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;
        }

        SicmedAskedBeans sicmedAskedBeans = new SicmedAskedBeans();
        SicmedAsked sicmedAsked = new SicmedAsked();
        if (!AppParameterSimulation.simulationId(caseId)) {
            sicmedAskedBeans.setError("1");
            sicmedAskedBeans.setErrorMessage("输入的病历ID不正确");
            return sicmedAskedBeans;
        }
        SicmedCase sicmedCase = sicmedCaseService.get(caseId);
        if (sicmedCase == null) {
            sicmedAskedBeans.setError("1");
            sicmedAskedBeans.setErrorMessage("病历不存在!");
            return sicmedAskedBeans;
        }
        sicmedAsked.setSicmedCase(sicmedCase);

        List<SicmedAsked> sicmedAskedes = sicmedAskedService.findList(sicmedAsked);

        if (sicmedAskedes.size() != 0) {
            for (SicmedAsked sicmedAsked2 : sicmedAskedes) {
                // 获取医嘱项目
                String classNumber = sicmedAsked2.getSicmedAskedClass().getClassNumber();

                SicmedAskedBean sicmedAskedBean = new SicmedAskedBean();
                // 检查
                if (classNumber.equals("0")) {
                    SicmedTwxrayCheck sicmedTwxrayCheck = sicmedTwxrayCheckService.get(sicmedAsked2.getOrderCode());
                    sicmedAskedBean.getSicmedTwxrayCheckBean().setSTCB(sicmedTwxrayCheck);
                }
                // 检验
                else if (classNumber.equals("1")) {
                    SicmedInspect sicmedInspect = sicmedInspectService.get(sicmedAsked2.getOrderCode());
                    sicmedAskedBean.getSicmedInspectBean().setSIB(sicmedInspect);
                }
                // 治疗
                else if (classNumber.equals("2")) {
                    SicmedCureCheck sicmedCureCheck = sicmedCureCheckService.get(sicmedAsked2.getOrderCode());
                    sicmedAskedBean.getSicmedCureCheckBean().setSCCB(sicmedCureCheck);
                }
                // 药品
                else if (classNumber.equals("3")) {
                    SicmedMedical sicmedMedical = sicmedMedicalService.get(sicmedAsked2.getOrderCode());
                    sicmedAskedBean.getSicmedMedicalBean().setSMB(sicmedMedical);
                }
                // 嘱托
                else if (classNumber.equals("4")) {
                }
                sicmedAskedBean.setSAB(sicmedAsked2);
                sicmedAskedBeans.getSicmedAskedBeans().add(sicmedAskedBean);
            }
            sicmedAskedBeans.setError("0");
            sicmedAskedBeans.setErrorMessage("请求成功");
        } else {
            sicmedAskedBeans.setError("0");
            sicmedAskedBeans.setErrorMessage("病历下还没有医嘱");
        }
        return sicmedAskedBeans;
    }

    /**
     * 根据病历查询医嘱信息
     *
     * @param caseId
     * @return BaseBean
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "findByCase")
    public BaseBean findByCase(@RequestParam(required = false) String caseId) {

        SicmedAskedBeans sicmedAskedBeans = new SicmedAskedBeans();
        // 判断传入参数
        if (!AppParameterSimulation.simulationId(caseId)) {
            sicmedAskedBeans.setError("1");
            sicmedAskedBeans.setErrorMessage("输入的病历ID不正确");
            return sicmedAskedBeans;
        }
        // 创建查询条件
        SicmedAsked sicmedAsked = new SicmedAsked();
        // 获取查询条件属性
        SicmedCase sicmedCase = sicmedCaseService.get(caseId);
        // 判断查询条件属性
        if (sicmedCase == null) {
            sicmedAskedBeans.setError("1");
            sicmedAskedBeans.setErrorMessage("病历不存在!");
            return sicmedAskedBeans;
        }
        // 为查询条件赋值
        sicmedAsked.setSicmedCase(sicmedCase);
        // 根据查询添加查询医嘱信息
        List<SicmedAsked> sicmedAskedes = sicmedAskedService.findList(sicmedAsked);
        // 创建空的返回结果

        SicmedAskedBean sicmedTwxrayCheckAskedBean = new SicmedAskedBean();
        SicmedAskedBean sicmedCureCheckAskedBean = new SicmedAskedBean();
        SicmedAskedBean sicmedInspectAskedBean = new SicmedAskedBean();
        SicmedAskedBean sicmedMedicalAskedBean = new SicmedAskedBean();

        SicmedAskedClassBean sicmedAskedClassBean = new SicmedAskedClassBean();

        SicmedAskedClass sicmedAskedClass = new SicmedAskedClass();
        List<SicmedAskedClass> sicmedAskedClasses = sicmedAskedClassService.findList(sicmedAskedClass);
        for (SicmedAskedClass sicmedAskedClass2 : sicmedAskedClasses) {
            switch (Integer.parseInt(sicmedAskedClass2.getClassNumber())) {
                case 0:
                    sicmedAsked.setSicmedAskedClass(sicmedAskedClass2);
                    sicmedTwxrayCheckAskedBean.setSAB(sicmedAsked);
                    sicmedAskedClassBean.setSac(sicmedAsked.getSicmedAskedClass());
                    sicmedTwxrayCheckAskedBean.setSicmedAskedClassBean(sicmedAskedClassBean);
                    sicmedAskedBeans.getSicmedAskedBeans().add(sicmedTwxrayCheckAskedBean);
                    break;
                case 1:
                    sicmedAsked.setSicmedAskedClass(sicmedAskedClass2);
                    sicmedCureCheckAskedBean.setSAB(sicmedAsked);
                    sicmedAskedClassBean.setSac(sicmedAsked.getSicmedAskedClass());
                    sicmedCureCheckAskedBean.setSicmedAskedClassBean(sicmedAskedClassBean);
                    sicmedAskedBeans.getSicmedAskedBeans().add(sicmedCureCheckAskedBean);
                    break;
                case 2:
                    sicmedAsked.setSicmedAskedClass(sicmedAskedClass2);
                    sicmedInspectAskedBean.setSAB(sicmedAsked);
                    sicmedAskedClassBean.setSac(sicmedAsked.getSicmedAskedClass());
                    sicmedInspectAskedBean.setSicmedAskedClassBean(sicmedAskedClassBean);
                    sicmedAskedBeans.getSicmedAskedBeans().add(sicmedInspectAskedBean);
                    break;
                case 3:
                    sicmedAsked.setSicmedAskedClass(sicmedAskedClass2);
                    sicmedMedicalAskedBean.setSAB(sicmedAsked);
                    sicmedAskedClassBean.setSac(sicmedAsked.getSicmedAskedClass());
                    sicmedMedicalAskedBean.setSicmedAskedClassBean(sicmedAskedClassBean);
                    SicmedMedicalUseBean sicmedMedicalUseBean = new SicmedMedicalUseBean();
                    sicmedMedicalUseBean.setSMUB(sicmedAsked.getSicmedMedicalUse());
                    sicmedMedicalAskedBean.setSicmedMedicalUseBean(sicmedMedicalUseBean);
                    sicmedAskedBeans.getSicmedAskedBeans().add(sicmedMedicalAskedBean);
                    break;
                default:
                    break;
            }
        }
        // 判断查询结果
        if (sicmedAskedes.size() != 0) {
            // 查询结果不为空 遍历查询结果
            for (SicmedAsked sicmedAsked2 : sicmedAskedes) {
                // 获取医嘱项目
                String classNumber = sicmedAsked2.getSicmedAskedClass().getClassNumber();

                SicmedAskedBean sicmedAskedBean = new SicmedAskedBean();
                switch (Integer.parseInt(classNumber)) {
                    case 0:// 检查
                        sicmedAskedBeans.getSicmedAskedBeans().remove(sicmedTwxrayCheckAskedBean);
                        sicmedAskedBean.setSAB(sicmedAsked2);
                        SicmedTwxrayCheck sicmedTwxrayCheck = sicmedTwxrayCheckService.get(sicmedAsked2.getOrderCode());
                        sicmedAskedBean.getSicmedTwxrayCheckBean().setSTCB(sicmedTwxrayCheck);
                        sicmedAskedBeans.getSicmedAskedBeans().add(sicmedAskedBean);
                        break;
                    case 1:// 检验
                        sicmedAskedBeans.getSicmedAskedBeans().remove(sicmedCureCheckAskedBean);
                        sicmedAskedBean.setSAB(sicmedAsked2);
                        SicmedInspect sicmedInspect = sicmedInspectService.get(sicmedAsked2.getOrderCode());
                        sicmedAskedBean.getSicmedInspectBean().setSIB(sicmedInspect);
                        sicmedAskedBeans.getSicmedAskedBeans().add(sicmedAskedBean);
                        break;
                    case 2:// 治疗
                        sicmedAskedBeans.getSicmedAskedBeans().remove(sicmedInspectAskedBean);
                        sicmedAskedBean.setSAB(sicmedAsked2);
                        SicmedCureCheck sicmedCureCheck = sicmedCureCheckService.get(sicmedAsked2.getOrderCode());
                        sicmedAskedBean.getSicmedCureCheckBean().setSCCB(sicmedCureCheck);
                        sicmedAskedBeans.getSicmedAskedBeans().add(sicmedAskedBean);
                        break;
                    case 3:// 药品
                        sicmedAskedBeans.getSicmedAskedBeans().remove(sicmedMedicalAskedBean);
                        sicmedAskedBean.setSAB(sicmedAsked2);
                        SicmedMedical sicmedMedical = sicmedMedicalService.get(sicmedAsked2.getOrderCode());
                        sicmedAskedBean.getSicmedMedicalBean().setSMB(sicmedMedical);
                        sicmedAskedBeans.getSicmedAskedBeans().add(sicmedAskedBean);
                        break;
                    case 4://
                        break;
                    default:
                        break;
                }
            }
            sicmedAskedBeans.setError("0");
            sicmedAskedBeans.setErrorMessage("请求成功");
        } else {
            // 查询结果为空
            sicmedAskedBeans.setError("0");
            sicmedAskedBeans.setErrorMessage("病历下还没有医嘱");
        }
        return sicmedAskedBeans;
    }

    /**
     * 根据病历查询医嘱信息
     *
     * @param caseId
     * @return BaseBean
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "findByAskedGroup")
    public BaseBean findByAskedGroup(@RequestParam(required = false) String askedGroup) {

        SicmedAskedBeans sicmedAskedBeans = new SicmedAskedBeans();
        // 判断传入参数
        if (!AppParameterSimulation.simulationId(askedGroup)) {
            sicmedAskedBeans.setError("1");
            sicmedAskedBeans.setErrorMessage("输入的病历ID不正确");
            return sicmedAskedBeans;
        }
        // 创建查询条件
        SicmedAsked sicmedAsked = new SicmedAsked();
        // 为查询条件赋值
        sicmedAsked.setAskedGroup(askedGroup);
        // 根据查询添加查询医嘱信息
        List<SicmedAsked> sicmedAskedes = sicmedAskedService.findList(sicmedAsked);

        // 判断查询结果
        if (sicmedAskedes.size() != 0) {
            // 查询结果不为空 遍历查询结果
            for (SicmedAsked sicmedAsked2 : sicmedAskedes) {
                // 获取医嘱项目
                SicmedAskedBean sicmedAskedBean = new SicmedAskedBean();
                sicmedAskedBean.setSAB(sicmedAsked2);
                SicmedMedical sicmedMedical = sicmedMedicalService.get(sicmedAsked2.getOrderCode());
                SicmedMedicalBean sicmedMedicalBean = new SicmedMedicalBean();
                sicmedMedicalBean.setSMB(sicmedMedical);
                sicmedAskedBean.setSicmedMedicalBean(sicmedMedicalBean);

                sicmedAskedBeans.getSicmedAskedBeans().add(sicmedAskedBean);
            }
            sicmedAskedBeans.setError("0");
            sicmedAskedBeans.setErrorMessage("请求成功");
        } else {
            // 查询结果为空
            sicmedAskedBeans.setError("0");
            sicmedAskedBeans.setErrorMessage("病历下还没有医嘱");
        }
        return sicmedAskedBeans;
    }

    /**
     * 根据医嘱类别查询医嘱信息
     */
    @ResponseBody
    @RequestMapping(value = "findByCaseAndClass")
    public BaseBean findByCaseAndClass(@RequestParam(required = false) String caseId,
                                       @RequestParam(required = false) String askedClassId) {

        SicmedAskedBeans sicmedAskedBeans = new SicmedAskedBeans();
        // 判断传入参数
        if (!AppParameterSimulation.simulationId(caseId) || !AppParameterSimulation.simulationId(askedClassId)) {
            sicmedAskedBeans.setError("1");
            sicmedAskedBeans.setErrorMessage("输入的ID不正确");
            return sicmedAskedBeans;
        }
        // 创建查询条件
        SicmedAsked sicmedAsked = new SicmedAsked();
        // 获取查询条件属性
        SicmedCase sicmedCase = sicmedCaseService.get(caseId);
        SicmedAskedClass sicmedAskedClass = sicmedAskedClassService.get(askedClassId);
        // 判断查询条件属性
        if (sicmedCase == null) {
            sicmedAskedBeans.setError("1");
            sicmedAskedBeans.setErrorMessage("病历不存在!");
            return sicmedAskedBeans;
        }
        // 为查询条件赋值
        sicmedAsked.setSicmedCase(sicmedCase);
        sicmedAsked.setSicmedAskedClass(sicmedAskedClass);
        // 根据查询添加查询医嘱信息
        List<SicmedAsked> sicmedAskedes = sicmedAskedService.findList(sicmedAsked);
        // 判断查询结果
        if (sicmedAskedes.size() != 0) {
            // 查询结果不为空 遍历查询结果
            for (SicmedAsked sicmedAsked2 : sicmedAskedes) {
                // 获取医嘱项目
                String classNumber = sicmedAsked2.getSicmedAskedClass().getClassNumber();

                SicmedAskedBean sicmedAskedBean = new SicmedAskedBean();
                switch (Integer.parseInt(classNumber)) {
                    case 0:// 检查
                        sicmedAskedBean.setSAB(sicmedAsked2);
                        SicmedTwxrayCheck sicmedTwxrayCheck = sicmedTwxrayCheckService.get(sicmedAsked2.getOrderCode());
                        sicmedAskedBean.getSicmedTwxrayCheckBean().setSTCB(sicmedTwxrayCheck);
                        sicmedAskedBeans.getSicmedAskedBeans().add(sicmedAskedBean);
                        break;
                    case 1:// 检验
                        sicmedAskedBean.setSAB(sicmedAsked2);
                        SicmedInspect sicmedInspect = sicmedInspectService.get(sicmedAsked2.getOrderCode());
                        sicmedAskedBean.getSicmedInspectBean().setSIB(sicmedInspect);
                        sicmedAskedBeans.getSicmedAskedBeans().add(sicmedAskedBean);
                        break;
                    case 2:// 治疗
                        sicmedAskedBean.setSAB(sicmedAsked2);
                        SicmedCureCheck sicmedCureCheck = sicmedCureCheckService.get(sicmedAsked2.getOrderCode());
                        sicmedAskedBean.getSicmedCureCheckBean().setSCCB(sicmedCureCheck);
                        sicmedAskedBeans.getSicmedAskedBeans().add(sicmedAskedBean);
                        break;
                    case 3:// 药品
                        sicmedAskedBean.setSAB(sicmedAsked2);
                        SicmedMedical sicmedMedical = sicmedMedicalService.get(sicmedAsked2.getOrderCode());
                        sicmedAskedBean.getSicmedMedicalBean().setSMB(sicmedMedical);
                        sicmedAskedBeans.getSicmedAskedBeans().add(sicmedAskedBean);
                        sicmedAskedBean.getSicmedMedicalUseBean()
                                .setSMUB(sicmedMedicalUseService.get(sicmedAsked2.getSicmedMedicalUse()));
                        break;
                    case 4://
                        break;
                    default:
                        break;
                }
            }
            sicmedAskedBeans.setError("0");
            sicmedAskedBeans.setErrorMessage("请求成功");
        } else {
            // 查询结果为空
            sicmedAskedBeans.setError("1");
            sicmedAskedBeans.setErrorMessage("暂无医嘱信息");
        }
        return sicmedAskedBeans;
    }

    /**
     * 根据ID查询医嘱详细信息
     *
     * @param id
     * @return BaseBean
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "getById")
    public BaseBean getById(@RequestParam(required = false) String id) {

        if (!AppParameterSimulation.simulationId(id)) {
            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;
        }

        SicmedAskedBean sicmedAskedBean = new SicmedAskedBean();
        SicmedAsked sicmedAsked = sicmedAskedService.get(id);

        int a = Integer.parseInt(sicmedAsked.getSicmedAskedClass().getClassNumber());

        switch (a) {
            case 0:
                sicmedAskedBean.getSicmedTwxrayCheckBean().setSTCB(sicmedTwxrayCheckService.get(sicmedAsked.getOrderCode()));
                break;
            case 1:
                sicmedAskedBean.getSicmedInspectBean().setSIB(sicmedInspectService.get(sicmedAsked.getOrderCode()));
                break;
            case 2:
                sicmedAskedBean.getSicmedCureCheckBean().setSCCB(sicmedCureCheckService.get(sicmedAsked.getOrderCode()));
                break;
            case 3:
                sicmedAskedBean.getSicmedMedicalBean().setSMB(sicmedMedicalService.get(sicmedAsked.getOrderCode()));
                sicmedAskedBean.getSicmedMedicalUseBean().setSMUB(sicmedAsked.getSicmedMedicalUse());
                break;
            default:
                break;
        }
        sicmedAskedBean.getSicmedAskedClassBean().setSac(sicmedAsked.getSicmedAskedClass());
        sicmedAskedBean.setSAB(sicmedAsked);
        sicmedAskedBean.setError("0");
        sicmedAskedBean.setErrorMessage("查找成功");
        return sicmedAskedBean;

    }

    /**
     * 根据Id修改医嘱
     *
     * @param sicmedAskedBean
     * @param sicmedasked
     * @return BaseBean
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "update")
    public BaseBean update(SicmedAskedBean sicmedAskedBean) {

        if (AppParameterSimulation.simulationId(sicmedAskedBean.getId())
                || !AppParameterSimulation.AskedId(sicmedAskedBean.getAskedCode())
                || !AppParameterSimulation.simulationId(sicmedAskedBean.getOrderCode())
                || !AppParameterSimulation.simulationName(sicmedAskedBean.getAskedName())) {

            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;
        }

        SicmedAsked sicmedAsked = sicmedAskedService.get(sicmedAskedBean.getId());
        sicmedAsked = SicmedAskedSetBean.setAsked(sicmedAskedBean, sicmedAsked);

        // 获取与医嘱对应的患者价格明细对象
        SicmedPatientPrice sicmedPatientPrice = sicmedPatientPriceService
                .get(sicmedAsked.getSicmedPatientPrice().getId());

        // 获取医嘱类别编号
        String classNumber = sicmedAsked.getSicmedAskedClass().getClassNumber();
        // 向患者价格明细对象中添加价格类别编号
        sicmedPatientPrice.setPriceClassType(classNumber);
        // 类别编码转Int
        int a = Integer.parseInt(classNumber);
        // 根据医嘱类别获取医嘱中项目信息
        switch (a) {
            case 0:
                // 获取检查项目信息
                SicmedTwxrayCheck sicmedTwxrayCheck = sicmedTwxrayCheckService.get(sicmedAskedBean.getOrderCode());
                SicmedCheckPrice sicmedCheckPrice = new SicmedCheckPrice();
                sicmedCheckPrice.setSicmedTwxrayCheck(sicmedTwxrayCheck);
                // 获取检查项目价格信息
                sicmedCheckPrice = sicmedCheckPriceService.getByEntity(sicmedCheckPrice);
                sicmedPatientPrice.setPriceCode(sicmedCheckPrice.getId());
                break;
            case 1:
                // 获取检验项目信息
                SicmedInspect sicmedInspect = sicmedInspectService.get(sicmedAskedBean.getOrderCode());
                SicmedInspectPrice sicmedInspectPrice = new SicmedInspectPrice();
                sicmedInspectPrice.setSicmedInspect(sicmedInspect);
                // 获取检验项目价格信息
                sicmedInspectPrice = sicmedInspectPriceService.getByEntity(sicmedInspectPrice);
                sicmedPatientPrice.setPriceCode(sicmedInspectPrice.getId());
                break;
            case 2:
                // 获取治疗项目信息
                SicmedCureCheck sicmedCureCheck = sicmedCureCheckService.get(sicmedAskedBean.getOrderCode());
                SicmedCurePrice sicmedCurePrice = new SicmedCurePrice();
                sicmedCurePrice.setSicmedCureCheck(sicmedCureCheck);
                // 获取治疗项目价格信息
                sicmedCurePrice = sicmedCurePriceService.getByEntity(sicmedCurePrice);
                sicmedPatientPrice.setPriceCode(sicmedCurePrice.getId());
                break;
            case 3:
                // 获取药品信息
                SicmedMedical sicmedMedical = sicmedMedicalService.get(sicmedAskedBean.getOrderCode());
                SicmedMedicalPrice sicmedMedicalPrice = new SicmedMedicalPrice();
                sicmedMedicalPrice.setSicmedMedical(sicmedMedical);
                // 获取药品价格信息
                sicmedMedicalPrice = sicmedMedicalPriceService.getMedicalPrice(sicmedMedicalPrice);
                sicmedPatientPrice.setPriceCode(sicmedMedicalPrice.getId());
                break;
            case 4:
                // 获取嘱托信息

                break;
            default:
                break;
        }
        sicmedPatientPriceService.update(sicmedPatientPrice);
        sicmedAsked.setSicmedPatientPrice(sicmedPatientPrice);
        sicmedAskedService.update(sicmedAsked);
        sicmedAskedBean.setError("0");
        sicmedAskedBean.setErrorMessage("修改医嘱成功");

        return sicmedAskedBean;
    }

    /**
     * 删除医嘱
     *
     * @param id
     * @return 提示是否删除成功
     */
    @ResponseBody
    @RequestMapping(value = "delete")
    public BaseBean delete(String id) {

        BaseBean baseBean = new BaseBean();
        if (AppParameterSimulation.simulationId(id)) {
            SicmedAsked sicmedAsked = sicmedAskedService.get(id);
            if (sicmedAsked != null) {
                SicmedPatientPrice sicmedPatientPrice = new SicmedPatientPrice();
                sicmedPatientPrice = sicmedAsked.getSicmedPatientPrice();
                sicmedPatientPriceService.delete(sicmedPatientPrice);
                sicmedAskedService.delete(sicmedAsked);
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

    /**
     * 获取医嘱打印信息
     */
    @ResponseBody
    @RequestMapping(value = "askedPrint")
    public BaseBean printAsked(String caseId, String ssid) {

        AskedPrintBean askedPrintBean = new AskedPrintBean();
        // 判断传入参数
        if (AppParameterSimulation.isEmpty(caseId)) {
            askedPrintBean.setError("1");
            askedPrintBean.setErrorMessage("输入参数为空");
            return askedPrintBean;
        } else if (!AppParameterSimulation.simulationId(caseId)) {
            askedPrintBean.setError("1");
            askedPrintBean.setErrorMessage("输入的病历ID不正确");
            return askedPrintBean;
        }
        // 创建查询条件
        SicmedAsked sicmedAsked = new SicmedAsked();
        // 获取查询条件属性
        SicmedCase sicmedCase = sicmedCaseService.get(caseId);
        // 判断查询条件属性
        if (sicmedCase == null) {
            askedPrintBean.setError("1");
            askedPrintBean.setErrorMessage("病历不存在!");
            return askedPrintBean;
        }
        SicmedPatientBean sicmedPatientBean = new SicmedPatientBean();
        sicmedPatientBean.setSP(sicmedCase.getSicmedPatient());
        askedPrintBean.setSicmedPatientBean(sicmedPatientBean);
        // 为查询条件赋值
        sicmedAsked.setSicmedCase(sicmedCase);
        // 根据查询添加查询医嘱信息
        List<SicmedAsked> sicmedAskedes = sicmedAskedService.findList(sicmedAsked);
        // 创建空的返回结果

        // 判断查询结果
        if (sicmedAskedes.size() != 0) {
            // 查询结果不为空 遍历查询结果
            for (SicmedAsked sicmedAsked2 : sicmedAskedes) {
                // 获取医嘱项目
                String classNumber = sicmedAsked2.getSicmedAskedClass().getClassNumber();
                switch (Integer.parseInt(classNumber)) {
                    case 0:// 检查
                        CheckPrintBean checkPrintBean = new CheckPrintBean();
                        SicmedTwxrayCheck sicmedTwxrayCheck = sicmedTwxrayCheckService.get(sicmedAsked2.getOrderCode());
                        checkPrintBean.setCPB(sicmedTwxrayCheck);
                        askedPrintBean.getCheckPrintBean().add(checkPrintBean);
                        break;
                    case 1:// 检验
                        InspectPrintBean inspectPrintBean = new InspectPrintBean();
                        SicmedInspect sicmedInspect = sicmedInspectService.get(sicmedAsked2.getOrderCode());
                        inspectPrintBean.setIPB(sicmedInspect);
                        askedPrintBean.getInspectPrintBean().add(inspectPrintBean);
                        break;
                    case 2:// 治疗
                        CurePrintBean curePrintBean = new CurePrintBean();
                        SicmedCureCheck sicmedCureCheck = sicmedCureCheckService.get(sicmedAsked2.getOrderCode());
                        curePrintBean.setCPB(sicmedCureCheck);
                        askedPrintBean.getCurePrintBean().add(curePrintBean);
                        break;
                    case 3:// 药品
                        MedicalPrintBean medicalPrintBean = new MedicalPrintBean();
                        SicmedMedical sicmedMedical = sicmedMedicalService.get(sicmedAsked2.getOrderCode());
                        medicalPrintBean.setMPB(sicmedMedical);
                        if (sicmedMedical.getMedicalClassOne().getName().equals("中药")) {
                            askedPrintBean.getcMedicalPrintBean().add(medicalPrintBean);
                        } else {
                            askedPrintBean.getwMedicalPrintBean().add(medicalPrintBean);
                        }
                        break;
                    default:
                        break;
                }
            }
            askedPrintBean.setError("0");
            askedPrintBean.setErrorMessage("请求成功");

        } else {
            // 查询结果为空
            askedPrintBean.setError("1");
            askedPrintBean.setErrorMessage("没有需要打印的信息");
        }
        return askedPrintBean;
    }

	/*
     * @RequiresPermissions("rest:sicmedAsked:view")
	 * 
	 * @RequestMapping(value = { "list", "" }) public String list(SicmedAsked
	 * sicmedAsked, HttpServletRequest request, HttpServletResponse response,
	 * Model model) { Page<SicmedAsked> page = sicmedAskedService.findPage(new
	 * Page<SicmedAsked>(request, response), sicmedAsked);
	 * model.addAttribute("page", page); return "mobile/rest/sicmedAskedList"; }
	 */

	/*
	 * @ModelAttribute public SicmedAsked get(@RequestParam(required = false)
	 * String id) { SicmedAsked entity = null; if (StringUtils.isNotBlank(id)) {
	 * entity = sicmedAskedService.get(id); } if (entity == null) { entity = new
	 * SicmedAsked(); } return entity; }
	 * 
	 * @RequiresPermissions("rest:sicmedAsked:view")
	 * 
	 * @RequestMapping(value = "form") public String form(SicmedAsked
	 * sicmedAsked, Model model) { model.addAttribute("sicmedAsked",
	 * sicmedAsked); return "mobile/rest/sicmedAskedForm"; }
	 * 
	 * @RequiresPermissions("rest:sicmedAsked:edit")
	 * 
	 * @RequestMapping(value = "save") public String save(SicmedAsked
	 * sicmedAsked, Model model, RedirectAttributes redirectAttributes) { if
	 * (!beanValidator(model, sicmedAsked)) { return form(sicmedAsked, model); }
	 * sicmedAskedService.save(sicmedAsked); addMessage(redirectAttributes,
	 * "保存医嘱保存成功成功"); return "redirect:" + Global.getAdminPath() +
	 * "/rest/sicmedAsked/?repage"; }
	 * 
	 * @RequiresPermissions("rest:sicmedAsked:edit")
	 * 
	 * @RequestMapping(value = "delete") public String delete(SicmedAsked
	 * sicmedAsked, RedirectAttributes redirectAttributes) {
	 * sicmedAskedService.delete(sicmedAsked); addMessage(redirectAttributes,
	 * "删除医嘱保存成功成功"); return "redirect:" + Global.getAdminPath() +
	 * "/rest/sicmedAsked/?repage"; }
	 */

}