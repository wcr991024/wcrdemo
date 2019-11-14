package com.dt.xd.service;

import java.util.List;

import com.dt.xd.xdUser.Comovement;



public interface ComovementService {
	List<Comovement> findProvince();
	List<Comovement> findCity(String pr_name);
	List<Comovement> findCounty(String ci_name);
}
