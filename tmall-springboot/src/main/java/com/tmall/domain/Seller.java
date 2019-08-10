package com.tmall.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "seller")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id")
    private Integer seller_id;

    @Column(name = "seller_name")
    private String seller_name;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "income")
    private Double income;

    @Column(name = "shop_ids")
    private String shop_ids;

    @Transient
    private User user;

    @Transient
    private List<Shop> shopList;

    public Integer getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Integer seller_id) {
        this.seller_id = seller_id;
    }

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name == null ? null : seller_name.trim();
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getShop_ids() {
        return shop_ids;
    }

    public void setShop_ids(String shop_ids) {
        this.shop_ids = shop_ids == null ? null : shop_ids.trim();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "seller_id=" + seller_id +
                ", seller_name='" + seller_name + '\'' +
                ", user_id=" + user_id +
                ", income=" + income +
                ", shop_ids='" + shop_ids + '\'' +
                ", user=" + user +
                ", shopList=" + shopList +
                '}';
    }

}