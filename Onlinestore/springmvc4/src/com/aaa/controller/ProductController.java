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
import org.springframework.web.servlet.ModelAndView;

import com.aaa.service.IPorductService;
import com.aaa.vo.Category;
import com.aaa.vo.Product;
import com.util.FileUploadUtil;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Resource
	private IPorductService productService;
	
	@RequestMapping("/search")
	public String searchAll(Model model){
		List<Product>productList=productService.search();
		model.addAttribute("size",productList.size());
		model.addAttribute("productList", productList);
		return "product/productList";		
	}
	@RequestMapping("/{pid}/selectById")
	public ModelAndView selectById(@PathVariable Integer pid){
		ModelAndView mv=new ModelAndView();
		Product product=productService.selectById(pid);
		mv.addObject("product",product);
		mv.setViewName("product/product");
		return mv;
	}
	//增加
	@RequestMapping("/toinsert")
	public String toinsert(){
		return "product/insert";
	}
	@RequestMapping("/insert")
	public String insert(Product product,HttpSession session,@RequestParam(required=false) MultipartFile pic){
		product.setImg(FileUploadUtil.uploadFile(pic,session,"image"));
		productService.insertProduct(product);
		return "redirect:/product/search";
	}
	//删除
	@RequestMapping("/{pid}/deleteProduct")
	public String deleteProduct(@PathVariable int pid){
		int result=productService.deleteProduct(pid);
		return "redirect:/product/search";
	}
	@RequestMapping("/{pid}/toUpdate")
	public String toUpdate(@PathVariable int pid,Model model){	
		Product product=productService.searchProduct(pid);
		model.addAttribute("product",product);		
		return "product/updateProduct";
	}
	@RequestMapping("/updateProduct")
	public String updateProduct(Product product,HttpSession session,@RequestParam(required=false) MultipartFile pic){
		if(pic!=null&&!pic.isEmpty()){
			product.setImg(FileUploadUtil.uploadFile(pic,session,"image"));
		}else{
			product.setImg(product.getImg());
		}
		int result=productService.updateProduct(product);
		System.out.println(result);
		return "redirect:/product/search";
	}
	
}