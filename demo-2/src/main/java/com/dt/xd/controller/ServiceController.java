package com.dt.xd.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dt.xd.service.XdServiceUserService;
import com.dt.xd.xdServiceUser.XdServiceUser;

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
		System.out.println("getCommodity====" + request.getParameter("phone"));
		System.out.println("getCommodity====" + request.getParameter("password"));
		int code1 = 0;
		String phone = request.getParameter("phone");
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(imgcode + "=====" + code + "===");
		System.out.println(code);
		if (imgcode.toUpperCase().equals(code)) {
			List<XdServiceUser> loginList = XdServiceUserService.ope_login(phone);
			System.out.println("loginList" + loginList);
			XdServiceUser password = loginList.get(0);
			if (password.getServicePassword().equals(request.getParameter("password"))) {
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
	@RequestMapping(value = "/repassword1", method = RequestMethod.POST)
	public Map<String, Object> repassword(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String imgcode = request.getParameter("imgcode");
		System.out.println("getCommodity====" + request.getParameter("phone"));
		String phone = request.getParameter("phone");
		int code1 = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		if (imgcode.toUpperCase().equals(code)) {
			List<XdServiceUser> loginList = XdServiceUserService.ope_login(phone);
			XdServiceUser password = loginList.get(0);
			XdServiceUser user = new XdServiceUser();
			user.setId(password.getId());
			user.setServicePhone(password.getServicePhone());
			user.setServicePassword(request.getParameter("password"));
			// user.setHeadImg(password.getHeadImg());
			user.setEmail(password.getEmail());
			user.setServiceName(password.getServiceName());
			user.setStatus(password.getStatus());
			user.setTs(password.getTs());
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
		return map;
	}
	/*
	 * @Autowired private XdServiceUserService xdserviceuserService;
	 * 
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/service_register") public String
	 * register(XdServiceUser xdserviceuser){
	 * xdserviceuserService.regist(xdserviceuser);
	 * System.out.println("111111111111111111111"+xdserviceuser); return
	 * "service_login"; }
	 */

	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/service_register") public Map<String, Object>
	 * register(String service_phone, String password, String imgcode, String area)
	 * { Map<String, Object> map = new HashMap<String, Object>(); XdServiceUser
	 * xdserviceuser = new XdServiceUser();
	 * xdserviceuser.setServicePassword(password);
	 * xdserviceuser.setServicePhone(service_phone); xdserviceuser.setArea(area);
	 * XdServiceUserService.regist(xdserviceuser);
	 * System.out.println(xdserviceuser); map.put("code", 1);
	 * System.out.println(xdserviceuser); return map; // return "service_register";
	 * }
	 */

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
		xdserviceuser.setServicePhone(phone);
		xdserviceuser.setServicePassword(password);
		xdserviceuser.setArea(area);
		System.out.println("0000000000000000000000" + xdserviceuser.getServicePhone());
		System.out.println("0000000000000000000000" + xdserviceuser.getArea());
		System.out.println("0000000000000000000000" + xdserviceuser.getServicePassword());
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(request.getParameter("servicePhone").length()!=11) {
			code1 = 2;
			map.put("code", code1);
		}else {
		/*if (xdserviceuser.getServicePhone().equals(request.getParameter("servicePhone"))) {
			code1 = 3;
			map.put("code", code1);
		}else {*/
		if (imgcode.toUpperCase().equals(code)) {

			XdServiceUserService.regist(xdserviceuser);

			code1 = 1;
			map.put("code", code1);
		}

		else {
			map.put("code", code1);
		}}
		return map;

	}

}
