package com.dt.xd.dao.mapper;

import com.dt.xd.xdProduct.XdProduct;
import com.dt.xd.xdProduct.XdProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XdProductMapper {
    long countByExample(XdProductExample example);

    int deleteByExample(XdProductExample example);

    int deleteByPrimaryKey(String id);

    int insert(XdProduct record);

    int insertSelective(XdProduct record);

    List<XdProduct> selectByExample(XdProductExample example);

    XdProduct selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") XdProduct record, @Param("example") XdProductExample example);

    int updateByExample(@Param("record") XdProduct record, @Param("example") XdProductExample example);

    int updateByPrimaryKeySelective(XdProduct record);

    int updateByPrimaryKey(XdProduct record);
}