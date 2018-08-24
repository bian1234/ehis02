package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedInspectBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedInspectBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspect;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspectClass;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedInspectClassService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedInspectService;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.PageUtils;

/**
 * @author Max
 */

@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedInspect")
public class SicmedInspectController extends BaseController {

    @Autowired
    private SicmedInspectService sicmedInspectService;

    @Autowired
    private SicmedInspectClassService sicmedInspectClassService;

    /**
     * 检验项目查询
     *
     * @param parameter(编码;名称;拼音缩写)
     * @return BaseBean
     * @author Max
     */

    @ResponseBody
    @RequestMapping(value = "searchInspect")
    public BaseBean searchInspect(String parameter, String pageNo, String classId) {
        SicmedInspectBeans sicmedInspectBeans = new SicmedInspectBeans();
        // 传入参数判断
        // 创建查询条件
        SicmedInspect sicmedInspect = new SicmedInspect();
        // 分页查询
        Page<SicmedInspect> page = new Page<SicmedInspect>();
        page.setPageSize(PageUtils.PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        sicmedInspect.setPage(page);
        if (parameter != null) {
            if (AppParameterSimulation.isChineseName(parameter)) {
                sicmedInspect.setInspectName(parameter);
            } else if (AppParameterSimulation.simulationIsNumber(parameter)) {
                sicmedInspect.setInspectCode(parameter);
            } else if (AppParameterSimulation.simulationIsPinYin(parameter)) {
                sicmedInspect.setInspectNamePY(parameter);
            }
        }
        if (AppParameterSimulation.isNotEmpty(classId)) {
            sicmedInspect.setSicmedInspectClass(sicmedInspectClassService.get(classId));
        }
        // 根据查询条件查询
        List<SicmedInspect> sicmedInspects = sicmedInspectService.findListLike(sicmedInspect);
        // 判断查询结果
        if (sicmedInspects.size() == 0) {
            sicmedInspectBeans.setError("1");
            sicmedInspectBeans.setErrorMessage("查询结果为空");
            return sicmedInspectBeans;
        } else {
            // 遍历查询结果
            for (SicmedInspect sicmedInspect2 : sicmedInspects) {
                SicmedInspectBean sicmedInspectBean = new SicmedInspectBean();
                sicmedInspectBean.setSIB(sicmedInspect2);
                sicmedInspectBeans.getSicmedInspectBeans().add(sicmedInspectBean);
            }
            sicmedInspectBeans.setError("0");
            sicmedInspectBeans.setSuccessMessage("查询成功");
        }
        return sicmedInspectBeans;
    }

    /**
     * 根据检验类别获取检验项目
     *
     * @param parameter
     * @param classId
     * @return BaseBean
     */
    @ResponseBody
    @RequestMapping(value = "findInspect")
    public BaseBean findInspect(String parameter, String classId, String pageNo) {
        // 创建返回条件
        SicmedInspectBeans sicmedInspectBeans = new SicmedInspectBeans();
        // 传入参数判断
        if (AppParameterSimulation.isEmpty(classId)) {
            sicmedInspectBeans.setError("1");
            sicmedInspectBeans.setErrorMessage("参数为空");
            return sicmedInspectBeans;
        } else if (AppParameterSimulation.simulationId(classId)) {
            sicmedInspectBeans.setError("1");
            sicmedInspectBeans.setErrorMessage("检验类别ID不正确");
            return sicmedInspectBeans;
        }
        // 获取检验类别
        SicmedInspectClass sicmedInspectClass = sicmedInspectClassService.get(classId);
        // 创建查询条件
        SicmedInspect sicmedInspect = new SicmedInspect();
        // 创建分页条件
        Page<SicmedInspect> page = new Page<SicmedInspect>();
        page.setPageSize(PageUtils.PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 查询条件赋值
        sicmedInspect.setPage(page);
        sicmedInspect.setInspectCode(parameter);
        sicmedInspect.setSicmedInspectClass(sicmedInspectClass);

        // 调用service方法查询检验项目
        List<SicmedInspect> sicmedInspects = sicmedInspectService.findListLike(sicmedInspect);
        // 判断查询结果
        if (sicmedInspects.size() == 0) {
            sicmedInspectBeans.setError("1");
            sicmedInspectBeans.setErrorMessage("查询结果为空");
            return sicmedInspectBeans;
        } else {
            // 遍历查询结果
            for (SicmedInspect sicmedInspect2 : sicmedInspects) {
                SicmedInspectBean sicmedInspectBean = new SicmedInspectBean();
                sicmedInspectBean.setSIB(sicmedInspect2);
                sicmedInspectBeans.getSicmedInspectBeans().add(sicmedInspectBean);
            }
        }
        return sicmedInspectBeans;
    }
    /*
	 * @ModelAttribute public SicmedInspect get(@RequestParam(required=false)
	 * String id) { SicmedInspect entity = null; if
	 * (StringUtils.isNotBlank(id)){ entity = sicmedInspectService.get(id); } if
	 * (entity == null){ entity = new SicmedInspect(); } return entity; }
	 * 
	 * @RequiresPermissions("rest:sicmedInspect:view")
	 * 
	 * @RequestMapping(value = {"list", ""}) public String list(SicmedInspect
	 * sicmedInspect, HttpServletRequest request, HttpServletResponse response,
	 * Model model) { Page<SicmedInspect> page =
	 * sicmedInspectService.findPage(new Page<SicmedInspect>(request, response),
	 * sicmedInspect); model.addAttribute("page", page); return
	 * "mobile/rest/sicmedInspectList"; }
	 * 
	 * @RequiresPermissions("rest:sicmedInspect:view")
	 * 
	 * @RequestMapping(value = "form") public String form(SicmedInspect
	 * sicmedInspect, Model model) { model.addAttribute("sicmedInspect",
	 * sicmedInspect); return "mobile/rest/sicmedInspectForm"; }
	 * 
	 * @RequiresPermissions("rest:sicmedInspect:edit")
	 * 
	 * @RequestMapping(value = "save") public String save(SicmedInspect
	 * sicmedInspect, Model model, RedirectAttributes redirectAttributes) { if
	 * (!beanValidator(model, sicmedInspect)){ return form(sicmedInspect,
	 * model); } sicmedInspectService.save(sicmedInspect);
	 * addMessage(redirectAttributes, "保存单表成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedInspect/?repage"; }
	 * 
	 * @RequiresPermissions("rest:sicmedInspect:edit")
	 * 
	 * @RequestMapping(value = "delete") public String delete(SicmedInspect
	 * sicmedInspect, RedirectAttributes redirectAttributes) {
	 * sicmedInspectService.delete(sicmedInspect);
	 * addMessage(redirectAttributes, "删除单表成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedInspect/?repage"; }
	 */
}