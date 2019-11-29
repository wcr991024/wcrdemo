package com.dt.xd.service;

import java.util.List;

import model.User.BusinessOrder;

public interface BusinessOrderService {
	long countByExample();

	public long getCount();

	public int getCount(String business_no);

	List<BusinessOrder> selectByExample(int pageStart, int pageSize, String business_no);

	BusinessOrder selectByPrimaryKey(String id);
}
