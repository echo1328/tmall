package com.tmall.service;

import com.tmall.domain.PageResult;
import com.tmall.domain.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public PageResult findPage(int pageNum, int pageSize);

    public User findById(int id);

    public void update(User user);

    public void deleteById(int id);

    public void delete(int[] ids);

    public void add(User user);

    public boolean login(String user_name, String user_pass);

}
