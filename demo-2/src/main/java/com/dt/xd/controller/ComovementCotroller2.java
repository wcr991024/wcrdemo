package com.dt.xd.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dt.xd.service.ComovementService;
import com.dt.xd.xdUser.Comovement;


@Controller
public class ComovementCotroller2 {
	@Resource
	ComovementService comovemantService;
	
	@RequestMapping("/findprovince1")
	public String  findProvince(Map<String, Object> map) {
		List<Comovement> province =comovemantService.findProvince();
		map.put("province", province);
		System.out.println(province.size());
		//return new ModelAndView("redirect:/service_register.html");
		return "e-commerce_register";
	}
	@RequestMapping("/findcity1")
	@ResponseBody
	public Object findCity(String pr_name) {
		List<Comovement> city =comovemantService.findCity(pr_name);
		return city;
	}
	@RequestMapping("/findcounty1")
	@ResponseBody
	public Object findCounty(String ci_name) {
		List<Comovement> county =comovemantService.findCounty(ci_name);
		return county;
	}
}
