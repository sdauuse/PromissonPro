package com.miao.web.controlle;

import com.miao.domain.AjaxRes;
import com.miao.domain.Employee;
import com.miao.domain.PageListRes;
import com.miao.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author miaoyin
 * @date 2021/1/13 - 13:55
 * @commet:
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employee")
    public String employee() {

        return "employee";
    }

    @RequestMapping("/employeeList")
    @ResponseBody
    public PageListRes employeeList() {
        PageListRes pageListRes = employeeService.findEmployees();
        return pageListRes;
    }

    /*接受员工添加的表单*/
    @RequestMapping("/saveEmployee")
    @ResponseBody
    public AjaxRes saveEmployee(Employee employee) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            employee.setState(true);
            employeeService.saveEmployee(employee);
            ajaxRes.setSuccess(true);
            ajaxRes.setMsg("保存成功");
        }catch (Exception e){
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("保存失败");
        }

        return ajaxRes;
    }
}
