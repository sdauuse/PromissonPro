package com.miao.mapper;

import com.miao.domain.Employee;
import com.miao.domain.QueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll(QueryVo queryVo);

    List<Employee> selectAllNoArg();

    int updateByPrimaryKey(Employee record);

    /*修改离职状态*/
    int updateState(Long id);

    void insertEmployeeAndRoleRel(@Param("id") Long id, @Param("rid") Long rid);

    List<Long> getRoleByEid(Long eid);

    void deleteEmployeeAndRoleRel(Long id);

    Employee getEmployeeByUsername(String username);

    List<String> getRolesById(Long id);

    List<String> getPermissionById(Long id);
}