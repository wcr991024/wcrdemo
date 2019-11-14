package com.dt.xd.dao.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dt.xd.xdUser.Comovement;


@Mapper
public interface ComovementMapper {
	List<Comovement> findProvince();
	List<Comovement> findCity(String pr_name);
	List<Comovement> findCounty(String ci_name);
	
}
