package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**   
 * @Title: ObjectTools.java 
 * @Package org.platform.tools 
 * @Description: <p>��������У�������Ƿ�Ϊ��</p>
 * @author Sniper
 * @date 2015-12-11 ����11:58:19 
 * @version V1.0   
 **/
public class ObjectTools
{
	/*��ʽ���ַ���  yyyy-MM-dd */
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	
	/*��ʽ���ַ���  yyyy-MM-dd hh:mm:ss */
	public static final String YYYY_MM_DD_HH = "yyyy-MM-dd hh:mm:ss";
	
	
	/** 
	 * @Title: notNull 
	 * @Description: <p>У��Object�������ݷ�Ϊ�գ�
	 * 				 <br/>���Ϊ���򷵻�false,��֮����true</p>
	 * @param @param obj
	 * @return boolean    �������� 
	 * @throws 
	 **/
	public static boolean notNull(Object obj)
	{
		if(obj == null) return true;
		
		return true;
		
	}
	
	
	/** 
	 * @Title: notNull 
	 * @Description: <p>��֤�����Ƿ�Ϊnull��Ϊ���ϵĳ����Ƿ�Ϊ0<br>
	 * 				    ���Ϊnull�򼯺�Ϊ��,�򷵻�false;��֮����true</p>
	 * @param @param coll
	 * @param @return  ����˵�� 
	 * @return boolean    �������� 
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
	 * @Description: <p>��֤�ַ����Ƿ�ΪNull��Ϊ��;<br/>
	 * 				    ���Ϊnull��Ϊ���򷵻�false;��֮����true</p>
	 * @param @param str
	 * @param @return  ����˵�� 
	 * @return boolean    �������� 
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
	 * @Description: <p>���������Ƿ�Ϊ�գ�<br>
	 * 				     ���Ϊnull�����鳤��Ϊ0,����false;��֮����true</p>
	 * @param @param obj
	 * @param @return  ����˵�� 
	 * @return boolean    �������� 
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
	 * @Description: <p>У��map�����Ƿ�ΪNull���,<br/>
	 * 					���ΪNull��գ��򷵻�false;��֮����true</p>
	 * @param @param map
	 * @param @return  ����˵�� 
	 * @return boolean    �������� 
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
	 * @Description: <p>��ʽ���������ͣ�����һ��yyyy-MM-dd hh:mm:ss��ʽ���ַ���</p>
	 * @param @param date
	 * @param @return  ����˵�� 
	 * @return String    �������� 
	 * @throws 
	 **/
	public static String dateToString(Date date)
	{
		
		return dateToString(date, YYYY_MM_DD_HH);
	}
	
	/** 
	 * @Title: dateToString 
	 * @Description: <p>��ʽ���������ͣ�����һ�����ղ�����ʽ���õ��ַ���</p>
	 * @param @param date
	 * @param @param formatString
	 * @param @return  ����˵�� 
	 * @return String    �������� 
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
	 * @Description: <p>��һ��ָ���ø�ʽ���ַ���ת��һ����������</p>
	 * @param @param str
	 * @param @param fomatString
	 * @param @return  ����˵�� 
	 * @return Date    �������� 
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
            	System.out.println("��ʽ������");
            }
            
            return d;
            
		}
	
		return null;
	}
	
	/** 
	 * @Title: stringToDate 
	 * @Description: <p>����һ��yyyy-MM-dd hh:mm:ss��ʽ����������</p>
	 * @param @param str
	 * @param @return  ����˵�� 
	 * @return Date    �������� 
	 * @throws 
	 **/
	public static Date stringToDate(String str)
	{
		return stringToDate(str, YYYY_MM_DD_HH);
	}
}
