package com.dt.cn.service;

import java.util.List;

import com.dt.cn.model.sysUser.Operator;
import com.dt.cn.model.sysUser.SysUser;

public interface OperatorService {

	List<Operator> findBusiness();
	List<Operator> findUser1();
	List<Operator> findExpence();
	List<Operator> findRecommend();
	List<Operator> findService();
	Operator selectByPrimaryKey(String id);
	List<Operator> selectByName(int pageStart,int pageSize,String username);
}
