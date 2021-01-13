package com.miao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author miaoyin
 * @date 2021/1/13 - 20:34
 * @commet:
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AjaxRes {
    private boolean success;
    private String msg;
}
