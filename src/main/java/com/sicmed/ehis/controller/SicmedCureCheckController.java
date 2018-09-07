package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.AppParameterSimulation;
import com.sicmed.ehis.entity.SicmedBranch;
import com.sicmed.ehis.entity.SicmedCureCheck;
import com.sicmed.ehis.entity.SicmedCureClass;
import com.sicmed.ehis.service.SicmedCureCheckService;
import com.sicmed.ehis.service.SicmedCureClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 9:20
 * @Todo:   治疗检查
 */
@Controller
@RequestMapping(value = "/rest/sicmedCureCheck")
public class SicmedCureCheckController extends BaseController{

    @Autowired
    private SicmedCureCheckService sicmedCureCheckService;

    @Autowired
    private SicmedCureClassService sicmedCureClassService;

   /**
    *@Author:      ykbian
    *@date_time:   2018/9/6 9:34
    *@Description:  搜索治疗项目
    *@param:       查询条件（编码，名称，拼音简写）、分页条件、治疗大分类id
   */
    @ResponseBody
    @GetMapping(value = "searchCure")
    public Map searchCure(String parameter,String classId,Integer offset,Integer limit) {
        Query query = new Query(offset,limit);
        SicmedCureCheck sicmedCureCheck = new SicmedCureCheck();
        SicmedCureClass cc = null;
        Map<String,Object> map = new HashMap<>();
        //判断传入的搜索条件======不是中文名，也不是拼音的默认是编码
        if(parameter!=null){
            if(AppParameterSimulation.isChineseName(parameter)){
                sicmedCureCheck.setCureName(parameter);
            }else if(AppParameterSimulation.simulationIsPinYin(parameter)){
                sicmedCureCheck.setCureNamePy(parameter);
            } else{
                sicmedCureCheck.setCureCode(parameter);
            }
        }
        if(AppParameterSimulation.isNotEmpty(classId)){
            sicmedCureCheck.setCureClassCode(classId);
        }

        if(AppParameterSimulation.isNotEmpty(classId)){
            cc = sicmedCureClassService.selectById(classId);
        }
        map.put("sicmedCureCheck",sicmedCureCheck);
        map.put("query",query);
        // 根据查询条件 查询
        List<SicmedCureCheck> sicmedCureChecks = sicmedCureCheckService.searchCure(map);
        for (SicmedCureCheck sicmedCureCheck1:sicmedCureChecks) {
            sicmedCureCheck1.setSicmedCureClass(cc);
        }
        if (sicmedCureChecks.isEmpty()){
            return  queryEmptyResponse();
        }
        return querySuccessResponse(sicmedCureChecks);
    }

//    /**
//     * 搜索治疗项目
//     *
//     * @author Max
//     * @return BaseBean
//     */
//    @ResponseBody
//    @RequestMapping(value = "findCure")
//    public BaseBean findCure(String parameter, String classId,String pageNo) {
//        //创建返回对象
//        SicmedCureCheckBeans sicmedCureCheckBeans = new SicmedCureCheckBeans();
//        // 传入参数判断
//        if (AppParameterSimulation.isEmpty(classId)) {
//            sicmedCureCheckBeans.setError("1");
//            sicmedCureCheckBeans.setErrorMessage("参数为空");
//            return sicmedCureCheckBeans;
//        } else if (!AppParameterSimulation.simulationId(classId)) {
//            sicmedCureCheckBeans.setError("1");
//            sicmedCureCheckBeans.setErrorMessage("治疗类别ID不正确");
//            return sicmedCureCheckBeans;
//        }
//        // 获取 治疗类别
//        SicmedCureClass sicmedCureClass = sicmedCureClassService.get(classId);
//        // 创建查询条件
//        SicmedCureCheck sicmedCureCheck = new SicmedCureCheck();
//        // 创建分页查询条件
//        Page<SicmedCureCheck> page = new Page<SicmedCureCheck>();
//        page.setPageSize(PageUtils.PAGE_SIZE);
//        if (AppParameterSimulation.isEmpty(pageNo)) {
//            pageNo = "1";
//        }
//        page.setPageNo(Integer.parseInt(pageNo));
//        //查询条件赋值
//        sicmedCureCheckBeans.setPageNo(pageNo);
//        sicmedCureCheck.setPage(page);
//        sicmedCureCheck.setSicmedCureClass(sicmedCureClass);
//        // 调用service方法查询治疗信息
//        List<SicmedCureCheck> sicmedCureChecks = sicmedCureCheckService.findListLike(sicmedCureCheck);
//        // 判断查询结果
//        if (sicmedCureChecks.size() == 0) {
//            sicmedCureCheckBeans.setError("1");
//            sicmedCureCheckBeans.setErrorMessage("查询结果为空");
//            return sicmedCureCheckBeans;
//        } else {
//            // 遍历查询结果设置 返回值
//            for (SicmedCureCheck sicmedCureCheck2 : sicmedCureChecks) {
//                SicmedCureCheckBean sicmedCureChecBean = new SicmedCureCheckBean();
//                sicmedCureChecBean.setSCCB(sicmedCureCheck2);
//                sicmedCureCheckBeans.getCureCheckBeanList().add(sicmedCureChecBean);
//            }
//        }
//        return sicmedCureCheckBeans;
//    }
}
