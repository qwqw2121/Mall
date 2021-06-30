package com.controller;

import com.dao.UserDao;
import com.pojo.User;
import com.service.UserService;
import com.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login.do")
    @ResponseBody
    public ServerResponse<User> login(HttpSession session, String account, String password)
    {
        ServerResponse<User> response=userService.login(account,password);
        if(response.isSuccess()){
            User user=response.getData();
            if(user.getRole()==2){
                session.setAttribute("cur_user",user);
                return response;
            }
            return ServerResponse.createByErrorMessage("非管理员无法登录");
        }
        return response;
    }
}
