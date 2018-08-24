package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.cfq.common.Page;
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


import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalClassBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalClassBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalClass;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedMedicalClassService;

/**
 * 药品分类Controller
 *
 * @author XUE
 * @version 2016-09-02
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedMedicalClass")
public class SicmedMedicalClassController extends BaseController {

    @Autowired
    private SicmedMedicalClassService sicmedMedicalClassService;

    @ResponseBody
    @RequestMapping(value = "findAll")
    public BaseBean findAll() {
        // 创建返回对象
        SicmedMedicalClassBeans sicmedMedicalClassBeans = new SicmedMedicalClassBeans();
        // 创建查询参数
        SicmedMedicalClass sicmedMedicalClass = new SicmedMedicalClass();
        SicmedMedicalClass p = new SicmedMedicalClass();
        sicmedMedicalClass.setParent(p);
        sicmedMedicalClass.getParent().getId();
        // 调用service方法查询
        List<SicmedMedicalClass> sicmedMedicalClasses = sicmedMedicalClassService.findAllList();
        // 查询结果校验
        if (sicmedMedicalClasses.size() > 0) {
            for (SicmedMedicalClass sicmedMedicalClass2 : sicmedMedicalClasses) {
                SicmedMedicalClassBean sicmedMedicalClassBean = new SicmedMedicalClassBean();
                sicmedMedicalClassBean.setSMCB(sicmedMedicalClass2);
                sicmedMedicalClassBeans.getSicmedMedicalClassBeans().add(sicmedMedicalClassBean);
            }
            sicmedMedicalClassBeans.setError("0");
            sicmedMedicalClassBeans.setErrorMessage("查询成功");
            return sicmedMedicalClassBeans;
        } else {
            sicmedMedicalClassBeans.setError("1");
            sicmedMedicalClassBeans.setErrorMessage("查询失败 结果为空");
            return sicmedMedicalClassBeans;
        }
    }

    @ResponseBody
    @RequestMapping(value = "findOne")
    public BaseBean findOne() {
        // 创建返回对象
        SicmedMedicalClassBeans sicmedMedicalClassBeans = new SicmedMedicalClassBeans();
        // 创建查询参数
        SicmedMedicalClass sicmedMedicalClass = new SicmedMedicalClass();
        sicmedMedicalClass.setParentIds("0");
        // 调用service方法查询
        List<SicmedMedicalClass> sicmedMedicalClasses = sicmedMedicalClassService.findList(sicmedMedicalClass);
        // 查询结果校验
        if (sicmedMedicalClasses.size() > 0) {
            for (SicmedMedicalClass sicmedMedicalClass2 : sicmedMedicalClasses) {
                SicmedMedicalClassBean sicmedMedicalClassBean = new SicmedMedicalClassBean();
                sicmedMedicalClassBean.setSMCB(sicmedMedicalClass2);
                sicmedMedicalClassBeans.getSicmedMedicalClassBeans().add(sicmedMedicalClassBean);
            }
            sicmedMedicalClassBeans.setError("0");
            sicmedMedicalClassBeans.setErrorMessage("查询成功");
            return sicmedMedicalClassBeans;
        } else {
            sicmedMedicalClassBeans.setError("1");
            sicmedMedicalClassBeans.setErrorMessage("查询失败 结果为空");
            return sicmedMedicalClassBeans;
        }
    }

    @ResponseBody
    @RequestMapping(value = "findchild")
    public BaseBean findchild(String pid) {
        // 创建返回对象
        SicmedMedicalClassBeans sicmedMedicalClassBeans = new SicmedMedicalClassBeans();
        // 创建查询参数
        SicmedMedicalClass sicmedMedicalClass = new SicmedMedicalClass();
        SicmedMedicalClass parent = new SicmedMedicalClass();
        parent.setId(pid);
        parent = sicmedMedicalClassService.get(parent);
        sicmedMedicalClass.setParent(parent);
        // 调用service方法查询
        List<SicmedMedicalClass> sicmedMedicalClasses = sicmedMedicalClassService.findList(sicmedMedicalClass);
        // 查询结果校验
        if (sicmedMedicalClasses.size() > 0) {
            for (SicmedMedicalClass sicmedMedicalClass2 : sicmedMedicalClasses) {
                SicmedMedicalClassBean sicmedMedicalClassBean = new SicmedMedicalClassBean();
                sicmedMedicalClassBean.setSMCB(sicmedMedicalClass2);
                sicmedMedicalClassBeans.getSicmedMedicalClassBeans().add(sicmedMedicalClassBean);
            }
            sicmedMedicalClassBeans.setError("0");
            sicmedMedicalClassBeans.setErrorMessage("查询成功");
            return sicmedMedicalClassBeans;
        } else {
            sicmedMedicalClassBeans.setError("1");
            sicmedMedicalClassBeans.setErrorMessage("查询失败 结果为空");
            return sicmedMedicalClassBeans;
        }
    }

    @ModelAttribute
    public SicmedMedicalClass get(@RequestParam(required = false) String id) {
        SicmedMedicalClass entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = sicmedMedicalClassService.get(id);
        }
        if (entity == null) {
            entity = new SicmedMedicalClass();
        }
        return entity;
    }

    @RequiresPermissions("rest:sicmedMedicalClass:view")
    @RequestMapping(value = {"list", ""})
    public String list(SicmedMedicalClass sicmedMedicalClass, HttpServletRequest request, HttpServletResponse response,
                       Model model) {
        Page<SicmedMedicalClass> page = sicmedMedicalClassService
                .findPage(new Page<SicmedMedicalClass>(request, response), sicmedMedicalClass);
        model.addAttribute("page", page);
        return "mobile/rest/sicmedMedicalClassList";
    }

    @RequiresPermissions("rest:sicmedMedicalClass:view")
    @RequestMapping(value = "form")
    public String form(SicmedMedicalClass sicmedMedicalClass, Model model) {
        model.addAttribute("sicmedMedicalClass", sicmedMedicalClass);
        return "mobile/rest/sicmedMedicalClassForm";
    }

    @RequiresPermissions("rest:sicmedMedicalClass:edit")
    @RequestMapping(value = "save")
    public String save(SicmedMedicalClass sicmedMedicalClass, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, sicmedMedicalClass)) {
            return form(sicmedMedicalClass, model);
        }
        sicmedMedicalClassService.save(sicmedMedicalClass);
        addMessage(redirectAttributes, "保存药品类别成功");
        return "redirect:" + Global.getAdminPath() + "/web/sicmedMedicalClass/?repage";
    }

    @RequiresPermissions("rest:sicmedMedicalClass:edit")
    @RequestMapping(value = "delete")
    public String delete(SicmedMedicalClass sicmedMedicalClass, RedirectAttributes redirectAttributes) {
        sicmedMedicalClassService.delete(sicmedMedicalClass);
        addMessage(redirectAttributes, "删除药品类别成功");
        return "redirect:" + Global.getAdminPath() + "/web/sicmedMedicalClass/?repage";
    }

    /**
     * 药品类别初始化
     */
    // 一级分类
    @ResponseBody
    @RequestMapping(value = "addAllClass1")
    public void addAllClass1() {
        String strs[] = {"中药", "西药"};
        int i = 1;
        for (String string : strs) {
            StringBuffer medicalCode = new StringBuffer();
            medicalCode.append("MEDC");
            if (i < 10) {
                medicalCode.append("000");
                medicalCode.append(i);
            } else {
                medicalCode.append("00");
                medicalCode.append(i);
            }
            SicmedMedicalClass sicmedMedicalClass = new SicmedMedicalClass();
            sicmedMedicalClass.setCode(medicalCode.toString());
            sicmedMedicalClass.setName(string);
            sicmedMedicalClass.setParentIds("0");
            sicmedMedicalClassService.save(sicmedMedicalClass);
            i = i + 1;
        }
        addAllClass2();
        addAllClass3();
    }

    //二级分类
    public void addAllClass2() {
        SicmedMedicalClass sicmedMedicalClassParent = new SicmedMedicalClass();
        sicmedMedicalClassParent.setName("西药");
        sicmedMedicalClassParent = sicmedMedicalClassService.get(sicmedMedicalClassParent);
        String strs[] = {"抗生素药", "抗寄生虫病药", "抗肿瘤药物", "麻醉药及麻醉辅助用药 ", "镇痛、解热、抗炎、抗风湿", "治疗神经系统疾病药 ", "治疗精神障碍药", "心血管系统用药 ",
                "呼吸系统用药", "消化系统用药", "泌尿系统用药", "血液系统用药", "激素及影响内分泌药", "抗变态反应药", "免疫系统用药", "维生素、矿物质及肠营养药 ",
                "调节水盐、电解质及酸碱平衡", "解毒药", "预防用生物制品", "放射性药物", "诊断用药", "计划生育用药", "消毒防腐药", "皮肤科用药", "眼科用药", "耳鼻喉、口腔科用药",
                "妇产科用药", "骨科用药 ", "生物制品", "肛肠科用药", "妇科非激素类药物", "男科用药"};
        int i = 1;
        for (String string : strs) {
            StringBuffer medicalCode = new StringBuffer();
            medicalCode.append("HXYP");
            if (i < 10) {
                medicalCode.append("000");
                medicalCode.append(i);
            } else {
                medicalCode.append("00");
                medicalCode.append(i);
            }
            SicmedMedicalClass sicmedMedicalClass = new SicmedMedicalClass();
            sicmedMedicalClass.setCode(medicalCode.toString());
            sicmedMedicalClass.setName(string);
            sicmedMedicalClass.setParent(sicmedMedicalClassParent);
            sicmedMedicalClass.setParentIds("1");
            sicmedMedicalClassService.save(sicmedMedicalClass);
            i = i + 1;
        }

        String parentName1 = "抗生素药";
        String child1[] = {"青霉素类抗生素", "头孢菌素类抗生素", "碳青霉烯类抗生素", "氨基糖苷类抗生素", "四环素类抗生素", "大环内酯类抗生素", "其他类抗生素抗生素", "磺胺类抗生素",
                "喹诺酮类抗生素", "其他类抗生素", "磺胺类抗生素", "抗麻风病类抗生素", "抗真菌类抗生素", "抗病毒类抗生素", "内酰胺酶抑制剂复合物类抗生素", "林可酰胺类抗生素", "糖肽类抗生素",
                "假单胞酸类抗生素", "硝基咪唑类抗生素", "氨基环多醇类抗生素", "青霉烯类抗生素", "单环内酰胺类抗生素", "磷霉素类抗生素"};
        addAllClassChild(parentName1, child1, "KSSY");

        String parentName2 = "抗寄生虫病药";
        String child2[] = {"抗疟药", "抗阿米巴病药及抗滴虫病药", "抗黑热病药", "抗吸虫病药及抗丝虫病药", "驱肠虫药", "其他寄生虫病药"};
        addAllClassChild(parentName2, child2, "KJSC");

        String parentName3 = "抗肿瘤药物";
        String child3[] = {"铂类化合物类抗肿瘤药物", "烷化剂类抗肿瘤药物", "抗代谢药类抗肿瘤药物", "抗肿瘤类抗生素", "抗肿瘤植物成分药", "激素类抗肿瘤药物",
                "其他抗肿瘤药及抗肿瘤辅助用药"};
        addAllClassChild(parentName3, child3, "KZLY");

        String parentName4 = "麻醉药及麻醉辅助用药";
        String child4[] = {"全身麻醉药-吸入麻醉药", "全身麻醉药-静脉麻醉药", "局部麻醉药", "骨骼肌松弛药", "其他麻醉药及麻醉辅助用药", "麻醉辅助", "镇痛"};
        addAllClassChild(parentName4, child4, "MZYY");

        String parentName5 = "镇痛、解热、抗炎、抗风湿";
        String child5[] = {"镇痛药", "解热止痛、抗炎、抗风湿药", "抗痛风药", "缓解感冒复方OTC", "辅助抗炎药"};
        addAllClassChild(parentName5, child5, "ZJKY");

        String parentName6 = "治疗神经系统疾病药";
        String child6[] = {"戒断综合症用药", "抗震颤麻痹药", "抗癫痫药", "脑血管病用药及降颅压药物", "中枢神经兴奋药-大脑功能改善药", "中枢神经兴奋药-呼吸兴奋药", "镇静催眠药",
                "抗偏头痛药", "其他治疗神经系统疾病药", "中枢神经兴奋药", "	抗重症肌无力", "中枢神经抑制药"};
        addAllClassChild(parentName6, child6, "SJXT");

        String parentName7 = "治疗精神障碍药";
        String child7[] = {"抗精神病药", "抗焦虑药", "抗躁狂药、抗抑郁药及精神兴奋药"};
        addAllClassChild(parentName7, child7, "JSZA");

        String parentName8 = "心血管系统用药";
        String child8[] = {"抗心绞痛药", "抗心律失常药", "抗心力衰竭药", "抗高血压药", "抗休克药", "调血脂药及抗动脉粥样化药", "其他心血管系统用药", "强心", "抗血小板凝集"};
        addAllClassChild(parentName8, child8, "XXGY");

        String parentName9 = "呼吸系统用药";
        String child9[] = {"祛痰药", "镇咳药", "平喘药", "肺纤维化及其他类"};
        addAllClassChild(parentName9, child9, "HXXT");

        String parentName10 = "消化系统用药";
        String child10[] = {"缓解呕吐用药", "抗酸药及抗溃疡病药", "助消化药", "胃肠解痉药及胃动力药", "泻药及止泻药", "微生态制剂", "肝胆疾病用药", "其他消化系统用药",
                "肝胆疾病辅助用药", "肠炎、结肠炎"};
        addAllClassChild(parentName10, child10, "XHXT");

        String parentName11 = "泌尿系统用药";
        String child11[] = {"利尿药", "良性前列腺增生用药", "其他泌尿系统用药", "尿路结石", "尿路感染用药"};
        addAllClassChild(parentName11, child11, "MNXT");

        String parentName12 = "血液系统用药";
        String child12[] = {"抗贫血药", "升白细胞药", "抗血小板药", "促凝血药", "抗凝血药及溶栓药", "血容量扩充剂"};
        addAllClassChild(parentName12, child12, "XYXT");

        String parentName13 = "激素及影响内分泌药";
        String child13[] = {"下丘脑垂体激素及其类似物", "肾上腺皮质激素类药物", "胰岛素及口服降血糖药", "甲状腺激素及抗甲状腺药", "甲状旁腺及钙代谢调节药", "雄激素及同化激素",
                "雌激素及孕激素", "其他激素及影响内分泌药"};
        addAllClassChild(parentName13, child13, "JSYX");

        String parentName14 = "抗变态反应药";
        String child14[] = {"抗组胺药", "其他抗变态反应药", "免疫增强剂"};
        addAllClassChild(parentName14, child14, "KBTF");

        String parentName15 = "免疫系统用药";
        String child15[] = {"免疫抑制药", "生物反应调节药"};
        addAllClassChild(parentName15, child15, "MYXT");

        String parentName16 = "维生素、矿物质及肠营养药";
        String child16[] = {"维生素", "矿物质类", "肠内营养药", "肠外营养药及氨基酸制剂"};
        addAllClassChild(parentName16, child16, "WSKW");

        String parentName17 = "调节水盐、电解质及酸碱平衡";
        String child17[] = {"调节水盐、电解质及酸碱平衡药 常用药品"};
        addAllClassChild(parentName17, child17, "SYDJ");

        String parentName18 = "解毒药";
        String child18[] = {"重金属、类金属中毒解毒药", "氰化物中毒解毒药", "有机磷酸酯类中毒解毒药及其他解毒药", "其他类解毒用药"};
        addAllClassChild(parentName18, child18, "JDYY");

        String parentName19 = "预防用生物制品";
        String child19[] = {"预防用生物制品 常用药品"};
        addAllClassChild(parentName19, child19, "YFSW");

        String parentName20 = "放射性药物";
        String child20[] = {"放射性药物  常用药品"};
        addAllClassChild(parentName20, child20, "FSXY");

        String parentName21 = "诊断用药";
        String child21[] = {"影像诊断用药", "其他诊断用药", "体外诊断试剂"};
        addAllClassChild(parentName21, child21, "ZDYY");

        String parentName22 = "计划生育用药";
        String child22[] = {"避孕药", "其他计划生育用药"};
        addAllClassChild(parentName22, child22, "JHSY");

        String parentName23 = "消毒防腐药";
        String child23[] = {"消毒防腐药 常用药品"};
        addAllClassChild(parentName23, child23, "XDFF");

        String parentName24 = "皮肤科用药";
        String child24[] = {"烧伤烫伤用药", "抗感染药", "角质促成剂及溶解药", "皮质类固醇", "其他皮肤科用药"};
        addAllClassChild(parentName24, child24, "PFKY");

        String parentName25 = "眼科用药";
        String child25[] = {"抗感染药", "抗青光眼药", "其他眼科用药", "白内障"};
        addAllClassChild(parentName25, child25, "YKYY");

        String parentName26 = "耳鼻喉、口腔科用药";
        String child26[] = {"耳鼻喉、口腔科用药 常用药品"};
        addAllClassChild(parentName26, child26, "KBHK");

        String parentName27 = "妇产科用药";
        String child27[] = {"子宫收缩及舒张药", "其他妇产科用药", "妇科炎症用药"};
        addAllClassChild(parentName27, child27, "FCKY");

        String parentName28 = "骨科用药";
        String child28[] = {"抗骨质疏松药", "骨关节炎、类风湿性关节炎", "外伤及其他骨科用药"};
        addAllClassChild(parentName28, child28, "GKYY");

        String parentName29 = "生物制品";
        String child29[] = {"生物制品 常用药品"};
        addAllClassChild(parentName29, child29, "SWZJ");

        String parentName30 = "肛肠科用药";
        String child30[] = {"肛肠科用药 常用药品"};
        addAllClassChild(parentName30, child30, "GCKY");

        String parentName31 = "妇科非激素类药物";
        String child31[] = {"妇科非激素类药物 常用药品"};
        addAllClassChild(parentName31, child31, "FKFJ");

        String parentName32 = "男科用药";
        String child32[] = {"男科用药 常用药品"};
        addAllClassChild(parentName32, child32, "NKYY");
    }

    public void addAllClass3() {
        SicmedMedicalClass sicmedMedicalClassParent = new SicmedMedicalClass();
        sicmedMedicalClassParent.setName("中药");
        sicmedMedicalClassParent = sicmedMedicalClassService.get(sicmedMedicalClassParent);
        String strs[] = {"内科", "外科", "妇科", "儿科", "耳鼻喉科", "口腔科", "眼科", "皮科", "骨伤科", "民族药"};
        int i = 1;
        for (String string : strs) {
            StringBuffer medicalCode = new StringBuffer();
            medicalCode.append("ZY");
            if (i < 10) {
                medicalCode.append("000");
                medicalCode.append(i);
            } else {
                medicalCode.append("00");
                medicalCode.append(i);
            }
            SicmedMedicalClass sicmedMedicalClass = new SicmedMedicalClass();
            sicmedMedicalClass.setCode(medicalCode.toString());
            sicmedMedicalClass.setName(string);
            sicmedMedicalClass.setParent(sicmedMedicalClassParent);
            sicmedMedicalClass.setParentIds("1");
            sicmedMedicalClassService.save(sicmedMedicalClass);
            i = i + 1;
        }
        String parentName1 = "内科";
        String child1[] = {"心脑血管用药", "肿瘤科", "消化科（消化系统）", "脑科/神经科（神经系统）", "呼吸科（呼吸系统疾病）", "骨科（躯干、四肢、关节）",
                "肾病科（泌尿系统、生殖系统）", "内分泌科（内分泌系统）", "虚症", "眩晕", "其他"};
        addAllClassChild(parentName1, child1, "NKYY");
        String parentName2 = "外科";
        String child2[] = {"性病", "肛门疾病", "男科疾病", "乳房/乳腺疾病", "其他"};
        addAllClassChild(parentName2, child2, "WKYY");
        String parentName3 = "妇科";
        String child3[] = {"产前产后用药", "其他妇科用药"};
        addAllClassChild(parentName3, child3, "FKYY");
        String parentName4 = "儿科";
        String child4[] = {"肺炎", "感冒", "咳嗽", "热证", "肠道寄生虫", "耳鼻喉疾病", "消化不良", "皮肤瘙痒", "其他儿科用药"};
        addAllClassChild(parentName4, child4, "EKYY");
        String parentName5 = "耳鼻喉科";
        String child5[] = {"耳鼻喉科用药"};
        addAllClassChild(parentName5, child5, "EBHK");
        String parentName6 = "口腔科";
        String child6[] = {"口腔科用药"};
        addAllClassChild(parentName6, child6, "KQKY");
        String parentName7 = "眼科";
        String child7[] = {"眼睑疾病", "结膜病", "角膜病变", "视神经及视路病", "其他眼看用药"};
        addAllClassChild(parentName7, child7, "YKYY");
        String parentName8 = "皮科";
        String child8[] = {"皮肤感染", "疱疹", "皮炎", "其他皮科用药"};
        addAllClassChild(parentName8, child8, "PKYY");
        String parentName9 = "骨伤科";
        String child9[] = {"骨伤科用药"};
        addAllClassChild(parentName9, child9, "GSKY");
        String parentName10 = "民族药";
        String child10[] = {"蒙药", "藏药", "维药", "苗药"};
        addAllClassChild(parentName10, child10, "MZY");
    }

    //三级分类
    public void addAllClassChild(String str, String[] strs, String code) {
        SicmedMedicalClass sicmedMedicalClassParent = new SicmedMedicalClass();
        sicmedMedicalClassParent.setName(str);
        sicmedMedicalClassParent = sicmedMedicalClassService.get(sicmedMedicalClassParent);
        int i = 1;
        for (String string : strs) {
            StringBuffer medicalCode = new StringBuffer();
            medicalCode.append(code);
            if (i < 10) {
                if (code.length() == 4) {
                    medicalCode.append("000");
                    medicalCode.append(i);
                } else {
                    medicalCode.append("0000");
                    medicalCode.append(i);
                }
            } else {
                if (code.length() == 4) {
                    medicalCode.append("00");
                    medicalCode.append(i);
                } else {
                    medicalCode.append("000");
                    medicalCode.append(i);
                }
            }
            SicmedMedicalClass sicmedMedicalClass = new SicmedMedicalClass();
            sicmedMedicalClass.setCode(medicalCode.toString());
            sicmedMedicalClass.setName(string);
            sicmedMedicalClass.setParent(sicmedMedicalClassParent);
            sicmedMedicalClass.setParentIds("2");
            sicmedMedicalClassService.save(sicmedMedicalClass);
            i = i + 1;
        }
    }
}