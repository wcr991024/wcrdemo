package com.dt.xd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.ExpenceMapper;
import com.dt.xd.service.ExpenceService;

import model.User.Expence;
import model.User.ExpenceExample;

@Service
public class ExpenceServiceImpl implements ExpenceService{
@Resource
ExpenceMapper expenceMapper;
	@Override
	public long countByExample() {
		ExpenceExample expenceExample = new ExpenceExample();
		return expenceMapper.countByExample(expenceExample);
	}

	@Override
	public long getCount() {
		ExpenceExample expenceExample = new ExpenceExample();
		return expenceMapper.countByExample(expenceExample);
	}

	@Override
	public int getCount(String name,int time) {
		return expenceMapper.getCount(name,time);
	}

	@Override
	public List<Expence> selectByExample(int pageStart, int pageSize, String name) {
		ExpenceExample expenceExample = new ExpenceExample();
		expenceExample.setPageSize(pageSize);
		expenceExample.setPageStart(pageStart);
		expenceExample.setName(name); 
		return expenceMapper.selectByExample(expenceExample);
	}

	@Override
	public List<Expence> timetwoByExample(int pageStart, int pageSize, String name) {
		ExpenceExample expenceExample = new ExpenceExample();
		expenceExample.setPageSize(pageSize);
		expenceExample.setPageStart(pageStart);
		expenceExample.setName(name); 
		return expenceMapper.timetwoByExample(expenceExample);
	}

	@Override
	public List<Expence> timeByExample(int pageStart, int pageSize, String name) {
		ExpenceExample expenceExample = new ExpenceExample();
		expenceExample.setPageSize(pageSize);
		expenceExample.setPageStart(pageStart);
		expenceExample.setName(name); 
		return expenceMapper.timeByExample(expenceExample);
	}

	@Override
	public List<Expence> timethreeByExample(int pageStart, int pageSize, String name) {
		ExpenceExample expenceExample = new ExpenceExample();
		expenceExample.setPageSize(pageSize);
		expenceExample.setPageStart(pageStart);
		expenceExample.setName(name); 
		return expenceMapper.timethreeByExample(expenceExample);}

	@Override
	public int price1() {
		return expenceMapper.sumPrice1();	
		}

	@Override
	public String price(int time) {
		return expenceMapper.sumPrice(time);	
	}

	
}
