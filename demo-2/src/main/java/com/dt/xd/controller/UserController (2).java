package com.xinda.controller;

import com.xinda.model.User;
import com.xinda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author aliao
 */
@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    /**
     * 登录、生成token
     * @author: aoliao
     * @param: cellphone
     * @param: password
     * @param: model
     * @updateTime: 2019/10/20 18:29  
     * @return: com.xinda.model.User
     */
    public User userLogin(@RequestParam(value = "cellphone",defaultValue = "null") String cellphone,
                            @RequestParam(value = "password",defaultValue = "null") String password,
                            Model model)throws Exception {
        User user = null;
        if (userService.login(cellphone,password)) {
            user = userService.getUser(cellphone, password);
        }
        return user;
    }
}
