package com.miao.web.controlle;

import com.miao.domain.AjaxRes;
import com.miao.domain.PageListRes;
import com.miao.domain.QueryVo;
import com.miao.domain.Role;
import com.miao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author miaoyin
 * @date 2021/1/13 - 13:59
 * @commet:
 */
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/role")
    public String role() {

        return "role";
    }

    @RequestMapping("/roleList")
    @ResponseBody
    public PageListRes roleList(QueryVo queryVo) {
        PageListRes roles = roleService.findRoles(queryVo);
        return roles;
    }

    @RequestMapping("/saveRole")
    @ResponseBody
    public AjaxRes saveRole(Role role) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            roleService.saveRole(role);
            ajaxRes.setSuccess(true);
            ajaxRes.setMsg("成功添加角色");
        } catch (Exception e) {
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("添加角色失败");
        }
        return ajaxRes;
    }

    @RequestMapping("/updateRole")
    @ResponseBody
    public AjaxRes updateRole(Role role) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            roleService.updateRole(role);
            ajaxRes.setSuccess(true);
            ajaxRes.setMsg("成功修改角色");
        } catch (Exception e) {
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("修改角色失败");
        }

        return ajaxRes;
    }
}
