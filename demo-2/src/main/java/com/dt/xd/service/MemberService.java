package com.datangedu.cn.service;

import org.springframework.stereotype.Service;

import com.datangedu.cn.model.Member;
@Service
public interface MemberService {
	/*通过id查找用户*/
	public Member selectMemberById(String MemberId);
	/*保存头像*/
	public int saveImg(Member member) throws Exception; 
	/*修改信息*/
	public int updateMemberByExample(Member member);
}
