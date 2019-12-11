package com.dt.xd.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import model.User.ProviderProduct1;
import model.User.ProviderProduct1Example;
@Mapper
public interface ProviderProduct1Mapper {
    long countByExample(ProviderProduct1Example example);

    int deleteByExample(ProviderProduct1Example example);

    int deleteByPrimaryKey(String id);

    int insert(ProviderProduct1 record);

    int insertSelective(ProviderProduct1 record);

    List<ProviderProduct1> selectByExample(ProviderProduct1Example example);

    int updateByExampleSelective(@Param("record") ProviderProduct1 record, @Param("example") ProviderProduct1Example example);

    int updateByExample(@Param("record") ProviderProduct1 record, @Param("example") ProviderProduct1Example example);

    int updateByPrimaryKeySelective(ProviderProduct1 record);

    int updateByPrimaryKey(ProviderProduct1 record);
    /******************************start*****************************/
	List<ProviderProduct1> selectAllProviderDao(ProviderProduct1Example providerProductExample);
	
	List<ProviderProduct1> selectByProviderNameDao(@Param("example")ProviderProduct1Example providerProductExample,@Param("providerName")String providerName);
	
	int countByProviderNameDao(String providerName);

	List<ProviderProduct1> selectByServiceNameDao(@Param("example")ProviderProduct1Example providerProductExample,@Param("serviceName")String serviceName);

	Object countByServiceNameDao(String serviceName);
	
	ProviderProduct1 selectByPrimaryKey(String id);
	/**
	 * 	通过 产品id查找单价
	 * @param productId
	 * @return
	 */
	int selectPriceByProductId(String productId);

}