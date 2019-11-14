package com.dt.cn.service;

import java.util.List;

import com.dt.cn.model.sysUser.Comovement;

public interface ComovementService {
	List<Comovement> findProvince();
	 List<Comovement> findCity(String pr_name);
	 List<Comovement> findCounty(String ci_name);
}
