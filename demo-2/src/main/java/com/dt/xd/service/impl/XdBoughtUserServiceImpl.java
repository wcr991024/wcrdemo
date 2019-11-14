package com.dt.xd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.XdBoughtUserMapper;

import com.dt.xd.service.XdBoughtUserService;
import com.dt.xd.xdBoughtUser.XdBoughtUser;
import com.dt.xd.xdBoughtUser.XdBoughtUserExample;


@Service
public class XdBoughtUserServiceImpl implements XdBoughtUserService {
	@Resource
	XdBoughtUserMapper XdBoughtUserMapper;
	@Override
	public List<XdBoughtUser> ope_login(String phone) {
		XdBoughtUserExample xdBoughtUserExample=new XdBoughtUserExample();
		XdBoughtUserExample.Criteria criteria=xdBoughtUserExample.createCriteria();
		criteria.andPhoneEqualTo(phone);
		return XdBoughtUserMapper.selectByExample(xdBoughtUserExample);
	}

	@Override
	public int ope_repassword(XdBoughtUser user) {
		XdBoughtUserExample xdBoughtUserExample=new XdBoughtUserExample();
		XdBoughtUserExample.Criteria criteria=xdBoughtUserExample.createCriteria();
		return XdBoughtUserMapper.updateByExample(user, xdBoughtUserExample);
	}

	@Override
	public int insert(XdBoughtUser record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Autowired
    private XdBoughtUserMapper xdboughtuserMapper;
	@Override
	public void regist(XdBoughtUser xdboughtuser) {
		xdboughtuserMapper.register(xdboughtuser);
		
	}

}
