package com.dt.xd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.ComovementMapper;
import com.dt.xd.service.ComovementService;
import com.dt.xd.xdUser.Comovement;


@Service
public class ComovementServicelmpl implements ComovementService{
	@Resource
	ComovementMapper comovemantMapper;

	public List<Comovement> findProvince() {
		// TODO Auto-generated method stub
		return comovemantMapper.findProvince();
	}

	public List<Comovement> findCity(String pr_name) {
		// TODO Auto-generated method stub
		return comovemantMapper.findCity(pr_name);
	}

	public List<Comovement> findCounty(String ci_name) {
		// TODO Auto-generated method stub
		return comovemantMapper.findCounty(ci_name);
	}

	

}
