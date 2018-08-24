package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.CasePrintBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.CasePrintDealBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.CasePrintDealBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedAskedBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedAskedBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedAskedClassBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCaseBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCureCheckBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedInspectBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalUseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientDiseaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientDiseaseBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedTwxrayCheckBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAskedClass;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCase;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCureCheck;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspect;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedical;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatient;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatientDisease;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegistered;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedTwxrayCheck;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedUser;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedAskedClassService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedAskedService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCaseService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCureCheckService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedDiseaseService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedInspectService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedMedicalService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedMedicalUseService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedPatientDiseaseService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedPatientService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedRegisteredService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedTwxrayCheckService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedUserService;
import com.thinkgem.jeesite.cfq.mobile.rest.setBean.SicmedCaseSetBean;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.PageUtils;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.SsidUtils;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionUser;

/**
 * 病历表Controller
 *
 * @author Max
 * @version 2016-07-18
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedCase")
public class SicmedCaseController extends BaseController {

    @Autowired
    private SicmedCaseService sicmedCaseService;

    @Autowired
    private SicmedPatientService sicmedPatientService;

    @Autowired
    private SicmedDiseaseService sicmedDiseaseService;

    @Autowired
    private SicmedUserService sicmedUserService;

    @Autowired
    private SicmedAskedService sicmedAskedService;

    @Autowired
    private SicmedMedicalUseService sicmedMedicalUseService;

    @Autowired
    private SicmedPatientDiseaseService sicmedPatientDiseaseService;

    @Autowired
    private SicmedAskedClassService sicmedAskedClassService;

    @Autowired
    private SicmedTwxrayCheckService sicmedTwxrayCheckService;

    @Autowired
    private SicmedInspectService sicmedInspectService;

    @Autowired
    private SicmedCureCheckService sicmedCureCheckService;

    @Autowired
    private SicmedMedicalService sicmedMedicalService;

    @Autowired
    private SicmedRegisteredService sicmedRegisteredService;

    /**
     * 添加病历
     *
     * @param sicmedCaseBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add")
    public BaseBean add(SicmedCaseBean sicmedCaseBean, String patientId, String ssid) {

        if (!AppParameterSimulation.simulationId(patientId)
                || !AppParameterSimulation.simulationId(sicmedCaseBean.getId())
                || !AppParameterSimulation.simulationId(sicmedCaseBean.getCaseTell())
                || !AppParameterSimulation.simulationId(sicmedCaseBean.getCaseHistory())
                || !AppParameterSimulation.simulationId(sicmedCaseBean.getCaseAllergy())
                || !AppParameterSimulation.simulationId(sicmedCaseBean.getFamilyAllergy())
                || !AppParameterSimulation.simulationId(sicmedCaseBean.getCheckCodeBody())
                || !AppParameterSimulation.simulationId(sicmedCaseBean.getCheckCodeAid())) {
            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
        }

        SicmedCase sicmedCase = new SicmedCase();

        SicmedPatient sicmedPatient = sicmedPatientService.get(patientId);
        sicmedCase.setSicmedPatient(sicmedPatient);
        sicmedCase.setCreateUser(sicmedUserService.get(SsidUtils.getSicmedUserId(ssid)));

        sicmedCaseService.save(sicmedCase);
        // --------------------更改挂号状态开始-------------------
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        sicmedRegistered.setSicmedPatient(sicmedPatient);
        sicmedRegistered = sicmedRegisteredService.getByP(sicmedRegistered);
        sicmedRegistered.setRegisteredStatus("1");
        sicmedRegisteredService.update(sicmedRegistered);
        // --------------------更改挂号状态结束-------------------
        sicmedCaseBean.setError("0");
        sicmedCaseBean.setErrorMessage("为病人创建病历成功");

        return sicmedCaseBean;
    }

    /**
     * 更新病历
     *
     * @param sicmedCaseBean
     * @param diagnosisDiseaseInitialId
     * @param diagnosisDiseaseSureId
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "update")
    public BaseBean update(SicmedCaseBean sicmedCaseBean) {
        // 校验传入参数
        if (AppParameterSimulation.isEmpty(sicmedCaseBean.getId())) {
            sicmedCaseBean.setError("1");
            sicmedCaseBean.setErrorMessage("参数不能为空");
            return sicmedCaseBean;
        } else if (!AppParameterSimulation.simulationId(sicmedCaseBean.getId())) {
            sicmedCaseBean.setError("1");
            sicmedCaseBean.setErrorMessage("病历ID不正确");
            return sicmedCaseBean;

        }
        // 获取要修改的对象
        SicmedCase sicmedCase = sicmedCaseService.get(sicmedCaseBean.getId());

        // 給要修改的对象赋值
        sicmedCase = SicmedCaseSetBean.setSCB(sicmedCaseBean, sicmedCase);
        // 修改病历
        sicmedCaseService.update(sicmedCase);
        // 获取修改后的对象
        sicmedCaseBean.setSC(sicmedCaseService.get(sicmedCaseBean.getId()));
        sicmedCaseBean.setError("0");
        sicmedCaseBean.setErrorMessage("更新病历成功");
        return sicmedCaseBean;

    }

    /**
     * 根据患者查询病历
     *
     * @param sicmedCaseBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getByPatient")
    public BaseBean getByPatient(@RequestParam(required = false) String patientId, String ssid) {

        SicmedCaseBean sicmedCaseBean = new SicmedCaseBean();
        SicmedPatientDiseaseBeans sicmedPatientDiseaseBeans = new SicmedPatientDiseaseBeans();

        // 创建查询条件
        SicmedCase sicmedCase = new SicmedCase();
        // 获取查询条件参数
        SicmedPatient sicmedPatient = sicmedPatientService.get(patientId);
        sicmedCaseBean.setBranchName(sicmedUserService.get(SsidUtils.getSicmedUserId(ssid)).getSicmedBranch().getBranchName());

        // 查询条件赋值
        sicmedCase.setSicmedPatient(sicmedPatient);
        // 调用service查询病历信息
        sicmedCase = sicmedCaseService.getByEntity(sicmedCase);
        // 判断查询的病历信息是否为空
        if (sicmedCase == null) {
            // 如果为空为病人创建一个病历
            sicmedCaseBean = (SicmedCaseBean) this.add(sicmedCaseBean, patientId, ssid);
            if (sicmedCaseBean.getError().equals("0")) {
                SicmedCase sicmedCase2 = new SicmedCase();
                sicmedCase2.setSicmedPatient(sicmedPatient);
                sicmedCase = sicmedCaseService.getByEntity(sicmedCase2);
                sicmedCaseBean.setSC(sicmedCase);
            } else {
                sicmedCaseBean.setError("1");
                sicmedCaseBean.setErrorMessage("为病人创建病历失败");
                return sicmedCaseBean;
            }
        } else {
            // 查询初步诊断
            // 创建查询条件
            SicmedPatientDisease sicmedPatientDisease = new SicmedPatientDisease();
            // 查询条件赋值
            sicmedPatientDisease.setCaseCode(sicmedCase);
            // 查询数据
            List<SicmedPatientDisease> sicmedPatientDiseases = sicmedPatientDiseaseService
                    .findList(sicmedPatientDisease);
            // 返回值校验
            if (sicmedPatientDiseases.size() > 0) {
                // 返回值处理
                for (SicmedPatientDisease sicmedPatientDisease2 : sicmedPatientDiseases) {
                    SicmedPatientDiseaseBean sicmedPatientDiseaseBean = new SicmedPatientDiseaseBean();
                    sicmedPatientDiseaseBean.setspd(sicmedPatientDisease2);
                    sicmedPatientDiseaseBean.setDiseaseName(
                            sicmedDiseaseService.get(sicmedPatientDisease2.getDiseaseCode().getId()).getDiseaseName());
                    sicmedPatientDiseaseBeans.getSicmedPatientDiseaseBeans().add(sicmedPatientDiseaseBean);
                }
                sicmedPatientDiseaseBeans.setError(null);
                sicmedPatientDiseaseBeans.setErrorMessage(null);
                sicmedCaseBean.setSicmedPatientDiseaseBeans(sicmedPatientDiseaseBeans.getSicmedPatientDiseaseBeans());
            } else {
                sicmedPatientDiseaseBeans.setError(null);
                sicmedPatientDiseaseBeans.setErrorMessage(null);
                sicmedCaseBean.setSicmedPatientDiseaseBeans(sicmedPatientDiseaseBeans.getSicmedPatientDiseaseBeans());
            }
            // //不为空 获取病历中的诊断信息
            // SicmedPatientDisease sicmedPatientDisease = new
            // SicmedPatientDisease();
            // sicmedPatientDisease.setCaseCode(sicmedCase);
            // List<SicmedPatientDisease> sicmedPatientDiseases =
            // sicmedPatientDiseaseService
            // .findList(sicmedPatientDisease);
            // if (sicmedPatientDiseases != null) {
            // StringBuffer str = new StringBuffer();
            // for (SicmedPatientDisease sicmedPatientDisease2 :
            // sicmedPatientDiseases) {
            // str.append(
            // sicmedDiseaseService.get(sicmedPatientDisease2.getDiseaseCode().getId()).getDiseaseName());
            // str.append(";");
            // }
            // sicmedCaseBean.setDiagnosisDiseaseInitial(str.toString());
            // }
            // sicmedCaseBean.setSC(sicmedCase);
            // sicmedCaseBean.setError("0");
            // sicmedCaseBean.setErrorMessage("查询病历成功");
            sicmedCaseBean.setSC(sicmedCase);
        }

        // 查询患者 医嘱
        SicmedAskedBeans sicmedAskedBeans = new SicmedAskedBeans();

        // 创建查询条件
        SicmedAsked sicmedAsked = new SicmedAsked();
        // 为查询条件赋值
        sicmedAsked.setSicmedCase(sicmedCase);
        // 根据查询添加查询医嘱信息
        List<SicmedAsked> sicmedAskedes = sicmedAskedService.findList(sicmedAsked);

        // 查询结果为空
        // 创建空的返回结果

        SicmedAskedBean sicmedTwxrayCheckAskedBean = new SicmedAskedBean();
        SicmedAskedBean sicmedCureCheckAskedBean = new SicmedAskedBean();
        SicmedAskedBean sicmedInspectAskedBean = new SicmedAskedBean();
        SicmedAskedBean sicmedMedicalAskedBean = new SicmedAskedBean();

        SicmedAskedClass sicmedAskedClass = new SicmedAskedClass();
        List<SicmedAskedClass> sicmedAskedClasses = sicmedAskedClassService.findList(sicmedAskedClass);
        for (SicmedAskedClass sicmedAskedClass2 : sicmedAskedClasses) {
            switch (Integer.parseInt(sicmedAskedClass2.getClassNumber())) {
                case 0:
                    sicmedAsked.setSicmedAskedClass(sicmedAskedClass2);
                    sicmedTwxrayCheckAskedBean.setSAB(sicmedAsked);

                    SicmedAskedClassBean sicmedAskedClassBean = new SicmedAskedClassBean();
                    sicmedAskedClassBean.setSac(sicmedAskedClass2);
                    sicmedTwxrayCheckAskedBean.setSicmedAskedClassBean(sicmedAskedClassBean);
                    sicmedAskedBeans.getSicmedAskedBeans().add(sicmedTwxrayCheckAskedBean);
                    break;
                case 1:
                    sicmedAsked.setSicmedAskedClass(sicmedAskedClass2);
                    sicmedInspectAskedBean.setSAB(sicmedAsked);
                    SicmedAskedClassBean sicmedAskedClassBean3 = new SicmedAskedClassBean();
                    sicmedAskedClassBean3.setSac(sicmedAskedClass2);
                    sicmedInspectAskedBean.setSicmedAskedClassBean(sicmedAskedClassBean3);
                    sicmedAskedBeans.getSicmedAskedBeans().add(sicmedInspectAskedBean);
                    break;
                case 2:
                    sicmedAsked.setSicmedAskedClass(sicmedAskedClass2);
                    sicmedCureCheckAskedBean.setSAB(sicmedAsked);
                    SicmedAskedClassBean sicmedAskedClassBean2 = new SicmedAskedClassBean();
                    sicmedAskedClassBean2.setSac(sicmedAskedClass2);
                    sicmedCureCheckAskedBean.setSicmedAskedClassBean(sicmedAskedClassBean2);
                    sicmedAskedBeans.getSicmedAskedBeans().add(sicmedCureCheckAskedBean);
                    break;
                case 3:
                    sicmedAsked.setSicmedAskedClass(sicmedAskedClass2);
                    sicmedMedicalAskedBean.setSAB(sicmedAsked);

                    SicmedAskedClassBean sicmedAskedClassBean4 = new SicmedAskedClassBean();
                    sicmedAskedClassBean4.setSac(sicmedAskedClass2);

                    sicmedMedicalAskedBean.setSicmedAskedClassBean(sicmedAskedClassBean4);

                    sicmedAskedBeans.getSicmedAskedBeans().add(sicmedMedicalAskedBean);
                    break;
                default:
                    break;
            }
        }
        // 判断查询结果
        if (sicmedAskedes.size() > 0) {
            // 查询结果不为空 遍历查询结果
            for (SicmedAsked sicmedAsked2 : sicmedAskedes) {
                // 获取医嘱项目
                String classNumber = sicmedAsked2.getSicmedAskedClass().getClassNumber();
                SicmedAskedBean sicmedAskedBean = new SicmedAskedBean();
                switch (Integer.parseInt(classNumber)) {
                    case 0:// 检查
                        sicmedAskedBeans.getSicmedAskedBeans().remove(sicmedTwxrayCheckAskedBean);
                        sicmedAskedBean.setSAB(sicmedAsked2);
                        // 获取检查项目
                        SicmedTwxrayCheck sicmedTwxrayCheck = sicmedTwxrayCheckService.get(sicmedAsked2.getOrderCode());
                        SicmedTwxrayCheckBean sicmedTwxrayCheckBean = new SicmedTwxrayCheckBean();
                        sicmedTwxrayCheckBean.setSTCB(sicmedTwxrayCheck);
                        // 向检查医嘱中添加检查项目
                        sicmedAskedBean.setSicmedTwxrayCheckBean(sicmedTwxrayCheckBean);
                        // 获取医嘱类别
                        SicmedAskedClassBean sicmedAskedClassBean = new SicmedAskedClassBean();
                        sicmedAskedClassBean.setSac(sicmedAsked2.getSicmedAskedClass());
                        // 向检查医嘱中添加医嘱类别
                        sicmedAskedBean.setSicmedAskedClassBean(sicmedAskedClassBean);

                        sicmedAskedBeans.getSicmedAskedBeans().add(sicmedAskedBean);
                        break;
                    case 1:// 检验
                        sicmedAskedBeans.getSicmedAskedBeans().remove(sicmedInspectAskedBean);
                        sicmedAskedBean.setSAB(sicmedAsked2);

                        SicmedInspect sicmedInspect = sicmedInspectService.get(sicmedAsked2.getOrderCode());
                        SicmedInspectBean sicmedInspectBean = new SicmedInspectBean();

                        sicmedInspectBean.setSIB(sicmedInspect);

                        SicmedAskedClassBean sicmedAskedClassBean2 = new SicmedAskedClassBean();
                        sicmedAskedBean.setSicmedInspectBean(sicmedInspectBean);
                        sicmedAskedClassBean2.setSac(sicmedAsked2.getSicmedAskedClass());

                        sicmedAskedBean.setSicmedAskedClassBean(sicmedAskedClassBean2);

                        sicmedAskedBeans.getSicmedAskedBeans().add(sicmedAskedBean);
                        break;
                    case 2:// 治疗
                        sicmedAskedBeans.getSicmedAskedBeans().remove(sicmedCureCheckAskedBean);
                        sicmedAskedBean.setSAB(sicmedAsked2);

                        SicmedCureCheck sicmedCureCheck = sicmedCureCheckService.get(sicmedAsked2.getOrderCode());
                        SicmedCureCheckBean sicmedCureCheckBean = new SicmedCureCheckBean();

                        sicmedCureCheckBean.setSCCB(sicmedCureCheck);

                        SicmedAskedClassBean sicmedAskedClassBean3 = new SicmedAskedClassBean();
                        sicmedAskedBean.setSicmedCureCheckBean(sicmedCureCheckBean);
                        sicmedAskedClassBean3.setSac(sicmedAsked2.getSicmedAskedClass());

                        sicmedAskedBean.setSicmedAskedClassBean(sicmedAskedClassBean3);
                        sicmedAskedBeans.getSicmedAskedBeans().add(sicmedAskedBean);
                        break;
                    case 3:// 药品
                        sicmedAskedBeans.getSicmedAskedBeans().remove(sicmedMedicalAskedBean);
                        sicmedAskedBean.setSAB(sicmedAsked2);
                        logger.info(sicmedAsked2.getOrderCode());
                        SicmedMedical sicmedMedical = sicmedMedicalService.get(sicmedAsked2.getOrderCode());
                        SicmedMedicalBean sicmedMedicalBean = new SicmedMedicalBean();
                        sicmedMedicalBean.setSMB(sicmedMedical);

                        SicmedAskedClassBean sicmedAskedClassBean4 = new SicmedAskedClassBean();
                        sicmedAskedBean.setSicmedMedicalBean(sicmedMedicalBean);
                        sicmedAskedClassBean4.setSac(sicmedAsked2.getSicmedAskedClass());

                        SicmedMedicalUseBean sicmedMedicalUseBean = new SicmedMedicalUseBean();
                        sicmedMedicalUseBean.setSMUB(sicmedMedicalUseService.get(sicmedAsked2.getSicmedMedicalUse()));
                        sicmedAskedBean.setSicmedMedicalUseBean(sicmedMedicalUseBean);

                        sicmedAskedBean.setSicmedAskedClassBean(sicmedAskedClassBean4);

                        sicmedAskedBeans.getSicmedAskedBeans().add(sicmedAskedBean);
                        break;
                    default:
                        break;
                }
            }
            sicmedCaseBean.setSicmedAskedBeans(sicmedAskedBeans.getSicmedAskedBeans());

            sicmedCaseBean.setError("0");
            sicmedCaseBean.setErrorMessage("请求成功");
        } else {
            sicmedCaseBean.setError("0");
            sicmedCaseBean.setErrorMessage("请求成功 !但是没有医嘱");
            sicmedCaseBean.setSicmedAskedBeans(sicmedAskedBeans.getSicmedAskedBeans());
        }
        return sicmedCaseBean;
    }

    /**
     * 患者病历打印
     */
    @ResponseBody
    @RequestMapping(value = "casePrint")
    public BaseBean casePrint(@RequestParam(required = false) String caseId, String ssid) {
        // 创建返回值
        CasePrintBean casePrintBean = new CasePrintBean();
        // 传入参数校验
        if (AppParameterSimulation.isEmpty(caseId)) {
            casePrintBean.setError("1");
            casePrintBean.setErrorMessage("参数不能为空");
            return casePrintBean;
        }
        // 创建查询对象
        SicmedCase sicmedCase = new SicmedCase();
        // 给查询对象赋值
        sicmedCase.setId(caseId);
        // 执行查询
        sicmedCase = sicmedCaseService.getByEntity(sicmedCase);
        // 判断查询结果
        if (sicmedCase == null) {
            casePrintBean.setError("1");
            casePrintBean.setErrorMessage("获取打印信息失败!打印信息不存在");
            return casePrintBean;
        }
        // 获取医嘱中的处理项
        SicmedAsked sicmedAsked = new SicmedAsked();
        sicmedAsked.setSicmedCase(sicmedCase);
        List<SicmedAsked> sicmedAskedes = sicmedAskedService.findList(sicmedAsked);
        // 查询结果处理
        if (sicmedAskedes.size() <= 0) {
            casePrintBean.setCPB(sicmedCase);
            casePrintBean.setError("0");
            casePrintBean.setErrorMessage("获取打印信息成功!没有处理项");
            return casePrintBean;
        }
        CasePrintDealBeans casePrintDealBeans = new CasePrintDealBeans();
        for (SicmedAsked sicmedAsked2 : sicmedAskedes) {
            CasePrintDealBean casePrintDealBean = new CasePrintDealBean();
            if (sicmedAsked2.getSicmedAskedClass().getClassNumber().equals("3")) {
                sicmedAsked2.setSicmedMedicalUse(sicmedMedicalUseService.get(sicmedAsked2.getSicmedMedicalUse()));
            }
            casePrintDealBean.setCPDB(sicmedAsked2);
            casePrintDealBeans.getCasePrintDealBeans().add(casePrintDealBean);
        }
        casePrintBean.setCasePrintDealBeans(casePrintDealBeans);
        casePrintBean.setCPB(sicmedCase);
        casePrintBean.setError("0");
        casePrintBean.setErrorMessage("获取打印信息成功");
        return casePrintBean;
    }

    /**
     * 诊疗记录查询
     * url:192.168.0.107/jeesite/a/rest/sicmedCase/zlSeachCase
     *
     * @param doctorId      医生id
     * @param ssid          sessionId
     * @param startDateTime 创建时间(yyyy-MM-dd)
     * @param endDateTime   截止时间(yyyy-MM-dd)
     */
    @ResponseBody
    @RequestMapping(value = "zlSeachCase")
    public BaseBean zlSeachCase(String pageNo, Date startDateTime, Date endDateTime, String ssid, String startDate, String endDate,
                                HttpServletRequest request, HttpServletResponse response,
                                Model model) {
        SicmedCaseBeans caseBeans = new SicmedCaseBeans();
        //校验参数是否合法，不合法返回对应数据
        /*if (!AppParameterSimulation.simulationId(doctorId)&&!AppParameterSimulation.simulationId(sessionId)) {
			patientBeans.setError("1");
			patientBeans.setErrorMessage("参数不合法请核对参数");
			return patientBeans;
		}*/
        // 给sicmedPatient对象赋值
        SicmedCase sicmedCase = new SicmedCase();
        SicmedUser tempCreateUser = new SicmedUser();
        tempCreateUser.setId(SsidUtils.getSicmedUserId(ssid));
        if (startDateTime != null) {
            sicmedCase.setBeginCreateDate(startDateTime);
        }
        if (endDateTime != null) {
            sicmedCase.setEndCreateDate(endDateTime);
        }
		
		/*Page<SicmedCase> page = sicmedCaseService.findPage(new Page<SicmedPatient>(request, response),
				sicmedPatient);*/
        Page<SicmedCase> page = new Page<SicmedCase>();
        page.setPageSize(PageUtils.PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        sicmedCase.setCreateUser(tempCreateUser);
        sicmedCase.setPage(page);
        List<SicmedCase> pageList = sicmedCaseService.findPageWithDate(sicmedCase);
        caseBeans.setSicmedCaseBeanList(pageList);
        caseBeans.setError("0");
        caseBeans.setSuccessMessage("访问成功");
        return caseBeans;
    }
	

	/*
	 * @ModelAttribute public SicmedCase get(@RequestParam(required=false)
	 * String id) { SicmedCase entity = null; if (StringUtils.isNotBlank(id)){
	 * entity = sicmedCaseService.get(id); } if (entity == null){ entity = new
	 * SicmedCase(); } return entity; }
	 * 
	 * @RequiresPermissions("rest:sicmedCase:view")
	 * 
	 * @RequestMapping(value = {"list", ""}) public String list(SicmedCase
	 * sicmedCase, HttpServletRequest request, HttpServletResponse response,
	 * Model model) { Page<SicmedCase> page = sicmedCaseService.findPage(new
	 * Page<SicmedCase>(request, response), sicmedCase);
	 * model.addAttribute("page", page); return "mobile/rest/sicmedCaseList"; }
	 * 
	 * @RequiresPermissions("rest:sicmedCase:view")
	 * 
	 * @RequestMapping(value = "form") public String form(SicmedCase sicmedCase,
	 * Model model) { model.addAttribute("sicmedCase", sicmedCase); return
	 * "mobile/rest/sicmedCaseForm"; }
	 * 
	 * @RequiresPermissions("rest:sicmedCase:edit")
	 * 
	 * @RequestMapping(value = "save") public String save(SicmedCase sicmedCase,
	 * Model model, RedirectAttributes redirectAttributes) { if
	 * (!beanValidator(model, sicmedCase)){ return form(sicmedCase, model); }
	 * sicmedCaseService.save(sicmedCase); addMessage(redirectAttributes,
	 * "保存保存成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedCase/?repage"; }
	 * 
	 * @RequiresPermissions("rest:sicmedCase:edit")
	 * 
	 * @RequestMapping(value = "delete") public String delete(SicmedCase
	 * sicmedCase, RedirectAttributes redirectAttributes) {
	 * sicmedCaseService.delete(sicmedCase); addMessage(redirectAttributes,
	 * "删除保存成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedCase/?repage"; }
	 */

}