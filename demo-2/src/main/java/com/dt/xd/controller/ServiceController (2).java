package com.dt.cn.controller.sysUser;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dt.cn.model.sysUser.Service;
import com.dt.cn.service.ServiceService;

@Controller
public class ServiceController {
	@Resource
	ServiceService serviceService;
	
	@RequestMapping("/fuwushang")
	public String fuwushang(Map<String,Object> map,
			@RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "3") int pageSize,
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
}
