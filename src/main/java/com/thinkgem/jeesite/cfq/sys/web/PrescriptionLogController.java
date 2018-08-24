/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.sys.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.web.BaseController;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionLog;
import com.thinkgem.jeesite.cfq.sys.service.PrescriptionLogService;

/**
 * 日志Controller
 *
 * @author ThinkGem
 * @version 2013-6-2
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/prescriptionLog")
public class PrescriptionLogController extends BaseController {

    @Autowired
    private PrescriptionLogService prescriptionLogService;

    @RequiresPermissions("sys:prescriptionLog:view")
    @RequestMapping(value = {"list", ""})
    public String list(PrescriptionLog prescriptionLog, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<PrescriptionLog> page = prescriptionLogService.findPage(new Page<PrescriptionLog>(request, response), prescriptionLog);
        model.addAttribute("page", page);
        return "cfq/sys/logList";
    }

}
