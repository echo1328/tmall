package com.tmall.mapper;

import com.tmall.pojo.User;
import com.tmall.pojo.UserExample;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer user_id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer user_id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}