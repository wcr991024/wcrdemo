package com.dt.cn.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dt.cn.model.sysUser.Operator;
import com.dt.cn.model.sysUser.SysUser;




@Mapper
public interface OperatorMapper {
	List<Operator> findBusiness();
	List<Operator> findUser1();
	List<Operator> findExpence();
	List<Operator> findRecommend();
	List<Operator> findService();
	Operator selectByPrimaryKey(String id);
}
