package com.tmall.mapper;

import com.tmall.pojo.AdType;
import com.tmall.pojo.AdTypeExample;
import java.util.List;

public interface AdTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdType record);

    int insertSelective(AdType record);

    List<AdType> selectByExample(AdTypeExample example);

    AdType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdType record);

    int updateByPrimaryKey(AdType record);
}