package com.kmswoo.bms.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @RequestMapping("/logout")
    public String logout(HttpSession session,SessionStatus sessionStatus){
//        session.invalidate();
//        sessionStatus.setComplete();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
