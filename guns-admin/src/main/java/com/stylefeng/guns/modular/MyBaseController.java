package com.stylefeng.guns.modular;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.shiro.ShiroUser;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBaseController extends BaseController {

    @Autowired
    private IUserService userService;

    public User getLoginUser(){
        ShiroUser shiroUser = ShiroKit.getUser();
        User user = userService.getByAccount(shiroUser.getAccount());
        return user;
    }

    public Boolean isAdmin(){
        User user = getLoginUser();
        if(user.getRoleid().equals("1")){
            return true;
        }
        return false;
    }

    public Boolean isAdmin(User user){
        if(user.getRoleid().equals("1")){
            return true;
        }
        return false;
    }

    public Boolean isResraurantOwner(){
        return !isAdmin();
    }

    public Boolean isResraurantOwner(User user){
        return !isAdmin(user);
    }
}
