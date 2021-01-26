package com.miao.web.controlle;

import com.miao.domain.AjaxRes;
import com.miao.domain.Menu;
import com.miao.domain.PageListRes;
import com.miao.domain.QueryVo;
import com.miao.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/13 - 13:58
 * @commet:
 */
@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;
    @RequestMapping("/menu")
    public String menu(){

        return "menu";
    }

    @RequestMapping("/menuList")
    @ResponseBody
    public PageListRes menuList(QueryVo queryVo){

        return menuService.findMenuList(queryVo);
    }

    /*查询出所有父菜单*/
    @RequestMapping("/parentList")
    @ResponseBody
    public List<Menu> parentList(){
        List<Menu> menus = menuService.parentList();
        return menus;
    }
    /*保存菜单*/
    @RequestMapping("/saveMenu")
    @ResponseBody
    public AjaxRes saveMenu(Menu menu){
        AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用业务层,保存菜单*/
            menuService.saveMenu(menu);
            ajaxRes.setMsg("保存成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("保存失败");
            System.out.println(e);
        }
        return ajaxRes;
    }

    @RequestMapping("/updateMenu")
    @ResponseBody
    public AjaxRes updateMenu(Menu menu){

        return menuService.updateMenu(menu);
    }

    @RequestMapping("/deleteMenu")
    @ResponseBody
    public AjaxRes deleteMenu(Long id){

        return menuService.deleteMenu(id);
    }

    @RequestMapping("/getTreeData")
    @ResponseBody
    public List<Menu> getTreeData(){

        return menuService.getTreeData();
    }
}
