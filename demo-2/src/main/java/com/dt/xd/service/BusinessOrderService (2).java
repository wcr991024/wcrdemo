package com.dt.cn.service;

import java.util.List;

import com.dt.cn.model.sysUser.BusinessOrder;

public interface BusinessOrderService {

	List<BusinessOrder> selectByExample(int pageStart, int pageSize, String business_no);

	// 添加总数的函数,不需要和Mapper接口方法一致 随便取函数名
	public long getCount();

	int getCount(String business_no);

	long countByExample();
}
