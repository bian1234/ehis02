package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCureCheckBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCureCheckBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCureCheck;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCureClass;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCureCheckService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCureClassService;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.PageUtils;

/**
 * 治疗项目 接口示例Controller
 *
 * @author Max
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedCureCheck")
public class SicmedCureCheckController extends BaseController {

    @Autowired
    private SicmedCureCheckService sicmedCureCheckService;

    @Autowired
    private SicmedCureClassService sicmedCureClassService;

    /**
     * 搜索治疗项目
     *
     * @param parameter(编码;名称;拼音缩写)
     * @return BaseBean
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "searchCure")
    public BaseBean searchCure(String parameter, String pageNo, String classId) {
        SicmedCureCheckBeans sicmedCureCheckBeans = new SicmedCureCheckBeans();
        // 传入参数判断
        // 创建查询条件
        SicmedCureCheck sicmedCureCheck = new SicmedCureCheck();
        // 创建分页查询条件
        Page<SicmedCureCheck> page = new Page<SicmedCureCheck>();
        page.setPageSize(PageUtils.PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        sicmedCureCheckBeans.setPageNo(pageNo);
        sicmedCureCheck.setPage(page);
        if (parameter != null) {
            if (AppParameterSimulation.isChineseName(parameter)) {
                sicmedCureCheck.setCureName(parameter);
            } else if (AppParameterSimulation.simulationIsNumber(parameter)) {
                sicmedCureCheck.setCureCode(parameter);
            } else if (AppParameterSimulation.simulationIsPinYin(parameter)) {
                sicmedCureCheck.setCureNamePY(parameter);
            }
        }
        if (AppParameterSimulation.isNotEmpty(classId)) {
            sicmedCureCheck.setSicmedCureClass(sicmedCureClassService.get(classId));
        }
        // 根据查询条件 查询
        List<SicmedCureCheck> sicmedCureChecks = sicmedCureCheckService.findListLike(sicmedCureCheck);
        // 判断查询结果
        if (sicmedCureChecks.size() > 0) {
            for (SicmedCureCheck sicmedCureCheck2 : sicmedCureChecks) {
                SicmedCureCheckBean sicmedCureChecBean = new SicmedCureCheckBean();
                sicmedCureChecBean.setSCCB(sicmedCureCheck2);
                sicmedCureCheckBeans.getCureCheckBeanList().add(sicmedCureChecBean);
            }
            sicmedCureCheckBeans.setError("0");
            sicmedCureCheckBeans.setSuccessMessage("查询成功");
        } else {
            sicmedCureCheckBeans.setError("1");
            sicmedCureCheckBeans.setErrorMessage("查询结果为空");
        }
        return sicmedCureCheckBeans;
    }

    /**
     * 搜索治疗项目
     *
     * @return BaseBean
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "findCure")
    public BaseBean findCure(String parameter, String classId, String pageNo) {
        //创建返回对象
        SicmedCureCheckBeans sicmedCureCheckBeans = new SicmedCureCheckBeans();
        // 传入参数判断
        if (AppParameterSimulation.isEmpty(classId)) {
            sicmedCureCheckBeans.setError("1");
            sicmedCureCheckBeans.setErrorMessage("参数为空");
            return sicmedCureCheckBeans;
        } else if (!AppParameterSimulation.simulationId(classId)) {
            sicmedCureCheckBeans.setError("1");
            sicmedCureCheckBeans.setErrorMessage("治疗类别ID不正确");
            return sicmedCureCheckBeans;
        }
        // 获取 治疗类别
        SicmedCureClass sicmedCureClass = sicmedCureClassService.get(classId);
        // 创建查询条件
        SicmedCureCheck sicmedCureCheck = new SicmedCureCheck();
        // 创建分页查询条件
        Page<SicmedCureCheck> page = new Page<SicmedCureCheck>();
        page.setPageSize(PageUtils.PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        //查询条件赋值
        sicmedCureCheckBeans.setPageNo(pageNo);
        sicmedCureCheck.setPage(page);
        sicmedCureCheck.setSicmedCureClass(sicmedCureClass);
        // 调用service方法查询治疗信息
        List<SicmedCureCheck> sicmedCureChecks = sicmedCureCheckService.findListLike(sicmedCureCheck);
        // 判断查询结果
        if (sicmedCureChecks.size() == 0) {
            sicmedCureCheckBeans.setError("1");
            sicmedCureCheckBeans.setErrorMessage("查询结果为空");
            return sicmedCureCheckBeans;
        } else {
            // 遍历查询结果设置 返回值
            for (SicmedCureCheck sicmedCureCheck2 : sicmedCureChecks) {
                SicmedCureCheckBean sicmedCureChecBean = new SicmedCureCheckBean();
                sicmedCureChecBean.setSCCB(sicmedCureCheck2);
                sicmedCureCheckBeans.getCureCheckBeanList().add(sicmedCureChecBean);
            }
        }
        return sicmedCureCheckBeans;
    }
}