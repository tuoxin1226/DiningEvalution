package com.stylefeng.guns.modular.dishEvalution.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.enums.EmYn;
import com.stylefeng.guns.modular.MyBaseController;
import com.stylefeng.guns.modular.system.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.DishMenu;
import com.stylefeng.guns.modular.dishEvalution.service.IDishMenuService;

import java.util.Date;

/**
 * 顾客菜单总览管理控制器
 *
 * @author fengshuonan
 * @Date 2018-04-09 12:03:26
 */
@Controller
@RequestMapping("/dishMenu")
public class DishMenuController extends MyBaseController {

    private String PREFIX = "/dishEvalution/dishMenu/";

    @Autowired
    private IDishMenuService dishMenuService;

    /**
     * 跳转到顾客菜单总览管理首页
     */
    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("admin", isAdmin());
        return PREFIX + "dishMenu.html";
    }

    /**
     * 跳转到添加顾客菜单总览管理
     */
    @RequestMapping("/dishMenu_add")
    public String dishMenuAdd() {
        return PREFIX + "dishMenu_add.html";
    }

    /**
     * 跳转到修改顾客菜单总览管理
     */
    @RequestMapping("/dishMenu_update/{dishMenuId}")
    public String dishMenuUpdate(@PathVariable Integer dishMenuId, Model model) {
        DishMenu dishMenu = dishMenuService.selectById(dishMenuId);
        model.addAttribute("item",dishMenu);
        LogObjectHolder.me().set(dishMenu);
        return PREFIX + "dishMenu_edit.html";
    }

    /**
     * 获取顾客菜单总览管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return dishMenuService.selectList(null);
    }

    /**
     * 新增顾客菜单总览管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(DishMenu dishMenu) {
        User user = getLoginUser();
        dishMenu.setYn(EmYn.YES.getValue());
        dishMenu.setModifiedTime(new Date());
        dishMenu.setCreatedTime(new Date());
        dishMenu.setMoidfiedUser(user.getName());
        dishMenu.setRemark("超级管理员添加");
        dishMenuService.insert(dishMenu);
        return SUCCESS_TIP;
    }

    /**
     * 删除顾客菜单总览管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Long dishMenuId) {
        DishMenu dishMenu = new DishMenu();
        dishMenu.setId(dishMenuId);
        dishMenu.setYn(EmYn.NO.getValue());
        dishMenuService.updateById(dishMenu);
        return SUCCESS_TIP;
    }

    /**
     * 修改顾客菜单总览管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(DishMenu dishMenu) {
        dishMenuService.updateById(dishMenu);
        return SUCCESS_TIP;
    }

    /**
     * 顾客菜单总览管理详情
     */
    @RequestMapping(value = "/detail/{dishMenuId}")
    @ResponseBody
    public Object detail(@PathVariable("dishMenuId") Integer dishMenuId) {
        return dishMenuService.selectById(dishMenuId);
    }
}
