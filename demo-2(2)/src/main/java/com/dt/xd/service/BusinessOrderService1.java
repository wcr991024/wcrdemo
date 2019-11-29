package com.dt.xd.service;

import model.User.BusinessOrder1;
import org.springframework.stereotype.Service;

import java.util.List;

@Service	
public interface BusinessOrderService1 {

	int insertSelective(BusinessOrder1 businessOrder);
	//查询是否存在未支付订单
	BusinessOrder1 selectUnpaidOrder(String serviceId, String memberId);
	//按主键查找
	BusinessOrder1 selectByPrimaryKey(String orderId);
	/*修改订单状态*/
	int updateByExample(BusinessOrder1 businessOrder,String orderId);
	/*查找订单 通过用户id*/
	List<BusinessOrder1> selectOrderByMemberId(String memberId);
	/*通过主键删除*/
	int deleteByPrimaryKey(String orderId);
	/*按id模糊查询订单*/
	List<BusinessOrder1> selectLikeByOrderId(String orderId, String memberId,String beginDate,String endDate);


}
