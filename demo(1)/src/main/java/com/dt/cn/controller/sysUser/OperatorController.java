package com.dt.cn.controller.sysUser;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dt.cn.model.sysUser.Operator;
import com.dt.cn.service.ComovementService;
import com.dt.cn.service.OperatorService;

@Controller
public class OperatorController {
	@Resource
	OperatorService operatorService;
	@RequestMapping("/dingdan")
	public String findBusiness(Map<String,Object> map) {
		List<Operator> business= operatorService.findBusiness();
		map.put("business", business);
		System.out.println(business);
		return "operator_orderform";
		

}}
