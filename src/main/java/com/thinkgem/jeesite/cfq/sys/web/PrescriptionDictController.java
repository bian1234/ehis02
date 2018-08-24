/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.sys.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.cfq.common.config.Global;
import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.utils.StringUtils;
import com.thinkgem.jeesite.cfq.common.web.BaseController;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionDict;
import com.thinkgem.jeesite.cfq.sys.service.PrescriptionDictService;

/**
 * 字典Controller
 *
 * @author ThinkGem
 * @version 2014-05-16
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/prescriptionDict")
public class PrescriptionDictController extends BaseController {

    @Autowired
    private PrescriptionDictService prescriptionDictService;

    @ModelAttribute
    public PrescriptionDict get(@RequestParam(required = false) String id) {
        if (StringUtils.isNotBlank(id)) {
            return prescriptionDictService.get(id);
        } else {
            return new PrescriptionDict();
        }
    }

    @RequiresPermissions("sys:prescriptionDict:view")
    @RequestMapping(value = {"list", ""})
    public String list(PrescriptionDict prescriptionDict, HttpServletRequest request, HttpServletResponse response, Model model) {
        List<String> typeList = prescriptionDictService.findTypeList();
        model.addAttribute("typeList", typeList);
        Page<PrescriptionDict> page = prescriptionDictService.findPage(new Page<PrescriptionDict>(request, response), prescriptionDict);
        model.addAttribute("page", page);
        return "cfq/sys/dictList";
    }

    @RequiresPermissions("sys:prescriptionDict:view")
    @RequestMapping(value = "form")
    public String form(PrescriptionDict prescriptionDict, Model model) {
        model.addAttribute("prescriptionDict", prescriptionDict);
        return "cfq/sys/dictForm";
    }

    @RequiresPermissions("sys:prescriptionDict:edit")
    @RequestMapping(value = "save")//@Valid
    public String save(PrescriptionDict prescriptionDict, Model model, RedirectAttributes redirectAttributes) {
        if (Global.isDemoMode()) {
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sys/dict/?repage&type=" + prescriptionDict.getType();
        }
        if (!beanValidator(model, prescriptionDict)) {
            return form(prescriptionDict, model);
        }
        prescriptionDictService.save(prescriptionDict);
        addMessage(redirectAttributes, "保存字典'" + prescriptionDict.getLabel() + "'成功");
        return "redirect:" + adminPath + "/sys/prescriptionDict/?repage&type=" + prescriptionDict.getType();
    }

    @RequiresPermissions("sys:prescriptionDict :edit")
    @RequestMapping(value = "delete")
    public String delete(PrescriptionDict prescriptionDict, RedirectAttributes redirectAttributes) {
        if (Global.isDemoMode()) {
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sys/prescriptionDict/?repage";
        }
        prescriptionDictService.delete(prescriptionDict);
        addMessage(redirectAttributes, "删除字典成功");
        return "redirect:" + adminPath + "/sys/prescriptionDict/?repage&type=" + prescriptionDict.getType();
    }

    @RequiresPermissions("user")
    @ResponseBody
    @RequestMapping(value = "treeData")
    public List<Map<String, Object>> treeData(@RequestParam(required = false) String type, HttpServletResponse response) {
        List<Map<String, Object>> mapList = Lists.newArrayList();
        PrescriptionDict prescriptionDict = new PrescriptionDict();
        prescriptionDict.setType(type);
        List<PrescriptionDict> list = prescriptionDictService.findList(prescriptionDict);
        for (int i = 0; i < list.size(); i++) {
            PrescriptionDict e = list.get(i);
            Map<String, Object> map = Maps.newHashMap();
            map.put("id", e.getId());
            map.put("pId", e.getParentId());
            map.put("name", StringUtils.replace(e.getLabel(), " ", ""));
            mapList.add(map);
        }
        return mapList;
    }

    @ResponseBody
    @RequestMapping(value = "listData")
    public List<PrescriptionDict> listData(@RequestParam(required = false) String type) {
        PrescriptionDict prescriptionDict = new PrescriptionDict();
        prescriptionDict.setType(type);
        return prescriptionDictService.findList(prescriptionDict);
    }

}
