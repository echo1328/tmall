package com.tmall.service.impl;

import com.tmall.domain.PageResult;
import com.tmall.domain.Seller;
import com.tmall.domain.Shop;
import com.tmall.domain.User;
import com.tmall.repository.SellerJpa;
import com.tmall.repository.ShopJpa;
import com.tmall.repository.UserJpa;
import com.tmall.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther wenlongzhou
 * @date 2019/6/13 19:46
 */

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerJpa sellerJpa;

    @Autowired
    private UserJpa userJpa;

    @Autowired
    private ShopJpa shopJpa;

    @Override
    public List<Seller> findAll() {
        List<Seller> list1 = sellerJpa.findAll();
        List<Seller> list2 = new ArrayList<>();
        for (Seller seller : list1) {
            List<Shop> shopList = new ArrayList<>();
            int user_id = seller.getUser_id();
            User user = userJpa.findById(user_id).get();
            seller.setUser(user);
            String shop_ids = seller.getShop_ids();
            String[] ids = shop_ids.split(",");
            for (String id : ids) {
                int shop_id = Integer.parseInt(id);
                Shop shop = shopJpa.findById(shop_id).get();
                shopList.add(shop);
            }
            seller.setShopList(shopList);
            list2.add(seller);
        }
        return list2;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Seller> page = sellerJpa.findAll(pageable);
        return new PageResult(page.getTotalElements(),page.getContent());
    }

    @Override
    public Seller findById(int id) {
        Seller seller1 = new Seller();
        seller1.setSeller_id(id);
        Example<Seller> example = Example.of(seller1);
        List<Seller> sellerList = sellerJpa.findAll(example);
        Seller seller = sellerList.get(0);
        List<Shop> shopList = new ArrayList<>();
        int user_id = seller.getUser_id();
        User user = userJpa.findById(user_id).get();
        seller.setUser(user);
        String shop_ids = seller.getShop_ids();
        String[] ids = shop_ids.split(",");
        for (String str : ids) {
            int shop_id = Integer.parseInt(str);
            Shop shop = shopJpa.findById(shop_id).get();
            shopList.add(shop);
        }
        seller.setShopList(shopList);
        return seller;
    }

    @Override
    public void deleteById(int id) {
        sellerJpa.deleteById(id);
    }

    @Override
    public void delete(int[] ids) {
        for (int id : ids) {
            sellerJpa.deleteById(id);
        }
    }

    @Override
    public void update(Seller seller) {
        sellerJpa.saveAndFlush(seller);
    }

}
