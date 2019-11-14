package com.dt.xd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.XdServiceUserMapper;
import com.dt.xd.dao.mapper.XdUserMapper;
import com.dt.xd.service.XdServiceUserService;
import com.dt.xd.xdServiceUser.XdServiceUser;
import com.dt.xd.xdServiceUser.XdServiceUserExample;
import com.dt.xd.xdUser.XdUserExample;
@Service
public class XdServiceUserServiceImpl implements XdServiceUserService{
	@Resource
	XdServiceUserMapper xdServiceUserMapper;
	@Override
	public List<XdServiceUser> ope_login(String phone) {
		XdServiceUserExample xdServiceUserExample=new XdServiceUserExample();
		XdServiceUserExample.Criteria criteria=xdServiceUserExample.createCriteria();
		criteria.andServicePhoneEqualTo(phone);
		return xdServiceUserMapper.selectByExample(xdServiceUserExample);
	}

	@Override
	public int ope_repassword(XdServiceUser user) {
		XdServiceUserExample xdServiceUserExample=new XdServiceUserExample();
		XdServiceUserExample.Criteria criteria=xdServiceUserExample.createCriteria();
		return xdServiceUserMapper.updateByExample(user, xdServiceUserExample);
	}
	@Autowired
    private XdServiceUserMapper xdserviceuserMapper;
	@Override
	public void regist(XdServiceUser xdserviceuser) {
		xdserviceuserMapper.register(xdserviceuser);
		
	}

}
