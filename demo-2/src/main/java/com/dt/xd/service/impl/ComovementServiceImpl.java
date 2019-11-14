package com.datangedu.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.ComovementMapper;
import com.datangedu.cn.model.Comovement;
import com.datangedu.cn.service.ComovementService;

@Service
public class ComovementServiceImpl implements ComovementService{
	@Resource
	ComovementMapper comovementMapper;
	
	@Override
	public List<Comovement> findProvinceService() {
		return comovementMapper.findProvince();
	}

	@Override
	public List<Comovement> findCityService(String pr_name) {
		return comovementMapper.findCity(pr_name);
	}

	@Override
	public List<Comovement> findCountyService(String ci_name) {
		return comovementMapper.findCounty(ci_name);
	}

}
