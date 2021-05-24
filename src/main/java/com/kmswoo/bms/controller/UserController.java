package com.kmswoo.bms.controller;

import com.alibaba.fastjson.JSONObject;
import com.kmswoo.bms.mapper.UserMapper;
import com.kmswoo.bms.pojo.Book;
import com.kmswoo.bms.pojo.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        //生成md5,随机salt
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        String pwd=new Md5Hash(params.get("password").toString(),salt,2).toString();

        User user = new User(params.get("username").toString(),pwd,salt,params.get("email").toString());
        userMapper.addUser(user);
        response.sendRedirect("/userlist");
        return "ok";
    }
}
