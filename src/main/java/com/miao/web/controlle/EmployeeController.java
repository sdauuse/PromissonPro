package com.miao.web.controlle;

import com.miao.domain.AjaxRes;
import com.miao.domain.Employee;
import com.miao.domain.PageListRes;
import com.miao.domain.QueryVo;
import com.miao.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public PageListRes employeeList(QueryVo queryVo) {
        PageListRes pageListRes = employeeService.findEmployees(queryVo);
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
        } catch (Exception e) {
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("保存失败");
        }

        return ajaxRes;
    }

    @RequestMapping("updateEmployee")
    @ResponseBody
    public AjaxRes updateEmployee(Employee employee) {

        AjaxRes ajaxRes = new AjaxRes();
        try {
            employeeService.updateEmployee(employee);
            ajaxRes.setSuccess(true);
            ajaxRes.setMsg("修改成功");
        } catch (Exception e) {
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("修改失败");
        }

        return ajaxRes;
    }

    @RequestMapping("/updateState")
    @ResponseBody
    public AjaxRes updateState(Long id) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            employeeService.updateState(id);
            ajaxRes.setSuccess(true);
            ajaxRes.setMsg("修改成功");
        } catch (Exception e) {
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("修改失败");
        }

        return ajaxRes;
    }

    @RequestMapping("/getRoleByEid")
    @ResponseBody
    public List<Long> getRoleByEid(Long id) {
        List<Long> longs = employeeService.getRoleByEid(id);
        return longs;
    }
}
