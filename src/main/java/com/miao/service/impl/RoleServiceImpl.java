package com.miao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.miao.domain.PageListRes;
import com.miao.domain.Permission;
import com.miao.domain.QueryVo;
import com.miao.domain.Role;
import com.miao.mapper.RoleMapper;
import com.miao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/14 - 14:29
 * @commet:
 */
@Transactional
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageListRes findRoles(QueryVo queryVo) {
        Page<Object> page = PageHelper.startPage(queryVo.getPage(), queryVo.getRows());
        List<Role> roles = roleMapper.selectAll();
        /*封装成PageListRes*/
        PageListRes pageListRes = new PageListRes();
        pageListRes.setRows(roles);
        pageListRes.setTotal(page.getTotal());
        return pageListRes;
    }

    @Override
    public List<Role> findRoles() {
        return roleMapper.selectAll();
    }

    @Override
    public void saveRole(Role role) {
        roleMapper.insert(role);
        for (Permission permission : role.getPermissions()) {
            roleMapper.insertRoleAndPermissionRel(role.getRid(), permission.getPid());
        }
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateByPrimaryKey(role);

        roleMapper.deleteRoleAndPermissionRel(role.getRid());
        for (Permission permission : role.getPermissions()) {
            roleMapper.insertRoleAndPermissionRel(role.getRid(), permission.getPid());
        }
    }

    @Override
    public void deleteRole(Role role) {
        roleMapper.deleteRoleAndPermissionRel(role.getRid());
        roleMapper.deleteByPrimaryKey(role.getRid());
    }
}