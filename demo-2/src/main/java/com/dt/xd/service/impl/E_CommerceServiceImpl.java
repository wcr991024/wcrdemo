package com.datangedu.cn.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.CartMapper;
import com.datangedu.cn.dao.mapper.ProviderProductMapper;
import com.datangedu.cn.model.Cart;
import com.datangedu.cn.model.ProviderProduct;
import com.datangedu.cn.model.ProviderProductExample;
import com.datangedu.cn.service.E_CommerceService;

@Service
public class E_CommerceServiceImpl implements E_CommerceService{
	@Resource
	ProviderProductMapper providerProductMapper;
	@Resource
	CartMapper cartMapper;
	/**
	 * 商品相关
	 */
	@Override
	public List<ProviderProduct> selectAllProviderService(int pageStart,int pageSize) {
		ProviderProductExample providerProductExample = new ProviderProductExample();
		providerProductExample.setDistinct(false);
		providerProductExample.setPageStart(pageStart);
		providerProductExample.setPageSize(pageSize);
		//System.out.println("pageStart=" + pageStart + "pageSize=" +pageSize);
		return providerProductMapper.selectAllProviderDao(providerProductExample);
	}

	@Override
	public long countAllProviderService() {
		ProviderProductExample providerProductExample = new ProviderProductExample();
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
	public List<ProviderProduct> selectByProviderNameService(Integer pageStart, Integer pageSize, String providerName) {
		ProviderProductExample providerProductExample = new ProviderProductExample();
		providerProductExample.setDistinct(false);
		providerProductExample.setPageStart(pageStart);
		providerProductExample.setPageSize(pageSize);
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
	public List<ProviderProduct> selectByServiceNameService(Integer pageStart, Integer pageSize, String serviceName) {
		ProviderProductExample providerProductExample = new ProviderProductExample();
		providerProductExample.setDistinct(false);
		providerProductExample.setPageStart(pageStart);
		providerProductExample.setPageSize(pageSize);
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
	public ProviderProduct selectProviderProductByPrimaryKey(String id) {
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
	/******************************************
	 * 	购物车相关
	 ******************************************/
	@Override
	public List<Cart> selectByMemberIdService(String memberId) {
		return cartMapper.selectByMemberId(memberId);
	}
	/**
	 * 	通过id查找的商品条数
	 * @param memberId
	 * @return
	 */
	@Override
	public int countByMemberIdService(String memberId) {
		return cartMapper.countByMemberId(memberId);
	}
	/**
	 * 	插入不为空 的数据
	 * @param cart
	 * @return
	 */
	@Override
	public int insertSelectiveService(Cart cart) {
		return cartMapper.insertSelective(cart);
	}
	/**
     * 	通过主键删除 购物车数据
     * @param id
     * @return
     */
	@Override
	public int deleteByPrimaryKeyService(String cartId) {
		return cartMapper.deleteByPrimaryKey(cartId);
	}
	/**
     * 	按用户id查找 cart表中 总价格
     * @param memberId
     * @return
     */
	@Override
    public Integer allPriceService(String memberId) {
		return cartMapper.allPrice(memberId);
	}
	/**
     *	 通过用户id和产品id 修改 
     * @param memberId
     * @param productId
     * @param totalPrice
     * @return
     */
	@Override
	public int updateNumAndPriceByProductId(String memberId, String productId, Integer buynum, int totalPrice) {
		return cartMapper.updateNumAndPriceByProductId(memberId,productId,buynum,totalPrice);
	}
	/**
	 * 通过用户id和产品id查找totalPrice
	 * @param productId
	 * @param memberId
	 * @return
	 */
	@Override
	public int selectTotalPriceByProductId(String productId, String memberId) {
		return cartMapper.selectTotalPriceByProductId(productId,memberId);
	}

	@Override
	public Cart selectByMemeberAndProviderId(String memberId, String providerId) {
		return cartMapper.selectByMemeberAndProviderId(memberId,providerId);
	}
	/*通过主键查找*/
	@Override
	public Cart selectCartByPrimaryKey(String cartId) {
		return cartMapper.selectByPrimaryKey(cartId);
	}

}
