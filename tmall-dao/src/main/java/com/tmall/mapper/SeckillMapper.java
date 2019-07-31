package com.tmall.mapper;

import com.tmall.pojo.Seckill;
import com.tmall.pojo.SeckillExample;
import java.util.List;

public interface SeckillMapper {
    int deleteByPrimaryKey(Integer seckill_id);

    int insert(Seckill record);

    int insertSelective(Seckill record);

    List<Seckill> selectByExample(SeckillExample example);

    Seckill selectByPrimaryKey(Integer seckill_id);

    int updateByPrimaryKeySelective(Seckill record);

    int updateByPrimaryKey(Seckill record);
}