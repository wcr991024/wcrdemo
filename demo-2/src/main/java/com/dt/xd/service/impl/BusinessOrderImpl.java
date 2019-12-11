package com.dt.xd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.BusinessOrderMapper;
import com.dt.xd.service.BusinessOrderService;

import model.User.BusinessOrder;
import model.User.BusinessOrderExample;

@Service
public class BusinessOrderImpl  implements BusinessOrderService {
	@Resource
	BusinessOrderMapper businessOrderMapper;
	@Override
	public long getCount() {
		BusinessOrderExample businessOrderExample = new BusinessOrderExample();
		return businessOrderMapper.countByExample(businessOrderExample);
	}

	@Override
	public int getCount(String business_no) {
		// TODO Auto-generated method stub
		return businessOrderMapper.getCount(business_no);
	}

	@Override
	public List<BusinessOrder>selectByExample(int pageStart, int pageSize, String business_no) {
		BusinessOrderExample businessOrderExample = new BusinessOrderExample();
		businessOrderExample.setPageSize(pageSize);
		businessOrderExample.setBusiness_no(business_no);
		businessOrderExample.setPageStart(pageStart);
		return    businessOrderMapper.selectByExample(businessOrderExample);
	}

	@Override
	public long countByExample() {
		BusinessOrderExample businessOrderExample = new BusinessOrderExample();
		return businessOrderMapper.countByExample(businessOrderExample);
	}

	@Override
	public BusinessOrder selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return businessOrderMapper.selectByPrimaryKey(id);
	}


}
