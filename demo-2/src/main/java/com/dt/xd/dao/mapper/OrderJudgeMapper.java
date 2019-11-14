package com.datangedu.cn.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.datangedu.cn.model.BusinessOrder;
@Mapper
public interface OrderJudgeMapper {
	List<BusinessOrder> selectOrderJudge(String status);
}
