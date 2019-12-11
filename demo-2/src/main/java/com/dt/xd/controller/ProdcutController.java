package com.dt.xd.controller;

import com.dt.xd.service.BusinessOrderService1;
import com.dt.xd.service.ProviderProductService1;
import com.dt.xd.util.GetCookie;
import com.dt.xd.util.UniqueId;
import com.dt.xd.util.UploadFile;
import model.User.ProviderProduct1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ProdcutController {
    @Resource
    ProviderProductService1 productService;
    @Resource
    BusinessOrderService1 orderService;

    @ResponseBody
    @RequestMapping("/product/list")
    /**
     * @author: aoliao
     * @param: page
     * @param: style
     * @param: type
     * @param: word
     * @param: request
     * @updateTime: 2019/10/26 18:56
     * @return: com.github.pagehelper.PageInfo<com.xinda.model.ProviderProduct>
     */
    public Map getProductList(@RequestParam(value = "page",defaultValue = "1",required = false) int page,
                              @RequestParam(value = "word",required = false)String word,
                              HttpServletRequest request) throws IOException {
        String providerId = (String) GetCookie.getCookie(request,"providerId");

        //暂时设置7
        int pageSize=7;
        Map mapt=productService.productList(page,pageSize,providerId,word);
        return mapt;
    }

    @RequestMapping(value = "/product/add",method = RequestMethod.POST)
    @ResponseBody
    /**
     * @author: aoliao
     * @param: product
     * @param: file
     * @param: request
     * @updateTime: 2019/10/24 16:32
     * @return: java.util.Map<java.lang.String,java.lang.String>
     */
    public Map<String,String> insertProduct(
            ProviderProduct1 product,
            @RequestParam(value = "file", required = false) MultipartFile file,
            HttpServletRequest request)
            throws IOException{
        // 格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat();
        // a为am/pm的标记
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");
        // 获取当前时间
        Date date = new Date();

        String providerId = (String) GetCookie.getCookie(request,"providerId");


        product.setProviderId(providerId);

        boolean flag = false;
        String save = null;
        Map<String,String> map = new HashMap<>();
        map.put("flag","失败");
        //生成唯一id值
        String productId = UniqueId.getUniqueId();
        product.setId(productId);

        try {
            //文件是否非空
            if (file.getSize()!=0) {
                //保存文件
                save= UploadFile.uploadFile(request,file,product.getProviderId(),product.getServiceName());
                if (!save.isEmpty()){
                    product.setServiceImg(save);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //默认下线
        product.setStatus(0);
        product.setCreateTime(date);
        int status = productService.insertProduct(product);
        //判断插入是否成功
        if (status!=0){
            //将标志置为true
            flag=true;
        }
        //标志为true时，修改flag为成功
        if (flag){map.put("flag","成功");}

        return map;
    }

    @RequestMapping(value = "/product/update",method = RequestMethod.POST)
    @ResponseBody
    /**
     * 更新产品
     * @author: aoliao
     * @param: product
     * @param: file
     * @param: request
     * @updateTime: 2019/11/13 15:03
     * @return: java.util.Map
     */
    public Map upProduct(ProviderProduct1 product,
                         @RequestParam(value = "file", required = false) MultipartFile file,
                         HttpServletRequest request) throws IOException {
        Map map =new  HashMap<String,String>();
        String save;

        String providerId = (String) GetCookie.getCookie(request,"providerId");

        String productId = (String)GetCookie.getCookie(request,"productId");

        try {
            //文件是否非空
            if (file.getSize()!=0) {
                //保存文件
                save= UploadFile.uploadFile(request,file,providerId,product.getServiceName());
                if (!save.isEmpty()){
                    product.setServiceImg(save);
                    product.setProviderId(providerId);
                }
            }else {
                save=productService.getProduct(productId).getServiceImg();
                product.setServiceImg(save);
                product.setProviderId(providerId);
            }
        }catch (Exception e){
            save=productService.getProduct(productId).getServiceImg();
            product.setServiceImg(save);
            product.setProviderId(providerId);
            System.out.println(e.getMessage());
        }

        product.setStatus(0);

        if (productService.upProduct(product,productId)){
            map.put("flag","成功");
        }else {
            map.put("flag","失败");
        }
        return map;
    }

    @RequestMapping(value = "/product/delete")
    @ResponseBody
    public Map<String,String> deleteProduct(@RequestParam(value = "productID")String productID,
                                            HttpServletRequest request)throws Exception{
        ProviderProduct1 providerProduct=productService.getProduct(productID);
        Map<String,String> map=new HashMap<>();
        if (1==productService.deleteProduct(productID)){
            String path = "/uploads/"+providerProduct.getProviderId()+"/"+providerProduct.getServiceName();
            UploadFile.delUploadFile(request,path);
            map.put("flag","删除成功");
            return map;
        }else {
            map.put("flag","删除失败");
            return map;
        }
    }
    @RequestMapping("/product/getproduct")
    @ResponseBody
    /**
     * 获取产品信息
     * @author: aoliao
     * @param: productId
     * @updateTime: 2019/10/28 17:39
     * @return: com.xinda.model.ProviderProduct
     */
    public ProviderProduct1 getProduct(@RequestParam(value = "productId",required = true)String productId){
        return productService.getProduct(productId);
    }

    @RequestMapping("/product/online")
    @ResponseBody
    /**
     * 更新状态为上线
     * @author: aoliao
     * @param: productId
     * @updateTime: 2019/11/2 17:39
     * @return: java.util.Map<java.lang.String,java.lang.String>
     */
    public Map<String,String> onlineProduct(@RequestParam(value = "productId",required = true)String productId){
        System.out.println(productId);
        ProviderProduct1 providerProduct = productService.getProduct(productId);
        providerProduct.setStatus(1);
        Map<String,String> map = new HashMap<>();
        if (productService.upProduct((ProviderProduct1) providerProduct,productId)){
            map.put("flag","更新状态成功");
        }else {
            map.put("flag","更新状态失败");
        }
        return map;
    }
    @RequestMapping("/product/offline")
    @ResponseBody
    /**
     * 更新状态为下线
     * @author: aoliao
     * @param: productId
     * @updateTime: 2019/11/2 17:39
     * @return: java.util.Map<java.lang.String,java.lang.String>
     */
    public Map<String,String> offlineProduct(@RequestParam(value = "productId",required = true)String productId){

        ProviderProduct1 providerProduct = productService.getProduct(productId);
        providerProduct.setStatus(0);
        Map<String,String> map = new HashMap<>();
        if (productService.upProduct((ProviderProduct1) providerProduct,productId)){
            map.put("flag","更新状态成功");
        }else {
            map.put("flag","更新状态失败");
        }
        return map;
    }

}
