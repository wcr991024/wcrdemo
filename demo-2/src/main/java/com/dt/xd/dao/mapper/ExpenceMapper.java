package com.dt.cn.dao.mapper;

import com.dt.cn.model.sysUser.Expence;
import com.dt.cn.model.sysUser.ExpenceExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ExpenceMapper {
	int getCount(@Param("name") String name);
	int select(@Param("buy_time") String buy_time);
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