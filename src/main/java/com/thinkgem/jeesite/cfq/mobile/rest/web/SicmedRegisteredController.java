package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.Date;
import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.HistoryRecordBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.HistoryRecordBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedRegisteredBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedBranch;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatient;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegistered;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegisteredPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegisteredType;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedUser;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.Sno;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedBranchService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedPatientService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedRegisteredPriceService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedRegisteredService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedRegisteredTypeService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedUserService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SnoService;
import com.thinkgem.jeesite.cfq.mobile.rest.setBean.SicmedPatientSetBean;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.DateTimeUtils;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.PageUtils;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.SsidUtils;

/**
 * 挂号信息表Controller
 *
 * @author Max
 * @version 2016-07-12
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedRegistered")
public class SicmedRegisteredController extends BaseController {

    @Autowired
    private SicmedRegisteredService sicmedRegisteredService;

    @Autowired
    private SicmedUserService sicmedUserService;

    @Autowired
    private SicmedBranchService sicmedBranchService;

    @Autowired
    private SicmedPatientService sicmedPatientService;

    @Autowired
    private SicmedRegisteredTypeService sicmedRegisteredTypeService;

    @Autowired
    private SicmedRegisteredPriceService sicmedRegisteredPriceService;
    @Autowired
    private SnoService snoService;

    /**
     * 挂号
     *
     * @param sicmedRegisteredBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add")
    public BaseBean add(SicmedPatientBean sicmedPatientBean, String branchId, String doctorId, String registeredTypeId,
                        String ssid) {
        // 创建返回对象
        SicmedRegisteredBean sicmedRegisteredBean = new SicmedRegisteredBean();
        // 传入参数校验
        if (AppParameterSimulation.isEmpty(branchId)
                || AppParameterSimulation.isEmpty(sicmedPatientBean.getPatientName())
                || AppParameterSimulation.isEmpty(registeredTypeId)) {
            sicmedPatientBean.setError("1");
            sicmedPatientBean.setErrorMessage("参数不能为空");
            return sicmedPatientBean;
        } else if (sicmedPatientBean.getPatientAge() <= 0 || sicmedPatientBean.getPatientAge() > 121) {
            sicmedPatientBean.setError("1");
            sicmedPatientBean.setErrorMessage("患者年龄不符合规则");
            return sicmedPatientBean;
        }
        // 创建 挂号患者 对象
        SicmedPatient sicmedPatient = SicmedPatientSetBean.setSPB(sicmedPatientBean, null);
        // 获取挂号患者的 属性
        SicmedUser createUser = sicmedUserService.get(SsidUtils.getSicmedUserId(ssid));

        //患者编号 getDateStr
        StringBuffer patientNumber = new StringBuffer();
        String str = DateTimeUtils.getDateStr();
        patientNumber.append(str);
        Sno sno = snoService.get("1");
        Date date = sno.getUpdateDate();
        if (DateTimeUtils.getDayBeginDate(date)) {
            sno.setNumber("1");
        }
        String s = sno.getNumber();
        int i = 4 - s.length();
        for (int j = 0; j < i; j++) {
            patientNumber.append(0);
        }
        patientNumber.append(s);
        Integer integer = Integer.parseInt(s);
        integer = integer + 1;
        sno.setNumber(integer.toString());
        sno.setUpdateDate(new Date());
        snoService.update(sno);
        sicmedPatient.setPatientNumber(patientNumber.toString());
        sicmedPatient.setCreateUser(createUser);
        // 调用service方法 保存患者信息
        sicmedPatientService.save(sicmedPatient);
        sicmedPatient = sicmedPatientService.get(sicmedPatient);
        // 创建 挂号信息 对象
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        // 获取 挂号对象的 属性
        SicmedBranch sicmedBranch = sicmedBranchService.get(branchId);
        SicmedRegisteredType sicmedRegisteredType = sicmedRegisteredTypeService.get(registeredTypeId);
        SicmedUser sicmedDoctor = sicmedUserService.get(doctorId);
        SicmedRegisteredPrice sicmedRegisteredPrice = sicmedRegisteredPriceService
                .get(sicmedRegisteredType.getSicmedRegisteredPrice());
        sicmedRegisteredType.setSicmedRegisteredPrice(sicmedRegisteredPrice);
        double a = Double.parseDouble(sicmedRegisteredPrice.getRegisteredFee());
        double b = Double.parseDouble(sicmedRegisteredPrice.getClinicsFee());
        double c = Double.parseDouble(sicmedRegisteredPrice.getMaterialFee());
        Double price = a + b + c;

        // 为挂号对象赋值
        sicmedRegistered.setSicmedPatient(sicmedPatient);
        sicmedRegistered.setSicmedBranch(sicmedBranch);
        sicmedRegistered.setSicmedRegistrationType(sicmedRegisteredType);
        sicmedRegistered.setSicmedDoctor(sicmedDoctor);
        sicmedRegistered.setCreateUser(createUser);
        sicmedRegistered.setRegisteredStatus("0");
        sicmedRegistered.setRegisteredPric(price.toString());
        // 调用service方法保存患者挂号信息
        sicmedRegisteredService.save(sicmedRegistered);
        // 获取保存好的 挂号信息
        sicmedRegistered = sicmedRegisteredService.getByEntity(sicmedRegistered);
        if (sicmedRegistered != null) {
            sicmedRegistered.setSicmedRegistrationType(sicmedRegisteredType);
            sicmedRegisteredBean.setSR(sicmedRegistered);
            sicmedRegisteredBean.setError("0");
            sicmedRegisteredBean.setErrorMessage("挂号成功返回打印信息");
        } else {
            sicmedRegisteredBean.setError("1");
            sicmedRegisteredBean.setErrorMessage("挂号成功返回打印信息失败");
        }

        return sicmedRegisteredBean;

    }

    /**
     * 退号
     *
     * @param registeredId
     * @return sicmedRegisteredBean
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "delete")
    public BaseBean delete(@RequestParam(required = false) String registeredId, String ssid) {
        // 创建返回对象
        SicmedRegisteredBean sicmedRegisteredBean = new SicmedRegisteredBean();
        // 参数校验
        if (AppParameterSimulation.isEmpty(registeredId)) {
            sicmedRegisteredBean.setError("1");
            sicmedRegisteredBean.setErrorMessage("参数为空");
            return sicmedRegisteredBean;
        } else if (!AppParameterSimulation.simulationId(registeredId)) {
            sicmedRegisteredBean.setError("1");
            sicmedRegisteredBean.setErrorMessage("挂号ID不正确");
            return sicmedRegisteredBean;
        }
        SicmedUser deleteUser = sicmedUserService.get(SsidUtils.getSicmedUserId(ssid));
        // 调用service方法查询患者信息
        SicmedRegistered sicmedRegistered = sicmedRegisteredService.get(registeredId);
        // 查询结果校验 处理
        if (sicmedRegistered != null) {
            // 退号删除挂号信息
            sicmedRegistered.setDeleteUser(deleteUser);
            sicmedRegistered.setUpdateDate(DateTimeUtils.getTime());
            sicmedRegisteredService.update(sicmedRegistered);

            sicmedRegisteredService.delete(sicmedRegistered);

            // 退号删除患者信息
            SicmedPatient sicmedPatient = sicmedRegistered.getSicmedPatient();
            sicmedPatient.setDeleteUser(deleteUser);
            sicmedPatientService.update(sicmedPatient);

            sicmedPatientService.delete(sicmedPatient);

            sicmedRegisteredBean.setError("0");
            sicmedRegisteredBean.setErrorMessage("取消挂号成功");
        } else {
            sicmedRegisteredBean.setError("1");
            sicmedRegisteredBean.setErrorMessage("取消挂号失败挂号信息不存在");
        }
        return sicmedRegisteredBean;
    }

    /**
     * 改号
     *
     * @param sicmedRegisteredBean
     * @param patientId
     * @param branchId
     * @return
     * @author Max
     */

    @ResponseBody
    @RequestMapping(value = "update")
    public BaseBean update(SicmedPatientBean sicmedPatientBean, String branchId, String doctorId,
                           String registeredTypeId, String registeredId, String ssid) {
        // 创建返回对象
        SicmedRegisteredBean sicmedRegisteredBean = new SicmedRegisteredBean();
        // 传入参数校验
        if (AppParameterSimulation.isEmpty(registeredId)) {
            sicmedPatientBean.setError("1");
            sicmedPatientBean.setErrorMessage("参数不能为空");
            return sicmedPatientBean;
        } else if (!AppParameterSimulation.simulationId(registeredId)) {
            sicmedPatientBean.setError("1");
            sicmedPatientBean.setErrorMessage("挂号Id不正确");
            return sicmedPatientBean;
        }
        // 获取 挂号患者 对象
        SicmedPatient sicmedPatient = sicmedPatientService.get(sicmedPatientBean.getId());
        sicmedPatient = SicmedPatientSetBean.setSPB(sicmedPatientBean, sicmedPatient);
        // 获取挂号患者的 属性
        SicmedUser updateUser = sicmedUserService.get(SsidUtils.getSicmedUserId(ssid));
        sicmedPatient.setUpdateUser(updateUser);
        sicmedPatient.setUpdateDate(DateTimeUtils.getTime());
        // 调用service方法 保存患者信息
        sicmedPatientService.update(sicmedPatient);
        // 获取 挂号信息 对象
        SicmedRegistered sicmedRegistered = sicmedRegisteredService.get(registeredId);
        // 获取 挂号对象的 属性
        SicmedBranch sicmedBranch = sicmedBranchService.get(branchId);
        SicmedUser sicmedDoctor = sicmedUserService.get(doctorId);
        SicmedRegisteredType sicmedRegisteredType = sicmedRegisteredTypeService.get(registeredTypeId);
        SicmedRegisteredPrice sicmedRegisteredPrice = sicmedRegisteredType.getSicmedRegisteredPrice();
        int a = Integer.parseInt(sicmedRegisteredPrice.getRegisteredFee());
        int b = Integer.parseInt(sicmedRegisteredPrice.getClinicsFee());
        int c = Integer.parseInt(sicmedRegisteredPrice.getMaterialFee());
        Integer price = a + b + c;

        // 为挂号对象赋值
        sicmedRegistered.setSicmedBranch(sicmedBranch);
        sicmedRegistered.setSicmedRegistrationType(sicmedRegisteredType);
        sicmedRegistered.setSicmedDoctor(sicmedDoctor);
        sicmedRegistered.setUpdateUser(updateUser);
        sicmedRegistered.setRegisteredPric(price.toString());
        // 调用service方法保存患者挂号信息
        sicmedRegistered.setUpdateDate(DateTimeUtils.getTime());
        sicmedRegisteredService.update(sicmedRegistered);
        // 获取保存好的 挂号信息
        sicmedRegistered = sicmedRegisteredService.get(sicmedRegistered);
        if (sicmedRegistered != null) {
            sicmedRegistered.setSicmedRegistrationType(sicmedRegisteredType);
            sicmedRegisteredBean.setSR(sicmedRegistered);
            sicmedRegisteredBean.setError("0");
            sicmedRegisteredBean.setErrorMessage("修改挂号成功返回打印信息");
        } else {
            sicmedRegisteredBean.setError("1");
            sicmedRegisteredBean.setErrorMessage("修改挂号成功返回打印信息失败");
        }

        return sicmedRegisteredBean;

    }

    /**
     * 根据患者查询患者挂号信息
     *
     * @param patientId
     * @return
     * @author Max
     */

    @ResponseBody
    @RequestMapping(value = "getByPatient")
    public BaseBean getByPatient(String patientId) {
        // 创建返回对象
        SicmedRegisteredBean sicmedRegisteredBean = new SicmedRegisteredBean();
        // 参数校验
        if (AppParameterSimulation.isEmpty(patientId)) {
            sicmedRegisteredBean.setError("1");
            sicmedRegisteredBean.setErrorMessage("参数为空");
            return sicmedRegisteredBean;
        } else if (!AppParameterSimulation.simulationId(patientId)) {
            sicmedRegisteredBean.setError("1");
            sicmedRegisteredBean.setErrorMessage("患者ID不正确");
            return sicmedRegisteredBean;
        }
        // 创建查询条件
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        // 获取查询条件参数
        SicmedPatient sicmedPatient = sicmedPatientService.get(patientId);
        // 查询条件赋值
        sicmedRegistered.setSicmedPatient(sicmedPatient);
        // 调用service方法查询患者挂号信息
        sicmedRegistered = sicmedRegisteredService.getByP(sicmedRegistered);
        // 查询结果校验 处理
        if (sicmedRegistered != null) {
            SicmedRegisteredType sicmedRegisteredType = sicmedRegisteredTypeService
                    .get(sicmedRegistered.getSicmedRegistrationType().getId());
            SicmedRegisteredPrice sicmedRegisteredPrice = sicmedRegisteredPriceService
                    .get(sicmedRegisteredType.getSicmedRegisteredPrice());
            if (sicmedRegistered.getSicmedDoctor() != null) {
                SicmedUser sicmedDoctor = sicmedUserService.get(sicmedRegistered.getSicmedDoctor().getId());
                sicmedRegistered.setSicmedDoctor(sicmedDoctor);
            }
            sicmedRegisteredType.setSicmedRegisteredPrice(sicmedRegisteredPrice);
            sicmedRegistered.setSicmedRegistrationType(sicmedRegisteredType);
            sicmedRegisteredBean.getCreateUserBean().setSUser(sicmedRegistered.getCreateUser());
            sicmedRegisteredBean.setSR(sicmedRegistered);
            sicmedRegisteredBean.setError("0");
            sicmedRegisteredBean.setErrorMessage("查询成功");
        } else {
            sicmedRegisteredBean.setError("1");
            sicmedRegisteredBean.setErrorMessage("查询失败 结果为空");
        }
        return sicmedRegisteredBean;
    }

    /**
     * 查询挂号记录
     *
     * @param ssid
     * @return BaseBean
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "getRegisteredFlag")
    public BaseBean getRegisteredFlag(@RequestParam(required = false) String ssid) {
        // 创建返回对象
        HistoryRecordBeans historyRecordBeans = new HistoryRecordBeans();
        // 创建查询条件
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        // 获取查询条件的属性
        Date startDate = DateTimeUtils.getDayBeginDate();
        Date endDate = DateTimeUtils.getTime();
        SicmedUser sicmedUser = sicmedUserService.get(SsidUtils.getSicmedUserId(ssid));
        // 给查询条件赋值
        sicmedRegistered.setRegisteredBeginDate(startDate);
        sicmedRegistered.setRegisteredEndDate(endDate);
        sicmedRegistered.setCreateUser(sicmedUser);
        // 根据查询条件去数据库中查询
        List<SicmedRegistered> sicmedRegisteredes = sicmedRegisteredService.findHistoryListByCreateUser(sicmedRegistered);
        // 查询结果处理
        if (sicmedRegisteredes.size() > 0) {
            for (SicmedRegistered sicmedRegistered2 : sicmedRegisteredes) {
                HistoryRecordBean historyRecordBean = new HistoryRecordBean();
                historyRecordBean.setHRB(sicmedRegistered2.getSicmedPatient());
                historyRecordBeans.getHistoryRecordBeans().add(historyRecordBean);
            }
            historyRecordBeans.setBenginDate(DateTimeUtils.getDateStr(startDate));
            historyRecordBeans.setEndDate(DateTimeUtils.getDateStr(endDate));
            historyRecordBeans.setError("0");
            historyRecordBeans.setErrorMessage("查询成功");

        } else {
            historyRecordBeans.setError("0");
            historyRecordBeans.setErrorMessage("查询的结果为空");
        }
        return historyRecordBeans;
    }

    /**
     * 查询退号记录
     *
     * @param ssid
     * @return BaseBean
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "getDelRegisteredFlag")
    public BaseBean getDelRegisteredFlag(@RequestParam(required = false) String ssid) {
        // 创建返回对象
        HistoryRecordBeans historyRecordBeans = new HistoryRecordBeans();
        // 创建查询条件
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        // 获取查询条件的属性
        Date startDate = DateTimeUtils.getDayBeginDate();
        Date endDate = DateTimeUtils.getTime();
        SicmedUser deleteUser = sicmedUserService.get(SsidUtils.getSicmedUserId(ssid));
        // 给查询条件赋值
        sicmedRegistered.setRegisteredBeginDate(startDate);
        sicmedRegistered.setRegisteredEndDate(endDate);
        sicmedRegistered.setDeleteUser(deleteUser);
        // 根据查询条件去数据库中查询
        List<SicmedRegistered> sicmedRegisteredes = sicmedRegisteredService.findHistoryListByDeleteUser(sicmedRegistered);
        //查询结果校验
        if (sicmedRegisteredes.size() > 0) {
            for (SicmedRegistered sicmedRegistered2 : sicmedRegisteredes) {
                HistoryRecordBean historyRecordBean = new HistoryRecordBean();
                historyRecordBean.setHRB(sicmedRegistered2.getSicmedPatient());
                historyRecordBeans.getHistoryRecordBeans().add(historyRecordBean);
            }
            historyRecordBeans.setBenginDate(DateTimeUtils.getDateStr(startDate));
            historyRecordBeans.setEndDate(DateTimeUtils.getDateStr(endDate));
            historyRecordBeans.setError("0");
            historyRecordBeans.setErrorMessage("查询成功");

        } else {
            historyRecordBeans.setError("0");
            historyRecordBeans.setErrorMessage("查询的结果为空");
        }
        return historyRecordBeans;
    }

    /**
     * 查询改记录
     *
     * @param ssid
     * @return BaseBean
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "getUpRegisteredFlag")
    public BaseBean getUpRegisteredFlag(@RequestParam(required = false) String ssid) {
        // 创建返回对象
        HistoryRecordBeans historyRecordBeans = new HistoryRecordBeans();
        // 创建查询条件
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        // 获取查询条件的属性
        Date startDate = DateTimeUtils.getDayBeginDate();
        Date endDate = DateTimeUtils.getTime();
        SicmedUser updateUser = sicmedUserService.get(SsidUtils.getSicmedUserId(ssid));
        // 给查询条件赋值
        sicmedRegistered.setRegisteredBeginDate(startDate);
        sicmedRegistered.setRegisteredEndDate(endDate);
        sicmedRegistered.setUpdateUser(updateUser);
        // 根据查询条件去数据库中查询
        List<SicmedRegistered> sicmedRegisteredes = sicmedRegisteredService.findHistoryListByUpdateUser(sicmedRegistered);
        //查询结果校验
        if (sicmedRegisteredes.size() > 0) {
            for (SicmedRegistered sicmedRegistered2 : sicmedRegisteredes) {
                HistoryRecordBean historyRecordBean = new HistoryRecordBean();
                historyRecordBean.setHRB(sicmedRegistered2.getSicmedPatient());
                historyRecordBeans.getHistoryRecordBeans().add(historyRecordBean);
            }
            historyRecordBeans.setBenginDate(DateTimeUtils.getDateStr(startDate));
            historyRecordBeans.setEndDate(DateTimeUtils.getDateStr(endDate));
            historyRecordBeans.setError("0");
            historyRecordBeans.setErrorMessage("查询成功");

        } else {
            historyRecordBeans.setError("0");
            historyRecordBeans.setErrorMessage("查询的结果为空");
        }
        return historyRecordBeans;
    }


    /**
     * 获取医生端首页 患者列表 (未排序)
     *
     * @param ssid
     * @return sicmedPatientBeans
     * @author Max
     */

    @ResponseBody
    @RequestMapping(value = "findShow")
    public BaseBean findShow(@RequestParam(required = false) String ssid, String pageNo) {

        // 创建返回对象
        SicmedPatientBeans sicmedPatientBeans = new SicmedPatientBeans();
        // 参数校验

        // 创建查询参数
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        // 获取查询参数属性
        SicmedUser sicmedDoctor = sicmedUserService.get(SsidUtils.getSicmedUserId(ssid));
        SicmedBranch sicmedBranch = sicmedDoctor.getSicmedBranch();
        Page<SicmedRegistered> page = new Page<SicmedRegistered>();
        page.setPageSize(PageUtils.PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 查询条件赋值
        sicmedRegistered.setPage(page);
        // 查询参数赋值
        sicmedRegistered.setSicmedBranch(sicmedBranch);
        sicmedRegistered.setSicmedDoctor(sicmedDoctor);
        // 调用service方法查询挂号信息
        List<SicmedRegistered> sicmedRegisteredes = sicmedRegisteredService.findByDAndB(sicmedRegistered);
        // 查询参数校验 处理
        if (sicmedRegisteredes.size() > 0) {
            for (SicmedRegistered sicmedRegistered2 : sicmedRegisteredes) {
                SicmedPatientBean sicmedPatientBean = new SicmedPatientBean();
                sicmedPatientBean.setSP(sicmedPatientService.get(sicmedRegistered2.getSicmedPatient()));
                sicmedPatientBeans.getSicmedPatientBeans().add(sicmedPatientBean);
            }
            sicmedPatientBeans.setError("0");
            sicmedPatientBeans.setErrorMessage("查询成功");
        } else {
            sicmedPatientBeans.setError("1");
            sicmedPatientBeans.setErrorMessage("查询的结果为空");
        }
        return sicmedPatientBeans;
    }


    /**
     * 查询挂号记录
     *
     * @param ssid
     * @return BaseBean
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "pc/getRegisteredFlag")
    public BaseBean getRegisteredFlag2(@RequestParam(required = false) String ssid, String beginDate, String endDate) {
        // 创建返回对象
        HistoryRecordBeans historyRecordBeans = new HistoryRecordBeans();
        // 创建查询条件
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        Date beginDate1 = DateTimeUtils.getDate("2016-01-01 00:00:00");
        Date endDate1 = DateTimeUtils.getTime();
        // 获取查询条件的属性
        if (!AppParameterSimulation.isEmpty(beginDate)) {
            beginDate1 = DateTimeUtils.getDate(beginDate);
            endDate1 = DateTimeUtils.getDate(endDate);
        } else if (!AppParameterSimulation.isEmpty(endDate)) {
            beginDate1 = DateTimeUtils.getDate(beginDate);
            endDate1 = DateTimeUtils.getDate(endDate);
        }

        SicmedUser sicmedUser = sicmedUserService.get(SsidUtils.getSicmedUserId(ssid));
        // 给查询条件赋值
        sicmedRegistered.setRegisteredBeginDate(beginDate1);
        sicmedRegistered.setRegisteredEndDate(endDate1);
        sicmedRegistered.setCreateUser(sicmedUser);
        // 根据查询条件去数据库中查询
        List<SicmedRegistered> sicmedRegisteredes = sicmedRegisteredService.findHistoryListByCreateUser(sicmedRegistered);
        // 查询结果处理
        if (sicmedRegisteredes.size() > 0) {
            for (SicmedRegistered sicmedRegistered2 : sicmedRegisteredes) {
                HistoryRecordBean historyRecordBean = new HistoryRecordBean();
                historyRecordBean.setHRBByRegistered(sicmedRegistered2);
                historyRecordBeans.getHistoryRecordBeans().add(historyRecordBean);
            }
            historyRecordBeans.setBenginDate(DateTimeUtils.getDateStr(beginDate1));
            historyRecordBeans.setEndDate(DateTimeUtils.getDateStr(endDate1));
            historyRecordBeans.setError("0");
            historyRecordBeans.setErrorMessage("查询成功");

        } else {
            historyRecordBeans.setError("0");
            historyRecordBeans.setErrorMessage("查询的结果为空");
        }
        return historyRecordBeans;
    }

    /**
     * 查询退号记录
     *
     * @param ssid
     * @return BaseBean
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "pc/getDelRegisteredFlag")
    public BaseBean getDelRegisteredFlag2(@RequestParam(required = false) String ssid, String beginDate, String endDate) {
        // 创建返回对象
        HistoryRecordBeans historyRecordBeans = new HistoryRecordBeans();
        // 创建查询条件
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        Date beginDate1 = DateTimeUtils.getDate("2016-01-01 00:00:00");
        Date endDate1 = DateTimeUtils.getTime();
        // 获取查询条件的属性
        if (!AppParameterSimulation.isEmpty(beginDate)) {
            beginDate1 = DateTimeUtils.getDate(beginDate);
            endDate1 = DateTimeUtils.getDate(endDate);
        } else if (!AppParameterSimulation.isEmpty(endDate)) {
            beginDate1 = DateTimeUtils.getDate(beginDate);
            endDate1 = DateTimeUtils.getDate(endDate);
        }
        SicmedUser deleteUser = sicmedUserService.get(SsidUtils.getSicmedUserId(ssid));
        // 给查询条件赋值
        sicmedRegistered.setRegisteredBeginDate(beginDate1);
        sicmedRegistered.setRegisteredEndDate(endDate1);
        sicmedRegistered.setDeleteUser(deleteUser);
        // 根据查询条件去数据库中查询
        List<SicmedRegistered> sicmedRegisteredes = sicmedRegisteredService.findHistoryListByDeleteUser(sicmedRegistered);
        //查询结果校验
        if (sicmedRegisteredes.size() > 0) {
            for (SicmedRegistered sicmedRegistered2 : sicmedRegisteredes) {
                HistoryRecordBean historyRecordBean = new HistoryRecordBean();
                historyRecordBean.setHRBByRegistered(sicmedRegistered2);
                historyRecordBeans.getHistoryRecordBeans().add(historyRecordBean);
            }
            historyRecordBeans.setBenginDate(DateTimeUtils.getDateStr(beginDate1));
            historyRecordBeans.setEndDate(DateTimeUtils.getDateStr(endDate1));
            historyRecordBeans.setError("0");
            historyRecordBeans.setErrorMessage("查询成功");

        } else {
            historyRecordBeans.setError("0");
            historyRecordBeans.setErrorMessage("查询的结果为空");
        }
        return historyRecordBeans;
    }

    /**
     * 查询改记录
     *
     * @param ssid
     * @return BaseBean
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "pc/getUpRegisteredFlag")
    public BaseBean getUpRegisteredFlag2(@RequestParam(required = false) String ssid, String beginDate, String endDate) {
        // 创建返回对象
        HistoryRecordBeans historyRecordBeans = new HistoryRecordBeans();
        // 创建查询条件
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        Date beginDate1 = DateTimeUtils.getDate("2016-01-01 00:00:00");
        Date endDate1 = DateTimeUtils.getTime();
        // 获取查询条件的属性
        if (!AppParameterSimulation.isEmpty(beginDate)) {
            beginDate1 = DateTimeUtils.getDate(beginDate);
            endDate1 = DateTimeUtils.getDate(endDate);
        } else if (!AppParameterSimulation.isEmpty(endDate)) {
            beginDate1 = DateTimeUtils.getDate(beginDate);
            endDate1 = DateTimeUtils.getDate(endDate);
        }
        SicmedUser updateUser = sicmedUserService.get(SsidUtils.getSicmedUserId(ssid));
        // 给查询条件赋值
        sicmedRegistered.setRegisteredBeginDate(beginDate1);
        sicmedRegistered.setRegisteredEndDate(endDate1);
        sicmedRegistered.setUpdateUser(updateUser);
        // 根据查询条件去数据库中查询
        List<SicmedRegistered> sicmedRegisteredes = sicmedRegisteredService.findHistoryListByUpdateUser(sicmedRegistered);
        //查询结果校验
        if (sicmedRegisteredes.size() > 0) {
            for (SicmedRegistered sicmedRegistered2 : sicmedRegisteredes) {
                HistoryRecordBean historyRecordBean = new HistoryRecordBean();
                historyRecordBean.setHRBByRegistered(sicmedRegistered2);
                historyRecordBeans.getHistoryRecordBeans().add(historyRecordBean);
            }
            historyRecordBeans.setBenginDate(DateTimeUtils.getDateStr(beginDate1));
            historyRecordBeans.setEndDate(DateTimeUtils.getDateStr(endDate1));
            historyRecordBeans.setError("0");
            historyRecordBeans.setErrorMessage("查询成功");

        } else {
            historyRecordBeans.setError("0");
            historyRecordBeans.setErrorMessage("查询的结果为空");
        }
        return historyRecordBeans;
    }

}