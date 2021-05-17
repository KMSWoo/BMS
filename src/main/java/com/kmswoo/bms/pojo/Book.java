package com.kmswoo.bms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//图书表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;
    private String isbn;
    /* 0 fot available,1 for be reserved,2 for be borrowed */
    private String status;
    private String name;
    private String author;
    private String publisher;
    private String is_delete;

    public Book(String isbn, String name, String author, String publisher) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
    }
}
