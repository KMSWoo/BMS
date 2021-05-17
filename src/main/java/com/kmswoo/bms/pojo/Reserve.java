package com.kmswoo.bms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//预定表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserve {
    private Integer id;
    private Integer bid;
    private Integer uid;
}
