package com.datangedu.cn.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.datangedu.cn.model.Cart;
import com.datangedu.cn.model.ProviderProduct;

@Service
public interface E_CommerceService {
	/*******************************************************
	 * 	商品相关
	 *******************************************************/
	List<ProviderProduct> selectAllProviderService(int pageStart,int pageSize);

	long countAllProviderService();
	/**
	 * 	通过服务商 模糊查找服务
	 * @param pageStart
	 * @param pageSize
	 * @param providerName
	 * @return
	 */
	List<ProviderProduct> selectByProviderNameService(Integer pageStart, Integer pageSize, String providerName);
	/**
	 * 	通过服务商 模糊查找服务的数目
	 * @param providerName
	 * @return
	 */
	int countByProviderNameService(String providerName);
	
	List<ProviderProduct> selectByServiceNameService(Integer pageStart, Integer pageSize, String serviceName);

	Object countByServiceNameService(String serviceName);
	/**
	 * 	通过主键id查找
	 * @param id
	 * @return
	 */
	ProviderProduct selectProviderProductByPrimaryKey(String id);
	/**
	 * 	通过 产品id查找单价
	 * @param productId
	 * @return
	 */
	int selectPriceByProductId(String productId);
	
	/************************************************************
	 * 	购物车相关
	 ************************************************************/
	/**
	 * 	通过会员id查找  购物车内商品
	 * @param memberId
	 * @return
	 */
	List<Cart> selectByMemberIdService(String memberId);
	/**
	 * 	通过id查找的商品条数
	 * @param memberId
	 * @return
	 */
	int countByMemberIdService(String memberId);
	/**
	 * 	插入不为空 的数据
	 * @param cart
	 * @return
	 */
	int insertSelectiveService(Cart cart);
	/**
     * 	通过主键删除 购物车数据
     * @param id
     * @return
     */
    int deleteByPrimaryKeyService(String cartId);
    /**
     * 	按用户id查找 cart表中数据 总价格
     * @param memberId
     * @return
     */
    public Integer allPriceService(String memberId);
    /**
     *	 通过用户id和产品id 修改 
     * @param memberId
     * @param productId
     * @param totalPrice
     * @return
     */
	int updateNumAndPriceByProductId(String memberId, String productId, Integer buynum, int totalPrice);
	/**
	 * 通过用户id和产品id查找totalPrice
	 * @param productId
	 * @param memberId
	 * @return
	 */
	int selectTotalPriceByProductId(String productId, String memberId);
	/**
	 * 通过用户id和产品id查找信息
	 * @param memberId
	 * @param providerId
	 * @return
	 */
	Cart selectByMemeberAndProviderId(String memberId, String providerId);
	/*通过主键查找*/
	Cart selectCartByPrimaryKey(String cartId);

}
