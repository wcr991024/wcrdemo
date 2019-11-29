package com.dt.xd.service;

import java.util.List;
import java.util.Map;

import model.User.Product;


public interface ProductService {
	List<Product> selectByExample(int pageStart, int pageSize, String product_name);

	public long getCount();

	int deleteByPrimaryKey(String product_id);

	int getCount(String product_name);

	long countByExample();

	List<Product> getProductByName(String product_id);

	// int updateByPrimaryKey1(Product record);
	/***********************/
	int updateByExample(Product product);

	int updateByExample1(String product);

	Product selectByPrimaryKey1(String product_id);
}
