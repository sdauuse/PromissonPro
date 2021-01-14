package com.miao.service;

import com.miao.domain.PageListRes;
import com.miao.domain.QueryVo;

/**
 * @author miaoyin
 * @date 2021/1/14 - 14:28
 * @commet:
 */
public interface RoleService {
    public PageListRes findRoles(QueryVo queryVo);
}
