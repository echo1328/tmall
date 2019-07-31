package com.tmall.mapper;

import com.tmall.pojo.Provinces;
import com.tmall.pojo.ProvincesExample;
import java.util.List;

public interface ProvincesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Provinces record);

    int insertSelective(Provinces record);

    List<Provinces> selectByExample(ProvincesExample example);

    Provinces selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Provinces record);

    int updateByPrimaryKey(Provinces record);
}