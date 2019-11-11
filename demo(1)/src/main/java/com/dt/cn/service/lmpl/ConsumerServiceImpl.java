package com.dt.cn.service.lmpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.cn.dao.mapper.ConsumerMapper;
import com.dt.cn.model.sysUser.Consumer;
import com.dt.cn.model.sysUser.ConsumerExample;
import com.dt.cn.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService{
	@Resource
	ConsumerMapper consumerMapper;
	@Override
	public List<Consumer> selectByExample(int pageStart, int pageSize, String name) {
		ConsumerExample consumerExample=new ConsumerExample();
		consumerExample.setPageSize(pageSize);
		consumerExample.setPageStart(pageStart);
		consumerExample.setName(name);
		return consumerMapper.selectByExample(consumerExample);
	}

	@Override
	public long getCount() {
		ConsumerExample consumerExample=new ConsumerExample();
		return consumerMapper.countByExample(consumerExample);
	}

	@Override
	public int getCount(String name) {
		
		return consumerMapper.getCount(name);
	}

	@Override
	public long countByExample() {
		ConsumerExample consumerExample=new ConsumerExample();
		return consumerMapper.countByExample(consumerExample);
	}

}
