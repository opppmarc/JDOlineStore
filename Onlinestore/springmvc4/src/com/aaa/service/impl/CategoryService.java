package com.aaa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aaa.dao.CategoryDao;
import com.aaa.service.ICategoryService;
import com.aaa.vo.Category;

@Service("categoryService")
public class CategoryService implements ICategoryService {
	@Resource
	private CategoryDao categoryDao;
	
	//查询
	public List<Category> search() {
		return categoryDao.search();
	}
	//增加
	public int insertCategory(Category catgory) {
		return categoryDao.insertCategory(catgory);
	}
	//删除
	public int deleteCategory(int cid) {
		return categoryDao.deleteCategory(cid);
	}
	//更新
	public int updateCategory(Category category) {
		return categoryDao.updateCategory(category);
	}
	public Category searchCategory(int cid) {
		return categoryDao.searchCategory(cid);
	}
		
}
