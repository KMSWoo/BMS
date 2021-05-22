package com.kmswoo.bms.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping({"/login"})
    public String login(){
        return "login";
    }


    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session) {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //获取令牌
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);

        try {
            //尝试登陆
            subject.login(usernamePasswordToken);
            return "/";
        } catch (UnknownAccountException uae) {
            model.addAttribute("msg","用户名不存在！");
            return "login";
        } catch (IncorrectCredentialsException ice) {
            model.addAttribute("msg","密码错误！");
            return "login";
        } catch (AuthenticationException ae) {
            model.addAttribute("msg","发生错误，请稍后再试！");
            return "login";
        }
    }
}
