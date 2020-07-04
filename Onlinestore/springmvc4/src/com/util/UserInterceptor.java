package com.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.aaa.vo.User;
/**
 * 判断用户权限的spring mvc用户的拦截器
 * @author Administrator
 */
public class UserInterceptor implements HandlerInterceptor {
	//定义不需要拦截的请求
	private static final String[] IGNORE_URI={"/loginForm","/login","/404.html"};
	//该方法需要preHandle方法的返回值为true时才执行
	//在整个请求完成之后执行，作用：用于清理资源
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}
	//该方法需要preHandle方法的返回值为true时才执行
	//时间：在处理器进行处理后执行，也就是Controller的方法调用后执行
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {

	}
	//作用：进行处理器拦截使用，在Controller处理之前进行调用；
	//当preHandle返回false的时候整个请求就结束了
	//如果返回true，则继续执行postHandle和afterCompletion
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object handler) throws Exception {
		boolean flag=false;
		String servletPath=req.getServletPath(); //获得请求的路径，注意
		//判断请求是否拦截
		for(String s:IGNORE_URI){
			if(servletPath.contains(s))
				break;
		}
		//拦截请求;
		if(!flag){
			User user=(User)req.getSession().getAttribute(HrmConstants.USER_SESSION);
			if(user==null){
				req.setAttribute("message","请先登录再访问");
				req.getRequestDispatcher(HrmConstants.LOGIN).forward(req, resp);
				return flag;
			}else{
				flag=true;
			}
		}
		return flag;
	}

}
