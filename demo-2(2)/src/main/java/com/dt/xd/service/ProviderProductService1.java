package com.dt.xd.service;

import model.User.ProviderProduct1;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ProviderProductService1 {
	/*******************************************************
	 * 	商品相关
	 *******************************************************/
	List<ProviderProduct1> selectAllProviderService(int pageStart,int pageSize);

	long countAllProviderService();
	/** 通过服务商 模糊查找服务 */
	List<ProviderProduct1> selectByProviderNameService(Integer pageStart, Integer pageSize, String providerName, int OrderByClause);
	/** 通过服务商 模糊查找服务的数目  */
	int countByProviderNameService(String providerName);
	
	List<ProviderProduct1> selectByServiceNameService(Integer pageStart, Integer pageSize, String serviceName, int OrderByClause);

	Object countByServiceNameService(String serviceName);
	/** 通过主键id查找 */
	ProviderProduct1 selectProviderProductByPrimaryKey(String id);
	/** 通过 产品id查找单价 */
	int selectPriceByProductId(String productId);

	public Map<?,?> productList(int pageNum, int pageSize, String providerId, String word);

	public int deleteProduct(String productID);

	public ProviderProduct1 getProduct(String productID);

	public boolean upProduct(ProviderProduct1 product, String productId);

	public int insertProduct(ProviderProduct1 product);
	
}
