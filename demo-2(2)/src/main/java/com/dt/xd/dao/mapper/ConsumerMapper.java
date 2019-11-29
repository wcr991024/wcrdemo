package com.dt.xd.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import model.User.Consumer;
import model.User.ConsumerExample;

@Mapper
public interface ConsumerMapper {
	long countByExample(ConsumerExample example);

	int getCount(@Param("name") String name);

	int deleteByExample(ConsumerExample example);

	int insert(Consumer record);

	int insertSelective(Consumer record);

	Consumer selectByPrimaryKey(String id);

	List<Consumer> selectByExample(ConsumerExample example);

	int updateByExampleSelective(@Param("record") Consumer record, @Param("example") ConsumerExample example);

	int updateByExample(@Param("record") Consumer record, @Param("example") ConsumerExample example);
}