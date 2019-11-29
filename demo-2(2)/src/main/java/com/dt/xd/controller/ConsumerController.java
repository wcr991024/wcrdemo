package com.dt.xd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dt.xd.service.ConsumerService;

import model.User.Consumer;

@Controller
public class ConsumerController {
	@Resource
	ConsumerService consumerService;

	@RequestMapping("/yonghu")
	public String yonghu(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "4") int pageSize, @RequestParam(defaultValue = "") String name) {
		List<Consumer> consumerList = consumerService.selectByExample(pageStart, pageSize, name);
		long pageCount = 0;
		pageCount = consumerService.getCount(name);
		map.put("consumerList", consumerList);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("name", name);
		map.put("pageCount", pageCount);
		return "operator_user";
	}
	@ResponseBody
	@RequestMapping("/selectconsumer")
	public Map<String, Object> selectconsumer(String id) {
		Consumer consumer = consumerService.selectByPrimaryKey(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("consumer", consumer);
		return map;
	}
}
