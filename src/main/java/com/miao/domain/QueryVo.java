package com.miao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author miaoyin
 * @date 2021/1/14 - 13:18
 * @commet:
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QueryVo {
    private int page;
    private int rows;
    private String keyword;
}
