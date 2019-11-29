package com.dt.xd.service;


import java.util.List;

import model.User.BusinessOrder1;


public interface OrderJudgeService {
	public List<BusinessOrder1> selectOrderJudge(String status, String memberId);
}
