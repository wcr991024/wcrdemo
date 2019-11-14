package com.dt.cn.controller.sysUser;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dt.cn.model.sysUser.BusinessOrder;
import com.dt.cn.model.sysUser.Recommend;
import com.dt.cn.service.RecommendService;

@Controller
public class RecommendController {
	@Resource
	RecommendService  	recommendService ;
	@RequestMapping("/tuijian")
	public String dingdan(Map<String,Object> map,
			@RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "3") int pageSize,
			@RequestParam(defaultValue="") String product_name) {
		List<Recommend>  recommendList= recommendService.selectByExample(pageStart, pageSize,product_name);
		long pageCount=0;
		pageCount=recommendService.getCount(product_name);
		map.put("recommendList", recommendList);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("product_name",product_name);
		map.put("pageCount", pageCount);
		return "operator_recommend";
		}
}
