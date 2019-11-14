package com.dt.cn.service;
import java.util.List;

import com.dt.cn.model.sysUser.Recommend;
public interface RecommendService {
	List<Recommend> selectByExample(int pageStart, int pageSize, String product_name);
	public long getCount();

	int getCount(String productName);

	long countByExample();
	
}
