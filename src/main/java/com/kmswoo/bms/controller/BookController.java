package com.kmswoo.bms.controller;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.kmswoo.bms.mapper.BookMapper;
import com.kmswoo.bms.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @GetMapping("/book/{id}")
    public Book book(@PathVariable("id") int id) {
        Book book = bookMapper.queryBookById(id);
        return book;
    }


    @RequestMapping("/addbook")
    public String addBook() {
        bookMapper.addBook(new Book("9787536455382", "球状闪电", "刘慈欣", "四川科学技术出版社"));
        return "ok";
    }

    @RequestMapping("/deletebook/{id}")
    public String deleteBookById(@PathVariable int id){
        bookMapper.deleteBook(id);
        return "ok";
    }

    @PostMapping("/deletebook")
    public String deleteBookByAjax(@RequestBody JSONObject params) {

//        System.out.println(params);
        for (Object i :
                params.values()) {
            bookMapper.deleteBook(Integer.parseInt(i.toString()));
        }
        return "ok";
    }

}
