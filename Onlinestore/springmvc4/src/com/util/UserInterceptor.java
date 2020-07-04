package com.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.aaa.vo.User;
/**
 * �ж��û�Ȩ�޵�spring mvc�û���������
 * @author Administrator
 */
public class UserInterceptor implements HandlerInterceptor {
	//���岻��Ҫ���ص�����
	private static final String[] IGNORE_URI={"/loginForm","/login","/404.html"};
	//�÷�����ҪpreHandle�����ķ���ֵΪtrueʱ��ִ��
	//�������������֮��ִ�У����ã�����������Դ
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}
	//�÷�����ҪpreHandle�����ķ���ֵΪtrueʱ��ִ��
	//ʱ�䣺�ڴ��������д����ִ�У�Ҳ����Controller�ķ������ú�ִ��
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {

	}
	//���ã����д���������ʹ�ã���Controller����֮ǰ���е��ã�
	//��preHandle����false��ʱ����������ͽ�����
	//�������true�������ִ��postHandle��afterCompletion
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object handler) throws Exception {
		boolean flag=false;
		String servletPath=req.getServletPath(); //��������·����ע��
		//�ж������Ƿ�����
		for(String s:IGNORE_URI){
			if(servletPath.contains(s))
				break;
		}
		//��������;
		if(!flag){
			User user=(User)req.getSession().getAttribute(HrmConstants.USER_SESSION);
			if(user==null){
				req.setAttribute("message","���ȵ�¼�ٷ���");
				req.getRequestDispatcher(HrmConstants.LOGIN).forward(req, resp);
				return flag;
			}else{
				flag=true;
			}
		}
		return flag;
	}

}
