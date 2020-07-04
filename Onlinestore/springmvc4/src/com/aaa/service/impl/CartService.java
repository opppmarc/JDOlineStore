package com.aaa.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.dao.CartDao;
import com.aaa.service.ICartService;
import com.aaa.vo.Cart;
import com.aaa.vo.User;
import com.util.Constants;
//购物车的业务逻辑类
@Service
public class CartService implements ICartService {
	@Resource
	private CartDao cartDao;
	
	@Autowired
	private HttpServletRequest request;
	
	public void addCart(Cart cart) {
		HttpSession session = request.getSession();
		User user=new User();
		user.setUid(1);
		cart.setUid(user.getUid());
		List<Cart> cartList=cartDao.selectOne(cart);
	
		if(cartList.size()==0){
			cartDao.addCart(cart);
		}else{
			cart.setId(cartList.get(0).getId());
			cart.setNum(cartList.get(0).getNum()+1);
			cartDao.updateCart(cart);
		}
		
	}
	
	
	public List<Cart> selectOne(Cart cart) {
		return cartDao.selectOne(cart);
	}


	public int updateCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.updateCart(cart);
	}


	public List<Cart> selectByUid(Integer uid) {
		// TODO Auto-generated method stub
		return cartDao.selectByUid(uid);
	}


	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return cartDao.deleteById(id);
	}


	public List<Cart> select() {
		// TODO Auto-generated method stub
		return cartDao.select();
	}


	
}