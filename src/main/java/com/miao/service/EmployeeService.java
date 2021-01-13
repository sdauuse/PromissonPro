package com.miao.service;

import com.miao.domain.Employee;
import com.miao.domain.PageListRes;

/**
 * @author miaoyin
 * @date 2021/1/13 - 15:29
 * @commet:
 */
public interface EmployeeService {

    public PageListRes findEmployees();

    public int saveEmployee(Employee employee);
}
