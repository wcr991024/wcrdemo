package com.xinda.Config;

import java.util.Arrays;
import java.util.List;

public class PermissUrlConfig {
    public static final List Provider= Arrays.asList(
            "/product/getSort",
            "/product/add",
            "/product/list",
            "/product/delete",
            "/product/getproduct",
            "/product/update",
            "/provide/upshop",
            "/provide/getshop",
            "/provide/uplogin",
            "/product/online",
            "/product/offline"
    );

    public static final List Member = Arrays.asList(
            "/member/productlist",
            "/product/getSort",
            "/api/shoplist",
            "/member/addcart",
            "/member/pluscart",
            "/member/lesscart",
            "/member/setbuynum",
            "/member/delcart",
            "/member/cartlist",
            "/member/getshopimg",
            "/member/play",
            "/order/memberlist",
            "/member/getlogin",
            "/member/uplogin",
            "/member/setpassword"
    );
}
