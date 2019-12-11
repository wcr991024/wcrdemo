package com.dt.xd.service;

import java.util.List;

import model.User.Consumer;

public interface ConsumerService {
	List<Consumer> selectByExample(int pageStart, int pageSize, String name);

	public long getCount();

	int getCount(String name);

	long countByExample();

	Consumer selectByPrimaryKey(String id);
}
