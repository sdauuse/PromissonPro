package com.miao.mapper;

import com.miao.domain.Employee;
import com.miao.domain.QueryVo;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll(QueryVo queryVo);

    int updateByPrimaryKey(Employee record);

    /*修改离职状态*/
    int updateState(Long id);
}