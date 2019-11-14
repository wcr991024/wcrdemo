package com.xinda.service;

import com.github.pagehelper.PageInfo;
import com.xinda.model.ProductStyleKey;
import com.xinda.model.ProductTypeKey;
import com.xinda.model.ProviderProduct;
import com.xinda.model.ProviderProductWithBLOBs;

import java.util.List;

/**
 * 服务产品接口
 * @author aliao
 */
public interface ProductService {

    public int insertProduct(ProviderProductWithBLOBs product);

    public List<ProductStyleKey> getProductStyle();

    public List<ProductTypeKey> getProductType();

    public PageInfo productList(int pageNum, int pageSize,String providerId,String style,String type,String word);

    public int deleteProduct(String productID);

    public ProviderProduct getProduct(String productID);

    public boolean upProduct(ProviderProductWithBLOBs product, String productId);

}
