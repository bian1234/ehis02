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

import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionOffice;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionUser;
import com.thinkgem.jeesite.cfq.sys.service.PrescriptionOfficeService;
import com.thinkgem.jeesite.cfq.sys.utils.PrescriptionDictUtils;
import com.thinkgem.jeesite.cfq.sys.utils.PrescriptionUserUtils;

/**
 * 机构Controller
 *
 * @author ThinkGem
 * @version 2013-5-15
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/prescriptionOffice")
public class PrescriptionOfficeController extends BaseController {

    @Autowired
    private PrescriptionOfficeService prescriptionOfficeService;

    @ModelAttribute("prescriptionOffice")
    public PrescriptionOffice get(@RequestParam(required = false) String id) {
        if (StringUtils.isNotBlank(id)) {
            return prescriptionOfficeService.get(id);
        } else {
            return new PrescriptionOffice();
        }
    }

    @RequiresPermissions("sys:prescriptionOffice:view")
    @RequestMapping(value = {""})
    public String index(PrescriptionOffice prescriptionOffice, Model model) {
//        model.addAttribute("list", officeService.findAll());
        return "cfq/sys/officeIndex";
    }

    @RequiresPermissions("sys:prescriptionOffice:view")
    @RequestMapping(value = {"list"})
    public String list(PrescriptionOffice prescriptionOffice, Model model) {
        model.addAttribute("list", prescriptionOfficeService.findList(prescriptionOffice));
        return "cfq/sys/officeList";
    }

    @RequiresPermissions("sys:prescriptionOffice:view")
    @RequestMapping(value = "form")
    public String form(PrescriptionOffice prescriptionOffice, Model model) {
        PrescriptionUser prescriptionUser = PrescriptionUserUtils.getPrescriptionUser();
        if (prescriptionOffice.getParent() == null || prescriptionOffice.getParent().getId() == null) {
            prescriptionOffice.setParent(prescriptionUser.getOffice());
        }
        prescriptionOffice.setParent(prescriptionOfficeService.get(prescriptionOffice.getParent().getId()));
        if (prescriptionOffice.getArea() == null) {
            //prescriptionOffice.setArea(prescriptionUser.getOffice().getArea());
        }
        // 自动获取排序号
        if (StringUtils.isBlank(prescriptionOffice.getId()) && prescriptionOffice.getParent() != null) {
            int size = 0;
            List<PrescriptionOffice> list = prescriptionOfficeService.findAll();
            for (int i = 0; i < list.size(); i++) {
                PrescriptionOffice e = list.get(i);
                if (e.getParent() != null && e.getParent().getId() != null
                        && e.getParent().getId().equals(prescriptionOffice.getParent().getId())) {
                    size++;
                }
            }
            prescriptionOffice.setCode(prescriptionOffice.getParent().getCode() + StringUtils.leftPad(String.valueOf(size > 0 ? size + 1 : 1), 3, "0"));
        }
        model.addAttribute("prescriptionOffice", prescriptionOffice);
        return "cfq/sys/officeForm";
    }

    @RequiresPermissions("sys:prescriptionOffice:edit")
    @RequestMapping(value = "save")
    public String save(PrescriptionOffice prescriptionOffice, Model model, RedirectAttributes redirectAttributes) {
        if (Global.isDemoMode()) {
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sys/prescriptionOffice/";
        }
        if (!beanValidator(model, prescriptionOffice)) {
            return form(prescriptionOffice, model);
        }
        prescriptionOfficeService.save(prescriptionOffice);

        if (prescriptionOffice.getChildDeptList() != null) {
            PrescriptionOffice childOffice = null;
            for (String id : prescriptionOffice.getChildDeptList()) {
                childOffice = new PrescriptionOffice();
                childOffice.setName(PrescriptionDictUtils.getDictLabel(id, "sys_office_common", "未知"));
                childOffice.setParent(prescriptionOffice);
                childOffice.setArea(prescriptionOffice.getArea());
                childOffice.setType("2");
                childOffice.setGrade(String.valueOf(Integer.valueOf(prescriptionOffice.getGrade()) + 1));
                childOffice.setUseable(Global.YES);
                prescriptionOfficeService.save(childOffice);
            }
        }

        addMessage(redirectAttributes, "保存机构'" + prescriptionOffice.getName() + "'成功");
        String id = "0".equals(prescriptionOffice.getParentId()) ? "" : prescriptionOffice.getParentId();
        return "redirect:" + Global.getAdminPath() + "/sys/prescriptionOffice/list?id=" + id + "&parentIds=" + prescriptionOffice.getParentIds();
    }

    @RequiresPermissions("sys:prescriptionOffice:edit")
    @RequestMapping(value = "delete")
    public String delete(PrescriptionOffice prescriptionOffice, RedirectAttributes redirectAttributes) {
        if (Global.isDemoMode()) {
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sys/prescriptionOffice/list";
        }
//		if (Office.isRoot(id)){
//			addMessage(redirectAttributes, "删除机构失败, 不允许删除顶级机构或编号空");
//		}else{
        prescriptionOfficeService.delete(prescriptionOffice);
        addMessage(redirectAttributes, "删除机构成功");
//		}
        return "redirect:" + adminPath + "/sys/prescriptionOffice/list?id=" + prescriptionOffice.getParentId() + "&parentIds=" + prescriptionOffice.getParentIds();
    }

    /**
     * 获取机构JSON数据。
     *
     * @param extId    排除的ID
     * @param type     类型（1：公司；2：部门/小组/其它：3：用户）
     * @param grade    显示级别
     * @param response
     * @return
     */
    @RequiresPermissions("user")
    @ResponseBody
    @RequestMapping(value = "treeData")
    public List<Map<String, Object>> treeData(@RequestParam(required = false) String extId, @RequestParam(required = false) String type,
                                              @RequestParam(required = false) Long grade, @RequestParam(required = false) Boolean isAll, HttpServletResponse response) {
        List<Map<String, Object>> mapList = Lists.newArrayList();
        List<PrescriptionOffice> list = prescriptionOfficeService.findList(isAll);
        for (int i = 0; i < list.size(); i++) {
            PrescriptionOffice e = list.get(i);
            if ((StringUtils.isBlank(extId) || (extId != null && !extId.equals(e.getId()) && e.getParentIds().indexOf("," + extId + ",") == -1))
                    && (type == null || (type != null && (type.equals("1") ? type.equals(e.getType()) : true)))
                    && (grade == null || (grade != null && Integer.parseInt(e.getGrade()) <= grade.intValue()))
                    && Global.YES.equals(e.getUseable())) {
                Map<String, Object> map = Maps.newHashMap();
                map.put("id", e.getId());
                map.put("pId", e.getParentId());
                map.put("pIds", e.getParentIds());
                map.put("name", e.getName());
                if (type != null && "3".equals(type)) {
                    map.put("isParent", true);
                }
                mapList.add(map);
            }
        }
        return mapList;
    }
}
