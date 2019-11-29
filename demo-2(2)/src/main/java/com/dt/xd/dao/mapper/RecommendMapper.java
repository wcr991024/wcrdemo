package com.dt.xd.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import model.User.Recommend;
import model.User.RecommendExample;

@Mapper
public interface RecommendMapper {
	List<Recommend> orderByExample(RecommendExample example);

	List<Recommend> ordertwoByExample(RecommendExample example);

	
	long countByExample(RecommendExample example);

	int getCount(@Param("product_name") String product_name);

	int deleteByExample(RecommendExample example);

	int deleteByPrimaryKey(String id);

	int insert(Recommend record);

	int insertSelective(Recommend record);

	List<Recommend> selectByExample(RecommendExample example);

	Recommend selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Recommend record, @Param("example") RecommendExample example);

	int updateByExample(@Param("record") Recommend record, @Param("example") RecommendExample example);

	int updateByPrimaryKeySelective(Recommend record);

	int updateByPrimaryKey(Recommend record);
}