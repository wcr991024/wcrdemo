package com.dt.xd.dao.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import model.User.Product;
import model.User.ProductExample;

@Mapper
public interface ProductMapper {
	long countByExample(ProductExample example);

	int deleteByPrimaryKey(String product_id);

	int updateByPrimaryKey(String product_id);

	int deleteByExample(ProductExample example);

	int getCount(@Param("product_name") String product_name);

	int insert(Product record);

	Product selectByPrimaryKey1(String product_id);

	int insertSelective(Product record);

	List<Product> selectByExample(ProductExample example);

	List<Product> selectByExample(@Param("example") ProductExample example, @Param("product_name") String product_name);

	int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

	/// int updateByPrimaryKey1(Product record);
	/****************************/
	int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

	int updateByExample1(@Param("status") String status);

}