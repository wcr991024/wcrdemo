package com.xinda.controller;

import com.github.pagehelper.PageInfo;
import com.xinda.service.OrderService;
import com.xinda.utils.GetCookie;
import com.xinda.utils.JwtOperat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


/**
 * @author: aoliao
 * @updateTime: 2019/11/4 8:55
 */
@RequestMapping("/order")
@Controller
public class OrderContrller {
    @Autowired
    OrderService orderService;
    @RequestMapping("/memberlist")
    @ResponseBody
    public PageInfo getServiceOrder(@RequestParam(value = "page",defaultValue = "1",required = false) int page,
                                    @RequestParam(value = "word",required = false)String word,
                                    @RequestParam(value = "startDate",required = false) String startDate,
                                    @RequestParam(value = "endDate",required = false) String endDate,
                                    HttpServletRequest request) throws IOException {

        String token = (String) GetCookie.getCookie(request,"token");

        JwtOperat jwtOperat = new JwtOperat();
        Map<String,String> subjectMap = jwtOperat.getSubject(token);
        //取出会员id
        String memberId = subjectMap.get("userid");

        //暂时设置5
        int pageSize=2;

        Date newStartDate=null;
        Date newEndDate=null;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


        if (!"".equals(startDate)&&!"".equals(endDate)){
            //尝试转换时间
            try {
                newStartDate = format.parse(startDate);
                System.out.println(newStartDate);

                newEndDate = format.parse(endDate);
                System.out.println(newEndDate);
                return orderService.getOrderList(page,pageSize,memberId,word,newStartDate,newEndDate);
            } catch (ParseException e) {

                System.out.println("#################################");
                System.out.println("时间转换失败");
                e.printStackTrace();
            }
        }

        System.out.println(word);


        return orderService.getOrderList(page,pageSize,memberId,word,newStartDate,newEndDate);

    }
}
