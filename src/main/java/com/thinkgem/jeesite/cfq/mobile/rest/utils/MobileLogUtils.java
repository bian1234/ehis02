//package com.thinkgem.jeesite.modules.cfq.mobile.rest.utils;
//
//import java.lang.reflect.Method;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.springframework.web.method.HandlerMethod;
//
//import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;
//import com.thinkgem.jeesite.common.config.Global;
//import com.thinkgem.jeesite.common.utils.CacheUtils;
//import com.thinkgem.jeesite.common.utils.Exceptions;
//import com.thinkgem.jeesite.common.utils.SpringContextHolder;
//import com.thinkgem.jeesite.common.utils.StringUtils;
//import com.thinkgem.jeesite.modules.cfq.sys.dao.PrescriptionLogDao;
//import com.thinkgem.jeesite.modules.cfq.sys.dao.PrescriptionMenuDao;
//import com.thinkgem.jeesite.modules.cfq.sys.entity.PrescriptionLog;
//import com.thinkgem.jeesite.modules.cfq.sys.entity.PrescriptionMenu;
//import com.thinkgem.jeesite.modules.cfq.sys.entity.PrescriptionUser;
//
///**
// * 字典工具类
// * @author ThinkGem
// * @version 2014-11-7
// */
//public class MobileLogUtils {
//	
//	public static final String CACHE_MENU_NAME_PATH_MAP = "menuNamePathMap";
//	
//	private static PrescriptionLogDao prescriptionLogDao = SpringContextHolder.getBean(PrescriptionLogDao.class);
//	private static PrescriptionMenuDao prescriptionMenuDao = SpringContextHolder.getBean(PrescriptionMenuDao.class);
//	
//	/**
//	 * 保存日志
//	 */
//	public static void saveLog(HttpServletRequest request, String title){
//		saveLog(request, null, null, title);
//	}
//	
//	/**
//	 * 保存日志
//	 */
//	public static void saveLog(HttpServletRequest request, Object handler, Exception ex, String title){
//		PrescriptionUser prescriptionUser = PrescriptionUserUtils.getPrescriptionUser();
//		if (prescriptionUser != null && prescriptionUser.getId() != null){
//			PrescriptionLog prescriptionLog = new PrescriptionLog();
//			prescriptionLog.setTitle(title);
//			prescriptionLog.setType(ex == null ? PrescriptionLog.TYPE_ACCESS : PrescriptionLog.TYPE_EXCEPTION);
//			prescriptionLog.setRemoteAddr(StringUtils.getRemoteAddr(request));
//			prescriptionLog.setUserAgent(request.getHeader("user-agent"));
//			prescriptionLog.setRequestUri(request.getRequestURI());
//			prescriptionLog.setParams(request.getParameterMap());
//			prescriptionLog.setMethod(request.getMethod());
//			// 异步保存日志
//			new SaveLogThread(prescriptionLog, handler, ex).start();
//		}
//	}
//
//	/**
//	 * 保存日志线程
//	 */
//	public static class SaveLogThread extends Thread{
//		
//		private PrescriptionLog prescriptionLog;
//		private Object handler;
//		private Exception ex;
//		
//		public SaveLogThread(PrescriptionLog prescriptionLog, Object handler, Exception ex){
//			super(SaveLogThread.class.getSimpleName());
//			this.prescriptionLog = prescriptionLog;
//			this.handler = handler;
//			this.ex = ex;
//		}
//		
//		@Override
//		public void run() {
//			// 获取日志标题
//			if (StringUtils.isBlank(prescriptionLog.getTitle())){
//				String permission = "";
//				if (handler instanceof HandlerMethod){
//					Method m = ((HandlerMethod)handler).getMethod();
//					RequiresPermissions rp = m.getAnnotation(RequiresPermissions.class);
//					permission = (rp != null ? StringUtils.join(rp.value(), ",") : "");
//				}
//				prescriptionLog.setTitle(getMenuNamePath(prescriptionLog.getRequestUri(), permission));
//			}
//			// 如果有异常，设置异常信息
//			prescriptionLog.setException(Exceptions.getStackTraceAsString(ex));
//			// 如果无标题并无异常日志，则不保存信息
//			if (StringUtils.isBlank(prescriptionLog.getTitle()) && StringUtils.isBlank(prescriptionLog.getException())){
//				return;
//			}
//			// 保存日志信息
//			prescriptionLog.preInsert();
//			prescriptionLogDao.insert(prescriptionLog);
//		}
//	}
//
//	/**
//	 * 获取菜单名称路径（如：系统设置-机构用户-用户管理-编辑）
//	 */
//	public static String getMenuNamePath(String requestUri, String permission){
//		String href = StringUtils.substringAfter(requestUri, Global.getAdminPath());
//		@SuppressWarnings("unchecked")
//		Map<String, String> menuMap = (Map<String, String>)CacheUtils.get(CACHE_MENU_NAME_PATH_MAP);
//		if (menuMap == null){
//			menuMap = Maps.newHashMap();
//			List<PrescriptionMenu> prescriptionMenuList = prescriptionMenuDao.findAllList(new PrescriptionMenu());
//			for (PrescriptionMenu prescriptionMenu : prescriptionMenuList){
//				// 获取菜单名称路径（如：系统设置-机构用户-用户管理-编辑）
//				String namePath = "";
//				if (prescriptionMenu.getParentIds() != null){
//					List<String> namePathList = Lists.newArrayList();
//					for (String id : StringUtils.split(prescriptionMenu.getParentIds(), ",")){
//						if (PrescriptionMenu.getRootId().equals(id)){
//							continue; // 过滤跟节点
//						}
//						for (PrescriptionMenu pm : prescriptionMenuList){
//							if (pm.getId().equals(id)){
//								namePathList.add(pm.getName());
//								break;
//							}
//						}
//					}
//					namePathList.add(prescriptionMenu.getName());
//					namePath = StringUtils.join(namePathList, "-");
//				}
//				// 设置菜单名称路径
//				if (StringUtils.isNotBlank(prescriptionMenu.getHref())){
//					menuMap.put(prescriptionMenu.getHref(), namePath);
//				}else if (StringUtils.isNotBlank(prescriptionMenu.getPermission())){
//					for (String p : StringUtils.split(prescriptionMenu.getPermission())){
//						menuMap.put(p, namePath);
//					}
//				}
//				
//			}
//			CacheUtils.put(CACHE_MENU_NAME_PATH_MAP, menuMap);
//		}
//		String menuNamePath = menuMap.get(href);
//		if (menuNamePath == null){
//			for (String p : StringUtils.split(permission)){
//				menuNamePath = menuMap.get(p);
//				if (StringUtils.isNotBlank(menuNamePath)){
//					break;
//				}
//			}
//			if (menuNamePath == null){
//				return "";
//			}
//		}
//		return menuNamePath;
//	}
//
//	
//}
