package com.miao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role {
    private Long rid;

    private String rnum;

    private String rname;

    private List<Permission> permissions = new ArrayList<>();

}