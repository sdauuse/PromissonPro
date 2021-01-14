package com.miao.service;

import com.miao.domain.PageListRes;
import com.miao.domain.QueryVo;
import com.miao.domain.Role;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/14 - 14:28
 * @commet:
 */
public interface RoleService {
    public PageListRes findRoles(QueryVo queryVo);

    public List<Role> findRoles();

    public void saveRole(Role role);

    public void updateRole(Role role);

    void deleteRole(Role role);
}
