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

}

	@Override
	public List<Operator> findUser1() {
		
		return operatorMapper.findUser1();
	}

	@Override
	public List<Operator> findExpence() {
		
		return operatorMapper.findExpence();
	}

	@Override
	public List<Operator> findRecommend() {
		
		return operatorMapper.findRecommend();
	}

	@Override
	public List<Operator> findService() {
		
		return operatorMapper.findService();
	}

	@Override
	public Operator selectByPrimaryKey(String id) {
		
		return operatorMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Operator> selectByName(int pageStart, int pageSize, String username) {
		
		return null;
	}
	

}
