package com.miao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/13 - 15:24
 * @commet:
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class PageListRes {
    private Long total;
    private List<?> rows = new ArrayList<>();
}
