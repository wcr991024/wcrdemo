package com.dt.cn.service;

import java.util.List;

import com.dt.cn.model.sysUser.Consumer;

public interface ConsumerService {
	List<Consumer> selectByExample(int pageStart, int pageSize, String name);

	public long getCount();

	int getCount(String name);

	long countByExample();
}
