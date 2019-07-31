package com.tmall.mapper;

import com.tmall.pojo.Cities;
import com.tmall.pojo.CitiesExample;
import java.util.List;

public interface CitiesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cities record);

    int insertSelective(Cities record);

    List<Cities> selectByExample(CitiesExample example);

    Cities selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cities record);

    int updateByPrimaryKey(Cities record);
}