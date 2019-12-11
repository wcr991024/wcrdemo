package com.dt.xd.dao.mapper;

import com.dt.xd.User.XdServiceUser;
import com.dt.xd.User.XdServiceUserExample;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface XdServiceUserMapper {
    long countByExample(XdServiceUserExample example);

	int deleteByExample(XdServiceUserExample example);

	int deleteByPrimaryKey(String id);

	int insert(XdServiceUser record);

	int insertSelective(XdServiceUser record);

	List<XdServiceUser> selectByExample(XdServiceUserExample example);

	XdServiceUser selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") XdServiceUser record, @Param("example") XdServiceUserExample example);

	int updateByExample(@Param("record") XdServiceUser record, @Param("example") XdServiceUserExample example);

	int updateByPrimaryKeySelective(XdServiceUser record);

	int updateByPrimaryKey(XdServiceUser record);

	
    @Insert("insert into xd_service_user (id,service_phone,service_password,area) values(#{id},#{servicePhone},#{servicePassword},#{area})")
    void register(XdServiceUser xdserviceuser);
    @Select("SELECT COUNT(*) FROM xd_service_user WHERE service_phone=#{servicePhone}") int login(String string);

}