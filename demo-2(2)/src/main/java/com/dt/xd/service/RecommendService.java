package com.dt.xd.service;
import java.util.List;

import model.User.Recommend;

public interface RecommendService {
	List<Recommend> selectByExample(int pageStart, int pageSize, String product_name);
	public long getCount();
	List<Recommend> orderByExample(int pageStart, int pageSize, String product_name);

	List<Recommend> orderBytwoExample(int pageStart, int pageSize, String product_name);

	int getCount(String productName);

	long countByExample();
	
}
