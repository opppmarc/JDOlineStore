package com.aaa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaa.dao.ProductDao;
import com.aaa.service.IPorductService;
import com.aaa.vo.Product;
@Service("productService")
public class ProductService implements IPorductService {
	@Resource
	private ProductDao productDao;

	public List<Product> search() {
		return productDao.search();
	}

	public int insertProduct(Product product) {
		return productDao.insertProduct(product);
	}

	public int deleteProduct(int pid) {
		return productDao.deleteProduct(pid);
	}

	public int updateProduct(Product product) {
		return productDao.updateProduct(product);
	}

	public Product searchProduct(int pid) {
		return productDao.searchProduct(pid);
	}

	public Product selectById(Integer pid) {
		return productDao.selectById(pid);
	}

}
