package com.miao.mapper;

import com.miao.domain.QueryVo;
import com.miao.domain.Role;
import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long rid);

    int insert(Role record);

    Role selectByPrimaryKey(Long rid);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);
}