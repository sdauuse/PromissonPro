package com.miao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.miao.domain.PageListRes;
import com.miao.domain.QueryVo;
import com.miao.domain.Role;
import com.miao.mapper.RoleMapper;
import com.miao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/14 - 14:29
 * @commet:
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageListRes findRoles(QueryVo queryVo) {
        Page<Object> page = PageHelper.startPage(queryVo.getPage(),queryVo.getRows());
        List<Role> roles = roleMapper.selectAll();
        /*封装成PageListRes*/
        PageListRes pageListRes = new PageListRes();
        pageListRes.setRows(roles);
        pageListRes.setTotal(page.getTotal());
        return pageListRes;
    }
}
