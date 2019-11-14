package com.datangedu.cn.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.MemberMapper;
import com.datangedu.cn.model.Member;
import com.datangedu.cn.model.MemberExample;
import com.datangedu.cn.service.MemberService;
@Service
public class MemberServiceImpl implements MemberService{
	@Resource
	MemberMapper memberMapper;

	@Override
	public Member selectMemberById(String MemberId) {
		return memberMapper.selectByPrimaryKey(MemberId);
	}

	@Override
	public int saveImg(Member member) throws Exception {
		int i = memberMapper.saveUserImg(member);
		if(i!=1) {
			throw new Exception("更新用户头像失败");
		}
		return i;
	}

	@Override
	public int updateMemberByExample(Member member) {
		MemberExample memberExample = new MemberExample();
		MemberExample.Criteria criteria = memberExample.createCriteria();
		criteria.andIdEqualTo(member.getId());
		return memberMapper.updateByExample(member, memberExample);
	}

}
