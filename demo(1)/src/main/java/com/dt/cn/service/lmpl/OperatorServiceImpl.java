package com.dt.cn.service.lmpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.cn.dao.mapper.OperatorMapper;
import com.dt.cn.model.sysUser.Operator;
import com.dt.cn.service.OperatorService;

@Service 
public class OperatorServiceImpl implements OperatorService{
	@Resource
	OperatorMapper operatorMapper;
	
	@Override
	public List<Operator> findBusiness() {
		
		return operatorMapper.findBusiness();

}}
