package com.tmall.mapper;

import com.tmall.pojo.Goods;
import com.tmall.pojo.GoodsExample;
import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer goods_id);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Integer goods_id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}