package com.stylefeng.guns.modular.restaurant.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Restaurant;
import com.stylefeng.guns.modular.restaurant.service.IRestaurantService;

/**
 * 饭店管理控制器
 *
 * @author fengshuonan
 * @Date 2018-04-09 12:02:26
 */
@Controller
@RequestMapping("/restaurant")
public class RestaurantController extends BaseController {

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
        return restaurantService.selectList(null);
    }

    /**
     * 新增饭店管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Restaurant restaurant) {
        restaurantService.insert(restaurant);
        return SUCCESS_TIP;
    }

    /**
     * 删除饭店管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer restaurantId) {
        restaurantService.deleteById(restaurantId);
        return SUCCESS_TIP;
    }

    /**
     * 修改饭店管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Restaurant restaurant) {
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
