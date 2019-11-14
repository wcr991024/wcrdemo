package com.xinda.service;

import com.github.pagehelper.PageInfo;
import com.xinda.model.Member;

public interface MemberService {

    public boolean registMember(Member member);

    public Member loginMember(String cellphone,String password);

    public Member getMember(String memberId);

    public boolean setPassword(String cellphone,String password);

    public boolean updateMember(Member member,String memberId);

    public boolean existMember(String cellphone,String password);

    public boolean existCellphone(String cellphone);

    public boolean existProvider(String memberId);

    public PageInfo getProductList(int pageNum, int pageSize, String style, String type, String word);

}
