package com.miao.web.controlle;

import com.miao.domain.Department;
import com.miao.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/13 - 16:48
 * @commet:
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/departList")
    @ResponseBody
    public List<Department> departList(){
        List<Department> departments = departmentService.findDepartments();
        return departments;
    }
}
