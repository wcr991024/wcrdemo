package com.dt.xd.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.ServiceJudgeMapper;
import com.dt.xd.service.ServiceJudgeService;

import model.User.ServiceJudge;
import model.User.ServiceJudgeExample;

@Service
public class ServiceJudgeServiceImpl implements ServiceJudgeService{
	@Resource
	ServiceJudgeMapper serviceJudgeMapper;

	@Override
	public ServiceJudge selectByPrimaryKey(String judgeId) {
		return serviceJudgeMapper.selectByPrimaryKey(judgeId);
	}

	@Override
	public int updateByExampleSelective(ServiceJudge serviceJudge) {
		ServiceJudgeExample serviceJudgeExample = new ServiceJudgeExample();
		ServiceJudgeExample.Criteria criteria = serviceJudgeExample.createCriteria();
		criteria.andIdEqualTo(serviceJudge.getId());
		
		return serviceJudgeMapper.updateByExample(serviceJudge, serviceJudgeExample);
	}

	@Override
	public int insertServiceJudge(ServiceJudge serviceJudge) {
		return serviceJudgeMapper.insertSelective(serviceJudge);
	}

}
