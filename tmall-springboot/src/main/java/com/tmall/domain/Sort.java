package com.tmall.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sort")
public class Sort implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自动增长主键
    @Column(name = "sort_id")
    private Integer sort_id;

    @Column(name = "parent_id")
    private Integer parent_id;

    @Column(name = "name")
    private String name;

    public Integer getSort_id() {
        return sort_id;
    }

    public void setSort_id(Integer sort_id) {
        this.sort_id = sort_id;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        return "Sort{" +
                "sort_id=" + sort_id +
                ", parent_id=" + parent_id +
                ", name='" + name + '\'' +
                '}';
    }
}