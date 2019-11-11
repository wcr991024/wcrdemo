package com.dt.cn.controller.sysUser;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dt.cn.model.sysUser.BusinessOrder;
import com.dt.cn.model.sysUser.Consumer;
import com.dt.cn.service.ConsumerService;

@Controller
public class ConsumerController {
	@Resource
	ConsumerService consumerService;
	@RequestMapping("/yonghu")
	public String yonghu(Map<String,Object> map,
			@RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "3") int pageSize,
			@RequestParam(defaultValue="") String name) {
		List<Consumer>  consumerList= consumerService.selectByExample(pageStart, pageSize, name);
		long pageCount=0;
		pageCount=consumerService.getCount(name);
		map.put("consumerList", consumerList);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("name",name);
		map.put("pageCount", pageCount);
		return "operator_user";
		}
}
