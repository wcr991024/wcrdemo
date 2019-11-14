package com.xinda.mapper;

import com.xinda.model.ProviderProduct;
import com.xinda.model.ProviderProductExample;
import com.xinda.model.ProviderProductWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderProductMapper {
    int countByExample(ProviderProductExample example);

    int deleteByExample(ProviderProductExample example);

    int deleteByPrimaryKey(String productId);

    int insert(ProviderProductWithBLOBs record);

    int insertSelective(ProviderProductWithBLOBs record);

    List<ProviderProductWithBLOBs> selectByExampleWithBLOBs(ProviderProductExample example);

    List<ProviderProduct> selectByExample(ProviderProductExample example);

    ProviderProductWithBLOBs selectByPrimaryKey(String productId);

    int updateByExampleSelective(@Param("record") ProviderProductWithBLOBs record, @Param("example") ProviderProductExample example);

    int updateByExampleWithBLOBs(@Param("record") ProviderProductWithBLOBs record, @Param("example") ProviderProductExample example);

    int updateByExample(@Param("record") ProviderProduct record, @Param("example") ProviderProductExample example);

    int updateByPrimaryKeySelective(ProviderProductWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProviderProductWithBLOBs record);

    int updateByPrimaryKey(ProviderProduct record);

}