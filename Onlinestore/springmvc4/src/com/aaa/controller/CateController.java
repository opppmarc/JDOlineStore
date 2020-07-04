package com.aaa.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaa.service.ICategoryService;
import com.aaa.vo.Category;

@Controller
@RequestMapping("/cate")
public class CateController {
	@Resource
	private ICategoryService cateService;
	
	@RequestMapping("/toAddCate")
	public String toAdd(){
		return "cate/addCate";
	}
	@RequestMapping("/addCate")
	public String addCate(Category c){
		cateService.insertCategory(c);
		return "cate/addCate";
	}
	
}