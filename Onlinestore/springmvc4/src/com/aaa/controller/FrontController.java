package com.aaa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aaa.service.ICategoryService;
import com.aaa.service.IPorductService;
import com.aaa.vo.Category;
import com.aaa.vo.Product;

@Controller
@RequestMapping("/front")
public class FrontController {
	@Resource
	private ICategoryService categoryService;
	@Resource
	private IPorductService productService;
	@RequestMapping("/header")
	public ModelAndView header(){
		ModelAndView mv=new ModelAndView();
		List<Category> categoryList=categoryService.search();
		mv.addObject("categoryList",categoryList);
		//shopList:所有商品信息
		List<Product>productList=productService.search();
		mv.addObject("productList",productList);
		mv.setViewName("../../index");
		return mv;
	}

}
