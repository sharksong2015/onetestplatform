package com.shl.onetest.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shl.onetest.annotation.Log;
import com.shl.onetest.constant.SexEnum;
import com.shl.onetest.domain.User;
import com.shl.onetest.entity.QueryRequest;
import com.shl.onetest.entity.ResponseBo;
import com.shl.onetest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author:songhongli
 * @Created: 2018/7/11
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    UserService userService;

    @RequestMapping("/profile")
    public String profileIndex(Model model) {
        User user = super.getCurrentUser();

        String sex = user.getSex();
        if (SexEnum.SEX_Man.getSexEnum().equals(sex)) {
            user.setSex("性别：男");
        } else if (SexEnum.SEX_WoMan.getSexEnum().equals(sex)) {
            user.setSex("性别：女");
        } else {
            user.setSex("性别：保密");
        }
        model.addAttribute("user", user);
        return "system/user/profile";
    }

    @Log("获取用户信息")
    @RequestMapping("user/list")
    @ResponseBody
    public Map<String, Object> userList(QueryRequest request, User user) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<User> list = userService.findUserWithDept(user);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return getDataTable(pageInfo);
    }

    @RequestMapping("/getUserProfile")
    @ResponseBody
    public ResponseBo getUserProfile(Long userId) {
        try {
            User user = new User();
            user.setUserId(userId);
            return ResponseBo.ok(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取用户信息失败，请联系网站管理员！");
        }
    }

    @Log("更换主题")
    @RequestMapping("user/theme")
    @ResponseBody
    public ResponseBo updateTheme(User user) {
        try {
            userService.updateTheme(user.getTheme(), user.getUsername());
            return ResponseBo.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("更新主题失败！");
        }
    }
}
