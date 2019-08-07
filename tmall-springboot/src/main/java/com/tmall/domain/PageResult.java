package com.tmall.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @program: tmall-springboot
 * @description: PageResult
 * @author: wenlongzhou
 * @create: 2019-08-07 11:09
 **/

public class PageResult implements Serializable {

    private Long total;
    private List rows;

    public PageResult(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}