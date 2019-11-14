package com.dt.cn.service.lmpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.cn.dao.mapper.RecommendMapper;
import com.dt.cn.model.sysUser.Recommend;
import com.dt.cn.model.sysUser.RecommendExample;
import com.dt.cn.service.RecommendService;

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
}
