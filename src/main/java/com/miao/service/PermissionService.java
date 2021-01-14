package com.miao.service;

import com.miao.domain.Permission;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/14 - 15:18
 * @commet:
 */
public interface PermissionService {

    public List<Permission> findPermissions();

    public List<Permission> findPermissionByRid(Long rid);
}
