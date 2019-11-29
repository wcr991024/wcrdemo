package com.dt.xd.controller;

import com.dt.xd.User.XdServiceUser;
import com.dt.xd.service.XdServiceUserService;
import com.dt.xd.util.MD5Util;
import com.dt.xd.util.UniqueId;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("xdserviceuser")
public class ServiceController {
	@Resource
	XdServiceUserService XdServiceUserService;

	@ResponseBody
	@RequestMapping(value = "/login1", method = RequestMethod.POST)
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
			if (XdServiceUserService.logine(phone) == 0) {
				code1 = 3;
				map.put("code", code1);
			} else {
				if (imgcode.toUpperCase().equals(code)) {
					List<XdServiceUser> loginList = XdServiceUserService.ope_login(phone);
					System.out.println("loginList" + loginList);
					XdServiceUser password = loginList.get(0);
					if (password.getServicePassword().equals(MD5Util.getMD5(request.getParameter("password")))) {
						code1 = 1;
						map.put("code", code1);
						map.put("providerId", password.getId());

						System.out.println(password.getId());
						map.put("loginname", password.getServiceName());
						map.put("loginImg", password.getServiceHead());

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
	@RequestMapping(value = "/repassword1", method = RequestMethod.POST)
	public Map<String, Object> repassword(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		System.out.println("getCommodity====" + request.getParameter("phone"));
		String phone = request.getParameter("phone");
		int code1 = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		if (request.getParameter("phone").length() != 11) {
			code1 = 2;
			map.put("code", code1);
		} else {
			if (XdServiceUserService.logine(phone) == 0) {
				code1 = 3;
				map.put("code", code1);
			} else {
				if (imgcode.toUpperCase().equals(code)) {
					List<XdServiceUser> loginList = XdServiceUserService.ope_login(phone);
					XdServiceUser password = loginList.get(0);
					XdServiceUser user = new XdServiceUser();
					user.setId(loginList.get(0).getId());
					user.setServicePhone(password.getServicePhone());
					user.setServicePassword(MD5Util.getMD5(request.getParameter("password")));
					if (request.getParameter("password").equals(request.getParameter("password1"))) {
						XdServiceUserService.ope_repassword(user);
						code1 = 1;
						map.put("code", code1);
					} else {
						map.put("code", code1);
					}
				} else {
					map.put("code", code1);
				}
				System.out.println(imgcode + "=====" + code + "===");
			}
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Map<String, Object> regist(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		String phone = request.getParameter("servicePhone");
		String password = request.getParameter("servicePassword");
		String area = request.getParameter("area");
		int code1 = 0;
		XdServiceUser xdserviceuser = new XdServiceUser();
		xdserviceuser.setId(UniqueId.getUniqueId());
		xdserviceuser.setServicePhone(phone);
		xdserviceuser.setServicePassword(MD5Util.getMD5(password));
		xdserviceuser.setArea(area);
		xdserviceuser.setId(UniqueId.getUniqueId());
		Map<String, Object> map = new HashMap<String, Object>();

		if (request.getParameter("servicePhone").length() != 11) {
			code1 = 2;
			map.put("code", code1);
		} else {
			if (XdServiceUserService.logine(phone) != 0) {
				code1 = 3;
				map.put("code", code1);
			} else {
				if (imgcode.toUpperCase().equals(code)) {

					XdServiceUserService.regist(xdserviceuser);

					code1 = 1;
					map.put("code", code1);
				}

				else {
					map.put("code", code1);
				}
			}
		}
		return map;

	}

}
