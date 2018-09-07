package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.entity.SicmedDisease;
import com.sicmed.ehis.entity.SicmedInspectPrice;
import com.sicmed.ehis.service.SicmedDiseaseClassService;
import com.sicmed.ehis.service.SicmedDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 15:20
 * @Todo:  疾病表
 */
@Controller
@RequestMapping(value = "/rest/sicmedDisease")
public class SicmedDiseaseController extends BaseController{


    @Autowired
    private SicmedDiseaseService sicmedDiseaseService;

    @Autowired
    private SicmedDiseaseClassService sicmedDiseaseClassService;

   /**
    *@Author:      ykbian
    *@date_time:   2018/9/6 15:24
    *@Description:  根据id查询疾病信息
    *@param:
   */
    @ResponseBody
    @RequestMapping(value = "getById")
    public Map getById(String id) {
        SicmedDisease sicmedDisease = sicmedDiseaseService.selectById(id);
        if (sicmedDisease == null) {
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedDisease);
    }

//    /**
//     *@Author:      ykbian
//     *@date_time:   2018/9/6 15:33
//     *@Description:
//     *@param:
//    */
//    @ResponseBody
//    @RequestMapping(value = "getByClass")
//    public Map getByDiseaseClass(@RequestParam String diseaseClassId) {
//
//        if (!AppParameterSimulation.simulationId(diseaseClassId)) {
//            BaseBean baseBean = new BaseBean();
//            baseBean.failureWithParameter();
//            return baseBean;
//        }
//
//        SicmedDiseaseBeans sicmedDiseaseBeans = new SicmedDiseaseBeans();
//        SicmedDisease sicmedDisease = new SicmedDisease();
//
//        try {
//            SicmedDiseaseClass sicmedDiseaseClass = sicmedDiseaseClassService.get(diseaseClassId);
//            sicmedDisease.setDiseaseClass(sicmedDiseaseClass);
//
//            List<SicmedDisease> sicmedDiseases = sicmedDiseaseService.findList(sicmedDisease);
//            if (sicmedDiseases.size() != 0) {
//                for (SicmedDisease sicmedDisease2 : sicmedDiseases) {
//                    SicmedDiseaseBean sicmedDiseaseBean = new SicmedDiseaseBean();
//                    sicmedDiseaseBean.setSD(sicmedDisease2);
//                    sicmedDiseaseBeans.getSicmedDiseaseBeans().add(sicmedDiseaseBean);
//                }
//                sicmedDiseaseBeans.setError("0");
//                sicmedDiseaseBeans.setErrorMessage("查询疾病成功");
//            } else {
//
//                sicmedDiseaseBeans.setError("1");
//                sicmedDiseaseBeans.setErrorMessage("查询的信息不存在");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            sicmedDiseaseBeans.setError("1");
//            sicmedDiseaseBeans.setErrorMessage("查询疾病失败");
//        }
//        return sicmedDiseaseBeans;
//    }

//    /**
//     * 模糊搜索疾病信息 接口
//     *
//     * @author Max
//     * @param disease
//     * @return BaseBean
//     */
//    @ResponseBody
//    @RequestMapping(value = "searchDisease")
//    public BaseBean searchDisease(String disease, String pageNo,String classId) {
//        // 创建返回对象
//        SicmedDiseaseBeans sicmedDiseaseBeans = new SicmedDiseaseBeans();
//        // 创建查询条件
//        SicmedDisease sicmedDisease = new SicmedDisease();
//        // 创建分页条件
//        Page<SicmedDisease> page = new Page<SicmedDisease>();
//        page.setPageSize(PageUtils.PAGE_SIZE);
//        if (AppParameterSimulation.isEmpty(pageNo)) {
//            pageNo = "1";
//        }
//        page.setPageNo(Integer.parseInt(pageNo));
//        // 查询条件赋值
//        sicmedDisease.setPage(page);
//        if(AppParameterSimulation.simulationIsChinese(disease)){
//            sicmedDisease.setDiseaseName(disease);
//        }else if(AppParameterSimulation.simulationIsPinYin(disease)){
//            sicmedDisease.setDiseaseNamePmpa(disease);
//        }else if(AppParameterSimulation.isNumber(disease)){
//            sicmedDisease.setDiseaseCode(disease);
//        }
//        if(AppParameterSimulation.isNotEmpty(classId)){
//            sicmedDisease.setDiseaseClass(sicmedDiseaseClassService.get(classId));
//        }
//        // 调用service查询疾病信息
//        List<SicmedDisease> sicmedDiseases = sicmedDiseaseService.findListLike(sicmedDisease);
//        // 查询结果处理
//        if (sicmedDiseases.size() > 0) {
//            for (SicmedDisease sicmedDisease2 : sicmedDiseases) {
//                SicmedDiseaseBean sicmedDiseaseBean = new SicmedDiseaseBean();
//                sicmedDiseaseBean.setSD(sicmedDisease2);
//                sicmedDiseaseBeans.getSicmedDiseaseBeans().add(sicmedDiseaseBean);
//            }
//            sicmedDiseaseBeans.setError("0");
//            sicmedDiseaseBeans.setErrorMessage("查询成功");
//        } else {
//            sicmedDiseaseBeans.setError("1");
//            sicmedDiseaseBeans.setErrorMessage("查询结果为空!");
//            return sicmedDiseaseBeans;
//        }
//        // 返回处理结果
//        return sicmedDiseaseBeans;
//    }
}
