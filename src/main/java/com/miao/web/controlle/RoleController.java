package com.miao.web.controlle;

import com.miao.domain.PageListRes;
import com.miao.domain.QueryVo;
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
    public String role(){

        return "role";
    }

    @RequestMapping("/roleList")
    @ResponseBody
    public PageListRes roleList(QueryVo queryVo){
        PageListRes roles = roleService.findRoles(queryVo);
        return roles;
    }
}
