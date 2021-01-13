package com.miao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.miao.domain.Employee;
import com.miao.domain.PageListRes;
import com.miao.mapper.EmployeeMapper;
import com.miao.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/13 - 15:30
 * @commet:
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public PageListRes findEmployees() {
        Page<Object> page = PageHelper.startPage(1, 5);

        List<Employee> employees = employeeMapper.selectAll();

        PageListRes pageListRes = new PageListRes();
        pageListRes.setTotal(page.getTotal());
        pageListRes.setRows(employees);

        return pageListRes;
    }

    @Override
    public int saveEmployee(Employee employee) {
        return employeeMapper.insert(employee);
    }
}
