package com.miao.web.controlle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author miaoyin
 * @date 2021/1/19 - 12:13
 * @commet:
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "redirect:/login.jsp";
    }
}
