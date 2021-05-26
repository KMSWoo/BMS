package com.kmswoo.bms.mapper;

import com.kmswoo.bms.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {
    //获取所有图书信息

    List<Book> queryBookList();

    Book queryBookById(int id);

    void addBook(Book book);

//    void updateBook(Book book);

    void deleteBook(int id);

    void reserveBook(int bid,int uid);

    List queryReserveList(int id);
}
