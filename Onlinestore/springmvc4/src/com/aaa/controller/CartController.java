package com.aaa.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.aaa.service.ICartService;
import com.aaa.vo.Cart;
import com.aaa.vo.User;
import com.util.Constants;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Resource
	private ICartService cartService;
	
	@RequestMapping("/toCartList")
	public String toCartList(){
		return "cart/cartList";
	}
	@RequestMapping("/addCart")
	public String addCart(Cart cart,HttpSession session,Model model){
		//User user=(User)session.getAttribute(Constants.USER_SESSION);
		User user=new User();
		user.setUid(1);
		//将目前存在的用户id，放到cart里
		cart.setUid(user.getUid());
		
		if(null==user){
			//未登陆状态操作
			System.out.println("==");
		}else{
			//登录状态
			cartService.addCart(cart);
			List<Cart> selectOne=cartService.selectByUid(user.getUid());
			model.addAttribute("cartList",selectOne);
		}
		return "cart/cartList";
	}
	@RequestMapping("/selectById")
	public String selectById(Cart cart,Model model){
		List<Cart> selectOne = cartService.selectOne(cart);
		model.addAttribute("cartList", selectOne);
		return "cart/cartList";
	}
	@RequestMapping("/select")
	public String select(Model model){
		cartService.select();
		List<Cart> select = cartService.select();
		model.addAttribute("cartList", select);
		return "cart/cartList";
	}
	@RequestMapping("/{id}/deleteById")
	public String deleteById(@PathVariable int id){
		cartService.deleteById(id);
		return "redirect:/cart/select";
		
	}
}
