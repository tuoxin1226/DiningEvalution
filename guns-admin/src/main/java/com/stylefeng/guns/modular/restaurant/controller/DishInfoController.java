package com.stylefeng.guns.modular.restaurant.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.modular.restaurant.service.IDishInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.DishInfo;

/**
 * 饭店管理控制器
 *
 * @author fengshuonan
 * @Date 2018-04-09 12:02:14
 */
@Controller
@RequestMapping("/dishInfo")
public class DishInfoController extends BaseController {

    private String PREFIX = "/restaurant/dishInfo/";

    @Autowired
    private IDishInfoService dishInfoService;

    /**
     * 跳转到饭店管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "dishInfo.html";
    }

    /**
     * 跳转到添加饭店管理
     */
    @RequestMapping("/dishInfo_add")
    public String dishInfoAdd() {
        return PREFIX + "dishInfo_add.html";
    }

    /**
     * 跳转到修改饭店管理
     */
    @RequestMapping("/dishInfo_update/{dishInfoId}")
    public String dishInfoUpdate(@PathVariable Integer dishInfoId, Model model) {
        DishInfo dishInfo = dishInfoService.selectById(dishInfoId);
        model.addAttribute("item",dishInfo);
        LogObjectHolder.me().set(dishInfo);
        return PREFIX + "dishInfo_edit.html";
    }

    /**
     * 获取饭店管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return dishInfoService.selectList(null);
    }

    /**
     * 新增饭店管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(DishInfo dishInfo) {
        dishInfoService.insert(dishInfo);
        return SUCCESS_TIP;
    }

    /**
     * 删除饭店管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer dishInfoId) {
        dishInfoService.deleteById(dishInfoId);
        return SUCCESS_TIP;
    }

    /**
     * 修改饭店管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(DishInfo dishInfo) {
        dishInfoService.updateById(dishInfo);
        return SUCCESS_TIP;
    }

    /**
     * 饭店管理详情
     */
    @RequestMapping(value = "/detail/{dishInfoId}")
    @ResponseBody
    public Object detail(@PathVariable("dishInfoId") Integer dishInfoId) {
        return dishInfoService.selectById(dishInfoId);
    }
}
