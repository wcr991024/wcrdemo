package com.xinda.mapper;

import com.xinda.model.BusinessOrder;
import com.xinda.model.BusinessOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessOrderMapper {
    int countByExample(BusinessOrderExample example);

    int deleteByExample(BusinessOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(BusinessOrder record);

    int insertSelective(BusinessOrder record);

    List<BusinessOrder> selectByExample(BusinessOrderExample example);

    BusinessOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BusinessOrder record, @Param("example") BusinessOrderExample example);

    int updateByExample(@Param("record") BusinessOrder record, @Param("example") BusinessOrderExample example);

    int updateByPrimaryKeySelective(BusinessOrder record);

    int updateByPrimaryKey(BusinessOrder record);
}