package com.dt.xd.service;

import java.util.List;

import com.dt.xd.xdBoughtUser.XdBoughtUser;




public interface XdBoughtUserService {
public List<XdBoughtUser> ope_login(String phone);
	
	public int ope_repassword(XdBoughtUser user);
	int insert(XdBoughtUser record);
	void regist(XdBoughtUser xdboughtuser);
}
