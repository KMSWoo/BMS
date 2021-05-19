package com.kmswoo.bms.controller;

import com.kmswoo.bms.mapper.UserMapper;
import com.kmswoo.bms.pojo.Book;
import com.kmswoo.bms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/userlist")
    public List<User> userList(){
        List<User> userlist = userMapper.queryUserList();
        return userlist;
    }

    @GetMapping("/user/{id}")
    public User user(@PathVariable("id") int id){
        User user = userMapper.queryUserById(id);
        return user;
    }

    @GetMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userMapper.deleteUser(id);
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
