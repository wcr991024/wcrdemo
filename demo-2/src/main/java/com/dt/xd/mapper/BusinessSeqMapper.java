package com.xinda.mapper;

import com.xinda.model.BusinessSeq;
import com.xinda.model.BusinessSeqExample;
import com.xinda.model.BusinessSeqKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessSeqMapper {
    int countByExample(BusinessSeqExample example);

    int deleteByExample(BusinessSeqExample example);

    int deleteByPrimaryKey(BusinessSeqKey key);

    int insert(BusinessSeq record);

    int insertSelective(BusinessSeq record);

    List<BusinessSeq> selectByExample(BusinessSeqExample example);

    BusinessSeq selectByPrimaryKey(BusinessSeqKey key);

    int updateByExampleSelective(@Param("record") BusinessSeq record, @Param("example") BusinessSeqExample example);

    int updateByExample(@Param("record") BusinessSeq record, @Param("example") BusinessSeqExample example);

    int updateByPrimaryKeySelective(BusinessSeq record);

    int updateByPrimaryKey(BusinessSeq record);
}