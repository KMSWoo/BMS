package com.kmswoo.bms.controller;

import com.alibaba.fastjson.JSONObject;
import com.kmswoo.bms.mapper.CountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountController{

    @Autowired
    CountMapper countMapper;


    @RequestMapping("/countbook")
    public String countBook(){
        return countMapper.countBook();
    }


    @RequestMapping("/countuser")
    public String countUser() {
        return countMapper.countUser();
    }


    @RequestMapping("/countborrow")
    public String countBorrow() {
        return countMapper.countBorrow();
    }
}

