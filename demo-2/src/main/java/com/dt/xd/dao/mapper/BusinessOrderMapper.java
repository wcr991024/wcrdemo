package com.dt.xd.dao.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import model.User.BusinessOrder;
import model.User.BusinessOrderExample;

@Mapper
public interface BusinessOrderMapper {
	int getCount(@Param("business_no") String business_no);

	long countByExample(BusinessOrderExample example);

	int deleteByExample(BusinessOrderExample example);

	int deleteByPrimaryKey(String id);

	int insert(BusinessOrder record);

	int insertSelective(BusinessOrder record);

	List<BusinessOrder> selectByExample(BusinessOrderExample example);

	BusinessOrder selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") BusinessOrder record, @Param("example") BusinessOrderExample example);

	int updateByExample(@Param("record") BusinessOrder record, @Param("example") BusinessOrderExample example);

	int updateByPrimaryKeySelective(BusinessOrder record);

	int updateByPrimaryKey(BusinessOrder record);
}