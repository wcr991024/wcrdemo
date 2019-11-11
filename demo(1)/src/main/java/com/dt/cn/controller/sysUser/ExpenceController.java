package com.dt.cn.controller.sysUser;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dt.cn.model.sysUser.Expence;
import com.dt.cn.service.ExpenceService;

@Controller
public class ExpenceController {
	@Resource
	ExpenceService expenceService;
	@RequestMapping("/feiyong")
	public String findExpance(Map<String,Object> map,
			@RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "2") int pageSize,
			@RequestParam(defaultValue="") String name) {
		List<Expence> expence= expenceService.selectByExample(pageStart, pageSize, name);
		long pageCount=0;
		pageCount=expenceService.getCount(name);
		map.put("expence", expence);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("name",name);
		map.put("pageCount", pageCount);
		return "operator_expenses";
		}
}
