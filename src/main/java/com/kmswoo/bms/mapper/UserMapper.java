package com.kmswoo.bms.mapper;

import com.kmswoo.bms.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> queryUserList();

    User queryUserById(int id);

    User queryUserByName(String name);

    void addUser(User user);

    void deleteUser(int id);

//    void updateUser(User user);
}
