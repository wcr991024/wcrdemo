package com.dt.xd.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import model.User.Member1;

@Service
public interface MemberService1 {
	/*通过id查找用户*/
	public Member1 selectMemberById(String MemberId);
	/*保存头像*/
	public int saveImg(Member1 member) throws Exception; 
	/*修改信息*/
	public int updateMemberByExample(Member1 member);
	
	Member1 memberLogin(Map<String,Object> map);
	/*按手机号查找*/
	public Member1 selectByCellPhone(String cellphone);
	public int insertSelective(Member1 insertMember);
}
