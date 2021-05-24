package com.kmswoo.bms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//用户表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String password;
    //0 for general user,1 for admin
    private String is_admin;
    private String email;
    private String salt;
    //0 for ok,1 for deleted,2 for locked
    private String state;

    public User(String name, String password, String salt,String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
