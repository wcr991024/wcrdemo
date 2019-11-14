package com.xinda.mapper;

import com.xinda.model.ProviderImg;
import com.xinda.model.ProviderImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProviderImgMapper {
    int countByExample(ProviderImgExample example);

    int deleteByExample(ProviderImgExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProviderImg record);

    int insertSelective(ProviderImg record);

    List<ProviderImg> selectByExample(ProviderImgExample example);

    ProviderImg selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProviderImg record, @Param("example") ProviderImgExample example);

    int updateByExample(@Param("record") ProviderImg record, @Param("example") ProviderImgExample example);

    int updateByPrimaryKeySelective(ProviderImg record);

    int updateByPrimaryKey(ProviderImg record);
}