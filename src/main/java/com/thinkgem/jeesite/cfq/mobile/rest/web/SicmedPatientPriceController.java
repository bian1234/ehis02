package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.Date;
import java.util.List;

import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.HistoryRecordBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.HistoryRecordBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCureCheckBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedInspectBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientTotalPriceBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientUnitPriceBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientUnitPriceBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedRegisteredBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedTwxrayCheckBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.RefundsPrintBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.RefundsPrintBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.TollPrintBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.print.TollPrintBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCheckPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCurePrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspectPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatient;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatientPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegistered;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedUser;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCheckPriceService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCurePriceService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedInspectPriceService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedMedicalPriceService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedPatientPriceService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedPatientService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedRegisteredService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedUserService;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.DateTimeUtils;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.SsidUtils;

/**
 * 患者价格明细表Controller
 *
 * @author Max
 * @version 2016-07-18
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedPatientPrice")
public class SicmedPatientPriceController extends BaseController {

    @Autowired
    private SicmedPatientPriceService sicmedPatientPriceService;

    @Autowired
    private SicmedPatientService sicmedPatientService;

    @Autowired
    private SicmedCheckPriceService sicmedCheckPriceService;

    @Autowired
    private SicmedInspectPriceService sicmedInspectPriceService;

    @Autowired
    private SicmedCurePriceService sicmedCurePriceService;

    @Autowired
    private SicmedMedicalPriceService sicmedMedicalPriceService;

    @Autowired
    private SicmedRegisteredService sicmedRegisteredService;

    @Autowired
    private SicmedUserService sicmedUserService;


    /**
     * 根据患者Id查询患者缴费信息
     *
     * @param isPay
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getYesByPatient")
    public BaseBean getYesByPatient(String patientId, String isPay) {
        // 创建返回实体
        SicmedPatientUnitPriceBeans sicmedPatientUnitPriceBeans = new SicmedPatientUnitPriceBeans();
        // 校验传入参数
        // 创建查询条件
        SicmedPatientPrice patientPrice = new SicmedPatientPrice();
        // 给查询条件赋值
        SicmedPatient sicmedPatient = sicmedPatientService.get(patientId);
        patientPrice.setSicmedPatient(sicmedPatient);
        //返回实体 中 添加患者信息
        SicmedPatientBean sicmedPatientBean = new SicmedPatientBean();
        sicmedPatientBean.setSP(sicmedPatient);
        sicmedPatientUnitPriceBeans.setSicmedPatientBean(sicmedPatientBean);
        //获取患者挂号信息
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        sicmedRegistered.setSicmedPatient(sicmedPatient);
        sicmedRegistered = sicmedRegisteredService.getByP(sicmedRegistered);
        SicmedRegisteredBean sicmedRegisteredBean = new SicmedRegisteredBean();
        sicmedRegisteredBean.setSR(sicmedRegistered);
        sicmedPatientUnitPriceBeans.setSicmedRegisteredBean(sicmedRegisteredBean);

        patientPrice.setIsPay(isPay);
        // 执行查询条件
        List<SicmedPatientPrice> tempList = sicmedPatientPriceService.findList(patientPrice);
        // 返回值校验
        if (tempList == null || tempList.size() == 0) {
            sicmedPatientUnitPriceBeans.setError("1");
            sicmedPatientUnitPriceBeans.setErrorMessage("所选患者无费用信息");
            return sicmedPatientUnitPriceBeans;
        }
        Integer checkNo = 0;
        Integer inspectNo = 0;
        Integer cureNo = 0;
        Integer medicalNo = 0;

        Double checkTotalPrice = 0.00;
        Double inspectTotalPrice = 0.00;
        Double cureTotalPrice = 0.00;
        Double medicalTotalPrice = 0.00;
        // 返回值处理
        for (SicmedPatientPrice sicmedPatientPrice : tempList) {
            int i = Integer.parseInt(sicmedPatientPrice.getPriceClassType());// 价格类别
            String priceId = sicmedPatientPrice.getPriceCode();// 价格Id
            SicmedPatientUnitPriceBean sicmedPatientUnitPriceBean = new SicmedPatientUnitPriceBean();
            sicmedPatientUnitPriceBean.setPriceId(sicmedPatientPrice.getId());
            switch (i) {
                case 0:
                    checkNo = checkNo + 1;
                    SicmedCheckPrice sicmedCheckPrice = sicmedCheckPriceService.get(priceId);
                    SicmedTwxrayCheckBean sicmedTwxrayCheckBean = new SicmedTwxrayCheckBean();
                    sicmedTwxrayCheckBean.setSTCB(sicmedCheckPrice.getSicmedTwxrayCheck());
                    sicmedPatientUnitPriceBean.setSicmedTwxrayCheckBean(sicmedTwxrayCheckBean);
                    sicmedPatientUnitPriceBean.setCheckPrice(sicmedCheckPrice.getCheckPrice());
                    checkTotalPrice += Double.parseDouble(sicmedCheckPriceService.get(priceId).getCheckPrice());

                    break;
                case 1:
                    inspectNo = inspectNo + 1;
                    SicmedInspectPrice sicmedInspectPrice = sicmedInspectPriceService.get(priceId);

                    SicmedInspectBean sicmedInspectBean = new SicmedInspectBean();
                    sicmedInspectBean.setSIB(sicmedInspectPrice.getSicmedInspect());
                    sicmedPatientUnitPriceBean.setSicmedInspectBean(sicmedInspectBean);
                    sicmedPatientUnitPriceBean.setInspectPrice(sicmedInspectPrice.getPrice());
                    inspectTotalPrice += Double.parseDouble(sicmedInspectPriceService.get(priceId).getPrice());
                    break;
                case 2:
                    cureNo = cureNo + 1;
                    SicmedCurePrice sicmedCurePrice = sicmedCurePriceService.get(priceId);

                    SicmedCureCheckBean sicmedCureCheckBean = new SicmedCureCheckBean();
                    sicmedCureCheckBean.setSCCB(sicmedCurePrice.getSicmedCureCheck());

                    sicmedPatientUnitPriceBean.setSicmedCureCheckBean(sicmedCureCheckBean);
                    sicmedPatientUnitPriceBean.setCurePrice(sicmedCurePrice.getPrice());
                    cureTotalPrice += Double.parseDouble(sicmedCurePriceService.get(priceId).getPrice());
                    break;
                case 3:
                    medicalNo = medicalNo + 1;
                    SicmedMedicalPrice sicmedMedicalPrice = sicmedMedicalPriceService.get(priceId);


                    SicmedMedicalBean sicmedMedicalBean = new SicmedMedicalBean();
                    sicmedMedicalBean.setSMB(sicmedMedicalPrice.getSicmedMedical());

                    sicmedPatientUnitPriceBean.setSicmedMedicalBean(sicmedMedicalBean);
                    sicmedPatientUnitPriceBean.setMedicalPrice(sicmedMedicalPrice.getPriceSale());
                    medicalTotalPrice += Double.parseDouble(sicmedMedicalPriceService.get(priceId).getPriceSale());

                    break;
                default:
                    break;
            }
            sicmedPatientUnitPriceBeans.getSicmedPatientUnitPriceBeans().add(sicmedPatientUnitPriceBean);
        }
        sicmedPatientUnitPriceBeans.setCheckNo(checkNo.toString());
        sicmedPatientUnitPriceBeans.setInspectNo(inspectNo.toString());
        sicmedPatientUnitPriceBeans.setCureNo(cureNo.toString());
        sicmedPatientUnitPriceBeans.setMedicalNo(medicalNo.toString());
        sicmedPatientUnitPriceBeans.setTotalCheckPrice(checkTotalPrice.toString());
        sicmedPatientUnitPriceBeans.setTotalInspectPrice(inspectTotalPrice.toString());
        sicmedPatientUnitPriceBeans.setTotalCurePrice(cureTotalPrice.toString());
        sicmedPatientUnitPriceBeans.setTotalMedicalPrice(medicalTotalPrice.toString());
        return sicmedPatientUnitPriceBeans;
    }


    /**
     * 根据患者Id查询患者缴费信息
     *
     * @param isPay
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getYesByPatientId")
    public BaseBean getYesByPatientId(String patientId, String isPay) {
        // 创建返回实体
        SicmedPatientTotalPriceBean sicmedPatientTotalPriceBean = new SicmedPatientTotalPriceBean();
        // 校验传入参数
        if (AppParameterSimulation.isEmpty(patientId)) {
            sicmedPatientTotalPriceBean.setError("1");
            sicmedPatientTotalPriceBean.setErrorMessage("参数为空");
            return sicmedPatientTotalPriceBean;
        } else if (!AppParameterSimulation.simulationId(patientId)) {
            sicmedPatientTotalPriceBean.setError("1");
            sicmedPatientTotalPriceBean.setErrorMessage("参数类型不正确");
            return sicmedPatientTotalPriceBean;
        }
        // 创建查询条件
        SicmedPatientPrice patientPrice = new SicmedPatientPrice();
        // 给查询条件赋值
        patientPrice.setSicmedPatient(sicmedPatientService.get(patientId));
        patientPrice.setIsPay(isPay);
        // 执行查询条件
        List<SicmedPatientPrice> tempList = sicmedPatientPriceService.findList(patientPrice);
        // 返回值校验
        if (tempList == null || tempList.size() == 0) {
            sicmedPatientTotalPriceBean.setError("1");
            sicmedPatientTotalPriceBean.setErrorMessage("所选患者无费用信息");
            return sicmedPatientTotalPriceBean;
        }
        // 返回值处理

        // 创建价格
        double checkTotalPrice = 0.00;
        double inspectTotalPrice = 0.00;
        double cureTotalPrice = 0.00;
        double medicalTotalPrice = 0.00;
        // double registerPrice = 0.00;
        // double totalPrice = 0.00;

        for (SicmedPatientPrice sicmedPatientPrice : tempList) {
            int i = Integer.parseInt(sicmedPatientPrice.getPriceClassType());// 价格类别
            String priceId = sicmedPatientPrice.getPriceCode();// 价格Id
            switch (i) {
                case 0:
                    checkTotalPrice += Double.parseDouble(sicmedCheckPriceService.get(priceId).getCheckPrice());
                    break;
                case 1:
                    sicmedInspectPriceService.get(priceId);
                    inspectTotalPrice += Double.parseDouble(sicmedInspectPriceService.get(priceId).getPrice());
                    break;
                case 2:
                    sicmedCurePriceService.get(priceId);
                    cureTotalPrice += Double.parseDouble(sicmedCurePriceService.get(priceId).getPrice());
                    break;
                case 3:
                    sicmedMedicalPriceService.get(priceId);
                    medicalTotalPrice += Double.parseDouble(sicmedMedicalPriceService.get(priceId).getPriceSale());
                    break;
                case 4:
                    break;
                // case 5:
                // SicmedCase sicmedCase = new SicmedCase();
                // sicmedCase.setSicmedPatient(sicmedPatientService.get(patientId));
                // sicmedCase = sicmedCaseService.getByEntity(sicmedCase);
                // if (sicmedCase != null) {
                // registerPrice = 0.00;
                // } else {
                // sicmedRegisteredService.get(priceId);
                // registerPrice +=
                // Double.parseDouble(sicmedRegisteredService.get(priceId).getRegisteredPric());
                // }
                // break;
                default:
                    break;
            }
            sicmedPatientTotalPriceBean.setCheckTotalPrice(Double.toString(checkTotalPrice));
            sicmedPatientTotalPriceBean.setInspectTotalPrice(Double.toString(inspectTotalPrice));
            sicmedPatientTotalPriceBean.setCureTotalPrice(Double.toString(cureTotalPrice));
            sicmedPatientTotalPriceBean.setMedicalTotalPrice(Double.toString(medicalTotalPrice));
            // sicmedPatientTotalPriceBean.setTotalPrice(Double.toString(totalPrice));
            // sicmedPatientTotalPriceBean.setRegisterPrice(Double.toString(registerPrice));
            if (checkTotalPrice == 0.00 && inspectTotalPrice == 0.00 && cureTotalPrice == 0.00
                    && medicalTotalPrice == 0.00) {
                sicmedPatientTotalPriceBean.setError("1");
                sicmedPatientTotalPriceBean.setErrorMessage("无可操作信息");
            } else {
                sicmedPatientTotalPriceBean.success();
            }
        }
        return sicmedPatientTotalPriceBean;
    }

    /**
     * 查询患者缴费明细
     *
     * @param isPay
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getByPatientId")
    public BaseBean getByPatientId(String patientId, String isPay, String classType) {
        // 创建返回实体
        SicmedPatientUnitPriceBeans sicmedPatientUnitPriceBeans = new SicmedPatientUnitPriceBeans();
        // 校验传入参数
        if (AppParameterSimulation.isEmpty(patientId)) {
            sicmedPatientUnitPriceBeans.setError("1");
            sicmedPatientUnitPriceBeans.setErrorMessage("参数为空");
            return sicmedPatientUnitPriceBeans;
        } else if (!AppParameterSimulation.simulationId(patientId)) {
            sicmedPatientUnitPriceBeans.setError("1");
            sicmedPatientUnitPriceBeans.setErrorMessage("参数类型不正确");
            return sicmedPatientUnitPriceBeans;
        }
        // 创建查询条件
        SicmedPatientPrice patientPrice = new SicmedPatientPrice();
        // 给查询条件赋值
        patientPrice.setSicmedPatient(sicmedPatientService.get(patientId));
        patientPrice.setIsPay(isPay);
        patientPrice.setPriceClassType(classType);
        // 执行查询条件
        List<SicmedPatientPrice> tempList = sicmedPatientPriceService.findList(patientPrice);
        // 返回值校验
        if (tempList == null || tempList.size() == 0) {
            sicmedPatientUnitPriceBeans.successNotFoundData();
            return sicmedPatientUnitPriceBeans;
        }
        // 返回值处理
        for (SicmedPatientPrice sicmedPatientPrice : tempList) {
            SicmedPatientUnitPriceBean sicmedPatientUnitPriceBean = new SicmedPatientUnitPriceBean();
            int i = Integer.parseInt(sicmedPatientPrice.getPriceClassType());// 价格类别
            String priceId = sicmedPatientPrice.getPriceCode();// 价格Id
            switch (i) {
                case 0:
                    SicmedTwxrayCheckBean sicmedTwxrayCheckBean = new SicmedTwxrayCheckBean();
                    SicmedCheckPrice sicmedCheckPrice = sicmedCheckPriceService.get(priceId);
                    sicmedTwxrayCheckBean.setSTCB(sicmedCheckPrice.getSicmedTwxrayCheck());
                    sicmedPatientUnitPriceBean.setSicmedTwxrayCheckBean(sicmedTwxrayCheckBean);
                    sicmedPatientUnitPriceBean.setCheckPrice(sicmedCheckPrice.getCheckPrice());
                    break;
                case 1:
                    SicmedInspectBean sicmedInspectBean = new SicmedInspectBean();
                    SicmedInspectPrice sicmedInspectPrice = sicmedInspectPriceService.get(priceId);
                    sicmedInspectBean.setSIB(sicmedInspectPrice.getSicmedInspect());
                    sicmedPatientUnitPriceBean.setSicmedInspectBean(sicmedInspectBean);
                    sicmedPatientUnitPriceBean.setInspectPrice(sicmedInspectPrice.getPrice());
                    break;
                case 2:
                    SicmedCureCheckBean sicmedCureCheckBean = new SicmedCureCheckBean();
                    SicmedCurePrice sicmedCurePrice = sicmedCurePriceService.get(priceId);
                    sicmedCureCheckBean.setSCCB(sicmedCurePrice.getSicmedCureCheck());
                    sicmedPatientUnitPriceBean.setSicmedCureCheckBean(sicmedCureCheckBean);
                    sicmedPatientUnitPriceBean.setCurePrice(sicmedCurePrice.getPrice());
                    break;
                case 3:
                    SicmedMedicalBean sicmedMedicalBean = new SicmedMedicalBean();
                    SicmedMedicalPrice sicmedMedicalPrice = sicmedMedicalPriceService.get(priceId);
                    sicmedMedicalBean.setSMB(sicmedMedicalPrice.getSicmedMedical());
                    sicmedPatientUnitPriceBean.setSicmedMedicalBean(sicmedMedicalBean);
                    sicmedPatientUnitPriceBean.setMedicalPrice(sicmedMedicalPrice.getPriceSale());
                    break;
                case 4:
                    break;
                // case 5:
                // SicmedRegisteredBean sicmedRegisteredBean = new
                // SicmedRegisteredBean();
                // SicmedRegistered sicmedRegistered =
                // sicmedRegisteredService.get(priceId);
                // sicmedRegisteredBean.setSR(sicmedRegistered);
                // sicmedPatientUnitPriceBean.setSicmedRegisteredBean(sicmedRegisteredBean);
                // sicmedPatientUnitPriceBean.setRegisterPrice(sicmedRegistered.getRegisteredPric());
                // break;
                default:
                    break;
            }
            sicmedPatientUnitPriceBeans.getSicmedPatientUnitPriceBeans().add(sicmedPatientUnitPriceBean);
        }
        sicmedPatientUnitPriceBeans.setError("0");
        return sicmedPatientUnitPriceBeans;
    }

    /**
     * 退费/收费
     *
     * @param isPay
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "update")
    public BaseBean update(String patientId, String isPay, String checkType, String inspectType, String cureType,
                           String medicalType, String ssid) {
        // 创建返回对象
        SicmedPatientUnitPriceBeans sicmedPatientUnitPriceBeans = new SicmedPatientUnitPriceBeans();

        List<SicmedCheckPrice> sicmedCheckPrices = Lists.newArrayList();
        List<SicmedInspectPrice> sicmedInspectPrices = Lists.newArrayList();
        List<SicmedCurePrice> sicmedCurePrices = Lists.newArrayList();
        List<SicmedMedicalPrice> sicmedMedicalPrices = Lists.newArrayList();

        List<SicmedPatientPrice> sicmedPatientPriceCheck = Lists.newArrayList();
        List<SicmedPatientPrice> sicmedPatientPriceInspect = Lists.newArrayList();
        List<SicmedPatientPrice> sicmedPatientPriceCure = Lists.newArrayList();
        List<SicmedPatientPrice> sicmedPatientPriceMedical = Lists.newArrayList();

        // 校验传入参数
        if (AppParameterSimulation.isEmpty(patientId) && AppParameterSimulation.isEmpty(isPay)) {
            sicmedPatientUnitPriceBeans.setError("1");
            sicmedPatientUnitPriceBeans.setErrorMessage("参数为空");
            return sicmedPatientUnitPriceBeans;
        } else if (!AppParameterSimulation.simulationId(patientId)) {
            sicmedPatientUnitPriceBeans.setError("1");
            sicmedPatientUnitPriceBeans.setErrorMessage("参数类型不正确");
            return sicmedPatientUnitPriceBeans;
        }

        // 参数校验成功 获取患者信息
        SicmedPatient sicmedPatient = sicmedPatientService.get(patientId);
        // 获取操作人员
        SicmedUser sicmedUser = sicmedUserService.get(SsidUtils.getSicmedUserId(ssid));
        // 获取 患者 挂号 信息
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        sicmedRegistered.setSicmedPatient(sicmedPatient);
        sicmedRegistered = sicmedRegisteredService.getByP(sicmedRegistered);
        // 获取患者收费信息
        if (checkType != null) {
            // 获取检查收费信息
            SicmedPatientPrice sicmedPatientPrice = new SicmedPatientPrice();
            sicmedPatientPrice.setSicmedPatient(sicmedPatient);
            sicmedPatientPrice.setPriceClassType(checkType);
            sicmedPatientPriceCheck = sicmedPatientPriceService.findList(sicmedPatientPrice);
            // 获取检查价格
            for (SicmedPatientPrice sicmedPatientPrice2 : sicmedPatientPriceCheck) {
                sicmedCheckPrices.add(sicmedCheckPriceService.get(sicmedPatientPrice2.getPriceCode()));
            }
        }
        if (inspectType != null) {
            // 获取检验收费信息
            SicmedPatientPrice sicmedPatientPrice = new SicmedPatientPrice();
            sicmedPatientPrice.setSicmedPatient(sicmedPatient);
            sicmedPatientPrice.setPriceClassType(inspectType);
            sicmedPatientPriceInspect = sicmedPatientPriceService.findList(sicmedPatientPrice);
            // 获取检验价格
            for (SicmedPatientPrice sicmedPatientPrice2 : sicmedPatientPriceInspect) {
                sicmedInspectPrices.add(sicmedInspectPriceService.get(sicmedPatientPrice2.getPriceCode()));
            }
        }
        if (cureType != null) {
            // 获取治疗收费信息
            SicmedPatientPrice sicmedPatientPrice = new SicmedPatientPrice();
            sicmedPatientPrice.setSicmedPatient(sicmedPatient);
            sicmedPatientPrice.setPriceClassType(cureType);
            sicmedPatientPriceCure = sicmedPatientPriceService.findList(sicmedPatientPrice);
            // 获取 治疗价格
            for (SicmedPatientPrice sicmedPatientPrice2 : sicmedPatientPriceCure) {
                sicmedCurePrices.add(sicmedCurePriceService.get(sicmedPatientPrice2.getPriceCode()));
            }
        }
        if (medicalType != null) {
            // 获取药品收费信息
            SicmedPatientPrice sicmedPatientPrice = new SicmedPatientPrice();
            sicmedPatientPrice.setSicmedPatient(sicmedPatient);
            sicmedPatientPrice.setPriceClassType(medicalType);
            sicmedPatientPriceMedical = sicmedPatientPriceService.findList(sicmedPatientPrice);
            // 获取药品价格
            for (SicmedPatientPrice sicmedPatientPrice2 : sicmedPatientPriceMedical) {
                sicmedMedicalPrices.add(sicmedMedicalPriceService.get(sicmedPatientPrice2.getPriceCode()));
            }
        }
        // 判断 操作类型 (收费 /退费)
        if (isPay.equals("0")) {
            // 收费
            // 创建收费凭证
            TollPrintBeans tollPrintBeans = new TollPrintBeans();
            // 创建收费总价
            Double price = 0.00d;
            if (checkType != null) {
                // 检查收费
                for (SicmedPatientPrice sicmedPatientPrice : sicmedPatientPriceCheck) {
                    sicmedPatientPrice.setIsPay("1");
                    sicmedPatientPrice.setCreateUser(sicmedUser);
                    sicmedPatientPrice.setUpdateDate(DateTimeUtils.getTime());
                    sicmedPatientPriceService.update(sicmedPatientPrice);
                }
                for (SicmedCheckPrice sicmedCheckPrice : sicmedCheckPrices) {
                    TollPrintBean tollPrintBean = new TollPrintBean();
                    tollPrintBean.setTPB(sicmedCheckPrice);
                    tollPrintBeans.getTollPrintBeans().add(tollPrintBean);
                    price = price + Double.parseDouble(sicmedCheckPrice.getCheckPrice());
                }
            }
            if (inspectType != null) {
                // 检验收费
                for (SicmedPatientPrice sicmedPatientPrice : sicmedPatientPriceInspect) {
                    sicmedPatientPrice.setIsPay("1");
                    sicmedPatientPrice.setCreateUser(sicmedUser);
                    sicmedPatientPrice.setUpdateDate(DateTimeUtils.getTime());
                    sicmedPatientPriceService.update(sicmedPatientPrice);
                }
                for (SicmedInspectPrice sicmedInspectPrice : sicmedInspectPrices) {
                    TollPrintBean tollPrintBean = new TollPrintBean();
                    tollPrintBean.setTPB(sicmedInspectPrice);
                    tollPrintBeans.getTollPrintBeans().add(tollPrintBean);
                    price = price + Double.parseDouble(sicmedInspectPrice.getPrice());
                }
            }
            if (cureType != null) {
                // 治疗收费
                for (SicmedPatientPrice sicmedPatientPrice : sicmedPatientPriceCure) {
                    sicmedPatientPrice.setIsPay("1");
                    sicmedPatientPrice.setCreateUser(sicmedUser);
                    sicmedPatientPrice.setUpdateDate(DateTimeUtils.getTime());
                    sicmedPatientPriceService.update(sicmedPatientPrice);
                }
                for (SicmedCurePrice sicmedCurePrice : sicmedCurePrices) {
                    TollPrintBean tollPrintBean = new TollPrintBean();
                    tollPrintBean.setTPB(sicmedCurePrice);
                    tollPrintBeans.getTollPrintBeans().add(tollPrintBean);
                    price = price + Double.parseDouble(sicmedCurePrice.getPrice());
                }
            }
            if (medicalType != null) {
                // 药品收费
                for (SicmedPatientPrice sicmedPatientPrice : sicmedPatientPriceMedical) {
                    sicmedPatientPrice.setIsPay("1");
                    sicmedPatientPrice.setCreateUser(sicmedUser);
                    sicmedPatientPrice.setUpdateDate(DateTimeUtils.getTime());
                    sicmedPatientPriceService.update(sicmedPatientPrice);
                }
                for (SicmedMedicalPrice sicmedMedicalPrice : sicmedMedicalPrices) {
                    TollPrintBean tollPrintBean = new TollPrintBean();
                    tollPrintBean.setTPB(sicmedMedicalPrice);
                    tollPrintBeans.getTollPrintBeans().add(tollPrintBean);
                    price = price + Double.parseDouble(sicmedMedicalPrice.getPriceSale());
                }
            }
            tollPrintBeans.setTPB(sicmedPatient);
            tollPrintBeans.setPriceUserName(sicmedUser.getUserName());
            tollPrintBeans.setPricUper(price);
            tollPrintBeans.setPriceLower(price);
            tollPrintBeans.setError("0");
            tollPrintBeans.setSuccessMessage("收费成功");
            return tollPrintBeans;
        } else if (isPay.equals("1")) {
            // 退费
            // 创建退费凭证
            RefundsPrintBeans refundsPrintBeans = new RefundsPrintBeans();

            Double price = 0.00d;
            if (checkType != null) {
                for (SicmedPatientPrice sicmedPatientPrice : sicmedPatientPriceCheck) {
                    sicmedPatientPrice.setUpdateUser(sicmedUser);
                    sicmedPatientPrice.setUpdateDate(DateTimeUtils.getTime());
                    sicmedPatientPriceService.update(sicmedPatientPrice);
                    sicmedPatientPriceService.delete(sicmedPatientPrice);
                }
                for (SicmedCheckPrice sicmedCheckPrice : sicmedCheckPrices) {
                    RefundsPrintBean refundsPrintBean = new RefundsPrintBean();
                    refundsPrintBean.setTPB(sicmedCheckPrice);
                    refundsPrintBeans.getRefundsPrintBeans().add(refundsPrintBean);
                    price = price + Double.parseDouble(sicmedCheckPrice.getCheckPrice());
                }
            }
            if (inspectType != null) {
                for (SicmedPatientPrice sicmedPatientPrice : sicmedPatientPriceInspect) {
                    sicmedPatientPrice.setUpdateUser(sicmedUser);
                    sicmedPatientPrice.setUpdateDate(DateTimeUtils.getTime());
                    sicmedPatientPriceService.update(sicmedPatientPrice);
                    sicmedPatientPriceService.delete(sicmedPatientPrice);
                }
                for (SicmedInspectPrice sicmedInspectPrice : sicmedInspectPrices) {
                    RefundsPrintBean refundsPrintBean = new RefundsPrintBean();
                    refundsPrintBean.setTPB(sicmedInspectPrice);
                    refundsPrintBeans.getRefundsPrintBeans().add(refundsPrintBean);
                    price = price + Double.parseDouble(sicmedInspectPrice.getPrice());
                }
            }
            if (cureType != null) {
                for (SicmedPatientPrice sicmedPatientPrice : sicmedPatientPriceCure) {
                    sicmedPatientPrice.setUpdateUser(sicmedUser);
                    sicmedPatientPrice.setUpdateDate(DateTimeUtils.getTime());
                    sicmedPatientPriceService.update(sicmedPatientPrice);
                    sicmedPatientPriceService.delete(sicmedPatientPrice);
                }
                for (SicmedCurePrice sicmedCurePrice : sicmedCurePrices) {
                    RefundsPrintBean refundsPrintBean = new RefundsPrintBean();
                    refundsPrintBean.setTPB(sicmedCurePrice);
                    refundsPrintBeans.getRefundsPrintBeans().add(refundsPrintBean);
                    price = price + Double.parseDouble(sicmedCurePrice.getPrice());
                }
            }
            if (medicalType != null) {
                for (SicmedPatientPrice sicmedPatientPrice : sicmedPatientPriceMedical) {
                    sicmedPatientPrice.setUpdateUser(sicmedUser);
                    sicmedPatientPrice.setUpdateDate(DateTimeUtils.getTime());
                    sicmedPatientPriceService.update(sicmedPatientPrice);
                    sicmedPatientPriceService.delete(sicmedPatientPrice);
                }
                for (SicmedMedicalPrice sicmedMedicalPrice : sicmedMedicalPrices) {
                    RefundsPrintBean refundsPrintBean = new RefundsPrintBean();
                    refundsPrintBean.setTPB(sicmedMedicalPrice);
                    refundsPrintBeans.getRefundsPrintBeans().add(refundsPrintBean);
                    price = price + Double.parseDouble(sicmedMedicalPrice.getPriceSale());
                }
            }
            refundsPrintBeans.setTPB(sicmedPatient);
            refundsPrintBeans.setPriceUserName(sicmedUser.getUserName());
            refundsPrintBeans.setPricUper(price);
            refundsPrintBeans.setPriceLower(price);
            refundsPrintBeans.setError("0");
            refundsPrintBeans.setSuccessMessage("退费成功");
            return refundsPrintBeans;
        } else {
            sicmedPatientUnitPriceBeans.setError("1");
            sicmedPatientUnitPriceBeans.setErrorMessage("错误操作");
            return sicmedPatientUnitPriceBeans;
        }

    }

    /**
     * 查询收费/退费记录
     *
     * @param isPay
     * @param ssid
     * @return
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "getHistory")
    public BaseBean getHistory(String isPay, String ssid) {
        HistoryRecordBeans historyRecordBeans = new HistoryRecordBeans();
        // 创建查询条件
        SicmedPatientPrice sicmedPatientPrice = new SicmedPatientPrice();
        // 获取查询条件的属性
        Date startDate = DateTimeUtils.getDayBeginDate();
        Date endDate = DateTimeUtils.getTime();
        // 给查询条件赋值
        sicmedPatientPrice.setIsPay(isPay);
        sicmedPatientPrice.setStartDate(startDate);
        sicmedPatientPrice.setEndDate(endDate);
        // 判断要查询的数据类型
        if (isPay.equals("0")) {
            // 查询收费记录
            sicmedPatientPrice.setIsPay("1");
            sicmedPatientPrice.setDelFlag(null);
            sicmedPatientPrice.setCreateUser(sicmedUserService.get(SsidUtils.getSicmedUserId(ssid)));
        } else if (isPay.equals("1")) {
            // 查询退费记录
            sicmedPatientPrice.setIsPay("1");
            sicmedPatientPrice.setDelFlag("1");
            sicmedPatientPrice.setUpdateUser(sicmedUserService.get(SsidUtils.getSicmedUserId(ssid)));
        }
        // 执行查询条件
        List<SicmedPatientPrice> tempList = sicmedPatientPriceService.findHistoryList(sicmedPatientPrice);
        // 判断查询结果
        if (tempList.size() > 0) {
            // 处理返回结果
            Double totalPrice = 0.00;
            String priceStr = "";
            for (SicmedPatientPrice sicmedPatientPrice2 : tempList) {
                Double unitPrice = 0.00;
                int a = Integer.parseInt(sicmedPatientPrice2.getPriceClassType());
                String priceId = sicmedPatientPrice2.getPriceCode();

                switch (a) {
                    case 0:
                        SicmedCheckPrice sicmedCheckPrice = sicmedCheckPriceService.get(priceId);
                        priceStr = sicmedCheckPrice.getCheckPrice();
                        break;
                    case 1:
                        SicmedInspectPrice sicmedInspectPrice = sicmedInspectPriceService.get(priceId);
                        priceStr = sicmedInspectPrice.getPrice();
                        break;
                    case 2:
                        SicmedCurePrice sicmedCurePrice = sicmedCurePriceService.get(priceId);
                        priceStr = sicmedCurePrice.getPrice();
                        break;
                    case 3:
                        SicmedMedicalPrice sicmedMedicalPrice = sicmedMedicalPriceService.get(priceId);
                        priceStr = sicmedMedicalPrice.getPriceSale();
                        break;
                    case 5:
                        SicmedRegistered sicmedRegistered = sicmedRegisteredService.get(priceId);
                        priceStr = sicmedRegistered.getRegisteredPric();
                        break;
                    default:
                        break;
                }
                totalPrice = totalPrice + Double.parseDouble(priceStr);
                unitPrice = Double.parseDouble(priceStr);
                HistoryRecordBean historyRecordBean = new HistoryRecordBean();
                historyRecordBean.setUnitPrice(unitPrice.toString());
                SicmedPatient sicmedPatient = sicmedPatientPrice2.getSicmedPatient();
                sicmedPatient.setDelFlag("1");
                historyRecordBean.setHRB(sicmedPatientService.get(sicmedPatientPrice2.getSicmedPatient()));
                historyRecordBeans.addHis(historyRecordBean);
            }
            historyRecordBeans.success();
            historyRecordBeans.setTotalPrice(totalPrice.toString());
        } else {
            historyRecordBeans.setError("1");
            historyRecordBeans.setErrorMessage("结果为空");
        }
        historyRecordBeans.setBenginDate(DateTimeUtils.getDateStr(startDate));
        historyRecordBeans.setEndDate(DateTimeUtils.getDateStr(endDate));
        return historyRecordBeans;
    }

    /**
     * PC查询收费/退费记录
     *
     * @param isPay
     * @param ssid
     * @return
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "pc/getHistory")
    public BaseBean getHistory2(String isPay, String ssid, String beginDate, String endDate) {
        HistoryRecordBeans historyRecordBeans = new HistoryRecordBeans();
        // 创建查询条件
        SicmedPatientPrice sicmedPatientPrice = new SicmedPatientPrice();
        // 获取查询条件的属性
        // 获取查询条件的属性
        Date beginDate1 = DateTimeUtils.getDayBeginDate();
        Date endDate1 = DateTimeUtils.getTime();
        if (AppParameterSimulation.isNotEmpty(beginDate)) {
            beginDate1 = DateTimeUtils.getDate(beginDate);
        }
        if (AppParameterSimulation.isNotEmpty(endDate)) {
            endDate1 = DateTimeUtils.getDate(endDate);
        }
        // 给查询条件赋值
        sicmedPatientPrice.setIsPay(isPay);
        sicmedPatientPrice.setStartDate(beginDate1);
        sicmedPatientPrice.setEndDate(endDate1);
        // 判断要查询的数据类型
        if (isPay.equals("0")) {
            // 查询收费记录
            sicmedPatientPrice.setIsPay("1");
            sicmedPatientPrice.setDelFlag(null);
            sicmedPatientPrice.setCreateUser(sicmedUserService.get(SsidUtils.getSicmedUserId(ssid)));
        } else if (isPay.equals("1")) {
            // 查询退费记录
            sicmedPatientPrice.setIsPay("1");
            sicmedPatientPrice.setDelFlag("1");
            sicmedPatientPrice.setUpdateUser(sicmedUserService.get(SsidUtils.getSicmedUserId(ssid)));
        }
        // 执行查询条件
        List<SicmedPatientPrice> tempList = sicmedPatientPriceService.findHistoryList(sicmedPatientPrice);
        // 判断查询结果
        if (tempList.size() > 0) {
            // 处理返回结果
            Double totalPrice = 0.00;
            String priceStr = "";
            for (SicmedPatientPrice sicmedPatientPrice2 : tempList) {
                Double unitPrice = 0.00;
                int a = Integer.parseInt(sicmedPatientPrice2.getPriceClassType());
                String priceId = sicmedPatientPrice2.getPriceCode();

                switch (a) {
                    case 0:
                        SicmedCheckPrice sicmedCheckPrice = sicmedCheckPriceService.get(priceId);
                        priceStr = sicmedCheckPrice.getCheckPrice();
                        break;
                    case 1:
                        SicmedInspectPrice sicmedInspectPrice = sicmedInspectPriceService.get(priceId);
                        priceStr = sicmedInspectPrice.getPrice();
                        break;
                    case 2:
                        SicmedCurePrice sicmedCurePrice = sicmedCurePriceService.get(priceId);
                        priceStr = sicmedCurePrice.getPrice();
                        break;
                    case 3:
                        SicmedMedicalPrice sicmedMedicalPrice = sicmedMedicalPriceService.get(priceId);
                        priceStr = sicmedMedicalPrice.getPriceSale();
                        break;
                    case 5:
                        SicmedRegistered sicmedRegistered = sicmedRegisteredService.get(priceId);
                        priceStr = sicmedRegistered.getRegisteredPric();
                        break;
                    default:
                        break;
                }
                totalPrice = totalPrice + Double.parseDouble(priceStr);
                unitPrice = Double.parseDouble(priceStr);
                HistoryRecordBean historyRecordBean = new HistoryRecordBean();
                historyRecordBean.setUnitPrice(unitPrice.toString());
                SicmedPatient sicmedPatient = sicmedPatientPrice2.getSicmedPatient();
                sicmedPatient.setDelFlag("1");
                historyRecordBean.setHRB(sicmedPatientService.get(sicmedPatientPrice2.getSicmedPatient()));
                historyRecordBeans.addHis(historyRecordBean);
            }
            historyRecordBeans.success();
            historyRecordBeans.setTotalPrice(totalPrice.toString());
        } else {
            historyRecordBeans.setError("1");
            historyRecordBeans.setErrorMessage("结果为空");
        }
        historyRecordBeans.setBenginDate(DateTimeUtils.getDateStr(beginDate1));
        historyRecordBeans.setEndDate(DateTimeUtils.getDateStr(endDate1));
        return historyRecordBeans;
    }

    /*
     * Pc收费
     */
    @ResponseBody
    @RequestMapping(value = "toll")
    public BaseBean toll(String ids, String ssid) {
        SicmedPatientUnitPriceBeans sicmedPatientUnitPriceBeans = new SicmedPatientUnitPriceBeans();
        ids = ids.substring(0, ids.length() - 1);
        String[] strs = ids.split("\\$");
        SicmedUser sicmedUser = sicmedUserService.get(SsidUtils.getSicmedUserId(ssid));
        for (String id : strs) {
            SicmedPatientPrice sicmedPatientPrice = sicmedPatientPriceService.get(id);
            sicmedPatientPrice.setIsPay("1");
            sicmedPatientPrice.setCreateUser(sicmedUser);
            sicmedPatientPrice.preUpdate();
            sicmedPatientPriceService.update(sicmedPatientPrice);
        }
        sicmedPatientUnitPriceBeans.setError("0");
        sicmedPatientUnitPriceBeans.setSuccessMessage("保存成功");
        return sicmedPatientUnitPriceBeans;

    }

    /**
     * @param ids
     * @return
     * @Pc退费
     */

    @ResponseBody
    @RequestMapping(value = "refund")
    public BaseBean refund(String ids, String ssid) {
        SicmedPatientUnitPriceBeans sicmedPatientUnitPriceBeans = new SicmedPatientUnitPriceBeans();
        ids = ids.substring(0, ids.length() - 1);
        SicmedUser sicmedUser = sicmedUserService.get(SsidUtils.getSicmedUserId(ssid));
        String[] strs = ids.split("\\$");
        for (String id : strs) {
            SicmedPatientPrice sicmedPatientPrice = sicmedPatientPriceService.get(id);
            sicmedPatientPrice.setUpdateUser(sicmedUser);
            sicmedPatientPrice.preUpdate();
            sicmedPatientPriceService.update(sicmedPatientPrice);
            sicmedPatientPriceService.delete(sicmedPatientPrice);
        }
        sicmedPatientUnitPriceBeans.setError("0");
        sicmedPatientUnitPriceBeans.setSuccessMessage("退费成功");
        return sicmedPatientUnitPriceBeans;

    }
    /*
	 * @ModelAttribute public SicmedPatientPrice
	 * get(@RequestParam(required=false) String id) { SicmedPatientPrice entity
	 * = null; if (StringUtils.isNotBlank(id)){ entity =
	 * sicmedPatientPriceService.get(id); } if (entity == null){ entity = new
	 * SicmedPatientPrice(); } return entity; }
	 * 
	 * @RequiresPermissions("rest:sicmedPatientPrice:view")
	 * 
	 * @RequestMapping(value = {"list", ""}) public String
	 * list(SicmedPatientPrice sicmedPatientPrice, HttpServletRequest request,
	 * HttpServletResponse response, Model model) { Page<SicmedPatientPrice>
	 * page = sicmedPatientPriceService.findPage(new
	 * Page<SicmedPatientPrice>(request, response), sicmedPatientPrice);
	 * model.addAttribute("page", page); return
	 * "mobile/rest/sicmedPatientPriceList"; }
	 * 
	 * @RequiresPermissions("rest:sicmedPatientPrice:view")
	 * 
	 * @RequestMapping(value = "form") public String form(SicmedPatientPrice
	 * sicmedPatientPrice, Model model) {
	 * model.addAttribute("sicmedPatientPrice", sicmedPatientPrice); return
	 * "mobile/rest/sicmedPatientPriceForm"; }
	 * 
	 * @RequiresPermissions("rest:sicmedPatientPrice:edit")
	 * 
	 * @RequestMapping(value = "save") public String save(SicmedPatientPrice
	 * sicmedPatientPrice, Model model, RedirectAttributes redirectAttributes) {
	 * if (!beanValidator(model, sicmedPatientPrice)){ return
	 * form(sicmedPatientPrice, model); }
	 * sicmedPatientPriceService.save(sicmedPatientPrice);
	 * addMessage(redirectAttributes, "保存患者价格明细表保存成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedPatientPrice/?repage"; }
	 * 
	 * @RequiresPermissions("rest:sicmedPatientPrice:edit")
	 * 
	 * @RequestMapping(value = "delete") public String delete(SicmedPatientPrice
	 * sicmedPatientPrice, RedirectAttributes redirectAttributes) {
	 * sicmedPatientPriceService.delete(sicmedPatientPrice);
	 * addMessage(redirectAttributes, "删除患者价格明细表保存成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedPatientPrice/?repage"; }
	 */

}