package com.dt.xd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.ConsumerMapper;
import com.dt.xd.service.ConsumerService;

import model.User.Consumer;
import model.User.ConsumerExample;


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

	@Override
	public Consumer selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return consumerMapper.selectByPrimaryKey(id);
	}

}
