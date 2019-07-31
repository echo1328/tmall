package com.tmall.mapper;

import com.tmall.pojo.Brand;
import com.tmall.pojo.BrandExample;
import java.util.List;

public interface BrandMapper {
    int deleteByPrimaryKey(Integer brand_id);

    int insert(Brand record);

    int insertSelective(Brand record);

    List<Brand> selectByExample(BrandExample example);

    Brand selectByPrimaryKey(Integer brand_id);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);
}