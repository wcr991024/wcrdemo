package com.dt.xd.service;

import java.util.List;

import model.User.Service;

public interface ServiceService {
	List<Service> selectByExample(int pageStart, int pageSize, String service_name);

	// 添加总数的函数,不需要和Mapper接口方法一致 随便取函数名
	public long getCount();

	int getCount(String service_name);

	long countByExample();

	Service selectByPrimaryKey(String id);
}