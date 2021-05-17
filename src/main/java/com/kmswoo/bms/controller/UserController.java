package com.kmswoo.bms.controller;

import com.kmswoo.bms.mapper.UserMapper;
import com.kmswoo.bms.pojo.Book;
import com.kmswoo.bms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
