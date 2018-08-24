package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedStanderprescriptionDiseaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedStanderprescriptionDiseaseBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStanderprescriptionAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStanderprescriptionDisease;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedDiseaseService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedStanderprescriptionAskedService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedStanderprescriptionDiseaseService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedUserService;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.SsidUtils;

/**
 * 标准处方中的疾病表Controller
 *
 * @author Max
 * @version 2016-07-18
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedStanderprescriptionDisease")
public class SicmedStanderprescriptionDiseaseController extends BaseController {

    @Autowired
    private SicmedStanderprescriptionDiseaseService sicmedStanderprescriptionDiseaseService;
    @Autowired
    private SicmedStanderprescriptionAskedService sicmedStanderprescriptionAskedService;
    @Autowired
    private SicmedDiseaseService sicmedDiseaseService;

    @Autowired
    private SicmedUserService sicmedUserService;

    @ResponseBody
    @RequestMapping(value = "saveOrUpdate")
    public BaseBean saveOrUpdate(SicmedStanderprescriptionDiseaseBean sicmedStanderprescriptionDiseaseBean,
                                 String diseaseId, String ssid) {
        if (AppParameterSimulation.isEmpty(sicmedStanderprescriptionDiseaseBean.getPrescriptionName())
                || AppParameterSimulation.isEmpty(diseaseId)) {
            sicmedStanderprescriptionDiseaseBean.setError("1");
            sicmedStanderprescriptionDiseaseBean.setErrorMessage("参数为空");
            return sicmedStanderprescriptionDiseaseBean;
        }
        if (AppParameterSimulation.isEmpty(sicmedStanderprescriptionDiseaseBean.getId())) {
            sicmedStanderprescriptionDiseaseBean = this.add(sicmedStanderprescriptionDiseaseBean, diseaseId, ssid);
            sicmedStanderprescriptionDiseaseBean.setSuccessMessage("添加成功");
        } else {
            sicmedStanderprescriptionDiseaseBean = this.update(sicmedStanderprescriptionDiseaseBean, diseaseId, ssid);
            sicmedStanderprescriptionDiseaseBean.setSuccessMessage("修改成功");
        }
        return sicmedStanderprescriptionDiseaseBean;

    }

    /**
     * 添加标准处方中的疾病
     *
     * @param sicmedStanderprescriptionDiseaseBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add")
    public SicmedStanderprescriptionDiseaseBean add(SicmedStanderprescriptionDiseaseBean sicmedStanderprescriptionDiseaseBean, String diseaseId,
                                                    String ssid) {
        SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease = new SicmedStanderprescriptionDisease();
        sicmedStanderprescriptionDisease
                .setPrescriptionName(sicmedStanderprescriptionDiseaseBean.getPrescriptionName());
        sicmedStanderprescriptionDisease.setSicmedDisease(sicmedDiseaseService.get(diseaseId));
        sicmedStanderprescriptionDisease.setCreateUser(sicmedUserService.get(SsidUtils.getSicmedUserId(ssid)));
        sicmedStanderprescriptionDiseaseService.save(sicmedStanderprescriptionDisease);
        sicmedStanderprescriptionDisease = sicmedStanderprescriptionDiseaseService.get(sicmedStanderprescriptionDisease);
        sicmedStanderprescriptionDiseaseBean.setssdb(sicmedStanderprescriptionDiseaseService.get(sicmedStanderprescriptionDisease));
        sicmedStanderprescriptionDiseaseBean.setError("0");
        return sicmedStanderprescriptionDiseaseBean;

    }

    /**
     * 根据创建人查询标准处方
     */
    @ResponseBody
    @RequestMapping(value = "get")
    public BaseBean get(String ssid) {

        SicmedStanderprescriptionDiseaseBeans sicmedStanderprescriptionDiseaseBeans = new SicmedStanderprescriptionDiseaseBeans();

        SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease = new SicmedStanderprescriptionDisease();

        sicmedStanderprescriptionDisease.setCreateUser(sicmedUserService.get(SsidUtils.getSicmedUserId(ssid)));

        List<SicmedStanderprescriptionDisease> a = sicmedStanderprescriptionDiseaseService
                .findList(sicmedStanderprescriptionDisease);

        if (a.size() > 0) {
            for (SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease2 : a) {
                SicmedStanderprescriptionDiseaseBean sicmedStanderprescriptionDiseaseBean = new SicmedStanderprescriptionDiseaseBean();
                sicmedStanderprescriptionDiseaseBean.setssdb(sicmedStanderprescriptionDisease2);
                sicmedStanderprescriptionDiseaseBeans.getSicmedStanderprescriptionDiseaseBeans()
                        .add(sicmedStanderprescriptionDiseaseBean);
            }
            sicmedStanderprescriptionDiseaseBeans.setError("0");
            sicmedStanderprescriptionDiseaseBeans.setErrorMessage("查询成功");
        } else {
            sicmedStanderprescriptionDiseaseBeans.setError("1");
            sicmedStanderprescriptionDiseaseBeans.setErrorMessage("查询结果为空");
        }
        return sicmedStanderprescriptionDiseaseBeans;
    }

    /**
     * 删除标准处方
     */
    @ResponseBody
    @RequestMapping(value = "delete")
    public BaseBean delete(String id) {

        BaseBean baseBean = new BaseBean();
        if (AppParameterSimulation.simulationId(id)) {
            SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease = sicmedStanderprescriptionDiseaseService
                    .get(id);
            if (sicmedStanderprescriptionDisease != null) {
                SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked = new SicmedStanderprescriptionAsked();
                sicmedStanderprescriptionAsked.setSicmedStanderprescription(sicmedStanderprescriptionDisease);
                List<SicmedStanderprescriptionAsked> a = sicmedStanderprescriptionAskedService
                        .findList(sicmedStanderprescriptionAsked);
                if (a.size() > 0) {
                    for (SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked2 : a) {
                        sicmedStanderprescriptionAskedService.delete(sicmedStanderprescriptionAsked2);
                    }
                }
                sicmedStanderprescriptionDiseaseService.delete(sicmedStanderprescriptionDisease);
                baseBean.setError("0");
                baseBean.setErrorMessage("删除成功");
            } else {
                baseBean.setError("1");
                baseBean.setErrorMessage("删除失败");
            }
        } else {
            baseBean.setError("1");
            baseBean.setErrorMessage("输入的id有误");
        }
        return baseBean;
    }

    /**
     * 修改标准处方
     *
     * @param sicmedStanderprescriptionDiseaseBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "update")
    public SicmedStanderprescriptionDiseaseBean update(SicmedStanderprescriptionDiseaseBean sicmedStanderprescriptionDiseaseBean, String diseaseId,
                                                       String ssid) {
        SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease = sicmedStanderprescriptionDiseaseService
                .get(sicmedStanderprescriptionDiseaseBean.getId());
        sicmedStanderprescriptionDisease
                .setPrescriptionName(sicmedStanderprescriptionDiseaseBean.getPrescriptionName());
        sicmedStanderprescriptionDisease.setSicmedDisease(sicmedDiseaseService.get(diseaseId));
        sicmedStanderprescriptionDisease.setUpdateUser(sicmedUserService.get(SsidUtils.getSicmedUserId(ssid)));
        sicmedStanderprescriptionDiseaseService.update(sicmedStanderprescriptionDisease);

        sicmedStanderprescriptionDiseaseBean
                .setssdb(sicmedStanderprescriptionDiseaseService.get(sicmedStanderprescriptionDisease));
        sicmedStanderprescriptionDiseaseBean.setError("0");
        return sicmedStanderprescriptionDiseaseBean;

    }

    /**
     * 根据标准处方名查询标准处方
     */
    @ResponseBody
    @RequestMapping(value = "findByName")
    public BaseBean findByName(@RequestParam(required = false) String name) {
        // 创建返回对象
        SicmedStanderprescriptionDiseaseBeans sicmedStanderprescriptionDiseaseBeans = new SicmedStanderprescriptionDiseaseBeans();

        SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease = new SicmedStanderprescriptionDisease();
        sicmedStanderprescriptionDisease.setPrescriptionName(name);
        List<SicmedStanderprescriptionDisease> a = sicmedStanderprescriptionDiseaseService
                .findListLike(sicmedStanderprescriptionDisease);
        if (a.size() > 0) {
            for (SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease2 : a) {
                SicmedStanderprescriptionDiseaseBean sicmedStanderprescriptionAskedBean = new SicmedStanderprescriptionDiseaseBean();
                sicmedStanderprescriptionAskedBean.setssdb(sicmedStanderprescriptionDisease2);

                sicmedStanderprescriptionDiseaseBeans.getSicmedStanderprescriptionDiseaseBeans()
                        .add(sicmedStanderprescriptionAskedBean);
            }
            sicmedStanderprescriptionDiseaseBeans.setError("0");
        } else {
            sicmedStanderprescriptionDiseaseBeans.setError("1");
        }
        return sicmedStanderprescriptionDiseaseBeans;
    }

	/*
     * @ModelAttribute public SicmedStanderprescriptionDisease
	 * get(@RequestParam(required = false) String id) {
	 * SicmedStanderprescriptionDisease entity = null; if
	 * (StringUtils.isNotBlank(id)) { entity =
	 * sicmedStanderprescriptionDiseaseService.get(id); } if (entity == null) {
	 * entity = new SicmedStanderprescriptionDisease(); } return entity; }
	 * 
	 * @RequiresPermissions("rest:sicmedStanderprescriptionDisease:view")
	 * 
	 * @RequestMapping(value = { "list", "" }) public String
	 * list(SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease,
	 * HttpServletRequest request, HttpServletResponse response, Model model) {
	 * Page<SicmedStanderprescriptionDisease> page =
	 * sicmedStanderprescriptionDiseaseService.findPage( new
	 * Page<SicmedStanderprescriptionDisease>(request, response),
	 * sicmedStanderprescriptionDisease); model.addAttribute("page", page);
	 * return "mobile/rest/sicmedStanderprescriptionDiseaseList"; }
	 * 
	 * @RequiresPermissions("rest:sicmedStanderprescriptionDisease:view")
	 * 
	 * @RequestMapping(value = "form") public String
	 * form(SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease,
	 * Model model) { model.addAttribute("sicmedStanderprescriptionDisease",
	 * sicmedStanderprescriptionDisease); return
	 * "mobile/rest/sicmedStanderprescriptionDiseaseForm"; }
	 * 
	 * @RequiresPermissions("rest:sicmedStanderprescriptionDisease:edit")
	 * 
	 * @RequestMapping(value = "save") public String
	 * save(SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease,
	 * Model model, RedirectAttributes redirectAttributes) { if
	 * (!beanValidator(model, sicmedStanderprescriptionDisease)) { return
	 * form(sicmedStanderprescriptionDisease, model); }
	 * sicmedStanderprescriptionDiseaseService.save(
	 * sicmedStanderprescriptionDisease); addMessage(redirectAttributes,
	 * "保存保存成功成功"); return "redirect:" + Global.getAdminPath() +
	 * "/rest/sicmedStanderprescriptionDisease/?repage"; }
	 * 
	 * @RequiresPermissions("rest:sicmedStanderprescriptionDisease:edit")
	 * 
	 * @RequestMapping(value = "delete") public String
	 * delete(SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease,
	 * RedirectAttributes redirectAttributes) {
	 * sicmedStanderprescriptionDiseaseService.delete(
	 * sicmedStanderprescriptionDisease); addMessage(redirectAttributes,
	 * "删除保存成功成功"); return "redirect:" + Global.getAdminPath() +
	 * "/rest/sicmedStanderprescriptionDisease/?repage"; }
	 */

}