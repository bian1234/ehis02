package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.config.Global;
import com.thinkgem.jeesite.cfq.common.utils.StringUtils;
import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedRegisteredTypeBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedRegisteredTypeBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedBranch;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegisteredType;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedBranchService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedRegisteredPriceService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedRegisteredTypeService;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;

/**
 * 挂号类别Controller
 *
 * @author XUE
 * @version 2016-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedRegisteredType")
public class SicmedRegisteredTypeController extends BaseController {

    @Autowired
    private SicmedRegisteredTypeService sicmedRegisteredTypeService;

    @Autowired
    private SicmedRegisteredPriceService sicmedRegisteredPriceService;
    @Autowired
    private SicmedBranchService sicmedBranchService;

    /**
     * 根据科室等级查询 挂号类别
     *
     * @param branchId
     * @return sicmedRegisteredTypeBeans
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "findByBranch")
    public BaseBean findByBranch(String branchId) {
        // 创建返回对象
        SicmedRegisteredTypeBeans sicmedRegisteredTypeBeans = new SicmedRegisteredTypeBeans();
        // 参数校验
        if (AppParameterSimulation.isEmpty(branchId)) {
            sicmedRegisteredTypeBeans.setError("1");
            sicmedRegisteredTypeBeans.setErrorMessage("参数为空");
            return sicmedRegisteredTypeBeans;
        } else if (!AppParameterSimulation.simulationId(branchId)) {
            sicmedRegisteredTypeBeans.setError("1");
            sicmedRegisteredTypeBeans.setErrorMessage("科室ID不正确");
            return sicmedRegisteredTypeBeans;
        }
        // 创建查询对象
        SicmedRegisteredType sicmedRegisteredType = new SicmedRegisteredType();
        // 获取查询对象属性
        SicmedBranch sicmedBranch = sicmedBranchService.get(branchId);
        // 查询对象赋值
        sicmedRegisteredType.setCodeGrades(sicmedBranch.getBranchNumber());
        // 调用service方法查询挂号类型
        List<SicmedRegisteredType> sicmedRegisteredTypes = sicmedRegisteredTypeService.findList(sicmedRegisteredType);
        // 查询结果校验 处理
        if (sicmedRegisteredTypes.size() > 0) {
            for (SicmedRegisteredType sicmedRegisteredType2 : sicmedRegisteredTypes) {
                SicmedRegisteredTypeBean sicmedRegisteredTypeBean = new SicmedRegisteredTypeBean();
                sicmedRegisteredType2.setSicmedRegisteredPrice(
                        sicmedRegisteredPriceService.get(sicmedRegisteredType2.getSicmedRegisteredPrice().getId()));

                sicmedRegisteredTypeBean.setSRTB(sicmedRegisteredType2);
                sicmedRegisteredTypeBeans.getSicmedRegisteredTypeBeans().add(sicmedRegisteredTypeBean);
            }
            sicmedRegisteredTypeBeans.setError("0");
            sicmedRegisteredTypeBeans.setErrorMessage("查询成功");
        } else {
            sicmedRegisteredTypeBeans.setError("1");
            sicmedRegisteredTypeBeans.setErrorMessage("查询失败查询结果为空");
        }
        // 返回处理信息
        return sicmedRegisteredTypeBeans;
    }

    /**
     * 根据科室等级查询 挂号类别
     *
     * @param branchId
     * @return sicmedRegisteredTypeBeans
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "getById")
    public BaseBean getById(String id) {
        // 创建返回对象
        SicmedRegisteredTypeBean sicmedRegisteredTypeBean = new SicmedRegisteredTypeBean();
        // 参数校验
        if (AppParameterSimulation.isEmpty(id)) {
            sicmedRegisteredTypeBean.setError("1");
            sicmedRegisteredTypeBean.setErrorMessage("参数为空");
            return sicmedRegisteredTypeBean;
        } else if (!AppParameterSimulation.simulationId(id)) {
            sicmedRegisteredTypeBean.setError("1");
            sicmedRegisteredTypeBean.setErrorMessage("科室ID不正确");
            return sicmedRegisteredTypeBean;
        }
        // 调用service方法查询挂号类型
        SicmedRegisteredType sicmedRegisteredType = sicmedRegisteredTypeService.get(id);
        // 查询结果校验 处理
        if (sicmedRegisteredType != null) {
            sicmedRegisteredTypeBean.setSRTB(sicmedRegisteredType);
            sicmedRegisteredTypeBean.setError("0");
            sicmedRegisteredTypeBean.setErrorMessage("查询成功");
        } else {
            sicmedRegisteredTypeBean.setError("1");
            sicmedRegisteredTypeBean.setErrorMessage("查询失败查询结果为空");
        }
        // 返回处理信息
        return sicmedRegisteredTypeBean;
    }

    @ModelAttribute
    public SicmedRegisteredType get(@RequestParam(required = false) String id) {
        SicmedRegisteredType entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = sicmedRegisteredTypeService.get(id);
        }
        if (entity == null) {
            entity = new SicmedRegisteredType();
        }
        return entity;
    }

    @RequiresPermissions("rest:sicmedRegisteredType:view")
    @RequestMapping(value = {"list", ""})
    public String list(SicmedRegisteredType sicmedRegisteredType, HttpServletRequest request,
                       HttpServletResponse response, Model model) {
        Page<SicmedRegisteredType> page = sicmedRegisteredTypeService
                .findPage(new Page<SicmedRegisteredType>(request, response), sicmedRegisteredType);
        model.addAttribute("page", page);
        return "mobile/rest/sicmedRegisteredTypeList";
    }

    @RequiresPermissions("rest:sicmedRegisteredType:view")
    @RequestMapping(value = "form")
    public String form(SicmedRegisteredType sicmedRegisteredType, Model model) {
        model.addAttribute("sicmedRegisteredType", sicmedRegisteredType);
        return "mobile/rest/sicmedRegisteredTypeForm";
    }

    @RequiresPermissions("rest:sicmedRegisteredType:edit")
    @RequestMapping(value = "save")
    public String save(SicmedRegisteredType sicmedRegisteredType, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, sicmedRegisteredType)) {
            return form(sicmedRegisteredType, model);
        }
        sicmedRegisteredTypeService.save(sicmedRegisteredType);
        addMessage(redirectAttributes, "保存挂号类别成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedRegisteredType/?repage";
    }

    @RequiresPermissions("rest:sicmedRegisteredType:edit")
    @RequestMapping(value = "delete")
    public String delete(SicmedRegisteredType sicmedRegisteredType, RedirectAttributes redirectAttributes) {
        sicmedRegisteredTypeService.delete(sicmedRegisteredType);
        addMessage(redirectAttributes, "删除挂号类别成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedRegisteredType/?repage";
    }

}