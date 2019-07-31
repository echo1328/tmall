package com.tmall.mapper;

import com.tmall.pojo.Order;
import com.tmall.pojo.OrderExample;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer order_id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer order_id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}