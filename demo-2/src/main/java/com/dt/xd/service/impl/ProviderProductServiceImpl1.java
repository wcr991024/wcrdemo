package com.dt.xd.service.impl;

import com.dt.xd.dao.mapper.ProviderProduct1Mapper;
import com.dt.xd.service.ProviderProductService1;
import model.User.ProviderProduct1;
import model.User.ProviderProduct1Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ProviderProductServiceImpl1 implements ProviderProductService1{
	@Resource
	ProviderProduct1Mapper providerProductMapper;

	/**
	 * 商品相关
	 */
	@Override
	public List<ProviderProduct1> selectAllProviderService(int pageStart,int pageSize) {
		ProviderProduct1Example providerProductExample = new ProviderProduct1Example();
		providerProductExample.setDistinct(false);
		providerProductExample.setPageStart(pageStart);
		providerProductExample.setPageSize(pageSize);
		providerProductExample.setOrderByClause("`PRICE` DESC,`id` DESC");
		//System.out.println("pageStart=" + pageStart + "pageSize=" +pageSize);
		return providerProductMapper.selectAllProviderDao(providerProductExample);
	}

	@Override
	public long countAllProviderService() {
		ProviderProduct1Example providerProductExample = new ProviderProduct1Example();
		return providerProductMapper.countByExample(providerProductExample);
	}

	/**
	 * 	通过服务商 模糊查找服务
	 * @param pageStart
	 * @param pageSize
	 * @param providerName
	 * @return
	 */
	@Override
	public List<ProviderProduct1> selectByProviderNameService(Integer pageStart, Integer pageSize, String providerName, int orderByClause) {
		ProviderProduct1Example providerProductExample = new ProviderProduct1Example();
		providerProductExample.setDistinct(false);
		providerProductExample.setPageStart(pageStart);
		providerProductExample.setPageSize(pageSize);
		if(orderByClause==1) {
			providerProductExample.setOrderByClause("`PRICE` DESC,`id` DESC");
		}else if(orderByClause==2){
			providerProductExample.setOrderByClause("`PRICE` ASC,`id` ASC");
		}else{
			
		}
		return providerProductMapper.selectByProviderNameDao(providerProductExample,providerName);
	}
	/**
	 * 	通过服务商 模糊查找服务的数目
	 * @param providerName
	 * @return
	 */
	@Override
	public int countByProviderNameService(String providerName) {
		return providerProductMapper.countByProviderNameDao(providerName);
	}

	@Override
	public List<ProviderProduct1> selectByServiceNameService(Integer pageStart, Integer pageSize, String serviceName, int orderByClause) {
		ProviderProduct1Example providerProductExample = new ProviderProduct1Example();
		providerProductExample.setDistinct(false);
		providerProductExample.setPageStart(pageStart);
		providerProductExample.setPageSize(pageSize);
		if(orderByClause==1) {
			providerProductExample.setOrderByClause("`PRICE` DESC,`id` DESC");
		}else if(orderByClause==2){
			providerProductExample.setOrderByClause("`PRICE` ASC,`id` ASC");
		}else{
		}
		return providerProductMapper.selectByServiceNameDao(providerProductExample,serviceName);
	}

	@Override
	public Object countByServiceNameService(String serviceName) {
		return providerProductMapper.countByServiceNameDao(serviceName);
	}
	/**
	 * 	通过主键id查找
	 * @param id
	 * @return
	 */
	@Override
	public ProviderProduct1 selectProviderProductByPrimaryKey(String id) {
		return providerProductMapper.selectByPrimaryKey(id);
	}
	/**
	 * 	通过 产品id查找单价
	 * @param productId
	 * @return
	 */
	@Override
	public int selectPriceByProductId(String productId) {
		return providerProductMapper.selectPriceByProductId(productId);
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
	public Map productList(int pageNum, int pageSize, String providerId, String word) {

		Map map = new HashMap();
		ProviderProduct1Example productExample = new ProviderProduct1Example();
		ProviderProduct1Example.Criteria criteria= productExample.createCriteria();
		criteria.andIdIsNotNull();
		//根据服务商id来查找
		criteria.andProviderIdEqualTo(providerId);

		//模糊查询
		if (word!=null&&!"".equals(word)&&!"null".equals(word)){
			criteria.andServiceNameLike("%"+word+"%");
		}
		productExample.setPageStart(pageNum);
		productExample.setPageSize(pageSize);
		int pages_sum = providerProductMapper.selectByExample(productExample).size();
		if (pages_sum!=0){
			List<ProviderProduct1> productList = providerProductMapper.selectByExample(productExample);
			if ((pageNum-1)*pageSize<pages_sum&&(pageNum-1)!=0&&pageNum*pageSize< pages_sum){
				map.put("list",productList.subList((pageNum-1)*pageSize,pageNum*pageSize));
				map.put("size",productList.subList((pageNum-1)*pageSize,pageNum*pageSize).size());
			}else if ((pageNum-1)==0){
				if ((pageSize>pages_sum)){
					map.put("list",productList.subList((pageNum-1),pages_sum));
					map.put("size",productList.subList((pageNum-1),pages_sum).size());
				}
				else {
					map.put("list",productList.subList(pageNum-1,pageSize));
					map.put("size",productList.subList(pageNum-1,pageSize).size());
				}
			}else if ((pageNum-1)*pageSize<pages_sum&&pageNum*pageSize>=pages_sum){
                    map.put("list",productList.subList((pageNum-1)*pageSize,pages_sum));
                    map.put("size",productList.subList((pageNum-1)*pageSize,pages_sum).size());
            }
		}else {
			map.put("list",null);
		}
		if (pages_sum%pageSize!=0){
			map.put("pagesum",(int)pages_sum/pageSize+1);
		}
		else {
			map.put("pagesum",(int)pages_sum/pageSize);
		}
		map.put("pageNum",pageNum);
		return map;
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
		ProviderProduct1Example productExample = new ProviderProduct1Example();
		ProviderProduct1Example.Criteria criteria= productExample.createCriteria();
		criteria.andIdEqualTo(productID);
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
	public ProviderProduct1 getProduct(String productID) {
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
	public boolean upProduct(ProviderProduct1 product,String productId) {
		ProviderProduct1Example productExample = new ProviderProduct1Example();
		ProviderProduct1Example.Criteria criteria= productExample.createCriteria();
		criteria.andIdEqualTo(productId);
		product.setId(productId);
		return providerProductMapper.updateByExample(product,productExample)!=0;
	}
	@Override
	/**
	 * 插入数据成功返回1,失败0
	 * @author: aoliao
	 * @param: product
	 * @updateTime: 2019/10/24 11:06
	 * @return: int
	 */
	public int insertProduct(ProviderProduct1 product) {
		return providerProductMapper.insertSelective(product);
	}

}
