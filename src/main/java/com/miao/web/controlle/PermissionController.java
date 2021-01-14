package com.miao.web.controlle;

import com.miao.domain.Permission;
import com.miao.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/14 - 15:16
 * @commet:
 */
@Controller
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/permissionList")
    @ResponseBody
    public List<Permission> permissionList(){

        return permissionService.findPermissions();
    }

    @RequestMapping("/findPermissionByRid")
    @ResponseBody
    public List<Permission> findPermissionByRid(Long rid){

        return permissionService.findPermissionByRid(rid);
    }
}
