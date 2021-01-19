package com.miao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.miao.domain.Employee;
import com.miao.domain.PageListRes;
import com.miao.domain.QueryVo;
import com.miao.domain.Role;
import com.miao.mapper.EmployeeMapper;
import com.miao.service.EmployeeService;
import org.apache.shiro.crypto.hash.Md5Hash;
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
        /*给用户密码用md5加密，参数依次是密码，加盐，散列几次*/
        Md5Hash md5Hash = new Md5Hash(employee.getPassword(), employee.getUsername(), 2);
        employee.setPassword(md5Hash.toString());

        int i = employeeMapper.insert(employee);

        for (Role role : employee.getRoles()) {

            employeeMapper.insertEmployeeAndRoleRel(employee.getId(), role.getRid());
        }

        return i;
    }

    @Override
    public int updateEmployee(Employee employee) {
        Employee oldEmployee = employeeMapper.selectByPrimaryKey(employee.getId());
        employee.setPassword(oldEmployee.getPassword());


        employeeMapper.deleteEmployeeAndRoleRel(employee.getId());
        int i = employeeMapper.updateByPrimaryKey(employee);
        for (Role role : employee.getRoles()) {
            employeeMapper.insertEmployeeAndRoleRel(employee.getId(), role.getRid());
        }
        return i;
    }

    @Override
    public int updateState(Long id) {
        return employeeMapper.updateState(id);
    }

    @Override
    public List<Long> getRoleByEid(Long eid) {
        return employeeMapper.getRoleByEid(eid);
    }

    @Override
    public Employee getEmployeeByUsername(String username) {
        return employeeMapper.getEmployeeByUsername(username);
    }

    @Override
    public List<String> getRolesById(Long id) {
        return employeeMapper.getRolesById(id);
    }

    @Override
    public List<String> getPermissionById(Long id) {
        return employeeMapper.getPermissionById(id);
    }


}
