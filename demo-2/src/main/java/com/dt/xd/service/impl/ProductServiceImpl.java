package com.xinda.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xinda.mapper.ProductStyleMapper;
import com.xinda.mapper.ProductTypeMapper;
import com.xinda.mapper.ProviderProductMapper;
import com.xinda.model.*;
import com.xinda.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author aoliao
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductStyleMapper productStyleMapper;
    @Resource
    ProductTypeMapper productTypeMapper;
    @Resource
    ProviderProductMapper providerProductMapper;

    @Override
    /**
     * 插入数据成功返回1,失败0
     * @author: aoliao
     * @param: product
     * @updateTime: 2019/10/24 11:06
     * @return: int
     */
    public int insertProduct(ProviderProductWithBLOBs product) {
        return providerProductMapper.insertSelective(product);
    }

    @Override
    /**
     * 获取产品类型
     * @author: aoliao
     * @updateTime: 2019/10/21 11:34
     * @return: java.util.List<com.xinda.model.ProductStyleKey>
     */
    public List<ProductStyleKey> getProductStyle() {
        ProductStyleExample productStyleExample = new ProductStyleExample();
        ProductStyleExample.Criteria criteria= productStyleExample.createCriteria();

        criteria.andNameIsNotNull();
        criteria.andStyleIdIsNotNull();

        return productStyleMapper.selectByExample(productStyleExample);
    }

    @Override
    /**
     * 获取产品分类
     * @author: aoliao
     * @updateTime: 2019/10/21 11:34
     * @return: java.util.List<com.xinda.model.ProductTypeKey>
     */
    public List<ProductTypeKey> getProductType() {
        ProductTypeExample productTypeExample = new ProductTypeExample();
        ProductTypeExample.Criteria criteria=productTypeExample.createCriteria();

        criteria.andNameIsNotNull();
        criteria.andTypeIdIsNotNull();
        return productTypeMapper.selectByExample(productTypeExample);

    }

    @Override
    /**
     * @author: aoliao
     * @param: pageNum
     * @param: pageSize
     * @param: providerId
     * @param: style
     * @param: type
     * @param: word
     * @updateTime: 2019/10/26 18:53
     * @return: com.github.pagehelper.PageInfo
     */
    public PageInfo productList(int pageNum, int pageSize,String providerId,String style,String type,String word) {

        ProviderProductExample productExample = new ProviderProductExample();
        ProviderProductExample.Criteria criteria= productExample.createCriteria();
        criteria.andProductIdIsNotNull();
        //根据服务商id来查找
        criteria.andProviderIdEqualTo(providerId);

        //分类
        if (style!=null&&!"".equals(style)&&!"null".equals(style)){

            criteria.andStyleIdEqualTo(style);
        }
        if (type!=null&&!"".equals(type)&&!"null".equals(type)){

            criteria.andTypeIdEqualTo(type);
        }
        //模糊查询
        if (word!=null&&!"".equals(word)&&!"null".equals(word)){
            criteria.andServiceNameLike("%"+word+"%");
        }
        //从第pageNum页开始，每页显示pageSize条记录
        PageHelper.startPage(pageNum, pageSize);
        List<ProviderProductWithBLOBs> productList = providerProductMapper.selectByExampleWithBLOBs(productExample);
        return new PageInfo(productList);
    }

    @Override
    /**
     * 删除服务
     * @author: aoliao
     * @param: productID
     * @updateTime: 2019/10/29 18:17
     * @return: int
     */
    public int deleteProduct(String productID) {
        ProviderProductExample productExample = new ProviderProductExample();
        ProviderProductExample.Criteria criteria= productExample.createCriteria();
        criteria.andProductIdEqualTo(productID);
        return providerProductMapper.deleteByExample(productExample);
    }

    @Override
    /**
     * 获取产品
     * @author: aoliao
     * @param: productID
     * @updateTime: 2019/10/28 13:41
     * @return: com.xinda.model.ProviderProduct
     */
    public ProviderProduct getProduct(String productID) {
        return providerProductMapper.selectByPrimaryKey(productID);
    }

    @Override
    /**
     * 更新服务产品
     * @author: aoliao
     * @param: product
     * @param: productId
     * @updateTime: 2019/10/27 13:41
     * @return: boolean
     */
    public boolean upProduct(ProviderProductWithBLOBs product,String productId) {
        ProviderProductExample productExample = new ProviderProductExample();
        ProviderProductExample.Criteria criteria= productExample.createCriteria();
        criteria.andProductIdEqualTo(productId);

        return providerProductMapper.updateByExampleWithBLOBs(product,productExample)!=0;
    }


}
