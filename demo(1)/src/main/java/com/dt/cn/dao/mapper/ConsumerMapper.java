package com.dt.cn.dao.mapper;

import com.dt.cn.model.sysUser.Consumer;
import com.dt.cn.model.sysUser.ConsumerExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ConsumerMapper {
    long countByExample(ConsumerExample example);

    int getCount(@Param("name") String name);
    int deleteByExample(ConsumerExample example);

    int insert(Consumer record);

    int insertSelective(Consumer record);

    List<Consumer> selectByExample(ConsumerExample example);

    int updateByExampleSelective(@Param("record") Consumer record, @Param("example") ConsumerExample example);

    int updateByExample(@Param("record") Consumer record, @Param("example") ConsumerExample example);
}