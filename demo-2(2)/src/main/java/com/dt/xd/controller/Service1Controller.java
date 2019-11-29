package com.dt.xd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dt.xd.service.ServiceService;

import model.User.Service;


@Controller
public class Service1Controller {
	@Resource
	ServiceService serviceService;
	
	@RequestMapping("/fuwushang")
	public String fuwushang(Map<String,Object> map,
			@RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "4") int pageSize,
			@RequestParam(defaultValue="") String service_name) {
		List<Service> service= serviceService.selectByExample(pageStart, pageSize, service_name);
				long pageCount=0;
		pageCount=serviceService.getCount(service_name);
		map.put("service", service);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("service_name",service_name);
		map.put("pageCount", pageCount);
		return "operator_facilitator";
		}
	@ResponseBody
	@RequestMapping("/selectservice")
	public Map<String, Object> selectservice(String id) {
		Service service = serviceService.selectByPrimaryKey(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("service", service);
		return map;
	}
}
