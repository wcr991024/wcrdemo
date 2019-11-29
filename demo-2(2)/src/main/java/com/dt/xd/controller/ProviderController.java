package com.dt.xd.controller;

import com.dt.xd.User.XdServiceUser;
import com.dt.xd.service.XdServiceUserService;
import com.dt.xd.util.GetCookie;
import com.dt.xd.util.MD5Util;
import com.dt.xd.util.UploadFile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/provide")

public class ProviderController {
    @Resource
    XdServiceUserService providerService;

    @RequestMapping(value = "/getshop")
    @ResponseBody
    /**
     * 获取服务商信息
     * @author: aoliao
     * @param: request
     * @updateTime: 2019/10/31 11:10
     * @return: com.xinda.model.Provider
     */
    public XdServiceUser getShop(HttpServletRequest request) throws IOException {

        String providerId = (String) GetCookie.getCookie(request,"providerId");

        return providerService.getProvider(providerId);
    }


    @RequestMapping(value = "/upshop")
    @ResponseBody
    /**
     * 更新店铺信息
     * @author: aoliao
     * @param: provider
     * @param: file
     * @param: request
     * @updateTime: 2019/10/31 11:12
     * @return: java.util.Map<java.lang.String,java.lang.String>
     */
    public Map<String,String> upProShop(XdServiceUser provider,
                                        @RequestParam(value = "file", required = false) MultipartFile file,
                                        HttpServletRequest request)throws Exception{
        HashMap<String,String> map = new HashMap<>();

        String providerId = (String) GetCookie.getCookie(request,"providerId");

        String save;


        XdServiceUser upPrvovider = providerService.getProvider(providerId);

        //如果电话号和原本不同
        if (!provider.getServicePhone().equals(upPrvovider.getServicePhone())){

            if (providerService.existCellphone(provider.getServicePhone())){

                map.put("flag","修改失败,已经存在该号码的服务商，请更换手机号");
                return map;
            }
        }

        upPrvovider.setQq(provider.getQq());
        upPrvovider.setWorktime(provider.getWorktime());
        upPrvovider.setServicePhone(provider.getServicePhone());
        upPrvovider.setIntroduction(provider.getIntroduction());
        //文件是否非空
        try {
            if (file.getSize()!=0) {
                //保存文件
                save= UploadFile.uploadFile(request,file,providerId,provider.getServiceName());
                if (!save.isEmpty()){

                    upPrvovider.setServiceHead(save);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if (providerService.updateProvider(upPrvovider,providerId)){
            map.put("flag","成功");
        }else {
            map.put("flag","失败");
        }return map;
    }

    @RequestMapping(value = "/uplogin",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> upLogin(XdServiceUser provider,
                                      @RequestParam(value = "file", required = false) MultipartFile file,
                                      HttpServletRequest request)throws Exception{

        String providerId = (String) GetCookie.getCookie(request,"providerId");

        String save = null;

        HashMap<String,String> map = new HashMap<>();

        XdServiceUser upPrvovider = providerService.getProvider(providerId);

        String logImg = upPrvovider.getServiceHead();

        //如果电话号和原本不同
        if (!provider.getServicePhone().equals(upPrvovider.getServicePhone())){
            if (providerService.existCellphone(provider.getServicePhone())){
                map.put("flag","修改失败,该号码已经被使用");
                return map;
            }
        }
        //将更新的数据放置到upPrvovider对象中，使用upPrvovider来更新
        upPrvovider.setServiceHead(provider.getServiceHead());

        if (!provider.getServicePassword().equals(upPrvovider.getServicePassword())){
            upPrvovider.setServicePassword(MD5Util.getMD5(provider.getServicePassword()));
        }

        upPrvovider.setServiceName(provider.getServiceName());
        upPrvovider.setServicePhone(provider.getServicePhone());
        upPrvovider.setWechat(provider.getWechat());
        upPrvovider.setQq(provider.getQq());
        upPrvovider.setArea(provider.getArea());
        upPrvovider.setEmail(provider.getEmail());
        upPrvovider.setId(providerId);

        //文件是否非空
        try {
            if (file.getSize()!=0) {
                //保存文件
                save= UploadFile.uploadFile(request,file,providerId,provider.getServiceName()+"login");
                if (!save.isEmpty()){
                    upPrvovider.setServiceHead(save);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if (upPrvovider.getServiceHead()==null){
            upPrvovider.setServiceHead(logImg);
        }

        if (providerService.updateProvider(upPrvovider,providerId)){

            map.put("flag","成功");
            map.put("logImg",save);
            map.put("logname",upPrvovider.getServiceName());
        }else {
            map.put("flag","失败");

        }
        return map;
    }
}
