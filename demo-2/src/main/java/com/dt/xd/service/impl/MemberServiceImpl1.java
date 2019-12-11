package com.dt.xd.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dt.xd.dao.mapper.Member1Mapper;
import com.dt.xd.service.MemberService1;

import model.User.Member1;
import model.User.Member1Example;

@Service
public class MemberServiceImpl1 implements MemberService1{
	@Resource
	Member1Mapper memberMapper;

	@Override
	public Member1 selectMemberById(String MemberId) {
		return memberMapper.selectByPrimaryKey(MemberId);
	}

	@Override
	public int saveImg(Member1 member) throws Exception {
		int i = memberMapper.saveUserImg(member);
		if(i!=1) {
			throw new Exception("更新用户头像失败");
		}
		return i;
	}

	@Override
	public int updateMemberByExample(Member1 member) {
		Member1Example memberExample = new Member1Example();
		Member1Example.Criteria criteria = memberExample.createCriteria();
		criteria.andIdEqualTo(member.getId());
		return memberMapper.updateByExample(member, memberExample);
	}

	@Override
	public Member1 memberLogin(Map<String, Object> map) {
		return memberMapper.memberLogin(map);
	}

	@Override
	public Member1 selectByCellPhone(String cellphone) {
		return memberMapper.selectByCellPhone(cellphone);
	}

	@Override
	public int insertSelective(Member1 insertMember) {
		return memberMapper.insertSelective(insertMember);
	}

}
