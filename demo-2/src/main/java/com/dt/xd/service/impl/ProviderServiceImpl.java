package com.xinda.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xinda.mapper.ProviderMapper;
import com.xinda.model.Provider;
import com.xinda.model.ProviderExample;
import com.xinda.service.ProviderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("providerService")
public class ProviderServiceImpl implements ProviderService {
    @Resource
    ProviderMapper providerMapper;
    @Override
    /**
     * 注册
     * @author: aoliao
     * @param: provider
     * @updateTime: 2019/10/26 15:30
     * @return: boolean
     */
    public boolean registProvider(Provider provider)
    {
        int flag = providerMapper.insert(provider);
        return flag != 0;
    }

    @Override
    /**
     * 通过手机号和密码查询用户
     * @author: aoliao
     * @param: cellphone
     * @param: password
     * @updateTime: 2019/10/26 21:58
     * @return: com.xinda.model.Provider
     */
    public Provider loginProvider(String cellphone,String password) {

        ProviderExample providerExample = new ProviderExample();
        ProviderExample.Criteria criteria= providerExample.createCriteria();

        criteria.andCellphoneEqualTo(cellphone);
        criteria.andPasswordEqualTo(password);

        return providerMapper.selectByExampleWithBLOBs(providerExample).get(0);
    }

    @Override
    /**
     * @author: aoliao
     * @param: providerId
     * @updateTime: 2019/10/27 13:46
     * @return: com.xinda.model.Provider
     */
    public Provider getProvider(String providerId) {
        ProviderExample providerExample = new ProviderExample();
        ProviderExample.Criteria criteria= providerExample.createCriteria();
        criteria.andIdEqualTo(providerId);
        return (Provider) providerMapper.selectByExampleWithBLOBs(providerExample).get(0);
    }

    @Override
    /**
     * 修改密码
     * @author: aoliao
     * @param: cellphone
     * @param: password
     * @updateTime: 2019/11/1 14:06
     * @return: com.xinda.model.Provider
     */
    public boolean setPassword(String cellphone, String password) {
        ProviderExample providerExample = new ProviderExample();
        ProviderExample.Criteria criteria= providerExample.createCriteria();
        criteria.andCellphoneEqualTo(cellphone);
        Provider provider = (Provider) providerMapper.selectByExampleWithBLOBs(providerExample).get(0);
        provider.setPassword(password);
        return providerMapper.updateByPrimaryKeyWithBLOBs(provider)!=0;
    }
    @Override
    /**
     * 更新数据
     * @author: aoliao
     * @param: provider
     * @updateTime: 2019/10/30 21:15
     * @return: boolean
     */
    public boolean updateProvider(Provider provider,String providerId) {
        ProviderExample providerExample = new ProviderExample();
        ProviderExample.Criteria criteria= providerExample.createCriteria();
        criteria.andIdEqualTo(providerId);
        return providerMapper.updateByExampleWithBLOBs(provider,providerExample)!=0;
    }
    /**
     * 判断是否数据表中已经有该数据，有则返回真
     * @author: aoliao
     * @param: cellphone
     * @param: password
     * @updateTime: 2019/10/26 16:29
     * @return: boolean
     */
    @Override
    public boolean existProvider(String cellphone, String password) {

        ProviderExample providerExample = new ProviderExample();
        ProviderExample.Criteria criteria= providerExample.createCriteria();

        criteria.andCellphoneEqualTo(cellphone);
        criteria.andPasswordEqualTo(password);

        return providerMapper.selectByExample(providerExample).size()!=0;
    }
    @Override
    /**
     * 通过手机号判断用户是否存在
     * @author: aoliao
     * @param: cellphone
     * @updateTime: 2019/11/1 13:52
     * @return: boolean
     */
    public boolean existCellphone(String cellphone) {

        ProviderExample providerExample = new ProviderExample();
        ProviderExample.Criteria criteria= providerExample.createCriteria();

        criteria.andCellphoneEqualTo(cellphone);

        return providerMapper.selectByExample(providerExample).size()!=0;
    }


    @Override
    /**
     * 判断用户是否存在
     * @author: aoliao
     * @param: providerId
     * @updateTime: 2019/11/1 13:46
     * @return: boolean
     */
    public boolean existProvider(String providerId) {
        return providerMapper.selectByPrimaryKey(providerId)!=null;
    }

    @Override
    /**
     * 获取服务商商铺信息
     * @author: aoliao
     * @updateTime: 2019/11/3 19:28
     * @return: com.github.pagehelper.PageInfo
     */
    public PageInfo providerShop(int pageNum, int pageSize,String word) {
        ProviderExample providerExample = new ProviderExample();
        ProviderExample.Criteria criteria= providerExample.createCriteria();
        criteria.andIdIsNotNull();
        //模糊查询
        if (word!=null&&!"".equals(word)&&!"null".equals(word)){
            criteria.andNameLike("%"+word+"%");
        }
        //从第pageNum页开始，每页显示pageSize条记录
        PageHelper.startPage(pageNum, pageSize);
        List<Provider> providerList = providerMapper.selectByExampleWithBLOBs(providerExample);
        for (int i=0;i<providerList.size();i++)
        {
            Provider provider = providerList.get(i);
            provider.setPassword("");
            provider.setWeixin("");
            provider.setLoginId("");
            provider.setRecommend(null);
            provider.setRegisterTime(null);
            provider.setAuthFile("");
            providerList.set(i,provider);
        }
        return new PageInfo(providerList);
    }

}
