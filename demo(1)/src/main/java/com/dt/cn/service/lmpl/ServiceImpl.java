package com.dt.cn.service.lmpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.cn.dao.mapper.ServiceMapper;
import com.dt.cn.model.sysUser.ServiceExample;
import com.dt.cn.service.ServiceService;

@Service
public class ServiceImpl implements ServiceService{
	@Resource
	ServiceMapper serviceMapper;

	@Override
	public long countByExample() {
		ServiceExample serviceExample=new ServiceExample();
		return serviceMapper.countByExample(serviceExample);
	}

	@Override
	public long getCount() {
		ServiceExample serviceExample=new ServiceExample();
		return serviceMapper.countByExample(serviceExample);
	}

	@Override
	public int getCount(String service_name) {
		// TODO Auto-generated method stub
		return serviceMapper.getCount(service_name);
	}

	@Override
	public List<com.dt.cn.model.sysUser.Service> selectByExample(int pageStart, int pageSize, String service_name) {
		ServiceExample serviceExample=new ServiceExample();
		serviceExample.setService_name(service_name);
		serviceExample.setPageSize(pageSize);
		serviceExample.setPageStart(pageStart);
		return serviceMapper.selectByExample(serviceExample);
		
	}
}
