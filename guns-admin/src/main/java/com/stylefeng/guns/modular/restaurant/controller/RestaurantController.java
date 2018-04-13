package com.stylefeng.guns.modular.restaurant.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.modular.MyBaseController;
import com.stylefeng.guns.modular.system.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Restaurant;
import com.stylefeng.guns.modular.restaurant.service.IRestaurantService;
import com.stylefeng.guns.enums.*;

import java.util.Date;

/**
 * 饭店管理控制器
 *
 * @author fengshuonan
 * @Date 2018-04-09 12:02:26
 */
@Controller
@RequestMapping("/restaurant")
public class RestaurantController extends MyBaseController {

    private String PREFIX = "/restaurant/restaurant/";

    @Autowired
    private IRestaurantService restaurantService;

    /**
     * 跳转到饭店管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "restaurant.html";
    }

    /**
     * 跳转到添加饭店管理
     */
    @RequestMapping("/restaurant_add")
    public String restaurantAdd() {
        return PREFIX + "restaurant_add.html";
    }

    /**
     * 跳转到修改饭店管理
     */
    @RequestMapping("/restaurant_update/{restaurantId}")
    public String restaurantUpdate(@PathVariable Integer restaurantId, Model model) {
        Restaurant restaurant = restaurantService.selectById(restaurantId);
        model.addAttribute("item",restaurant);
        LogObjectHolder.me().set(restaurant);
        return PREFIX + "restaurant_edit.html";
    }

    /**
     * 获取饭店管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        User user = getLoginUser();
        Restaurant param = new Restaurant();
        param.setUserId(Long.valueOf(user.getId()));
        Wrapper wrapper = new EntityWrapper();
        wrapper.where("yn = {0}", EmYn.YES.getValue());
        if(isResraurantOwner()){
            wrapper.and("user_id = {0}", user.getId());
        }
        return restaurantService.selectList(wrapper);
    }

    /**
     * 新增饭店管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Restaurant restaurant) {
        restaurant.setStatus(EmRestaurantStatus.AUDIT.getValue());
        User user = getLoginUser();
        //不是超级管理员，设置userId
        if (isResraurantOwner(user)){
            restaurant.setUserId(Long.valueOf(user.getId()));
        }
        restaurant.setStatus(EmRestaurantStatus.AUDIT.getValue());
        restaurant.setMoidfiedUser(user.getAccount() + ":" + user.getName());
        restaurant.setCreatedTime(new Date());
        restaurant.setModifiedTime(new Date());
        restaurant.setYn(EmYn.YES.getValue());
        restaurantService.insert(restaurant);
        return SUCCESS_TIP;
    }

    /**
     * 删除饭店管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Long restaurantId) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(restaurantId);
        restaurant.setYn(EmYn.NO.getValue());
        restaurantService.updateById(restaurant);
        return SUCCESS_TIP;
    }

    /**
     * 修改饭店管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Restaurant restaurant) {
        User user = getLoginUser();
        restaurant.setStatus(EmRestaurantStatus.AUDIT.getValue());
        restaurant.setMoidfiedUser(user.getAccount() + ":" + user.getName());
        restaurant.setCreatedTime(new Date());
        restaurant.setModifiedTime(new Date());
        restaurantService.updateById(restaurant);
        return SUCCESS_TIP;
    }

    /**
     * 饭店管理详情
     */
    @RequestMapping(value = "/detail/{restaurantId}")
    @ResponseBody
    public Object detail(@PathVariable("restaurantId") Integer restaurantId) {
        return restaurantService.selectById(restaurantId);
    }
}
