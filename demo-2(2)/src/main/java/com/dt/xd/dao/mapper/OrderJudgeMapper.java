package com.dt.xd.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import model.User.BusinessOrder1;

@Mapper
public interface OrderJudgeMapper {
	List<BusinessOrder1> selectOrderJudge(String status, String memberId);
}
