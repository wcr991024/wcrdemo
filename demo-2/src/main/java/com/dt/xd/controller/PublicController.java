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

import com.dt.xd.User.XdUser;
import com.dt.xd.service.xdUserService;

@Controller
public class PublicController {
	@Resource
	xdUserService XdUserService;

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, Object> login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		int code1 = 0;
		String phone = request.getParameter("phone");
		Map<String, Object> map = new HashMap<String, Object>();
		if (request.getParameter("phone").length() != 11) {
			code1 = 2;
			map.put("code", code1);
		} else {
			if (XdUserService.logine(phone) == 0) {
				code1 = 3;
				map.put("code", code1);
			} else {
				if (imgcode.toUpperCase().equals(code)) {
					List<XdUser> loginList = XdUserService.ope_login(phone);
					XdUser xdUser = loginList.get(0);
					if (xdUser.getPassword().equals(request.getParameter("password"))) {
						session.setAttribute("xdUser", xdUser);
						code1 = 1;
						map.put("code", code1);
					} else {
						map.put("code", code1);
					}
				} else {
					map.put("code", code1);
				}
			}
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/repassword", method = RequestMethod.POST)
	public Map<String, Object> repassword(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		String phone = request.getParameter("phone");
		int code1 = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		if (request.getParameter("phone").length() != 11) {
			code1 = 2;
			map.put("code", code1);
		} else {
			if (XdUserService.logine(phone) == 0) {
				code1 = 3;
				map.put("code", code1);
			} else {
				if (imgcode.toUpperCase().equals(code)) {
					List<XdUser> loginList = XdUserService.ope_login(phone);
					XdUser password = loginList.get(0);
					XdUser user = new XdUser();
					user.setPhone(password.getPhone());
					user.setPassword(request.getParameter("password"));
					if (request.getParameter("password").equals(request.getParameter("password1"))) {
						XdUserService.ope_repassword(user);
						code1 = 1;
						map.put("code", code1);
					} else {
						map.put("code", code1);
					}
				} else {
					map.put("code", code1);
				}
			}
		}
		return map;
	}
}
