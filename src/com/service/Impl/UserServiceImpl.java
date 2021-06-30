package com.service.Impl;

import com.dao.UserDao;
import com.pojo.User;
import com.service.UserService;
import com.util.MD5Util;
import com.util.ServerResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public ServerResponse<User> login(String account, String password){
        int rs= userDao.CheckUserByAccount(account);
        if (rs==0)
        {
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        String md5pwd= MD5Util.md5(password);
        User user=userDao.findUserByAccountAndPassword(account,md5pwd);
        if(user==null){
            return ServerResponse.createByErrorMessage("密码错误");
        }
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccessCodeMessage("登录成功",user);
    }

    @Override
    public ServerResponse<String> isAdmin(User user) {
        if(user.getRole()==2)
          return  ServerResponse.createBySuccessMessage("登录成功");
        else
           return ServerResponse.createBySuccessMessage("非管理员不能登录");
    }
}
