package com.shl.onetest.mapper;

import com.shl.onetest.domain.Menu;
import com.shl.onetest.entity.Tree;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:songhongli
 * @Created: 2018/7/14
 */
@Repository
public interface MenuMapper {
    List<Menu> findUserPermissions(String userName);

    List<Menu> findUserMenus(String userName);

    // 删除父节点，子节点变成顶级节点（根据实际业务调整）
    void changeToTop(List<String> menuIds);


    List<Menu> findAllMenus(Menu menu);

    Tree<Menu> getMenuButtonTree();

    Tree<Menu> getMenuTree();

    Tree<Menu> getUserMenu(String userName);

    Menu findById(Long menuId);

    Menu findByNameAndType(String menuName, String type);

    void addMenu(Menu menu);

    void updateMenu(Menu menu);

    void deleteMeuns(String menuIds);
}
