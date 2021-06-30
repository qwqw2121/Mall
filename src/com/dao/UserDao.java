package com.dao;

import com.pojo.User;

public interface UserDao {
    public int CheckUserByAccount(String account);
    public User findUserByAccountAndPassword(String account,String password);
}
