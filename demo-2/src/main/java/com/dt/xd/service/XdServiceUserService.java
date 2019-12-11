package com.dt.xd.service;


import java.util.List;

import com.dt.xd.User.XdServiceUser;



public interface XdServiceUserService {
public  List<XdServiceUser> ope_login(String phone) ;
	
	public int ope_repassword(XdServiceUser user);
	void regist(XdServiceUser xdserviceuser);
	int logine(String string);

	XdServiceUser getProvider(String providerId);

	public boolean existCellphone(String cellphone);


	public boolean updateProvider(XdServiceUser provider,String providerId);
}
