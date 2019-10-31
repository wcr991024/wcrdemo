package com.dt.cn.controller.sysUser;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dt.cn.model.sysUser.SysUser;
import com.dt.cn.model.sysUser.User;
import com.dt.cn.service.lmpl.SysUserServicelmpl;

@Controller
public class TestController {
	
	
	
	@RequestMapping("/testBinder")
public String testBinder(Map<String,Object>map,User sysUser){
		
	map.put("user", sysUser);
		
		//return sysUserServicelmpl.insert(sysUser) == 1?"test":"";
	return "test";
}
}
