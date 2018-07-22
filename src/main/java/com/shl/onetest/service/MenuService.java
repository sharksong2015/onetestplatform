package com.shl.onetest.service;

import com.shl.onetest.domain.Menu;
import com.shl.onetest.entity.Tree;
import com.shl.onetest.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:songhongli
 * @Created: 2018/7/14
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    List<Menu> findUserPermissions(String userName){
        return null;
    }

    public List<Menu> findUserMenus(String userName){
        return null;
    }

    // 删除父节点，子节点变成顶级节点（根据实际业务调整）
    void changeToTop(List<String> menuIds){

    }


    List<Menu> findAllMenus(Menu menu){
        return null;
    }

    Tree<Menu> getMenuButtonTree(){
        return null;
    }

    Tree<Menu> getMenuTree(){
        return null;
    }

    public Tree<Menu> getUserMenu(String userName){
        return null;
    }

    Menu findById(Long menuId){
        return null;
    }

    Menu findByNameAndType(String menuName, String type){
        return null;
    }

    void addMenu(Menu menu){

    }

    void updateMenu(Menu menu){

    }

    void deleteMeuns(String menuIds){

    }
}
