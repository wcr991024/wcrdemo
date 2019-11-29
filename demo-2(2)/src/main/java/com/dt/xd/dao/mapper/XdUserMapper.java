package com.dt.xd.dao.mapper;

import com.dt.xd.User.XdUser;
import com.dt.xd.User.XdUserExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface XdUserMapper {
    long countByExample(XdUserExample example);

    int deleteByExample(XdUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(XdUser record);

    int insertSelective(XdUser record);

    List<XdUser> selectByExample(XdUserExample example);

    XdUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") XdUser record, @Param("example") XdUserExample example);

    int updateByExample(@Param("record") XdUser record, @Param("example") XdUserExample example);

    int updateByPrimaryKeySelective(XdUser record);

    int updateByPrimaryKey(XdUser record);
    @Select("SELECT COUNT(*) FROM xd_user WHERE phone=#{phone}") int login(String string);
}