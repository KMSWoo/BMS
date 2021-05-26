package com.kmswoo.bms.controller;

import com.kmswoo.bms.mapper.BookMapper;
import com.kmswoo.bms.mapper.UserMapper;
import com.kmswoo.bms.pojo.Book;
import com.kmswoo.bms.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ListController {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    UserMapper userMapper;

    @GetMapping("/booklist")
    public String booklist(Model model) throws SQLException {
        List<Book> booklist = bookMapper.queryBookList();
        model.addAttribute("booklist",booklist);
        return "booklist :: booklist";
    }

    @GetMapping("/userlist")
    public String userList(Model model){
        List<User> userlist = userMapper.queryUserList();
        model.addAttribute("userlist",userlist);
        return "userlist :: userlist";
    }

    @GetMapping("/reservelist")
    public String reservelist(Model model) throws SQLException {
        Subject subject = SecurityUtils.getSubject();
        String name = subject.getPrincipal().toString();
        User user = userMapper.queryUserByName(name);

        List<String> IDlist = bookMapper.queryReserveList(user.getId());
        List<Book> booklist = new ArrayList<>();
        for (String bid :
                IDlist) {
            Book book = bookMapper.queryBookById(Integer.parseInt(bid));
            booklist.add(book);
        }
        System.out.println(booklist);
        model.addAttribute("booklist",booklist);
        return "booklist :: booklist";
    }
}
