package com.kmswoo.bms;

import com.kmswoo.bms.mapper.UserMapper;
import com.kmswoo.bms.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class MysqlTest {
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        Connection conn = dataSource.getConnection();
        System.out.println(conn.getClass());
        System.out.println(conn);

        conn.close();
    }

    @Autowired
    UserMapper userMapper;

    @Test
    void userMapperTest(){
        User user = userMapper.queryUserByName("kms");
        System.out.println(user);
    }
}
