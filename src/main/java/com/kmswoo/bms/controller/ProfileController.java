package com.kmswoo.bms.controller;

import com.kmswoo.bms.mapper.UserMapper;
import com.kmswoo.bms.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class ProfileController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/userprofile")
    public String userProfile (Model model, HttpSession session) throws IOException {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        model.addAttribute("user",user);
        return "userprofile :: userprofile";
    }

}
