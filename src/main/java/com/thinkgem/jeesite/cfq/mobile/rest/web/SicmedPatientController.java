package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedRegisteredBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedRegisteredBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedBranch;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatient;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatientPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegistered;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedUser;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedBranchService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedPatientPriceService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedPatientService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedRegisteredService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedUserService;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.PageUtils;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.SsidUtils;

/**
 * 患者信息表Controller
 *
 * @author Max
 * @version 2016-07-12
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedPatient")
public class SicmedPatientController extends BaseController {

    @Autowired
    private SicmedPatientService sicmedPatientService;

    @Autowired
    private SicmedPatientPriceService sicmedPatientPriceService;

    @Autowired
    private SicmedUserService sicmedUserService;

    @Autowired
    private SicmedRegisteredService sicmedRegisteredService;

    @Autowired
    private SicmedBranchService sicmedBranchService;

    /**
     * 查询可以退号的 患者
     */
    @ResponseBody
    @RequestMapping(value = "findAllRefund")
    public BaseBean findAllRefund(@RequestParam(required = false) String patientId) {
        // 创建返回对象
        SicmedPatientBeans sicmedPatientBeans = new SicmedPatientBeans();
        // 创建查询对象
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        // 查询对象赋值
        sicmedRegistered.setRegisteredStatus("0");
        // 调用 service 查询 挂号信息
        List<SicmedRegistered> sicmedRegistereds = sicmedRegisteredService.findRefuntOrChange(sicmedRegistered);
        // 查询结果校验 处理
        if (sicmedRegistereds.size() > 0) {
            for (SicmedRegistered sicmedRegistered2 : sicmedRegistereds) {
                // 获取挂号患者信息
                SicmedPatientBean sicmedPatientBean = new SicmedPatientBean();
                sicmedPatientBean.setSP(sicmedPatientService.get(sicmedRegistered2.getSicmedPatient()));
                sicmedPatientBeans.getSicmedPatientBeans().add(sicmedPatientBean);
            }
            sicmedPatientBeans.setError("0");
            sicmedPatientBeans.setErrorMessage("所有可以退号的患者信息");
        } else {
            sicmedPatientBeans.setError("1");
            sicmedPatientBeans.setErrorMessage("没有可以退号的患者信息");
        }
        // 返回处理结果
        return sicmedPatientBeans;
    }

    /**
     * PC查询可以退号的 患者
     */
    @ResponseBody
    @RequestMapping(value = "pc/findAllRefund")
    public BaseBean findAllRefund2(String pageNo) {
        // 创建返回对象
        SicmedRegisteredBeans sicmedRegisteredBeans = new SicmedRegisteredBeans();
        // 创建查询对象
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        // 查询对象赋值
        sicmedRegistered.setRegisteredStatus("0");
        Page<SicmedRegistered> page = new Page<SicmedRegistered>();
        page.setPageSize(PageUtils.PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 查询条件赋值
        sicmedRegistered.setPage(page);
        // 调用 service 查询 挂号信息
        List<SicmedRegistered> sicmedRegistereds = sicmedRegisteredService.findRefuntOrChange(sicmedRegistered);
        // 查询结果校验 处理
        if (sicmedRegistereds.size() > 0) {
            for (SicmedRegistered sicmedRegistered2 : sicmedRegistereds) {
                SicmedRegisteredBean sicmedRegisteredBean = new SicmedRegisteredBean();
                sicmedRegisteredBean.setSR(sicmedRegistered2);
                sicmedRegisteredBeans.getSicmedRegisteredBeans().add(sicmedRegisteredBean);
            }
            sicmedRegisteredBeans.setError("0");
            sicmedRegisteredBeans.setErrorMessage("所有可以退号的患者信息");
        } else {
            sicmedRegisteredBeans.setError("1");
            sicmedRegisteredBeans.setErrorMessage("没有可以退号的患者信息");
        }
        // 返回处理结果
        return sicmedRegisteredBeans;
    }

    /**
     * 查询可以改号的 患者
     */

    @ResponseBody
    @RequestMapping(value = "findAllChange")
    public BaseBean findAllChange(@RequestParam(required = false) String patientId) {
        // 创建返回对象
        SicmedPatientBeans sicmedPatientBeans = new SicmedPatientBeans();
        // 创建查询对象
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        // 查询对象赋值
        sicmedRegistered.setRegisteredStatus("1");
        // 调用 service 查询 挂号信息
        List<SicmedRegistered> sicmedRegistereds = sicmedRegisteredService.findRefuntOrChange(sicmedRegistered);
        // 查询结果校验 处理
        if (sicmedRegistereds.size() > 0) {
            for (SicmedRegistered sicmedRegistered2 : sicmedRegistereds) {
                // 获取挂号患者信息
                SicmedPatientBean sicmedPatientBean = new SicmedPatientBean();
                sicmedPatientBean.setSP(sicmedPatientService.get(sicmedRegistered2.getSicmedPatient()));
                sicmedPatientBeans.getSicmedPatientBeans().add(sicmedPatientBean);
            }
            sicmedPatientBeans.setError("0");
            sicmedPatientBeans.setErrorMessage("所有可以退号的患者信息");
        } else {
            sicmedPatientBeans.setError("1");
            sicmedPatientBeans.setErrorMessage("没有可以退号的患者信息");
        }
        // 返回处理结果
        return sicmedPatientBeans;
    }

    @ResponseBody
    @RequestMapping(value = "pc/findAllChange")
    public BaseBean findAllChange2(String pageNo) {
        // 创建返回对象
        SicmedRegisteredBeans sicmedRegisteredBeans = new SicmedRegisteredBeans();
        // 创建查询对象
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        // 查询对象赋值
        sicmedRegistered.setRegisteredStatus("1");
        Page<SicmedRegistered> page = new Page<SicmedRegistered>();
        page.setPageSize(PageUtils.PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 查询条件赋值
        sicmedRegistered.setPage(page);
        // 调用 service 查询 挂号信息
        List<SicmedRegistered> sicmedRegistereds = sicmedRegisteredService.findRefuntOrChange(sicmedRegistered);

        // 查询结果校验 处理
        if (sicmedRegistereds.size() > 0) {
            for (SicmedRegistered sicmedRegistered2 : sicmedRegistereds) {
                SicmedRegisteredBean sicmedRegisteredBean = new SicmedRegisteredBean();
                sicmedRegisteredBean.setSR(sicmedRegistered2);
                sicmedRegisteredBeans.getSicmedRegisteredBeans().add(sicmedRegisteredBean);
            }
            sicmedRegisteredBeans.setError("0");
            sicmedRegisteredBeans.setErrorMessage("所有可以退号的患者信息");
        } else {
            sicmedRegisteredBeans.setError("1");
            sicmedRegisteredBeans.setErrorMessage("没有可以退号的患者信息");
        }
        // 返回处理结果
        return sicmedRegisteredBeans;
    }

    /**
     * 查询 可以就诊的患者
     */
    @ResponseBody
    @RequestMapping(value = "findAllCheckPatient")
    public BaseBean findAllCheckPatient(String ssid, String pageNo) {
        // 创建返回对象
        SicmedPatientBeans sicmedPatientBeans = new SicmedPatientBeans();
        // 创建查询对象
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        // 获取查询对象的值
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
        // 查询对象赋值
        sicmedRegistered.setSicmedBranch(sicmedBranch);
        sicmedRegistered.setSicmedDoctor(sicmedDoctor);
        // 调用 service 查询 挂号信息
        List<SicmedRegistered> sicmedRegistereds = sicmedRegisteredService.findByDAndB(sicmedRegistered);
        // 查询结果校验 处理
        if (sicmedRegistereds.size() > 0) {
            for (SicmedRegistered sicmedRegistered2 : sicmedRegistereds) {
                // 获取挂号患者信息
                SicmedPatientBean sicmedPatientBean = new SicmedPatientBean();
                sicmedPatientBean.setSP(sicmedPatientService.get(sicmedRegistered2.getSicmedPatient()));
                sicmedPatientBeans.getSicmedPatientBeans().add(sicmedPatientBean);
            }
            sicmedPatientBeans.setError("0");
            sicmedPatientBeans.setErrorMessage("所有可以就诊的患者信息");
        } else {
            sicmedPatientBeans.setError("1");
            sicmedPatientBeans.setErrorMessage("没有可以就诊的患者信息");
        }
        // 返回处理结果
        return sicmedPatientBeans;

    }

    /**
     * 查询
     */

    /**
     * 根据ID查询患者信息
     *
     * @param patientId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getById")
    public BaseBean getById(@RequestParam(required = false) String patientId) {

        if (!AppParameterSimulation.simulationId(patientId)) {
            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;
        }

        SicmedPatientBean sicmedPatientBean = new SicmedPatientBean();
        try {
            SicmedPatient sicmedPatient = sicmedPatientService.get(patientId);
            sicmedPatientBean.setSP(sicmedPatient);
            sicmedPatientBean.setError("0");
            sicmedPatientBean.setErrorMessage("查询患者成功");
        } catch (Exception e) {
            e.printStackTrace();
            sicmedPatientBean.setError("1");
            sicmedPatientBean.setErrorMessage("查询患者失败");
        }
        return sicmedPatientBean;

    }

    /**
     * 查询
     *
     * @param patientId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getHistoryByParam")
    public BaseBean getHistoryByParam(@RequestParam(required = false) String param, String ssid) {
        // 创建返回对象
        SicmedPatientBeans sicmedPatientBeans = new SicmedPatientBeans();
        // 输入参数校验
        if (AppParameterSimulation.isEmpty(param)) {
            sicmedPatientBeans.setError("1");
            sicmedPatientBeans.setErrorMessage("输入 参数不能为空");
            return sicmedPatientBeans;
        } else if (param.length() > 12) {
            sicmedPatientBeans.setError("1");
            sicmedPatientBeans.setErrorMessage("输入 参数过长");
            return sicmedPatientBeans;
        }
        // 创建查询调条件
        SicmedPatient sicmedPatient = new SicmedPatient();
        // 判断参数类型
        if (AppParameterSimulation.isNumber(param)) {
            // 判断结果为数字
            sicmedPatient.setPatientTel(param);
        } else if (AppParameterSimulation.simulationIsChinese(param)) {
            // 判断结果为汉字
            sicmedPatient.setPatientName(param);
        }
        sicmedPatient.setCreateUser(sicmedUserService.get(SsidUtils.getSicmedUserId(ssid)));
        // 获取数据
        List<SicmedPatient> sicmedPatients = sicmedPatientService.findListLike(sicmedPatient);
        // 获取数据判断
        if (sicmedPatients.size() > 0) {
            // 数据处理
            for (SicmedPatient sicmedPatient2 : sicmedPatients) {
                SicmedPatientBean sicmedPatientBean = new SicmedPatientBean();
                sicmedPatientBean.setSP(sicmedPatient2);
                sicmedPatientBeans.getSicmedPatientBeans().add(sicmedPatientBean);
            }
            sicmedPatientBeans.setError("0");
            sicmedPatientBeans.setErrorMessage("查询患者成功");
        } else {
            sicmedPatientBeans.setError("1");
            sicmedPatientBeans.setErrorMessage("未找到患者");
        }
        return sicmedPatientBeans;

    }

    /**
     * 医生查询患者信息
     *
     * @param param
     * @return 医生所在科室的所有挂号患者
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "getByParam")
    public BaseBean getByParam(@RequestParam(required = false) String param, String ssid) {
        SicmedPatientBeans sicmedPatientBeans = new SicmedPatientBeans();
        // 创建查询对象
        SicmedPatient sicmedPatient = new SicmedPatient();
        if (AppParameterSimulation.isEmpty(param)) {
            sicmedPatientBeans.setError("1");
            sicmedPatientBeans.setErrorMessage("请求参数不能为空");
            return sicmedPatientBeans;
        } else if (AppParameterSimulation.simulationIsNumber(param)) {
            // 如果是编号
            sicmedPatient.setPatientNumber(param);
        } else if (AppParameterSimulation.isChineseName(param)) {
            // 如果是姓名
            sicmedPatient.setPatientName(param);
        } else {
            sicmedPatientBeans.setError("1");
            sicmedPatientBeans.setErrorMessage("请求参数不正确");
            return sicmedPatientBeans;
        }
        // 获取操作医生
        SicmedUser sicmedDoctor = sicmedUserService.get(SsidUtils.getSicmedUserId(ssid));
        // 获取操作医生所属科室
        SicmedBranch sicmedBranch = sicmedBranchService.get(sicmedDoctor.getSicmedBranch());
        // 获取科室下的所有挂号信息
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        sicmedRegistered.setSicmedBranch(sicmedBranch);
        sicmedRegistered.setSicmedPatient(sicmedPatient);
        List<SicmedRegistered> sicmedRegisteredes = sicmedRegisteredService.findByParamAndD(sicmedRegistered);
        if (sicmedRegisteredes.size() > 0) {
            for (SicmedRegistered sicmedRegistered2 : sicmedRegisteredes) {
                SicmedPatientBean sicmedPatientBean = new SicmedPatientBean();
                sicmedPatientBean.setSP(sicmedRegistered2.getSicmedPatient());
                sicmedPatientBeans.getSicmedPatientBeans().add(sicmedPatientBean);
            }
            sicmedPatientBeans.setError("0");
            sicmedPatientBeans.setErrorMessage("查詢成功");
            return sicmedPatientBeans;
        } else {
            sicmedPatientBeans.setError("1");
            sicmedPatientBeans.setErrorMessage("查詢结果为空");
            return sicmedPatientBeans;
        }
    }

    /**
     * 收费退费 查询患者信息
     *
     * @param param
     * @return BaseBean
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "getByParams")
    public BaseBean getByParams(@RequestParam(required = false) String param, String isPay) {

        // 创建返回对象
        SicmedPatientBeans sicmedPatientBeans = new SicmedPatientBeans();
        // 创建查询条件
        SicmedPatient sicmedPatient = new SicmedPatient();
        if (AppParameterSimulation.isEmpty(param)) {
            sicmedPatientBeans.setError("1");
            sicmedPatientBeans.setErrorMessage("请求参数不能为空");
            //return sicmedPatientBeans;
        } else if (AppParameterSimulation.simulationIsNumber(param)) {
            // 查询条件赋值
            sicmedPatient.setPatientNumber(param);
        } else if (AppParameterSimulation.isChineseName(param)) {
            // 查询条件赋值
            sicmedPatient.setPatientName(param);
        } else {
            sicmedPatientBeans.setError("1");
            sicmedPatientBeans.setErrorMessage("请求参数不正确");
            return sicmedPatientBeans;
        }
        //调用service方法查询患者信息
        List<SicmedPatient> sicmedPatients = sicmedPatientService.findListLike(sicmedPatient);
        if (sicmedPatients.size() > 0) {
            for (SicmedPatient sicmedPatient2 : sicmedPatients) {
                // 创建查询条件
                SicmedPatientPrice patientPrice = new SicmedPatientPrice();
                // 给查询条件赋值
                patientPrice.setSicmedPatient(sicmedPatient2);
                patientPrice.setIsPay(isPay);
                // 执行查询条件
                List<SicmedPatientPrice> tempList = sicmedPatientPriceService.findListUUID(patientPrice);
                if (tempList.size() > 0) {
                    SicmedPatientBean sicmedPatientBean = new SicmedPatientBean();
                    sicmedPatientBean.setSP(sicmedPatient2);
                    sicmedPatientBeans.getSicmedPatientBeans().add(sicmedPatientBean);
                } else {
                    continue;
                }
            }
            sicmedPatientBeans.setError("0");
            sicmedPatientBeans.setErrorMessage("查询成功返回可操作患者信息");
            return sicmedPatientBeans;
        } else {
            sicmedPatientBeans.setError("1");
            sicmedPatientBeans.setErrorMessage("不存在可操作患者");
            return sicmedPatientBeans;
        }
    }

	/*
     * @ModelAttribute public SicmedPatient get(@RequestParam(required=false)
	 * String id) { SicmedPatient entity = null; if
	 * (StringUtils.isNotBlank(id)){ entity = sicmedPatientService.get(id); } if
	 * (entity == null){ entity = new SicmedPatient(); } return entity; }
	 * 
	 * @RequiresPermissions("rest:sicmedPatient:view")
	 * 
	 * @RequestMapping(value = {"list", ""}) public String list(SicmedPatient
	 * sicmedPatient, HttpServletRequest request, HttpServletResponse response,
	 * Model model) { Page<SicmedPatient> page =
	 * sicmedPatientService.findPage(new Page<SicmedPatient>(request, response),
	 * sicmedPatient); model.addAttribute("page", page); return
	 * "mobile/rest/sicmedPatientList"; }
	 * 
	 * @RequiresPermissions("rest:sicmedPatient:view")
	 * 
	 * @RequestMapping(value = "form") public String form(SicmedPatient
	 * sicmedPatient, Model model) { model.addAttribute("sicmedPatient",
	 * sicmedPatient); return "mobile/rest/sicmedPatientForm"; }
	 * 
	 * @RequiresPermissions("rest:sicmedPatient:edit")
	 * 
	 * @RequestMapping(value = "save") public String save(SicmedPatient
	 * sicmedPatient, Model model, RedirectAttributes redirectAttributes) { if
	 * (!beanValidator(model, sicmedPatient)){ return form(sicmedPatient,
	 * model); } sicmedPatientService.save(sicmedPatient);
	 * addMessage(redirectAttributes, "保存保存患者信息成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedPatient/?repage"; }
	 * 
	 * @RequiresPermissions("rest:sicmedPatient:edit")
	 * 
	 * @RequestMapping(value = "delete") public String delete(SicmedPatient
	 * sicmedPatient, RedirectAttributes redirectAttributes) {
	 * sicmedPatientService.delete(sicmedPatient);
	 * addMessage(redirectAttributes, "删除保存患者信息成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedPatient/?repage"; }
	 */

}