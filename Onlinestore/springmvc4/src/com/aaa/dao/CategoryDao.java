package com.aaa.dao;

import java.util.List;

import com.aaa.vo.Category;
import com.aaa.vo.User;

public interface CategoryDao {
//查询
	public List<Category>search();
//增加	
	public int insertCategory(Category category);
//修改
	public int deleteCategory(int cid);
//更新
	public int updateCategory(Category category);
	
	public Category searchCategory(int cid); 

}
