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
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedDiseaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedDiseaseBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDisease;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDiseaseClass;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedDiseaseClassService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedDiseaseService;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.PageUtils;

/**
 * 疾病表Controller
 *
 * @author Max
 * @version 2016-07-18
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedDisease")
public class SicmedDiseaseController extends BaseController {

    @Autowired
    private SicmedDiseaseService sicmedDiseaseService;

    @Autowired
    private SicmedDiseaseClassService sicmedDiseaseClassService;

    /**
     * 根据ID查询疾病信息
     *
     * @param diseaseId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getById")
    public BaseBean getById(@RequestParam String diseaseId) {

        if (!AppParameterSimulation.simulationId(diseaseId)) {
            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;
        }
        SicmedDiseaseBean sicmedDiseaseBean = new SicmedDiseaseBean();

        try {
            SicmedDisease sicmedDisease = sicmedDiseaseService.get(diseaseId);
            sicmedDiseaseBean.setSD(sicmedDisease);
            sicmedDiseaseBean.setError("0");
            sicmedDiseaseBean.setErrorMessage("查询疾病成功");
        } catch (Exception e) {
            e.printStackTrace();
            sicmedDiseaseBean.setError("1");
            sicmedDiseaseBean.setErrorMessage("查询疾病失败");
        }
        return sicmedDiseaseBean;
    }

    /**
     * 根据疾病类别查询疾病集合
     *
     * @param diseaseClassId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getByClass")
    public BaseBean getByDiseaseClass(@RequestParam String diseaseClassId) {

        if (!AppParameterSimulation.simulationId(diseaseClassId)) {
            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;
        }

        SicmedDiseaseBeans sicmedDiseaseBeans = new SicmedDiseaseBeans();
        SicmedDisease sicmedDisease = new SicmedDisease();

        try {
            SicmedDiseaseClass sicmedDiseaseClass = sicmedDiseaseClassService.get(diseaseClassId);
            sicmedDisease.setDiseaseClass(sicmedDiseaseClass);

            List<SicmedDisease> sicmedDiseases = sicmedDiseaseService.findList(sicmedDisease);
            if (sicmedDiseases.size() != 0) {
                for (SicmedDisease sicmedDisease2 : sicmedDiseases) {
                    SicmedDiseaseBean sicmedDiseaseBean = new SicmedDiseaseBean();
                    sicmedDiseaseBean.setSD(sicmedDisease2);
                    sicmedDiseaseBeans.getSicmedDiseaseBeans().add(sicmedDiseaseBean);
                }
                sicmedDiseaseBeans.setError("0");
                sicmedDiseaseBeans.setErrorMessage("查询疾病成功");
            } else {

                sicmedDiseaseBeans.setError("1");
                sicmedDiseaseBeans.setErrorMessage("查询的信息不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            sicmedDiseaseBeans.setError("1");
            sicmedDiseaseBeans.setErrorMessage("查询疾病失败");
        }
        return sicmedDiseaseBeans;
    }

    /**
     * 模糊搜索疾病信息 接口
     *
     * @param disease
     * @return BaseBean
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "searchDisease")
    public BaseBean searchDisease(String disease, String pageNo, String classId) {
        // 创建返回对象
        SicmedDiseaseBeans sicmedDiseaseBeans = new SicmedDiseaseBeans();
        // 创建查询条件
        SicmedDisease sicmedDisease = new SicmedDisease();
        // 创建分页条件
        Page<SicmedDisease> page = new Page<SicmedDisease>();
        page.setPageSize(PageUtils.PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 查询条件赋值
        sicmedDisease.setPage(page);
        if (AppParameterSimulation.simulationIsChinese(disease)) {
            sicmedDisease.setDiseaseName(disease);
        } else if (AppParameterSimulation.simulationIsPinYin(disease)) {
            sicmedDisease.setDiseaseNamePmpa(disease);
        } else if (AppParameterSimulation.isNumber(disease)) {
            sicmedDisease.setDiseaseCode(disease);
        }
        if (AppParameterSimulation.isNotEmpty(classId)) {
            sicmedDisease.setDiseaseClass(sicmedDiseaseClassService.get(classId));
        }
        // 调用service查询疾病信息
        List<SicmedDisease> sicmedDiseases = sicmedDiseaseService.findListLike(sicmedDisease);
        // 查询结果处理
        if (sicmedDiseases.size() > 0) {
            for (SicmedDisease sicmedDisease2 : sicmedDiseases) {
                SicmedDiseaseBean sicmedDiseaseBean = new SicmedDiseaseBean();
                sicmedDiseaseBean.setSD(sicmedDisease2);
                sicmedDiseaseBeans.getSicmedDiseaseBeans().add(sicmedDiseaseBean);
            }
            sicmedDiseaseBeans.setError("0");
            sicmedDiseaseBeans.setErrorMessage("查询成功");
        } else {
            sicmedDiseaseBeans.setError("1");
            sicmedDiseaseBeans.setErrorMessage("查询结果为空!");
            return sicmedDiseaseBeans;
        }
        // 返回处理结果
        return sicmedDiseaseBeans;
    }

    // @ResponseBody
    // @RequestMapping(value = "resave")
    // public void resave() {
    // logger.info("疾病信息重新保存开始");
    // SicmedDisease sicmedDisease = new SicmedDisease();
    // List<SicmedDisease> sicmedDiseases =
    // sicmedDiseaseService.findList(sicmedDisease);
    // logger.info("疾病数量======"+sicmedDiseases.size());
    // for (SicmedDisease sicmedDisease2 : sicmedDiseases) {
    // sicmedDiseaseService.save(sicmedDisease2);
    // }
    // logger.info("疾病信息重新保存结束");
    // }
    /*
	 * @ModelAttribute public SicmedDisease get(@RequestParam(required=false)
	 * String id) { SicmedDisease entity = null; if
	 * (StringUtils.isNotBlank(id)){ entity = sicmedDiseaseService.get(id); } if
	 * (entity == null){ entity = new SicmedDisease(); } return entity; }
	 * 
	 * @RequiresPermissions("rest:sicmedDisease:view")
	 * 
	 * @RequestMapping(value = {"list", ""}) public String list(SicmedDisease
	 * sicmedDisease, HttpServletRequest request, HttpServletResponse response,
	 * Model model) { Page<SicmedDisease> page =
	 * sicmedDiseaseService.findPage(new Page<SicmedDisease>(request, response),
	 * sicmedDisease); model.addAttribute("page", page); return
	 * "mobile/rest/sicmedDiseaseList"; }
	 * 
	 * @RequiresPermissions("rest:sicmedDisease:view")
	 * 
	 * @RequestMapping(value = "form") public String form(SicmedDisease
	 * sicmedDisease, Model model) { model.addAttribute("sicmedDisease",
	 * sicmedDisease); return "mobile/rest/sicmedDiseaseForm"; }
	 * 
	 * @RequiresPermissions("rest:sicmedDisease:edit")
	 * 
	 * @RequestMapping(value = "save") public String save(SicmedDisease
	 * sicmedDisease, Model model, RedirectAttributes redirectAttributes) { if
	 * (!beanValidator(model, sicmedDisease)){ return form(sicmedDisease,
	 * model); } sicmedDiseaseService.save(sicmedDisease);
	 * addMessage(redirectAttributes, "保存保存成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedDisease/?repage"; }
	 * 
	 * @RequiresPermissions("rest:sicmedDisease:edit")
	 * 
	 * @RequestMapping(value = "delete") public String delete(SicmedDisease
	 * sicmedDisease, RedirectAttributes redirectAttributes) {
	 * sicmedDiseaseService.delete(sicmedDisease);
	 * addMessage(redirectAttributes, "删除保存成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedDisease/?repage"; }
	 */
}