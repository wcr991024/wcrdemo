package com.dt.xd.service;

import java.util.List;

import com.dt.xd.xdServiceUser.XdServiceUser;



public interface XdServiceUserService {
public  List<XdServiceUser> ope_login(String phone) ;
	
	public int ope_repassword(XdServiceUser user);
	void regist(XdServiceUser xdserviceuser);
}
