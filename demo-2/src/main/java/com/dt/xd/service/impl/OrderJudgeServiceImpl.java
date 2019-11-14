package com.datangedu.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.OrderJudgeMapper;
import com.datangedu.cn.model.BusinessOrder;
import com.datangedu.cn.service.OrderJudgeService;
@Service
public class OrderJudgeServiceImpl implements OrderJudgeService{
	@Resource
	OrderJudgeMapper orderJudgeMapper;
	@Override
	public List<BusinessOrder> selectOrderJudge(String status) {
		return orderJudgeMapper.selectOrderJudge(status);
	}

}
