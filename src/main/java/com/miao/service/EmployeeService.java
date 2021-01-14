package com.miao.service;

import com.miao.domain.Employee;
import com.miao.domain.PageListRes;
import com.miao.domain.QueryVo;

/**
 * @author miaoyin
 * @date 2021/1/13 - 15:29
 * @commet:
 */
public interface EmployeeService {

    public PageListRes findEmployees(QueryVo queryVo);

    public int saveEmployee(Employee employee);

    public int updateEmployee(Employee employee);

    public int updateState(Long id);
}
