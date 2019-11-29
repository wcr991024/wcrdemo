package com.dt.xd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.ServiceMapper;
import com.dt.xd.service.ServiceService;

import model.User.ServiceExample;

@Service
public class ServiceImpl implements ServiceService {
	@Resource
	ServiceMapper serviceMapper;
	@Override
	public List<model.User.Service> selectByExample(int pageStart, int pageSize, String service_name) {
		ServiceExample serviceExample=new  ServiceExample();
		serviceExample.setPageSize(pageSize);
		serviceExample.setPageStart(pageStart);
		serviceExample.setService_name(service_name);
		return serviceMapper.selectByExample(serviceExample);
	}

	@Override
	public long getCount() {
		ServiceExample serviceExample=new  ServiceExample();
		return serviceMapper.countByExample(serviceExample);
	}

	@Override
	public int getCount(String service_name) {
		
		return serviceMapper.getCount(service_name);
	}

	@Override
	public long countByExample() {
		ServiceExample serviceExample=new  ServiceExample();
		return serviceMapper.countByExample(serviceExample);
	}

	@Override
	public model.User.Service selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return serviceMapper.selectByPrimaryKey(id);
	}

}
