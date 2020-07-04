package com.aaa.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aaa.service.ICategoryService;
import com.aaa.vo.Category;
import com.aaa.vo.Product;
import com.aaa.vo.User;

@Controller
@RequestMapping("/category")
public class CategoryController {
		
	@Resource
	private ICategoryService categoryService;
	//查询
	@RequestMapping("/search")
	public String searchAll(Model model){
		List<Category> categoryList=categoryService.search();
		model.addAttribute("size",categoryList.size());
		model.addAttribute("categoryList",categoryList);
		return "category/categoryList";	
	}
	@RequestMapping("/toinsert")
	public String toinsert(){
		return "category/insert";
	}
	@RequestMapping("/insert")
	public String insert(Category category){
		int result=-1;
		result=categoryService.insertCategory(category);
		return "redirect:/category/search";
	}
	@RequestMapping("/{cid}/deleteCategory")
	public String deleteCategory(@PathVariable int cid){
		int result=categoryService.deleteCategory(cid);
		return "redirect:/category/search";
	}
	@RequestMapping("/{cid}/toUpdate")
	public String toUpdate(@PathVariable int cid,Model model){
		//我们可以利用service进行查询
		Category category=categoryService.searchCategory(cid);
		model.addAttribute("category",category);//利用model来传递数据		
		return "category/updateCategory";//页面
	}
	@RequestMapping("/updateCategory")
	public String updateCategory(Category category){
		//category.setCid(cid);
		int result=categoryService.updateCategory(category);
		System.out.println(result);
		return "redirect:/category/search";
	}
}
