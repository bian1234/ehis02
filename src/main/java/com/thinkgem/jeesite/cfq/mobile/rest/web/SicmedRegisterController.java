package com.thinkgem.jeesite.cfq.mobile.rest.web;

import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedUserBean;

/**
 * 手机端注册接口Controller
 *
 * @author Max
 * @version 2016-07-13
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedRegister")
public class SicmedRegisterController extends BaseController {


    @ModelAttribute

    @ResponseBody
    @RequestMapping(value = "register")
    public BaseBean treeData(@RequestParam(required = false) String userTel,
                             @RequestParam(required = false) String password, @RequestParam(required = false) String repassword, HttpServletResponse response) {

        SicmedUserBean sicmedUserBean = new SicmedUserBean();
        sicmedUserBean.setError("1");
        sicmedUserBean.setErrorMessage("aaaaaaaaaaaaaaaaaaaaa");
        return sicmedUserBean;

    }

}