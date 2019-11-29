package com.dt.xd.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dt.xd.service.RecommendService;

import model.User.Recommend;


@Controller
public class RecommendController {
	@Resource
	RecommendService  	recommendService ;
	@ResponseBody
	@RequestMapping("/tuijian")
	public ModelAndView dingdan(Map<String,Object> map,
			@RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "4") int pageSize,
			@RequestParam(defaultValue="") String product_name) {
		List<Recommend>  recommendList= recommendService.selectByExample(pageStart, pageSize,product_name);
		long pageCount=0;
		pageCount=recommendService.getCount(product_name);
		map.put("recommendList", recommendList);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("product_name",product_name);
		map.put("pageCount", pageCount);
		map.put("nihao","tuijian");
		return new ModelAndView("operator_recommend");
		}
	@RequestMapping("/paijia")
	public ModelAndView orderRecommend(Map<String, Object> map, 
			@RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "4") int pageSize, 
			@RequestParam(defaultValue = "") String product_name) {
		List<Recommend> recommendList = recommendService.orderByExample(pageStart, pageSize, product_name);
		long pageCound = 0;
		pageCound = recommendService.getCount(product_name);
		map.put("recommendList", recommendList);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("product_name", product_name);
		map.put("pageCount", pageCound);
		map.put("nihao","paijia");
		return new ModelAndView("operator_recommend");

	}
	@RequestMapping("/paixiao")
	public ModelAndView ordertwoRecommend(Map<String, Object> map, 
			@RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "4") int pageSize, 
			@RequestParam(defaultValue = "") String product_name) {
		List<Recommend> recommendList = recommendService.orderBytwoExample(pageStart, pageSize, product_name);
		long pageCound = 0;
		pageCound = recommendService.getCount(product_name);
		map.put("recommendList", recommendList);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("product_name", product_name);
		map.put("pageCount", pageCound);
		map.put("nihao","paixiao");
		return new ModelAndView("operator_recommend");

	}
}
