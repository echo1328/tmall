package com.tmall.service;

import com.tmall.domain.PageResult;
import com.tmall.domain.Seller;

import java.util.List;

public interface SellerService {

    public List<Seller> findAll();

    public PageResult findPage(int pageNum, int pageSize);

    public Seller findById(int id);

    public void deleteById(int id);

    public void delete(int[] ids);

    public void update(Seller seller);

}
