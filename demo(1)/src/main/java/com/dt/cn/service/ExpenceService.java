package com.dt.cn.service;

import java.util.List;

import com.dt.cn.model.sysUser.Expence;

public interface ExpenceService {
	long countByExample();

	public long getCount();

	public int getCount(String name);

	List<Expence> selectByExample(int pageStart, int pageSize, String name);

}
