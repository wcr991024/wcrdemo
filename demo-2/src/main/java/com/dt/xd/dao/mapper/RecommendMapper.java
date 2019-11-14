package com.dt.cn.dao.mapper;

import com.dt.cn.model.sysUser.Recommend;
import com.dt.cn.model.sysUser.RecommendExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RecommendMapper {
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