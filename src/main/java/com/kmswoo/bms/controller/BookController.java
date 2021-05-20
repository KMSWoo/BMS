package com.kmswoo.bms.controller;


import com.alibaba.fastjson.JSONObject;
import com.kmswoo.bms.mapper.BookMapper;
import com.kmswoo.bms.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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


    @PostMapping("/addbook")
    public String addBook(@RequestParam Map<String,Object> params, HttpServletResponse response) throws IOException {
//        bookMapper.addBook(new Book("9787536455382", "球状闪电", "刘慈欣", "四川科学技术出版社"));
        Book book = new Book(params.get("isbn").toString(),params.get("bookname").toString(),params.get("author").toString(),params.get("publisher").toString());
        bookMapper.addBook(book);
//        System.out.println(params);
        response.sendRedirect("/booklist");
        return "ok";
    }


    @PostMapping("/deletebook")
    public String deleteBookByAjax(@RequestBody JSONObject params) throws IOException {

//        System.out.println(params);
        for (Object i :
                params.values()) {
            bookMapper.deleteBook(Integer.parseInt(i.toString()));
        }
        return "ok";
    }

}
