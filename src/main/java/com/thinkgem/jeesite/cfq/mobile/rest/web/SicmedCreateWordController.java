//package com.thinkgem.jeesite.cfq.mobile.rest.web;
//
//import java.util.List;
//import java.util.UUID;
//
//import com.thinkgem.jeesite.cfq.common.web.BaseController;
//import org.apache.velocity.VelocityContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.CasePrintBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.CasePrintDealBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.CasePrintDealBeans;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedAskedBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCaseBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalPriceBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalUseBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientDiseaseBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientDiseaseBeans;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientPriceBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedRegisteredBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedUserBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.AskedPrintBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.CheckPrintBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.CheckPrintBeans;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.CurePrintBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.CurePrintBeans;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.InspectPrintBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.InspectPrintBeans;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.MedicalPrintBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.MedicalPrintBeans;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAsked;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAskedClass;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCase;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCureCheck;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspect;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedical;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalClass;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalPrice;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalUse;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatient;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatientDisease;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatientPrice;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegistered;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedTwxrayCheck;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedUser;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedWord;
//import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedAskedClassService;
//import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedAskedService;
//import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCaseService;
//import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCheckPriceService;
//import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCureCheckService;
//import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCurePriceService;
//import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedInspectPriceService;
//import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedInspectService;
//import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedMedicalClassService;
//import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedMedicalPriceService;
//import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedMedicalService;
//import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedMedicalUseService;
//import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedPatientDiseaseService;
//import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedPatientPriceService;
//import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedPatientService;
//import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedRegisteredService;
//import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedTwxrayCheckService;
//import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedUserService;
//import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedWordService;
//import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;
//import com.thinkgem.jeesite.cfq.mobile.rest.utils.SsidUtils;
//import com.thinkgem.jeesite.cfq.mobile.rest.utils.VelocityUtil;
//
//@Controller
//@RequestMapping(value = "${adminPath}/rest/createWord")
//public class SicmedCreateWordController extends BaseController {
//
//    @Autowired
//    private SicmedAskedService sicmedAskedService;
//
//    @Autowired
//    private SicmedAskedClassService sicmedAskedClassService;
//
//    @Autowired
//    private SicmedCaseService sicmedCaseService;
//
//    @Autowired
//    private SicmedTwxrayCheckService sicmedTwxrayCheckService;
//    @Autowired
//    private SicmedCheckPriceService sicmedCheckPriceService;
//
//    @Autowired
//    private SicmedInspectService sicmedInspectService;
//    @Autowired
//    private SicmedInspectPriceService sicmedInspectPriceService;
//
//    @Autowired
//    private SicmedCureCheckService sicmedCureCheckService;
//    @Autowired
//    private SicmedCurePriceService sicmedCurePriceService;
//
//    @Autowired
//    private SicmedMedicalService sicmedMedicalService;
//    @Autowired
//    private SicmedMedicalPriceService sicmedMedicalPriceService;
//
//    @Autowired
//    private SicmedMedicalClassService sicmedMedicalClassService;
//
//    @Autowired
//    private SicmedPatientPriceService sicmedPatientPriceService;
//
//    @Autowired
//    private SicmedPatientService sicmedPatientService;
//
//    @Autowired
//    private SicmedMedicalUseService sicmedMedicalUseService;
//
//    @Autowired
//    private SicmedRegisteredService sicmedRegisteredService;
//
//    @Autowired
//    private SicmedUserService sicmedUserService;
//
//    @Autowired
//    private SicmedWordService sicmedwordService;
//
//    @Autowired
//    private SicmedPatientDiseaseService sicmedPatientDiseaseService;
//
//    /**
//     * 创建病历word返回预览信息
//     *
//     * @param caseId
//     * @param ssid
//     * @param printLoc
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "createCase")
//    public BaseBean createCase(String caseId, String ssid, String printLoc) {
//
//        // 1. 创建返回值
//        CasePrintBean casePrintBean = new CasePrintBean();
//        AskedPrintBean askedPrintBean = new AskedPrintBean();
//        // 1.传入参数校验
//        if (AppParameterSimulation.isEmpty(caseId)) {
//            casePrintBean.setError("1");
//            casePrintBean.setErrorMessage("参数不能为空");
//            return casePrintBean;
//        }
//        // 3.创建查询对象
//        SicmedCase sicmedCase = new SicmedCase();
//        // 4.给查询对象赋值
//        sicmedCase.setId(caseId);
//        // 5.调用service
//        sicmedCase = sicmedCaseService.getByEntity(sicmedCase);
//        // 5.1判断查询结果
//        if (sicmedCase == null) {
//            casePrintBean.setError("1");
//            casePrintBean.setErrorMessage("获取打印信息失败!打印信息不存在");
//            return casePrintBean;
//        }
//        // 6.获取医嘱中的处理项
//        SicmedAsked sicmedAsked = new SicmedAsked();
//        sicmedAsked.setSicmedCase(sicmedCase);
//        List<SicmedAsked> sicmedAskedes = sicmedAskedService.findList(sicmedAsked);
//        // 6.1查询结果处理
//        if (sicmedAskedes.size() <= 0) {
//            casePrintBean.setCPB(sicmedCase);
//        } else {
//            CasePrintDealBeans casePrintDealBeans = new CasePrintDealBeans();
//            for (SicmedAsked sicmedAsked2 : sicmedAskedes) {
//                CasePrintDealBean casePrintDealBean = new CasePrintDealBean();
//                if (sicmedAsked2.getSicmedAskedClass().getClassNumber().equals("3")) {
//                    sicmedAsked2.setSicmedMedicalUse(sicmedMedicalUseService.get(sicmedAsked2.getSicmedMedicalUse()));
//                }
//                casePrintDealBean.setCPDB(sicmedAsked2);
//                casePrintDealBeans.getCasePrintDealBeans().add(casePrintDealBean);
//            }
//            casePrintBean.setCasePrintDealBeans(casePrintDealBeans);
//        }
//        casePrintBean.setCPB(sicmedCase);
//        casePrintBean.setError("0");
//        casePrintBean.setErrorMessage("获取打印信息成功");
//
//        // 7.创建病历word
//        SicmedPatient sicmedPatient = sicmedPatientService.get(sicmedCase.getSicmedPatient());
//
//        // 创建velocity上下文对象
//        VelocityContext velocityContext = new VelocityContext();
//        // 判断查询结果
//        if (sicmedAskedes.size() != 0) {
//            // 查询结果不为空 遍历查询结果
//            for (SicmedAsked sicmedAsked2 : sicmedAskedes) {
//                // 获取医嘱项目
//                String classNumber = sicmedAsked2.getSicmedAskedClass().getClassNumber();
//                switch (Integer.parseInt(classNumber)) {
//                    case 0:// 检查
//                        CheckPrintBean checkPrintBean = new CheckPrintBean();
//                        SicmedTwxrayCheck sicmedTwxrayCheck = sicmedTwxrayCheckService.get(sicmedAsked2.getOrderCode());
//                        checkPrintBean.setCPB(sicmedTwxrayCheck);
//                        askedPrintBean.getCheckPrintBean().add(checkPrintBean);
//                        break;
//                    case 1:// 检验
//                        InspectPrintBean inspectPrintBean = new InspectPrintBean();
//                        SicmedInspect sicmedInspect = sicmedInspectService.get(sicmedAsked2.getOrderCode());
//                        inspectPrintBean.setIPB(sicmedInspect);
//                        askedPrintBean.getInspectPrintBean().add(inspectPrintBean);
//                        break;
//                    case 2:// 治疗
//                        CurePrintBean curePrintBean = new CurePrintBean();
//                        SicmedCureCheck sicmedCureCheck = sicmedCureCheckService.get(sicmedAsked2.getOrderCode());
//                        curePrintBean.setCPB(sicmedCureCheck);
//
//                        askedPrintBean.getCurePrintBean().add(curePrintBean);
//                        break;
//                    case 3:// 药品
//                        MedicalPrintBean medicalPrintBean = new MedicalPrintBean();
//                        SicmedMedical sicmedMedical = sicmedMedicalService.get(sicmedAsked2.getOrderCode());
//                        medicalPrintBean.setMPB(sicmedMedical);
//                        SicmedMedicalClass sicmedMedicalClass = sicmedMedicalClassService
//                                .get(sicmedMedical.getMedicalClassOne());
//                        if (sicmedMedicalClass != null && sicmedMedicalClass.getName() != null
//                                && sicmedMedicalClass.getName().equals("中药")) {
//                            askedPrintBean.getcMedicalPrintBean().add(medicalPrintBean);
//                        } else {
//                            askedPrintBean.getwMedicalPrintBean().add(medicalPrintBean);
//                        }
//                        break;
//                }
//            }
//        } else {
//        }
//        // 获取诊疗医生
//        SicmedUser doctor = sicmedUserService.get(SsidUtils.getSicmedUserId(ssid));
//        SicmedUserBean sicmedDoctorBean = new SicmedUserBean();
//        sicmedDoctorBean.setSUser(doctor);
//
//        // 获取患者信息
//        SicmedPatientBean sicmedPatientBean = new SicmedPatientBean();
//        sicmedPatientBean.setSP(sicmedPatient);
//
//        // 获取患者挂号信息
//        SicmedRegistered sicmedRegistered = new SicmedRegistered();
//        sicmedRegistered.setSicmedPatient(sicmedPatient);
//        sicmedRegistered = sicmedRegisteredService.getByP(sicmedRegistered);
//        SicmedRegisteredBean sicmedRegisteredBean = new SicmedRegisteredBean();
//        sicmedRegisteredBean.setSR(sicmedRegistered);
//
//        // 获取患者病历信息
//        SicmedCaseBean sicmedCaseBean = new SicmedCaseBean();
//        sicmedCaseBean.setSC(sicmedCase);
//
//        // 获取诊断信息
//        SicmedPatientDisease sicmedPatientDisease = new SicmedPatientDisease();
//        sicmedPatientDisease.setCaseCode(sicmedCase);
//        List<SicmedPatientDisease> sicmedPatientDiseases = sicmedPatientDiseaseService.findList(sicmedPatientDisease);
//        SicmedPatientDiseaseBeans sicmedPatientDiseaseBeans = null;
//        if (sicmedPatientDiseases.size() > 0) {
//            sicmedPatientDiseaseBeans = new SicmedPatientDiseaseBeans();
//            for (SicmedPatientDisease sicmedPatientDisease2 : sicmedPatientDiseases) {
//                SicmedPatientDiseaseBean sicmedPatientDiseaseBean = new SicmedPatientDiseaseBean();
//                sicmedPatientDiseaseBean.setspd(sicmedPatientDisease2);
//                sicmedPatientDiseaseBeans.getSicmedPatientDiseaseBeans().add(sicmedPatientDiseaseBean);
//            }
//        }
//        // 预览信息赋值
//        casePrintBean.setSicmedDoctorBean(sicmedDoctorBean);
//        casePrintBean.setSicmedRegisteredBean(sicmedRegisteredBean);
//        // 创建word所在文件夹目录
//        StringBuffer uri = new StringBuffer();
//        uri.append("word/case/");
//        uri.append(doctor.getSicmedBranch().getBranchCode());
//        uri.append("/");
//        uri.append(doctor.getUserNumber());
//
//        // 创建 word 文件名
//        StringBuffer wordName = new StringBuffer();
//
//        wordName.append(UUID.randomUUID());
//        wordName.append(".doc");
//
//        // 创建 word 生成路径
//        StringBuffer fileName = new StringBuffer();
//
//        fileName.append(uri.toString());
//        fileName.append("/");
//        fileName.append(wordName.toString());
//
//        velocityContext.put("sicmedCaseBean", sicmedCaseBean);
//        velocityContext.put("sicmedDoctorBean", sicmedDoctorBean);
//        velocityContext.put("sicmedPatientBean", sicmedPatientBean);
//        velocityContext.put("sicmedRegisteredBean", sicmedRegisteredBean);
//        if (sicmedPatientDiseaseBeans != null) {
//            velocityContext.put("sicmedPatientDiseaseBeans", sicmedPatientDiseaseBeans);
//        }
//        if (askedPrintBean.getcMedicalPrintBean().size() > 0) {
//            velocityContext.put("cMedicalPrintBeans", askedPrintBean.getcMedicalPrintBean());
//        }
//        if (askedPrintBean.getwMedicalPrintBean().size() > 0) {
//            velocityContext.put("wMedicalPrintBeans", askedPrintBean.getwMedicalPrintBean());
//        }
//        if (askedPrintBean.getCheckPrintBean().size() > 0) {
//            velocityContext.put("checkPrintBeans", askedPrintBean.getCheckPrintBean());
//        }
//        if (askedPrintBean.getInspectPrintBean().size() > 0) {
//            velocityContext.put("inspectPrintBeans", askedPrintBean.getInspectPrintBean());
//        }
//        if (askedPrintBean.getCurePrintBean().size() > 0) {
//            velocityContext.put("curePrintBeans", askedPrintBean.getCurePrintBean());
//        }
//        // 调用velocity工具类 生成word文档
//        try {
//            VelocityUtil.createDoc(velocityContext, "wordvm/case.vm", uri.toString(), fileName.toString());
//            SicmedWord sicmedWord = this.saveWord(wordName.toString(), uri.toString(), doctor, "0", printLoc,
//                    sicmedPatient);
//            logger.info("创建病历word成功");
//            casePrintBean.setWordId(sicmedWord.getId());
//            casePrintBean.setError("0");
//            casePrintBean.setSuccessMessage("创建病历word成功!可以打印");
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.info("创建病历word失败!系统异常");
//            casePrintBean.setError("1");
//            casePrintBean.setErrorMessage("创建病历word失败!系统异常");
//            return casePrintBean;
//        }
//        // 预览信息返回
//        return casePrintBean;
//    }
//
//    /**
//     * 生成检查医嘱单
//     *
//     * @param caseId
//     * @param ssid
//     * @param printLoc
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "createCheckWord")
//    public BaseBean createCheckWord(String caseId, String ssid, String printLoc) {
//        // 1.创建Bean对象
//        CheckPrintBeans checkPrintBeans = new CheckPrintBeans();
//        // 2.传入参数校验
//        if (!AppParameterSimulation.simulationId(caseId)) {
//            checkPrintBeans.setError("1");
//            checkPrintBeans.setErrorMessage("输入的病历ID不正确");
//            return checkPrintBeans;
//        }
//        // 3.创建查询对象
//        SicmedAsked sicmedAsked = new SicmedAsked();
//        // 4.查询对象赋值
//        SicmedCase sicmedCase = sicmedCaseService.get(caseId);
//        if (sicmedCase == null) {
//            checkPrintBeans.setError("1");
//            checkPrintBeans.setErrorMessage("病历不存在!");
//            return checkPrintBeans;
//        }
//        SicmedAskedClass sicmedAskedClass = new SicmedAskedClass();
//        sicmedAskedClass.setClassNumber("0");
//        sicmedAskedClass = sicmedAskedClassService.get(sicmedAskedClass);
//        sicmedAsked.setSicmedCase(sicmedCase);
//        sicmedAsked.setSicmedAskedClass(sicmedAskedClass);
//        // 5.调用service
//        List<SicmedAsked> sicmedAskedes = sicmedAskedService.findList(sicmedAsked);
//        // 6.查询结果校验 处理
//        if (sicmedAskedes.size() > 0) {
//            for (SicmedAsked sicmedAsked2 : sicmedAskedes) {
//                CheckPrintBean checkPrintBean = new CheckPrintBean();
//                SicmedTwxrayCheck sicmedTwxrayCheck = sicmedTwxrayCheckService.get(sicmedAsked2.getOrderCode());
//                checkPrintBean.setCPB(sicmedTwxrayCheck);
//                checkPrintBeans.getCheckPrintBean().add(checkPrintBean);
//            }
//        } else {
//            checkPrintBeans.setError("1");
//            checkPrintBeans.setErrorMessage("生成word失败!服务器内部异常!");
//            return checkPrintBeans;
//        }
//
//        // 7.获取需要打印的信息
//        // 获取诊疗医生
//        SicmedUser doctor = sicmedUserService.get(SsidUtils.getSicmedUserId(ssid));
//        SicmedUserBean sicmedDoctorBean = new SicmedUserBean();
//        sicmedDoctorBean.setSUser(doctor);
//        // 获取患者信息
//        SicmedPatient sicmedPatient = sicmedPatientService.get(sicmedCase.getSicmedPatient());
//        SicmedPatientBean sicmedPatientBean = new SicmedPatientBean();
//        sicmedPatientBean.setSP(sicmedPatient);
//        // 获取患者挂号信息
//        SicmedRegistered sicmedRegistered = new SicmedRegistered();
//        sicmedRegistered.setSicmedPatient(sicmedPatient);
//        sicmedRegistered = sicmedRegisteredService.getByP(sicmedRegistered);
//        SicmedRegisteredBean sicmedRegisteredBean = new SicmedRegisteredBean();
//        sicmedRegisteredBean.setSR(sicmedRegistered);
//        // 获取患者病历信息
//        SicmedCaseBean sicmedCaseBean = new SicmedCaseBean();
//        sicmedCaseBean.setSC(sicmedCase);
//        // 获取诊断信息
//        SicmedPatientDisease sicmedPatientDisease = new SicmedPatientDisease();
//        sicmedPatientDisease.setCaseCode(sicmedCase);
//        List<SicmedPatientDisease> sicmedPatientDiseases = sicmedPatientDiseaseService.findList(sicmedPatientDisease);
//        SicmedPatientDiseaseBeans sicmedPatientDiseaseBeans = null;
//        if (sicmedPatientDiseases.size() > 0) {
//            sicmedPatientDiseaseBeans = new SicmedPatientDiseaseBeans();
//            for (SicmedPatientDisease sicmedPatientDisease2 : sicmedPatientDiseases) {
//                SicmedPatientDiseaseBean sicmedPatientDiseaseBean = new SicmedPatientDiseaseBean();
//                sicmedPatientDiseaseBean.setspd(sicmedPatientDisease2);
//                sicmedPatientDiseaseBeans.getSicmedPatientDiseaseBeans().add(sicmedPatientDiseaseBean);
//            }
//        }
//        // 8.检查预览内容赋值
//        checkPrintBeans.setSicmedDoctorBean(sicmedDoctorBean);
//        checkPrintBeans.setSicmedCaseBean(sicmedCaseBean);
//        checkPrintBeans.setSicmedRegisteredBean(sicmedRegisteredBean);
//        // 9.生成检查word
//        // 创建文档生成目录
//        StringBuffer uri = new StringBuffer();
//        uri.append("word/asked/check/");
//        uri.append(doctor.getSicmedBranch().getBranchCode());
//        uri.append("/");
//        uri.append(doctor.getUserNumber());
//
//        // 创建文档名
//        StringBuffer wordName = new StringBuffer();
//        wordName.append(UUID.randomUUID());
//        wordName.append(".doc");
//
//        // 创建文档生成路径
//        StringBuffer fileName = new StringBuffer();
//        fileName.append(uri.toString());
//        fileName.append("/");
//        fileName.append(wordName.toString());
//
//        // 创建velocity 上下文
//        VelocityContext velocityContext = new VelocityContext();
//
//        // velocity 对象赋值
//        velocityContext.put("checkPrintBeans", checkPrintBeans.getCheckPrintBean());
//        velocityContext.put("sicmedDoctorBean", sicmedDoctorBean);
//        velocityContext.put("sicmedPatientBean", sicmedPatientBean);
//        velocityContext.put("sicmedCaseBean", sicmedCaseBean);
//        velocityContext.put("sicmedRegisteredBean", sicmedRegisteredBean);
//        if (sicmedPatientDiseaseBeans != null) {
//            velocityContext.put("sicmedPatientDiseaseBeans", sicmedPatientDiseaseBeans.getSicmedPatientDiseaseBeans());
//        }
//        // 调用velocity工具类生成word
//        try {
//            VelocityUtil.createDoc(velocityContext, "wordvm/asked_check.vm", uri.toString(), fileName.toString());
//            SicmedWord sicmedWord = this.saveWord(wordName.toString(), uri.toString(), doctor, "0", printLoc,
//                    sicmedPatient);
//            checkPrintBeans.setWordId(sicmedWord.getId());
//            checkPrintBeans.setError("0");
//            checkPrintBeans.setErrorMessage("生成检查word成功");
//        } catch (Exception e) {
//            checkPrintBeans.setError("1");
//            checkPrintBeans.setErrorMessage("生成检查word失败!服务器内部异常!");
//            e.printStackTrace();
//        }
//        // 9.返回执行结果
//        return checkPrintBeans;
//    }
//
//
//    /**
//     * 生成检验医嘱单
//     *
//     * @param caseId
//     * @param ssid
//     * @param printLoc
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "createInspectWord")
//    public BaseBean createInspectWord(String caseId, String ssid, String printLoc) {
//        // 1.创建Bean对象
//        InspectPrintBeans inspectPrintBeans = new InspectPrintBeans();
//        // 2.传入参数校验
//        if (!AppParameterSimulation.simulationId(caseId)) {
//            inspectPrintBeans.setError("1");
//            inspectPrintBeans.setErrorMessage("输入的病历ID不正确");
//            return inspectPrintBeans;
//        }
//        // 3.创建查询对象
//        SicmedAsked sicmedAsked = new SicmedAsked();
//        // 4.查询对象赋值
//        SicmedCase sicmedCase = sicmedCaseService.get(caseId);
//        if (sicmedCase == null) {
//            inspectPrintBeans.setError("1");
//            inspectPrintBeans.setErrorMessage("病历不存在!");
//            return inspectPrintBeans;
//        }
//        SicmedAskedClass sicmedAskedClass = new SicmedAskedClass();
//        sicmedAskedClass.setClassNumber("1");
//        sicmedAskedClass = sicmedAskedClassService.get(sicmedAskedClass);
//        sicmedAsked.setSicmedCase(sicmedCase);
//        sicmedAsked.setSicmedAskedClass(sicmedAskedClass);
//        // 5.调用service
//        List<SicmedAsked> sicmedAskedes = sicmedAskedService.findList(sicmedAsked);
//        // 6.查询结果校验 处理
//        if (sicmedAskedes.size() > 0) {
//            for (SicmedAsked sicmedAsked2 : sicmedAskedes) {
//                InspectPrintBean inspectPrintBean = new InspectPrintBean();
//                SicmedInspect sicmedInspect = sicmedInspectService.get(sicmedAsked2.getOrderCode());
//                inspectPrintBean.setIPB(sicmedInspect);
//                inspectPrintBeans.getInspectPrintBean().add(inspectPrintBean);
//            }
//        } else {
//            inspectPrintBeans.setError("1");
//            inspectPrintBeans.setErrorMessage("生成word失败!服务器内部异常!");
//            return inspectPrintBeans;
//        }
//
//        // 7.获取需要打印的信息
//        // 获取诊疗医生
//        SicmedUser doctor = sicmedUserService.get(SsidUtils.getSicmedUserId(ssid));
//        SicmedUserBean sicmedDoctorBean = new SicmedUserBean();
//        sicmedDoctorBean.setSUser(doctor);
//        // 获取患者信息
//        SicmedPatient sicmedPatient = sicmedPatientService.get(sicmedCase.getSicmedPatient());
//        SicmedPatientBean sicmedPatientBean = new SicmedPatientBean();
//        sicmedPatientBean.setSP(sicmedPatient);
//        // 获取患者挂号信息
//        SicmedRegistered sicmedRegistered = new SicmedRegistered();
//        sicmedRegistered.setSicmedPatient(sicmedPatient);
//        sicmedRegistered = sicmedRegisteredService.getByP(sicmedRegistered);
//        SicmedRegisteredBean sicmedRegisteredBean = new SicmedRegisteredBean();
//        sicmedRegisteredBean.setSR(sicmedRegistered);
//        // 获取患者病历信息
//        SicmedCaseBean sicmedCaseBean = new SicmedCaseBean();
//        sicmedCaseBean.setSC(sicmedCase);
//        // 获取诊断信息
//        SicmedPatientDisease sicmedPatientDisease = new SicmedPatientDisease();
//        sicmedPatientDisease.setCaseCode(sicmedCase);
//        List<SicmedPatientDisease> sicmedPatientDiseases = sicmedPatientDiseaseService.findList(sicmedPatientDisease);
//        SicmedPatientDiseaseBeans sicmedPatientDiseaseBeans = null;
//        if (sicmedPatientDiseases.size() > 0) {
//            sicmedPatientDiseaseBeans = new SicmedPatientDiseaseBeans();
//            for (SicmedPatientDisease sicmedPatientDisease2 : sicmedPatientDiseases) {
//                SicmedPatientDiseaseBean sicmedPatientDiseaseBean = new SicmedPatientDiseaseBean();
//                sicmedPatientDiseaseBean.setspd(sicmedPatientDisease2);
//                sicmedPatientDiseaseBeans.getSicmedPatientDiseaseBeans().add(sicmedPatientDiseaseBean);
//            }
//        }
//        // 8.检查预览内容赋值
//        inspectPrintBeans.setSicmedDoctorBean(sicmedDoctorBean);
//        inspectPrintBeans.setSicmedCaseBean(sicmedCaseBean);
//        inspectPrintBeans.setSicmedRegisteredBean(sicmedRegisteredBean);
//        // 9.生成检查word
//        // 创建文档生成目录
//        StringBuffer uri = new StringBuffer();
//        uri.append("word/asked/inspect/");
//        uri.append(doctor.getSicmedBranch().getBranchCode());
//        uri.append("/");
//        uri.append(doctor.getUserNumber());
//
//        // 创建文档名
//        StringBuffer wordName = new StringBuffer();
//        wordName.append(UUID.randomUUID());
//        wordName.append(".doc");
//
//        // 创建文档生成路径
//        StringBuffer fileName = new StringBuffer();
//        fileName.append(uri.toString());
//        fileName.append("/");
//        fileName.append(wordName.toString());
//
//        // 创建velocity 上下文
//        VelocityContext velocityContext = new VelocityContext();
//
//        // velocity 对象赋值
//        velocityContext.put("inspectPrintBeans", inspectPrintBeans.getInspectPrintBean());
//        velocityContext.put("sicmedDoctorBean", sicmedDoctorBean);
//        velocityContext.put("sicmedPatientBean", sicmedPatientBean);
//        velocityContext.put("sicmedCaseBean", sicmedCaseBean);
//        velocityContext.put("sicmedRegisteredBean", sicmedRegisteredBean);
//        if (sicmedPatientDiseaseBeans != null) {
//            velocityContext.put("sicmedPatientDiseaseBeans", sicmedPatientDiseaseBeans);
//        }
//        // 调用velocity工具类生成word
//        try {
//            VelocityUtil.createDoc(velocityContext, "wordvm/asked_inspect.vm", uri.toString(), fileName.toString());
//            SicmedWord sicmedWord = this.saveWord(wordName.toString(), uri.toString(), doctor, "0", printLoc,
//                    sicmedPatient);
//            inspectPrintBeans.setWordId(sicmedWord.getId());
//            inspectPrintBeans.setError("0");
//            inspectPrintBeans.setErrorMessage("生成检查word成功");
//        } catch (Exception e) {
//            inspectPrintBeans.setError("1");
//            inspectPrintBeans.setErrorMessage("生成检查word失败!服务器内部异常!");
//            e.printStackTrace();
//        }
//        // 9.返回执行结果
//        return inspectPrintBeans;
//
//    }
//
//
//    /**
//     * 生成治疗医嘱单
//     *
//     * @param caseId
//     * @param ssid
//     * @param printLoc
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "createCureWord")
//    public BaseBean createCureWord(String caseId, String ssid, String printLoc) {
//        // 1.创建Bean对象
//        CurePrintBeans curePrintBeans = new CurePrintBeans();
//        // 2.传入参数校验
//        if (!AppParameterSimulation.simulationId(caseId)) {
//            curePrintBeans.setError("1");
//            curePrintBeans.setErrorMessage("输入的病历ID不正确");
//            return curePrintBeans;
//        }
//        // 3.创建查询对象
//        SicmedAsked sicmedAsked = new SicmedAsked();
//        // 4.查询对象赋值
//        SicmedCase sicmedCase = sicmedCaseService.get(caseId);
//        if (sicmedCase == null) {
//            curePrintBeans.setError("1");
//            curePrintBeans.setErrorMessage("病历不存在!");
//            return curePrintBeans;
//        }
//        SicmedAskedClass sicmedAskedClass = new SicmedAskedClass();
//        sicmedAskedClass.setClassNumber("2");
//        sicmedAskedClass = sicmedAskedClassService.get(sicmedAskedClass);
//        sicmedAsked.setSicmedCase(sicmedCase);
//        sicmedAsked.setSicmedAskedClass(sicmedAskedClass);
//        // 5.调用service
//        List<SicmedAsked> sicmedAskedes = sicmedAskedService.findList(sicmedAsked);
//        // 6.查询结果校验 处理
//        if (sicmedAskedes.size() > 0) {
//            for (SicmedAsked sicmedAsked2 : sicmedAskedes) {
//                CurePrintBean curePrintBean = new CurePrintBean();
//                SicmedCureCheck sicmedCureCheck = sicmedCureCheckService.get(sicmedAsked2.getOrderCode());
//                curePrintBean.setCPB(sicmedCureCheck);
//                curePrintBeans.getCurePrintBean().add(curePrintBean);
//            }
//        } else {
//            curePrintBeans.setError("1");
//            curePrintBeans.setErrorMessage("生成word失败!服务器内部异常!");
//            return curePrintBeans;
//        }
//
//        // 7.获取需要打印的信息
//        // 获取诊疗医生
//        SicmedUser doctor = sicmedUserService.get(SsidUtils.getSicmedUserId(ssid));
//        SicmedUserBean sicmedDoctorBean = new SicmedUserBean();
//        sicmedDoctorBean.setSUser(doctor);
//        // 获取患者信息
//        SicmedPatient sicmedPatient = sicmedPatientService.get(sicmedCase.getSicmedPatient());
//        SicmedPatientBean sicmedPatientBean = new SicmedPatientBean();
//        sicmedPatientBean.setSP(sicmedPatient);
//        // 获取患者挂号信息
//        SicmedRegistered sicmedRegistered = new SicmedRegistered();
//        sicmedRegistered.setSicmedPatient(sicmedPatient);
//        sicmedRegistered = sicmedRegisteredService.getByP(sicmedRegistered);
//        SicmedRegisteredBean sicmedRegisteredBean = new SicmedRegisteredBean();
//        sicmedRegisteredBean.setSR(sicmedRegistered);
//        // 获取患者病历信息
//        SicmedCaseBean sicmedCaseBean = new SicmedCaseBean();
//        sicmedCaseBean.setSC(sicmedCase);
//        // 获取诊断信息
//        SicmedPatientDisease sicmedPatientDisease = new SicmedPatientDisease();
//        sicmedPatientDisease.setCaseCode(sicmedCase);
//        List<SicmedPatientDisease> sicmedPatientDiseases = sicmedPatientDiseaseService.findList(sicmedPatientDisease);
//        SicmedPatientDiseaseBeans sicmedPatientDiseaseBeans = null;
//        if (sicmedPatientDiseases.size() > 0) {
//            sicmedPatientDiseaseBeans = new SicmedPatientDiseaseBeans();
//            for (SicmedPatientDisease sicmedPatientDisease2 : sicmedPatientDiseases) {
//                SicmedPatientDiseaseBean sicmedPatientDiseaseBean = new SicmedPatientDiseaseBean();
//                sicmedPatientDiseaseBean.setspd(sicmedPatientDisease2);
//                sicmedPatientDiseaseBeans.getSicmedPatientDiseaseBeans().add(sicmedPatientDiseaseBean);
//            }
//        }
//        // 8.检查预览内容赋值
//        curePrintBeans.setSicmedDoctorBean(sicmedDoctorBean);
//        curePrintBeans.setSicmedCaseBean(sicmedCaseBean);
//        curePrintBeans.setSicmedRegisteredBean(sicmedRegisteredBean);
//        // 9.生成检查word
//        // 创建文档生成目录
//        StringBuffer uri = new StringBuffer();
//        uri.append("word/asked/cure/");
//        uri.append(doctor.getSicmedBranch().getBranchCode());
//        uri.append("/");
//        uri.append(doctor.getUserNumber());
//
//        // 创建文档名
//        StringBuffer wordName = new StringBuffer();
//        wordName.append(UUID.randomUUID());
//        wordName.append(".doc");
//
//        // 创建文档生成路径
//        StringBuffer fileName = new StringBuffer();
//        fileName.append(uri.toString());
//        fileName.append("/");
//        fileName.append(wordName.toString());
//
//        // 创建velocity 上下文
//        VelocityContext velocityContext = new VelocityContext();
//
//        // velocity 对象赋值
//        velocityContext.put("CurePrintBeans", curePrintBeans.getCurePrintBean());
//        velocityContext.put("sicmedDoctorBean", sicmedDoctorBean);
//        velocityContext.put("sicmedPatientBean", sicmedPatientBean);
//        velocityContext.put("sicmedCaseBean", sicmedCaseBean);
//        velocityContext.put("sicmedRegisteredBean", sicmedRegisteredBean);
//        if (sicmedPatientDiseaseBeans != null) {
//            velocityContext.put("sicmedPatientDiseaseBeans", sicmedPatientDiseaseBeans);
//        }
//        // 调用velocity工具类生成word
//        try {
//            VelocityUtil.createDoc(velocityContext, "wordvm/asked_cure.vm", uri.toString(), fileName.toString());
//            SicmedWord sicmedWord = this.saveWord(wordName.toString(), uri.toString(), doctor, "0", printLoc,
//                    sicmedPatient);
//            curePrintBeans.setWordId(sicmedWord.getId());
//            curePrintBeans.setError("0");
//            curePrintBeans.setErrorMessage("生成检查word成功");
//        } catch (Exception e) {
//            curePrintBeans.setError("1");
//            curePrintBeans.setErrorMessage("生成检查word失败!服务器内部异常!");
//            e.printStackTrace();
//        }
//        // 9.返回执行结果
//        return curePrintBeans;
//
//    }
//
//
//    /**
//     * 生成药品医嘱单
//     *
//     * @param caseId
//     * @param ssid
//     * @param printLoc
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "createMedicalWord")
//    public BaseBean createMedicalWord(String caseId, String ssid, String printLoc) {
//        // 1.创建Bean对象
//        MedicalPrintBeans medicalPrintBeans = new MedicalPrintBeans();
//        // 2.传入参数校验
//        if (!AppParameterSimulation.simulationId(caseId)) {
//            medicalPrintBeans.setError("1");
//            medicalPrintBeans.setErrorMessage("输入的病历ID不正确");
//            return medicalPrintBeans;
//        }
//        // 3.创建查询对象
//        SicmedAsked sicmedAsked = new SicmedAsked();
//        // 4.查询对象赋值
//        SicmedCase sicmedCase = sicmedCaseService.get(caseId);
//        if (sicmedCase == null) {
//            medicalPrintBeans.setError("1");
//            medicalPrintBeans.setErrorMessage("病历不存在!");
//            return medicalPrintBeans;
//        }
//        SicmedAskedClass sicmedAskedClass = new SicmedAskedClass();
//        sicmedAskedClass.setClassNumber("3");
//        sicmedAskedClass = sicmedAskedClassService.get(sicmedAskedClass);
//        sicmedAsked.setSicmedCase(sicmedCase);
//        sicmedAsked.setSicmedAskedClass(sicmedAskedClass);
//        // 5.调用service
//        List<SicmedAsked> sicmedAskedes = sicmedAskedService.findList(sicmedAsked);
//        // 6.查询结果校验 处理
//        if (sicmedAskedes.size() > 0) {
//            Integer wMedTotalPrice = 0;
//            Integer cMedTotalPrice = 0;
//            for (SicmedAsked sicmedAsked2 : sicmedAskedes) {
//                MedicalPrintBean medicalPrintBean = new MedicalPrintBean();
//                SicmedMedical sicmedMedical = sicmedMedicalService.get(sicmedAsked2.getOrderCode());
//                //获取医嘱信息
//                SicmedAskedBean sicmedAskedBean = new SicmedAskedBean();
//                sicmedAskedBean.setSAB(sicmedAsked2);
//                //获取药品用法
//                SicmedMedicalUse sicmedMedicalUse = sicmedMedicalUseService.get(sicmedAsked2.getSicmedMedicalUse());
//                SicmedMedicalUseBean sicmedMedicalUseBean = new SicmedMedicalUseBean();
//                sicmedMedicalUseBean.setSMUB(sicmedMedicalUse);
//                //获取药品价格
//                SicmedMedicalPriceBean sicmedMedicalPriceBean = new SicmedMedicalPriceBean();
//                SicmedMedicalPrice sicmedMedicalPrice = new SicmedMedicalPrice();
//                sicmedMedicalPrice.setSicmedMedical(sicmedMedical);
//                sicmedMedicalPrice = sicmedMedicalPriceService.get(sicmedMedicalPrice);
//                sicmedMedicalPriceBean.setSicmedMedicaPrice(sicmedMedicalPrice);
//                //获取患者价格表
//                SicmedPatientPriceBean sicmedPatientPriceBean = new SicmedPatientPriceBean();
//                SicmedPatientPrice sicmedPatientPrice = sicmedPatientPriceService.get(sicmedAsked2.getSicmedPatientPrice());
//                sicmedPatientPriceBean.setSicmedPatientPrice(sicmedPatientPrice);
//                //获取当前药品总价
//                String salePrice = sicmedMedicalPrice.getPriceSale();
//                String number = sicmedPatientPrice.getNumber();
//                Integer medicalTotalPrice = Integer.parseInt(salePrice) * Integer.parseInt(number);
//                medicalPrintBean.setMedicalTotalPrice(medicalTotalPrice.toString());
//
//                medicalPrintBean.setMPB(sicmedMedical);
//                medicalPrintBean.setSicmedMedicalUseBean(sicmedMedicalUseBean);
//                medicalPrintBean.setSicmedMedicalPriceBean(sicmedMedicalPriceBean);
//                medicalPrintBean.setSicmedAskedBean(sicmedAskedBean);
//                medicalPrintBean.setSicmedPatientPriceBean(sicmedPatientPriceBean);
//
//                SicmedMedicalClass sicmedMedicalClass = sicmedMedicalClassService.get(sicmedMedical.getMedicalClassOne());
//                if (sicmedMedicalClass != null && sicmedMedicalClass.getName() != null && sicmedMedicalClass.getName().equals("中药")) {
//                    cMedTotalPrice = cMedTotalPrice + medicalTotalPrice;
//                    medicalPrintBeans.getcMedicalPrintBean().add(medicalPrintBean);
//                } else {
//                    wMedTotalPrice = wMedTotalPrice + medicalTotalPrice;
//                    medicalPrintBeans.getwMedicalPrintBean().add(medicalPrintBean);
//                }
//            }
//            medicalPrintBeans.setcMedTotalPrice(cMedTotalPrice.toString());
//            medicalPrintBeans.setwMedTotalPrice(wMedTotalPrice.toString());
//        } else {
//            medicalPrintBeans.setError("1");
//            medicalPrintBeans.setErrorMessage("生成word失败!服务器内部异常!");
//            return medicalPrintBeans;
//        }
//
//        // 7.获取需要打印的信息
//        // 获取诊疗医生
//        SicmedUser doctor = sicmedUserService.get(SsidUtils.getSicmedUserId(ssid));
//        SicmedUserBean sicmedDoctorBean = new SicmedUserBean();
//        sicmedDoctorBean.setSUser(doctor);
//        // 获取患者信息
//        SicmedPatient sicmedPatient = sicmedPatientService.get(sicmedCase.getSicmedPatient());
//        SicmedPatientBean sicmedPatientBean = new SicmedPatientBean();
//        sicmedPatientBean.setSP(sicmedPatient);
//        // 获取患者挂号信息
//        SicmedRegistered sicmedRegistered = new SicmedRegistered();
//        sicmedRegistered.setSicmedPatient(sicmedPatient);
//        sicmedRegistered = sicmedRegisteredService.getByP(sicmedRegistered);
//        SicmedRegisteredBean sicmedRegisteredBean = new SicmedRegisteredBean();
//        sicmedRegisteredBean.setSR(sicmedRegistered);
//        // 获取患者病历信息
//        SicmedCaseBean sicmedCaseBean = new SicmedCaseBean();
//        sicmedCaseBean.setSC(sicmedCase);
//        // 获取诊断信息
//        SicmedPatientDisease sicmedPatientDisease = new SicmedPatientDisease();
//        sicmedPatientDisease.setCaseCode(sicmedCase);
//        List<SicmedPatientDisease> sicmedPatientDiseases = sicmedPatientDiseaseService.findList(sicmedPatientDisease);
//        SicmedPatientDiseaseBeans sicmedPatientDiseaseBeans = null;
//        if (sicmedPatientDiseases.size() > 0) {
//            sicmedPatientDiseaseBeans = new SicmedPatientDiseaseBeans();
//            for (SicmedPatientDisease sicmedPatientDisease2 : sicmedPatientDiseases) {
//                SicmedPatientDiseaseBean sicmedPatientDiseaseBean = new SicmedPatientDiseaseBean();
//                sicmedPatientDiseaseBean.setspd(sicmedPatientDisease2);
//                sicmedPatientDiseaseBeans.getSicmedPatientDiseaseBeans().add(sicmedPatientDiseaseBean);
//            }
//        }
//        // 8.检查预览内容赋值
//        medicalPrintBeans.setSicmedDoctorBean(sicmedDoctorBean);
//        medicalPrintBeans.setSicmedCaseBean(sicmedCaseBean);
//        medicalPrintBeans.setSicmedRegisteredBean(sicmedRegisteredBean);
//        // 9.生成检查word
//        // 创建文档生成目录
//        StringBuffer uri = new StringBuffer();
//        uri.append("word/asked/medical/");
//        uri.append(doctor.getSicmedBranch().getBranchCode());
//        uri.append("/");
//        uri.append(doctor.getUserNumber());
//
//        // 创建文档名
//        StringBuffer wordName = new StringBuffer();
//        wordName.append(UUID.randomUUID());
//        wordName.append(".doc");
//
//        // 创建文档生成路径
//        StringBuffer fileName = new StringBuffer();
//        fileName.append(uri.toString());
//        fileName.append("/");
//        fileName.append(wordName.toString());
//
//        // 创建velocity 上下文
//        VelocityContext velocityContext = new VelocityContext();
//
//        // velocity 对象赋值
//        velocityContext.put("cMedicalPrintBeans", medicalPrintBeans.getcMedicalPrintBean());
//        velocityContext.put("wMedicalPrintBeans", medicalPrintBeans.getwMedicalPrintBean());
//        velocityContext.put("sicmedDoctorBean", sicmedDoctorBean);
//        velocityContext.put("sicmedPatientBean", sicmedPatientBean);
//        velocityContext.put("sicmedCaseBean", sicmedCaseBean);
//        velocityContext.put("sicmedRegisteredBean", sicmedRegisteredBean);
//        if (sicmedPatientDiseaseBeans != null) {
//            velocityContext.put("sicmedPatientDiseaseBeans", sicmedPatientDiseaseBeans);
//        }
//
//        // 调用velocity工具类生成word
//        try {
//            VelocityUtil.createDoc(velocityContext, "wordvm/asked_medical.vm", uri.toString(), fileName.toString());
//            SicmedWord sicmedWord = this.saveWord(wordName.toString(), uri.toString(), doctor, "0", printLoc, sicmedPatient);
//            medicalPrintBeans.setWordId(sicmedWord.getId());
//            medicalPrintBeans.setError("0");
//            medicalPrintBeans.setErrorMessage("生成药品word成功");
//        } catch (Exception e) {
//            medicalPrintBeans.setError("1");
//            medicalPrintBeans.setErrorMessage("生成药品word失败!服务器内部异常!");
//            e.printStackTrace();
//        }
//        // 9.返回执行结果
//        return medicalPrintBeans;
//
//    }
//
//
//    /**
//     * 生成挂号单
//     *
//     * @param caseId
//     * @param ssid
//     * @param printLoc
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "createRegisteredWord")
//    public BaseBean createRegisteredWord(String caseId, String ssid, String printLoc) {
//
//        return null;
//
//    }
//
//    /**
//     * 生成改号单
//     *
//     * @param caseId
//     * @param ssid
//     * @param printLoc
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "createUpRegisteredWord")
//    public BaseBean createUpRegisteredWord(String caseId, String ssid, String printLoc) {
//
//        return null;
//
//    }
//
//    /**
//     * 生成退号凭证
//     *
//     * @param caseId
//     * @param ssid
//     * @param printLoc
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "createDelRegisteredWord")
//    public BaseBean createDelRegisteredWord(String caseId, String ssid, String printLoc) {
//
//        return null;
//
//    }
//
//    /**
//     * 生成检查缴费清单
//     *
//     * @param caseId
//     * @param ssid
//     * @param printLoc
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "createCheckPaymentWord")
//    public BaseBean createCheckPaymentWord(String caseId, String ssid, String printLoc) {
//
//        return null;
//
//    }
//
//    /**
//     * 生成检验缴费清单
//     *
//     * @param caseId
//     * @param ssid
//     * @param printLoc
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "createInspectPaymentWord")
//    public BaseBean createInspectPaymentWord(String caseId, String ssid, String printLoc) {
//
//        return null;
//
//    }
//
//    /**
//     * 生成治疗缴费清单
//     *
//     * @param caseId
//     * @param ssid
//     * @param printLoc
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "createCurePaymentWord")
//    public BaseBean createCurePaymentWord(String caseId, String ssid, String printLoc) {
//
//        return null;
//
//    }
//
//    /**
//     * 生成药品缴费清单
//     *
//     * @param caseId
//     * @param ssid
//     * @param printLoc
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "createMedicalPaymentWord")
//    public BaseBean createMedicalPaymentWord(String caseId, String ssid, String printLoc) {
//
//        return null;
//
//    }
//
//    /**
//     * 生成检查退费清单
//     *
//     * @param caseId
//     * @param ssid
//     * @param printLoc
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "createCheckRefundWord")
//    public BaseBean createCheckRefundWord(String caseId, String ssid, String printLoc) {
//
//        return null;
//
//    }
//
//    /**
//     * 生成检验退费清单
//     *
//     * @param caseId
//     * @param ssid
//     * @param printLoc
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "createInspectRefundWord")
//    public BaseBean createInspectRefundWord(String caseId, String ssid, String printLoc) {
//
//        return null;
//
//    }
//
//    /**
//     * 生成治疗退费清单
//     *
//     * @param caseId
//     * @param ssid
//     * @param printLoc
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "createCureRefundWord")
//    public BaseBean createCureRefundWord(String caseId, String ssid, String printLoc) {
//
//        return null;
//
//    }
//
//    /**
//     * 生成药品退费清单
//     *
//     * @param caseId
//     * @param ssid
//     * @param printLoc
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "createMedicalRefundWord")
//    public BaseBean createMedicalRefundWord(String caseId, String ssid, String printLoc) {
//
//        return null;
//
//    }
//
//    /**
//     * 保存生成的 word 信息
//     *
//     * @param wordName
//     * @param wordUri
//     * @param createUser
//     * @param printType
//     * @param printLoc
//     * @param sicmedPatient
//     * @return
//     */
//
//    public SicmedWord saveWord(String wordName, String wordUri, SicmedUser createUser, String printType,
//                               String printLoc, SicmedPatient sicmedPatient) {
//        logger.debug(printLoc);
//        SicmedWord sicmedWord = new SicmedWord();
//        sicmedWord.setWordName(wordName);
//        sicmedWord.setWordUri(wordUri);
//        sicmedWord.setCreateUser(createUser);
//        sicmedWord.setPrintType(printType);
//        sicmedWord.setPrintLoc(printLoc);
//        sicmedWord.setSicmedPatient(sicmedPatient);
//        sicmedwordService.save(sicmedWord);
//        return sicmedwordService.get(sicmedWord);
//
//    }
//
//}