package com.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.aaa.vo.User;
//自定义拦截器，判断如果没有用户登录，则不能访问网站，返回登录页面重新登录
public class AuthorizedInterceptor implements HandlerInterceptor {
	//定义不需要拦截的请求
	private static final String[]IGNORE_URI={"user/toLogin","/404.html"};
	//preHandle方法返回值为true时才会执行。该方法将在整个请求完成之后执行
	//作用清理资源
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
	}
	//Controller的方法调用之后执行
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView arg3) throws Exception {

	}
	//Controller之前执行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		//默认用户没有登录
		boolean flag=false;
		//获得请求的ServletPath
		String servletPath=request.getServletPath();
		//判断请求是否需要拦截
		for(String s:IGNORE_URI){
			if(servletPath.contains(s)){
				flag=true;
				break;
			}
		}
		//拦截请求
		if(!flag){
			//1.获取session中的用户
			User user=(User)request.getSession().getAttribute(Constants.USER_SESSION);
			//2.判断用户是否已经登录
			if(user==null){
				//如果没有登录，则跳转到登录页面
				request.setAttribute("message","请先登录再访问网站");
				request.getRequestDispatcher(Constants.LOGIN).forward(request,response);
				return flag;
			}else{
				flag=true;
			}
		}
		return flag;
	}

}
