package com.dt.xd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dt.xd.service.BusinessOrderService;

import model.User.BusinessOrder;


@Controller
public class BusinessOrderController {
	@Resource
	BusinessOrderService businessOrderService;

	@RequestMapping("/dingdan")
	public String dingdan(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "4") int pageSize, @RequestParam(defaultValue = "") String business_no) {
		List<BusinessOrder> businessOrderList = businessOrderService.selectByExample(pageStart, pageSize, business_no);
		long pageCound = 0;
		pageCound = businessOrderService.getCount(business_no);
		map.put("businessOrderList", businessOrderList);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("business_no", business_no);
		map.put("pageCount", pageCound);
		// System.out.println("====" + businessOrderList.get(0).getOrderPrice());
		return "operator_orderform";
	}
	
	@ResponseBody
	@RequestMapping("/selectorder")
	public Map<String, Object> selectorder(String id) {
		BusinessOrder businessOrder = businessOrderService.selectByPrimaryKey(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("businessOrder", businessOrder);
		return map;
	}
}
