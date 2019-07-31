package com.tmall.mapper;

import com.tmall.pojo.Seller;
import com.tmall.pojo.SellerExample;
import java.util.List;

public interface SellerMapper {
    int deleteByPrimaryKey(Integer seller_id);

    int insert(Seller record);

    int insertSelective(Seller record);

    List<Seller> selectByExample(SellerExample example);

    Seller selectByPrimaryKey(Integer seller_id);

    int updateByPrimaryKeySelective(Seller record);

    int updateByPrimaryKey(Seller record);
}