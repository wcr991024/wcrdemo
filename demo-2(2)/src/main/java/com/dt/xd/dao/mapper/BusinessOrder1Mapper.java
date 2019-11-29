package com.dt.xd.dao.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import model.User.BusinessOrder1;
import model.User.BusinessOrder1Example;
@Mapper
public interface BusinessOrder1Mapper {
    long countByExample(BusinessOrder1Example example);

    int deleteByExample(BusinessOrder1Example example);

    int deleteByPrimaryKey(String id);

    int insert(BusinessOrder1 record);

    int insertSelective(BusinessOrder1 record);

    List<BusinessOrder1> selectByExample(BusinessOrder1Example example);

    BusinessOrder1 selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BusinessOrder1 record, @Param("example") BusinessOrder1Example example);

    int updateByExample(@Param("record") BusinessOrder1 record, @Param("example") BusinessOrder1Example example);

    int updateByPrimaryKeySelective(BusinessOrder1 record);

    int updateByPrimaryKey(BusinessOrder1 record);
    /*查找已存在的未完成订单*/
	BusinessOrder1 selectUnpaidOrder(String serviceId, String memberId);
	/*按用户名查找订单*/
	List<BusinessOrder1> selectOrderByMemberId(String memberId);
	/*按id模糊查询订单*/
	List<BusinessOrder1> selectLikeByOrderId(String orderId, String memberId,String beginDate,String endDate);
}