package com.dt.cn.service;

import java.util.List;
import java.util.Map;

import com.dt.cn.model.sysUser.SysUser;

public interface SysUserService {

	List<SysUser> getSystemUserById(Integer id);

	int insert(SysUser record);

	int deleteByPrimaryKey(Integer id);

	SysUser selectByPrimaryKey(Integer id);

	int updateByPrimaryKey(SysUser record);

	SysUser selectSysUser(Map<String,String> map);
	 List<SysUser> selectByExample(int pageStart,int pageSize,String username);
	//添加总数的函数,不需要和Mapper接口方法一致 随便取函数名
	 public long getCount();
     int getCount(String username);
	 //三个参数页面用到
	List<SysUser> selectByName(int pageStart,int pageSize,String username);
int updateImg(SysUser sysUser);

	

}
