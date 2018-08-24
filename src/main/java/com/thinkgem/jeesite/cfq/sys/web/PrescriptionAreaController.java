/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.sys.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.cfq.common.config.Global;
import com.thinkgem.jeesite.cfq.common.utils.StringUtils;
import com.thinkgem.jeesite.cfq.common.web.BaseController;
import com.thinkgem.jeesite.cfq.sys.service.PrescriptionAreaService;
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
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionArea;
import com.thinkgem.jeesite.cfq.sys.utils.PrescriptionUserUtils;

/**
 * 区域Controller
 *
 * @author ThinkGem
 * @version 2013-5-15
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/prescriptionArea")
public class PrescriptionAreaController extends BaseController {

    @Autowired
    private PrescriptionAreaService prescriptionAreaService;

    @ModelAttribute("prescriptionArea")
    public PrescriptionArea get(@RequestParam(required = false) String id) {
        if (StringUtils.isNotBlank(id)) {
            return prescriptionAreaService.get(id);
        } else {
            return new PrescriptionArea();
        }
    }

    @RequiresPermissions("sys:prescriptionArea:view")
    @RequestMapping(value = {"list", ""})
    public String list(PrescriptionArea area, Model model) {
        model.addAttribute("list", prescriptionAreaService.findAll());
        return "cfq/sys/areaList";
    }

    @RequiresPermissions("sys:prescriptionArea:view")
    @RequestMapping(value = "form")
    public String form(PrescriptionArea prescriptionArea, Model model) {
        if (prescriptionArea.getParent() == null || prescriptionArea.getParent().getId() == null) {
            prescriptionArea.setParent(PrescriptionUserUtils.getPrescriptionUser().getOffice().getArea());
        }
        prescriptionArea.setParent(prescriptionAreaService.get(prescriptionArea.getParent().getId()));

//		// 自动获取排序号
//		if (StringUtils.isBlank(area.getId())){
//			int size = 0;
//			List<Area> list = areaService.findAll();
//			for (int i=0; i<list.size(); i++){
//				Area e = list.get(i);
//				if (e.getParent()!=null && e.getParent().getId()!=null
//						&& e.getParent().getId().equals(area.getParent().getId())){
//					size++;
//				}
//			}
//			area.setCode(area.getParent().getCode() + StringUtils.leftPad(String.valueOf(size > 0 ? size : 1), 4, "0"));
//		}
        model.addAttribute("prescriptionArea", prescriptionArea);
        return "cfq/sys/areaForm";
    }

    @RequiresPermissions("sys:prescriptionArea:edit")
    @RequestMapping(value = "save")
    public String save(PrescriptionArea prescriptionArea, Model model, RedirectAttributes redirectAttributes) {
        if (Global.isDemoMode()) {
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sys/prescriptionArea";
        }
        if (!beanValidator(model, prescriptionArea)) {
            return form(prescriptionArea, model);
        }
        prescriptionAreaService.save(prescriptionArea);
        addMessage(redirectAttributes, "保存区域'" + prescriptionArea.getName() + "'成功");
        return "redirect:" + adminPath + "/sys/prescriptionArea/";
    }

    @RequiresPermissions("sys:prescriptionArea:edit")
    @RequestMapping(value = "delete")
    public String delete(PrescriptionArea prescriptionArea, RedirectAttributes redirectAttributes) {
        if (Global.isDemoMode()) {
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sys/prescriptionArea";
        }
//		if (Area.isRoot(id)){
//			addMessage(redirectAttributes, "删除区域失败, 不允许删除顶级区域或编号为空");
//		}else{
        prescriptionAreaService.delete(prescriptionArea);
        addMessage(redirectAttributes, "删除区域成功");
//		}
        return "redirect:" + adminPath + "/sys/prescriptionArea/";
    }

    @RequiresPermissions("user")
    @ResponseBody
    @RequestMapping(value = "treeData")
    public List<Map<String, Object>> treeData(@RequestParam(required = false) String extId, HttpServletResponse response) {
        List<Map<String, Object>> mapList = Lists.newArrayList();
        List<PrescriptionArea> list = prescriptionAreaService.findAll();
        for (int i = 0; i < list.size(); i++) {
            PrescriptionArea e = list.get(i);
            if (StringUtils.isBlank(extId) || (extId != null && !extId.equals(e.getId()) && e.getParentIds().indexOf("," + extId + ",") == -1)) {
                Map<String, Object> map = Maps.newHashMap();
                map.put("id", e.getId());
                map.put("pId", e.getParentId());
                map.put("name", e.getName());
                mapList.add(map);
            }
        }
        return mapList;
    }
}
