package com.aaa.service;

import java.util.List;

import com.aaa.vo.Category;


public interface ICategoryService {
	//查询
	public List<Category>search();
	//增加
	public int insertCategory(Category category);
	//修改
	public int deleteCategory(int cid);
	public int updateCategory(Category category);
	public Category searchCategory(int cid); 
}
