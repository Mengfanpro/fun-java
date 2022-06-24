package net.mengfan.fun.utils;

import net.mengfan.fun.domain.Menu;
import java.util.ArrayList;
import java.util.List;

/**
 * @author FUN
 * @version 1.0
 * @description: 菜单数据递归树状结构
 * @date 2022/6/24 8:48
 */
public class MenuTree {

    // 建立父节点树形结构
    public List<Menu> buildTree(List<Menu> depts) {
        ArrayList<Menu> Menus = new ArrayList<>();
        for (Menu Menu : getNodeTree(depts)) {
            getChildrenNode(depts, Menu);
            Menus.add(Menu);
        }
        return Menus;
    }

    // 查询所有的父节点，getParentMenu()=0
    private List<Menu> getNodeTree(List<Menu> depts) {
        ArrayList<Menu> Menus = new ArrayList<>();
        for (Menu dept : depts) {
            if (dept.getParentMenu().equals(0)) {
                Menus.add(dept);
            }
        }
        return Menus;
    }

    // 递归建立树形子节点，将子节点放到父节点下
    private Menu getChildrenNode(List<Menu> depts, Menu Menu) {
        ArrayList<Menu> Menus = new ArrayList<>();
        for (Menu dept : depts) {
            if (dept.getParentMenu().equals(Menu.getMenuId())) {
                Menus.add(getChildrenNode(depts, dept));
            }
        }
        Menu.setChildrenList(Menus);
        return Menu;
    }
}
