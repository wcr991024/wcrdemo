package com.xinda.controller;

import com.github.pagehelper.PageInfo;
import com.xinda.service.ProviderService;
import com.xinda.utils.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class APIController {
    @Autowired
    ProviderService providerService;
    /**
     * 用于生成带四位数字验证码的图片
     */
    @RequestMapping(value = "/captcha")
    @ResponseBody
    public String imagecode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        OutputStream os = response.getOutputStream();
        //返回验证码和图片的map
        Map<String,Object> map = Captcha.getImageCode(86, 37, os);
        String simpleCaptcha = "simpleCaptcha";
        request.getSession().setAttribute(simpleCaptcha, map.get("strEnsure").toString().toLowerCase());
        request.getSession().setAttribute("codeTime",System.currentTimeMillis());
        try {
            ImageIO.write((BufferedImage) map.get("image"), "jpg", os);
        } catch (IOException e) {
            return "";
        }   finally {
            if (os != null) {
                os.flush();
                os.close();
            }
        }
        return null;
    }
    @RequestMapping("/shoplist")
    @ResponseBody
    public PageInfo getProviderList(@RequestParam(value = "page",defaultValue = "1",required = false) int page,
                                    @RequestParam(value = "word",required = false)String word){
        //暂时设置5
        int pageSize=5;
        return  providerService.providerShop(page,pageSize,word);
    }
}