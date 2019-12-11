package com.dt.xd.dao.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import model.User.Service;
import model.User.ServiceExample;
@Mapper
public interface ServiceMapper {

    long countByExample(ServiceExample example);
    int getCount(@Param("service_name") String service_name);
    int deleteByExample(ServiceExample example);

    int deleteByPrimaryKey(String id);

	int insert(Service record);

    int insertSelective(Service record);

    List<Service> selectByExample(ServiceExample example);

    Service selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Service record, @Param("example") ServiceExample example);

    int updateByExample(@Param("record") Service record, @Param("example") ServiceExample example);

    int updateByPrimaryKeySelective(Service record);

    int updateByPrimaryKey(Service record);
}