package com.dt.xd.controller;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dt.xd.User.Comovement;
import com.dt.xd.service.ComovementService;





@Controller
public class ComovementController {
	@Resource
	ComovementService comovementService;
	
	@RequestMapping("/selectprovince")
	public String findProvinceController(Map<String,Object> map) {
		List<Comovement> province = comovementService.findProvince();
		map.put("province", province);
		//System.out.println("hello");
		return "e-commerce_register";
	}
	@ResponseBody		//ajax相关注解
	@RequestMapping("/selectcity")
	public Object findCityController(String pr_name) {
		List<Comovement> city= comovementService.findCity(pr_name);
		//System.out.println("world" + pr_name + "!!!" + city);
		//System.out.println("world");
		return city;
	}
	@ResponseBody		//ajax相关注解
	@RequestMapping("/selectcounty")
	public Object findCountyController(String ci_name) {
		List<Comovement> county = comovementService.findCounty(ci_name);
		//System.out.println("!!!" + ci_name + "====" + county);
		return county;
	}

	
}
