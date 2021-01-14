package com.miao.service.impl;

import com.miao.domain.Permission;
import com.miao.mapper.PermissionMapper;
import com.miao.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/14 - 15:18
 * @commet:
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findPermissions() {
        return permissionMapper.selectAll();
    }

    @Override
    public List<Permission> findPermissionByRid(Long rid) {
        return permissionMapper.findPermissionByRid(rid);
    }
}
