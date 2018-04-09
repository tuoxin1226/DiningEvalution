package com.stylefeng.guns.modular.dishEvalution.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.MenuDetail;
import com.stylefeng.guns.modular.dishEvalution.service.IMenuDetailService;

/**
 * 评价管理控制器
 *
 * @author fengshuonan
 * @Date 2018-04-09 12:03:20
 */
@Controller
@RequestMapping("/menuDetail")
public class MenuDetailController extends BaseController {

    private String PREFIX = "/dishEvalution/menuDetail/";

    @Autowired
    private IMenuDetailService menuDetailService;

    /**
     * 跳转到评价管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "menuDetail.html";
    }

    /**
     * 跳转到添加评价管理
     */
    @RequestMapping("/menuDetail_add")
    public String menuDetailAdd() {
        return PREFIX + "menuDetail_add.html";
    }

    /**
     * 跳转到修改评价管理
     */
    @RequestMapping("/menuDetail_update/{menuDetailId}")
    public String menuDetailUpdate(@PathVariable Integer menuDetailId, Model model) {
        MenuDetail menuDetail = menuDetailService.selectById(menuDetailId);
        model.addAttribute("item",menuDetail);
        LogObjectHolder.me().set(menuDetail);
        return PREFIX + "menuDetail_edit.html";
    }

    /**
     * 获取评价管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return menuDetailService.selectList(null);
    }

    /**
     * 新增评价管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(MenuDetail menuDetail) {
        menuDetailService.insert(menuDetail);
        return SUCCESS_TIP;
    }

    /**
     * 删除评价管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer menuDetailId) {
        menuDetailService.deleteById(menuDetailId);
        return SUCCESS_TIP;
    }

    /**
     * 修改评价管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(MenuDetail menuDetail) {
        menuDetailService.updateById(menuDetail);
        return SUCCESS_TIP;
    }

    /**
     * 评价管理详情
     */
    @RequestMapping(value = "/detail/{menuDetailId}")
    @ResponseBody
    public Object detail(@PathVariable("menuDetailId") Integer menuDetailId) {
        return menuDetailService.selectById(menuDetailId);
    }
}
