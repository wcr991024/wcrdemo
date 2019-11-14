package com.xinda.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xinda.mapper.MemberMapper;
import com.xinda.mapper.ProviderProductMapper;
import com.xinda.model.Member;
import com.xinda.model.MemberExample;
import com.xinda.model.ProviderProductExample;
import com.xinda.model.ProviderProductWithBLOBs;
import com.xinda.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("memberService")
/**
 * 会员服务相关。。。
 * @author: aoliao
 * @updateTime: 2019/11/1 18:51
 */
public class MemberServiceImpl implements MemberService {
    @Resource
    MemberMapper memberMapper;
    @Resource
    ProviderProductMapper productMapper;
    @Override
    /**
     * 会员注册
     * @author: aoliao
     * @param: member
     * @updateTime: 2019/11/1 19:00
     * @return: boolean
     */
    public boolean registMember(Member member) {
        return memberMapper.insert(member)!=0;
    }

    @Override
    /**
     * 会员登录
     * @author: aoliao
     * @param: cellphone
     * @param: password
     * @updateTime: 2019/11/1 19:00
     * @return: com.xinda.model.Member
     */
    public Member loginMember(String cellphone, String password) {
        MemberExample memberExample = new MemberExample();
        MemberExample.Criteria criteria = memberExample.createCriteria();
        criteria.andCellphoneEqualTo(cellphone);
        criteria.andPasswordEqualTo(password);
        return memberMapper.selectByExample(memberExample).get(0);
    }

    @Override
    /**
     * 根据id值获取会员
     * @author: aoliao
     * @param: memberId
     * @updateTime: 2019/11/1 19:13
     * @return: com.xinda.model.Member
     */
    public Member getMember(String memberId) {
        MemberExample memberExample = new MemberExample();
        MemberExample.Criteria criteria = memberExample.createCriteria();
        criteria.andIdEqualTo(memberId);
        return memberMapper.selectByExample(memberExample).get(0);
    }

    @Override
    /**
     * 重置会员密码
     * @author: aoliao
     * @param: cellphone
     * @param: password
     * @updateTime: 2019/11/1 19:14
     * @return: boolean
     */
    public boolean setPassword(String cellphone, String password) {
        MemberExample memberExample = new MemberExample();
        MemberExample.Criteria criteria = memberExample.createCriteria();
        criteria.andCellphoneEqualTo(cellphone);

        Member member = memberMapper.selectByExample(memberExample).get(0);

        member.setPassword(password);
        return memberMapper.updateByExampleSelective(member,memberExample)!=0;
    }

    @Override
    /**
     * 更新会员信息
     * @author: aoliao
     * @param: member
     * @param: memberId
     * @updateTime: 2019/11/1 19:14
     * @return: boolean
     */
    public boolean updateMember(Member member, String memberId) {
        MemberExample memberExample = new MemberExample();
        MemberExample.Criteria criteria = memberExample.createCriteria();
        criteria.andIdEqualTo(memberId);
        return memberMapper.updateByExampleSelective(member,memberExample)!=0;
    }

    @Override
    /**
     * 判断是否存在会员
     * @author: aoliao
     * @param: cellphone
     * @param: password
     * @updateTime: 2019/11/1 19:15
     * @return: boolean
     */
    public boolean existMember(String cellphone, String password) {
        MemberExample memberExample = new MemberExample();
        MemberExample.Criteria criteria = memberExample.createCriteria();
        criteria.andCellphoneEqualTo(cellphone);
        criteria.andPasswordEqualTo(password);
        return memberMapper.selectByExample(memberExample).size()!=0;
    }

    @Override
    /**
     * 通过电话号判断用户存在与否
     * @author: aoliao 
     * @param: cellphone
     * @updateTime: 2019/11/1 19:41  
     * @return: boolean
     */
    public boolean existCellphone(String cellphone) {
        MemberExample memberExample = new MemberExample();
        MemberExample.Criteria criteria = memberExample.createCriteria();
        criteria.andCellphoneEqualTo(cellphone);
        return memberMapper.selectByExample(memberExample).size()!=0;
    }

    @Override
    /**
     * 通过会员ID判断是否存在
     * @author: aoliao
     * @param: memberId
     * @updateTime: 2019/11/1 19:41
     * @return: boolean
     */
    public boolean existProvider(String memberId) {
        MemberExample memberExample = new MemberExample();
        MemberExample.Criteria criteria = memberExample.createCriteria();
        criteria.andIdEqualTo(memberId);
        return memberMapper.selectByExample(memberExample).size()!=0;
    }

    @Override
    /**
     * 获取上线服务
     * @author: aoliao
     * @param: pageNum 第几页
     * @param: pageSize 每页数据量
     * @param: style
     * @param: type
     * @param: word
     * @updateTime: 2019/11/2 18:52
     * @return: com.github.pagehelper.PageInfo
     */
    public PageInfo getProductList(int pageNum, int pageSize,  String style, String type, String word) {

        ProviderProductExample productExample = new ProviderProductExample();
        ProviderProductExample.Criteria criteria= productExample.createCriteria();
        criteria.andProductIdIsNotNull();
        criteria.andStatusEqualTo(1);

        //分类
        if (style!=null&&!"".equals(style)&&!"null".equals(style)){
            criteria.andStyleIdEqualTo(style);
        }
        if (type!=null&&!"".equals(type)&&!"null".equals(type)){


            criteria.andTypeIdEqualTo(type);
        }
        //模糊查询
        if (word!=null&&!"".equals(word)&&!"null".equals(word)){
            criteria.andServiceNameLike("%"+word+"%");
        }

        //从第pageNum页开始，每页显示pageSize条记录
        PageHelper.startPage(pageNum, pageSize);
        List<ProviderProductWithBLOBs> productList = productMapper.selectByExampleWithBLOBs(productExample);
        System.out.println(productList.size());
        return new PageInfo(productList);
    }



}
