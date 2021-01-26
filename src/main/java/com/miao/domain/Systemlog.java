package com.miao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Systemlog {
    private Long id;

    private Date optime;

    private String ip;

    private String function;

    private String params;

}