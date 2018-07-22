package com.shl.onetest.controller;

import com.shl.onetest.annotation.Log;
import com.shl.onetest.domain.Menu;
import com.shl.onetest.entity.ResponseBo;
import com.shl.onetest.entity.Tree;
import com.shl.onetest.service.MenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author:songhongli
 * @Created: 2018/7/14
 */
@Controller
public class MenuController extends BaseController {
    @Autowired
    MenuService menuService;

    @Log("获取菜单信息")
    @RequestMapping("menu")
    //@RequiresPermissions("menu:list")
    public String index() {
        return "system/menu/menu";
    }

    @RequestMapping("menu/menu")
    @ResponseBody
    public ResponseBo getMenu(String userName) {
        try {
            List<Menu> menus = menuService.findUserMenus(userName);
            return ResponseBo.ok(menus);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取菜单失败！");
        }
    }

    @RequestMapping("menu/getUserMenu")
    @ResponseBody
    public ResponseBo getUserMenu(String userName) {
        try {
            Tree<Menu> tree = menuService.getUserMenu(userName);
            return ResponseBo.ok(tree);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取用户菜单失败！");
        }
    }
}
