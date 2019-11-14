package com.dt.xd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dt.xd.service.xdUserService;
import com.dt.xd.xdUser.XdUser;

@Controller
public class PublicController {
	@Resource
	xdUserService XdUserService;
	
	@ResponseBody
	@RequestMapping(value = "/login",method= RequestMethod.POST)
	public Map<String,Object> login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String)session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		System.out.println("getCommodity===="+request.getParameter("phone"));
		System.out.println("getCommodity===="+request.getParameter("password"));
		int code1 = 0;
		String phone = request.getParameter("phone");
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println(imgcode+"====="+code+"===");
		System.out.println(code);
		if(request.getParameter("phone").length()!=11) {
			code1 = 2;
			map.put("code", code1);
		}else {
		if(imgcode.toUpperCase().equals(code)) {
			List<XdUser> loginList = XdUserService.ope_login(phone);
			System.out.println("loginList" + loginList);
			XdUser password = loginList.get(0);
			if(password.getPassword().equals(request.getParameter("password"))) {
				code1 = 1;
				map.put("code", code1);
			}
			else {
				map.put("code", code1);
			}
		}else {
			map.put("code", code1);
		}}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/repassword",method= RequestMethod.POST)
	public Map<String,Object> repassword(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String)session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		System.out.println("getCommodity===="+request.getParameter("phone"));
		String phone = request.getParameter("phone");
		int code1 = 0;
		Map<String,Object> map = new HashMap<String,Object>();
		if(imgcode.toUpperCase().equals(code)) {
			List<XdUser> loginList = XdUserService.ope_login(phone);
			XdUser password = loginList.get(0);
			XdUser user = new XdUser();
			user.setId(password.getId());
			user.setPhone(password.getPhone());
			user.setPassword(request.getParameter("password"));
			user.setHeadImg(password.getHeadImg());
			user.setEmail(password.getEmail());
			user.setName(password.getName());
			user.setStatus(password.getStatus());
			user.setTs(password.getTs());
			if(request.getParameter("password").equals(request.getParameter("password1"))) {
				XdUserService.ope_repassword(user);
				code1 = 1;
				map.put("code", code1);
			}
			else {
				map.put("code", code1);
			}
		}
		else {
			map.put("code", code1);
		}
		System.out.println(imgcode+"====="+code+"===");
		return map;
	}
}
