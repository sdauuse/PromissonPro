package com.miao.service.impl;

import com.miao.domain.Department;
import com.miao.mapper.DepartmentMapper;
import com.miao.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/13 - 16:54
 * @commet:
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> findDepartments() {

        List<Department> departments = departmentMapper.selectAll();

        return departments;
    }
}
