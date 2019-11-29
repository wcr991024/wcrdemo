package com.dt.xd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dt.xd.service.ProductService;

import model.User.Product;


@Controller
public class ProductController1 {
	@Resource
	ProductService productService;

	@RequestMapping("/product")
	public String product(Map<String, Object> map, @RequestParam(defaultValue = "0") int pageStart,
			@RequestParam(defaultValue = "4") int pageSize, @RequestParam(defaultValue = "") String product_name) {
		List<Product> productList = productService.selectByExample(pageStart, pageSize, product_name);
		long pageCount = 0;
		pageCount = productService.getCount(product_name);
		map.put("productList", productList);
		map.put("pageStart", pageStart);
		map.put("pageSize", pageSize);
		map.put("product_name", product_name);
		map.put("pageCount", pageCount);
		return "operator_product";
	}

	@RequestMapping("/delete")
	public ModelAndView deleteByPrimaryKey(@RequestParam(defaultValue = "0", required = false) String product_id) {
		int i = productService.deleteByPrimaryKey(product_id);
		if (i == 1) {
			return new ModelAndView("redirect:/product");
		} else {
			return new ModelAndView("error");
		}
	}

	@ResponseBody
	@RequestMapping("/updateQ")
	public Map<String, Object> updateQ(String product_id) {
		Product product = productService.selectByPrimaryKey1(product_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("product", product);
		return map;
	}
	@ResponseBody
	@RequestMapping("/update")
	public Map<String, Object> update(Product product) {
		//System.out.println(product.getProductName());
		Map<String, Object> map = new HashMap<String, Object>();
		Product pro = productService.selectByPrimaryKey1(product.getProductId());
		pro.setProductInfo(product.getProductInfo());
		pro.setProductName(product.getProductName());
		pro.setPrice(product.getPrice());
		int code = productService.updateByExample(pro);
		map.put("code", code);
		return map;
	}
	
	
	@ResponseBody
	@RequestMapping("/changeStatus")
	public Map<String, Object> changeStatus(String productId,String status) {
		Map<String, Object> map = new HashMap<String, Object>();
		Product product = productService.selectByPrimaryKey1(productId);
		product.setStatus(status);
		int code = productService.updateByExample(product);
		map.put("product", product);
		map.put("code", code);
		return map;
	}
	@ResponseBody
	@RequestMapping("/changeAllStatus")
	public Map<String, Object> updateByExample1(String status) {
		Map<String, Object> map = new HashMap<String, Object>();
		int code = productService.updateByExample1(status);
		//System.out.println(code);
		map.put("code", code);
		return map;
	}
	
	
}
