package com.thinkgem.jeesite.cfq.mobile.rest.web;//package com.thinkgem.jeesite.cfq.mobile.rest.web;
//
//import com.thinkgem.jeesite.cfq.common.web.BaseController;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedWordBean;
//import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedWord;
//import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedWordService;
//import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;
//import com.thinkgem.jeesite.cfq.mobile.rest.utils.SimcedPutWord;
//
//
//@Controller
//@RequestMapping(value = "${adminPath}/rest/printWord")
//public class SicmedPrintWordController extends BaseController {
////
//    @Autowired
//    private SicmedWordService sicmedWordService;
//
//
//    /**
//     * 打印 word
//     *
//     * @param
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printWord")
//    public BaseBean printWord(String wordId) {
//        //1.创建返回对象
//        SicmedWordBean sicmedWordBean = new SicmedWordBean();
//        //2.传入参数校验(处理)
//        if (!AppParameterSimulation.simulationId(wordId)) {
//            sicmedWordBean.setError("1");
//            sicmedWordBean.setErrorMessage("输入的wordId不正确");
//            return sicmedWordBean;
//        }
//        //3.创建查询条件
//        SicmedWord sicmedWord = new SicmedWord();
//        //4.查询条件赋值
//        sicmedWord.setPrintType("0");
//        sicmedWord.setId(wordId);
//        //5.调用service查询数据
//        sicmedWord = sicmedWordService.get(sicmedWord);
//        //6.查询结果校验
//        if (sicmedWord == null) {
//            sicmedWordBean.setError("1");
//            sicmedWordBean.setSuccessMessage("打印失败!没有需要打印的信息");
//            return sicmedWordBean;
//        }
//        //7.调用打印工具类打印word
//        SimcedPutWord.putWord("word.Application", "C:/Users/Administrator/Desktop/" + sicmedWord.getWordUri() + "/" + sicmedWord.getWordName());
//        //8.返回对象赋值
//        sicmedWordBean.setError("0");
//        sicmedWordBean.setSuccessMessage("打印成功!");
//        //9.处理结果反馈
//        return sicmedWordBean;
//    }
//
//
//    /**
//     * 打印病历
//     *
//     * @param patientId
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printCase")
//    public BaseBean printCase(String patientId, String printType) {
//        //1.创建返回对象
//        SicmedWordBean sicmedWordBean = new SicmedWordBean();
//        //2.传入参数校验(处理)
//
//        //3.创建查询条件
//        SicmedWord sicmedWord = new SicmedWord();
//        //4.查询条件赋值
//        sicmedWord.setPrintType("0");
//        //5.调用service查询数据
//        sicmedWord = sicmedWordService.get(sicmedWord);
//        //6.查询结果校验
//        if (sicmedWord == null) {
//            sicmedWordBean.setError("1");
//            sicmedWordBean.setSuccessMessage("打印失败!没有需要打印的信息");
//            return sicmedWordBean;
//        }
//        //7.调用打印工具类打印word
//        SimcedPutWord.putWord("word.Application", sicmedWord.getWordUri() + sicmedWord.getWordName());
//        //8.返回对象赋值
//        sicmedWordBean.setError("0");
//        sicmedWordBean.setSuccessMessage("打印成功!");
//        //9.处理结果反馈
//        return sicmedWordBean;
//    }
//
//    /**
//     * 打印检查医嘱
//     *
//     * @param patientId
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printCheck")
//    public BaseBean printCheck(String patientId) {
//        //1.创建返回对象
//        SicmedWordBean sicmedWordBean = new SicmedWordBean();
//        //2.传入参数校验(处理)
//
//        //3.创建查询条件
//        SicmedWord sicmedWord = new SicmedWord();
//        //4.查询条件赋值
//        sicmedWord.setPrintType("0");
//        //5.调用service查询数据
//        sicmedWord = sicmedWordService.get(sicmedWord);
//        //6.查询结果校验
//        if (sicmedWord == null) {
//            sicmedWordBean.setError("1");
//            sicmedWordBean.setSuccessMessage("打印失败!没有需要打印的信息");
//            return sicmedWordBean;
//        }
//        //7.调用打印工具类打印word
//        SimcedPutWord.putWord("word.Application", sicmedWord.getWordUri() + sicmedWord.getWordName());
//        //8.返回对象赋值
//        sicmedWordBean.setError("0");
//        sicmedWordBean.setSuccessMessage("打印成功!");
//        //9.处理结果反馈
//        return sicmedWordBean;
//    }
//
//    /**
//     * 打印检验医嘱
//     *
//     * @param patientId
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printInspect")
//    public BaseBean printInspect(String patientId) {
//        //1.创建返回对象
//        SicmedWordBean sicmedWordBean = new SicmedWordBean();
//        //2.传入参数校验(处理)
//
//        //3.创建查询条件
//        SicmedWord sicmedWord = new SicmedWord();
//        //4.查询条件赋值
//        sicmedWord.setPrintType("0");
//        //5.调用service查询数据
//        sicmedWord = sicmedWordService.get(sicmedWord);
//        //6.查询结果校验
//        if (sicmedWord == null) {
//            sicmedWordBean.setError("1");
//            sicmedWordBean.setSuccessMessage("打印失败!没有需要打印的信息");
//            return sicmedWordBean;
//        }
//        //7.调用打印工具类打印word
//        SimcedPutWord.putWord("word.Application", sicmedWord.getWordUri() + sicmedWord.getWordName());
//        //8.返回对象赋值
//        sicmedWordBean.setError("0");
//        sicmedWordBean.setSuccessMessage("打印成功!");
//        //9.处理结果反馈
//        return sicmedWordBean;
//    }
//
//    /**
//     * 打印治疗医嘱
//     *
//     * @param patientId
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printCure")
//    public BaseBean printCure(String patientId) {
//        //1.创建返回对象
//        SicmedWordBean sicmedWordBean = new SicmedWordBean();
//        //2.传入参数校验(处理)
//
//        //3.创建查询条件
//        SicmedWord sicmedWord = new SicmedWord();
//        //4.查询条件赋值
//        sicmedWord.setPrintType("0");
//        //5.调用service查询数据
//        sicmedWord = sicmedWordService.get(sicmedWord);
//        //6.查询结果校验
//        if (sicmedWord == null) {
//            sicmedWordBean.setError("1");
//            sicmedWordBean.setSuccessMessage("打印失败!没有需要打印的信息");
//            return sicmedWordBean;
//        }
//        //7.调用打印工具类打印word
//        SimcedPutWord.putWord("word.Application", sicmedWord.getWordUri() + sicmedWord.getWordName());
//        //8.返回对象赋值
//        sicmedWordBean.setError("0");
//        sicmedWordBean.setSuccessMessage("打印成功!");
//        //9.处理结果反馈
//        return sicmedWordBean;
//    }
//
//    /**
//     * 打印中药医嘱
//     *
//     * @param patientId
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printCMedical")
//    public BaseBean printCMedical(String patientId) {
//        //1.创建返回对象
//        SicmedWordBean sicmedWordBean = new SicmedWordBean();
//        //2.传入参数校验(处理)
//
//        //3.创建查询条件
//        SicmedWord sicmedWord = new SicmedWord();
//        //4.查询条件赋值
//        sicmedWord.setPrintType("0");
//        //5.调用service查询数据
//        sicmedWord = sicmedWordService.get(sicmedWord);
//        //6.查询结果校验
//        if (sicmedWord == null) {
//            sicmedWordBean.setError("1");
//            sicmedWordBean.setSuccessMessage("打印失败!没有需要打印的信息");
//            return sicmedWordBean;
//        }
//        //7.调用打印工具类打印word
//        SimcedPutWord.putWord("word.Application", sicmedWord.getWordUri() + sicmedWord.getWordName());
//        //8.返回对象赋值
//        sicmedWordBean.setError("0");
//        sicmedWordBean.setSuccessMessage("打印成功!");
//        //9.处理结果反馈
//        return sicmedWordBean;
//    }
//
//    /**
//     * 打印西药医嘱
//     *
//     * @param patientId
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printWMedical")
//    public BaseBean printWMedical(String patientId) {
//        //1.创建返回对象
//        SicmedWordBean sicmedWordBean = new SicmedWordBean();
//        //2.传入参数校验(处理)
//
//        //3.创建查询条件
//        SicmedWord sicmedWord = new SicmedWord();
//        //4.查询条件赋值
//        sicmedWord.setPrintType("0");
//        //5.调用service查询数据
//        sicmedWord = sicmedWordService.get(sicmedWord);
//        //6.查询结果校验
//        if (sicmedWord == null) {
//            sicmedWordBean.setError("1");
//            sicmedWordBean.setSuccessMessage("打印失败!没有需要打印的信息");
//            return sicmedWordBean;
//        }
//        //7.调用打印工具类打印word
//        SimcedPutWord.putWord("word.Application", sicmedWord.getWordUri() + sicmedWord.getWordName());
//        //8.返回对象赋值
//        sicmedWordBean.setError("0");
//        sicmedWordBean.setSuccessMessage("打印成功!");
//        //9.处理结果反馈
//        return sicmedWordBean;
//    }
//
//    /**
//     * 打印挂号凭证
//     *
//     * @param patientId
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printRegistered")
//    public BaseBean printRegistered(String patientId) {
//        //1.创建返回对象
//        SicmedWordBean sicmedWordBean = new SicmedWordBean();
//        //2.传入参数校验(处理)
//
//        //3.创建查询条件
//        SicmedWord sicmedWord = new SicmedWord();
//        //4.查询条件赋值
//        sicmedWord.setPrintType("0");
//        //5.调用service查询数据
//        sicmedWord = sicmedWordService.get(sicmedWord);
//        //6.查询结果校验
//        if (sicmedWord == null) {
//            sicmedWordBean.setError("1");
//            sicmedWordBean.setSuccessMessage("打印失败!没有需要打印的信息");
//            return sicmedWordBean;
//        }
//        //7.调用打印工具类打印word
//        SimcedPutWord.putWord("word.Application", sicmedWord.getWordUri() + sicmedWord.getWordName());
//        //8.返回对象赋值
//        sicmedWordBean.setError("0");
//        sicmedWordBean.setSuccessMessage("打印成功!");
//        //9.处理结果反馈
//        return sicmedWordBean;
//    }
//
//    /**
//     * 打印改号凭证
//     *
//     * @param patientId
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printUpRegistered")
//    public BaseBean printUpRegistered(String patientId) {
//        //1.创建返回对象
//        SicmedWordBean sicmedWordBean = new SicmedWordBean();
//        //2.传入参数校验(处理)
//
//        //3.创建查询条件
//        SicmedWord sicmedWord = new SicmedWord();
//        //4.查询条件赋值
//        sicmedWord.setPrintType("0");
//        //5.调用service查询数据
//        sicmedWord = sicmedWordService.get(sicmedWord);
//        //6.查询结果校验
//        if (sicmedWord == null) {
//            sicmedWordBean.setError("1");
//            sicmedWordBean.setSuccessMessage("打印失败!没有需要打印的信息");
//            return sicmedWordBean;
//        }
//        //7.调用打印工具类打印word
//        SimcedPutWord.putWord("word.Application", sicmedWord.getWordUri() + sicmedWord.getWordName());
//        //8.返回对象赋值
//        sicmedWordBean.setError("0");
//        sicmedWordBean.setSuccessMessage("打印成功!");
//        //9.处理结果反馈
//        return sicmedWordBean;
//    }
//
//    /**
//     * 打印检查缴费单
//     *
//     * @param patientId
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printPriceCheck")
//    public BaseBean printPriceCheck(String patientId) {
//        //1.创建返回对象
//        SicmedWordBean sicmedWordBean = new SicmedWordBean();
//        //2.传入参数校验(处理)
//
//        //3.创建查询条件
//        SicmedWord sicmedWord = new SicmedWord();
//        //4.查询条件赋值
//        sicmedWord.setPrintType("0");
//        //5.调用service查询数据
//        sicmedWord = sicmedWordService.get(sicmedWord);
//        //6.查询结果校验
//        if (sicmedWord == null) {
//            sicmedWordBean.setError("1");
//            sicmedWordBean.setSuccessMessage("打印失败!没有需要打印的信息");
//            return sicmedWordBean;
//        }
//        //7.调用打印工具类打印word
//        SimcedPutWord.putWord("word.Application", sicmedWord.getWordUri() + sicmedWord.getWordName());
//        //8.返回对象赋值
//        sicmedWordBean.setError("0");
//        sicmedWordBean.setSuccessMessage("打印成功!");
//        //9.处理结果反馈
//        return sicmedWordBean;
//    }
//
//    /**
//     * 打印检验缴费单
//     *
//     * @param patientId
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printPriceInspect")
//    public BaseBean printPriceInspect(String patientId) {
//        //1.创建返回对象
//        SicmedWordBean sicmedWordBean = new SicmedWordBean();
//        //2.传入参数校验(处理)
//
//        //3.创建查询条件
//        SicmedWord sicmedWord = new SicmedWord();
//        //4.查询条件赋值
//        sicmedWord.setPrintType("0");
//        //5.调用service查询数据
//        sicmedWord = sicmedWordService.get(sicmedWord);
//        //6.查询结果校验
//        if (sicmedWord == null) {
//            sicmedWordBean.setError("1");
//            sicmedWordBean.setSuccessMessage("打印失败!没有需要打印的信息");
//            return sicmedWordBean;
//        }
//        //7.调用打印工具类打印word
//        SimcedPutWord.putWord("word.Application", sicmedWord.getWordUri() + sicmedWord.getWordName());
//        //8.返回对象赋值
//        sicmedWordBean.setError("0");
//        sicmedWordBean.setSuccessMessage("打印成功!");
//        //9.处理结果反馈
//        return sicmedWordBean;
//    }
//
//    /**
//     * 打印治疗缴费单
//     *
//     * @param patientId
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printPriceCure")
//    public BaseBean printPriceCure(String patientId) {
//        //1.创建返回对象
//        SicmedWordBean sicmedWordBean = new SicmedWordBean();
//        //2.传入参数校验(处理)
//
//        //3.创建查询条件
//        SicmedWord sicmedWord = new SicmedWord();
//        //4.查询条件赋值
//        sicmedWord.setPrintType("0");
//        //5.调用service查询数据
//        sicmedWord = sicmedWordService.get(sicmedWord);
//        //6.查询结果校验
//        if (sicmedWord == null) {
//            sicmedWordBean.setError("1");
//            sicmedWordBean.setSuccessMessage("打印失败!没有需要打印的信息");
//            return sicmedWordBean;
//        }
//        //7.调用打印工具类打印word
//        SimcedPutWord.putWord("word.Application", sicmedWord.getWordUri() + sicmedWord.getWordName());
//        //8.返回对象赋值
//        sicmedWordBean.setError("0");
//        sicmedWordBean.setSuccessMessage("打印成功!");
//        //9.处理结果反馈
//        return sicmedWordBean;
//    }
//
//    /**
//     * 打印中药缴费单
//     *
//     * @param patientId
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printPriceCMedical")
//    public BaseBean printPriceCMedical(String patientId) {
//        //1.创建返回对象
//        SicmedWordBean sicmedWordBean = new SicmedWordBean();
//        //2.传入参数校验(处理)
//
//        //3.创建查询条件
//        SicmedWord sicmedWord = new SicmedWord();
//        //4.查询条件赋值
//        sicmedWord.setPrintType("0");
//        //5.调用service查询数据
//        sicmedWord = sicmedWordService.get(sicmedWord);
//        //6.查询结果校验
//        if (sicmedWord == null) {
//            sicmedWordBean.setError("1");
//            sicmedWordBean.setSuccessMessage("打印失败!没有需要打印的信息");
//            return sicmedWordBean;
//        }
//        //7.调用打印工具类打印word
//        SimcedPutWord.putWord("word.Application", sicmedWord.getWordUri() + sicmedWord.getWordName());
//        //8.返回对象赋值
//        sicmedWordBean.setError("0");
//        sicmedWordBean.setSuccessMessage("打印成功!");
//        //9.处理结果反馈
//        return sicmedWordBean;
//    }
//
//    /**
//     * 打印西药缴费单
//     *
//     * @param patientId
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printPriceWMedical")
//    public BaseBean printPriceWMedical(String patientId) {
//        //1.创建返回对象
//        SicmedWordBean sicmedWordBean = new SicmedWordBean();
//        //2.传入参数校验(处理)
//
//        //3.创建查询条件
//        SicmedWord sicmedWord = new SicmedWord();
//        //4.查询条件赋值
//        sicmedWord.setPrintType("0");
//        //5.调用service查询数据
//        sicmedWord = sicmedWordService.get(sicmedWord);
//        //6.查询结果校验
//        if (sicmedWord == null) {
//            sicmedWordBean.setError("1");
//            sicmedWordBean.setSuccessMessage("打印失败!没有需要打印的信息");
//            return sicmedWordBean;
//        }
//        //7.调用打印工具类打印word
//        SimcedPutWord.putWord("word.Application", sicmedWord.getWordUri() + sicmedWord.getWordName());
//        //8.返回对象赋值
//        sicmedWordBean.setError("0");
//        sicmedWordBean.setSuccessMessage("打印成功!");
//        //9.处理结果反馈
//        return sicmedWordBean;
//    }
//
//    /**
//     * 打印检查退费单
//     *
//     * @param patientId
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printRefundCheck")
//    public BaseBean printRefundCheck(String patientId) {
//        //1.创建返回对象
//        SicmedWordBean sicmedWordBean = new SicmedWordBean();
//        //2.传入参数校验(处理)
//
//        //3.创建查询条件
//        SicmedWord sicmedWord = new SicmedWord();
//        //4.查询条件赋值
//        sicmedWord.setPrintType("0");
//        //5.调用service查询数据
//        sicmedWord = sicmedWordService.get(sicmedWord);
//        //6.查询结果校验
//        if (sicmedWord == null) {
//            sicmedWordBean.setError("1");
//            sicmedWordBean.setSuccessMessage("打印失败!没有需要打印的信息");
//            return sicmedWordBean;
//        }
//        //7.调用打印工具类打印word
//        SimcedPutWord.putWord("word.Application", sicmedWord.getWordUri() + sicmedWord.getWordName());
//        //8.返回对象赋值
//        sicmedWordBean.setError("0");
//        sicmedWordBean.setSuccessMessage("打印成功!");
//        //9.处理结果反馈
//        return sicmedWordBean;
//    }
//
//    /**
//     * 打印检验退费单
//     *
//     * @param patientId
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printRefundInspect")
//    public BaseBean printRefundInspect(String patientId) {
//        //1.创建返回对象
//        SicmedWordBean sicmedWordBean = new SicmedWordBean();
//        //2.传入参数校验(处理)
//
//        //3.创建查询条件
//        SicmedWord sicmedWord = new SicmedWord();
//        //4.查询条件赋值
//        sicmedWord.setPrintType("0");
//        //5.调用service查询数据
//        sicmedWord = sicmedWordService.get(sicmedWord);
//        //6.查询结果校验
//        if (sicmedWord == null) {
//            sicmedWordBean.setError("1");
//            sicmedWordBean.setSuccessMessage("打印失败!没有需要打印的信息");
//            return sicmedWordBean;
//        }
//        //7.调用打印工具类打印word
//        SimcedPutWord.putWord("word.Application", sicmedWord.getWordUri() + sicmedWord.getWordName());
//        //8.返回对象赋值
//        sicmedWordBean.setError("0");
//        sicmedWordBean.setSuccessMessage("打印成功!");
//        //9.处理结果反馈
//        return sicmedWordBean;
//    }
//
//    /**
//     * 打印治疗退费单
//     *
//     * @param patientId
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printRefundCure")
//    public BaseBean printRefundCure(String patientId) {
//        //1.创建返回对象
//        SicmedWordBean sicmedWordBean = new SicmedWordBean();
//        //2.传入参数校验(处理)
//
//        //3.创建查询条件
//        SicmedWord sicmedWord = new SicmedWord();
//        //4.查询条件赋值
//        sicmedWord.setPrintType("0");
//        //5.调用service查询数据
//        sicmedWord = sicmedWordService.get(sicmedWord);
//        //6.查询结果校验
//        if (sicmedWord == null) {
//            sicmedWordBean.setError("1");
//            sicmedWordBean.setSuccessMessage("打印失败!没有需要打印的信息");
//            return sicmedWordBean;
//        }
//        //7.调用打印工具类打印word
//        SimcedPutWord.putWord("word.Application", sicmedWord.getWordUri() + sicmedWord.getWordName());
//        //8.返回对象赋值
//        sicmedWordBean.setError("0");
//        sicmedWordBean.setSuccessMessage("打印成功!");
//        //9.处理结果反馈
//        return sicmedWordBean;
//    }
//
//    /**
//     * 打印中药退费单
//     *
//     * @param patientId
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printRefundCMedical")
//    public BaseBean printRefundCMedical(String patientId) {
//        //1.创建返回对象
//        SicmedWordBean sicmedWordBean = new SicmedWordBean();
//        //2.传入参数校验(处理)
//
//        //3.创建查询条件
//        SicmedWord sicmedWord = new SicmedWord();
//        //4.查询条件赋值
//        sicmedWord.setPrintType("0");
//        //5.调用service查询数据
//        sicmedWord = sicmedWordService.get(sicmedWord);
//        //6.查询结果校验
//        if (sicmedWord == null) {
//            sicmedWordBean.setError("1");
//            sicmedWordBean.setSuccessMessage("打印失败!没有需要打印的信息");
//            return sicmedWordBean;
//        }
//        //7.调用打印工具类打印word
//        SimcedPutWord.putWord("word.Application", sicmedWord.getWordUri() + sicmedWord.getWordName());
//        //8.返回对象赋值
//        sicmedWordBean.setError("0");
//        sicmedWordBean.setSuccessMessage("打印成功!");
//        //9.处理结果反馈
//        return sicmedWordBean;
//    }
//
//    /**
//     * 打印西药退费单
//     *
//     * @param patientId
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "printRefundWMedical")
//    public BaseBean printRefundWMedical(String patientId) {
//        //1.创建返回对象
//        SicmedWordBean sicmedWordBean = new SicmedWordBean();
//        //2.传入参数校验(处理)
//
//        //3.创建查询条件
//        SicmedWord sicmedWord = new SicmedWord();
//        //4.查询条件赋值
//        sicmedWord.setPrintType("0");
//        //5.调用service查询数据
//        sicmedWord = sicmedWordService.get(sicmedWord);
//        //6.查询结果校验
//        if (sicmedWord == null) {
//            sicmedWordBean.setError("1");
//            sicmedWordBean.setSuccessMessage("打印失败!没有需要打印的信息");
//            return sicmedWordBean;
//        }
//        //7.调用打印工具类打印word
//        SimcedPutWord.putWord("word.Application", sicmedWord.getWordUri() + sicmedWord.getWordName());
//        //8.返回对象赋值
//        sicmedWordBean.setError("0");
//        sicmedWordBean.setSuccessMessage("打印成功!");
//        //9.处理结果反馈
//        return sicmedWordBean;
//    }
//}
