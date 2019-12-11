package com.dt.xd.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.ProductMapper;
import com.dt.xd.service.ProductService;

import model.User.Product;
import model.User.ProductExample;


@Service
public class ProductImpl implements ProductService {
	@Resource
	ProductMapper productMapper;

	@Override
	public List<Product> selectByExample(int pageStart, int pageSize, String product_name) {
		ProductExample productExample = new ProductExample();
		productExample.setProduct_name(product_name);
		productExample.setPageStart(pageStart);
		productExample.setPageSize(pageSize);
		return productMapper.selectByExample(productExample);
	}

	@Override
	public long getCount() {
		ProductExample productExample = new ProductExample();
		return productMapper.countByExample(productExample);
	}

	@Override
	public int getCount(String product_name) {
		return productMapper.getCount(product_name);
	}

	@Override
	public long countByExample() {
		ProductExample productExample = new ProductExample();
		return productMapper.countByExample(productExample);
	}

	@Override
	public int deleteByPrimaryKey(String product_id) {

		return productMapper.deleteByPrimaryKey(product_id);
	}

	@Override
	public List<Product> getProductByName(String product_id) {
		ProductExample productExample = new ProductExample();
		ProductExample.Criteria criteria = productExample.createCriteria();
		criteria.andPriceEqualTo(product_id);
		return productMapper.selectByExample(productExample, null);
	}

	@Override
	public Product selectByPrimaryKey1(String product_id) {
		return productMapper.selectByPrimaryKey1(product_id);

	}
	/*
	@Override
	public int updateByPrimaryKey1(Product record) {
		// TODO Auto-generated method stub
		return product.updateByPrimaryKey1(record);
	}
	*/

	@Override
	public int updateByExample(Product product) {
		ProductExample productExample = new ProductExample();
		ProductExample.Criteria criteria = productExample.createCriteria();
		criteria.andProductIdEqualTo(product.getProductId());
		return productMapper.updateByExample(product, productExample);
	}

	@Override
	public int updateByExample1(String product) {
		return productMapper.updateByExample1(product);
	}
	
}
