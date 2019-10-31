package com.dt.cn.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dt.cn.model.sysUser.Operator;




@Mapper
public interface OperatorMapper {
	List<Operator> findBusiness();

}
