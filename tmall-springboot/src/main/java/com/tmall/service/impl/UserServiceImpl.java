package com.tmall.service.impl;

import com.tmall.domain.PageResult;
import com.tmall.domain.User;
import com.tmall.repository.UserJpa;
import com.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpa userJpa;

    @Override
    public List<User> findAll() {
        return userJpa.findAll();
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<User> page = userJpa.findAll(pageable);
        return new PageResult(page.getTotalElements(), page.getContent());
    }

    @Override
    public User findById(int id) {
        return userJpa.findById(id).get();
    }

    @Override
    public void update(User user) {
        userJpa.saveAndFlush(user);
    }

    @Override
    public void deleteById(int id) {
        userJpa.deleteById(id);
    }

    @Override
    public void delete(int[] ids) {
        for(int id : ids) {
            userJpa.deleteById(id);
        }
    }

    @Override
    public void add(User user) {
        userJpa.saveAndFlush(user);
    }

    @Override
    public boolean login(String user_name, String user_pass) {
        User user = new User();
        user.setUser_name(user_name);
        user.setUser_pass(user_pass);
        Example<User> example = Example.of(user);
        List<User> list = userJpa.findAll(example);
        if (list.size() == 1) {
            return true;
        } else {
            return false;
        }
    }

}
