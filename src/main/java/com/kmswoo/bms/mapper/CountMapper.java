package com.kmswoo.bms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CountMapper {
    String countBook();

    String countUser();

//    String countNewBook();

    String countBorrow();
}
