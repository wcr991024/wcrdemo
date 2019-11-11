package com.dt.cn.service.lmpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.cn.dao.mapper.BusinessOrderMapper;
import com.dt.cn.model.sysUser.BusinessOrder;
import com.dt.cn.model.sysUser.BusinessOrderExample;
import com.dt.cn.service.BusinessOrderService;
@Service
public class BusinessOrderImpl implements BusinessOrderService{
@Resource
	BusinessOrderMapper businessOrderMapper ;
	@Override
	public List<BusinessOrder> selectByExample(int pageStart, int pageSize, String business_no) {
		BusinessOrderExample businessOrderExample =new BusinessOrderExample ();
		 businessOrderExample.setPageSize(pageSize);
		 businessOrderExample.setPageStart(pageStart);
		 businessOrderExample.setBusiness_no(business_no);
		return businessOrderMapper.selectByExample(businessOrderExample);
	}

	@Override
	public long getCount() {
		BusinessOrderExample businessOrderExample =new BusinessOrderExample ();
		
		return businessOrderMapper.countByExample(businessOrderExample);
	}

	@Override
	public int getCount(String business_no) {
		
		
		return businessOrderMapper.getCount(business_no);
	}

	@Override
	public long countByExample() {
		BusinessOrderExample businessOrderExample =new BusinessOrderExample ();
		return businessOrderMapper.countByExample(businessOrderExample);
	}

}
