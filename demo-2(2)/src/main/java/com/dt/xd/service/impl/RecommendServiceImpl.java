package com.dt.xd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.RecommendMapper;
import com.dt.xd.service.RecommendService;

import model.User.Recommend;
import model.User.RecommendExample;


@Service
public class RecommendServiceImpl implements RecommendService{
	@Resource
	RecommendMapper recommendMapper;
	@Override
	public List<Recommend> selectByExample(int pageStart, int pageSize, String product_name) {
		RecommendExample recommendExample=new RecommendExample();
		recommendExample.setPageSize(pageSize);
		recommendExample.setPageStart(pageStart);
		recommendExample.setProduct_name(product_name);
		return recommendMapper.selectByExample(recommendExample);
	}

	@Override
	public long getCount() {
		RecommendExample recommendExample=new RecommendExample();
		return recommendMapper.countByExample(recommendExample);
	}

	@Override
	public int getCount(String productName) {
		return recommendMapper.getCount(productName);
	}

	@Override
	public long countByExample() {
		RecommendExample recommendExample=new RecommendExample();
		return recommendMapper.countByExample(recommendExample);
	}

	@Override
	public List<Recommend> orderByExample(int pageStart, int pageSize, String product_name) {
		RecommendExample recommendExample=new RecommendExample();
		recommendExample.setPageSize(pageSize);
		recommendExample.setProduct_name(product_name);
		recommendExample.setPageStart(pageStart);
		return recommendMapper.orderByExample(recommendExample);
	}

	@Override
	public List<Recommend> orderBytwoExample(int pageStart, int pageSize, String product_name) {
		RecommendExample recommendExample=new RecommendExample();
		recommendExample.setPageSize(pageSize);
		recommendExample.setProduct_name(product_name);
		recommendExample.setPageStart(pageStart);
		return recommendMapper.ordertwoByExample(recommendExample);
	}
}
