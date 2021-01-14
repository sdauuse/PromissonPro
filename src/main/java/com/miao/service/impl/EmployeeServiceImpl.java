package com.miao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.miao.domain.Employee;
import com.miao.domain.PageListRes;
import com.miao.domain.QueryVo;
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
    public PageListRes findEmployees(QueryVo queryVo) {
        Page<Object> page = PageHelper.startPage(queryVo.getPage(), queryVo.getRows());

        List<Employee> employees = employeeMapper.selectAll(queryVo);

        PageListRes pageListRes = new PageListRes();
        pageListRes.setTotal(page.getTotal());
        pageListRes.setRows(employees);

        return pageListRes;
    }

    @Override
    public int saveEmployee(Employee employee) {
        return employeeMapper.insert(employee);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public int updateState(Long id) {
        return employeeMapper.updateState(id);
    }


}
