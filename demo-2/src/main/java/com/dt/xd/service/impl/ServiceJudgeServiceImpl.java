package com.datangedu.cn.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.ServiceJudgeMapper;
import com.datangedu.cn.model.ServiceJudge;
import com.datangedu.cn.service.ServiceJudgeService;
@Service
public class ServiceJudgeServiceImpl implements ServiceJudgeService{
	@Resource
	ServiceJudgeMapper serviceJudgeMapper;

	@Override
	public int insertServiceJudge(ServiceJudge serviceJudge) {
		return serviceJudgeMapper.insertSelective(serviceJudge);
	}

	@Override
	public ServiceJudge selectByPrimaryKey(String judgeId) {
		return serviceJudgeMapper.selectByPrimaryKey(judgeId);
	}

}
