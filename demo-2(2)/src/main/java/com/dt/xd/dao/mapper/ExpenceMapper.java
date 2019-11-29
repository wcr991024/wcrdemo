package com.dt.xd.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import model.User.Expence;
import model.User.ExpenceExample;

@Mapper
public interface ExpenceMapper {
	int getCount(@Param("name") String name,@Param("time") int time);

	List<Expence> timeByExample(ExpenceExample example);

	Integer sumPrice1();

	String sumPrice(@Param("time") int time);

	List<Expence> timetwoByExample(ExpenceExample example);

	List<Expence> timethreeByExample(ExpenceExample example);

	long countByExample(ExpenceExample example);

	int deleteByExample(ExpenceExample example);

	int deleteByPrimaryKey(String id);

	int insert(Expence record);

	int insertSelective(Expence record);

	List<Expence> selectByExample(ExpenceExample example);

	Expence selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Expence record, @Param("example") ExpenceExample example);

	int updateByExample(@Param("record") Expence record, @Param("example") ExpenceExample example);

	int updateByPrimaryKeySelective(Expence record);

	int updateByPrimaryKey(Expence record);
}