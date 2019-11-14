package com.dt.xd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.XdUserMapper;
import com.dt.xd.service.xdUserService;
import com.dt.xd.xdUser.XdUser;
import com.dt.xd.xdUser.XdUserExample;

@Service
public class xdUserServiceImpl implements xdUserService{
	@Resource
	XdUserMapper xdUserMapper;
	@Override
	public List<XdUser> ope_login(String phone) {
		XdUserExample xdUserExample=new XdUserExample();
		XdUserExample.Criteria criteria=xdUserExample.createCriteria();
		criteria.andPhoneEqualTo(phone);
		return xdUserMapper.selectByExample(xdUserExample);
	}
	@Override
	public int ope_repassword(XdUser user) {
		XdUserExample xdUserExample=new XdUserExample();
		XdUserExample.Criteria criteria=xdUserExample.createCriteria();
		return xdUserMapper.updateByExample(user, xdUserExample);
	}

}
