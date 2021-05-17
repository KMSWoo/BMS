package com.kmswoo.bms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//借书表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {
    private Integer id;
    private Integer uid;
    private Integer bid;
}
