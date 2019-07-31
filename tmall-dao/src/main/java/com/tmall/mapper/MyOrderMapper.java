package com.tmall.mapper;

import com.tmall.pojo.MyOrder;
import com.tmall.pojo.MyOrderExample;
import java.util.List;

public interface MyOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MyOrder record);

    int insertSelective(MyOrder record);

    List<MyOrder> selectByExample(MyOrderExample example);

    MyOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MyOrder record);

    int updateByPrimaryKey(MyOrder record);
}