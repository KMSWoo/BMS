package com.kmswoo.bms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping({"/login","/login.html"})
    public String login(){
        return "login";
    }
}
