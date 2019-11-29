package com.dt.xd.service;

import org.springframework.stereotype.Service;

import model.User.ServiceJudge;

@Service
public interface ServiceJudgeService {
	int updateByExampleSelective(ServiceJudge serviceJudge);
	int insertServiceJudge(ServiceJudge serviceJudge);
	ServiceJudge selectByPrimaryKey(String judgeId);
}
