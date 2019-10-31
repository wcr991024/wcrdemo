package com.dt.cn.controller.sysUser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class XindaController {
@RequestMapping("/servicelogin")
	public String login() {
		return "service_login";
	}
}
