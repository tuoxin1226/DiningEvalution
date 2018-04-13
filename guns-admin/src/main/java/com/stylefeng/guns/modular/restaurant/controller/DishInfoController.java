package com.stylefeng.guns.modular.restaurant.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.enums.EmYn;
import com.stylefeng.guns.modular.MyBaseController;
import com.stylefeng.guns.modular.restaurant.service.IDishInfoService;
import com.stylefeng.guns.modular.restaurant.service.IRestaurantService;
import com.stylefeng.guns.modular.system.model.Restaurant;
import com.stylefeng.guns.modular.system.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.DishInfo;

import java.util.Date;

/**
 * 菜品管理控制器
 *
 * @author fengshuonan
 * @Date 2018-04-09 12:02:14
 */
@Controller
@RequestMapping("/dishInfo")
public class DishInfoController extends MyBaseController {

    private String PREFIX = "/restaurant/dishInfo/";

    @Autowired
    private IDishInfoService dishInfoService;

    @Autowired
    private IRestaurantService restaurantService;

    /**
     * 跳转到菜品管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "dishInfo.html";
    }

    /**
     * 跳转到添加菜品管理
     */
    @RequestMapping("/dishInfo_add")
    public String dishInfoAdd() {
        return PREFIX + "dishInfo_add.html";
    }

    /**
     * 跳转到修改菜品管理
     */
    @RequestMapping("/dishInfo_update/{dishInfoId}")
    public String dishInfoUpdate(@PathVariable Integer dishInfoId, Model model) {
        DishInfo dishInfo = dishInfoService.selectById(dishInfoId);
        model.addAttribute("item",dishInfo);
        LogObjectHolder.me().set(dishInfo);
        return PREFIX + "dishInfo_edit.html";
    }

    /**
     * 获取菜品管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        Wrapper wrapper = new EntityWrapper();
        wrapper.where("yn = {0}", EmYn.YES.getValue());
        if(isResraurantOwner()){
            wrapper.and("restaurant_id = {0}", getRestaurant().getId());
        }
        return dishInfoService.selectList(wrapper);
    }

    /**
     * 新增菜品管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(DishInfo dishInfo) {
        User user = getLoginUser();
        dishInfo.setRestaurantId(getRestaurant().getId());
        dishInfo.setYn(EmYn.YES.getValue());
        dishInfo.setMoidfiedUser(user.getAccount() + ":" + user.getName());
        dishInfo.setCreatedTime(new Date());
        dishInfo.setModifiedTime(new Date());
        dishInfoService.insert(dishInfo);
        return SUCCESS_TIP;
    }

    /**
     * 删除菜品管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Long dishInfoId) {
        DishInfo dishInfo = new DishInfo();
        dishInfo.setId(dishInfoId);
        dishInfo.setYn(EmYn.NO.getValue());
        dishInfoService.updateById(dishInfo);
        return SUCCESS_TIP;
    }

    /**
     * 修改菜品管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(DishInfo dishInfo) {
        User user = getLoginUser();
        dishInfo.setMoidfiedUser(user.getAccount() + ":" + user.getName());
        dishInfo.setCreatedTime(new Date());
        dishInfo.setModifiedTime(new Date());
        dishInfoService.updateById(dishInfo);
        return SUCCESS_TIP;
    }

    /**
     * 菜品管理详情
     */
    @RequestMapping(value = "/detail/{dishInfoId}")
    @ResponseBody
    public Object detail(@PathVariable("dishInfoId") Long dishInfoId) {
        return dishInfoService.selectById(dishInfoId);
    }

    private Restaurant getRestaurant(){
        User user = getLoginUser();
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.where("user_id = {0}", user.getId()).and("yn = {0}", EmYn.YES.getValue());
        Restaurant restaurant = restaurantService.selectOne(entityWrapper);
        return restaurant;
    }
}
