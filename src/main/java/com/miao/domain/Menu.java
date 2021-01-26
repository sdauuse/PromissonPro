package com.miao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Menu {
    private Long id;

    private String text;

    private String url;

    private Menu parent;

    private Permission permission;

    private List<Menu> children = new ArrayList<>();
}