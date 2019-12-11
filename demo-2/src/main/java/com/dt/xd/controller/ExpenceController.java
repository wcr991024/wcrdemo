package com.dt.xd.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dt.xd.service.ExpenceService;

import model.User.Expence;


@Controller
public class ExpenceController {
	@Resource
	ExpenceService expenceService;
	@ResponseBody
	@RequestMapping("/feiyong")
	public ModelAndView findExpance(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "4") int pageSize, @RequestParam(defaultValue = "") String name) {
		List<Expence> expence = expenceService.selectByExample(pageStart, pageSize, name);
		long pageCount = 0;
		pageCount = expenceService.getCount(name,-1);
		int price=expenceService.price1();
		map.put("expence", expence);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("name", name);
		map.put("pageCount", pageCount);
		map.put("feiyong", "feiyong");
		map.put("price",price);
		return new ModelAndView("operator_expenses");
	}

	@RequestMapping("/qitian")
	public ModelAndView findQi(Map<String, Object> map, 
			@RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "4") int pageSize, 
			@RequestParam(defaultValue = "") String name) {
		List<Expence> expence = expenceService.timeByExample(pageStart, pageSize, name);
		long pageCount = 0;
		pageCount = expenceService.getCount(name,7);
		String price=expenceService.price(7);
		map.put("expence", expence);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("name", name);
		map.put("feiyong", "qitian");
		map.put("pageCount", pageCount);
		map.put("price", price);
		return new ModelAndView("operator_expenses");
	}

	@RequestMapping("/yiyue")
	public ModelAndView findYue(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "4") int pageSize, @RequestParam(defaultValue = "") String name) {
		List<Expence> expence = expenceService.timetwoByExample(pageStart, pageSize, name);
		long pageCount = 0;
		pageCount = expenceService.getCount(name,30);
		String price=expenceService.price(30);
		map.put("expence", expence);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("name", name);
		map.put("pageCount", pageCount);
		map.put("feiyong", "yiyue");
		map.put("price",price);
		return new ModelAndView("operator_expenses");
	}

	@RequestMapping("/jintian")
	public ModelAndView findTian(Map<String, Object> map, 
			@RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "4") int pageSize, 
			@RequestParam(defaultValue = "") String name) {
		List<Expence> expence = expenceService.timethreeByExample(pageStart, pageSize, name);
		long pageCount = 0;
		pageCount = expenceService.getCount(name,0);
		String price=expenceService.price(0);
		map.put("expence", expence);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("name", name);
		map.put("feiyong","jintian");
		map.put("pageCount", pageCount);
		map.put("price",price);
		
		return new ModelAndView("operator_expenses");
	}

	
}
