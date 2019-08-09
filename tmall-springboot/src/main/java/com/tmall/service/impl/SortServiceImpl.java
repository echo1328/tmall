package com.tmall.service.impl;

import com.tmall.domain.Sort;
import com.tmall.repository.SortJpa;
import com.tmall.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @program: tmall-springboot
 * @description: SortServiceImpl
 * @author: wenlongzhou
 * @create: 2019-08-09 16:09
 **/

@Service
public class SortServiceImpl implements SortService {

    @Autowired
    private SortJpa sortJpa;

    @Override
    public List<Sort> findAll() {
        return sortJpa.findAll();
    }

    @Override
    public Sort findById(int id) {
        return sortJpa.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        sortJpa.deleteById(id);
    }

    @Override
    public Sort add(Sort sort) {
        return sortJpa.saveAndFlush(sort);
    }
}
