package com.dt.xd.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import model.User.Cart1;

@Mapper
public interface Cart1Mapper {
    int insert(Cart1 record);

    Cart1 selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Cart1 record);

    int updateByPrimaryKey(Cart1 record);
    //satrt
    /**
     * 	通过会员id查找  购物车内商品
     * @param memberId
     * @return
     */
    List<Cart1> selectByMemberId(String memberId);
    /**
     * 	通过id查找的商品条数 (购物车内数目)
     * @param memberId
     * @return
     */
    int countByMemberId(String memberId);
    /**
     * 	插入不为空 的数据
     * @param record
     * @return
     */
    int insertSelective(Cart1 record);
    /**
     * 	通过主键删除 购物车数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String cartId);
    /**
     * 	按用户id查找 cart表中数据 总价格
     * @param memberId
     * @return
     */
    Integer allPrice(String memberId);
    /**
     *	 通过用户id和产品id 修改 
     * @param memberId
     * @param productId
     * @param totalPrice
     * @return
     */
	int updateNumAndPriceByProductId(@Param("memberId")String memberId, @Param("productId")String productId, @Param("buynum")Integer buynum, @Param("totalPrice")int totalPrice);
	/**
	 * 通过用户id和产品id查找totalPrice
	 */
	int selectTotalPriceByProductId(String productId, String memberId);

	Cart1 selectByMemeberAndProviderId(@Param("memberId")String memberId, @Param("productId")String providerId);
}