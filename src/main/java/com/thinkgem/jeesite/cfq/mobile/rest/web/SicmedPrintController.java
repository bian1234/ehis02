//package com.thinkgem.jeesite.cfq.mobile.rest.web;
//
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
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCaseBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientDiseaseBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientDiseaseBeans;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedRegisteredBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedUserBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.AskedPrintBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.CheckPrintBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.CurePrintBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.InspectPrintBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.MedicalPrintBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.RegisteredPrintBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAsked;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCase;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCureCheck;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspect;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedical;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalClass;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatient;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatientDisease;
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
///**
// * @author Max
// * @version 2016-07-12
// */
//@Controller
//@RequestMapping(value = "${adminPath}/rest/sicmedPrint")
//public class SicmedPrintController extends BaseController {
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
//     * 获取医嘱打印信息
//     */
//    @ResponseBody
//    @RequestMapping(value = "printAsked")
//    public BaseBean printAsked(String caseId, String ssid, String printLoc) {
//
//        AskedPrintBean askedPrintBean = new AskedPrintBean();
//        // 判断传入参数
//        if (AppParameterSimulation.isEmpty(caseId)) {
//            askedPrintBean.setError("1");
//            askedPrintBean.setErrorMessage("输入参数为空");
//            return askedPrintBean;
//        } else if (!AppParameterSimulation.simulationId(caseId)) {
//            askedPrintBean.setError("1");
//            askedPrintBean.setErrorMessage("输入的病历ID不正确");
//            return askedPrintBean;
//        }
//        // 创建查询条件
//        SicmedAsked sicmedAsked = new SicmedAsked();
//        // 获取查询条件属性
//        SicmedCase sicmedCase = sicmedCaseService.get(caseId);
//        // 判断查询条件属性
//        if (sicmedCase == null) {
//            askedPrintBean.setError("1");
//            askedPrintBean.setErrorMessage("病历不存在!");
//            return askedPrintBean;
//        }
//        SicmedPatient sicmedPatient = sicmedPatientService.get(sicmedCase.getSicmedPatient());
//        // 为查询条件赋值
//        sicmedAsked.setSicmedCase(sicmedCase);
//        // 根据查询添加查询医嘱信息
//        List<SicmedAsked> sicmedAskedes = sicmedAskedService.findList(sicmedAsked);
//        // 创建空的返回结果
//
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
//                        askedPrintBean.getCurePrintBean().add(curePrintBean);
//                        break;
//                    case 3:// 药品
//                        MedicalPrintBean medicalPrintBean = new MedicalPrintBean();
//                        SicmedMedical sicmedMedical = sicmedMedicalService.get(sicmedAsked2.getOrderCode());
//                        medicalPrintBean.setMPB(sicmedMedical);
//                        SicmedMedicalClass sicmedMedicalClass = sicmedMedicalClassService.get(sicmedMedical.getMedicalClassOne());
//                        if (sicmedMedicalClass != null && sicmedMedicalClass.getName() != null && sicmedMedicalClass.getName().equals("中药")) {
//                            askedPrintBean.getcMedicalPrintBean().add(medicalPrintBean);
//                        } else {
//                            askedPrintBean.getwMedicalPrintBean().add(medicalPrintBean);
//                        }
//                        break;
//                    case 4:// 嘱托
//                        break;
//                    default:
//                        break;
//                }
//            }
//            askedPrintBean.setError("0");
//            askedPrintBean.setErrorMessage("请求成功");
//            //获取诊疗医生
//            SicmedUser doctor = sicmedUserService.get(SsidUtils.getSicmedUserId(ssid));
//            SicmedUserBean sicmedDoctorBean = new SicmedUserBean();
//            sicmedDoctorBean.setSUser(doctor);
//            //获取患者信息
//            SicmedPatientBean sicmedPatientBean = new SicmedPatientBean();
//            sicmedPatientBean.setSP(sicmedPatient);
//            //获取患者挂号信息
//            SicmedRegistered sicmedRegistered = new SicmedRegistered();
//            sicmedRegistered.setSicmedPatient(sicmedPatient);
//            sicmedRegistered = sicmedRegisteredService.getByP(sicmedRegistered);
//            SicmedRegisteredBean sicmedRegisteredBean = new SicmedRegisteredBean();
//            sicmedRegisteredBean.setSR(sicmedRegistered);
//            //获取患者病历信息
//            SicmedCaseBean sicmedCaseBean = new SicmedCaseBean();
//            sicmedCaseBean.setSC(sicmedCase);
//            //获取诊断信息
//            SicmedPatientDisease sicmedPatientDisease = new SicmedPatientDisease();
//            sicmedPatientDisease.setCaseCode(sicmedCase);
//            List<SicmedPatientDisease> sicmedPatientDiseases = sicmedPatientDiseaseService.findList(sicmedPatientDisease);
//            SicmedPatientDiseaseBeans sicmedPatientDiseaseBeans = null;
//            if (sicmedPatientDiseases.size() > 0) {
//                sicmedPatientDiseaseBeans = new SicmedPatientDiseaseBeans();
//                for (SicmedPatientDisease sicmedPatientDisease2 : sicmedPatientDiseases) {
//                    SicmedPatientDiseaseBean sicmedPatientDiseaseBean = new SicmedPatientDiseaseBean();
//                    sicmedPatientDiseaseBean.setspd(sicmedPatientDisease2);
//                    sicmedPatientDiseaseBeans.getSicmedPatientDiseaseBeans().add(sicmedPatientDiseaseBean);
//                }
//            }
//            if (askedPrintBean.getcMedicalPrintBean().size() > 0) {
//
//                StringBuffer uri = new StringBuffer();
//
//                uri.append("word/asked/cmedical/");
//                uri.append(doctor.getSicmedBranch().getBranchCode());
//                uri.append("/");
//                uri.append(doctor.getDoctorCode());
//
//                StringBuffer wordName = new StringBuffer();
//
//                wordName.append(UUID.randomUUID());
//                wordName.append(".doc");
//
//                StringBuffer fileName = new StringBuffer();
//                fileName.append(uri.toString());
//                fileName.append("/");
//                fileName.append(wordName.toString());
//
//                VelocityContext velocityContext = new VelocityContext();
//                velocityContext.put("cMedicalPrintBeans", askedPrintBean.getcMedicalPrintBean());
//                velocityContext.put("sicmedDoctorBean", sicmedDoctorBean);
//                velocityContext.put("sicmedPatientBean", sicmedPatientBean);
//                velocityContext.put("sicmedCaseBean", sicmedCaseBean);
//                velocityContext.put("sicmedRegisteredBean", sicmedRegisteredBean);
//                if (sicmedPatientDiseaseBeans != null) {
//                    velocityContext.put("sicmedPatientDiseaseBeans", sicmedPatientDiseaseBeans);
//                }
//                try {
//                    VelocityUtil.createDoc(velocityContext, "wordvm/asked_cmedical.vm", uri.toString(), fileName.toString());
//                    this.saveWord(wordName.toString(), uri.toString(), doctor, "0", printLoc, sicmedPatient);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            if (askedPrintBean.getwMedicalPrintBean().size() > 0) {
//                StringBuffer uri = new StringBuffer();
//
//                uri.append("word/asked/wmedical/");
//                uri.append(doctor.getSicmedBranch().getBranchCode());
//                uri.append("/");
//                uri.append(doctor.getDoctorCode());
//
//                StringBuffer wordName = new StringBuffer();
//
//                wordName.append(UUID.randomUUID());
//                wordName.append(".doc");
//
//                StringBuffer fileName = new StringBuffer();
//                fileName.append(uri.toString());
//                fileName.append("/");
//                fileName.append(wordName.toString());
//
//                VelocityContext velocityContext = new VelocityContext();
//                velocityContext.put("wMedicalPrintBeans", askedPrintBean.getwMedicalPrintBean());
//                velocityContext.put("sicmedDoctorBean", sicmedDoctorBean);
//                velocityContext.put("sicmedPatientBean", sicmedPatientBean);
//                velocityContext.put("sicmedCaseBean", sicmedCaseBean);
//                velocityContext.put("sicmedRegisteredBean", sicmedRegisteredBean);
//                if (sicmedPatientDiseaseBeans != null) {
//                    velocityContext.put("sicmedPatientDiseaseBeans", sicmedPatientDiseaseBeans);
//                }
//                try {
//                    VelocityUtil.createDoc(velocityContext, "wordvm/asked_wmedical.vm", uri.toString(), fileName.toString());
//                    this.saveWord(wordName.toString(), uri.toString(), doctor, "0", printLoc, sicmedPatient);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            if (askedPrintBean.getCheckPrintBean().size() > 0) {
//                StringBuffer uri = new StringBuffer();
//
//                uri.append("word/asked/check/");
//                uri.append(doctor.getSicmedBranch().getBranchCode());
//                uri.append("/");
//                uri.append(doctor.getDoctorCode());
//
//                StringBuffer wordName = new StringBuffer();
//
//                wordName.append(UUID.randomUUID());
//                wordName.append(".doc");
//
//                StringBuffer fileName = new StringBuffer();
//                fileName.append(uri.toString());
//                fileName.append("/");
//                fileName.append(wordName.toString());
//
//                VelocityContext velocityContext = new VelocityContext();
//                velocityContext.put("checkPrintBean", askedPrintBean.getCheckPrintBean());
//                velocityContext.put("sicmedDoctorBean", sicmedDoctorBean);
//                velocityContext.put("sicmedPatientBean", sicmedPatientBean);
//                velocityContext.put("sicmedCaseBean", sicmedCaseBean);
//                velocityContext.put("sicmedRegisteredBean", sicmedRegisteredBean);
//                if (sicmedPatientDiseaseBeans != null) {
//                    velocityContext.put("sicmedPatientDiseaseBeans", sicmedPatientDiseaseBeans);
//                }
//                try {
//                    VelocityUtil.createDoc(velocityContext, "wordvm/asked_check.vm", uri.toString(), fileName.toString());
//                    this.saveWord(wordName.toString(), uri.toString(), doctor, "0", printLoc, sicmedPatient);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            if (askedPrintBean.getInspectPrintBean().size() > 0) {
//                StringBuffer uri = new StringBuffer();
//
//                uri.append("word/asked/inspect/");
//                uri.append(doctor.getSicmedBranch().getBranchCode());
//                uri.append("/");
//                uri.append(doctor.getDoctorCode());
//
//
//                StringBuffer wordName = new StringBuffer();
//
//                wordName.append(UUID.randomUUID());
//                wordName.append(".doc");
//
//                StringBuffer fileName = new StringBuffer();
//                fileName.append(uri.toString());
//                fileName.append("/");
//                fileName.append(wordName.toString());
//
//                VelocityContext velocityContext = new VelocityContext();
//                velocityContext.put("inspectPrintBean", askedPrintBean.getInspectPrintBean());
//                velocityContext.put("sicmedDoctorBean", sicmedDoctorBean);
//                velocityContext.put("sicmedPatientBean", sicmedPatientBean);
//                velocityContext.put("sicmedCaseBean", sicmedCaseBean);
//                velocityContext.put("sicmedRegisteredBean", sicmedRegisteredBean);
//                if (sicmedPatientDiseaseBeans != null) {
//                    velocityContext.put("sicmedPatientDiseaseBeans", sicmedPatientDiseaseBeans);
//                }
//                try {
//                    VelocityUtil.createDoc(velocityContext, "wordvm/asked_inspect.vm", uri.toString(), fileName.toString());
//                    this.saveWord(wordName.toString(), uri.toString(), doctor, "0", printLoc, sicmedPatient);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            if (askedPrintBean.getCurePrintBean().size() > 0) {
//                StringBuffer uri = new StringBuffer();
//
//                uri.append("word/asked/cure/");
//                uri.append(doctor.getSicmedBranch().getBranchCode());
//                uri.append("/");
//                uri.append(doctor.getDoctorCode());
//
//                StringBuffer wordName = new StringBuffer();
//
//                wordName.append(UUID.randomUUID());
//                wordName.append(".doc");
//
//                StringBuffer fileName = new StringBuffer();
//
//                fileName.append(uri.toString());
//                fileName.append("/");
//                fileName.append(wordName.toString());
//                VelocityContext velocityContext = new VelocityContext();
//                velocityContext.put("curePrintBean", askedPrintBean.getCurePrintBean());
//                velocityContext.put("sicmedDoctorBean", sicmedDoctorBean);
//                velocityContext.put("sicmedPatientBean", sicmedPatientBean);
//                velocityContext.put("sicmedCaseBean", sicmedCaseBean);
//                velocityContext.put("sicmedRegisteredBean", sicmedRegisteredBean);
//                if (sicmedPatientDiseaseBeans != null) {
//                    velocityContext.put("sicmedPatientDiseaseBeans", sicmedPatientDiseaseBeans);
//                }
//                try {
//                    VelocityUtil.createDoc(velocityContext, "wordvm/asked_cure.vm", uri.toString(), fileName.toString());
//                    this.saveWord(wordName.toString(), uri.toString(), doctor, "0", printLoc, sicmedPatient);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        } else {
//            // 查询结果为空
//            askedPrintBean.setError("1");
//            askedPrintBean.setErrorMessage("没有需要打印的信息");
//        }
//        return askedPrintBean;
//    }
//
//
//    @ResponseBody
//    @RequestMapping(value = "printCase")
//    public BaseBean printCase(String caseId, String ssid, String printLoc) {
//
//        AskedPrintBean askedPrintBean = new AskedPrintBean();
//        // 判断传入参数
//        if (AppParameterSimulation.isEmpty(caseId)) {
//            askedPrintBean.setError("1");
//            askedPrintBean.setErrorMessage("输入参数为空");
//            return askedPrintBean;
//        } else if (!AppParameterSimulation.simulationId(caseId)) {
//            askedPrintBean.setError("1");
//            askedPrintBean.setErrorMessage("输入的病历ID不正确");
//            return askedPrintBean;
//        }
//        // 创建查询条件
//        SicmedAsked sicmedAsked = new SicmedAsked();
//        // 获取查询条件属性
//        SicmedCase sicmedCase = sicmedCaseService.get(caseId);
//        // 判断查询条件属性
//        if (sicmedCase == null) {
//            askedPrintBean.setError("1");
//            askedPrintBean.setErrorMessage("病历不存在!");
//            return askedPrintBean;
//        }
//        SicmedPatient sicmedPatient = sicmedPatientService.get(sicmedCase.getSicmedPatient());
//        // 为查询条件赋值
//        sicmedAsked.setSicmedCase(sicmedCase);
//        // 根据查询添加查询医嘱信息
//        List<SicmedAsked> sicmedAskedes = sicmedAskedService.findList(sicmedAsked);
//        // 创建空的返回结果
//        VelocityContext velocityContext = new VelocityContext();
//
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
//                        SicmedMedicalClass sicmedMedicalClass = sicmedMedicalClassService.get(sicmedMedical.getMedicalClassOne());
//                        if (sicmedMedicalClass != null && sicmedMedicalClass.getName() != null && sicmedMedicalClass.getName().equals("中药")) {
//                            askedPrintBean.getcMedicalPrintBean().add(medicalPrintBean);
//                        } else {
//                            askedPrintBean.getwMedicalPrintBean().add(medicalPrintBean);
//                        }
//                        break;
//                    case 4:// 嘱托
//                        break;
//                    default:
//                        break;
//                }
//            }
//            //获取诊疗医生
//            SicmedUser doctor = sicmedUserService.get(SsidUtils.getSicmedUserId(ssid));
//            SicmedUserBean sicmedDoctorBean = new SicmedUserBean();
//            sicmedDoctorBean.setSUser(doctor);
//            //获取患者信息
//            SicmedPatientBean sicmedPatientBean = new SicmedPatientBean();
//            sicmedPatientBean.setSP(sicmedPatient);
//            //获取患者挂号信息
//            SicmedRegistered sicmedRegistered = new SicmedRegistered();
//            sicmedRegistered.setSicmedPatient(sicmedPatient);
//            sicmedRegistered = sicmedRegisteredService.getByP(sicmedRegistered);
//            SicmedRegisteredBean sicmedRegisteredBean = new SicmedRegisteredBean();
//            sicmedRegisteredBean.setSR(sicmedRegistered);
//            //获取患者病历信息
//            SicmedCaseBean sicmedCaseBean = new SicmedCaseBean();
//            sicmedCaseBean.setSC(sicmedCase);
//            velocityContext.put("sicmedCaseBean", sicmedCaseBean);
//            //获取诊断信息
//            SicmedPatientDisease sicmedPatientDisease = new SicmedPatientDisease();
//            sicmedPatientDisease.setCaseCode(sicmedCase);
//            List<SicmedPatientDisease> sicmedPatientDiseases = sicmedPatientDiseaseService.findList(sicmedPatientDisease);
//            SicmedPatientDiseaseBeans sicmedPatientDiseaseBeans = null;
//            if (sicmedPatientDiseases.size() > 0) {
//                sicmedPatientDiseaseBeans = new SicmedPatientDiseaseBeans();
//                for (SicmedPatientDisease sicmedPatientDisease2 : sicmedPatientDiseases) {
//                    SicmedPatientDiseaseBean sicmedPatientDiseaseBean = new SicmedPatientDiseaseBean();
//                    sicmedPatientDiseaseBean.setspd(sicmedPatientDisease2);
//                    sicmedPatientDiseaseBeans.getSicmedPatientDiseaseBeans().add(sicmedPatientDiseaseBean);
//                }
//            }
//            StringBuffer uri = new StringBuffer();
//            uri.append("word/case/");
//            uri.append(doctor.getSicmedBranch().getBranchCode());
//            uri.append("/");
//            uri.append(doctor.getDoctorCode());
//            StringBuffer wordName = new StringBuffer();
//
//            wordName.append(UUID.randomUUID());
//            wordName.append(".doc");
//            StringBuffer fileName = new StringBuffer();
//
//            fileName.append(uri.toString());
//            fileName.append("/");
//            fileName.append(wordName.toString());
//
//
//            velocityContext.put("sicmedDoctorBean", sicmedDoctorBean);
//            velocityContext.put("sicmedPatientBean", sicmedPatientBean);
//            velocityContext.put("sicmedRegisteredBean", sicmedRegisteredBean);
//            if (sicmedPatientDiseaseBeans != null) {
//                velocityContext.put("sicmedPatientDiseaseBeans", sicmedPatientDiseaseBeans);
//            }
//            if (askedPrintBean.getcMedicalPrintBean().size() > 0) {
//                velocityContext.put("cMedicalPrintBeans", askedPrintBean.getcMedicalPrintBean());
//            }
//            if (askedPrintBean.getwMedicalPrintBean().size() > 0) {
//                velocityContext.put("wMedicalPrintBeans", askedPrintBean.getwMedicalPrintBean());
//            }
//            if (askedPrintBean.getCheckPrintBean().size() > 0) {
//                velocityContext.put("checkPrintBeans", askedPrintBean.getCheckPrintBean());
//            }
//            if (askedPrintBean.getInspectPrintBean().size() > 0) {
//                velocityContext.put("inspectPrintBeans", askedPrintBean.getInspectPrintBean());
//            }
//            if (askedPrintBean.getCurePrintBean().size() > 0) {
//                velocityContext.put("curePrintBeans", askedPrintBean.getCurePrintBean());
//            }
//            try {
//                VelocityUtil.createDoc(velocityContext, "wordvm/case.vm", uri.toString(), fileName.toString());
//                this.saveWord(wordName.toString(), uri.toString(), doctor, "0", printLoc, sicmedPatient);
//                askedPrintBean.setError("0");
//                askedPrintBean.setErrorMessage("打印成功");
//            } catch (Exception e) {
//                e.printStackTrace();
//                askedPrintBean.setError("1");
//                askedPrintBean.setErrorMessage("打印失败");
//                return askedPrintBean;
//            }
//        } else {
//            //获取患者病历信息
//            SicmedCaseBean sicmedCaseBean = new SicmedCaseBean();
//            sicmedCaseBean.setSC(sicmedCase);
//            velocityContext.put("sicmedCaseBean", sicmedCaseBean);
//            // 查询结果为空
//            askedPrintBean.setError("1");
//            askedPrintBean.setErrorMessage("打印失败");
//        }
//
//
//        return askedPrintBean;
//    }
//
//
//    /**
//     * 生成挂号单word
//     *
//     * @param caseId
//     * @param ssid
//     * @param printLoc
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printRegistered")
//    public BaseBean printRegistered(String caseId, String ssid, String printLoc) {
//
//        //1.创建返回对象
//        RegisteredPrintBean registeredPrintBean = new RegisteredPrintBean();
//        //2.传入参数校验
//        if (AppParameterSimulation.isEmpty(caseId)) {
//
//        }
//        //3.创建查询对象
//        SicmedRegistered sicmedRegistered = new SicmedRegistered();
//        //4.查询对象赋值
//        sicmedRegistered.setId(caseId);
//        //5.调用service查询
//        sicmedRegistered = sicmedRegisteredService.get(sicmedRegistered);
//        //6.查询结果处理
//        if (sicmedRegistered == null) {
//            registeredPrintBean.setError("1");
//            registeredPrintBean.setSuccessMessage("要打印的信息不存在.");
//            return registeredPrintBean;
//        }
//
//        try {
////			VelocityUtil.createDoc(velocityContext, "wordvm/case.vm", uri.toString(), fileName.toString());
////			this.saveWord(wordName.toString(),uri.toString(),doctor,"0",printLoc,sicmedPatient);
//            registeredPrintBean.setError("0");
//            registeredPrintBean.setSuccessMessage("word文档创建成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//            registeredPrintBean.setError("1");
//            registeredPrintBean.setSuccessMessage("word文档创建失败");
//            return registeredPrintBean;
//        }
//
//
//        return registeredPrintBean;
//
//    }
//
//
//    /**
//     * 生成改好凭证word
//     *
//     * @param caseId
//     * @param ssid
//     * @param printLoc
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printUpRegistered")
//    public BaseBean printUpRegistered(String caseId, String ssid, String printLoc) {
//
//        return null;
//
//    }
//
//    /**
//     * 生成退号凭证word
//     *
//     * @param caseId
//     * @param ssid
//     * @param printLoc
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printDelRegistered")
//    public BaseBean printDelRegistered(String caseId, String ssid, String printLoc) {
//
//        return null;
//
//    }
//
//    /**
//     * 生成退款单word
//     *
//     * @param caseId
//     * @param ssid
//     * @param printLoc
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printRefund")
//    public BaseBean printRefund(String caseId, String ssid, String printLoc) {
//
//        return null;
//
//    }
//
//    /**
//     * 生成缴费单word
//     *
//     * @param caseId
//     * @param ssid
//     * @param printLoc
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printPrice")
//    public BaseBean printPrice(String caseId, String ssid, String printLoc) {
//
//        return null;
//
//    }
//
//    /**
//     * 保存word文件路径和文件名
//     *
//     * @param wordName
//     * @param wordUri
//     * @param createUser
//     * @param printType
//     * @param printLoc
//     * @param sicmedPatient
//     */
//    public void saveWord(String wordName, String wordUri, SicmedUser createUser, String printType, String printLoc, SicmedPatient sicmedPatient) {
//        SicmedWord sicmedWord = new SicmedWord();
//        sicmedWord.setWordName(wordName);
//        sicmedWord.setWordUri(wordUri);
//        sicmedWord.setCreateUser(createUser);
//        sicmedWord.setPrintType(printType);
//        sicmedWord.setPrintLoc(printLoc);
//        sicmedWord.setSicmedPatient(sicmedPatient);
//        sicmedwordService.save(sicmedWord);
//
//    }
//
//}