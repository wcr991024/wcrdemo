package com.dt.cn.service;

import java.util.List;

import org.springframework.stereotype.Service;

public interface ServiceService {
	long countByExample();

	public long getCount();

	public int getCount(String service_name);

	List<com.dt.cn.model.sysUser.Service> selectByExample(int pageStart, int pageSize, String service_name);

}
