package com.kmswoo.bms.controller;

import com.kmswoo.bms.mapper.BookMapper;
import com.kmswoo.bms.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
public class ListController {

    @Autowired
    BookMapper bookMapper;

    @GetMapping("/booklist")
    public String booklist(Model model) throws SQLException {
        List<Book> booklist = bookMapper.queryBookList();
        model.addAttribute("booklist",booklist);
        return "booklist :: booklist";
    }
}
