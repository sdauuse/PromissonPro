package com.miao.web.controlle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author miaoyin
 * @date 2021/1/13 - 13:59
 * @commet:
 */
@Controller
public class RoleController {
    @RequestMapping("/role")
    public String role(){

        return "role";
    }
}
