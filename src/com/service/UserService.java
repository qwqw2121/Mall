package com.service;

import com.pojo.User;
import com.util.ServerResponse;

public interface UserService {
    public ServerResponse<User> login(String account, String password);

    public ServerResponse<String> isAdmin(User user);
}
