package com.miao.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    private Long id;

    private String username;

    /*输入的json格式化，GMT+8国际标准时间东8区*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    /*传输来的时间格式化*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputtime;

    private String tel;

    private String email;

    private Boolean state;

    private Boolean admin;

    private Department department;

    private String password;

    private List<Role> roles = new ArrayList<>();
}