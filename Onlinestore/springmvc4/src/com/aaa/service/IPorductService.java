package com.aaa.service;

import java.util.List;

import com.aaa.vo.Product;

public interface IPorductService {
	public List<Product>search();
	public int insertProduct(Product product);
	public int deleteProduct(int pid);
	public int updateProduct(Product product);
	public Product searchProduct(int pid);
	public Product selectById(Integer pid);

}
