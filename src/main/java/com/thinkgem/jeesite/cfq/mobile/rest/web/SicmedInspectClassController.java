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
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedInspectClassBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedInspectClassBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspectClass;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedInspectClassService;

/**
 * @author Max
 */

@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedInspectClass")
public class SicmedInspectClassController extends BaseController {

    @Autowired
    private SicmedInspectClassService sicmedInspectClassService;

    /**
     * 获取所有 检验类别
     *
     * @param null
     * @return BaseBean
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "findAll")
    public BaseBean findAll() {
        // 创建返回对象
        SicmedInspectClassBeans sicmedInspectClassBeans = new SicmedInspectClassBeans();
        SicmedInspectClass sicmedInspectClass = new SicmedInspectClass();
        List<SicmedInspectClass> sicmedInspectClasses = sicmedInspectClassService.findList(sicmedInspectClass);

        if (sicmedInspectClasses.size() > 0) {
            for (SicmedInspectClass sicmedInspectClass2 : sicmedInspectClasses) {
                SicmedInspectClassBean sicmedInspectClassBean = new SicmedInspectClassBean();
                sicmedInspectClassBean.setSICB(sicmedInspectClass2);
                sicmedInspectClassBeans.getSicmedInspectClassBeans().add(sicmedInspectClassBean);
            }
            sicmedInspectClassBeans.setError("0");
            sicmedInspectClassBeans.setErrorMessage("查询成功");
        } else {
            sicmedInspectClassBeans.setError("1");
            sicmedInspectClassBeans.setErrorMessage("查询结果为空");
        }
        return sicmedInspectClassBeans;
    }

    @ModelAttribute
    public SicmedInspectClass get(@RequestParam(required = false) String id) {
        SicmedInspectClass entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = sicmedInspectClassService.get(id);
        }
        if (entity == null) {
            entity = new SicmedInspectClass();
        }
        return entity;
    }

    @RequiresPermissions("rest:sicmedInspectClass:view")
    @RequestMapping(value = {"list", ""})
    public String list(SicmedInspectClass sicmedInspectClass, HttpServletRequest request, HttpServletResponse response,
                       Model model) {
        Page<SicmedInspectClass> page = sicmedInspectClassService
                .findPage(new Page<SicmedInspectClass>(request, response), sicmedInspectClass);
        model.addAttribute("page", page);
        return "mobile/rest/sicmedInspectClassList";
    }

    @RequiresPermissions("rest:sicmedInspectClass:view")
    @RequestMapping(value = "form")
    public String form(SicmedInspectClass sicmedInspectClass, Model model) {
        model.addAttribute("sicmedInspectClass", sicmedInspectClass);
        return "mobile/rest/sicmedInspectClassForm";
    }

    @RequiresPermissions("rest:sicmedInspectClass:edit")
    @RequestMapping(value = "save")
    public String save(SicmedInspectClass sicmedInspectClass, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, sicmedInspectClass)) {
            return form(sicmedInspectClass, model);
        }
        sicmedInspectClassService.save(sicmedInspectClass);
        addMessage(redirectAttributes, "保存单表成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedInspectClass/?repage";
    }

    @RequiresPermissions("rest:sicmedInspectClass:edit")
    @RequestMapping(value = "delete")
    public String delete(SicmedInspectClass sicmedInspectClass, RedirectAttributes redirectAttributes) {
        sicmedInspectClassService.delete(sicmedInspectClass);
        addMessage(redirectAttributes, "删除单表成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedInspectClass/?repage";
    }

}