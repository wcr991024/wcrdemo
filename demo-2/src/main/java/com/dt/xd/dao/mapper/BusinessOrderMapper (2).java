package com.dt.cn.dao.mapper;

import com.dt.cn.model.sysUser.BusinessOrder;
import com.dt.cn.model.sysUser.BusinessOrderExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BusinessOrderMapper {
	long countByExample(BusinessOrderExample example);

	int getCount(@Param("business_no") String business_no);

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