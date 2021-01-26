package com.miao.service;

import com.miao.domain.Employee;
import com.miao.domain.PageListRes;
import com.miao.domain.QueryVo;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/13 - 15:29
 * @commet:
 */
public interface EmployeeService {

    public PageListRes findEmployees(QueryVo queryVo);

    public PageListRes findEmployees();

    public int saveEmployee(Employee employee);

    public int updateEmployee(Employee employee);

    public int updateState(Long id);

    List<Long> getRoleByEid(Long eid);

    Employee getEmployeeByUsername(String username);

    List<String> getRolesById(Long id);

    List<String> getPermissionById(Long id);
}
