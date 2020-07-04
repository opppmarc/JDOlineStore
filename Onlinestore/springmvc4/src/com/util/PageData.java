package com.util;

import java.util.List;

/**
类名：PageData.java
创建人: zhz
修改人:
完成功能:分页返回用
*/
public class PageData{

    //列表
	private  List list;
	//行数
	private int count;

	public PageData(){
	}
	
	public <T> PageData(int count,List<T> list)
	{
		this.count=count;
		this.list=list;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
