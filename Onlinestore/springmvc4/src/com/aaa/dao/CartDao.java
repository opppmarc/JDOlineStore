package com.aaa.dao;

import java.util.List;

import com.aaa.vo.Cart;
//购物车Dao
public interface CartDao {
		public int addCart(Cart cart);
		public List<Cart> selectOne(Cart cart);
		public int updateCart(Cart cart);
		public List<Cart> selectByUid(Integer uid);
		public int deleteById(int id);
		public List<Cart> select();
}