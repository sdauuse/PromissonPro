package com.miao.service;

import com.miao.domain.AjaxRes;
import com.miao.domain.Menu;
import com.miao.domain.PageListRes;
import com.miao.domain.QueryVo;

import java.util.List;

/**
 * @author miaoyin
 * @date 2021/1/19 - 17:04
 * @commet:
 */
public interface MenuService {

    public List<Menu> parentList() ;


    public PageListRes findMenuList(QueryVo queryVo);

    void saveMenu(Menu menu);

    AjaxRes updateMenu(Menu menu);

    AjaxRes deleteMenu(Long id);

    List<Menu> getTreeData();
}
