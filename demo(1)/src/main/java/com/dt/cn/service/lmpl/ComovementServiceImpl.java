package com.dt.cn.service.lmpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.cn.dao.mapper.ComovementMapper;

import com.dt.cn.model.sysUser.Comovement;
import com.dt.cn.service.ComovementService;


//业务类
@Service 
public class ComovementServiceImpl implements ComovementService{
	@Resource
	ComovementMapper comovementMapper;

	@Override
	public List<Comovement> findProvince() {
	
		return comovementMapper.findProvince();
	}

	@Override
	public List<Comovement> findCity(String pr_name) {
	
		return comovementMapper.findCity(pr_name);
	}

	@Override
	public List<Comovement> findCounty(String ci_name) {
		// TODO Auto-generated method stub
		return comovementMapper.findCounty(ci_name);
	}

	
}
