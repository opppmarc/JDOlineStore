
package com.util;


import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class PageUtil {
	
	private int  recordCount,pageSize,pageNo;//总数量   每页显示数量   页数
    private int pageCount=0;//总页数
	private String pageString,css="", url="";
	
	/**
	 * 构造方法，初始化其他参数
	 * @param pageSize
	 * @param pageNo
	 * @param recordCount
	 * @param request
	 */
	public PageUtil(int pageSize,int pageNo,int recordCount,HttpServletRequest request)
	{
		this.pageNo=pageNo;
		this.recordCount=recordCount;
		if(this.recordCount<0)
			this.recordCount=0;
		this.pageSize=pageSize;
		//链接地址
		this.url=request.getRequestURI()+"?";
		Enumeration  pNames=request.getParameterNames();  
		 while(pNames.hasMoreElements()){  
		  String  name=(String)pNames.nextElement();
		  if( name.equalsIgnoreCase("pageNo")==false )
			{
			  if(url.charAt(url.length()-1)=='?')
				  url+=name+"="+request.getParameter(name);
			  else
				  url+="&"+name+"="+request.getParameter(name);
			}
		  }
		 if(url.charAt(url.length()-1)!='?')
		 {
			 url+="&";
		 }
	}
	/**
	 * 计算拼接分页字符串
	 * @return
	 */
	public String getPageString()
	{
	
		if(recordCount%pageSize==0)
		{
			pageCount=recordCount/pageSize;
		}
		else
		{
			pageCount=recordCount/pageSize+1;
		}

		//当前页
		if(pageNo<1)
		{
			pageNo=1;
		}
		//尾页
		if(pageNo>pageCount)
		{
			pageNo=pageCount;
		}
	
		//上页和首页
		if (pageNo>1)
		{
			pageString="<a href='"+url+"pageNo=1'><font class='"+css+"'>首页</font></a>&nbsp;";
			pageString+="<a href='"+url+"pageNo="+(pageNo-1)+"'><font class='"+css+"'>上页</font></a>&nbsp;";
		}
		else
		{
			pageString="<font class='"+css+"'>首页</font>&nbsp;";
			pageString+="<font class='"+css+"'>上页</font>&nbsp;";
		}
  

		pageString+="<font color=red>"+pageNo+"</font>&nbsp;";
		
		//下页和尾页
		if(pageNo<pageCount)
		{
			pageString+="<a href='"+url+"pageNo="+(pageNo+1)+"' class='"+css+"'>下页</a>&nbsp;";
			pageString+="<a href='"+url+"pageNo="+pageCount+"' class='"+css+"'>尾页</a>&nbsp;";
		}
		else
		{
			pageString+="<font class='"+css+"'>下页</font>&nbsp;";
			pageString+="<font class='"+css+"'>尾页</font>";
		}
		//跳转页
		pageString+="&nbsp;&nbsp;转到第<select id=pageNo onchange=\"window.location.href='"+url+"pageNo='+this.value\">";;
		for(int i=1;i<=this.pageCount;i++) {
				if( pageNo==i) {
					pageString+="<option value="+i+" selected>"+i+"</option>";
				} else {
					pageString+="<option value="+i+">"+i+"</option>";
				}
		}
			pageString+="</select>页";
			
		return "<div align=center class="+css+">共"+pageCount+"页,"+recordCount+"条记录&nbsp;&nbsp;"+pageString+"</div>";		
	}
	public void setPageNo(int pageNo) 
	{
		this.pageNo=pageNo;
	}
	
	public void setCss(String css) 
	{
		this.css=css;
	}
	
	public void setUrl(String url) 
	{
		this.url=url;
	}
	public static void main(String[] args) {
		System.out.println("abc".charAt("abc".length()-1));
	}
}




	
	
	

