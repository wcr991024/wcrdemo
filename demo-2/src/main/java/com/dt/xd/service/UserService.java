package com.datangedu.cn.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.datangedu.cn.model.User;

@Service		//声明服务层
public interface UserService {
	//登录
	User userLoginService(Map<String,Object> map);
}
