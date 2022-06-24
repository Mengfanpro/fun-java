package net.mengfan.fun.utils;

import net.mengfan.fun.domain.MenuOption;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FUN
 * @version 1.0
 * @date 2022/6/23 10:26
 */
public class MenuOptionTree {

    // 建立父节点树形结构
    public List<MenuOption> buildTree(List<MenuOption> depts){
        ArrayList<MenuOption> Menus = new ArrayList<>();
        for (MenuOption Menu : getNodeTree(depts)) {
            getChildrenNode(depts, Menu);
            Menus.add(Menu);
        }
        return Menus;
    }

    // 查询所有的父节点，getParentMenu()=0
    private List<MenuOption> getNodeTree(List<MenuOption> depts){
        ArrayList<MenuOption> Menus = new ArrayList<>();
        for (MenuOption dept : depts) {
            if (dept.getParentMenu().equals(0)){
                Menus.add(dept);
            }
        }
        return Menus;
    }

    // 递归建立树形子节点，将子节点放到父节点下
    private MenuOption getChildrenNode(List<MenuOption> depts,MenuOption Menu){
        ArrayList<MenuOption> Menus = new ArrayList<>();
        for (MenuOption dept : depts) {
            if (dept.getParentMenu().equals(Menu.getValue())){
                Menus.add(getChildrenNode(depts,dept));
            }
        }
        Menu.setChildren(Menus);
        return Menu;
    }
}
