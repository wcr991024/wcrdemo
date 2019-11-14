package com.dt.xd.service;

import java.util.List;

import com.dt.xd.xdUser.XdUser;


public interface xdUserService {
	
	public List<XdUser> ope_login(String phone);
	
	public int ope_repassword(XdUser user);
}
