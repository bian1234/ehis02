package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.HashMap;
import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.restlet.resource.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedical;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalClass;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedMedicalClassService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedMedicalPriceService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedMedicalService;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.PageUtils;

/**
 * 药品详细信息Controller
 *
 * @author 丁学志
 * @version 2016-07-12
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedMedical")
public class SicmedMedicalController extends BaseController {

    @Autowired
    private SicmedMedicalService sicmedMedicalService;
    @Autowired
    private SicmedMedicalClassService sicmedMedicalClassService;
    @Autowired
    private SicmedMedicalPriceService sicmedMedicalPriceService;

    /**
     * 修改药品信息名
     */
    @ResponseBody
    @RequestMapping(value = "updateMedicalName")
    public void updateMedical() {
        List<SicmedMedical> sicmedMedicales = sicmedMedicalService.getAll();
        for (SicmedMedical sicmedMedical : sicmedMedicales) {
            String str = clearNotChinese(sicmedMedical.getMedicalNameChina());
            sicmedMedical.setMedicalNameChina(str);
            sicmedMedicalService.update(sicmedMedical);
            logger.info(str);
        }
    }

    /**
     * 修改药品类别
     */
    @ResponseBody
    @RequestMapping(value = "updateMedicalClass")
    public void updateMedicalClass() {
        SicmedMedicalClass medicalClass1 = sicmedMedicalClassService.get("586ad37b461e448bb5c5decaa6c4f8d6");// 中成
        SicmedMedicalClass medicalClass2 = sicmedMedicalClassService.get("ed3022b14ee04787812be7c0065149ea");// 中
        SicmedMedicalClass medicalClass3 = sicmedMedicalClassService.get("4c17ac064fdb4a9abdd6294066485165");// 西
        int i = 0;
        List<SicmedMedical> sicmedMedicales = sicmedMedicalService.getAll();
        for (SicmedMedical sicmedMedical : sicmedMedicales) {
            i = i + 1;
            String str = sicmedMedical.getMedicalCode();
            if (str.indexOf("CMED") != -1) {
                sicmedMedical.setMedicalClassOne(medicalClass1);
            } else if (str.indexOf("HMED") != -1) {
                sicmedMedical.setMedicalClassOne(medicalClass2);
            } else if (str.indexOf("MED0") != -1) {
                sicmedMedical.setMedicalClassOne(medicalClass3);
            }
            sicmedMedicalService.update(sicmedMedical);
            logger.info("已完成" + i + "条数据修改");
        }
    }

    /**
     * 修改药品类别
     */
    @ResponseBody
    @RequestMapping(value = "updateMedicalunit")
    public void updateMedicalunit() {
        int i = 0;
        List<SicmedMedical> sicmedMedicales = sicmedMedicalService.getAll();
        for (SicmedMedical sicmedMedical : sicmedMedicales) {
            i = i + 1;
            String str = sicmedMedical.getMedicalClassOne().getId();
            String medicalDetail = sicmedMedical.getDetail();
            String medicalStand = "";
            if (medicalDetail.indexOf("(") != -1 && medicalDetail.indexOf(")") != -1) {
                medicalStand = medicalDetail.substring(medicalDetail.indexOf("(") + 1, medicalDetail.lastIndexOf(")"));
            } else {
                medicalStand = "1";
            }
            if (str.equals("ed3022b14ee04787812be7c0065149ea")) {
                sicmedMedical.setMedicalStand(medicalStand);
                sicmedMedical.setUnit1("袋");
                sicmedMedical.setUnit2("g");
            } else if (str.equals("586ad37b461e448bb5c5decaa6c4f8d6")) {
                sicmedMedical.setMedicalStand(medicalStand);
                if (medicalDetail.indexOf("丸") != -1 && medicalDetail.indexOf("袋") != -1) {
                    sicmedMedical.setUnit1("袋");
                    sicmedMedical.setUnit2("丸");
                } else if (medicalDetail.indexOf("胶囊") != -1 && medicalDetail.indexOf("粒") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("粒");
                } else if (medicalDetail.indexOf("颗粒") != -1 && medicalDetail.indexOf("袋") != -1
                        && medicalDetail.indexOf("盒") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("袋");
                } else if (medicalDetail.indexOf("软膏") != -1 && medicalDetail.indexOf("支") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("支");
                } else if (medicalDetail.indexOf("剂") != -1 && medicalDetail.indexOf("袋") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("袋");
                } else if (medicalDetail.indexOf("口服液") != -1 && medicalDetail.indexOf("支") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("支");
                } else if (medicalDetail.indexOf("颗粒") != -1 && medicalDetail.indexOf("包") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("包");
                } else if (medicalDetail.indexOf("栓") != -1 && medicalDetail.indexOf("枚") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("枚");
                } else if (medicalDetail.indexOf("液") != -1 && medicalDetail.indexOf("支") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("支");
                } else if (medicalDetail.indexOf("膏") != -1 && medicalDetail.indexOf("贴") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("贴");
                } else if (medicalDetail.indexOf("丸") != -1 && medicalDetail.indexOf("瓶") != -1) {
                    sicmedMedical.setUnit1("瓶");
                    sicmedMedical.setUnit2("丸");
                } else if (medicalDetail.indexOf("散") != -1 && medicalDetail.indexOf("瓶") != -1) {
                    sicmedMedical.setUnit1("瓶");
                    sicmedMedical.setUnit2("mg");
                } else if (medicalDetail.indexOf("水") != -1 && medicalDetail.indexOf("瓶") != -1) {
                    sicmedMedical.setUnit1("瓶");
                    sicmedMedical.setUnit2("ml");
                } else if (medicalDetail.indexOf("丹") != -1 && medicalDetail.indexOf("支") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("支");
                } else if (medicalDetail.indexOf("洗液") != -1 && medicalDetail.indexOf("瓶") != -1) {
                    sicmedMedical.setUnit1("瓶");
                    sicmedMedical.setUnit2("ml");
                } else if (medicalDetail.indexOf("丹") != -1 && medicalDetail.indexOf("瓶") != -1) {
                    sicmedMedical.setUnit1("瓶");
                    sicmedMedical.setUnit2("粒");
                } else if (medicalDetail.indexOf("油") != -1 && medicalDetail.indexOf("瓶") != -1) {
                    sicmedMedical.setUnit1("瓶");
                    sicmedMedical.setUnit2("ml");
                } else if (medicalDetail.indexOf("栓") != -1 && medicalDetail.indexOf("粒") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("粒");
                } else if (medicalDetail.indexOf("浆") != -1 && medicalDetail.indexOf("瓶") != -1) {
                    sicmedMedical.setUnit1("瓶");
                    sicmedMedical.setUnit2("ml");
                } else if (medicalDetail.indexOf("颗粒") != -1 && medicalDetail.indexOf("袋") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("袋");
                } else if (medicalDetail.indexOf("冲剂") != -1 && medicalDetail.indexOf("袋") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("袋");
                } else if (medicalDetail.indexOf("支") != -1) {
                    sicmedMedical.setUnit1("支");
                    sicmedMedical.setUnit2("支");
                } else if (medicalDetail.indexOf("片") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("片");
                } else if (medicalDetail.indexOf("洗液") != -1) {
                    sicmedMedical.setUnit1("瓶");
                    sicmedMedical.setUnit2("ml");
                } else if (medicalDetail.indexOf("喷雾剂") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("ml");
                } else if (medicalDetail.indexOf("膏") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("mg");
                } else if (medicalDetail.indexOf("散") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("mg");
                } else if (medicalDetail.indexOf("剂") != -1) {
                    sicmedMedical.setUnit1("支");
                    sicmedMedical.setUnit2("ml");
                } else if (medicalDetail.indexOf("水") != -1) {
                    sicmedMedical.setUnit1("瓶");
                    sicmedMedical.setUnit2("ml");
                } else if (medicalDetail.indexOf("针") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("支");
                } else {
                    sicmedMedical.setUnit1("");
                    sicmedMedical.setUnit2("");
                }
            } else if (str.equals("4c17ac064fdb4a9abdd6294066485165")) {
                sicmedMedical.setMedicalStand(medicalStand);
                if (medicalDetail.indexOf("丸") != -1 && medicalDetail.indexOf("袋") != -1) {
                    sicmedMedical.setUnit1("袋");
                    sicmedMedical.setUnit2("丸");
                } else if (medicalDetail.indexOf("针") != -1 && medicalDetail.indexOf("ml") != -1
                        && medicalDetail.indexOf("mg") != -1) {
                    sicmedMedical.setUnit1("支");
                    sicmedMedical.setUnit2("支");
                } else if (medicalDetail.indexOf("针") != -1 && medicalDetail.indexOf("ml") != -1) {
                    sicmedMedical.setUnit1("支");
                    sicmedMedical.setUnit2("支");
                } else if (medicalDetail.indexOf("注射液") != -1 && medicalDetail.indexOf("ml") != -1
                        && medicalDetail.indexOf("mg") != -1) {
                    sicmedMedical.setUnit1("mg");
                    sicmedMedical.setUnit2("mg");
                } else if (medicalDetail.indexOf("注射液") != -1 && medicalDetail.indexOf("ml") != -1
                        && medicalDetail.indexOf("g") != -1) {
                    sicmedMedical.setUnit1("g");
                    sicmedMedical.setUnit2("g");
                } else if (medicalDetail.indexOf("注射液") != -1 && medicalDetail.indexOf("ml") != -1) {
                    sicmedMedical.setUnit1("ml");
                    sicmedMedical.setUnit2("ml");
                } else if (medicalDetail.indexOf("注射液") != -1 && medicalDetail.indexOf("mg") != -1) {
                    sicmedMedical.setUnit1("mg");
                    sicmedMedical.setUnit2("mg");
                } else if (medicalDetail.indexOf("注射液") != -1 && medicalDetail.indexOf("g") != -1) {
                    sicmedMedical.setUnit1("g");
                    sicmedMedical.setUnit2("g");
                } else if (medicalDetail.indexOf("注射液") != -1 && medicalDetail.indexOf("u") != -1) {
                    sicmedMedical.setUnit1("u");
                    sicmedMedical.setUnit2("u");
                } else if (medicalDetail.indexOf("注射用") != -1 && medicalDetail.indexOf("mg") != -1) {
                    sicmedMedical.setUnit1("mg");
                    sicmedMedical.setUnit2("mg");
                } else if (medicalDetail.indexOf("注射用") != -1 && medicalDetail.indexOf("g") != -1) {
                    sicmedMedical.setUnit1("g");
                    sicmedMedical.setUnit2("g");
                } else if (medicalDetail.indexOf("注射用") != -1 && medicalDetail.indexOf("IU") != -1) {
                    sicmedMedical.setUnit1("IU");
                    sicmedMedical.setUnit2("IU");
                } else if (medicalDetail.indexOf("胶囊") != -1 && medicalDetail.indexOf("粒") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("粒");
                } else if (medicalDetail.indexOf("颗粒") != -1 && medicalDetail.indexOf("袋") != -1
                        && medicalDetail.indexOf("盒") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("袋");
                } else if (medicalDetail.indexOf("软膏") != -1 && medicalDetail.indexOf("支") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("支");
                } else if (medicalDetail.indexOf("剂") != -1 && medicalDetail.indexOf("袋") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("袋");
                } else if (medicalDetail.indexOf("口服液") != -1 && medicalDetail.indexOf("支") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("支");
                } else if (medicalDetail.indexOf("颗粒") != -1 && medicalDetail.indexOf("包") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("包");
                } else if (medicalDetail.indexOf("栓") != -1 && medicalDetail.indexOf("枚") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("枚");
                } else if (medicalDetail.indexOf("液") != -1 && medicalDetail.indexOf("支") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("支");
                } else if (medicalDetail.indexOf("膏") != -1 && medicalDetail.indexOf("贴") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("贴");
                } else if (medicalDetail.indexOf("丸") != -1 && medicalDetail.indexOf("瓶") != -1) {
                    sicmedMedical.setUnit1("瓶");
                    sicmedMedical.setUnit2("丸");
                } else if (medicalDetail.indexOf("散") != -1 && medicalDetail.indexOf("瓶") != -1) {
                    sicmedMedical.setUnit1("瓶");
                    sicmedMedical.setUnit2("mg");
                } else if (medicalDetail.indexOf("水") != -1 && medicalDetail.indexOf("瓶") != -1) {
                    sicmedMedical.setUnit1("瓶");
                    sicmedMedical.setUnit2("ml");
                } else if (medicalDetail.indexOf("丹") != -1 && medicalDetail.indexOf("支") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("支");
                } else if (medicalDetail.indexOf("洗液") != -1 && medicalDetail.indexOf("瓶") != -1) {
                    sicmedMedical.setUnit1("瓶");
                    sicmedMedical.setUnit2("ml");
                } else if (medicalDetail.indexOf("丹") != -1 && medicalDetail.indexOf("瓶") != -1) {
                    sicmedMedical.setUnit1("瓶");
                    sicmedMedical.setUnit2("粒");
                } else if (medicalDetail.indexOf("油") != -1 && medicalDetail.indexOf("瓶") != -1) {
                    sicmedMedical.setUnit1("瓶");
                    sicmedMedical.setUnit2("ml");
                } else if (medicalDetail.indexOf("栓") != -1 && medicalDetail.indexOf("粒") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("粒");
                } else if (medicalDetail.indexOf("浆") != -1 && medicalDetail.indexOf("瓶") != -1) {
                    sicmedMedical.setUnit1("瓶");
                    sicmedMedical.setUnit2("ml");
                } else if (medicalDetail.indexOf("颗粒") != -1 && medicalDetail.indexOf("袋") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("袋");
                } else if (medicalDetail.indexOf("冲剂") != -1 && medicalDetail.indexOf("袋") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("袋");
                } else if (medicalDetail.indexOf("支") != -1) {
                    sicmedMedical.setUnit1("支");
                    sicmedMedical.setUnit2("支");
                } else if (medicalDetail.indexOf("片") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("片");
                } else if (medicalDetail.indexOf("洗液") != -1) {
                    sicmedMedical.setUnit1("瓶");
                    sicmedMedical.setUnit2("ml");
                } else if (medicalDetail.indexOf("喷雾剂") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("ml");
                } else if (medicalDetail.indexOf("膏") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("mg");
                } else if (medicalDetail.indexOf("散") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("mg");
                } else if (medicalDetail.indexOf("剂") != -1) {
                    sicmedMedical.setUnit1("支");
                    sicmedMedical.setUnit2("ml");
                } else if (medicalDetail.indexOf("水") != -1) {
                    sicmedMedical.setUnit1("瓶");
                    sicmedMedical.setUnit2("ml");
                } else if (medicalDetail.indexOf("针") != -1) {
                    sicmedMedical.setUnit1("盒");
                    sicmedMedical.setUnit2("支");
                } else if (medicalDetail.indexOf("g") != -1) {
                    sicmedMedical.setUnit1("g");
                    sicmedMedical.setUnit2("g");
                } else if (medicalDetail.indexOf("mg") != -1) {
                    sicmedMedical.setUnit1("mg");
                    sicmedMedical.setUnit2("mg");
                } else if (medicalDetail.indexOf("ml") != -1) {
                    sicmedMedical.setUnit1("ml");
                    sicmedMedical.setUnit2("ml");
                } else if (medicalDetail.indexOf("iu") != -1) {
                    sicmedMedical.setUnit1("iu");
                    sicmedMedical.setUnit2("iu");
                } else {
                    sicmedMedical.setUnit1("");
                    sicmedMedical.setUnit2("");
                }
                sicmedMedicalService.update(sicmedMedical);
                logger.info("第" + i + "条数据修改");
            }
        }
    }

    /**
     * 修改药品二级类别
     */
    @ResponseBody
    @RequestMapping(value = "updateMedicalClassTwo")
    public void updateMedicalClassTwo() {
        SicmedMedicalClass medicalClass1 = sicmedMedicalClassService.get("14578dbba5714e48b9cf0e890c3e800e");
        int i = 0;
        List<SicmedMedical> sicmedMedicales = sicmedMedicalService.getAll();
        for (SicmedMedical sicmedMedical : sicmedMedicales) {
            i = i + 1;
            String str = sicmedMedical.getDetail();
            if (str.indexOf("注射") != -1) {
                sicmedMedical.setMedicalClassTwo(medicalClass1);
            } else if (str.indexOf("针") != -1) {
                sicmedMedical.setMedicalClassTwo(medicalClass1);
            }
            sicmedMedicalService.update(sicmedMedical);
            logger.info("已完成" + i + "条数据修改");
        }
    }

    public String clearNotChinese(String buff) {
        String tmpString = buff.replaceAll("(?i)[^a-zA-Z0-9\u4E00-\u9FA5]", "");// 去掉所有中英文符号
        char[] carr = tmpString.toCharArray();
        for (int i = 0; i < tmpString.length(); i++) {
            if (carr[i] < 0xFF) {
                carr[i] = ' ';// 过滤掉非汉字内容
            }
        }
        return String.copyValueOf(carr).trim();
    }

    /**
     * 查询药品的详细信息
     *
     * @param parameter(编码;名称;拼音缩写)
     * @return BaseBean
     * @author Max
     */

    @ResponseBody
    @RequestMapping(value = "searchMedical")
    public BaseBean searchMedicalDetail(String parameter, String classId, String classOneId, String classTwoId, String classThreeId, String pageNo) {
        SicmedMedicalBeans sicmedMedicalBeans = new SicmedMedicalBeans();
        // 判断传入参数
        // 创建查询条件
        SicmedMedical sicmedMedical = new SicmedMedical();
        // 获取药品类别
        if (AppParameterSimulation.isNotEmpty(classOneId)) {
            SicmedMedicalClass sicmedMedicalClassOne = new SicmedMedicalClass();
            sicmedMedicalClassOne.setId(classOneId);
            sicmedMedicalClassOne = sicmedMedicalClassService.get(sicmedMedicalClassOne);
            sicmedMedical.setMedicalClassOne(sicmedMedicalClassOne);
        }
        if (AppParameterSimulation.isNotEmpty(classId)) {
            SicmedMedicalClass sicmedMedicalClassOne = new SicmedMedicalClass();
            sicmedMedicalClassOne.setId(classId);
            sicmedMedicalClassOne = sicmedMedicalClassService.get(sicmedMedicalClassOne);
            sicmedMedical.setMedicalClassOne(sicmedMedicalClassOne);
        }
        if (AppParameterSimulation.isNotEmpty(classTwoId)) {
            SicmedMedicalClass sicmedMedicalClassTwo = new SicmedMedicalClass();
            sicmedMedicalClassTwo.setId(classOneId);
            sicmedMedicalClassTwo = sicmedMedicalClassService.get(sicmedMedicalClassTwo);
            sicmedMedical.setMedicalClassOne(sicmedMedicalClassTwo);
        }
        if (AppParameterSimulation.isNotEmpty(classThreeId)) {
            SicmedMedicalClass sicmedMedicalClassThree = new SicmedMedicalClass();
            sicmedMedicalClassThree.setId(classOneId);
            sicmedMedicalClassThree = sicmedMedicalClassService.get(sicmedMedicalClassThree);
            sicmedMedical.setMedicalClassOne(sicmedMedicalClassThree);
        }
        // 分页查询
        Page<SicmedMedical> page = new Page<SicmedMedical>();
        page.setPageSize(PageUtils.PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));

        sicmedMedical.setPage(page);
        //判断请求参数
        //1.请求参数符合规定 不为空且不为注入攻击 长度小于6
        if (AppParameterSimulation.isNotEmpty(parameter) && parameter.length() < 6) {
            if (AppParameterSimulation.isChineseName(parameter)) {
                sicmedMedical.setMedicalNameChina(parameter);
            } else if (AppParameterSimulation.simulationIsNumber(parameter)) {    //请求参数是数字
                sicmedMedical.setMedicalCode(parameter);
            } else if (AppParameterSimulation.simulationIsPinYin(parameter)) {    //请求参数是拼音
                sicmedMedical.setMedicalNameEnglish(parameter);
            }
        } else if (AppParameterSimulation.isNotEmpty(parameter) && parameter.length() >= 6) {    //请求参数长度大于6
            if (AppParameterSimulation.isChineseName(parameter)) {
                sicmedMedical.setMedicalNameChina(parameter);
            } else if (AppParameterSimulation.simulationIsNumber(parameter)) {
                sicmedMedical.setMedicalCode(parameter);
            } else if (AppParameterSimulation.simulationIsPinYin(parameter)) {
                sicmedMedical.setMedicalNameEnglish(parameter);
            }
        }
        // 根据查询条件 查询药品信息
        List<SicmedMedical> sicmedMedicals = sicmedMedicalService.findListLike(sicmedMedical);
        // 判断查询结果
        if (sicmedMedicals.size() == 0) {
            sicmedMedicalBeans.setError("1");
            sicmedMedicalBeans.setErrorMessage("查询结果为空");
            return sicmedMedicalBeans;
        } else {
            // 遍历查询结果
            sicmedMedicalBeans.setError("0");
            sicmedMedicalBeans.setErrorMessage("查询成功");
            for (SicmedMedical sicmedMedical2 : sicmedMedicals) {
                SicmedMedicalBean sicmedMedicalBean = new SicmedMedicalBean();
                sicmedMedicalBean.setSMB(sicmedMedical2);
                sicmedMedicalBeans.getSicmedMedicalBeans().add(sicmedMedicalBean);
            }
        }
        return sicmedMedicalBeans;
    }

    /**
     * @param parameter
     * @param classId
     * @return
     * @author Max
     */
    @ResponseBody
    @RequestMapping(value = "findMedical")
    public BaseBean findMedical(String parameter, String classOneId, String classTwoId, String classThreeId, String pageNo) {
        // 创建返回对象
        SicmedMedicalBeans sicmedMedicalBeans = new SicmedMedicalBeans();
        // 创建查询条件
        SicmedMedical sicmedMedical = new SicmedMedical();
        // 获取药品类别
        if (AppParameterSimulation.isNotEmpty(classOneId)) {
            SicmedMedicalClass sicmedMedicalClassOne = sicmedMedicalClassService.get(classOneId);
            sicmedMedical.setMedicalClassOne(sicmedMedicalClassOne);
        }
        if (AppParameterSimulation.isNotEmpty(classTwoId)) {
            SicmedMedicalClass sicmedMedicalClassTwo = sicmedMedicalClassService.get(classTwoId);
            sicmedMedical.setMedicalClassOne(sicmedMedicalClassTwo);
        }
        if (AppParameterSimulation.isNotEmpty(classThreeId)) {
            SicmedMedicalClass sicmedMedicalClassThree = sicmedMedicalClassService.get(classThreeId);
            sicmedMedical.setMedicalClassOne(sicmedMedicalClassThree);
        }
        // 创建分页条件
        Page<SicmedMedical> page = new Page<SicmedMedical>();
        page.setPageSize(PageUtils.PAGE_SIZE);
        if (AppParameterSimulation.isEmpty(pageNo)) {
            pageNo = "1";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        // 查询条件赋值
        sicmedMedical.setPage(page);
        if (AppParameterSimulation.isNotEmpty(parameter)) {
            String[] parameters = {};
            parameter.length();
            for (int i = 0; i < parameter.length() - 1; i = i + 2) {
                parameters[i] = parameter.substring(i, i + 1);
                parameters[i + 1] = "%";
            }
            parameter = parameters.toString();
            sicmedMedical.setMedicalCode(parameter);
        }

        // 调用service方法查询药品信息
        List<SicmedMedical> sicmedMedicals = sicmedMedicalService.findListLike(sicmedMedical);
        // 判断查询结果
        if (sicmedMedicals.size() == 0) {
            sicmedMedicalBeans.setError("1");
            sicmedMedicalBeans.setErrorMessage("查询结果为空");
            return sicmedMedicalBeans;
        } else {
            // 遍历查询结果
            sicmedMedicalBeans.setError("0");
            sicmedMedicalBeans.setErrorMessage("查询成功");
            for (SicmedMedical sicmedMedical2 : sicmedMedicals) {
                SicmedMedicalBean sicmedMedicalBean = new SicmedMedicalBean();
                sicmedMedicalBean.setSMB(sicmedMedical2);
                sicmedMedicalBeans.getSicmedMedicalBeans().add(sicmedMedicalBean);
            }
        }
        return sicmedMedicalBeans;
    }

    // @ModelAttribute
    // public SicmedMedical get(@RequestParam(required = false) String id) {
    // SicmedMedical entity = null;
    // if (StringUtils.isNotBlank(id)) {
    // entity = sicmedMedicalService.get(id);
    // }
    // if (entity == null) {
    // entity = new SicmedMedical();
    // }
    // return entity;
    // }
    //
    // @RequiresPermissions("rest:sicmedMedical:view")
    // @RequestMapping(value = { "list", "" })
    // public String list(SicmedMedical
    // sicmedMedical, HttpServletRequest request, HttpServletResponse response,
    // Model model) { Page<SicmedMedical> page =
    // sicmedMedicalService.findPage(new Page<SicmedMedical>(request, response),
    // sicmedMedical); model.addAttribute("page", page); return
    // "mobile/rest/sicmedMedicalList";
    // }
    //
    // @RequiresPermissions("rest:sicmedMedical:view")
    // @RequestMapping(value = "form")
    // public String form(SicmedMedical
    // sicmedMedical, Model model) { model.addAttribute("sicmedMedical",
    // sicmedMedical); return "mobile/rest/sicmedMedicalForm";
    // }
    //
    // @RequiresPermissions("rest:sicmedMedical:edit")
    // @RequestMapping(value = "save")
    // public String save(SicmedMedical
    // sicmedMedical, Model model, RedirectAttributes redirectAttributes) { if
    // (!beanValidator(model, sicmedMedical)) { return form(sicmedMedical,
    // model); } sicmedMedicalService.save(sicmedMedical);
    // addMessage(redirectAttributes, "保存药品信息保存成功成功");
    // return "redirect:" +
    // Global.getAdminPath() + "/rest/sicmedMedical/?repage";
    // }
    //
    // @RequiresPermissions("rest:sicmedMedical:edit")
    // @RequestMapping(value = "delete")
    // public String delete(SicmedMedical
    // sicmedMedical, RedirectAttributes redirectAttributes) {
    // sicmedMedicalService.delete(sicmedMedical);
    // addMessage(redirectAttributes, "删除药品信息保存成功成功"); return "redirect:" +
    // Global.getAdminPath() + "/rest/sicmedMedical/?repage";
    // }
    //

    /**
     * 自动分析 药品 说明说 添加药品信息
     *
     * @param parameter
     * @param classId
     * @param pageNo
     * @return
     */

    @Post
    @ResponseBody
    @RequestMapping(value = "addMedical")
    public void addMedical(String medicalClassOne, String medicalClassTwo, String medicalClassThree,
                           String medicalGroup, String str, String code) {

        SicmedMedical sicmedMedical = new SicmedMedical();
        sicmedMedical.setMedicalGroup(medicalGroup);
        sicmedMedical.setMedicalCode(code);
        if (AppParameterSimulation.isNotEmpty(medicalClassOne)) {
            SicmedMedicalClass parent = new SicmedMedicalClass();
            parent.setId(medicalClassOne);
            parent = sicmedMedicalClassService.get(parent);
            sicmedMedical.setMedicalClassOne(parent);
        }
        if (AppParameterSimulation.isNotEmpty(medicalClassTwo)) {
            SicmedMedicalClass parent = new SicmedMedicalClass();
            parent.setId(medicalClassTwo);
            parent = sicmedMedicalClassService.get(parent);
            sicmedMedical.setMedicalClassTwo(parent);
        }
        if (AppParameterSimulation.isNotEmpty(medicalClassThree)) {
            SicmedMedicalClass parent = new SicmedMedicalClass();
            parent.setId(medicalClassThree);
            parent = sicmedMedicalClassService.get(parent);
            sicmedMedical.setMedicalClassThree(parent);
        }

        // String str = "【药品名称】通用名称注射用盐酸大观霉素 英文名称Spectinomycin Hydrochloride for
        // Injection 拼音名称ZhusheyongYansuan
        // Daguanmeisu【成份】本品主要成份为：大观霉素【性状】本品为白色或类白色结晶性粉末。【适应症】本品为淋病奈瑟菌所致尿道、宫颈和直肠感染的二线用药，主要用于对青霉素、四环素等耐药菌株引起的感染。由于多数淋病患者同时合并沙眼衣原体感染，因此应用本品治疗后应继以7日疗程的四环素或多西环素或红霉素治疗。【规格】2g(200万单位)【用法用量】仅供肌内注射。成人用于宫颈、直肠或尿道淋病奈瑟菌感染，单剂一次肌内注射2g；用于播散性淋病，一次肌内注射2g，每12小时1次，共3日。一次最大剂量4g，于左右两侧臀部肌内注射。小儿新生儿禁用。小儿体重45kg以下者，按体重单剂一次肌内注射40mg/kg；45kg以上者，单剂一次肌内注射2g。临用前，每2g本品加入0.9%苯甲醇注射液3.2ml，振摇，使呈混悬液。【不良反应】个别患者偶可出现注射部位疼痛、短暂眩晕、恶心、呕吐及失眠等；偶见发热、皮疹等过敏反应和血红蛋白、红细胞压积减少、肌酐清除率降低，以及碱性磷酸酶、尿素氮和血清氨基转移酶等升高。也有尿量减少的病例发生。【禁忌】对本品及氨基糖苷类抗生素过敏史者及肾病患者禁用。【注意事项】<br
        // />1．本品不得静脉给药。应在臀部肌肉外上方作深部肌内注射，注射部位一次注射量不超过2g(5ml)。2．本品与青霉素类无交叉过敏性。3．发生不良反应时，对严重过敏反应者可给予肾上腺素、皮质激素及（或）抗组胺药物，保持气道通畅，给氧等。【孕妇及哺乳期妇女用药】1．孕妇禁用。2．哺乳期妇女用药尚不明确。若使用本品，应暂停哺乳。【儿童用药】1．由于本品的稀释液中含0.9%的苯甲醇，可能引起新生儿产生致命性喘息综合征，故新生儿禁用。2．小儿淋病患者对青霉素类或头胞菌素类过敏者可应用本品。【药物相互作用】据文献资料报道，本品与碳酸锂合用，可使碳酸锂在个别患者身上出现毒性作用。【药理毒理】本品为链霉菌Streptomycesspectabilis产生的氨基糖苷类抗生素。主要对淋病奈瑟菌有高度抗菌活性，对产生β内酰胺酶的淋病奈瑟菌也有良好的抗菌活性；对许多肠杆菌科细菌具中度抗菌活性。普罗菲登菌和铜绿假单胞菌通常对本品耐药；对本品耐药的菌株往往对链霉素、庆大霉素、妥布霉素等仍敏感。本品对溶脲支原体有良好作用，对沙眼衣原体和梅毒螺旋体无活性。本品的作用机制是与细菌核糖体30S亚单位结合，抑制细菌蛋白质的合成。【药代动力学】本品肌内注射吸收良好。一次肌内注射本品2g后，1小时达血药峰浓度（Cmax），约为100mg/L，8小时血药浓度为15mg/L，剂量加倍则血药浓度亦约增加1倍。与血清蛋白不结合。血消除半衰期（t1/2(）为1～3小时，肾功能减退者（肌酐清除率&lt;20ml/分钟）可延长至10～30小时。本品主要以原型经肾排出，一次给药后48小时内尿中以原型排出约100％。血液透析可使本品的血药浓度降低约50%。【贮藏】密封，在干燥处保存。";
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        List<Integer> index = Lists.newArrayList();
        if (str.indexOf("【药品名称】") != -1) {
            int medNameIndex = str.indexOf("【药品名称】");
            map.put(medNameIndex, "【药品名称】");
            index.add(medNameIndex);
        }
        if (str.indexOf("【成分】") != -1) {
            int medChenIndex = str.indexOf("【成分】");
            map.put(medChenIndex, "【成分】");
            index.add(medChenIndex);
        }
        if (str.indexOf("【性状】") != -1) {
            int medXingIndex = str.indexOf("【性状】");
            map.put(medXingIndex, "【性状】");
            index.add(medXingIndex);
        }
        if (str.indexOf("【适应症】") != -1) {
            int medShiIndex = str.indexOf("【适应症】");
            map.put(medShiIndex, "【适应症】");
            index.add(medShiIndex);
        }
        if (str.indexOf("【规格】") != -1) {
            int medGuiIndex = str.indexOf("【规格】");
            map.put(medGuiIndex, "【规格】");
            index.add(medGuiIndex);
        }
        if (str.indexOf("【用法用量】") != -1) {
            int medYongIndex = str.indexOf("【用法用量】");
            map.put(medYongIndex, "【用法用量】");
            index.add(medYongIndex);
        }
        if (str.indexOf("【不良反应】") != -1) {
            int medBuLiangIndex = str.indexOf("【不良反应】");
            map.put(medBuLiangIndex, "【不良反应】");
            index.add(medBuLiangIndex);
        }
        if (str.indexOf("【禁忌】") != -1) {
            int medJinIndex = str.indexOf("【禁忌】");
            map.put(medJinIndex, "【禁忌】");
            index.add(medJinIndex);
        }
        if (str.indexOf("【注意事项】") != -1) {
            int medZhuIndex = str.indexOf("【注意事项】");
            map.put(medZhuIndex, "【注意事项】");
            index.add(medZhuIndex);
        }
        if (str.indexOf("【孕妇及哺乳期妇女用药】") != -1) {
            int medYunIndex = str.indexOf("【孕妇及哺乳期妇女用药】");
            map.put(medYunIndex, "【孕妇及哺乳期妇女用药】");
            index.add(medYunIndex);
        }
        if (str.indexOf("【儿童用药】") != -1) {
            int medErIndex = str.indexOf("【儿童用药】");
            map.put(medErIndex, "【儿童用药】");
            index.add(medErIndex);
        }
        if (str.indexOf("【老年用药】") != -1) {
            int medLaoIndex = str.indexOf("【老年用药】");
            map.put(medLaoIndex, "【老年用药】");
            index.add(medLaoIndex);
        }
        if (str.indexOf("【药物相互作用】") != -1) {
            int medYaowuIndex = str.indexOf("【药物相互作用】");
            map.put(medYaowuIndex, "【药物相互作用】");
            index.add(medYaowuIndex);
        }
        if (str.indexOf("【药物过量】") != -1) {
            int medGuoIndex = str.indexOf("【药物过量】");
            map.put(medGuoIndex, "【药物过量】");
            index.add(medGuoIndex);
        }
        if (str.indexOf("【临床试验】") != -1) {
            int medLinIndex = str.indexOf("【临床试验】");
            map.put(medLinIndex, "【临床试验】");
            index.add(medLinIndex);
        }
        if (str.indexOf("【药理毒理】") != -1) {
            int medYaolIndex = str.indexOf("【药理毒理】");
            map.put(medYaolIndex, "【药理毒理】");
            index.add(medYaolIndex);
        }
        if (str.indexOf("【药代动力学】") != -1) {
            int medYaodIndex = str.indexOf("【药代动力学】");
            map.put(medYaodIndex, "【药代动力学】");
            index.add(medYaodIndex);
        }
        if (str.indexOf("【贮藏】") != -1) {
            int medChucIndex = str.indexOf("【贮藏】");
            map.put(medChucIndex, "【储藏】");
            index.add(medChucIndex);
        }
        if (str.indexOf("【包装】") != -1) {
            int medBaozIndex = str.indexOf("【包装】");
            map.put(medBaozIndex, "【包装】");
            index.add(medBaozIndex);
        }
        if (str.indexOf("【有效期】") != -1) {
            int medYouxIndex = str.indexOf("【有效期】");
            map.put(medYouxIndex, "【有效期】");
            index.add(medYouxIndex);
        }
        if (str.indexOf("【执行标准】") != -1) {
            int medZhixIndex = str.indexOf("【执行标准】");
            map.put(medZhixIndex, "【执行标准】");
            index.add(medZhixIndex);
        }
        if (str.indexOf("【批准文号】") != -1) {
            int medPizIndex = str.indexOf("【批准文号】");
            map.put(medPizIndex, "【批准文号】");
            index.add(medPizIndex);
        }
        if (str.indexOf("【生产企业】") != -1) {
            int medShengcIndex = str.indexOf("【生产企业】");
            map.put(medShengcIndex, "【生产企业】");
            index.add(medShengcIndex);
        }
        if (str.indexOf("【成份】") != -1) {
            int medChenIndex = str.indexOf("【成份】");
            map.put(medChenIndex, "【成分】");
            index.add(medChenIndex);
        }
        if (str.indexOf("【储藏】") != -1) {
            int medChucIndex = str.indexOf("【储藏】");
            map.put(medChucIndex, "【储藏】");
            index.add(medChucIndex);
        }
        Object[] in = index.toArray();
        for (int i = 0; i < in.length - 1; i++) {
            for (int j = i + 1; j < in.length; j++) {
                int temp;
                if ((Integer) in[i] > (Integer) in[j]) {
                    temp = (Integer) in[j];
                    in[j] = in[i];
                    in[i] = temp;
                }
            }
        }
        for (int i = 0; i < in.length; i++) {
            String med = map.get(in[i]);
            System.out.println(map.get(in[i]));
            if (i < in.length - 1) {
                if (med.equals("【药品名称】")) {
                    String medName = str.substring((Integer) in[i] + med.length(), (Integer) in[i + 1]);
                    HashMap<Integer, String> mapMedName = new HashMap<Integer, String>();
                    List<Integer> indexMedName = Lists.newArrayList();
                    if (medName.indexOf("通用名称") != -1) {
                        int a = medName.indexOf("通用名称");
                        indexMedName.add(a);
                        mapMedName.put(a, "通用名称");
                    }
                    if (medName.indexOf("英文名称") != -1) {
                        int a = medName.indexOf("英文名称");
                        indexMedName.add(a);
                        mapMedName.put(a, "英文名称");
                    }
                    if (medName.indexOf("拼音名称") != -1) {
                        int a = medName.indexOf("拼音名称");
                        indexMedName.add(a);
                        mapMedName.put(a, "拼音名称");
                    }
                    Object[] names = indexMedName.toArray();
                    for (int k = 0; k < names.length - 1; k++) {
                        for (int j = k + 1; j < names.length; j++) {
                            int temp;
                            if ((Integer) names[k] > (Integer) names[j]) {
                                temp = (Integer) names[j];
                                names[j] = names[k];
                                names[k] = temp;
                            }
                        }
                    }
                    for (int j = 0; j < names.length; j++) {
                        String medName1 = mapMedName.get((Integer) names[j]);
                        if (j < names.length - 1) {
                            if (medName1.equals("通用名称")) {
                                String medicalNameChina = medName.substring((Integer) names[j] + medName1.length(),
                                        (Integer) names[j + 1]);
                                sicmedMedical.setMedicalNameChina(medicalNameChina);
                            } else if (medName1.equals("英文名称")) {
                                String medicalNameEnglish = medName.substring((Integer) names[j] + medName1.length(),
                                        (Integer) names[j + 1]);
                                sicmedMedical.setMedicalNameEnglish(medicalNameEnglish);
                            } else if (medName1.equals("拼音名称")) {
                                String medicalNamePinyin = medName.substring((Integer) names[j] + medName1.length(),
                                        (Integer) names[j + 1]);
                                sicmedMedical.setMedicalNamePinyin(medicalNamePinyin);
                            }
                        } else {
                            if (medName1.equals("通用名称")) {
                                String medicalNameChina = medName.substring((Integer) names[j] + medName1.length());
                                sicmedMedical.setMedicalNameChina(medicalNameChina);
                            } else if (medName1.equals("英文名称")) {
                                String medicalNameEnglish = medName.substring((Integer) names[j] + medName1.length());
                                sicmedMedical.setMedicalNameEnglish(medicalNameEnglish);
                            } else if (medName1.equals("拼音名称")) {
                                String medicalNamePinyin = medName.substring((Integer) names[j] + medName1.length());
                                sicmedMedical.setMedicalNamePinyin(medicalNamePinyin);
                            }
                        }
                    }
                } else if (med.equals("【成分】")) {
                    String medicalIngredient = str.substring((Integer) in[i] + med.length(), (Integer) in[i + 1]);
                    sicmedMedical.setMedicalIngredient(medicalIngredient);
                } else if (med.equals("【性状】")) {
                    String medicalTraits = str.substring((Integer) in[i] + med.length(), (Integer) in[i + 1]);
                    if (medicalTraits.indexOf("胶囊") != -1 || medicalTraits.indexOf("片") != -1
                            || medicalTraits.indexOf("膏") != -1 || medicalTraits.indexOf("颗粒") != -1) {
                        sicmedMedical.setUnit1("盒");
                    } else if (medicalTraits.indexOf("结晶") != -1 || medicalTraits.indexOf("粉末") != -1
                            || medicalTraits.indexOf("液体") != -1 || medicalTraits.indexOf("块状物") != -1) {
                        sicmedMedical.setUnit1("支");
                    } else if (medicalTraits.indexOf("颗粒") != -1) {
                        sicmedMedical.setUnit1("盒");
                    }
                    sicmedMedical.setMedicalTraits(medicalTraits);
                } else if (med.equals("【适应症】")) {
                    String medicalIndications = str.substring((Integer) in[i] + med.length(), (Integer) in[i + 1]);
                    sicmedMedical.setMedicalIndications(medicalIndications);
                } else if (med.equals("【规格】")) {
                    String medicalSpecification = str.substring((Integer) in[i] + med.length(), (Integer) in[i + 1]);
                    sicmedMedical.setMedicalSpecification(medicalSpecification);
                } else if (med.equals("【用法用量】")) {
                    String medicalDosageUsage = str.substring((Integer) in[i] + med.length(), (Integer) in[i + 1]);
                    sicmedMedical.setMedicalDosageUsage(medicalDosageUsage);
                } else if (med.equals("【不良反应】")) {
                    String medicalAdverseReactions = str.substring((Integer) in[i] + med.length(), (Integer) in[i + 1]);
                    sicmedMedical.setMedicalAdverseReactions(medicalAdverseReactions);
                } else if (med.equals("【禁忌】")) {
                    String medicalTaboo = str.substring((Integer) in[i] + med.length(), (Integer) in[i + 1]);
                    sicmedMedical.setMedicalTaboo(medicalTaboo);
                } else if (med.equals("【注意事项】")) {
                    String medicalPrecautions = str.substring((Integer) in[i] + med.length(), (Integer) in[i + 1]);
                    sicmedMedical.setMedicalPrecautions(medicalPrecautions);
                } else if (med.equals("【孕妇及哺乳期妇女用药】")) {
                    String medicalPregnantWomenLactatingWomen = str.substring((Integer) in[i] + med.length(),
                            (Integer) in[i + 1]);
                    sicmedMedical.setMedicalPregnantWomenLactatingWomen(medicalPregnantWomenLactatingWomen);
                } else if (med.equals("【儿童用药】")) {
                    String medicalPediatricUse = str.substring((Integer) in[i] + med.length(), (Integer) in[i + 1]);
                    sicmedMedical.setMedicalPediatricUse(medicalPediatricUse);
                } else if (med.equals("【老年用药】")) {
                    String medicalElderlyMedication = str.substring((Integer) in[i] + med.length(),
                            (Integer) in[i + 1]);
                    sicmedMedical.setMedicalElderlyMedication(medicalElderlyMedication);
                } else if (med.equals("【药物相互作用】")) {
                    String medicalMedicineInteractions = str.substring((Integer) in[i] + med.length(),
                            (Integer) in[i + 1]);
                    sicmedMedical.setMedicalMedicineInteractions(medicalMedicineInteractions);
                } else if (med.equals("【药物过量】")) {
                    String medicalDrugOverdose = str.substring((Integer) in[i] + med.length(), (Integer) in[i + 1]);
                    sicmedMedical.setMedicalDrugOverdose(medicalDrugOverdose);
                } else if (med.equals("【临床试验】")) {
                    String medicalClinicalTrials = str.substring((Integer) in[i] + med.length(), (Integer) in[i + 1]);
                    sicmedMedical.setMedicalClinicalTrials(medicalClinicalTrials);
                } else if (med.equals("【药理毒理】")) {
                    String medicalPharmacologyToxicology = str.substring((Integer) in[i] + med.length(),
                            (Integer) in[i + 1]);
                    sicmedMedical.setMedicalPharmacologyToxicology(medicalPharmacologyToxicology);
                } else if (med.equals("【药代动力学】")) {
                    String medicalPharmacokinetics = str.substring((Integer) in[i] + med.length(), (Integer) in[i + 1]);
                    sicmedMedical.setMedicalPharmacokinetics(medicalPharmacokinetics);
                } else if (med.equals("【储藏】")) {
                    String medicalStorage = str.substring((Integer) in[i] + med.length(), (Integer) in[i + 1]);
                    sicmedMedical.setMedicalStorage(medicalStorage);
                } else if (med.equals("【包装】")) {
                    String medicalPackage = str.substring((Integer) in[i] + med.length(), (Integer) in[i + 1]);
                    sicmedMedical.setMedicalPackage(medicalPackage);
                } else if (med.equals("【有效期】")) {
                    String medicalPeriodValidity = str.substring((Integer) in[i] + med.length(), (Integer) in[i + 1]);
                    sicmedMedical.setMedicalPeriodValidity(medicalPeriodValidity);
                } else if (med.equals("【执行标准】")) {
                    String medicalImplementationStandards = str.substring((Integer) in[i] + med.length(),
                            (Integer) in[i + 1]);
                    sicmedMedical.setMedicalImplementationStandards(medicalImplementationStandards);
                } else if (med.equals("【批准文号】")) {
                    String medicalApprovalNumber = str.substring((Integer) in[i] + med.length(), (Integer) in[i + 1]);
                    sicmedMedical.setMedicalApprovalNumber(medicalApprovalNumber);
                } else if (med.equals("【生产企业】")) {
                    String medicalManufacturer = str.substring((Integer) in[i] + med.length(), (Integer) in[i + 1]);
                    sicmedMedical.setMedicalManufacturer(medicalManufacturer);
                }
            } else {
                if (med.equals("【药品名称】")) {
                    String medName = str.substring((Integer) in[i] + med.length());
                    HashMap<Integer, String> mapMedName = new HashMap<Integer, String>();
                    List<Integer> indexMedName = Lists.newArrayList();
                    if (medName.indexOf("通用名称") != -1) {
                        int a = medName.indexOf("通用名称");
                        indexMedName.add(a);
                        mapMedName.put(a, "通用名称");
                    }
                    if (medName.indexOf("英文名称") != -1) {
                        int a = medName.indexOf("英文名称");
                        indexMedName.add(a);
                        mapMedName.put(a, "英文名称");
                    }
                    if (medName.indexOf("拼音名称") != -1) {
                        int a = medName.indexOf("拼音名称");
                        indexMedName.add(a);
                        mapMedName.put(a, "拼音名称");
                    }
                    Object[] names = indexMedName.toArray();
                    for (int k = 0; k < names.length - 1; k++) {
                        for (int j = k + 1; j < names.length; j++) {
                            int temp;
                            if ((Integer) names[k] > (Integer) names[j]) {
                                temp = (Integer) names[j];
                                names[j] = names[k];
                                names[k] = temp;
                            }
                        }
                    }
                    for (int j = 0; j < names.length; j++) {
                        String medName1 = mapMedName.get((Integer) names[j]);
                        if (j < names.length - 1) {
                            if (medName1.equals("通用名称")) {
                                String medicalNameChina = medName.substring((Integer) names[j] + medName1.length(),
                                        (Integer) names[j + 1]);
                                sicmedMedical.setMedicalNameChina(medicalNameChina);
                            } else if (medName1.equals("英文名称")) {
                                String medicalNameEnglish = medName.substring((Integer) names[j] + medName1.length(),
                                        (Integer) names[j + 1]);
                                sicmedMedical.setMedicalNameEnglish(medicalNameEnglish);
                            } else if (medName1.equals("拼音名称")) {
                                String medicalNamePinyin = medName.substring((Integer) names[j] + medName1.length(),
                                        (Integer) names[j + 1]);
                                sicmedMedical.setMedicalNamePinyin(medicalNamePinyin);
                            }
                        } else {
                            if (medName1.equals("通用名称")) {
                                String medicalNameChina = medName.substring((Integer) names[j] + medName1.length());
                                sicmedMedical.setMedicalNameChina(medicalNameChina);
                            } else if (medName1.equals("英文名称")) {
                                String medicalNameEnglish = medName.substring((Integer) names[j] + medName1.length());
                                sicmedMedical.setMedicalNameEnglish(medicalNameEnglish);
                            } else if (medName1.equals("拼音名称")) {
                                String medicalNamePinyin = medName.substring((Integer) names[j] + medName1.length());
                                sicmedMedical.setMedicalNamePinyin(medicalNamePinyin);
                            }
                        }

                    }
                } else if (med.equals("【成分】")) {
                    String medicalIngredient = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalIngredient(medicalIngredient);
                } else if (med.equals("【性状】")) {
                    String medicalTraits = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalTraits(medicalTraits);
                } else if (med.equals("【适应症】")) {
                    String medicalIndications = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalIndications(medicalIndications);
                } else if (med.equals("【规格】")) {
                    String medicalSpecification = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalSpecification(medicalSpecification);
                } else if (med.equals("【用法用量】")) {
                    String medicalDosageUsage = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalDosageUsage(medicalDosageUsage);
                } else if (med.equals("【不良反应】")) {
                    String medicalAdverseReactions = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalAdverseReactions(medicalAdverseReactions);
                } else if (med.equals("【禁忌】")) {
                    String medicalTaboo = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalTaboo(medicalTaboo);
                } else if (med.equals("【注意事项】")) {
                    String medicalPrecautions = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalPrecautions(medicalPrecautions);
                } else if (med.equals("【孕妇及哺乳期妇女用药】")) {
                    String medicalPregnantWomenLactatingWomen = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalPregnantWomenLactatingWomen(medicalPregnantWomenLactatingWomen);
                } else if (med.equals("【儿童用药】")) {
                    String medicalPediatricUse = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalPediatricUse(medicalPediatricUse);
                } else if (med.equals("【老年用药】")) {
                    String medicalElderlyMedication = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalElderlyMedication(medicalElderlyMedication);
                } else if (med.equals("【药物相互作用】")) {
                    String medicalMedicineInteractions = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalMedicineInteractions(medicalMedicineInteractions);
                } else if (med.equals("【药物过量】")) {
                    String medicalDrugOverdose = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalDrugOverdose(medicalDrugOverdose);
                } else if (med.equals("【临床试验】")) {
                    String medicalClinicalTrials = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalClinicalTrials(medicalClinicalTrials);
                } else if (med.equals("【药理毒理】")) {
                    String medicalPharmacologyToxicology = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalPharmacologyToxicology(medicalPharmacologyToxicology);
                } else if (med.equals("【药代动力学】")) {
                    String medicalPharmacokinetics = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalPharmacokinetics(medicalPharmacokinetics);
                } else if (med.equals("【储藏】")) {
                    String medicalStorage = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalStorage(medicalStorage);
                } else if (med.equals("【包装】")) {
                    String medicalPackage = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalPackage(medicalPackage);
                } else if (med.equals("【有效期】")) {
                    String medicalPeriodValidity = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalPeriodValidity(medicalPeriodValidity);
                } else if (med.equals("【执行标准】")) {
                    String medicalImplementationStandards = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalImplementationStandards(medicalImplementationStandards);
                } else if (med.equals("【批准文号】")) {
                    String medicalApprovalNumber = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalApprovalNumber(medicalApprovalNumber);
                } else if (med.equals("【生产企业】")) {
                    String medicalManufacturer = str.substring((Integer) in[i] + med.length());
                    sicmedMedical.setMedicalManufacturer(medicalManufacturer);
                }
            }

        }
        sicmedMedicalService.save(sicmedMedical);
    }

    /**
     * 维护药品编号
     */
    @ResponseBody
    @RequestMapping(value = "updateMC")
    public void updateMC() {
        // 创建查询条件
        SicmedMedical sicmedMedical = new SicmedMedical();
        sicmedMedical.setMedicalGroup("0");
        // 调用service方法查询药品信息
        List<SicmedMedical> sicmedMedicals = sicmedMedicalService.findList(sicmedMedical);
        int i = 0;
        for (SicmedMedical sicmedMedical2 : sicmedMedicals) {
            StringBuffer str = new StringBuffer();
            str.append("MED");
            i = i + 1;
            if (i < 10) {
                str.append("0000");
                str.append(i);
            } else if (i >= 10 && i < 100) {
                str.append("000");
                str.append(i);
            } else if (i >= 100 && i < 1000) {
                str.append("00");
                str.append(i);
            } else if (i >= 1000 && i < 10000) {
                str.append("0");
                str.append(i);
            }
            sicmedMedical2.setMedicalCode(str.toString());
            sicmedMedicalService.update(sicmedMedical2);
        }
    }

    /**
     * 维护类别
     */
    @ResponseBody
    @RequestMapping(value = "updateUnit2")
    public void updateUnit2() {
        // 创建查询条件
        SicmedMedical sicmedMedical = new SicmedMedical();
        sicmedMedical.setMedicalGroup("0");
        // 调用service方法查询药品信息
        List<SicmedMedical> sicmedMedicals = sicmedMedicalService.findList(sicmedMedical);
        for (SicmedMedical sicmedMedical2 : sicmedMedicals) {
            String unti2 = "";
            if (sicmedMedical2.getMedicalGroup().equals("8")) {
                sicmedMedical2.setUnit1("");
                unti2 = "g";
            } else if (sicmedMedical2.getMedicalGroup().equals("0") && sicmedMedical2.getMedicalDosageUsage() != null) {
                String str = sicmedMedical2.getMedicalDosageUsage();
                if (str.indexOf("温水冲服") > -1 && "袋".indexOf("袋") > -1) {
                    unti2 = "袋";
                } else if (str.indexOf("喷") > -1) {
                    unti2 = "次";
                } else if (str.indexOf("贴") > -1) {
                    unti2 = "贴";
                } else if (str.indexOf("粒") > -1) {
                    unti2 = "粒";
                } else if (str.indexOf("包") > -1) {
                    unti2 = "粒";
                } else if (str.indexOf("包") > -1) {
                    unti2 = "包";
                } else if (str.indexOf("片") > -1) {
                    unti2 = "片";
                } else if (str.indexOf("温水冲服") > -1 && str.indexOf("包") > -1) {
                    unti2 = "包";
                } else if (str.indexOf("温水冲服") > -1 && str.indexOf("片") > -1) {
                    unti2 = "片";
                } else if (str.indexOf("温水冲服") > -1 && str.indexOf("mg") > -1) {
                    unti2 = "mg";
                } else if (str.indexOf("温水冲服") > -1 && str.indexOf("g") > -1) {
                    unti2 = "g";
                } else if (str.indexOf("温水冲服") > -1 && str.indexOf("ml") > -1) {
                    unti2 = "ml";
                } else if (str.indexOf("餐前口服") > -1 && str.indexOf("袋") > -1) {
                    unti2 = "袋";
                } else if (str.indexOf("餐前口服") > -1 && str.indexOf("包") > -1) {
                    unti2 = "包";
                } else if (str.indexOf("餐前口服") > -1 && str.indexOf("片") > -1) {
                    unti2 = "片";
                } else if (str.indexOf("餐前口服") > -1 && str.indexOf("支") > -1) {
                    unti2 = "支";
                } else if (str.indexOf("餐前口服") > -1 && str.indexOf("mg") > -1) {
                    unti2 = "mg";
                } else if (str.indexOf("餐前口服") > -1 && str.indexOf("g") > -1) {
                    unti2 = "g";
                } else if (str.indexOf("餐前口服") > -1 && str.indexOf("ml") > -1) {
                    unti2 = "ml";
                } else if (str.indexOf("静脉注射") > -1 && str.indexOf("ml") > -1) {
                    unti2 = "ml";
                } else if (str.indexOf("静脉注射") > -1 && str.indexOf("mg") > -1) {
                    unti2 = "mg";
                } else if (str.indexOf("静脉注射") > -1 && str.indexOf("g") > -1) {
                    unti2 = "g";
                } else if (str.indexOf("静脉注射") > -1 && str.indexOf("万单位") > -1) {
                    unti2 = "iu";
                } else if (str.indexOf("肌内注射") > -1 && str.indexOf("万单位") > -1) {
                    unti2 = "iu";
                } else if (str.indexOf("肌内注射") > -1 && str.indexOf("ml") > -1) {
                    unti2 = "ml";
                } else if (str.indexOf("肌内注射") > -1 && str.indexOf("mg") > -1) {
                    unti2 = "mg";
                } else if (str.indexOf("肌内注射") > -1 && str.indexOf("g") > -1) {
                    unti2 = "g";
                } else if (str.indexOf("皮下注射") > -1 && str.indexOf("万单位") > -1) {
                    unti2 = "iu";
                } else if (str.indexOf("皮下注射") > -1 && str.indexOf("ml") > -1) {
                    unti2 = "ml";
                } else if (str.indexOf("皮下注射") > -1 && str.indexOf("mg") > -1) {
                    unti2 = "mg";
                } else if (str.indexOf("皮下注射") > -1 && str.indexOf("g") > -1) {
                    unti2 = "g";
                } else if (str.indexOf("静脉滴注") > -1 && str.indexOf("万单位") > -1) {
                    unti2 = "iu";
                } else if (str.indexOf("静脉滴注") > -1 && str.indexOf("ml") > -1) {
                    unti2 = "ml";
                } else if (str.indexOf("静脉滴注") > -1 && str.indexOf("mg") > -1) {
                    unti2 = "mg";
                } else if (str.indexOf("静脉滴注") > -1 && str.indexOf("g") > -1) {
                    unti2 = "g";
                } else if (str.indexOf("阴道给药") > -1 && str.indexOf("片") > -1) {
                    unti2 = "片";
                } else if (str.indexOf("阴道给药") > -1 && str.indexOf("枚") > -1) {
                    unti2 = "枚";
                } else if (str.indexOf("直肠给药") > -1 && str.indexOf("片") > -1) {
                    unti2 = "片";
                } else if (str.indexOf("直肠给药") > -1 && str.indexOf("枚") > -1) {
                    unti2 = "枚";
                } else if (str.indexOf("口服") > -1 && str.indexOf("片") > -1) {
                    unti2 = "片";
                } else if (str.indexOf("口服") > -1 && str.indexOf("粒") > -1) {
                    unti2 = "粒";
                } else if (str.indexOf("口服") > -1 && str.indexOf("包") > -1) {
                    unti2 = "包";
                } else if (str.indexOf("口服") > -1 && str.indexOf("支") > -1) {
                    unti2 = "支";
                } else if (str.indexOf("口服") > -1 && str.indexOf("袋") > -1) {
                    unti2 = "袋";
                } else if (str.indexOf("口服") > -1 && str.indexOf("ml") > -1) {
                    unti2 = "ml";
                } else if (str.indexOf("口服") > -1 && str.indexOf("mg") > -1) {
                    unti2 = "mg";
                } else if (str.indexOf("口服") > -1 && str.indexOf("g") > -1) {
                    unti2 = "g";
                } else if (str.indexOf("口服") > -1 && str.indexOf("毫克") > -1) {
                    unti2 = "mg";
                } else if (str.indexOf("外用") > -1 && str.indexOf("mg") > -1) {
                    unti2 = "mg";
                } else if (str.indexOf("外用") > -1 && str.indexOf("g") > -1) {
                    unti2 = "g";
                } else if (str.indexOf("注入") > -1 && str.indexOf("ml") > -1) {
                    unti2 = "ml";
                } else if (str.indexOf("滴眼") > -1 && str.indexOf("滴") > -1) {
                    unti2 = "滴";
                } else if (str.indexOf("滴鼻") > -1 && str.indexOf("滴") > -1) {
                    unti2 = "滴";
                } else if (str.indexOf("漱口") > -1 && str.indexOf("ml") > -1) {
                    unti2 = "ml";
                } else if (str.indexOf("涂") > -1 && str.indexOf("mg") > -1) {
                    unti2 = "mg";
                } else if (str.indexOf("涂") > -1 && str.indexOf("g") > -1) {
                    unti2 = "g";
                } else if (str.indexOf("滴注") > -1 && str.indexOf("mg") > -1) {
                    unti2 = "mg";
                } else if (str.indexOf("滴注") > -1 && str.indexOf("ml") > -1) {
                    unti2 = "ml";
                } else if (str.indexOf("滴注") > -1 && str.indexOf("g") > -1) {
                    unti2 = "g";
                } else if (str.indexOf("注射液") > -1 && str.indexOf("ml") > -1) {
                    unti2 = "ml";
                } else if (str.indexOf("注射液") > -1 && str.indexOf("mg") > -1) {
                    unti2 = "ml";
                } else if (str.indexOf("注射液") > -1 && str.indexOf("mg") > -1) {
                    unti2 = "mg";
                } else if (str.indexOf("冲服") > -1 && str.indexOf("包") > -1) {
                    unti2 = "包";
                } else if (str.indexOf("冲服") > -1 && str.indexOf("片") > -1) {
                    unti2 = "片";
                } else if (str.indexOf("含化") > -1 && str.indexOf("片") > -1) {
                    unti2 = "片";
                }
            }
            sicmedMedical2.setUnit2(unti2);
            sicmedMedicalService.update(sicmedMedical2);
        }
    }

    /**
     * 维护类别
     */
    @ResponseBody
    @RequestMapping(value = "updateClassOne")
    public void updateClassOne() {
        // 创建查询条件
        SicmedMedical sicmedMedical = new SicmedMedical();
        sicmedMedical.setMedicalGroup("1");
        SicmedMedicalClass sicmedMedicalClassOne = new SicmedMedicalClass();
        sicmedMedicalClassOne.setName("中药");
        sicmedMedicalClassOne = sicmedMedicalClassService.get(sicmedMedicalClassOne);
        // 调用service方法查询药品信息
        List<SicmedMedical> sicmedMedicals = sicmedMedicalService.findList(sicmedMedical);
        for (SicmedMedical sicmedMedical2 : sicmedMedicals) {
            if (sicmedMedical2.getMedicalCode().indexOf("HMED") > -1) {
                sicmedMedical2.setMedicalClassOne(sicmedMedicalClassOne);
                sicmedMedical2.setMedicalGroup("8");
            } else if (sicmedMedical2.getMedicalCode().indexOf("CMED") > -1) {
                sicmedMedical2.setMedicalClassOne(sicmedMedicalClassOne);
                sicmedMedical2.setMedicalGroup("6");
            }
            sicmedMedicalService.update(sicmedMedical2);
        }
    }

    /**
     * 删除所有 单位不合格药品
     */
    @ResponseBody
    @RequestMapping(value = "delUnitlNull")
    public void delUnitlNull() {
        // 创建查询条件
        SicmedMedical sicmedMedical = new SicmedMedical();
        sicmedMedical.setMedicalGroup("0");
        // 调用service方法查询药品信息
        List<SicmedMedical> sicmedMedicals = sicmedMedicalService.findList(sicmedMedical);
        for (SicmedMedical sicmedMedical2 : sicmedMedicals) {
            if (sicmedMedical2.getUnit1() == null || sicmedMedical2.getUnit2() == null || sicmedMedical2.getUnit1() == "" || sicmedMedical2.getUnit2() == "") {
                sicmedMedicalService.delete(sicmedMedical2);
            } else {

            }
        }
        sicmedMedical.setMedicalGroup("1");
        // 调用service方法查询药品信息
        List<SicmedMedical> sicmedMedicals2 = sicmedMedicalService.findList(sicmedMedical);
        for (SicmedMedical sicmedMedical2 : sicmedMedicals2) {
            if (sicmedMedical2.getUnit1() == null || sicmedMedical2.getUnit2() == null || sicmedMedical2.getUnit1() == "" || sicmedMedical2.getUnit2() == "") {
                sicmedMedicalService.delete(sicmedMedical2);
            } else {

            }
        }

        sicmedMedical.setMedicalGroup("6");
        // 调用service方法查询药品信息
        List<SicmedMedical> sicmedMedicals3 = sicmedMedicalService.findList(sicmedMedical);
        for (SicmedMedical sicmedMedical2 : sicmedMedicals3) {
            sicmedMedicalService.delete(sicmedMedical2);
        }
    }


    /**
     * 维护药品价格
     */
    @ResponseBody
    @RequestMapping(value = "updateMedPrice")
    public void updateMedPrice() {
        // 创建查询条件
        SicmedMedical sicmedMedical = new SicmedMedical();
        sicmedMedical.setMedicalGroup("0");
        // 调用service方法查询药品信息
        List<SicmedMedical> sicmedMedicals = sicmedMedicalService.findList(sicmedMedical);
        for (SicmedMedical sicmedMedical2 : sicmedMedicals) {
            SicmedMedicalPrice sicmedMedicalPrice = new SicmedMedicalPrice();
            sicmedMedicalPrice.setSicmedMedical(sicmedMedical2);
            sicmedMedicalPrice.setPriceEnter("1");
            sicmedMedicalPrice.setPriceSale("2");

            sicmedMedicalPriceService.save(sicmedMedicalPrice);
        }
    }
}