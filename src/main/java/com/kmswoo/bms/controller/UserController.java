package com.kmswoo.bms.controller;

import com.alibaba.fastjson.JSONObject;
import com.kmswoo.bms.mapper.UserMapper;
import com.kmswoo.bms.pojo.Book;
import com.kmswoo.bms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/user/{id}")
    public User user(@PathVariable("id") int id){
        User user = userMapper.queryUserById(id);
        return user;
    }

    @PostMapping("/deleteuser")
    public String deleteBookByAjax(@RequestBody JSONObject params) throws IOException {

//        System.out.println(params);
        for (Object i :
                params.values()) {
            userMapper.deleteUser(Integer.parseInt(i.toString()));
        }
        return "ok";
    }


    @PostMapping("/adduser")
    public String addUser(@RequestParam Map<String,Object> params, HttpServletResponse response) throws IOException {
        User user = new User(params.get("username").toString(),params.get("password").toString(),params.get("email").toString());
        userMapper.addUser(user);
        response.sendRedirect("/userlist");
        return "ok";
    }
}
