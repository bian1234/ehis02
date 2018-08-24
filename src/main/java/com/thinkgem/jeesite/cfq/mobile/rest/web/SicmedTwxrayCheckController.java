package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedTwxrayCheckBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedTwxrayCheckBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedTwxrayCheck;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedTwxrayClass;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedTwxrayCheckService;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.PageUtils;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedTwxrayClassService;
/**
 * RESTful接口示例Controller
 *
 * @author DING
 * @version 2016-07-22
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedTwxrayCheck")
public class SicmedTwxrayCheckController extends BaseController {

    @Autowired
    private SicmedTwxrayCheckService sicmedTwxrayCheckService;

    @Autowired
    private SicmedTwxrayClassService sicmedTwxrayClassService;

    /**
     * 检查搜索接
     *
     * @param parameter(编码;名称;拼音缩写)
     * @return BaseBean
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "searchCheck")
    public SicmedTwxrayCheckBeans searchAllCheck(String parameter, String classId, String pageNo) {

        // 创建返回对象
        SicmedTwxrayCheckBeans sicmedTwxrayCheckBeans = new SicmedTwxrayCheckBeans();
        // 传入参数校验
        // 创建查询条件对象
        SicmedTwxrayCheck sicmedTwxrayCheck = new SicmedTwxrayCheck();

        // 创建分页查询条件
        Page<SicmedTwxrayCheck> page = new Page<SicmedTwxrayCheck>();
        page.setPageSize(PageUtils.PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        sicmedTwxrayCheck.setPage(page);
        if (parameter != null) {
            if (AppParameterSimulation.isChineseName(parameter)) {
                sicmedTwxrayCheck.setCheckName(parameter);
            } else if (AppParameterSimulation.simulationIsNumber(parameter)) {
                sicmedTwxrayCheck.setCheckCode(parameter);
            } else if (AppParameterSimulation.simulationIsPinYin(parameter)) {
                sicmedTwxrayCheck.setCheckNamePY(parameter);
            }
        }
        if (AppParameterSimulation.isNotEmpty(classId)) {
            // 获取检查类别
            SicmedTwxrayClass sicmedTwxrayClass = sicmedTwxrayClassService.get(classId);
            sicmedTwxrayCheck.setSicmedTwxrayClass(sicmedTwxrayClass);
        }
        // 根据查询条件查询检查项目信息
        List<SicmedTwxrayCheck> sicmedTwxrayChecks = sicmedTwxrayCheckService.findListLike(sicmedTwxrayCheck);
        // 判断查询结果
        if (sicmedTwxrayChecks.size() == 0) {
            sicmedTwxrayCheckBeans.setError("1");
            sicmedTwxrayCheckBeans.setErrorMessage("查询结果为空");
            return sicmedTwxrayCheckBeans;
        } else {
            // 遍历查询结果
            sicmedTwxrayCheckBeans.setError("0");
            sicmedTwxrayCheckBeans.setErrorMessage("查询成功");
            for (SicmedTwxrayCheck sicmedTwxrayCheck2 : sicmedTwxrayChecks) {
                SicmedTwxrayCheckBean sicmedTwxrayCheckBean = new SicmedTwxrayCheckBean();
                sicmedTwxrayCheckBean.setSTCB(sicmedTwxrayCheck2);
                sicmedTwxrayCheckBeans.getTwxrayCheckBeanList().add(sicmedTwxrayCheckBean);
            }
        }
        return sicmedTwxrayCheckBeans;
    }

    /**
     * 根据类别 获取检查项目
     *
     * @param parameter
     * @param classId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findCheck")
    public SicmedTwxrayCheckBeans findCheck(String parameter, String classId, String pageNo) {
        // 创建返回对象
        SicmedTwxrayCheckBeans sicmedTwxrayCheckBeans = new SicmedTwxrayCheckBeans();
        // 传入参数校验
        if (AppParameterSimulation.isEmpty(classId)) {
            sicmedTwxrayCheckBeans.setError("1");
            sicmedTwxrayCheckBeans.setErrorMessage("参数不能为空");
            return sicmedTwxrayCheckBeans;
        } else if (AppParameterSimulation.simulationId(classId)) {
            sicmedTwxrayCheckBeans.setError("1");
            sicmedTwxrayCheckBeans.setErrorMessage("类别ID不正确");
            return sicmedTwxrayCheckBeans;
        }
        // 获取检查类别
        SicmedTwxrayClass sicmedTwxrayClass = new SicmedTwxrayClass();
        sicmedTwxrayClass.setId(classId);
        sicmedTwxrayClass = sicmedTwxrayClassService.get(sicmedTwxrayClass);
        // 创建查询条件对象
        SicmedTwxrayCheck sicmedTwxrayCheck = new SicmedTwxrayCheck();
        // 创建分页查询条件
        Page<SicmedTwxrayCheck> page = new Page<SicmedTwxrayCheck>();
        page.setPageSize(PageUtils.PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 查询条件赋值
        sicmedTwxrayCheck.setPage(page);
        sicmedTwxrayCheck.setCheckCode(parameter);
        sicmedTwxrayCheck.setSicmedTwxrayClass(sicmedTwxrayClass);
        // 调用service方法查询检查信息
        List<SicmedTwxrayCheck> sicmedTwxrayChecks = sicmedTwxrayCheckService.findListLike(sicmedTwxrayCheck);
        // 判断查询结果
        if (sicmedTwxrayChecks.size() == 0) {
            sicmedTwxrayCheckBeans.setError("1");
            sicmedTwxrayCheckBeans.setErrorMessage("查询结果为空");
            return sicmedTwxrayCheckBeans;
        } else {
            // 遍历查询结果
            sicmedTwxrayCheckBeans.setError("0");
            sicmedTwxrayCheckBeans.setErrorMessage("查询成功");
            for (SicmedTwxrayCheck sicmedTwxrayCheck2 : sicmedTwxrayChecks) {
                SicmedTwxrayCheckBean sicmedTwxrayCheckBean = new SicmedTwxrayCheckBean();
                sicmedTwxrayCheckBean.setSTCB(sicmedTwxrayCheck2);
                sicmedTwxrayCheckBeans.getTwxrayCheckBeanList().add(sicmedTwxrayCheckBean);
            }
        }
        return sicmedTwxrayCheckBeans;
    }

	/*
     * @ModelAttribute public SicmedTwxrayCheck get(@RequestParam(required =
	 * false) String id) { SicmedTwxrayCheck entity = null; if
	 * (StringUtils.isNotBlank(id)) { entity = sicmedTwxrayCheckService.get(id);
	 * } if (entity == null) { entity = new SicmedTwxrayCheck(); } return
	 * entity; }
	 * 
	 * @RequiresPermissions("rest:sicmedTwxrayCheck:view")
	 * 
	 * @RequestMapping(value = { "list", "" }) public String
	 * list(SicmedTwxrayCheck sicmedTwxrayCheck, HttpServletRequest request,
	 * HttpServletResponse response, Model model) { Page<SicmedTwxrayCheck> page
	 * = sicmedTwxrayCheckService.findPage(new Page<SicmedTwxrayCheck>(request,
	 * response), sicmedTwxrayCheck); model.addAttribute("page", page); return
	 * "mobile/rest/sicmedTwxrayCheckList"; }
	 * 
	 * @RequiresPermissions("rest:sicmedTwxrayCheck:view")
	 * 
	 * @RequestMapping(value = "form") public String form(SicmedTwxrayCheck
	 * sicmedTwxrayCheck, Model model) { model.addAttribute("sicmedTwxrayCheck",
	 * sicmedTwxrayCheck); return "mobile/rest/sicmedTwxrayCheckForm"; }
	 * 
	 * @RequiresPermissions("rest:sicmedTwxrayCheck:edit")
	 * 
	 * @RequestMapping(value = "save") public String save(SicmedTwxrayCheck
	 * sicmedTwxrayCheck, Model model, RedirectAttributes redirectAttributes) {
	 * if (!beanValidator(model, sicmedTwxrayCheck)) { return
	 * form(sicmedTwxrayCheck, model); }
	 * sicmedTwxrayCheckService.save(sicmedTwxrayCheck);
	 * addMessage(redirectAttributes, "保存单表成功"); return "redirect:" +
	 * Global.getAdminPath() + "/rest/sicmedTwxrayCheck/?repage"; }
	 * 
	 * @RequiresPermissions("rest:sicmedTwxrayCheck:edit")
	 * 
	 * @RequestMapping(value = "delete") public String delete(SicmedTwxrayCheck
	 * sicmedTwxrayCheck, RedirectAttributes redirectAttributes) {
	 * sicmedTwxrayCheckService.delete(sicmedTwxrayCheck);
	 * addMessage(redirectAttributes, "删除单表成功"); return "redirect:" +
	 * Global.getAdminPath() + "/rest/sicmedTwxrayCheck/?repage"; }
	 */
}