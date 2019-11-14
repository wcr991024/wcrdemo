package com.xinda.service.impl;

import com.xinda.mapper.UserMapper;
import com.xinda.model.User;
import com.xinda.model.UserExample;
import com.xinda.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 管理员账户相关操作
 * @author aoliao
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    private User user;
    @Override
    /**
     * @author: aoliao
     * @param: phone
     * @param: password
     * @updateTime: 2019/10/19 20:43
     * @return: boolean
     */
    public boolean login(String phone, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        criteria.andCellphoneEqualTo(phone);
        criteria.andPasswordEqualTo(password);
        user = userMapper.selectByExample(userExample).get(0);
        return user != null;
    }
    @Override
    /**
     * @author: aoliao
     * @param: phone
     * @param: password
     * @updateTime: 2019/10/19 20:43
     * @return: com.xinda.model.User
     */
    public User getUser(String phone, String password) {
        return user;
    }
    @Override
    /**
     * @author: aoliao
     * @param: phone
     * @updateTime: 2019/10/19 20:43
     * @return: boolean
     */
    public boolean updatePassword(String phone) {
        return false;
    }
}
