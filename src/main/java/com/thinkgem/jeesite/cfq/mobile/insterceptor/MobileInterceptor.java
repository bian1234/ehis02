package com.thinkgem.jeesite.cfq.mobile.insterceptor;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.cfq.common.service.BaseService;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * 手机端RESTful拦截器
 *
 * @author Max
 * @version 2016-08-01
 */
public class MobileInterceptor extends BaseService implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info("进入拦截器");
        String uri = request.getRequestURI();

        String ssid = request.getParameter("ssid");

        logger.debug("获取SSID" + ssid);
        /*if (ssid == null) {
			if (uri.equals("/jeesite/a/rest/sicmedUser/login") || uri.equals("/jeesite/a/rest/sicmedUser/register")
					|| uri.substring(0, 26).equals("/jeesite/a/rest/sicmedCity")
					|| uri.substring(0, 30).equals("/jeesite/a/rest/sicmedHospital")) {
				logger.info("登陆或注册_不拦截");
				return true;
			}
			return false;
		} else {
			if(ssid.equals("666")){
				return true;
			}
			@SuppressWarnings("unchecked")
			Map<Date, Map<String, String>> ssidMap = (Map<Date, Map<String, String>>) SessionIdCacheUtils.get(ssid);
			if (ssidMap != null && ssidMap.size() >= 0) {
				logger.info("SSID验证成功_允许进入Controller");
				return true;
			} else {
				if (uri.equals("/jeesite/a/rest/sicmedUser/login") || uri.equals("/jeesite/a/rest/sicmedUser/register")
						|| uri.substring(0, 26).equals("/jeesite/a/rest/sicmedCity")
						|| uri.substring(0, 30).equals("/jeesite/a/rest/sicmedHospital")) {
					logger.info("登陆或注册_不拦截");
					return true;
				}
				return false;
			}
		}*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}
