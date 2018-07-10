package com.shl.onetest.controller;

import com.shl.onetest.domain.User;
import com.shl.onetest.entity.ResponseBo;
import com.shl.onetest.util.MD5Util;
import com.shl.onetest.vcode.Captcha;
import com.shl.onetest.vcode.GifCaptcha;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author songhongli
 **/
@Controller
public class LoginController {
    private  static Logger logger = LoggerFactory.getLogger(LoginController.class.getName());

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseBo login(@RequestParam("username") String userName, @RequestParam("password") String password,
                            @RequestParam("code") String code, @RequestParam("rememberMe") Boolean rememberMe,
                            HttpServletRequest req) {
        Subject subject = SecurityUtils.getSubject();
        if (!StringUtils.isNotBlank(code)) {
            return ResponseBo.warn("验证码不能为空!");
        }

        HttpSession session = req.getSession();
        String sessionCode = (String) session.getAttribute("_code");

        if (!code.toLowerCase().equals(sessionCode)) {
            return ResponseBo.warn("验证码错误!");
        }

        //password = MD5Util.encrypt(userName.toLowerCase(), password);
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password, rememberMe);

        try {
            subject.login(token);
            ;
            return ResponseBo.ok();
        } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
            return ResponseBo.error(e.getMessage());
        } catch (AuthenticationException e) {
            return ResponseBo.error("认证失败！");
        }

    }

    @GetMapping(value = "gifCode")
    public void getGifCode(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/gif");

            //Captcha captcha = new GifCaptcha(146, 33, 4);
            //captcha.out(response.getOutputStream());
            HttpSession session = request.getSession();
            session.removeAttribute("_code");
            //session.setAttribute("_code", captcha.text().toLowerCase());
            session.setAttribute("_code", "1111");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @GetMapping("/403")
    public String forbid() {
        return "403";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        model.addAttribute("user", user);
        model.addAttribute("user", user);
        return "index";
    }
}
