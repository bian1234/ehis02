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
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCureClassBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCureClassBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCureClass;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCureClassService;

/**
 * 治疗类别 接口示例Controller
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedCureClass")
public class SicmedCureClassController extends BaseController {

    @Autowired
    private SicmedCureClassService sicmedCureClassService;

    /**
     * @return sicmedCureClassBeans
     * @author Max
     */

    @ResponseBody
    @RequestMapping(value = "findAll")
    public BaseBean findAll() {
        // 创建返回对象
        SicmedCureClassBeans sicmedCureClassBeans = new SicmedCureClassBeans();
        // 创建查询条件
        SicmedCureClass sicmedCureClass = new SicmedCureClass();
        // 调用service方法查询
        List<SicmedCureClass> sicmedCureClasses = sicmedCureClassService.findList(sicmedCureClass);
        // 处理查询结果
        if (sicmedCureClasses.size() > 0) {
            for (SicmedCureClass sicmedCureClass2 : sicmedCureClasses) {
                SicmedCureClassBean sicmedCureClassBean = new SicmedCureClassBean();
                sicmedCureClassBean.setSCCB(sicmedCureClass2);
                sicmedCureClassBeans.getSicmedCureClassBeans().add(sicmedCureClassBean);
            }
            sicmedCureClassBeans.setError("0");
            sicmedCureClassBeans.setErrorMessage("查询成功");
        } else {
            sicmedCureClassBeans.setError("1");
            sicmedCureClassBeans.setErrorMessage("查询失败结果为空");
        }
        // 返回 查询结果
        return sicmedCureClassBeans;
    }

    @ModelAttribute
    public SicmedCureClass get(@RequestParam(required = false) String id) {
        SicmedCureClass entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = sicmedCureClassService.get(id);
        }
        if (entity == null) {
            entity = new SicmedCureClass();
        }
        return entity;
    }

    @RequiresPermissions("rest:sicmedCureClass:view")
    @RequestMapping(value = {"list", ""})
    public String list(SicmedCureClass sicmedCureClass, HttpServletRequest request, HttpServletResponse response,
                       Model model) {
        Page<SicmedCureClass> page = sicmedCureClassService.findPage(new Page<SicmedCureClass>(request, response),
                sicmedCureClass);
        model.addAttribute("page", page);
        return "mobile/rest/sicmedCureClassList";
    }

    @RequiresPermissions("rest:sicmedCureClass:view")
    @RequestMapping(value = "form")
    public String form(SicmedCureClass sicmedCureClass, Model model) {
        model.addAttribute("sicmedCureClass", sicmedCureClass);
        return "mobile/rest/sicmedCureClassForm";
    }

    @RequiresPermissions("rest:sicmedCureClass:edit")
    @RequestMapping(value = "save")
    public String save(SicmedCureClass sicmedCureClass, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, sicmedCureClass)) {
            return form(sicmedCureClass, model);
        }
        sicmedCureClassService.save(sicmedCureClass);
        addMessage(redirectAttributes, "保存单表成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedCureClass/?repage";
    }

    @RequiresPermissions("rest:sicmedCureClass:edit")
    @RequestMapping(value = "delete")
    public String delete(SicmedCureClass sicmedCureClass, RedirectAttributes redirectAttributes) {
        sicmedCureClassService.delete(sicmedCureClass);
        addMessage(redirectAttributes, "删除单表成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedCureClass/?repage";
    }

}