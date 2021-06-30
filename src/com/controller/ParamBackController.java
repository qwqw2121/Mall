package com.controller;
import com.pojo.Param;
import com.pojo.User;
import com.service.ParamService;
import com.service.UserService;
import com.util.ResponseCode;
import com.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/param")
public class ParamBackController {
    @Autowired
    private ParamService paramService;
    @Autowired
    private UserService userService;
    @RequestMapping("/saveparam.do")
    @ResponseBody
    public ServerResponse<String> saveParam(HttpSession session, Param param){
        User user= (User) session.getAttribute("cur_user");
        if(user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"请登录后操作");
        }
         ServerResponse<String> response=userService.isAdmin(user);
         if(response.isSuccess()){
            return paramService.addParam(param);
        }
            return ServerResponse.createByErrorMessage("没有操作权限");
    }
    public ServerResponse<String> updateCategory(HttpSession session,Param param){
        User user= (User) session.getAttribute("cur_user");
        if(user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"请登录后操作");
        }
        ServerResponse<String> response=userService.isAdmin(user);
        if(response.isSuccess()){
        //    return paramService.updateParam(param);
        }
        return ServerResponse.createByErrorMessage("没有操作权限");
    }
}
