package com.xinda.service;

import com.xinda.model.User;

/**
 * 管理员
 * @author aoliao
 */
public interface UserService {
    /** 登录接口*/
    public boolean login(String phone,String password);
    /** 获取用户接口*/
    public User getUser(String phone,String password);
    /** 修改密码接口*/
    public boolean updatePassword(String phone);

}
