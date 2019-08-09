package com.tmall.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @program: tmall-springboot
 * @description: brand
 * @author: wenlongzhou
 * @create: 2019-08-07 10:21
 **/

@Entity
@Table(name = "brand")
public class Brand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自动增长主键
    @Column(name = "brand_id")
    private Integer brand_id;

    @Column(name = "name")
    private String name;

    @Column(name = "first_char")
    private String first_char;

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFirst_char() {
        return first_char;
    }

    public void setFirst_char(String first_char) {
        this.first_char = first_char == null ? null : first_char.trim();
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brand_id=" + brand_id +
                ", name='" + name + '\'' +
                ", first_char='" + first_char + '\'' +
                '}';
    }
}
