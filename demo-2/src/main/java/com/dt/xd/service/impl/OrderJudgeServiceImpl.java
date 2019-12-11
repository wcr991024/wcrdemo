package com.dt.xd.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.OrderJudgeMapper;
import com.dt.xd.service.OrderJudgeService;

import model.User.BusinessOrder1;

@Service
public class OrderJudgeServiceImpl implements OrderJudgeService{
	@Resource
	OrderJudgeMapper orderJudgeMapper;
	@Override
	public List<BusinessOrder1> selectOrderJudge(String status,String memberId) {
		return orderJudgeMapper.selectOrderJudge(status,memberId);
	}

}
