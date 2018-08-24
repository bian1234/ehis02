package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedUserBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedUserBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedBranch;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDept;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInviteNumber;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegisteredType;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedUser;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedBranchService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedDeptService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedInviteNumberService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedRegisteredTypeService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedUserService;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.CreateSessionId;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.DateTimeUtils;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.PatientTestUtils;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.RandomUtils;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.SessionIdCacheUtils;

/**
 * 手机端接口Controller
 *
 * @author Max
 * @version 2016-07-12
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedUser")
public class SicmedUserController extends BaseController {

    @Autowired
    private SicmedUserService sicmedUserService;

    @Autowired
    private SicmedBranchService sicmedBranchService;

    @Autowired
    private SicmedDeptService sicmedDeptService;

    @Autowired
    private SicmedInviteNumberService sicmedInviteNumberService;

    @Autowired
    private SicmedRegisteredTypeService sicmedRegisteredTypeService;

    // private Integer passwordLength = 6; //密码长度
    // private Integer inviteLength = 4; //邀请码长度

	/*
     * @ModelAttribute public SicmedUser get(@RequestParam(required = false)
	 * String id) { SicmedUser entity = null; if (StringUtils.isNotBlank(id)) {
	 * entity = sicmedUserService.get(id); } if (entity == null) { entity = new
	 * SicmedUser(); } return entity; }
	 */

    /**
     * 初始化-医生
     */

    @ResponseBody
    @RequestMapping(value = "add")
    public BaseBean add(SicmedUserBean sicmedUserBean, String sicmedBranchId, String ssid) {


        SicmedBranch sicmedBranch = new SicmedBranch();
        List<SicmedBranch> ls = sicmedBranchService.findList(sicmedBranch);
        int a = 0;
        int b = 0;
        for (String str : PatientTestUtils.get()) {
            a = a + 1;
            SicmedUser sicmedUser = new SicmedUser();
            sicmedUser.setSicmedBranch(ls.get(b));
            sicmedUser.setUserName(str + "医生");
            sicmedUser.setUserTel(RandomUtils.getTel());
            sicmedUser.setPassword("12345678");
            sicmedUser.setUserJobGroup("1");
            String no = RandomUtils.getNo();
            sicmedUser.setUserJobGrade(no);
            sicmedUser.setDoctorGrade(no);
            sicmedUser.setUserEmail(RandomUtils.getEmail(11, 20));
            sicmedUser.setUserStatus("0");
            sicmedUserService.save(sicmedUser);
            if (a % 30 == 0) {
                b = b + 1;
                if (b > ls.size()) {
                    break;
                }
            }
        }
        // sicmedUser.setSicmedBranch(sicmedBranch);

        // SicmedInviteNumber sicmedInviteNumber = new SicmedInviteNumber();
        // 获取添加成功的用户
        // sicmedUser = sicmedUserService.getByTel(sicmedUserBean.getUserTel());
        // 为用户生成激活码
        // sicmedInviteNumber.setSicmedUser(sicmedUser);
        // sicmedInviteNumber.setInviteNumber(CreateRegisterCodeUtils.getRegisterCode());
        // sicmedInviteNumber.setInviteStatus("0");
        // sicmedInviteNumberService.save(sicmedInviteNumber);

        sicmedUserBean.setError("0");
        sicmedUserBean.setErrorMessage("添加用户成功");

        return sicmedUserBean;

    }

    /**
     * 激活用户
     *
     * @param userTel
     * @param password
     * @param inviteCode
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "register")
    public BaseBean register(@RequestParam String userTel, @RequestParam String password,
                             @RequestParam String inviteCode) {

        SicmedUserBean sicmedUserBean = new SicmedUserBean();
        if (!AppParameterSimulation.isNotEmpty(userTel) || !AppParameterSimulation.isNotEmpty(password)
                || !AppParameterSimulation.isNotEmpty(inviteCode)) {
            sicmedUserBean.setError("1");
            sicmedUserBean.setErrorMessage("输入项不能为空");
            return sicmedUserBean;
        } else if (!AppParameterSimulation.isHandset(userTel)) {
            sicmedUserBean.setError("1");
            sicmedUserBean.setErrorMessage("手机号格式不正确");
            return sicmedUserBean;
        } else if (!AppParameterSimulation.checkUserNamePassword(password)) {
            sicmedUserBean.setError("1");
            sicmedUserBean.setErrorMessage("密码只能使用英文字母、数字以及-和_，并且首字符必须为字母或数字 密码首字符必须为字母或数字");
            return sicmedUserBean;
        }
        // 创建返回给前台的Bean

        // 校验激活码是否正确可用
        SicmedInviteNumber sicmedInviteNumber = new SicmedInviteNumber();
        sicmedInviteNumber.setInviteNumber(inviteCode);
        sicmedInviteNumber = sicmedInviteNumberService.getByEntity(sicmedInviteNumber);
        // 判断激活码是否存在
        if (sicmedInviteNumber == null) {
            sicmedUserBean.setError("1");
            sicmedUserBean.setErrorMessage("激活用户失败!激活码不存在!");
            return sicmedUserBean;
        } else {
            // 判断激活码是否可用
            if (sicmedInviteNumber.getInviteStatus().equals("0")) {
                // 激活码可用获取用户
                SicmedUser sicmedUser = sicmedUserService.get(sicmedInviteNumber.getSicmedUser().getId());
                // 校验用户电话号码是否正确
                if (sicmedUser.getUserTel().equals(userTel)) {
                    // 电话号码正确激活用户
                    sicmedUser.setPassword(password);
                    sicmedUser.setUserStatus("1");
                    sicmedUserService.update(sicmedUser);
                    // 激活成功刪除将验证码标为已激活
                    sicmedInviteNumber.setInviteStatus("1");
                    sicmedInviteNumberService.update(sicmedInviteNumber);
                    sicmedUserBean.setError("0");
                    sicmedUserBean.setErrorMessage("激活用户成功!可以登陆了!");
                    return sicmedUserBean;
                } else {
                    // 电话号码错误激活失败
                    sicmedUserBean.setError("1");
                    sicmedUserBean.setErrorMessage("输入的手机号不正确");
                    return sicmedUserBean;
                }
            } else {
                // 激活码不可用
                sicmedUserBean.setError("1");
                sicmedUserBean.setErrorMessage("激活用户失败!该账户已激活!不需要重复激活");
                return sicmedUserBean;
            }
        }

    }

    /**
     * 登陆
     *
     * @param userTel
     * @param password
     * @return
     * @version 0.8
     */
    @ResponseBody
    @RequestMapping(value = "login")
    public BaseBean login(@RequestParam String userTel, @RequestParam String password) {
        // 创建返回对象
        SicmedUserBean sicmedUserBean = new SicmedUserBean();
        // 判断传入参数
        if (!AppParameterSimulation.isNotEmpty(userTel) || !AppParameterSimulation.isNotEmpty(password)) {
            sicmedUserBean.setError("1");
            sicmedUserBean.setErrorMessage("参数不能为空");
            return sicmedUserBean;
        } else if (!AppParameterSimulation.isHandset(userTel)) {
            sicmedUserBean.setError("1");
            sicmedUserBean.setErrorMessage("手机号格式不正确");
            return sicmedUserBean;
        } else if (!AppParameterSimulation.checkUserNamePassword(password)) {
            sicmedUserBean.setError("1");
            sicmedUserBean.setErrorMessage("密码只能使用英文字母、数字以及-和_，并且首字符必须为字母或数字 密码首字符必须为字母或数字");
            return sicmedUserBean;
        }
        // 创建查询对象
        SicmedUser sicmedUser = new SicmedUser();
        // 设置查询对象的属性
        sicmedUser.setUserTel(userTel);
        sicmedUser.setPassword(password);
        // 调用service方法 查询用户信息
        sicmedUser = sicmedUserService.login(sicmedUser);

        // SicmedUser sicmedUser = sicmedUserService.getByTel(userTel);
        // 查询结果校验
        if (sicmedUser != null) {
            if (sicmedUser.getUserStatus().equals("0")) {
                sicmedUserBean.setSUser(sicmedUser);
                sicmedUserBean.setError("0");
                sicmedUserBean.setErrorMessage("第一次登陆 需要更改厨师密码!");

                // 登陆成功 设置用户登陆时间
                sicmedUser.setLoginDate(DateTimeUtils.getTime());
                sicmedUserService.update(sicmedUser);
                // 用户重新登陆清除之前没有过期的SSID
                SessionIdCacheUtils.clearCurrentSSID(sicmedUser.getId());
                // 创建CATCH
                SessionIdCacheUtils.getCache(SessionIdCacheUtils.MOBILE_CACHE);
                // 获取SessionId
                String ssid = CreateSessionId.generateSessionId();
                // 将SSID 和用户添加到缓存中
                Map<String, String> userMap = new HashMap<String, String>();
                Map<Date, Map<String, String>> ssidMap = new HashMap<Date, Map<String, String>>();
                userMap.put(sicmedUser.getId(), sicmedUser.getUserName());
                ssidMap.put(DateTimeUtils.getTime(), userMap);
                SessionIdCacheUtils.put(ssid, ssidMap);
                // 将SSID添加到用户信息中
                sicmedUserBean.setSsid(ssid);

                return sicmedUserBean;
            } else if (sicmedUser.getUserStatus().equals("1")) {
                sicmedUserBean.setSUser(sicmedUser);
                sicmedUserBean.setError("0");
                sicmedUserBean.setErrorMessage("不是首次登陆 登陆成功 直接进入首页!");

                // 登陆成功 设置用户登陆时间
                sicmedUser.setLoginDate(DateTimeUtils.getTime());
                sicmedUserService.update(sicmedUser);
                // 用户重新登陆清除之前没有过期的SSID
                SessionIdCacheUtils.clearCurrentSSID(sicmedUser.getId());
                // 创建CATCH
                SessionIdCacheUtils.getCache(SessionIdCacheUtils.MOBILE_CACHE);
                // 获取SessionId
                String ssid = CreateSessionId.generateSessionId();
                // 将SSID 和用户添加到缓存中
                Map<String, String> userMap = new HashMap<String, String>();
                Map<Date, Map<String, String>> ssidMap = new HashMap<Date, Map<String, String>>();
                userMap.put(sicmedUser.getId(), sicmedUser.getUserName());
                ssidMap.put(DateTimeUtils.getTime(), userMap);
                SessionIdCacheUtils.put(ssid, ssidMap);
                // 将SSID添加到用户信息中
                sicmedUserBean.setSsid(ssid);

                return sicmedUserBean;

            } else {
                sicmedUserBean.setError("1");
                sicmedUserBean.setErrorMessage("登陆失败,密码错误!");
                return sicmedUserBean;
            }

        } else {
            sicmedUserBean.setError("1");
            sicmedUserBean.setErrorMessage("登陆失败 登陆密码 或者 登陆电话号码错误!");
            return sicmedUserBean;
        }
    }

    /**
     * 修改密码
     *
     * @param userId
     * @param password
     * @param oldPassword
     * @return sicmedUserBean
     * @version 0.8
     */

    @ResponseBody
    @RequestMapping(value = "update")
    public BaseBean update(@RequestParam(required = false) String userId, @RequestParam String password,
                           @RequestParam String oldPassword) {
        // 创建返回条件
        SicmedUserBean sicmedUserBean = new SicmedUserBean();
        // 参数校验
        if (!AppParameterSimulation.isNotEmpty(userId) || !AppParameterSimulation.isNotEmpty(password)
                || !AppParameterSimulation.isNotEmpty(oldPassword)) {
            sicmedUserBean.setError("1");
            sicmedUserBean.setErrorMessage("参数不能为空");
            return sicmedUserBean;
        } else if (!AppParameterSimulation.checkUserNamePassword(password)) {
            sicmedUserBean.setError("1");
            sicmedUserBean.setErrorMessage("密码只能使用英文字母、数字以及-和_，并且首字符必须为字母或数字 密码首字符必须为字母或数字");
            return sicmedUserBean;
        }
        // 根据ID获取要修改的用户信息
        SicmedUser sicmedUser = sicmedUserService.get(userId);
        // 判断用户是否存在
        if (sicmedUser != null) {
            // 判断原密码是否正确
            if (sicmedUser.getPassword().equals(oldPassword)) {
                // 原密码正确 修改用户密码
                sicmedUser.setPassword(password);
                sicmedUserService.update(sicmedUser);
                sicmedUserBean.setError("0");
                sicmedUserBean.setErrorMessage("更新成功.");
                return sicmedUserBean;
            } else {
                // 原密码错误返回错误信息
                sicmedUserBean.setError("1");
                sicmedUserBean.setErrorMessage("旧密码输入错误");
                return sicmedUserBean;
            }
        } else {
            sicmedUserBean.setError("1");
            sicmedUserBean.setErrorMessage("更新失败.输入的用户不存在");
            return sicmedUserBean;
        }
    }

    /**
     * 第一次登陆设置用户密码
     *
     * @param userId
     * @param password
     * @param ssid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "setPassword")
    public BaseBean setPassword(@RequestParam(required = false) String userId, @RequestParam String password,
                                String ssid) {
        // 创建返回条件
        SicmedUserBean sicmedUserBean = new SicmedUserBean();
        // 参数校验
        if (!AppParameterSimulation.isNotEmpty(userId) || !AppParameterSimulation.isNotEmpty(password)) {
            sicmedUserBean.setError("1");
            sicmedUserBean.setErrorMessage("参数不能为空");
            return sicmedUserBean;
        } else if (!AppParameterSimulation.checkUserNamePassword(password)) {
            sicmedUserBean.setError("1");
            sicmedUserBean.setErrorMessage("密码只能使用英文字母、数字以及-和_，并且首字符必须为字母或数字 密码首字符必须为字母或数字");
            return sicmedUserBean;
        }
        // 根据ID获取要修改的用户信息
        SicmedUser sicmedUser = sicmedUserService.get(userId);
        // 判断用户是否存在
        if (sicmedUser != null) {
            sicmedUser.setPassword(password);
            sicmedUser.setUserStatus("1");
            sicmedUserService.update(sicmedUser);
            sicmedUserBean.setSUser(sicmedUser);
            sicmedUserBean.setError("0");
            sicmedUserBean.setErrorMessage("设置用户初始密码成功");
            return sicmedUserBean;

        } else {
            sicmedUserBean.setError("1");
            sicmedUserBean.setErrorMessage("设置用户初始密码失败");
            return sicmedUserBean;
        }
    }

    /**
     * 根据挂号类别查询医生信息
     *
     * @param registeredTypeId
     * @return sicmedUserBeans
     * @author Max
     */

    @ResponseBody
    @RequestMapping(value = "findByRegisteredType")
    public BaseBean findByRegisteredType(@RequestParam(required = false) String registeredTypeId, String branchId) {
        // 创建返回对象
        SicmedUserBeans sicmedUserBeans = new SicmedUserBeans();
        // 传入参数验证
        if (AppParameterSimulation.isEmpty(registeredTypeId)) {
            sicmedUserBeans.setError("1");
            sicmedUserBeans.setErrorMessage("参数不能为空");
            return sicmedUserBeans;
        } else if (!AppParameterSimulation.simulationId(registeredTypeId)) {
            sicmedUserBeans.setError("1");
            sicmedUserBeans.setErrorMessage("挂号类型ID不正宗");
            return sicmedUserBeans;
        }
        // 创建查询条件
        SicmedUser sicmedUser = new SicmedUser();
        // 获取查询条件属性
        SicmedRegisteredType sicmedRegisteredType = sicmedRegisteredTypeService.get(registeredTypeId);
        SicmedBranch sicmedBranch = sicmedBranchService.get(branchId);
        // 查询条件赋值
        sicmedUser.setUserJobGrade(sicmedRegisteredType.getCodeGrades());
        sicmedUser.setSicmedBranch(sicmedBranch);
        // 调用service查询医生信息
        List<SicmedUser> sicmedUsers = sicmedUserService.findDoctorByTypeAndBranch(sicmedUser);
        // 查询结果校验 处理
        if (sicmedUsers.size() > 0) {
            for (SicmedUser sicmedUser1 : sicmedUsers) {
                SicmedUserBean sicmedUserBean = new SicmedUserBean();
                sicmedUserBean.setSUser(sicmedUser1);
                sicmedUserBeans.getSicmedUserBeans().add(sicmedUserBean);
            }
            sicmedUserBeans.setError("0");
            sicmedUserBeans.setErrorMessage("查询成功.");

        } else {
            sicmedUserBeans.setError("1");
            sicmedUserBeans.setErrorMessage("查询失败没有找到信息");
        }
        // 返回处理结果
        return sicmedUserBeans;
    }

    /**
     * 根据部门获取用户
     */
    @ResponseBody
    @RequestMapping(value = "findByDept")
    public BaseBean findByDept(@RequestParam(required = false) String deptId) {

        SicmedUserBeans sicmedUserBeans = new SicmedUserBeans();

        try {

            SicmedDept sicmedDept = sicmedDeptService.get(deptId);

            SicmedUser sicmedUser = new SicmedUser();

            sicmedUser.setSicmedDept(sicmedDept);

            List<SicmedUser> sicmedUsers = sicmedUserService.findByDept(sicmedUser);

            if (sicmedUsers.size() != 0) {
                for (SicmedUser sicmedUser1 : sicmedUsers) {
                    SicmedUserBean sicmedUserBean = new SicmedUserBean();
                    sicmedUserBean.setSUser(sicmedUser1);
                    sicmedUserBeans.getSicmedUserBeans().add(sicmedUserBean);
                }
                sicmedUserBeans.setError("0");
                sicmedUserBeans.setErrorMessage("查询成功.");

            } else {
                sicmedUserBeans.setError("1");
                sicmedUserBeans.setErrorMessage("查询失败没有找到信息");
            }

        } catch (Exception e) {

            e.printStackTrace();
            sicmedUserBeans.setError("1");
            sicmedUserBeans.setErrorMessage("查询失败!系统内部错误!请联系管理员!");

        }

        return sicmedUserBeans;

    }

    /**
     * 根据ID获取用户
     */
    @ResponseBody
    @RequestMapping(value = "findById")
    public BaseBean findById(@RequestParam(required = false) String id) {

        SicmedUserBean sicmedUserBean = new SicmedUserBean();
        try {
            SicmedUser sicmedUser = sicmedUserService.get(id);
            sicmedUserBean.setSUser(sicmedUser);

            sicmedUserBean.setError("0");
            sicmedUserBean.setErrorMessage("查询成功.");

        } catch (Exception e) {

            e.printStackTrace();
            sicmedUserBean.setError("1");
            sicmedUserBean.setErrorMessage("查询失败!系统内部错误!请联系管理员!");
        }
        return sicmedUserBean;

    }

	/*
	 * @RequiresPermissions("rest:sicmedUser:view")
	 * 
	 * @RequestMapping(value = {"list", ""}) public String list(SicmedUser
	 * sicmedUser, HttpServletRequest request, HttpServletResponse response,
	 * Model model) { Page<SicmedUser> page = sicmedUserService.findPage(new
	 * Page<SicmedUser>(request, response), sicmedUser);
	 * model.addAttribute("page", page); return "mobile/rest/sicmedUserList"; }
	 * 
	 * @RequiresPermissions("rest:sicmedUser:view")
	 * 
	 * @RequestMapping(value = "form") public String form(SicmedUser sicmedUser,
	 * Model model) { model.addAttribute("sicmedUser", sicmedUser); return
	 * "mobile/rest/sicmedUserForm"; }
	 * 
	 * @RequiresPermissions("rest:sicmedUser:edit")
	 * 
	 * @RequestMapping(value = "save") public String save(SicmedUser sicmedUser,
	 * Model model, RedirectAttributes redirectAttributes) { if
	 * (!beanValidator(model, sicmedUser)){ return form(sicmedUser, model); }
	 * sicmedUserService.save(sicmedUser); addMessage(redirectAttributes,
	 * "保存保存用户成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedUser/?repage"; }
	 * 
	 * @RequiresPermissions("rest:sicmedUser:edit")
	 * 
	 * @RequestMapping(value = "delete") public String delete(SicmedUser
	 * sicmedUser, RedirectAttributes redirectAttributes) {
	 * sicmedUserService.delete(sicmedUser); addMessage(redirectAttributes,
	 * "删除保存用户成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedUser/?repage"; }
	 */

}