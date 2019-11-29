package com.dt.xd.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import model.User.Member1;
import model.User.Member1Example;
@Mapper
public interface Member1Mapper {
    long countByExample(Member1Example example);

    int deleteByExample(Member1Example example);

    int deleteByPrimaryKey(String id);

    int insert(Member1 record);

    int insertSelective(Member1 record);

    List<Member1> selectByExampleWithBLOBs(Member1Example example);

    List<Member1> selectByExample(Member1Example example);

    Member1 selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Member1 record, @Param("example") Member1Example example);

    int updateByExampleWithBLOBs(@Param("record") Member1 record, @Param("example") Member1Example example);

    int updateByExample(@Param("record") Member1 record, @Param("example") Member1Example example);

    int updateByPrimaryKeySelective(Member1 record);

    int updateByPrimaryKeyWithBLOBs(Member1 record);

    int updateByPrimaryKey(Member1 record);
    /*修改头像*/
    int saveUserImg(Member1 member);
    
    Member1 memberLogin(Map<String,Object> map);
    /*按手机号查找*/
	Member1 selectByCellPhone(String cellphone);
}