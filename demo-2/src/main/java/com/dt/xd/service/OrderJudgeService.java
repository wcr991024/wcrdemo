package com.datangedu.cn.service;

import java.util.List;

import com.datangedu.cn.model.BusinessOrder;

public interface OrderJudgeService {
	public List<BusinessOrder> selectOrderJudge(String status);
}
