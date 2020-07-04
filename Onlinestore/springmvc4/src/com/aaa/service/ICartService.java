package com.aaa.service;

import java.util.List;


import com.aaa.vo.Cart;
//购物车的service
public interface ICartService {
	public void addCart(Cart cart);
	public List<Cart> selectOne(Cart cart);
	public int updateCart(Cart cart);
	public List<Cart> selectByUid(Integer uid);
	public int deleteById(int id);
	public List<Cart> select();


}
