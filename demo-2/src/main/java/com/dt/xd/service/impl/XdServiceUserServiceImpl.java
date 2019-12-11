package com.dt.xd.service.impl;

import com.dt.xd.User.XdServiceUser;
import com.dt.xd.User.XdServiceUserExample;
import com.dt.xd.dao.mapper.XdServiceUserMapper;
import com.dt.xd.service.XdServiceUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class XdServiceUserServiceImpl implements XdServiceUserService{
	@Resource
	XdServiceUserMapper xdServiceUserMapper;

	@Autowired
	private XdServiceUserMapper xdserviceuserMapper;
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
		criteria.andIdEqualTo(user.getId());
		return xdServiceUserMapper.updateByExample(user, xdServiceUserExample);
	}

	@Override
	public void regist(XdServiceUser xdserviceuser) {
		xdserviceuserMapper.register(xdserviceuser);
		
	}

	@Override
	public int logine(String string) {
		return xdserviceuserMapper.login(string);
		
	}

	@Override
	public XdServiceUser getProvider(String providerId) {
		return xdServiceUserMapper.selectByPrimaryKey(providerId);
	}

	@Override
	public boolean existCellphone(String cellphone) {
		XdServiceUserExample providerExample = new XdServiceUserExample();
		XdServiceUserExample.Criteria criteria= providerExample.createCriteria();

		criteria.andServicePhoneEqualTo(cellphone);

		return xdServiceUserMapper.selectByExample(providerExample).size()!=0;
	}

	@Override
	public boolean updateProvider(XdServiceUser provider, String providerId) {
		XdServiceUserExample providerExample = new XdServiceUserExample();
		XdServiceUserExample.Criteria criteria= providerExample.createCriteria();
		criteria.andIdEqualTo(providerId);
		return xdServiceUserMapper.updateByExample(provider,providerExample)!=0;
	}

}
