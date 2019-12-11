package com.dt.xd.service.impl;

import com.dt.xd.dao.mapper.BusinessOrder1Mapper;
import com.dt.xd.service.BusinessOrderService1;
import model.User.BusinessOrder1;
import model.User.BusinessOrder1Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BusinessOrderServiceImpl1 implements BusinessOrderService1{
	@Resource
	BusinessOrder1Mapper businessOrderDao;
	
	@Override
	public int insertSelective(BusinessOrder1 businessOrder) {
		return businessOrderDao.insertSelective(businessOrder);
	}
	/*查询是否存在未支付订单*/
	@Override
	public BusinessOrder1 selectUnpaidOrder(String serviceId, String memberId) {
		return businessOrderDao.selectUnpaidOrder(serviceId,memberId);
	}
	
	@Override
	public BusinessOrder1 selectByPrimaryKey(String orderId) {
		return businessOrderDao.selectByPrimaryKey(orderId);
	}
	@Override
	public int updateByExample(BusinessOrder1 businessOrder,String orderId) {
		BusinessOrder1Example businessOrderExample = new BusinessOrder1Example();
		BusinessOrder1Example.Criteria criteria = businessOrderExample.createCriteria();
		criteria.andIdEqualTo(orderId);
		return businessOrderDao.updateByExample(businessOrder, businessOrderExample);
	}
	@Override
	public List<BusinessOrder1> selectOrderByMemberId(String memberId) {
		return businessOrderDao.selectOrderByMemberId(memberId);
	}
	/*通过主键删除*/
	@Override
	public int deleteByPrimaryKey(String orderId) {
		return businessOrderDao.deleteByPrimaryKey(orderId);
	}
	/*按id模糊查询订单*/
	@Override
	public List<BusinessOrder1> selectLikeByOrderId(String orderId,String memberId,String beginDate,String endDate) {
		return businessOrderDao.selectLikeByOrderId(orderId,memberId,beginDate,endDate);
	}

}
