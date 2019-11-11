package com.dt.cn.controller.sysUser;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dt.cn.model.sysUser.BusinessOrder;
import com.dt.cn.service.BusinessOrderService;

@Controller
public class BusinessOrderController {
	@Resource
	BusinessOrderService businessOrderService;
	@RequestMapping("/dingdan")
	public String dingdan(Map<String,Object> map,
			@RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "3") int pageSize,
			@RequestParam(defaultValue="") String business_no) {
		List<BusinessOrder>  businessOrderList= businessOrderService.selectByExample(pageStart, pageSize,business_no);
		long pageCount=0;
		pageCount=businessOrderService.getCount(business_no);
		map.put("businessOrderList", businessOrderList);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("business_no",business_no);
		map.put("pageCount", pageCount);
		return "operator_orderform";
		}
}