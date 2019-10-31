package com.dt.cn.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dt.cn.model.sysUser.Comovement;
//准备相应的接口

@Mapper
public interface ComovementMapper {
	
	 List<Comovement> findProvince();
	 List<Comovement> findCity(String pr_name);
	 List<Comovement> findCounty(String ci_name);
}
