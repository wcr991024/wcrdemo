package com.datangedu.cn.service;

import org.springframework.stereotype.Service;

import com.datangedu.cn.model.ServiceJudge;
@Service
public interface ServiceJudgeService {
	int insertServiceJudge(ServiceJudge serviceJudge);

	ServiceJudge selectByPrimaryKey(String judgeId);
}
