
package com.dt.xd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dt.xd.service.XdBoughtUserService;
import com.dt.xd.xdBoughtUser.XdBoughtUser;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoughtController {

	@Resource
	XdBoughtUserService XdBoughtUserService;

	@ResponseBody

	@RequestMapping(value = "/login2", method = RequestMethod.POST)
	public Map<String, Object> login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		System.out.println("getCommodity====" + request.getParameter("phone"));
		System.out.println("getCommodity====" + request.getParameter("password"));
		int code1 = 0;
		String phone = request.getParameter("phone");
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(imgcode + "=====" + code + "===");
		System.out.println(code);
		if (imgcode.toUpperCase().equals(code)) {
			List<XdBoughtUser> loginList = XdBoughtUserService.ope_login(phone);
			System.out.println("loginList" + loginList);
			XdBoughtUser password = loginList.get(0);
			if (password.getPassword().equals(request.getParameter("password"))) {
				code1 = 1;
				map.put("code", code1);
			} else {
				map.put("code", code1);
			}
		} else {
			map.put("code", code1);
		}
		return map;
	}

	@ResponseBody

	@RequestMapping(value = "/repassword2", method = RequestMethod.POST)
	public Map<String, Object> repassword(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		System.out.println("getCommodity====" + request.getParameter("phone"));
		String phone = request.getParameter("phone");
		int code1 = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		if (imgcode.toUpperCase().equals(code)) {
			List<XdBoughtUser> loginList = XdBoughtUserService.ope_login(phone);
			XdBoughtUser password = loginList.get(0);
			XdBoughtUser user = new XdBoughtUser();
			user.setId(password.getId());
			user.setPhone(password.getPhone());
			user.setPassword(request.getParameter("password"));
			user.setHeadImg(password.getHeadImg());
			user.setEmail(password.getEmail());
			//user.setName(password.getName());
			user.setStatus(password.getStatus());
			user.setTs(password.getTs());
			if (request.getParameter("password").equals(request.getParameter("password1"))) {
				XdBoughtUserService.ope_repassword(user);
				code1 = 1;
				map.put("code", code1);
			} else {
				map.put("code", code1);
			}
		} else {
			map.put("code", code1);
		}
		System.out.println(imgcode + "=====" + code + "===");
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Map<String, Object> regist(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		String phone = request.getParameter("Phone");
		String password = request.getParameter("Password");
		String area = request.getParameter("area");
		int code1 = 0;
		XdBoughtUser xdboughtuser = new XdBoughtUser();
		xdboughtuser.setPhone(phone);
		xdboughtuser.setPassword(password);
		xdboughtuser.setArea(area);
		System.out.println("0000000000000000000000" + xdboughtuser.getPhone());
		System.out.println("0000000000000000000000" + xdboughtuser.getArea());
		System.out.println("0000000000000000000000" + xdboughtuser.getPassword());
		Map<String, Object> map = new HashMap<String, Object>();
		if(request.getParameter("Phone").length()!=11) {
			code1 = 2;
			map.put("code", code1);
		}else {
		/*if (xdboughtuser.getPhone().equals(request.getParameter("Phone"))) {
			code1 = -1;
			map.put("code", code1);
		}else {*/
		if (imgcode.toUpperCase().equals(code)) {

			XdBoughtUserService.regist(xdboughtuser);

			code1 = 1;
			map.put("code", code1);
		}

		else {
			map.put("code", code1);
		}}
		return map;

	}
}
