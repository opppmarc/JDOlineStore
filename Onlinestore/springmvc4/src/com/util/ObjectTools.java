package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**   
 * @Title: ObjectTools.java 
 * @Package org.platform.tools 
 * @Description: <p>用来帮助校验数据是否为空</p>
 * @author Sniper
 * @date 2015-12-11 上午11:58:19 
 * @version V1.0   
 **/
public class ObjectTools
{
	/*格式化字符串  yyyy-MM-dd */
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	
	/*格式化字符串  yyyy-MM-dd hh:mm:ss */
	public static final String YYYY_MM_DD_HH = "yyyy-MM-dd hh:mm:ss";
	
	
	/** 
	 * @Title: notNull 
	 * @Description: <p>校验Object类型数据否为空，
	 * 				 <br/>如果为空则返回false,反之返回true</p>
	 * @param @param obj
	 * @return boolean    返回类型 
	 * @throws 
	 **/
	public static boolean notNull(Object obj)
	{
		if(obj == null) return true;
		
		return true;
		
	}
	
	
	/** 
	 * @Title: notNull 
	 * @Description: <p>验证集合是否为null或为集合的长度是否为0<br>
	 * 				    如果为null或集合为空,则返回false;反之返回true</p>
	 * @param @param coll
	 * @param @return  参数说明 
	 * @return boolean    返回类型 
	 * @throws 
	 **/
	public static boolean notNull(Collection<Object> coll)
	{
		if(coll == null) return false;
		if(coll.isEmpty()) return false;
		
		return true;
	}
	
	
	
	/** 
	 * @Title: notNull 
	 * @Description: <p>验证字符串是否为Null或为空;<br/>
	 * 				    如果为null或为空则返回false;反之返回true</p>
	 * @param @param str
	 * @param @return  参数说明 
	 * @return boolean    返回类型 
	 * @throws 
	 **/
	public static boolean notNull(String str)
	{
		if(str == null)return false;
		if("".equals(str)) return false;
		
		return true;
		
	}
	
	
	/** 
	 * @Title: notNull 
	 * @Description: <p>检验数组是否为空，<br>
	 * 				     如果为null或数组长度为0,返回false;反之返回true</p>
	 * @param @param obj
	 * @param @return  参数说明 
	 * @return boolean    返回类型 
	 * @throws 
	 **/
	public static boolean notNull(Object[] obj)
	{
		if(obj == null) return false;
		if(obj.length == 0) return false;
		
		return true;
	}
	
	
	/** 
	 * @Title: notNull 
	 * @Description: <p>校验map集合是否为Null或空,<br/>
	 * 					如果为Null或空，则返回false;反之返回true</p>
	 * @param @param map
	 * @param @return  参数说明 
	 * @return boolean    返回类型 
	 * @throws 
	 **/
	public static boolean notNull(Map<Object,Object> map)
	{
		if(map == null) return false;
		if(map.size() == 0) return false;
		
		return true;
	}
	
	/** 
	 * @Title: dateToString 
	 * @Description: <p>格式化日期类型，返回一个yyyy-MM-dd hh:mm:ss格式的字符串</p>
	 * @param @param date
	 * @param @return  参数说明 
	 * @return String    返回类型 
	 * @throws 
	 **/
	public static String dateToString(Date date)
	{
		
		return dateToString(date, YYYY_MM_DD_HH);
	}
	
	/** 
	 * @Title: dateToString 
	 * @Description: <p>格式化日期类型，返回一个按照参数格式化好的字符串</p>
	 * @param @param date
	 * @param @param formatString
	 * @param @return  参数说明 
	 * @return String    返回类型 
	 * @throws 
	 **/
	public static String dateToString(Date date , String formatString)
	{
		if(notNull(date) && notNull(formatString))
		{
			SimpleDateFormat format = new SimpleDateFormat(formatString);
			
			return format.format(date);
		}
		
		return null;
		
	}
	
	
	/** 
	 * @Title: stringToDate 
	 * @Description: <p>将一个指定好格式的字符串转成一个日期类型</p>
	 * @param @param str
	 * @param @param fomatString
	 * @param @return  参数说明 
	 * @return Date    返回类型 
	 * @throws 
	 **/
	public static Date stringToDate(String str , String fomatString)
	{
		
		if(notNull(str) && notNull(fomatString))
		{
			SimpleDateFormat format = new SimpleDateFormat(fomatString);
			
			Date d = null;
			
			try
            {
	            d = format.parse(str);
            } catch (ParseException e)
            {
            	System.out.println("格式化错误！");
            }
            
            return d;
            
		}
	
		return null;
	}
	
	/** 
	 * @Title: stringToDate 
	 * @Description: <p>返回一个yyyy-MM-dd hh:mm:ss格式的日期类型</p>
	 * @param @param str
	 * @param @return  参数说明 
	 * @return Date    返回类型 
	 * @throws 
	 **/
	public static Date stringToDate(String str)
	{
		return stringToDate(str, YYYY_MM_DD_HH);
	}
}
