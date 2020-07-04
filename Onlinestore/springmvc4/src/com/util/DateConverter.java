package com.util;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date>
{

	public Date convert(String str) 
	{
		return ObjectTools.stringToDate(str, ObjectTools.YYYY_MM_DD_HH);
	}
	
}
