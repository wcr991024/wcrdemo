package com.dt.xd.dao.mapper;

import com.dt.xd.xdBoughtUser.XdBoughtUser;
import com.dt.xd.xdBoughtUser.XdBoughtUserExample;
import com.dt.xd.xdServiceUser.XdServiceUser;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface XdBoughtUserMapper {
    long countByExample(XdBoughtUserExample example);

	int deleteByExample(XdBoughtUserExample example);

	int deleteByPrimaryKey(String id);

	int insert(XdBoughtUser record);

	int insertSelective(XdBoughtUser record);

	List<XdBoughtUser> selectByExample(XdBoughtUserExample example);

	XdBoughtUser selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") XdBoughtUser record, @Param("example") XdBoughtUserExample example);

	int updateByExample(@Param("record") XdBoughtUser record, @Param("example") XdBoughtUserExample example);

	int updateByPrimaryKeySelective(XdBoughtUser record);

	int updateByPrimaryKey(XdBoughtUser record);
	@Insert("insert into xd_bought_user (phone,password,area) values(#{phone},#{password},#{area})")
    void register(XdBoughtUser xdboughtuser);

	
}